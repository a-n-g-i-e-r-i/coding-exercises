# Create a function called middle_element that has one parameter named lst.

# If there are an odd number of elements in lst, the function should return the middle element. If there are an even number of elements, the function should return the average of the middle two elements.

def middle_element(lst):
  l = len(lst)
  floor = l // 2
  return lst[floor] if not (l % 2 == 0) else ((lst[floor] + lst[floor - 1]) / 2)

# Should return -7.0
print(middle_element([5, 2, -10, -4, 4, 5]))