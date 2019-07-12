package com.implemica.bormashenko;

/**
 * This class swaps the value of two variables
 * without using third variable.
 *
 * @author Mykhailo Bormashenko
 */
public class Task1 {

    /**
     * First parameter to swap.
     */
    private int a;
    /**
     * Second parameter to swap.
     */
    private int b;

    /**
     * Setting parameter a.
     * @param a value to set.
     */
    void setA(int a) {
        this.a = a;
    }

    /**
     * Setting parameter b.
     * @param b value to set.
     */
    void setB(int b) {
        this.b = b;
    }

    /**
     * Swaps the value of two variables
     * without using third variable.
     */
    private void swap() {
        a += b;
        b = a - b;
        a -= b;
    }

    /**
     * Swaps the value of two variables
     * without using third variable
     * and prints this process.
     */
    void showSwapping() {
        System.out.println("Before reversing:" + System.lineSeparator() +
                "a: " + a + ", b: " + b);
        swap();
        System.out.println("After reversing:" + System.lineSeparator() +
                "a: " + a + ", b: " + b);
    }
}
