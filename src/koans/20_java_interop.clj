(ns koans.20-java-interop
  (:require [koan-engine.core :refer :all]))

(defn exp [x n]
    (reduce * (repeat n x)))

(meditations
  "You may have done more with Java than you know"
  (= (class (String. "warfare")) (class "warfare")) ; hint: try typing (javadoc "warfare") in the REPL

  "The dot signifies easy and direct Java interoperation"
  (= (clojure.string/upper-case "select * from") (.toUpperCase "select * from"))

  "But instance method calls are very different from normal functions"
  (= ["SELECT" "FROM" "WHERE"] (map clojure.string/upper-case ["select" "from" "where"]))

  "Constructing might be harder than breaking"
  (= 10 (let [latch (java.util.concurrent.CountDownLatch. 10)]
          (.getCount latch)))

  "Static methods are slashing prices!"
  (== (exp 2 10) (Math/pow 2 10)))
