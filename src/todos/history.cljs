(ns todos.history
  ;; FIXME -- need a (chan) to make this work
  ;; (:require [reagent.core :as reagent :refer [atom]])
  )

(enable-console-print!)

(def history (atom {:position 0 :list (list)}))
(def capacity 50)

(defn more-history [history]
  (let [pos (:position history) size (-> history :list count)]
    (comment println (str "peek " (inc pos) " < " size))
    (< (inc pos) size)))

(defn trim-history [h]
  (let [position (:position h)
        hlist (:list h)
        n (count hlist)]
    (when (> n 0)
      (comment println (str "history: " n " todos: " (count (nth hlist position)))))
    (cond
     (and (< n capacity) (= 0 position))
     h
     (= 0 position)
     {:position 0 :list (take capacity hlist) }
     :else
     {:position 0 :list (drop position hlist) } )))

(defn add-history [todos]
  (swap! history
         (fn [h]
           (let [trimh (trim-history h)
                 hlist (:list trimh)]
           (assoc trimh :list (cons todos hlist))))))

(defn bkwd-history [todos]
  (if (more-history @history)
    (let [newpos (inc (:position @history))]
      (do
        (swap! history assoc :position newpos)
        (nth (:list @history) newpos)))
    todos))

(defn fwd-history [todos]
  (let [newpos (dec (:position @history))]
    (if (< -1 newpos)
      (do
        (swap! history assoc :position newpos)
        (nth (:list @history) newpos))
      todos)))

