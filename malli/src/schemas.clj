(ns schemas
  (:require [malli.core :as m]
            [malli.json-schema :as json-schema]
            [malli.error :as merror]
            [cheshire.core :as ch]))


(def address
  [:map {:closed true}
   [:street [:string {:min 1, :max 10}]]
   [:city string?]
   [:zip [:int {:min 0 :max 1000}]]])

(-> address (m/explain {:street "AA" :city "Barcelona" :zip 1001}) (merror/humanize))

(-> address 
    (json-schema/transform) 
    (ch/generate-string {:pretty true}) 
    println)