package com.implemica.bormashenko;

import java.math.BigInteger;

/**
 * This utility class contains method that generates fibonacci's number.
 *
 * @author Mykhailo Bormashenko
 */
public class Task4 {

    /**
     * Generates n'th fibonacci's number.
     * @param n 'th fibonacci's number to generate.
     * @return value of n'th fibonacci's number.
     *
     * @throws IncorrectArgumentException if n is negative.
     */
    public static BigInteger genNFib(int n) {
        if (n < 0) {
            throw new IncorrectArgumentException("Number should be non-negative.");
        }
        if (n == 0) {
            return BigInteger.ZERO;
        }
        if (n == 1) {
            return BigInteger.ONE;
        }
        BigInteger fib1 = BigInteger.ZERO;
        BigInteger fib2 = BigInteger.ONE;
        BigInteger fib3 = BigInteger.ZERO;
        for (int i = 2; i <= n; i++) {
            fib3 = fib1.add(fib2);
            fib1 = fib2;
            fib2 = fib3;
        }
        return fib3;
    }
}