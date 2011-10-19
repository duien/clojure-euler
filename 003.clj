; The prime factors of 13195 are 5, 7, 13 and 29.

; What is the largest prime factor of the number 600851475143 ?

; Aww, sadface. This explodes with a sufficiently large `number`
; I knew it sucked, but I guess it sucks too much to use.
(defn sieve [maximum]
  (loop [numbers (range 2 (+ 1 maximum))
         index   0]
    (let [current (nth numbers index)]
      (if (< (* current current) maximum) 
        (recur
          (keep (fn [item] (if (and (= 0 (mod item current)) (not (= item current))) nil item)) numbers)
          (+ 1 index)
          )
        numbers
        )
      )
    )
  )


(defn unique-factor [number]
  (filter
    (fn [n] (= 0 (mod number n)))
    (sieve number)
    )
  )

  

(print
  (max (unique-factor 600851475143))
  "\n")
