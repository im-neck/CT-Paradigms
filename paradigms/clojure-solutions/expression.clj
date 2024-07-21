(defn operation [f]
  (fn [& args]
    (fn [vars]
      (apply f (map #(% vars) args)))))

(defn div
  ([x] (/ 1 (double x)))
  ([x y] (/ (double x) (double y)))
  ([x y & more]
   (apply div (/ (double x) (double y)) more)))

(def divide (operation div))
(def add (operation +))
(def subtract (operation -))
(def multiply (operation *))
(def negate (operation -))
(def constant constantly)
(defn variable [name]
  (fn [operands]
    (operands name)))



(def cosh (operation #(Math/cosh %)))
(def sinh (operation #(Math/sinh %)))

;38-39(24)
(def arithMean (operation (fn [& args] (/ (apply + args) (count args)))))
(def geomMean (operation (fn [& args] (Math/pow (abs (apply * args)) (div 1 (count args))))))
(def harmMean (operation (fn [& args] (div (count args) (apply + (map #(div %) args))))))


(def mapOp {'+      add
            '-      subtract
            '*      multiply
            '/      divide
            'negate negate
            'cosh   cosh
            'sinh   sinh
            })


;======================================================================================================================
(definterface Expression
  (^Number evaluate [vars])
  (^String toString []))

(deftype binAbstOp [sign op arg1 arg2]
  Expression
  (evaluate [this vars] (op (.evaluate arg1 vars) (.evaluate arg2 vars)))
  (toString [this] (str "(" sign " " (.toString arg1) " " (.toString arg2) ")"))
  )
(deftype unAbstOp [sign op arg]
  Expression
  (evaluate [this vars] (op (.evaluate arg vars)))
  (toString [this] (str "(" sign " " (.toString arg) ")"))
  )

(defn argumentsB [a, b]
      (fn [x, y]
          (binAbstOp. a b x y)))
(defn argumentsU [a, b]
      (fn [x]
          (unAbstOp. a b x)))
; :NOTE: очень длинно, можно через функцию делать короче
(def Add (argumentsB  '+ +))
(def Subtract (argumentsB  '- -))
(def Multiply (argumentsB  '* *))
(def Divide (argumentsB  '/ div))
(def Pow (argumentsB  'pow (fn [x y] (Math/pow x y))))
(def Log (argumentsB  'log (fn [x y] (/ (Math/log (Math/abs y)) (Math/log(Math/abs x)))) ))


(def Negate (argumentsU 'negate -))
(def Sinh  (argumentsU 'sinh #(Math/sinh %)))
(def Cosh (argumentsU 'cosh #(Math/cosh %) ))


(defn evaluate [args vars] (.evaluate args vars))
(defn toString [str] (.toString str))

(deftype Co [x]
  Expression
  (evaluate [this vars] x)
  (toString [this] (str x))
  )
(deftype Va [x]
  Expression
  (evaluate [this vars] (get vars x))
  (toString [this] x)
  )
(defn Constant [x] (Co. x))
(defn Variable [x] (Va. x))


(def mapOpObj {'+      Add
               '-      Subtract
               '*      Multiply
               '/      Divide
               'negate Negate
               'cosh   Cosh
               'sinh   Sinh
               'pow Pow
               'log Log
               })
; :NOTE: унифицировать с parse

 (defn parse [mapOp cons varb expression]
  (cond
     (number? expression) (cons expression)
     (symbol? expression) (varb (str expression))
     :else (apply (mapOp (first expression)) (mapv #(parse mapOp cons varb %) (rest expression)))
     )
   )


(defn parseObject [expression]
  (parse mapOpObj Constant Variable (read-string expression)))

(defn parseFunction [expression]
  (parse  mapOp constant variable (read-string expression) ))