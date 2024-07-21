(defn operV [func]
  #(mapv func %1 %2))

(def v+ (operV +))
(def v- (operV -))
(def v* (operV *))
(def vd (operV /))

(defn v*s [v s]
  (mapv #(* s %) v))

(def m+ (operV v+))
(def m- (operV v-))
(def m* (operV v*))
(def md (operV vd))

(defn scalar [v1 v2]
  (apply + (v* v1 v2)))
(defn transpose [m]
  (apply mapv vector m))
(defn m*s [m s]
  (mapv #(v*s % s) m))
(defn m*v [m v]
  (mapv #(scalar % v) m))


(defn m*m [m1 m2]
  (mapv #(m*v (transpose m2) %) m1))
(defn vect [v1 v2]
  [(- (* (get v1 1) (get v2 2)) (* (get v1 2) (get v2 1))),
   (- (* (get v1 2) (get v2 0)) (* (get v1 0) (get v2 2))),
   (- (* (get v1 0) (get v2 1)) (* (get v1 1) (get v2 0)))])

;(println (m*m [[1 2] [3 4]] [[1 2] [1 2]]))
;(println (vect [1 2 3] [3 2 1]))


(def c+ (operV m+))
(def c- (operV m-))
(def c* (operV m*))
(def cd (operV md))

(def c4+ (operV c+))
(def c4- (operV c-))
(def c4* (operV c*))
(def c4d (operV cd))
