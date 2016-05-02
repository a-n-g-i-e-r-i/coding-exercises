// A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

// Find the largest palindrome made from the product of two 3-digit numbers.

package main 

import (
    "fmt"
    "strconv"
)

func largest(n int) int {
  m := 0
  for i := n; i > 0; i-- {
    if m > i*i {
      return m 
    }

    for j := i; j > 0; j-- {
      if isPalindrome(i*j) && i*j > m {
        m = i * j
      }
    }
  }
  return 0
}

func isPalindrome(v int) bool {
  var s string = strconv.Itoa(v)
  var l int= len(s)

  for i := 0; i <= l/2; i++ {
    if s[i] != s[l-i-1] {
      return false
    }
  }
  return true
}

func main() {
  fmt.Println(largest(999))
}
