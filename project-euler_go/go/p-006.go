//project euler
//sum square difference
//The sum of the squares of the first ten natural numbers is,
//12 + 22 + ... + 102 = 385
//The square of the sum of the first ten natural numbers is,
//(1 + 2 + ... + 10)2 = 552 = 3025
//Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.

//Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.

package main

import (
  "fmt"
  "math"
  "time"
)

func sumDiff(x int) (diff int) {
  var sumsqr float64
  var sqrsum float64
  for i := 0; i < x; i++ {
    y := float64(i + 1)
    sumsqr += y
    y = math.Pow(y, 2)
    sqrsum += y
  }
  sumsqr = math.Pow(sumsqr, 2)
  diff = int(sumsqr - sqrsum)
  return
}

func main() {
  start := time.Now()

  fmt.Println(int(sumDiff(100)))

  elapsed := time.Since(start)
  fmt.Printf("Time elapsed: %s", elapsed)
}
