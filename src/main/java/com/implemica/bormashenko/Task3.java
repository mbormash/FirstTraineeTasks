package com.implemica.bormashenko;
import static java.lang.Integer.MIN_VALUE;

/**
 * This utility class finds gcd of 4 numbers.
 */
public class Task3 {

    /**
     * Defines greatest common divisor for two numbers.
     * @param a first number.
     * @param b second number.
     * @return greatest common divisor for these numbers.
     *
     * @throws IncorrectArgumentException if at least one number is Integer.MIN_VALUE.
     */
    private static int nod2args(int a, int b) {
        if (a == MIN_VALUE || b == MIN_VALUE) {
            throw new IncorrectArgumentException("Number should be not less than " + (MIN_VALUE + 1));
        }
        int x = Math.abs(a);
        int y = Math.abs(b);

        if (x == 0 || y == 0) {
            return 0;
        }
        if (x == 1 || y == 1) {
            return 1;
        }
        if (x == y) {
            return x;
        }

        while (x != 0 && y != 0) {
            if (x > y) {
                x = x % y;
            } else {
                y = y % x;
            }
        }
        return x + y;
    }

    /**
     * Defines greatest common divisor for 4 numbers.
     * @param a first number.
     * @param b second number.
     * @param c third number.
     * @param d fourth number.
     * @return greatest common divisor for these numbers.
     *
     * @throws IncorrectArgumentException if at least one number is Integer.MIN_VALUE.
     */
    public static int nod4args(int a, int b, int c, int d) {
        int nodAB = nod2args(a, b);
        int nodCD = nod2args(c, d);
        return nod2args(nodAB, nodCD);
    }
}
