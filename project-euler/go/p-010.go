//project euler
//summation of primes
//The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

//Find the sum of all the primes below two million.

package main

import (
  "fmt"
  "math/big"
  "time"
)

func sumOfArray(x []int) (sum int) {
  for _, y := range x {
    sum += y
  }
  return
}

func sumOfPrimes(x int) (result int) {
  cap := x/2
  primes := make([]int, 0, cap)
  primes = append(primes, 2)
  for i := 1; i < x ; i += 2 {
    big := big.NewInt(int64(i))
    isPrime := big.ProbablyPrime(4)
    if isPrime == true {
      primes = append(primes, i)
    }
  }
  result = sumOfArray(primes)
  return
}

func main() {
  start := time.Now()

  fmt.Println(sumOfPrimes(2000000))

  elapsed := time.Since(start)
  fmt.Printf("Time elapsed: %s", elapsed)
}
