/*
 * Regular (Non-Tail) Recursive Sum Example
 * 
 * This file demonstrates regular recursion in Scala.
 * Unlike tail recursion, this approach builds up the call stack
 * and can cause stack overflow for large inputs.
 */
package recursivesum

/**
 * Calculates the sum of integers from 'a' to 'b' using regular recursion.
 * 
 * This is NOT tail-recursive because after the recursive call returns,
 * we still need to perform the addition operation (a + recursiveSum(...)).
 * This means each recursive call must wait on the stack until all deeper
 * calls complete, leading to potential stack overflow for large ranges.
 * 
 * @param a The starting number (inclusive)
 * @param b The ending number (inclusive)
 * @return  The sum of all integers from a to b
 */
def recursiveSum(a: Long, b: Long): Long =
  // Base case: if a > b, there are no numbers to sum, return 0
  if (a > b) 0 
  // Recursive case: add current number 'a' to the sum of remaining numbers
  // This is NOT tail-recursive because we perform addition AFTER the recursive call
  else a + recursiveSum(a + 1, b)

/**
 * Main function demonstrating regular recursion.
 * Note: Uncommenting the large input (1 to 1,000,000) will likely cause
 * a StackOverflowError because each recursive call adds a frame to the stack.
 */
@main def run(): Unit = {
  println(recursiveSum(1, 10))  // Output: 55 (sum from 1 to 10)
  println(recursiveSum(5, 15))  // Output: 110 (sum from 5 to 15)
  println(recursiveSum(0, 100)) // Output: 5050 (sum from 0 to 100)
  // println(recursiveSum(1, 1_000_000)) // Uncomment to see StackOverflowError!
}