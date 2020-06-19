//project euler
//largest prime factor
//The prime factors of 13195 are 5, 7, 13 and 29.

//What is the largest prime factor of the number 600851475143 ?

package main

import (
	"fmt"
	"math"
	"time"
)

func sqrt(a int) int {
	return int(math.Sqrt(float64(a)))
}

func isPrime(x int) bool {
	if x <= 1 {
		return false
	}
	for i := sqrt(x); i >= 1; i-- {
		if i == 1 {
			return true
		} else if x%i == 0 {
			return false
		}
	}
	return true
}

func maxPrimeFactor(start int) (max int) {
	for i := sqrt(start); i >= 1; i-- {
		if start%i == 0 && isPrime(i) {
			max = i
			return
		}
	}
	return
}

func main() {
	start := time.Now()

	fmt.Println(maxPrimeFactor(600851475143))

	elapsed := time.Since(start)
	fmt.Printf("Time elapsed: %s", elapsed)
}
