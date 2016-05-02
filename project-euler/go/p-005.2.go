//project euler
//smallest multiple
//2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

//What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

package main

import (
  "fmt"
  "time"
)

func divisibleByAll(y int, x []int) (result bool){
  result = false
  for _, num := range x {
    if y % num == 0 {
      result = true
    } else {
      result = false
      return
    }
  }
  return result
}

func minPosEvenDivNum(x []int) (min int){
  min = (x[len(x) - 1]) * (x[(len(x)) - 2])
  exit := 3000000000000
  for i := min; i < exit; i++ {
      if divisibleByAll(i, x) == true {
        min = i
        return
      }
  }
  return
}

func main() {
  start := time.Now()

  slice := []int{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20}
  fmt.Println(minPosEvenDivNum(slice))

  elapsed := time.Since(start)
  fmt.Printf("Time elapsed: %s", elapsed)
}
