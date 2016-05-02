//project euler
//special pythagorean triplet
//A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

// a2 + b2 = c2
// For example, 32 + 42 = 9 + 16 = 25 = 52.
//
// There exists exactly one Pythagorean triplet for which a + b + c = 1000.

// Find the product abc.

package main

import (
  "fmt"
  "math"
  "time"
)

func isCorTrip(i, j, k int) bool{
  x := math.Pow(float64(i), 2)
  y := math.Pow(float64(j), 2)
  z := math.Pow(float64(k), 2)
  if (x + y == z) || (x + z == y) || (z + x == y) || (z + y == x) || (y + z == x) || (y + x == z) {
    return true
  }
  return false
}

func tripProd(x int) (corTripProd int) {
  for i := 1; i < x; i++ {
    for j := 1; j < x; j++ {
      for k := 1; k < x; k++ {
        if i + k + j == x {
          if isCorTrip(i, k, j) {
            fmt.Println(i, j, k)
            corTripProd = i * j * k
            return
          }
        }
      }
    }
  }
  return
}

func main() {
  start := time.Now()

  fmt.Println(tripProd(1000))

  elapsed := time.Since(start)
  fmt.Printf("Time elapsed: %s", elapsed)
}
