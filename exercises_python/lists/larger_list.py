# Write a function named larger_list that has two parameters named lst1 and lst2.

# The function should return the last element of the list that contains more elements. If both lists are the same size, then return the last element of lst1.

def larger_list(lst1, lst2):
  return lst2[-1] if len(lst2) > len(lst1) else lst1[-1]

# Should print 5
print(larger_list([4, 10, 2, 5], [-10, 2, 5, 10]))