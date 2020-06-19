//project euler
//largest palindrome product
//A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

//Find the largest palindrome made from the product of two 3-digit numbers.

package main

import (
	"fmt"
	"math"
	"strconv"
	"time"
)

func reverse(x string) (str string) {
	for _, char := range x {
		str = string(char) + str
	}
	return
}

func hasEvenNumDig(x int) bool {
	digits := int(math.Floor((math.Log10(float64(x))))) + 1
	if digits%2 == 0 {
		return true
	}
	return false
}

func hasEqualHalves(x int) bool {
	str := strconv.Itoa(x)
	len := len(str)
	y := string([]rune(str)[:(len/2)])
	z := string([]rune(str)[(len/2):])
	if y == reverse(z) {
		return true
	}
	return false
}

func sqrt(a int) int {
	return int(math.Sqrt(float64(a)))
}

func countDigits(x int) (digits int) {
	digits = int(math.Floor((math.Log10(float64(x))))) + 1
	return
}

func hasNDigitFactors(x, n int) bool {
	start := int(math.Pow(10, float64(n-1)))
	for i := sqrt(x); i >= start; i-- {
		if x%i == 0 && countDigits(i) == n {
			y := x / i
			if countDigits(y) == n {
				return true
			}
		}
	}
	return false
}

func isPalindrome(x int) bool {
	if hasEvenNumDig(x) {
		if hasEqualHalves(x) {
			return true
		}
	}
	return false
}

func maxPal(start, end, n int) (max int) {
	for i := start; i >= end; i-- {
		if isPalindrome(i) && hasNDigitFactors(i, n) {
			max = i
			return
		}
	}
	return
}

func main() {
	start := time.Now()

	fmt.Println(maxPal(997799, 100001, 3))

	elapsed := time.Since(start)
	fmt.Printf("Time elapsed: %s", elapsed)
}
