/*
 * Naive Fibonacci - Classic Recursive Implementation
 * 
 * This file demonstrates the classic recursive implementation of the Fibonacci sequence.
 * While elegant and mathematically intuitive, this approach has exponential time complexity
 * and serves as a perfect example of why optimization techniques like memoization or
 * tail recursion are necessary for practical recursive algorithms.
 */
package fibonacciNaive

import scala.math.BigInt

/**
 * Computes the nth Fibonacci number using naive recursion.
 * 
 * This implementation directly follows the mathematical definition:
 * F(0) = 0, F(1) = 1, F(n) = F(n-1) + F(n-2) for n > 1
 * 
 * WARNING: This function has exponential time complexity O(2^n)!
 * It recalculates the same Fibonacci numbers multiple times.
 * For example, F(5) calls F(4) and F(3), but F(4) also calls F(3),
 * leading to redundant calculations that grow exponentially.
 * 
 * Use this only for small values of n (< 40) or for educational purposes.
 * 
 * @param n the index of the Fibonacci number to compute (should be >= 0)
 * @return the nth Fibonacci number
 */
def fibonacciNaive(n: BigInt): BigInt = {
  // Base cases: the first two Fibonacci numbers are defined directly
  if (n == 0) BigInt(0)      // F(0) = 0
  else if (n == 1) BigInt(1) // F(1) = 1
  // Recursive case: F(n) = F(n-1) + F(n-2)
  // This is NOT tail-recursive because we perform addition after the recursive calls
  // This leads to exponential time complexity due to overlapping subproblems
  else fibonacciNaive(n - 1) + fibonacciNaive(n - 2)
}

/**
 * Main function demonstrating the naive Fibonacci implementation.
 * 
 * Notice how the computation time grows dramatically with larger inputs:
 * - F(10) is instant
 * - F(20) takes a moment
 * - F(30) takes several seconds
 * - F(40) takes minutes!
 * 
 * This demonstrates why algorithmic efficiency matters in recursive programming.
 */
@main def runFibonacciNaive(): Unit = {
  println("Fibonacci numbers 0-14 using naive recursion:")
  println((0 until 15).map(n => fibonacciNaive(BigInt(n))))
  
  println("\nTry timing larger numbers to see exponential growth:")
  println("F(20) = " + fibonacciNaive(BigInt(20)))
  println("F(25) = " + fibonacciNaive(BigInt(25)))
  
  // Uncomment to see how slow this becomes:
  // println("F(35) = " + fibonacciNaive(BigInt(35))) // Takes several seconds
  // println("F(40) = " + fibonacciNaive(BigInt(40))) // Takes minutes!
}