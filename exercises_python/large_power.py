# Create a function named large_power() that takes two parameters named base and exponent.
# If base raised to the exponent is greater than 5000, return True, otherwise return False

def large_power(b, e):
  if b**e > 5000:
    return True
  return False

large_power(10, 2)