# Minimum Clojure Project

```
simple-project/
├─ src/
│  ├─ app.clj
├─ deps.edn
```

## Minimum `deps.edn` definition

```clj
{}
```

## Main program

The file `app.clj`:

```clj
(ns app)

(defn -main
  "Say your first 'Hello World'."
  [& args]
  (println "Hello, World!"))
```

## Run main program

```
clj -M --main app-1
```

## More on `deps.edn`

Add clojure version dependency & define `src` path

```clj
{:deps {org.clojure/clojure {:mvn/version "1.11.1"}}
 :paths ["src"]
 :aliases {}
}
```

## Run main program using `-M[Aliases]`

Replace the `:aliases` key on `deps.edn` by this:

```
:aliases {:app/run {:main-opts ["-m" "app"]}}
```

Then, run your program:

```
clj -M:app/run
```

## Testing app code

Project structure will look like this:

```
simple-project/
├─ src/
│  ├─ app.clj
├─ test/
│  ├─ app-test.clj
deps.edn
tests.edn
```

### Create your first test

Inside your `app.clj` define the `identity-number` defn:

```clj
(ns app)

(defn identity-number
  [n]
  n)
```

Inside the `app-test.clj` create your first test:

```clj
(ns app-test
  (:require [clojure.test :refer [deftest is testing]]
            [app]))

(deftest identity-number-test
      (testing "Context of the test assertions"
        (is (= (app/identity-number 2) 2)))) 
```

## `deps.edn` for testing using `kaocha`

```clj
{:deps {org.clojure/clojure {:mvn/version "1.11.1"}}
 :paths ["src"]
 :aliases
 {:test {:extra-deps {lambdaisland/kaocha {:mvn/version "1.77.1236"}}}}}
 ```

Create a file named `tests.edn` on the root project with the content

```clj
#kaocha/v1 
{}
```

## Run your first test

```
clojure -A:test -M -m kaocha.runner --config-file tests.edn "$@"
```