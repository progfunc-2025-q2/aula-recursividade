/*
 * Loop Conversion Using Tail Recursion
 * 
 * This file demonstrates how tail recursion can be used to simulate
 * imperative loops in a functional programming style. The pattern shown
 * here is commonly used to convert traditional for/while loops into
 * functional, tail-recursive equivalents.
 */

/**
 * Calculates the sum of integers from 'a' to 'b' using a helper function
 * that simulates a loop through tail recursion.
 * 
 * This approach separates the main logic from the loop mechanics,
 * making the code more readable and maintainable.
 * 
 * @param a The starting number (inclusive)
 * @param b The ending number (inclusive)
 * @return  The sum of all integers from a to b
 */
def declarativeSum(a: Long, b: Long): Long = {
  /**
   * Helper function that acts like a loop using tail recursion.
   * This is equivalent to:
   * for (i <- a to b) sum += i
   * 
   * @param i   Current iteration value (like loop counter)
   * @param sum Running total (like accumulator variable)
   * @param b   Upper bound (end condition)
   * @return    Final sum when loop completes
   */
  @scala.annotation.tailrec
  def loopHelper(i: Long, sum: Long, b: Long): Long = {
    // Base case: if i > b, we've processed all numbers, return sum
    if (i > b) sum
    // Recursive case: increment i and add it to sum (like i++; sum += i)
    else loopHelper(i + 1, sum + i, b)
  }

  // Handle edge case: if start > end, return 0 (empty range)
  if (a > b) 0
  // Start the "loop" with initial values: i=a, sum=0
  else loopHelper(a, 0, b)
}

/**
 * Main function demonstrating the declarative sum approach.
 * This shows how functional programming can achieve the same results
 * as imperative loops while being stack-safe for large inputs.
 */
@main def runDeclarativeSum(): Unit = {
  println(declarativeSum(1, 10))        // Output: 55
  println(declarativeSum(5, 15))        // Output: 110
  println(declarativeSum(0, 100))       // Output: 5050
  println(declarativeSum(1, 1_000_000)) // Output: 500000500000 (no stack overflow!)
}
// println(declarativeSum(1, 1_000_000)) // Uncomment to test with large range
