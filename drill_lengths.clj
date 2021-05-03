(def drill-entries
    "list of drill groups in format of [nominal-size drill-length drill-drawer-width]"
    [[1/8 (fl 2 7/8) (fl 2 1/4)] 
    [3/8 (fl 5 1/8) 2]
    [9/64 (fl 3 7/8) (fl 1 3/4)]
    [5/32 (fl 3 1/4) (fl 1 3/4)]
    [5/16 (fl 4 5/8) (fl 2 1/8)]
    [1/4 (fl 4 1/8) (fl 2 7/8)]
    [15/64 4 (fl 1 5/8)]
    [13/64 (fl 3 7/8) (fl 1 5/8)]
    [7/32 (fl 3 7/8) (fl 1 1/2)]
    [11/64 (fl 3 3/8) (fl 1 3/8)]
    [3/32 (fl 2 3/8) (fl 1 1/4)]
    [1/16 2 (fl 1 3/8)]
    [5/64 (fl 2 1/8) (fl 1 3/8)]
    [3/16 (fl 4 1/8) 2]
    [7/64 (fl 3 1/8) (fl 1 7/8)]])

(defn fl [whole partial]
    "function to convert a mixed number to float"
    (float (+ whole partial)))

(def distinct-drill-diameters
    "total number of distinct nominal drill sizes"
    (count drill-entries))

(def drill-diameter-nominals
    "list of distinct nominal drill sizes"
    (for [all (range distinct-drill-diameters)] ((drill-entries all) 0)))

(def drill-diameter-floats
    "list of distinct drill diameters represented as floats"
    (map float drill-diameter-nominals))

(def drill-drawer-lengths
    "list of drawer lengths required to store the corresponding drills"
    (for [all (range distinct-drill-diameters)] ((drill-entries all) 1)))

(def sum-of-drill-diameters
    "the sum of distinct drill diameters"
    (reduce + drill-diameter-floats))

(def sum-of-drill-drawer-lengths
    "the sum of distinct drawer lengths"
    (reduce + drill-drawer-lengths))

(def drill-drawer-widths
    "list of drawer widths required to store the corresponding drills"
    (for [all (range distinct-drill-diameters)] ((drill-entries all) 2)))

(def sum-of-drill-drawer-widths
    "the sum of distinct drawer widths"
    (reduce + drill-drawer-widths))

(def fucking-hell
    "the entire reason i wrote this entire source file
        that is to get a geometric area scalar for use in determining suitability of drawers for drill storage"
    (reduce +
        (for [index (range distinct-drill-diameters)] 
            (* 
                ((drill-entries index) 1)
                ((drill-entries index) 2)))))