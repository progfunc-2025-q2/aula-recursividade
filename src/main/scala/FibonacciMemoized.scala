/*
 * Fibonacci with Memoization - Advanced Recursion Optimization
 * 
 * This file demonstrates memoization, a powerful optimization technique that
 * caches previously computed results to avoid redundant calculations.
 * Unlike simple tail recursion, memoization can optimize recursive functions
 * that are not naturally tail-recursive, like the Fibonacci sequence.
 */
package fibonacciMemoized

import scala.collection.mutable
import scala.math.BigInt
import fibonacciNaive.fibonacciNaive

/**
  * Higher order function that takes a function `f` and returns a memoized version of it.
  * The memoized function caches the results of `f` for each input, so that subsequent calls with the same input do not require recomputation.
  * The cache is implemented using a mutable Map that is kept private in the closure of the returned function.
  * 
  * This is a classic example of the "decorator pattern" in functional programming,
  * where we enhance a function's behavior without modifying its core logic.
  * 
  * @param f the function to be memoized
  * @return a new function that behaves like `f` but caches results
  */
def memoize[I, O](f: I => O): I => O = {
  // Private cache shared across all calls to the memoized function
  // This demonstrates closure - the cache persists between function calls
  val cache = mutable.Map.empty[I, O]

  // Return a new function that wraps the original function with caching logic
  // This demonstrates higher-order functions and functional composition
  (arg: I) => {
    // Check if we've computed this result before
    if (cache.contains(arg)) {
      // Cache hit: return previously computed result
      // This saves potentially expensive recomputation
      cache(arg)
    } else {
      // Cache miss: compute the result for the first time
      val result = f(arg)
      
      // Store the result for future use
      // This is the "memoization" - remembering past computations
      cache(arg) = result
      result
    }
  }
}

/**
  * Computes the nth Fibonacci number using memoization.
  * The function uses a higher order function `memoize` to cache results of previous computations.
  * 
  * This transforms the naive O(2^n) Fibonacci algorithm into an efficient O(n) solution
  * by ensuring each Fibonacci number is computed only once.
  * 
  * Key insight: Even though this looks like regular recursion (not tail-recursive),
  * memoization makes it efficient because each subproblem is solved only once.
  * 
  * @param n the index of the Fibonacci number to compute
  * @return the nth Fibonacci number
  */
val fibonacciMemoized: BigInt => BigInt = memoize { n =>
  // Base cases: F(0) = 0, F(1) = 1
  if (n == 0) BigInt(0)
  else if (n == 1) BigInt(1)
  // Recursive case: F(n) = F(n-1) + F(n-2)
  // Thanks to memoization, each F(k) is computed only once
  else fibonacciMemoized(n - 1) + fibonacciMemoized(n - 2)
}

/**
 * Main function demonstrating the power of memoization.
 * 
 * Compare the performance:
 * - fibonacciNaive(40) takes seconds and grows exponentially
 * - fibonacciMemoized(40) is nearly instant and scales linearly
 * 
 * This shows how memoization can transform an inefficient algorithm
 * into a practical one without changing the core recursive structure.
 */
@main def runFibonacciMemoized(): Unit = {
  println("Fibonacci numbers 0-14 using memoization:")
  println((0 until 15).map(n => fibonacciMemoized(BigInt(n))))
  
  println("\nTry larger numbers - memoization makes them fast!")
  println(s"F(40) = ${fibonacciMemoized(40)}")
  println(s"F(100) = ${fibonacciMemoized(100)}")
}



