package com.implemica.bormashenko;

/**
 * This class swaps the value of two variables
 * without using third variable.
 *
 * @author Mykhailo Bormashenko
 */
public class Task1 {

    private int a;
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

    public void swap() {
        a += b;
        b = a - b;
        a -= b;
    }

    void showSwapping() {
        System.out.println("Before reversing:" + System.lineSeparator() +
                "a: " + a + ", b: " + b);
        swap();
        System.out.println("After reversing:" + System.lineSeparator() +
                "a: " + a + ", b: " + b);
    }
}
