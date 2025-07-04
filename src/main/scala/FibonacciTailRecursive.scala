/*
 * Fibonacci with Tail Recursion - Optimized Recursive Implementation
 * 
 * This file demonstrates how to implement the Fibonacci sequence using tail recursion,
 * which is stack-safe and efficient. Unlike the naive recursive approach that has
 * exponential time complexity, this tail-recursive version runs in linear time O(n)
 * and constant space O(1) due to tail call optimization.
 */
package talRecursiveFibonacci

import scala.annotation.tailrec

// Alternative implementation using direct tail recursion with accumulators
// @tailrec
// def fibonacciTailRecursive(n: Int, a: BigInt = 0, b: BigInt = 1): BigInt = {
//   if (n == 0) a
//   else if (n == 1) b
//   else fibonacciTailRecursive(n - 1, b, a + b)
// }

/**
 * Computes the nth Fibonacci number using tail recursion with a helper function.
 * 
 * This implementation uses the "loop conversion" pattern where we transform
 * an iterative algorithm into a tail-recursive one. The helper function `loop`
 * acts like a traditional for loop but in functional style.
 * 
 * Time complexity: O(n) - linear time
 * Space complexity: O(1) - constant space due to tail call optimization
 * 
 * @param n the index of the Fibonacci number to compute (should be >= 0)
 * @return the nth Fibonacci number
 */
def fibonacciTailRecursive(n: BigInt): BigInt = {
  /**
   * Helper function that performs the actual computation using tail recursion.
   * This mimics a loop: for (i = 2; i <= n; i++) { update a and b }
   * 
   * @param i current iteration counter (like loop variable)
   * @param a previous Fibonacci number (F(i-2))
   * @param b current Fibonacci number (F(i-1))
   * @return the nth Fibonacci number
   */
  @tailrec
  def loop(i: BigInt, a: BigInt, b: BigInt): BigInt = {
    // Base case: if we've computed F(n), return the result
    if (i > n) b
    // Recursive case: compute next Fibonacci number and continue
    // This is tail-recursive because the recursive call is the last operation
    else loop(i + 1, b, a + b)  // i++; a = b; b = a + b
  }
  
  // Handle base cases directly
  if (n == 0) 0      // F(0) = 0
  else if (n == 1) 1 // F(1) = 1
  // For n >= 2, use the loop helper starting from F(2)
  else loop(2, 0, 1) // Start with F(0)=0, F(1)=1, compute from i=2
}

/**
 * Main function demonstrating tail-recursive Fibonacci computation.
 * 
 * This version is both stack-safe and efficient:
 * - No risk of stack overflow even for large inputs
 * - Linear time complexity O(n)
 * - Functional programming style without mutable state
 * 
 * Compare with:
 * - fibonacciNaive: O(2^n) time, risks stack overflow
 * - fibonacciMemoized: O(n) time but uses memory for cache
 * - fibonacciIterative: O(n) time, uses mutable variables
 */
@main def runFibonacciTailRecursive(): Unit = {
  println("Fibonacci numbers 0-14 using tail recursion:")
  println((0 until 15).map(x => fibonacciTailRecursive(x)))
  
  println("\nTail recursion can handle large numbers efficiently:")
  println(s"F(50) = ${fibonacciTailRecursive(50)}")
  println(s"F(100) = ${fibonacciTailRecursive(100)}")
  
  println("\nKey advantages of tail recursion:")
  println("- Stack-safe (no overflow)")
  println("- Linear time complexity O(n)")
  println("- Functional style (no mutable state)")
  println("- Compiler optimized to loop")
}