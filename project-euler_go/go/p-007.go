//project euler
//10001st prime
//By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

//What is the 10001st prime number?

package main

import (
  "fmt"
  "math/big"
  "time"
)

func nthPrime(x int) (result int) {
  count := 1
  for i := 1; count == count; i += 2 {
    if count >= x {
      return
    } else {
      big := big.NewInt(int64(i))
      isPrime := big.ProbablyPrime(4)
      if isPrime == true {
        count += 1
        result = i
      }
    }
  }
  return
}

func main() {
  start := time.Now()

  fmt.Println(nthPrime(10001))

  elapsed := time.Since(start)
  fmt.Printf("Time elapsed: %s", elapsed)
}
