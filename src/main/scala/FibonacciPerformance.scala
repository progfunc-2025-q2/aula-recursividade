/*
 * Fibonacci Performance Comparison - Empirical Analysis
 * 
 * This file provides a comprehensive performance comparison between different
 * Fibonacci implementations. It demonstrates the dramatic differences in
 * algorithmic complexity through actual timing measurements. It is not a 
 * very robust approach, because it runs every instance only once (it would
 * better to run each instance multiple times and average the results).
 * 
 * Educational Value:
 * - Shows real-world impact of algorithmic choices
 * - Demonstrates exponential vs linear growth
 * - Helps students understand Big O notation practically
 * - Compares functional vs imperative approaches
 */
package fibonacciPerformance

// Import all Fibonacci implementations for comparison
import fibonacciNaive.fibonacciNaive
import fibonacciMemoized.fibonacciMemoized
import iterativeFibonacci.fibonacciIterative
import talRecursiveFibonacci.fibonacciTailRecursive as fibonacciTailRecursive
import scala.math.BigInt

/**
 * Utility function to measure execution time of any operation.
 * 
 * This demonstrates higher-order functions and by-name parameters.
 * The `=> T` syntax means the operation is passed by-name, allowing
 * us to measure the time of any code block.
 * 
 * @param operation the code block to time (passed by-name)
 * @return tuple of (result, execution time in nanoseconds)
 */
def time[T](operation: => T): (T, Long) = {
  val start = System.nanoTime()    // Record start time
  val result = operation           // Execute the operation
  val end = System.nanoTime()      // Record end time
  (result, end - start)            // Return result and elapsed time
}

/**
 * Formats nanoseconds into human-readable time units.
 * 
 * This helper function makes performance results easier to interpret
 * by automatically choosing appropriate units (ns, μs, ms, s).
 * 
 * @param nanos execution time in nanoseconds
 * @return formatted string with appropriate time unit
 */
def formatTime(nanos: Long): String = {
  if (nanos < 1000) s"${nanos}ns"                    // Less than 1 microsecond
  else if (nanos < 1000000) s"${nanos / 1000}μs"     // Less than 1 millisecond
  else if (nanos < 1000000000) s"${nanos / 1000000}ms" // Less than 1 second
  else s"${nanos / 1000000000}s"                     // 1 second or more
}

/**
 * Performs a comprehensive performance comparison for a given Fibonacci number.
 * 
 * This function demonstrates the dramatic performance differences between
 * algorithms with different time complexities:
 * - Naive: O(2^n) - exponential growth, becomes impractical quickly
 * - Memoized: O(n) - linear growth, efficient for all practical inputs
 * - Tail Recursive: O(n) - linear growth, functional and efficient
 * - Iterative: O(n) - linear growth, imperative but very fast
 * 
 * @param n the Fibonacci number to compute and compare
 */
def performanceComparison(n: Int): Unit = {
  println(s"\n=== Performance Comparison for Fibonacci($n) ===")
  
  // Test naive approach (only for small values due to exponential complexity)
  if (n <= 35) {
    val (naiveResult, naiveTime) = time(fibonacciNaive(BigInt(n)))
    println(s"Naive Recursive: $naiveResult (${formatTime(naiveTime)})")
  } else {
    println(s"Naive Recursive: Skipped (too slow for n=$n)")
  }
  
  // Test memoized approach - efficient for all practical inputs
  val (memoizedResult, memoizedTime) = time(fibonacciMemoized(BigInt(n)))
  println(s"Memoized:        $memoizedResult (${formatTime(memoizedTime)})")
  
  // Test tail recursive approach - functional and efficient
  val (tailRecResult, tailRecTime) = time(fibonacciTailRecursive(n))
  println(s"Tail Recursive:  $tailRecResult (${formatTime(tailRecTime)})")
  
  // Test iterative approach - imperative but very efficient
  val (iterativeResult, iterativeTime) = time(fibonacciIterative(BigInt(n)))
  println(s"Iterative:       $iterativeResult (${formatTime(iterativeTime)})")
  
  println()
}

