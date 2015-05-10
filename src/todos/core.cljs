(ns todos.core
  (:require-macros [cljs.core.async.macros :refer [go]]
                   [hiccups.core :as hiccups])
  (:require [goog.dom :as dom]
            [goog.events :as events]
            [cljs.core.async :refer [put! chan <!]]
            [clojure.string :refer [lower-case]]
            [hiccups.runtime :as hiccupsrt]
            [todos.utils :as utils]
            [todos.history :as hx :refer [history capacity]])
  (:import [goog.net Jsonp]
           [goog.net XhrIo]
           [goog Uri]))

(enable-console-print!)
(println "Hello.")
;; (.log js/console (dom/getElement "query"))

(def todos (atom (sorted-map)))
(def counter (atom 0))
;;(def history (atom {:position 0 :list (list @todos)}))
(swap! history assoc :list (list @todos))
;;
;; FIXME:
(def app-state {:todos todos :counter counter :history history})


(defn add-todo [text]
  (let [id (swap! counter inc)]
    (hx/add-history (swap! todos assoc id {:id id :title text :done false}))))
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

(def todo-edit
  ;; FIXME
  ;; (with-meta todo-input {:component-did-mount #(.focus
  ;; (reagent/dom-node%))})
  nil
  )

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
           
           ;; [todo-input {:id "new-todo"
           (todo-input {:id "new-todo"
                          :placeholder "What needs to be done?"
                        :on-save add-todo})
           ;; ]
           
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
                  ^{:key (:id todo)}                  
                  ;; [todo-item todo]
                  (let [item-fn (todo-item)]
                    (item-fn todo)))]
               [:footer#footer
                ;; [todo-stats
                (todo-stats               
                 {:active active :done done :filt filt})
                ]]])]]
           [:footer#info
            [:p "Double-click to edit a todo"]]]))))

;; setup
(defn init [] "initialize dynamic page data"
  ;; dynamic html
  (let [body-el (dom/getElement "content")
        content-fn (todo-app app-state)
        content (content-fn)] 
    (aset body-el "innerHTML" (hiccups/html content))))

(comment
  ;;   (defn ^:export run [] (reagent/render-component [todo-app]
  (.-body js/document))

;; RUN...
(init)
