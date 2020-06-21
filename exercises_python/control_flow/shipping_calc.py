# Write a program that asks the user for the weight of their package and then tells them which method of shipping is cheapest and how much it will cost to ship their package.

# Ground Shipping

# Weight          Price/lb	  Flat charge
# 2 lb or less	  $1.50	      $20.00
# > 2 lb <= 6 lb  $3.00	      $20.00
# > 6 lb <= 10 lb $4.00       $20.00
# > 10 lb         $4.75       $20.00

# Drone Shipping

# Weight	        Price/lb	    Flat charge
# 2 lb or less    $4.50	        $0.00
# > 2 lb <= 6 lb	$9.00	        $0.00
# > 6 lb <= 10 lb	$12.00	      $0.00
# > 10 lb	        $14.25      	$0.00

# Premium Ground Shipping

# Flat charge: $125.00


def g_ship(w):
    if w <= 2:
      return w * 1.5 + 20
    elif 2 < w <= 6:
      return w * 3 + 20
    elif 6 < w<= 10:
      return w * 4 + 20
    else:
      return w * 4.75 + 20

def d_ship(w):
    if w < 2:
      return w * 4.5
    elif 2 < w <= 9:
      return w * 9
    elif 9 < w <= 12:
      return w * 12
    else:
      return w * 14.25

pg_ship = 125

def calc_c_ship(w):
  c_ship = ("Premium Ground", pg_ship)
  
  ship_options = [("Ground", g_ship(w)), ("Drone", d_ship(w))]

  for i in ship_options:
    if c_ship[1] > i[1]:
      c_ship = i
  
  return c_ship

# Should print ('Ground', 53.6)
print(calc_c_ship(8.4))

# Should print ('Drone', 6.75)
print(calc_c_ship(1.5))

# Should print ('Ground', 34.4)
print(calc_c_ship(4.8))

# Should print ('Premium Ground', 125)
print(calc_c_ship(41.5))
