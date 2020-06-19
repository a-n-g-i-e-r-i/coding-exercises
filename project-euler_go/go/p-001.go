//project euler
//multiples of 3 and 5
//If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

//Find the sum of all the multiples of 3 or 5 below 1000.

package main

import (
	"fmt"
	"time"
)
func multThreeFiveSum(max int) (sum int) {
	for i := 0; i < max; i++ {
		if i%3 == 0 || i%5 == 0 {
			sum += i
		}
	}
	return
}

func main() {
	start := time.Now()

	fmt.Println(multThreeFiveSum(1000))

	elapsed := time.Since(start)
	fmt.Printf("Time elapsed: %s", elapsed)
}
