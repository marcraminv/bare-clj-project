(ns app-2)



(defrecord Human [name])

(defprotocol Display
  (say-my-name [this]))

(extend-protocol Display
  Human
  (say-my-name [this] (str "my name is " (:name this))))

(def me (->Human "Marc"))
(say-my-name me)

(defn -my-private-fn
  [n]
  n)
(def ^:private my-private-variable 1)