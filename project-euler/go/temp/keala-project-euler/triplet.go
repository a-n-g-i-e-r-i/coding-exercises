// A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

// a2 + b2 = c2
// For example, 32 + 42 = 9 + 16 = 25 = 52.

// There exists exactly one Pythagorean triplet for which a + b + c = 1000.
// Find the product abc.

package main

import (
  "fmt"
)

func abc() (p int) {
  // s stands for sum
  // p for product
  var s int = 1000
  for a := 1; a < 450; a++ {
    for b := 1; b < 450; b++ {
      for c := 1; c < 450; c++ {
        if a * a + b * b == c * c && a + b + c == s {
          p = a * b * c
          return p
        } 
      }
    }
  }
  return p
}

func main() {
  fmt.Println(abc())
}
