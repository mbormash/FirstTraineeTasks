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
    public void setA(int a) {
        this.a = a;
    }

    /**
     * Setting parameter b.
     * @param b value to set.
     */
    public void setB(int b) {
        this.b = b;
    }

    /**
     * Getting parameter a.
     * @return value of a.
     */
    public int getA() {
        return a;
    }

    /**
     * Getting parameter b.
     * @return value of b.
     */
    public int getB() {
        return b;
    }

    /**
     * Swaps the value of two variables
     * without using third variable.
     */
    public void swap() {
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
                "a: " + getA() + ", b: " + getB());
        swap();
        System.out.println("After reversing:" + System.lineSeparator() +
                "a: " + getA() + ", b: " + getB());
    }
}
