#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the solve function below.
def solve(meal_cost, tip_percent, tax_percent):
  total_meal_cost = sum([meal_cost,
  (meal_cost * tax_percent/float(100)),
  (meal_cost * tip_percent/float(100))
  ])
  print(int(round(total_meal_cost)))

if __name__ == '__main__':
    meal_cost = float(input())

    tip_percent = int(input())

    tax_percent = int(input())

    solve(meal_cost, tip_percent, tax_percent)
