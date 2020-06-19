// If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

// Find the sum of all the multiples of 3 or 5 below 1000.

package main

import (
  "fmt"
  "time"
)

func multiples() (s int) {
  for i := 0; i < 1000; i++ {
    if i % 3 == 0 || i % 5 == 0 {
      // s is the sum of the multiples
      s += i
    }
  }
  return s
}

func main() {
  start := time.Now()

  fmt.Println(multiples())

  elapsed := time.Since(start)
  fmt.Printf("Time elapsed: %s", elapsed)
}