/**
 * Main function that runs comprehensive performance analysis.
 * 
 * This demonstrates:
 * 1. How algorithmic complexity affects real performance
 * 2. The trade-offs between different programming paradigms
 * 3. Why optimization techniques like memoization matter
 * 4. When functional approaches can match imperative performance
 * 
 * Educational insights:
 * - Exponential algorithms become impractical very quickly
 * - Memoization can transform bad algorithms into good ones
 * - Tail recursion achieves imperative-level performance functionally
 * - All optimized approaches produce identical results
 */
@main def runPerformanceComparison(): Unit = {
  println("Fibonacci Performance Comparison")
  println("=" * 40)
  println("This analysis shows the real-world impact of algorithmic choices!")
  
  // Test with small values - all algorithms can handle these
  println("\n=== Small Numbers (All Methods Work) ===")
  List(10, 20, 30, 35).foreach(performanceComparison)
  
  // Test with moderate values - naive becomes very slow
  println("\n=== Moderate Numbers (Naive Becomes Slow) ===")
  List(40, 45).foreach { n =>
    println(s"\nFibonacci($n):")
    
    // Warn about naive performance
    println("Testing naive recursive (this may take a while)...")
    val (naiveResult, naiveTime) = time(fibonacciNaive(BigInt(n)))
    println(s"Naive:     $naiveResult (${formatTime(naiveTime)})")
    
    // Test optimized approaches
    val (memoizedResult, memoizedTime) = time(fibonacciMemoized(BigInt(n)))
    println(s"Memoized:  $memoizedResult (${formatTime(memoizedTime)})")
    
    val (tailRecResult, tailRecTime) = time(fibonacciTailRecursive(n))
    println(s"Tail Rec:  $tailRecResult (${formatTime(tailRecTime)})")
    
    val (iterativeResult, iterativeTime) = time(fibonacciIterative(BigInt(n)))
    println(s"Iterative: $iterativeResult (${formatTime(iterativeTime)})")
    
    // Verify correctness - all methods should produce same result
    if (naiveResult == memoizedResult && memoizedResult == tailRecResult && tailRecResult == iterativeResult) {
      println("✓ All results match")
    } else {
      println("✗ Results differ!")
    }
  }
  
  // Test with very large values - only optimized approaches work
  println("\n=== Large Numbers (Only Optimized Methods) ===")
  List(50, 100, 500, 1000).foreach { n =>
    println(s"\nFibonacci($n):")
    println("Naive recursive: Skipped (would take hours/days)")
    
    // Compare optimized approaches
    val (memoizedResult, memoizedTime) = time(fibonacciMemoized(BigInt(n)))
    println(s"Memoized:  ${formatTime(memoizedTime)}")
    
    val (tailRecResult, tailRecTime) = time(fibonacciTailRecursive(n))
    println(s"Tail Rec:  ${formatTime(tailRecTime)}")
    
    val (iterativeResult, iterativeTime) = time(fibonacciIterative(BigInt(n)))
    println(s"Iterative: ${formatTime(iterativeTime)}")
    
    // Verify correctness
    if (memoizedResult == tailRecResult && tailRecResult == iterativeResult) {
      println("✓ Results match")
    } else {
      println("✗ Results differ!")
    }
  }
  
  // Educational summary
  println("\n" + "=" * 50)
  println("KEY INSIGHTS:")
  println("- Naive O(2^n): Becomes impractical around F(40)")
  println("- Memoized O(n): Transforms bad algorithm into good one")
  println("- Tail Recursive O(n): Functional style with imperative performance")
  println("- Iterative O(n): Traditional approach, still very efficient")
  println("- All optimized methods produce identical results")
  println("- Choice depends on style preference, not performance")
}



