
function factorial(number) {
  i = number;
  while(i > 1) {
    i--;
    number = number * i;
  }
  return number
}

factorial(7);

function recursionFactorial(number, countdown) {
  if (countdown <= 1) {
    return number;
  }
  countdown--;
  number = number * countdown;
  return recursionFactorial(number, countdown);
}

recursionFactorial(25, 25);

function recursiveFactorial(x) {
  if (x <= 1) {
    return x;
  }
  return x * (recursiveFactorial(x - 1));
}

recursiveFactorial(7);
