/*
 * Fibonacci with Iterative Approach - Traditional Imperative Implementation
 * 
 * This file demonstrates the traditional iterative (loop-based) implementation
 * of the Fibonacci sequence. While this approach uses mutable state and is less
 * "functional" in style, it's very efficient and familiar to programmers from
 * imperative backgrounds.
 * 
 * This serves as a comparison point to show how functional approaches (like
 * tail recursion) can achieve the same efficiency while maintaining immutability.
 */
package iterativeFibonacci

import scala.math.BigInt

/**
 * Computes the nth Fibonacci number using traditional iterative approach.
 * 
 * This implementation uses a while loop with mutable variables to compute
 * the Fibonacci sequence efficiently. It's the most straightforward approach
 * from an algorithmic perspective and what many programmers would write
 * in imperative languages like C or Java. Compared to a memoized approach,
 * it avoids the overhead of caching results and is very efficient for large n.
 * 
 * Time complexity: O(n) - linear time
 * Space complexity: O(1) - constant space
 * 
 * Trade-offs:
 * + Very efficient in both time and space
 * + Simple and intuitive algorithm
 * + No risk of stack overflow
 * - Uses mutable state (less functional)
 * - Harder to reason about in complex scenarios
 * 
 * @param n the index of the Fibonacci number to compute (should be >= 0)
 * @return the nth Fibonacci number
 */
def fibonacciIterative(n: BigInt): BigInt = {
  // Handle base cases first
  if (n == 0) return BigInt(0)  // F(0) = 0
  if (n == 1) return BigInt(1)  // F(1) = 1

  // Mutable variables to track the computation state
  var a = BigInt(0)  // Previous Fibonacci number (F(i-2))
  var b = BigInt(1)  // Current Fibonacci number (F(i-1))
  var i = BigInt(2)  // Loop counter starting from F(2)

  // Traditional while loop with mutable state updates
  while (i <= n) {
    val temp = a + b  // Compute next Fibonacci number F(i)
    a = b             // Shift: previous becomes current
    b = temp          // Shift: current becomes next
    i += 1            // Increment counter
  }

  return b  // Return the computed Fibonacci number
}

/**
 * Main function demonstrating iterative Fibonacci computation.
 * 
 * This shows the traditional imperative approach to computing Fibonacci numbers.
 * While it uses mutable state, it's highly efficient and serves as a baseline
 * for comparing with functional approaches.
 * 
 * Key characteristics:
 * - Uses traditional loops and mutable variables
 * - Very efficient: O(n) time, O(1) space
 * - Familiar to programmers from imperative backgrounds
 * - No risk of stack overflow
 * 
 * Compare with functional approaches:
 * - Tail recursion: Same efficiency, but immutable
 * - Memoization: Same time complexity, but uses cache memory
 * - Naive recursion: Much slower O(2^n) due to redundant calculations
 */
@main def runFibonacciIterative(): Unit = {
  println("Fibonacci numbers 0-14 using iterative approach:")
  println((0 until 15).map(n => fibonacciIterative(BigInt(n))))
  
  println("\nIterative approach handles large numbers efficiently:")
  println(s"F(50) = ${fibonacciIterative(BigInt(50))}")
  println(s"F(100) = ${fibonacciIterative(BigInt(100))}")
  
  println("\nCharacteristics of iterative approach:")
  println("- Uses mutable variables (imperative style)")
  println("- Very efficient: O(n) time, O(1) space")
  println("- No stack overflow risk")
  println("- Familiar to imperative programmers")
  println("- Serves as baseline for functional comparisons")
}
