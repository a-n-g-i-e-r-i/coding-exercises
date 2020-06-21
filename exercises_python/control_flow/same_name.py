# Create a function named same_name() that has two parameters named your_name and my_name.

# If our names are identical, return True. Otherwise, return False.

def same_name(your_name, my_name):
  result = True if your_name == my_name else False
  return result

# should print True
print(same_name("Colby", "Colby"))

# should print False
print(same_name("Tina", "Amber"))
