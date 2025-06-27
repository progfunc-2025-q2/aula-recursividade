/*
 * Comprehensive Tail Recursion Examples
 * 
 * This file contains multiple examples comparing tail-recursive and
 * non-tail-recursive implementations of common algorithms. Each pair
 * demonstrates the same computation using both approaches.
 */
package RecursiveTailCall

object RecursiveTailCall {

  /**
   * Fibonacci sequence using regular (non-tail) recursion.
   * This is inefficient because it recalculates the same values multiple times
   * and is not tail-recursive, so it will stack overflow for large n.
   * 
   * @param n The position in the Fibonacci sequence
   * @return  The nth Fibonacci number
   */
  // Not tail recursive
  def a(n: Int): Int =
    if (n <= 1) n
    else a(n - 1) + a(n - 2) // Two recursive calls + addition after = NOT tail recursive

  /**
   * Fibonacci sequence using tail recursion with accumulators.
   * This is much more efficient and stack-safe because it uses tail recursion
   * and calculates each value only once.
   * 
   * @param n Current countdown (positions remaining)
   * @param x Previous Fibonacci number (accumulator)
   * @param y Current Fibonacci number (accumulator)
   * @return  The nth Fibonacci number
   */
  // Tail recursive
  def b(n: Int, x: Int = 0, y: Int = 1): Int =
    if (n == 0) x
    else b(n - 1, y, x + y) // Single recursive call as last operation = tail recursive

  /**
   * Exponentiation using regular (non-tail) recursion.
   * Calculates x^n by multiplying x by the result of x^(n-1).
   * Not tail-recursive because multiplication happens after the recursive call.
   * 
   * @param x The base
   * @param n The exponent
   * @return  x raised to the power of n
   */
  // Not tail recursive
  def c(x: Int, n: Int): Int =
    if (n == 0) 1
    else x * c(x, n - 1) // Multiplication after recursive call = NOT tail recursive

  /**
   * Exponentiation using tail recursion with an accumulator.
   * Calculates x^n by building up the result in the accumulator.
   * Tail-recursive and more efficient for large exponents.
   * 
   * @param x   The base
   * @param n   The exponent (countdown)
   * @param acc The accumulator storing the current result
   * @return    x raised to the power of n
   */
  // Tail recursive
  def d(x: Int, n: Int, acc: Int = 1): Int =
    if (n == 0) acc
    else d(x, n - 1, acc * x) // Recursive call as last operation = tail recursive

  /**
   * Function with two tail recursive cases.
   * Demonstrates that a function can have multiple recursive calls
   * and still be tail-recursive if each call is the last operation
   * in its respective branch.
   * 
   * @param n   Input number (countdown)
   * @param acc Accumulator for the result
   * @return    Computed result based on even/odd logic
   */
  // Modified: two tail recursive cases
  def e(n: Int, acc: Int = 0): Int =
    if (n == 0) acc
    else if (n % 2 == 0) e(n / 2, acc + n)    // Tail recursive - call is last operation
    else e(n - 1, acc + 1)                    // Tail recursive - call is last operation

  /**
   * Function with mixed tail and non-tail recursive cases.
   * Shows that a function can have some branches that are tail-recursive
   * and others that are not. The function as a whole is NOT tail-recursive
   * because at least one path is not tail-recursive.
   * 
   * @param n   Input number
   * @param acc Accumulator for partial results
   * @return    Computed result
   */
  // f: two recursive cases, one tail recursive, one not
  def f(n: Int, acc: Int = 0): Int =
    if (n <= 0) acc
    else if (n % 2 == 0) f(n - 1, acc + n)    // Tail recursive
    else n + f(n - 2, acc)                    // NOT tail recursive - addition after call

  /**
   * Main function demonstrating all the recursive functions above.
   * Shows the results of both tail-recursive and non-tail-recursive
   * implementations for comparison.
   */
  @main def run(): Unit = {
    println(s"a(7) = ${a(7)}")           // Fibonacci (non-tail): slow for large inputs
    println(s"b(7) = ${b(7)}")           // Fibonacci (tail): efficient for large inputs
    println(s"c(2, 5) = ${c(2, 5)}")     // Exponentiation (non-tail): 2^5 = 32
    println(s"d(2, 5) = ${d(2, 5)}")     // Exponentiation (tail): 2^5 = 32
    println(s"e(12345) = ${e(12345)}")   // Two tail-recursive cases
    println(s"f(10) = ${f(10)}")         // Mixed tail/non-tail recursive
  }
}

