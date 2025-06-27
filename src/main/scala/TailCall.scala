/*
 * Tail Call Examples
 * 
 * This file demonstrates the difference between tail calls and non-tail calls.
 * A tail call is when a function call is the very last operation performed
 * before returning. Understanding this concept is crucial for writing
 * efficient recursive functions.
 */

/**
 * Simple function that adds two numbers.
 * This is not recursive, just a helper function for the examples below.
 * 
 * @param x First number
 * @param y Second number
 * @return  Sum of x and y
 */
// no tail call
def f(x: Int, y: Int): Int = {
    x + y
}

/**
 * Example of a TAIL CALL.
 * The call to f(x, y) is the last operation before returning.
 * No further computation happens after f returns.
 * 
 * @param x Input number
 * @return  Result of f(x, 10)
 */
// tail call
def g(x: Int): Int = {
    val y = 10
    
    f(x, y) // This is a tail call - last operation before return
}

/**
 * Example of a NON-TAIL CALL.
 * After f(x, y) returns, we still need to add x to the result.
 * The addition operation happens AFTER the function call returns.
 * 
 * @param y Input number
 * @return  Result of f(5, y) + 5
 */
// no tail call
def h(y: Int): Int = {
    val x = 5
    
    f(x, y) + x // NOT a tail call - we add x after f returns
}

/**
 * Example of a TAIL CALL with nested function calls.
 * Even though h(z + 1) is called first, the final operation
 * is the call to f, making it a tail call.
 * 
 * @param z Input number
 * @return  Result of f(z, h(z + 1))
 */
// tail call
def m(z: Int): Int = {
    f(z, h(z + 1)) // This is a tail call - last operation
}

/**
 * Example of MIXED tail and non-tail calls.
 * In the if branch: f(x, 0) is a tail call
 * In the else branch: the addition happens after f returns, so NOT a tail call
 * 
 * @param x Input number
 * @return  Different computation based on x value
 */
// mixed: tail call and no tail call
def p(x: Int): Int = {
    if (x <= 0) f(x, 0)        // TAIL CALL - last operation in this branch
    else x + f(x - 1, 0)       // NOT TAIL CALL - addition after f returns
}
