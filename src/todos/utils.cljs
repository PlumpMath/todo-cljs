(ns todos.utils
  (:require [goog.dom :as dom]
            [goog.events :as events]
            [cljs.core.async :as async])
  (:import [goog.net Jsonp]
           [goog.net XhrIo]
           [goog Uri]))

  ;; (.log js/console (dom/getElement "query"))

;; misc handlers

(defn listen [el type]
  (let [out (async/chan)
        f (fn [e] (async/put! out e))]
    (events/listen el type f)
    out))

(defn json-with-pad "Async call using channel"
  [uri]
  (let [out (async/chan)
        req (new Jsonp (new Uri uri))]
    (.send req nil
           (fn [res] (async/put! out res)))
    out))

(def timeout-ms-post 2000)
(def timeout-ms-get 2000)

(defn ajax-json
  ([url method content]
      (ajax-json url method {"Accept" "application/json"} content timeout-ms-get))
  ([url method headers content timeoutms]
     (let [out (async/chan)
           callback (fn [reply] "callback - TODO bug in server, would return xml here if ..." 
                      (let [j (.getResponseJson (.-target reply))]
                        (async/put! out j)))]
       (.send XhrIo url
              callback method content headers timeoutms)
       out)))

