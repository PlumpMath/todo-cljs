(ns todomvc.palin
  (:require [clojure.string :refer [replace]]))

;; ajazzhasaracecarz
;; aracehasaracecarz

(defn log [& msg]
  (if false
    (println (apply str msg))))

(defn is-palin "no param vers for test"
  ([in]
     (is-palin in 0 (count in)))
  ([in s size]
      (loop [fpos s bpos (+ s size -1)]
        (let [front (.charAt in fpos)
              back (.charAt in bpos)]
          (log front ":" back)
          (if (> fpos bpos)
            true
            (if (= front back)
              (recur (inc fpos) (dec bpos))
              false)))))
  )

;; in-progress
(defn find-of-size "Check substr of size working bkwds"
  [in len size]
  (loop [s (- len size)]
    (log "work bkwds: len size s start = " len ":" size ":" s ":" (+ s size))
    (if (< s 0)
      nil
      (if (is-palin in s size)
        (.substring in s (+ s size))
        (recur (dec s))))))

(defn find-biggest [in]
  (let [in (replace in #"[\s\.\,\:\;]" "")
        len (count in)]
    (loop [size len]
      (let [find (find-of-size in len size)]
        (log "find: " find)        
        (if (or (> 3 size) (not (nil? find)))
          find
          (recur (dec size)))))))

(defn find-all [in]
  ;; ["racecar"]
  ;;nil
  (let [start (js/Date.)
        palin (find-biggest in)
        finish (js/Date.)
        out (println "find-biggest in: " (- finish start))]
    (if (nil? palin)
      nil
      [palin]))
  )

