(ns app-1-test
  (:require [clojure.test :refer [deftest is testing]]
            ;; [clojure.test.check :as tc]
            ;; [clojure.test.check.generators :as gen]
            ;; [clojure.test.check.properties :as prop]
            [app-1]))


(deftest identity-number-test
  (testing "Context of the test assertions"
    (is (= (app-1/identity-number 2) 2))))

