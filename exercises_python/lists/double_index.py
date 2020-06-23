# Create a function named double_index that has two parameters: a list named lst and a single number named index.

# The function should return a new list where all elements are the same as in lst except for the element at index. The element at index should be double the value of the element at index of the original lst.

# If index is not a valid index, the function should return the original list.

def double_index(lst, index):
  try:
    lst[index] += lst[index]
  except IndexError:
    pass
  return lst

# Should print [3, 8, -20, 12]
print(double_index([3, 8, -10, 12], 2))