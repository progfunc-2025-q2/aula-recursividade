/*
 * Factorial Implementations - Comprehensive Comparison
 * 
 * This file demonstrates four different approaches to computing factorial:
 * 1. Naive recursion (elegant but not optimized)
 * 2. Tail recursion (optimized recursive approach)
 * 3. Imperative loop (traditional procedural approach)
 * 4. Functional loop conversion (imperative logic expressed functionally)
 * 
 * This comparison helps understand the trade-offs between different programming paradigms
 * and optimization techniques in functional programming.
 */
import scala.annotation.tailrec

/**
 * Computes factorial using naive recursion.
 * 
 * This follows the mathematical definition directly: n! = n × (n-1)!
 * While elegant, it's not tail-recursive and can cause stack overflow for large n.
 * 
 * Time complexity: O(n)
 * Space complexity: O(n) due to call stack
 * 
 * @param n the number to compute factorial for (should be >= 0)
 * @return n! (n factorial)
 */
def factorialNaive(n: BigInt): BigInt = {
  // Base case: 0! = 1, 1! = 1
  if (n <= 1) 1
  // Recursive case: n! = n × (n-1)!
  // NOT tail-recursive because multiplication happens after the recursive call
  else n * factorialNaive(n - 1)
}

/**
 * Computes factorial using tail recursion with an accumulator.
 * 
 * This version is optimized by the Scala compiler into a loop, preventing stack overflow.
 * The @tailrec annotation ensures the function is truly tail-recursive.
 * 
 * Time complexity: O(n)
 * Space complexity: O(1) due to tail call optimization
 * 
 * @param n   the number to compute factorial for
 * @param acc the accumulator storing the partial result (default 1)
 * @return n! (n factorial)
 */
@tailrec
def factorialTailRecursive(n: BigInt, acc: BigInt = 1): BigInt = {
    // Base case: when n <= 1, return the accumulated result
    if (n <= 1) acc
    // Recursive case: multiply current n into accumulator and continue with n-1
    // This IS tail-recursive because the recursive call is the last operation
    else factorialTailRecursive(n - 1, acc * n)
}

/**
 * Computes factorial using traditional imperative approach with loops.
 * 
 * This demonstrates how factorial would be computed in procedural languages.
 * While efficient, it uses mutable state and is less "functional" in style.
 * 
 * Time complexity: O(n)
 * Space complexity: O(1)
 * 
 * @param n the number to compute factorial for
 * @return n! (n factorial)
 */
def factorialImperative(n: BigInt): BigInt = {
  // Mutable variables for tracking state
  var result: BigInt = 1
  var i: BigInt = n

  // Traditional while loop with mutable state
  while (i > 1) {
    result *= i  // Accumulate the product
    i -= 1       // Decrement counter
  }
  result
}

/**
 * Computes factorial by converting imperative loop logic to functional recursion.
 * 
 * This shows how to transform imperative algorithms into functional ones
 * while maintaining the same logical structure and efficiency.
 * 
 * Time complexity: O(n)
 * Space complexity: O(1) due to tail call optimization
 * 
 * @param n the number to compute factorial for
 * @return n! (n factorial)
 */
def factorialFromImperative(n: BigInt): BigInt = {
  /**
   * Helper function that mimics the imperative loop using tail recursion.
   * This is equivalent to: for (i = n; i > 1; i--) acc *= i
   * 
   * @param i   current counter value (like loop variable)
   * @param acc accumulator for the result (like result variable)
   * @return final factorial result
   */
  @tailrec
  def loopHelper(i: BigInt, acc: BigInt): BigInt = {
    // Base case: when i <= 1, we've processed all numbers
    if (i <= 1) acc 
    // Recursive case: multiply i into accumulator and continue with i-1
    // This mimics the imperative: acc *= i; i -= 1
    else loopHelper(i - 1, acc * i)
  }
  
  // Start the "loop" with initial values
  loopHelper(n, 1)
}

/**
 * Demonstration function for naive factorial approach.
 * Shows results for small inputs where stack overflow isn't a concern.
 */
def runFactorialNaive(): Unit = {
  println("=== Naive Factorial (Non-Tail Recursive) ===")
  println(s"0! = ${factorialNaive(0)}")   // 1
  println(s"1! = ${factorialNaive(1)}")   // 1
  println(s"5! = ${factorialNaive(5)}")   // 120
  println(s"10! = ${factorialNaive(10)}") // 3628800
  println(s"21! = ${factorialNaive(21)}") // Large number
  // Note: Very large values may cause stack overflow
}

/**
 * Demonstration function for tail recursive factorial approach.
 * Shows the same results but with stack-safe implementation.
 */
def runFactorialTailRecursive(): Unit = {
  println("=== Tail Recursive Factorial (Optimized) ===")
  println(s"0! = ${factorialTailRecursive(0)}")   // 1
  println(s"1! = ${factorialTailRecursive(1)}")   // 1
  println(s"5! = ${factorialTailRecursive(5)}")   // 120
  println(s"10! = ${factorialTailRecursive(10)}") // 3628800
  println(s"21! = ${factorialTailRecursive(21)}") // Large number
  // This version can handle much larger inputs without stack overflow
}

/**
 * Demonstration function for imperative factorial approach.
 * Shows how traditional loop-based computation works.
 */
def runFactorialImperative(): Unit = {
    println("=== Imperative Factorial (Traditional Loop) ===")
    println(s"0! = ${factorialImperative(0)}")   // 1
    println(s"1! = ${factorialImperative(1)}")   // 1
    println(s"5! = ${factorialImperative(5)}")   // 120
    println(s"10! = ${factorialImperative(10)}") // 3628800
    println(s"21! = ${factorialImperative(21)}") // Large number
}

/**
 * Main function demonstrating the functional conversion approach.
 * This shows how to transform imperative algorithms into functional ones.
 */
@main def runFactorialFromImperative(): Unit = {
  println("=== Functional Loop Conversion ===")
  println(s"0! = ${factorialFromImperative(0)}")   // 1
  println(s"1! = ${factorialFromImperative(1)}")   // 1
  println(s"5! = ${factorialFromImperative(5)}")   // 120
  println(s"10! = ${factorialFromImperative(10)}") // 3628800
  println(s"21! = ${factorialFromImperative(21)}") // Large number
}

/**
 * Main function that runs all factorial implementations for comparison.
 * This demonstrates that all approaches produce the same results,
 * but with different performance characteristics and programming styles.
 */
@main def run(): Unit = {
    println("Factorial Implementations Comparison")
    println("=" * 50)
    
    runFactorialNaive()
    println()
    runFactorialTailRecursive()
    println()
    runFactorialImperative()
    println()
    println("All implementations produce identical results!")
    println("Key differences:")
    println("- Naive: Simple but not stack-safe")
    println("- Tail recursive: Functional and stack-safe")
    println("- Imperative: Traditional but uses mutable state")
    println("- Functional conversion: Best of both worlds")
}

