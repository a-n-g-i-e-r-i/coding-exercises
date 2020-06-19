// Code CracklePop
// 
// Write a program that prints out the numbers 1 to 100 (inclusive).
// If the number is divisible by 3, print Crackle instead of the number.
// If it's divisible by 5, print Pop.
// If it's divisible by both 3 and 5, print CracklePop. You can use any language.

function Range(min=Integer, max=Integer) {
  this.min = min;
  this.max = max;
}

function CracklePop(range=Range, crackleInt=Integer, popInt=Integer) {
  this.range = range;
  this.crackleInt = crackleInt;
  this.popInt = popInt;
  this.crackleStr = "Crackle";
  this.popStr = "Pop";
}

/**
 * Returns true if the dividend is divisible by the divisor, false if not
 * @param {Integer} dividend
 * @param {Integer} divisor
 */
function isDividendDivisibleByDivisor(dividend, divisor) {
  if (dividend % divisor === 0) {
    return true;
  }
  return false;
}

/**
 * Returns true if the arg is an instance of the type, false if not
 * @param arg
 * @param {String} type
 */
function isInstanceOf(arg, type) {
  if (
    typeof arg !== type) {
    console.log(`ERROR: ${arg} is not an instance of ${type}\n`);
    return false;
  }
  console.log(`INFO: ${arg} is an instance of ${type}\n`);
return true
}

/**
 * Returns true if the range is a Range instance, false if not
 * @param {Range} range
 */
function isRange(range) {
  if (
    typeof range !== "object" ||
    !isInstanceOf(range.min, "number") ||
    !isInstanceOf(range.max, "number")
    ) {
    console.log(`ERROR: Given range is not an instance of Range\n`);
    return false;
  }
  console.log(`INFO: Given range is an instance of Range\n`);
  return true
}

/**
 * For each number within the range, if the number is divisible by:
 *  - the crackle and pop divisors, print "CracklePop".
 *  - the crackle divisor, print "Crackle".
 *  - the pop divisor, print "Pop".
 *  - neither crackle nor pop divisors, print the number.
 * 
 * @param {CracklePop} cracklePop
 */
function getPrintValue(cracklePop, printValue="") {
  if(isDividendDivisibleByDivisor(cracklePop.range.min, cracklePop.crackleInt)) {
    printValue += cracklePop.crackleStr;
  }
  if (isDividendDivisibleByDivisor(cracklePop.range.min, cracklePop.popInt)) {
    printValue += cracklePop.popStr;
  }
  if (printValue === "") {
    printValue = cracklePop.range.min;
  }
  return printValue;
}

/**
 * Recurses inclusively through given range
 *  - in each recursion calls getPrintValue(cracklePop)
 * 
 * @param {CracklePop} cracklePop
 */
function rangeRecurser(cracklePop) {
  console.log(getPrintValue(cracklePop));
  
  cracklePop.range.min += 1;

  if (cracklePop.range.min <= cracklePop.range.max) {
    rangeRecurser(cracklePop);
  }
}

/**
 * Prints out the numbers within a range (inclusive).
 * For each number within the range, if the number is divisible by:
 *  - the crackle and pop divisors, print "CracklePop".
 *  - the crackle divisor, print "Crackle".
 *  - the pop divisor, print "Pop".
 *  - neither crackle nor pop divisors, print the number.
 * 
 * @param {CracklePop}  cracklePop
 */
function codeCracklePop(cracklePop) {
  console.log(`INFO: Starting codeCracklePop with CracklePop: ${JSON.stringify(cracklePop)}\n`);

  if (isRange(cracklePop.range) &&
    isInstanceOf(cracklePop.crackleInt, "number") &&
    isInstanceOf(cracklePop.popInt, "number") &&
    isInstanceOf(cracklePop.crackleStr, "string") &&
    isInstanceOf(cracklePop.popStr, "string")) {
    console.log(`INFO: Initializing rangeRecurser\n`);
    rangeRecurser(cracklePop);
    console.log(`\nINFO: Shutting down rangeRecurser\n`);
  } else {
    console.log(`ERROR: Given CracklePop does not pass inspection\n`);
  }
  console.log(`INFO: Stopping codeCracklePop\n`);
}

/********* TESTS *********/

// negative test for range min value
const stringMinTest = new CracklePop(new Range("one",100), 3, 5);
codeCracklePop(stringMinTest);

// negative test for range max value
const stringMaxTest = new CracklePop(new Range(1,"100"), 3, 5);
codeCracklePop(stringMaxTest);

// negative test for crackleInt value
const stringCrackleIntTest = new CracklePop(new Range(1,100), "3", 5);
codeCracklePop(stringCrackleIntTest);

// negative test for popInt value
const stringPopIntTest = new CracklePop(new Range(1,100), 3, "5");
codeCracklePop(stringPopIntTest);

// negative test for crackleStr value
const intCrackleStrTest = new CracklePop(new Range(1,100), 3, 5);
intCrackleStrTest.crackleStr = 3;
codeCracklePop(intCrackleStrTest);

// negative test for crackleStr value
const intPopStrTest = new CracklePop(new Range(1,100), 3, 5);
intPopStrTest.popStr = 5;
codeCracklePop(intPopStrTest);

// positive test for Crackle
codeCracklePop(new CracklePop(new Range(3,3), 3, 5));

// positive test for Pop
codeCracklePop(new CracklePop(new Range(5,5), 3, 5));

// positive test for CracklePop
codeCracklePop(new CracklePop(new Range(45,45), 3, 5));

/********* REQUESTED RESULT *********/
// CracklePop result
codeCracklePop(new CracklePop(new Range(1,100), 3, 5));
