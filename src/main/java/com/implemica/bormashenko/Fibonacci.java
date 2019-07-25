package com.implemica.bormashenko;

import java.math.BigInteger;

/**
 * This utility class contains method that generates
 * required fibonacci's number.
 *
 * @author Mykhailo Bormashenko
 * @since 1.8
 */
public class Fibonacci {

    /**
     * Generates n'th non-negative fibonacci's number.
     * Fibonacci's numbers are numbers from fibonacci sequence such that each
     * number is the sum of the two preceding ones, starting from 0 and 1.
     * Note that this method is not optimized for huge numbers and may work slowly.
     *
     * @param n fibonacci's number to generate.
     * @return value of n'th fibonacci's number.
     * @throws IllegalArgumentException if n is negative.
     */
    public static BigInteger genNFib(int n) {
        if (n < 0) {
            String message = "Expected: non-negative number." + System.lineSeparator() +
                    "Got: " + n;
            throw new IllegalArgumentException(message);
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