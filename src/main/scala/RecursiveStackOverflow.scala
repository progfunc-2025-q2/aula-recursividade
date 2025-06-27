/*
 * Stack Overflow Demonstration
 * 
 * This file demonstrates what happens when non-tail recursive functions
 * are called with large inputs. It shows the practical difference between
 * regular recursion and tail recursion in terms of stack usage.
 */
package recursivestackoverflow

import recursivesum.recursiveSum

/**
 * Main function that demonstrates stack overflow with regular recursion.
 * 
 * The recursiveSum function from the recursivesum package uses regular
 * (non-tail) recursion, which builds up the call stack. When we try to
 * sum from 1 to 1,000,000, the stack grows too large and overflows.
 * 
 * This is a practical example of why tail recursion is important for
 * functions that might be called with large inputs.
 */
@main def run(): Unit = {
    try {
        // This will likely cause a StackOverflowError because recursiveSum
        // is not tail-recursive and 1,000,000 recursive calls exceed
        // the JVM's default stack size (usually around 1000-8000 frames)
        println(recursiveSum(1, 1_000_000))
    } catch {
        // Catch and handle the expected StackOverflowError
        case e: StackOverflowError => {
            println("Stack overflow occurred")
            println("This demonstrates why tail recursion is important!")
            println("Compare this with tailRecursiveSum - it won't overflow.")
        }
    }
}