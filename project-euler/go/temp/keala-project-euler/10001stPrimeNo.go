// By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

// What is the 10001st prime number?

package main

import(
  "fmt"
)

func prime() int {
  // p is for prime number
  // s is for sum, to keep track of how many prime numbers there has been
  var p int = 1
  var s int = 0
  for s < 10001 {
    p++
    if isPrime(p) {
      s++
    }
  }
  return p
}

func isPrime(n int) bool {
  // d is for divisible
  var d int = 2
  for n > d {
    if n % d == 0 {
      return false 
    } else {
      d++
    }
  }
  return true
}

func main() {
  fmt.Println(prime())
}
