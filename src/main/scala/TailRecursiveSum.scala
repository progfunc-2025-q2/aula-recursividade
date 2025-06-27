/*
 * Tail Recursive Sum Example
 * 
 * This file demonstrates tail recursion optimization in Scala.
 * Tail recursion is a special form of recursion where the recursive call
 * is the last operation in the function, allowing the compiler to optimize
 * it into a loop and avoid stack overflow errors.
 */
package tailrecursivesum

import scala.annotation.tailrec

/**
 * Calculates the sum of integers from 'a' to 'b' using tail recursion.
 * 
 * The @tailrec annotation ensures that this function is tail-recursive.
 * If it's not, the compiler will generate an error.
 * 
 * @param a   The starting number (inclusive)
 * @param b   The ending number (inclusive)
 * @param acc The accumulator that stores the running sum (default 0)
 * @return    The sum of all integers from a to b
 */
@tailrec
def tailRecursiveSum(a: Long, b: Long, acc: Long = 0): Long = {
    // Base case: if a > b, we've processed all numbers, return the accumulator
    if (a > b) acc
    // Recursive case: add current number 'a' to accumulator and continue with a+1
    // This is tail-recursive because the recursive call is the last operation
    else tailRecursiveSum(a + 1, b, acc + a)
}

/**
 * Main function demonstrating the tail recursive sum with various inputs.
 * Large inputs (like 1 to 1,000,000) work without stack overflow because
 * tail recursion is optimized into a loop by the Scala compiler.
 */
@main def run(): Unit = {
    println(tailRecursiveSum(1, 10))      // Output: 55 (sum from 1 to 10)
    println(tailRecursiveSum(5, 15))      // Output: 110 (sum from 5 to 15)
    println(tailRecursiveSum(0, 100))     // Output: 5050 (sum from 0 to 100)
    println(tailRecursiveSum(1, 1_000_000)) // Output: 500000500000 (no stack overflow!)
}