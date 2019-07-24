package com.implemica.bormashenko;

/**
 * This class swaps the value of two variables
 * without using third variable.
 *
 * @author Mykhailo Bormashenko
 */
public class Swap {

    /**
     * First parameter.
     */
    private int a;

    /**
     * Second parameter.
     */
    private int b;

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    /**
     * Swaps values of two parameters without using the third one.
     */
    private void swap() {
        a += b;
        b = a - b;
        a -= b;
    }

    /**
     * Shows the process of swapping.
     */
    public String showSwapping() {
        String ls = System.lineSeparator();

        String before = "Before reversing:" + ls +
                "a: " + a + ", b: " + b;
        swap();
        String after = "After reversing:" + ls +
                "a: " + a + ", b: " + b;

        return before + ls + after;
    }
}
