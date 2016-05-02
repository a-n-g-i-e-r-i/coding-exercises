// The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

// Find the sum of all the primes below two million.

package main

import (
	"fmt"
)

func primesBelowTwoMillion() int {
	var s int = 0
	for i := 2; i < 2000000; i++ {
		if isPrime(i) {
			s += i
		}
	}
	return s
}

func isPrime(n int) bool {
	var d int = 2
	for n > d {
		if n%d == 0 {
			return false
		} else {
			d++
		}
	}
	return true
}

func main() {
	fmt.Println(primesBelowTwoMillion())
}
