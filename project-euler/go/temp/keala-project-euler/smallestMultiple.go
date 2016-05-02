// 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

// What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

// smallest positive number
// evenly divisible by 1 to 20

package main

import (
    "fmt"
)

func smallest() (n int) {
  for n = 1; n < 100000000000000; n++ {
  // d stands for divisible
    var d bool = true
    for i := 20; i > 0; i-- {
      if n % i != 0 {
        d = false
      }
    }
    if d == true {
      return n
    }
  }
  return n
}

func main() {
  fmt.Println(smallest())
}
