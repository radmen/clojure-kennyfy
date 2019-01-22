(ns info.radmen.kennyfy
  (:require [clojure.string :as str])
  (:require [clojure.set :as set]))

(def kenny-lang {
  \e "mpp"
  \t "fmp"
  \a "mmm"
  \o "ppf"
  \i "mff"
  \n "ppp"
  \s "fmm"
  \h "mfp"
  \r "pff"
  \d "mpm"
  \l "pmf"
  \c "mmf"
  \u "fmf"
  \m "ppm"
  \w "fpp"
  \f "mpf"
  \g "mfm"
  \y "ffm"
  \p "pfm"
  \b "mmp"
  \v "fpm"
  \k "pmp"
  \j "pmm"
  \x "fpf"
  \q "pfp"
  \z "ffp"
  \E "Mpp"
  \T "Fmp"
  \A "Mmm"
  \O "Ppf"
  \I "Mff"
  \N "Ppp"
  \S "Fmm"
  \H "Mfp"
  \R "Pff"
  \D "Mpm"
  \L "Pmf"
  \C "Mmf"
  \U "Fmf"
  \M "Ppm"
  \W "Fpp"
  \F "Mpf"
  \G "Mfm"
  \Y "Ffm"
  \P "Pfm"
  \B "Mmp"
  \V "Fpm"
  \K "Pmp"
  \J "Pmm"
  \X "Fpf"
  \Q "Pfp"
  \Z "Ffp"
})

(def kenny-lang-inverted (set/map-invert kenny-lang))

(defn- char->kenny
  [c]
  (get kenny-lang c c))

(defn- kenny-seq->char
  [xs]
  (let [s (apply str xs)]
    (get kenny-lang-inverted s)))

(defn- ->vec
  [xs]
  (apply vector xs))

(defn- parse-char-vec
  "Parses vector of characters. Returns pair of: decoded string and rest of vector."
  [xs]
  (let [v (->vec xs)
        c (kenny-seq->char (take 3 v))]
    (cond
      (nil? c) [(first v) (->vec (next v))]
      :else [c (subvec v 3)])))

(defn kenny-speak
  "Translate string to kenny-speak"
  [xs]
  (->> (seq xs)
       (map char->kenny)
       (reduce str)))

(defn kenny-translate
  "Translates kenny-speak"
  [xs]
  (loop [carry ""
         xs    xs]
    (let [[decoded new-xs] (parse-char-vec xs)
          new-carry        (str carry decoded)]
      (cond
        (empty? new-xs) new-carry
        :else (recur new-carry new-xs)))))
