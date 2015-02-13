(defproject clojure-markov-bot-tutorial "0.1.0-SNAPSHOT"
  :description "A tutorial for writing a basic Markov bot in Twitter."
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]]
  :plugins [[lein-gorilla "0.3.4"]]
  :main ^:skip-aot clojure-markov-bot-tutorial.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})