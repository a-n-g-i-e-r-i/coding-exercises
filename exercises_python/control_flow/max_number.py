# Create a function called max_num() that has three parameters named num1, num2, and num3.

# The function should return the largest of these three numbers. If any of two numbers tie as the largest, you should return "It's a tie!".

def max_num(num1, num2, num3):
  max = num1
  for n in (num2, num3):
    if max == n:
      return "It's a tie!"
    elif max < n:
      max = n
  return max

# should print 10
print(max_num(-10, 0, 10))

# should print 5
print(max_num(-10, 5, -30))

# should print -5
print(max_num(-5, -10, -10))

# should print "It's a tie!
print(max_num(2, 3, 3))
