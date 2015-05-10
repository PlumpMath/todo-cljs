(defproject todomvc-async "0.1.0-SNAPSHOT"

  :description "Redo todo mvc example w/o react/reagent"

  :url "todo-async"
  
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2311"]
                 [org.clojure/core.async "0.1.346.0-17112a-alpha"]
                 ;; ClojureScript port of Hiccup - a fast rendering HTML in cljs
                 ;; https://github.com/teropa/hiccups
                 [hiccups "0.3.0"]
                 ]
  
  :plugins [[lein-cljsbuild "1.0.5"]]

  :hooks [leiningen.cljsbuild]
  
  :profiles {:prod {:cljsbuild
                    {:builds
                     {:client {:compiler
                               {:optimizations :advanced
                                :preamble ^:replace ["reagent/react.min.js"]
                                :pretty-print false}}}}}
             :srcmap {:cljsbuild
                      {:builds
                       {:client {:compiler
                                 {:source-map "target/client.js.map"
                                  :source-map-path "client"}}}}}}

  :source-paths ["src"]
  
  :cljsbuild
  {:builds
   {:client {:source-paths ["src"]
             :compiler {:output-dir "out"
                        :output-to "todo_async.js"
                        :optimizations :none
                        :source-map true
                        :pretty-print true}}}})
