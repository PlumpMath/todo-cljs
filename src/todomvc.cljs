(ns todomvc
  (:require [reagent.core :as reagent :refer [atom]]
            [todomvc.history :as hx :refer [history capacity]]
            [todomvc.magic :as magic]))

(enable-console-print!)

(def todos (atom (sorted-map)))

(def state {:counter (atom 0) :titles #{} })

;;(def history (atom {:position 0 :list (list @todos)}))

(swap! history assoc :list (list @todos))

(defn add-todo [text]
  (if (contains? (:titles state) text)
    (println (str "dupe:" text))    
    (let [titles (magic/expand text)
          local (atom nil)]
     (doseq [title titles]
       (let [id (swap! (:counter state) inc)]
         (reset! local
                (swap! todos assoc id {:id id :title title :done false}))))
     (hx/add-history @local))))

(defn toggle [id]
  (hx/add-history (swap! todos update-in [id :done] not)))
(defn save [id title]
  (hx/add-history (swap! todos assoc-in [id :title] title)))
(defn delete [id]
  (hx/add-history (swap! todos dissoc id)))

(defn mmap [m f a] (->> m (f a) (into (empty m))))
(defn complete-all [v]
  (hx/add-history (swap! todos mmap map #(assoc-in % [1 :done] v))))
(defn clear-done []
  (hx/add-history (swap! todos mmap remove #(get-in % [1 :done]))))
(defn undo []
  (swap! todos hx/bkwd-history))
(defn redo []
  (swap! todos hx/fwd-history))

;; starting-state

(add-todo "Rename Cloact to Reagent")
(add-todo "Add undo demo")
(add-todo "Make all rendering async")
(add-todo "Allow any arguments to component functions")
(complete-all true)

;; behavioral views

(defn todo-input [{:keys [title on-save on-stop]}]
  (let [val (atom title)
        stop #(do (reset! val "")
                  (if on-stop (on-stop)))
        save #(let [v (-> @val str clojure.string/trim)]
                (if-not (empty? v) (on-save v))
                (stop))]
    (fn [props]
      [:input (merge props
                     {:type "text" :value @val :on-blur save
                      :on-change #(reset! val (-> % .-target .-value))
                      :on-key-up #(case (.-which %)
                                    13 (save)
                                    27 (stop)
                                    nil)})])))

(def todo-edit (with-meta todo-input
                 {:component-did-mount #(.focus (reagent/dom-node %))}))

(defn todo-stats [{:keys [filt active done]}]
  (let [props-for (fn [name]
                    {:class (if (= name @filt) "selected")
                     :on-click #(reset! filt name)})]
    [:div
     [:span#todo-count
      [:strong active] " " (case active 1 "item" "items") " left"]
     [:ul#filters
      [:li [:a (props-for :all) "All"]]
      [:li [:a (props-for :active) "Active"]]
      [:li [:a (props-for :done) "Completed"]]]
     (when (pos? done)
       [:button#clear-completed {:on-click clear-done}
        "Clear completed " done])]))

(defn todo-item []
  (let [editing (atom false)]
    (fn [{:keys [id done title]}]
      [:li {:class (str (if done "completed ")
                        (if @editing "editing"))}
       [:div.view
        [:input.toggle {:type "checkbox" :checked done
                        :on-change #(toggle id)}]
        [:label {:on-double-click #(reset! editing true)} title]
        [:button.destroy {:on-click #(delete id)}]]
       (when @editing
         [todo-edit {:class "edit" :title title
                     :on-save #(save id %)
                     :on-stop #(reset! editing false)}])])))

(defn todo-app [props]
  (let [filt (atom :all)]
    (fn []
      (let [items (vals @todos)
            done (->> items (filter :done) count)
            active (- (count items) done)]
        [:div
         [:section#todoapp
          [:header#header
           [:h1 "todos"]
           (if (and (hx/more-history @history) (-> @history :list count pos?))
             [:button#undo {:on-click #(undo)} "undo"]
             [:button#undo-off "undo"])
           (if (< 0 (:position @history))
             [:button#redo {:on-click #(redo)} "redo"]
             [:button#redo-off "redo"])
           [todo-input {:id "new-todo"
                        :placeholder "What needs to be done?"
                        :on-save add-todo}]]
          (when (-> items count pos?)
            [:div
             [:section#main
              [:input#toggle-all {:type "checkbox" :checked (zero? active)
                                  :on-change #(complete-all (pos? active))}]
              [:label {:for "toggle-all"} "Mark all as complete"]
              [:ul#todo-list
               (for [todo (filter (case @filt
                                    :active (complement :done)
                                    :done :done
                                    :all identity) items)]
                 ^{:key (:id todo)} [todo-item todo])]]
             [:footer#footer
              [todo-stats {:active active :done done :filt filt}]]])]
         [:footer#info
          [:p "Double-click to edit a todo"]]]))))

(defn ^:export run []
  (reagent/render-component [todo-app] (.-body js/document)))
