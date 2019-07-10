import com.implemica.bormashenko.IncorrectArgumentException;
import com.implemica.bormashenko.IntegerOverflowException;
import com.implemica.bormashenko.Task2;
import org.junit.jupiter.api.Test;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;
import static java.lang.String.valueOf;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Task2 (flats).
 *
 * @author Mykhailo Bormashenko
 */
class Task2Test {

    /**
     * Value of sqrt of Integer.MAX_VALUE, converted to int.
     */
    private static final int SQRT_MAX = (int)Math.sqrt(MAX_VALUE);

    /**
     * Tests with valid args for task2 (flats).
     * 21 tests for 5-floors and 4-flats-on-floor house;
     * 29 tests for 9-floors and 4-flats-on-floor house;
     * 43 tests for 16-floors and 4-flats-on-floor house;
     * 4 tests for number of flat more than (flats on floor * floors);
     * 4 tests for number of flat equals (flats on floor * floors);
     * 4 tests for number of flat more than flats on floor;
     * 4 tests for number of flat equals flats on floor;
     * 2 tests for max value of house returned;
     * 10 tests for floors * flats = MAX;
     * 45 tests for floors * flat = near to MAX;
     * 400 tests for all flats in first 4 houses of 1-2-3-4-flats-on-floor 1-2-3-4-floors house;
     * 566 tests at all.
     */
    @Test
    void validArgsTests() {
        //5 floors and 4 flats on floor
        //1, 1 expected
        check(5, 4, 1, "1", "1");
        check(5, 4, 2, "1", "1");
        check(5, 4, 3, "1", "1");
        check(5, 4, 4, "1", "1");
        //1, 2 expected
        check(5, 4, 5, "1", "2");
        check(5, 4, 8, "1", "2");
        //1, 3 expected
        check(5, 4, 9, "1", "3");
        check(5, 4, 12, "1", "3");
        //1, 4 expected
        check(5, 4, 13, "1", "4");
        check(5, 4, 16, "1", "4");
        //1, 5 expected
        check(5, 4, 17, "1", "5");
        check(5, 4, 18, "1", "5");
        check(5, 4, 19, "1", "5");
        check(5, 4, 20, "1", "5");
        //2, 1 expected
        check(5, 4, 21, "2", "1");
        //2, 5 expected
        check(5, 4, 40, "2", "5");
        //3, 1expected
        check(5, 4, 41, "3", "1");
        //3, 5 expected
        check(5, 4, 60, "3", "5");
        //4, 1 expected
        check(5, 4, 61, "4", "1");
        //4, 5 expected
        check(5, 4, 80, "4", "5");
        //5, 1 expected
        check(5, 4, 81, "5", "1");

        //9 floors and 4 flats on floor
        //1, 1 expected
        check(9, 4, 1, "1", "1");
        check(9, 4, 2, "1", "1");
        check(9, 4, 3, "1", "1");
        check(9, 4, 4, "1", "1");
        //1, 2 expected
        check(9, 4, 5, "1", "2");
        check(9, 4, 8, "1", "2");
        //1, 3 expected
        check(9, 4, 9, "1", "3");
        check(9, 4, 12, "1", "3");
        //1, 4 expected
        check(9, 4, 13, "1", "4");
        check(9, 4, 16, "1", "4");
        //1, 5 expected
        check(9, 4, 17, "1", "5");
        check(9, 4, 20, "1", "5");
        //1, 6 expected
        check(9, 4, 21, "1", "6");
        check(9, 4, 24, "1", "6");
        //1, 7 expected
        check(9, 4, 25, "1", "7");
        check(9, 4, 28, "1", "7");
        //1, 8 expected
        check(9, 4, 29, "1", "8");
        check(9, 4, 32, "1", "8");
        //1, 9 expected
        check(9, 4, 33, "1", "9");
        check(9, 4, 34, "1", "9");
        check(9, 4, 35, "1", "9");
        check(9, 4, 36, "1", "9");
        //2, 1 expected
        check(9, 4, 37, "2", "1");
        //2, 9 expected
        check(9, 4, 72, "2", "9");
        //3, 1 expected
        check(9, 4, 73, "3", "1");
        //3, 9 expected
        check(9, 4, 108, "3", "9");
        //4, 1 expected
        check(9, 4, 109, "4", "1");
        //4, 9 expected
        check(9, 4, 144, "4", "9");
        //5, 1 expected
        check(9, 4, 145, "5", "1");

        //16 floors and 4 flats on floor
        //1, 1 expected
        check(16, 4, 1, "1", "1");
        check(16, 4, 2, "1", "1");
        check(16, 4, 3, "1", "1");
        check(16, 4, 4, "1", "1");
        //1, 2 expected
        check(16, 4, 5, "1", "2");
        check(16, 4, 8, "1", "2");
        //1, 3 expected
        check(16, 4, 9, "1", "3");
        check(16, 4, 12, "1", "3");
        //1, 4 expected
        check(16, 4, 13, "1", "4");
        check(16, 4, 16, "1", "4");
        //1, 5 expected
        check(16, 4, 17, "1", "5");
        check(16, 4, 20, "1", "5");
        //1, 6 expected
        check(16, 4, 21, "1", "6");
        check(16, 4, 24, "1", "6");
        //1, 7 expected
        check(16, 4, 25, "1", "7");
        check(16, 4, 28, "1", "7");
        //1, 8 expected
        check(16, 4, 29, "1", "8");
        check(16, 4, 32, "1", "8");
        //1, 9 expected
        check(16, 4, 33, "1", "9");
        check(16, 4, 36, "1", "9");
        //1, 10 expected
        check(16, 4, 37, "1", "10");
        check(16, 4, 40, "1", "10");
        //1, 11 expected
        check(16, 4, 41, "1", "11");
        check(16, 4, 44, "1", "11");
        //1, 12 expected
        check(16, 4, 45, "1", "12");
        check(16, 4, 48, "1", "12");
        //1, 13 expected
        check(16, 4, 49, "1", "13");
        check(16, 4, 52, "1", "13");
        //1, 14 expected
        check(16, 4, 53, "1", "14");
        check(16, 4, 56, "1", "14");
        //1, 15 expected
        check(16, 4, 57, "1", "15");
        check(16, 4, 60, "1", "15");
        //1, 16 expected
        check(16, 4, 61, "1", "16");
        check(16, 4, 62, "1", "16");
        check(16, 4, 63, "1", "16");
        check(16, 4, 64, "1", "16");
        //2, 1 expected
        check(16, 4, 65, "2", "1");
        //2, 16 expected
        check(16, 4, 128, "2", "16");
        //3, 1expected
        check(16, 4, 129, "3", "1");
        //3, 16 expected
        check(16, 4, 192, "3", "16");
        //4, 1 expected
        check(16, 4, 193, "4", "1");
        //4, 16 expected
        check(16, 4, 256, "4", "16");
        //5, 1 expected
        check(16, 4, 257, "5", "1");

        //number of flat more than (flats on floor * floors)
        check(10, 4, 41, "2", "1");
        check(10, 6, 67, "2", "2");
        check(16, 4, 70, "2", "2");
        check(9, 4, 120, "4", "3");
        //number of flat equals (flats on floor * floors)
        check(10, 4, 40, "1", "10");
        check(10, 6, 60, "1", "10");
        check(16, 4, 64, "1", "16");
        check(9, 4, 36, "1", "9");
        //number of flat more than flats on floor
        check(10, 4, 5, "1", "2");
        check(10, 6, 7, "1", "2");
        check(16, 4, 12, "1", "3");
        check(9, 4, 16, "1", "4");
        //number of flat equals flats on floor
        check(10, 4, 4, "1", "1");
        check(10, 6, 6, "1", "1");
        check(16, 4, 4, "1", "1");
        check(9, 4, 4, "1", "1");

        //max value of house returned
        check(1, 1, MAX_VALUE, String.valueOf(MAX_VALUE), "1");
        check(1, 1, MAX_VALUE - 1, String.valueOf(MAX_VALUE - 1), "1");

        //floors * flats = MAX
        check(1, MAX_VALUE, 1, "1", "1");
        check(1, MAX_VALUE, 2, "1", "1");
        check(1, MAX_VALUE, MAX_VALUE / 2, "1", "1");
        check(1, MAX_VALUE, MAX_VALUE - 1, "1", "1");
        check(1, MAX_VALUE, MAX_VALUE, "1", "1");

        check(MAX_VALUE, 1, 1, "1", "1");
        check(MAX_VALUE, 1, 2, "1", "2");
        check(MAX_VALUE, 1, MAX_VALUE / 2, "1", valueOf(MAX_VALUE / 2));
        check(MAX_VALUE, 1, MAX_VALUE - 1, "1", valueOf(MAX_VALUE - 1));
        check(MAX_VALUE, 1, MAX_VALUE, "1", valueOf(MAX_VALUE));

        //floors * flat = near to MAX
        check(1, MAX_VALUE - 1, 1, "1", "1");
        check(1, MAX_VALUE - 1, 2, "1", "1");
        check(1, MAX_VALUE - 1, MAX_VALUE / 2, "1", "1");
        check(1, MAX_VALUE - 1, MAX_VALUE - 1, "1", "1");
        check(1, MAX_VALUE - 1, MAX_VALUE, "2", "1");

        check(MAX_VALUE - 1, 1, 1, "1", "1");
        check(MAX_VALUE - 1, 1, 2, "1", "2");
        check(MAX_VALUE - 1, 1, MAX_VALUE / 2, "1", valueOf(MAX_VALUE / 2));
        check(MAX_VALUE - 1, 1, MAX_VALUE - 1, "1", valueOf(MAX_VALUE - 1));
        check(MAX_VALUE - 1, 1, MAX_VALUE, "2", "1");

        check(2, MAX_VALUE / 2, 1, "1", "1");
        check(2, MAX_VALUE / 2, 2, "1", "1");
        check(2, MAX_VALUE / 2, MAX_VALUE / 2, "1", "1");
        check(2, MAX_VALUE / 2, MAX_VALUE - 1, "1", "2");
        check(2, MAX_VALUE / 2, MAX_VALUE, "2", "1");

        check(MAX_VALUE / 2, 2, 1, "1", "1");
        check(MAX_VALUE / 2, 2, 2, "1", "1");
        check(MAX_VALUE / 2, 2, MAX_VALUE / 2, "1", valueOf((MAX_VALUE / 4) + 1));
        check(MAX_VALUE / 2, 2, MAX_VALUE - 1, "1", valueOf(MAX_VALUE / 2));
        check(MAX_VALUE / 2, 2, MAX_VALUE, "2", "1");

        check(10, MAX_VALUE / 10, 1, "1", "1");
        check(10, MAX_VALUE / 10, 2, "1", "1");
        check(10, MAX_VALUE / 10, MAX_VALUE / 2, "1", "6");
        check(10, MAX_VALUE / 10, MAX_VALUE - 1, "2", "1");
        check(10, MAX_VALUE / 10, MAX_VALUE, "2", "1");

        check(MAX_VALUE / 10, 10, 1, "1", "1");
        check(MAX_VALUE / 10, 10, 2, "1", "1");
        check(MAX_VALUE / 10, 10, MAX_VALUE / 2, "1", valueOf((MAX_VALUE / 20) + 1));
        check(MAX_VALUE / 10, 10, MAX_VALUE - 1, "2", "1");
        check(MAX_VALUE / 10, 10, MAX_VALUE, "2", "1");

        check(100, MAX_VALUE / 100, 1, "1", "1");
        check(100, MAX_VALUE / 100, 2, "1", "1");
        check(100, MAX_VALUE / 100, MAX_VALUE / 2, "1",  "51");
        check(100, MAX_VALUE / 100, MAX_VALUE - 1, "2", "1");
        check(100, MAX_VALUE / 100, MAX_VALUE, "2", "1");

        check(MAX_VALUE / 100, 100, 1, "1", "1");
        check(MAX_VALUE / 100, 100, 2, "1", "1");
        check(MAX_VALUE / 100, 100, MAX_VALUE / 2, "1", valueOf((MAX_VALUE / 200) + 1));
        check(MAX_VALUE / 100, 100, MAX_VALUE - 1, "2", "1");
        check(MAX_VALUE / 100, 100, MAX_VALUE, "2", "1");

        check(SQRT_MAX, SQRT_MAX, 1, "1", "1");
        check(SQRT_MAX, SQRT_MAX, 2, "1", "1");
        check(SQRT_MAX, SQRT_MAX, MAX_VALUE / 2, "1", valueOf(((MAX_VALUE / 2) / SQRT_MAX) + 1));
        check(SQRT_MAX, SQRT_MAX, MAX_VALUE - 1, "2", "2");
        check(SQRT_MAX, SQRT_MAX, MAX_VALUE, "2", "2");

        //1 flat on floor
        //1st house expected
        check(1, 1, 1, "1", "1");
        check(2, 1, 1, "1", "1");
        check(2, 1, 2, "1", "2");
        check(3, 1, 1, "1", "1");
        check(3, 1, 2, "1", "2");
        check(3, 1, 3, "1", "3");
        check(4, 1, 1, "1", "1");
        check(4, 1, 2, "1", "2");
        check(4, 1, 3, "1", "3");
        check(4, 1, 4, "1", "4");
        //2nd house expected
        check(1, 1, 2, "2", "1");
        check(2, 1, 3, "2", "1");
        check(2, 1, 4, "2", "2");
        check(3, 1, 4, "2", "1");
        check(3, 1, 5, "2", "2");
        check(3, 1, 6, "2", "3");
        check(4, 1, 5, "2", "1");
        check(4, 1, 6, "2", "2");
        check(4, 1, 7, "2", "3");
        check(4, 1, 8, "2", "4");
        //3rd house expected
        check(1, 1, 3, "3", "1");
        check(2, 1, 5, "3", "1");
        check(2, 1, 6, "3", "2");
        check(3, 1, 7, "3", "1");
        check(3, 1, 8, "3", "2");
        check(3, 1, 9, "3", "3");
        check(4, 1, 9, "3", "1");
        check(4, 1, 10, "3", "2");
        check(4, 1, 11, "3", "3");
        check(4, 1, 12, "3", "4");
        //4th house expected
        check(1, 1, 4, "4", "1");
        check(2, 1, 7, "4", "1");
        check(2, 1, 8, "4", "2");
        check(3, 1, 10, "4", "1");
        check(3, 1, 11, "4", "2");
        check(3, 1, 12, "4", "3");
        check(4, 1, 13, "4", "1");
        check(4, 1, 14, "4", "2");
        check(4, 1, 15, "4", "3");
        check(4, 1, 16, "4", "4");

        //2 flats on floor
        //1st house expected
        check(1, 2, 1, "1", "1");
        check(1, 2, 2, "1", "1");
        check(2, 2, 1, "1", "1");
        check(2, 2, 2, "1", "1");
        check(2, 2, 3, "1", "2");
        check(2, 2, 4, "1", "2");
        check(3, 2, 1, "1", "1");
        check(3, 2, 2, "1", "1");
        check(3, 2, 3, "1", "2");
        check(3, 2, 4, "1", "2");
        check(3, 2, 5, "1", "3");
        check(3, 2, 6, "1", "3");
        check(4, 2, 1, "1", "1");
        check(4, 2, 2, "1", "1");
        check(4, 2, 3, "1", "2");
        check(4, 2, 4, "1", "2");
        check(4, 2, 5, "1", "3");
        check(4, 2, 6, "1", "3");
        check(4, 2, 7, "1", "4");
        check(4, 2, 8, "1", "4");
        //2nd house expected
        check(1, 2, 3, "2", "1");
        check(1, 2, 4, "2", "1");
        check(2, 2, 5, "2", "1");
        check(2, 2, 6, "2", "1");
        check(2, 2, 7, "2", "2");
        check(2, 2, 8, "2", "2");
        check(3, 2, 7, "2", "1");
        check(3, 2, 8, "2", "1");
        check(3, 2, 9, "2", "2");
        check(3, 2, 10, "2", "2");
        check(3, 2, 11, "2", "3");
        check(3, 2, 12, "2", "3");
        check(4, 2, 9, "2", "1");
        check(4, 2, 10, "2", "1");
        check(4, 2, 11, "2", "2");
        check(4, 2, 12, "2", "2");
        check(4, 2, 13, "2", "3");
        check(4, 2, 14, "2", "3");
        check(4, 2, 15, "2", "4");
        check(4, 2, 16, "2", "4");
        //3rd house expected
        check(1, 2, 5, "3", "1");
        check(1, 2, 6, "3", "1");
        check(2, 2, 9, "3", "1");
        check(2, 2, 10, "3", "1");
        check(2, 2, 11, "3", "2");
        check(2, 2, 12, "3", "2");
        check(3, 2, 13, "3", "1");
        check(3, 2, 14, "3", "1");
        check(3, 2, 15, "3", "2");
        check(3, 2, 16, "3", "2");
        check(3, 2, 17, "3", "3");
        check(3, 2, 18, "3", "3");
        check(4, 2, 17, "3", "1");
        check(4, 2, 18, "3", "1");
        check(4, 2, 19, "3", "2");
        check(4, 2, 20, "3", "2");
        check(4, 2, 21, "3", "3");
        check(4, 2, 22, "3", "3");
        check(4, 2, 23, "3", "4");
        check(4, 2, 24, "3", "4");
        //4th house expected
        check(1, 2, 7, "4", "1");
        check(1, 2, 8, "4", "1");
        check(2, 2, 13, "4", "1");
        check(2, 2, 14, "4", "1");
        check(2, 2, 15, "4", "2");
        check(2, 2, 16, "4", "2");
        check(3, 2, 19, "4", "1");
        check(3, 2, 20, "4", "1");
        check(3, 2, 21, "4", "2");
        check(3, 2, 22, "4", "2");
        check(3, 2, 23, "4", "3");
        check(3, 2, 24, "4", "3");
        check(4, 2, 25, "4", "1");
        check(4, 2, 26, "4", "1");
        check(4, 2, 27, "4", "2");
        check(4, 2, 28, "4", "2");
        check(4, 2, 29, "4", "3");
        check(4, 2, 30, "4", "3");
        check(4, 2, 31, "4", "4");
        check(4, 2, 32, "4", "4");

        //3 flats on floor
        //1st house expected
        check(1, 3, 1, "1", "1");
        check(1, 3, 2, "1", "1");
        check(1, 3, 3, "1", "1");
        check(2, 3, 1, "1", "1");
        check(2, 3, 2, "1", "1");
        check(2, 3, 3, "1", "1");
        check(2, 3, 4, "1", "2");
        check(2, 3, 5, "1", "2");
        check(2, 3, 6, "1", "2");
        check(3, 3, 1, "1", "1");
        check(3, 3, 2, "1", "1");
        check(3, 3, 3, "1", "1");
        check(3, 3, 4, "1", "2");
        check(3, 3, 5, "1", "2");
        check(3, 3, 6, "1", "2");
        check(3, 3, 7, "1", "3");
        check(3, 3, 8, "1", "3");
        check(3, 3, 9, "1", "3");
        check(4, 3, 1, "1", "1");
        check(4, 3, 2, "1", "1");
        check(4, 3, 3, "1", "1");
        check(4, 3, 4, "1", "2");
        check(4, 3, 5, "1", "2");
        check(4, 3, 6, "1", "2");
        check(4, 3, 7, "1", "3");
        check(4, 3, 8, "1", "3");
        check(4, 3, 9, "1", "3");
        check(4, 3, 10, "1", "4");
        check(4, 3, 11, "1", "4");
        check(4, 3, 12, "1", "4");
        //2nd house expected
        check(1, 3, 4, "2", "1");
        check(1, 3, 5, "2", "1");
        check(1, 3, 6, "2", "1");
        check(2, 3, 7, "2", "1");
        check(2, 3, 8, "2", "1");
        check(2, 3, 9, "2", "1");
        check(2, 3, 10, "2", "2");
        check(2, 3, 11, "2", "2");
        check(2, 3, 12, "2", "2");
        check(3, 3, 10, "2", "1");
        check(3, 3, 11, "2", "1");
        check(3, 3, 12, "2", "1");
        check(3, 3, 13, "2", "2");
        check(3, 3, 14, "2", "2");
        check(3, 3, 15, "2", "2");
        check(3, 3, 16, "2", "3");
        check(3, 3, 17, "2", "3");
        check(3, 3, 18, "2", "3");
        check(4, 3, 13, "2", "1");
        check(4, 3, 14, "2", "1");
        check(4, 3, 15, "2", "1");
        check(4, 3, 16, "2", "2");
        check(4, 3, 17, "2", "2");
        check(4, 3, 18, "2", "2");
        check(4, 3, 19, "2", "3");
        check(4, 3, 20, "2", "3");
        check(4, 3, 21, "2", "3");
        check(4, 3, 22, "2", "4");
        check(4, 3, 23, "2", "4");
        check(4, 3, 24, "2", "4");
        //3rd house expected
        check(1, 3, 7, "3", "1");
        check(1, 3, 8, "3", "1");
        check(1, 3, 9, "3", "1");
        check(2, 3, 13, "3", "1");
        check(2, 3, 14, "3", "1");
        check(2, 3, 15, "3", "1");
        check(2, 3, 16, "3", "2");
        check(2, 3, 17, "3", "2");
        check(2, 3, 18, "3", "2");
        check(3, 3, 19, "3", "1");
        check(3, 3, 20, "3", "1");
        check(3, 3, 21, "3", "1");
        check(3, 3, 22, "3", "2");
        check(3, 3, 23, "3", "2");
        check(3, 3, 24, "3", "2");
        check(3, 3, 25, "3", "3");
        check(3, 3, 26, "3", "3");
        check(3, 3, 27, "3", "3");
        check(4, 3, 25, "3", "1");
        check(4, 3, 26, "3", "1");
        check(4, 3, 27, "3", "1");
        check(4, 3, 28, "3", "2");
        check(4, 3, 29, "3", "2");
        check(4, 3, 30, "3", "2");
        check(4, 3, 31, "3", "3");
        check(4, 3, 32, "3", "3");
        check(4, 3, 33, "3", "3");
        check(4, 3, 34, "3", "4");
        check(4, 3, 35, "3", "4");
        check(4, 3, 36, "3", "4");
        //4th house expected
        check(1, 3, 10, "4", "1");
        check(1, 3, 11, "4", "1");
        check(1, 3, 12, "4", "1");
        check(2, 3, 19, "4", "1");
        check(2, 3, 20, "4", "1");
        check(2, 3, 21, "4", "1");
        check(2, 3, 22, "4", "2");
        check(2, 3, 23, "4", "2");
        check(2, 3, 24, "4", "2");
        check(3, 3, 28, "4", "1");
        check(3, 3, 29, "4", "1");
        check(3, 3, 30, "4", "1");
        check(3, 3, 31, "4", "2");
        check(3, 3, 32, "4", "2");
        check(3, 3, 33, "4", "2");
        check(3, 3, 34, "4", "3");
        check(3, 3, 35, "4", "3");
        check(3, 3, 36, "4", "3");
        check(4, 3, 37, "4", "1");
        check(4, 3, 38, "4", "1");
        check(4, 3, 39, "4", "1");
        check(4, 3, 40, "4", "2");
        check(4, 3, 41, "4", "2");
        check(4, 3, 42, "4", "2");
        check(4, 3, 43, "4", "3");
        check(4, 3, 44, "4", "3");
        check(4, 3, 45, "4", "3");
        check(4, 3, 46, "4", "4");
        check(4, 3, 47, "4", "4");
        check(4, 3, 48, "4", "4");

        //4 flats on floor
        //1st house expected
        check(1, 4, 1, "1", "1");
        check(1, 4, 2, "1", "1");
        check(1, 4, 3, "1", "1");
        check(1, 4, 4, "1", "1");
        check(2, 4, 1, "1", "1");
        check(2, 4, 2, "1", "1");
        check(2, 4, 3, "1", "1");
        check(2, 4, 4, "1", "1");
        check(2, 4, 5, "1", "2");
        check(2, 4, 6, "1", "2");
        check(2, 4, 7, "1", "2");
        check(2, 4, 8, "1", "2");
        check(3, 4, 1, "1", "1");
        check(3, 4, 2, "1", "1");
        check(3, 4, 3, "1", "1");
        check(3, 4, 4, "1", "1");
        check(3, 4, 5, "1", "2");
        check(3, 4, 6, "1", "2");
        check(3, 4, 7, "1", "2");
        check(3, 4, 8, "1", "2");
        check(3, 4, 9, "1", "3");
        check(3, 4, 10, "1", "3");
        check(3, 4, 11, "1", "3");
        check(3, 4, 12, "1", "3");
        check(4, 4, 1, "1", "1");
        check(4, 4, 2, "1", "1");
        check(4, 4, 3, "1", "1");
        check(4, 4, 4, "1", "1");
        check(4, 4, 5, "1", "2");
        check(4, 4, 6, "1", "2");
        check(4, 4, 7, "1", "2");
        check(4, 4, 8, "1", "2");
        check(4, 4, 9, "1", "3");
        check(4, 4, 10, "1", "3");
        check(4, 4, 11, "1", "3");
        check(4, 4, 12, "1", "3");
        check(4, 4, 13, "1", "4");
        check(4, 4, 14, "1", "4");
        check(4, 4, 15, "1", "4");
        check(4, 4, 16, "1", "4");
        //2nd house expected
        check(1, 4, 5, "2", "1");
        check(1, 4, 6, "2", "1");
        check(1, 4, 7, "2", "1");
        check(1, 4, 8, "2", "1");
        check(2, 4, 9, "2", "1");
        check(2, 4, 10, "2", "1");
        check(2, 4, 11, "2", "1");
        check(2, 4, 12, "2", "1");
        check(2, 4, 13, "2", "2");
        check(2, 4, 14, "2", "2");
        check(2, 4, 15, "2", "2");
        check(2, 4, 16, "2", "2");
        check(3, 4, 13, "2", "1");
        check(3, 4, 14, "2", "1");
        check(3, 4, 15, "2", "1");
        check(3, 4, 16, "2", "1");
        check(3, 4, 17, "2", "2");
        check(3, 4, 18, "2", "2");
        check(3, 4, 19, "2", "2");
        check(3, 4, 20, "2", "2");
        check(3, 4, 21, "2", "3");
        check(3, 4, 22, "2", "3");
        check(3, 4, 23, "2", "3");
        check(3, 4, 24, "2", "3");
        check(4, 4, 17, "2", "1");
        check(4, 4, 18, "2", "1");
        check(4, 4, 19, "2", "1");
        check(4, 4, 20, "2", "1");
        check(4, 4, 21, "2", "2");
        check(4, 4, 22, "2", "2");
        check(4, 4, 23, "2", "2");
        check(4, 4, 24, "2", "2");
        check(4, 4, 25, "2", "3");
        check(4, 4, 26, "2", "3");
        check(4, 4, 27, "2", "3");
        check(4, 4, 28, "2", "3");
        check(4, 4, 29, "2", "4");
        check(4, 4, 30, "2", "4");
        check(4, 4, 31, "2", "4");
        check(4, 4, 32, "2", "4");
        //3rd house expected
        check(1, 4, 9, "3", "1");
        check(1, 4, 10, "3", "1");
        check(1, 4, 11, "3", "1");
        check(1, 4, 12, "3", "1");
        check(2, 4, 17, "3", "1");
        check(2, 4, 18, "3", "1");
        check(2, 4, 19, "3", "1");
        check(2, 4, 20, "3", "1");
        check(2, 4, 21, "3", "2");
        check(2, 4, 22, "3", "2");
        check(2, 4, 23, "3", "2");
        check(2, 4, 24, "3", "2");
        check(3, 4, 25, "3", "1");
        check(3, 4, 26, "3", "1");
        check(3, 4, 27, "3", "1");
        check(3, 4, 28, "3", "1");
        check(3, 4, 29, "3", "2");
        check(3, 4, 30, "3", "2");
        check(3, 4, 31, "3", "2");
        check(3, 4, 32, "3", "2");
        check(3, 4, 33, "3", "3");
        check(3, 4, 34, "3", "3");
        check(3, 4, 35, "3", "3");
        check(3, 4, 36, "3", "3");
        check(4, 4, 33, "3", "1");
        check(4, 4, 34, "3", "1");
        check(4, 4, 35, "3", "1");
        check(4, 4, 36, "3", "1");
        check(4, 4, 37, "3", "2");
        check(4, 4, 38, "3", "2");
        check(4, 4, 39, "3", "2");
        check(4, 4, 40, "3", "2");
        check(4, 4, 41, "3", "3");
        check(4, 4, 42, "3", "3");
        check(4, 4, 43, "3", "3");
        check(4, 4, 44, "3", "3");
        check(4, 4, 45, "3", "4");
        check(4, 4, 46, "3", "4");
        check(4, 4, 47, "3", "4");
        check(4, 4, 48, "3", "4");
        //4th house expected
        check(1, 4, 13, "4", "1");
        check(1, 4, 14, "4", "1");
        check(1, 4, 15, "4", "1");
        check(1, 4, 16, "4", "1");
        check(2, 4, 25, "4", "1");
        check(2, 4, 26, "4", "1");
        check(2, 4, 27, "4", "1");
        check(2, 4, 28, "4", "1");
        check(2, 4, 29, "4", "2");
        check(2, 4, 30, "4", "2");
        check(2, 4, 31, "4", "2");
        check(2, 4, 32, "4", "2");
        check(3, 4, 37, "4", "1");
        check(3, 4, 38, "4", "1");
        check(3, 4, 39, "4", "1");
        check(3, 4, 40, "4", "1");
        check(3, 4, 41, "4", "2");
        check(3, 4, 42, "4", "2");
        check(3, 4, 43, "4", "2");
        check(3, 4, 44, "4", "2");
        check(3, 4, 45, "4", "3");
        check(3, 4, 46, "4", "3");
        check(3, 4, 47, "4", "3");
        check(3, 4, 48, "4", "3");
        check(4, 4, 49, "4", "1");
        check(4, 4, 50, "4", "1");
        check(4, 4, 51, "4", "1");
        check(4, 4, 52, "4", "1");
        check(4, 4, 53, "4", "2");
        check(4, 4, 54, "4", "2");
        check(4, 4, 55, "4", "2");
        check(4, 4, 56, "4", "2");
        check(4, 4, 57, "4", "3");
        check(4, 4, 58, "4", "3");
        check(4, 4, 59, "4", "3");
        check(4, 4, 60, "4", "3");
        check(4, 4, 61, "4", "4");
        check(4, 4, 62, "4", "4");
        check(4, 4, 63, "4", "4");
        check(4, 4, 64, "4", "4");
    }

    /**
     * Tests with non-valid args for task2 (swap).
     * 50 tests for random non-positive args;
     * 25 tests for too large numbers;
     * 85 boundary tests for too large numbers;
     * 45 tests for non-positive numbers tests;
     * 205 tests at all.
     */
    @Test
    void nonValidArgsTests() {
        //50 random non-positive args
        checkException(-6134, 75134, 1);
        checkException(-5123, 12313, 5123);
        checkException(-824, 6134, 6412);
        checkException(-312314, 751, 641);
        checkException(-64, 1, 8652);
        checkException(-123, 214151, 876524);
        checkException(-8523, 15141, 8523);
        checkException(-41412, 12415, 124);
        checkException(-7452, 78513, 123);
        checkException(-123154, 123, 851);
        checkException(13124, -12313, 13123);
        checkException(7513, -74213, 6412);
        checkException(521, -1236, 12314);
        checkException(8624, -513, 6142);
        checkException(1235, -1416, 1246);
        checkException(12, -151, 7523);
        checkException(123, -7651, 97345);
        checkException(1, -85143, 21141);
        checkException(897651312, -5242, 6241);
        checkException(1314, -8, 725);
        checkException(13124, 52341, 0);
        checkException(151, 1314, -1313);
        checkException(7421, 52341, -723);
        checkException(65134, 718, -72432);
        checkException(1415, 148, -8523);
        checkException(14216, 65341, -134);
        checkException(17852, 98, -1);
        checkException(13124, 7513, -65412);
        checkException(7653, 5, -865243);
        checkException(6, 6, -76523);
        checkException(-6, -2, 725);
        checkException(-652, -7352, 2341);
        checkException(-252, -2424, 1623);
        checkException(0, -237, 234);
        checkException(-623, -6243, 752);
        checkException(-14, 6234, -65134);
        checkException(-312431, 124, -123);
        checkException(-16144, 123, -13);
        checkException(-1236, 1231, -6417);
        checkException(-513, 614, -86258);
        checkException(4143, -1512, -511);
        checkException(125, -16, -7324);
        checkException(725, -235, -625);
        checkException(7852, -246, -62);
        checkException(2345, -862, -234);
        checkException(-132, -51, -6134);
        checkException(-265, -2424, -8083);
        checkException(-876234262, -621, -9734);
        checkException(-23524, -2424, -234);
        checkException(-234, -6243, -925);

        //25 random too large numbers
        checkException(444444444, 5, 1239);
        checkException(1235141, 1242313123, 3);
        checkException(92184014, 151251251, 13124);
        checkException(734252352, 2342342, 98423);
        checkException(897149814, 182571, 1234);
        checkException(1249871491, 142141, 131231);
        checkException(124109481, 1412414, 5141);
        checkException(20213, 62351151, 141241);
        checkException(6135411, 513141, 625412415);
        checkException(511513121, 512512412, 151231);
        checkException(51412311, 141276, 1143123);
        checkException(21471864, 7816481, 413139999);
        checkException(6551515, 565464, 5656546);
        checkException(169286336, 555892314, 48899166);
        checkException(15313216, 3151651,9155233);
        checkException(6525665, 565656,8949433);
        checkException(265626403, 6565648, 234526532);
        checkException(8532702, 965275638, 65236523);
        checkException(514, 51231141, 612412431);
        checkException(125154, 141231, 15124);
        checkException(124141, 51141, 1512);
        checkException(62356, 97815, 5171);
        checkException(91748214, 154124, 51412);
        checkException(982198274, 1421314, 1412);
        checkException(1412414, 12414, 692481);

        //boundary tests for too large numbers
        //(int)(MAX_VALUE + 1L) / 2 and 2
        checkException((int)(MAX_VALUE + 1L) / 2, 2, 1);
        checkException((int)(MAX_VALUE + 1L) / 2, 2, 2);
        checkException((int)(MAX_VALUE + 1L) / 2, 2, MAX_VALUE / 2);
        checkException((int)(MAX_VALUE + 1L) / 2, 2, MAX_VALUE - 1);
        checkException((int)(MAX_VALUE + 1L) / 2, 2, MAX_VALUE);

        checkException(2, (int)(MAX_VALUE + 1L) / 2, 1);
        checkException(2, (int)(MAX_VALUE + 1L) / 2, 2);
        checkException(2, (int)(MAX_VALUE + 1L) / 2, MAX_VALUE / 2);
        checkException(2, (int)(MAX_VALUE + 1L) / 2, MAX_VALUE - 1);
        checkException(2, (int)(MAX_VALUE + 1L) / 2, MAX_VALUE);

        //MAX_VALUE / 2
        //and 3
        checkException(MAX_VALUE / 2, 3, 1);
        checkException(MAX_VALUE / 2, 3, 2);
        checkException(MAX_VALUE / 2, 3, MAX_VALUE / 2);
        checkException(MAX_VALUE / 2, 3, MAX_VALUE - 1);
        checkException(MAX_VALUE / 2, 3, MAX_VALUE);

        checkException(3, MAX_VALUE / 2, 1);
        checkException(3, MAX_VALUE / 2, 2);
        checkException(3, MAX_VALUE / 2, MAX_VALUE / 2);
        checkException(3, MAX_VALUE / 2, MAX_VALUE - 1);
        checkException(3, MAX_VALUE / 2, MAX_VALUE);

        //and MAX_VALUE / 2
        checkException(MAX_VALUE / 2, MAX_VALUE / 2, 1);
        checkException(MAX_VALUE / 2, MAX_VALUE / 2, 2);
        checkException(MAX_VALUE / 2, MAX_VALUE / 2, MAX_VALUE / 2);
        checkException(MAX_VALUE / 2, MAX_VALUE / 2, MAX_VALUE - 1);
        checkException(MAX_VALUE / 2, MAX_VALUE / 2, MAX_VALUE);

        //and MAX_VALUE - 1
        checkException(MAX_VALUE / 2, MAX_VALUE - 1, 1);
        checkException(MAX_VALUE / 2, MAX_VALUE - 1, 2);
        checkException(MAX_VALUE / 2, MAX_VALUE - 1, MAX_VALUE / 2);
        checkException(MAX_VALUE / 2, MAX_VALUE - 1, MAX_VALUE - 1);
        checkException(MAX_VALUE / 2, MAX_VALUE - 1, MAX_VALUE);

        checkException(MAX_VALUE - 1, MAX_VALUE / 2, 1);
        checkException(MAX_VALUE - 1, MAX_VALUE / 2, 2);
        checkException(MAX_VALUE - 1, MAX_VALUE / 2, MAX_VALUE / 2);
        checkException(MAX_VALUE - 1, MAX_VALUE / 2, MAX_VALUE - 1);
        checkException(MAX_VALUE - 1, MAX_VALUE / 2, MAX_VALUE);

        //and MAX_VALUE
        checkException(MAX_VALUE / 2, MAX_VALUE, 1);
        checkException(MAX_VALUE / 2, MAX_VALUE, 2);
        checkException(MAX_VALUE / 2, MAX_VALUE, MAX_VALUE / 2);
        checkException(MAX_VALUE / 2, MAX_VALUE, MAX_VALUE - 1);
        checkException(MAX_VALUE / 2, MAX_VALUE, MAX_VALUE);

        checkException(MAX_VALUE, MAX_VALUE / 2, 1);
        checkException(MAX_VALUE, MAX_VALUE / 2, 2);
        checkException(MAX_VALUE, MAX_VALUE / 2, MAX_VALUE / 2);
        checkException(MAX_VALUE, MAX_VALUE / 2, MAX_VALUE - 1);
        checkException(MAX_VALUE, MAX_VALUE / 2, MAX_VALUE);

        //MAX_VALUE - 1
        //and 2
        checkException(MAX_VALUE - 1, 2, 1);
        checkException(MAX_VALUE - 1, 2, 2);
        checkException(MAX_VALUE - 1, 2, MAX_VALUE / 2);
        checkException(MAX_VALUE - 1, 2, MAX_VALUE - 1);
        checkException(MAX_VALUE - 1, 2, MAX_VALUE);

        checkException(2, MAX_VALUE - 1, 1);
        checkException(2, MAX_VALUE - 1, 2);
        checkException(2, MAX_VALUE - 1, MAX_VALUE / 2);
        checkException(2, MAX_VALUE - 1, MAX_VALUE - 1);
        checkException(2, MAX_VALUE - 1, MAX_VALUE);

        //and MAX_VALUE - 1
        checkException(MAX_VALUE - 1, MAX_VALUE - 1, 1);
        checkException(MAX_VALUE - 1, MAX_VALUE - 1, 2);
        checkException(MAX_VALUE - 1, MAX_VALUE - 1, MAX_VALUE / 2);
        checkException(MAX_VALUE - 1, MAX_VALUE - 1, MAX_VALUE - 1);
        checkException(MAX_VALUE - 1, MAX_VALUE - 1, MAX_VALUE);

        //and MAX_VALUE
        checkException(MAX_VALUE - 1, MAX_VALUE, 1);
        checkException(MAX_VALUE - 1, MAX_VALUE, 2);
        checkException(MAX_VALUE - 1, MAX_VALUE, MAX_VALUE / 2);
        checkException(MAX_VALUE - 1, MAX_VALUE, MAX_VALUE - 1);
        checkException(MAX_VALUE - 1, MAX_VALUE, MAX_VALUE);

        checkException(MAX_VALUE, MAX_VALUE - 1, 1);
        checkException(MAX_VALUE, MAX_VALUE - 1, 2);
        checkException(MAX_VALUE, MAX_VALUE - 1, MAX_VALUE / 2);
        checkException(MAX_VALUE, MAX_VALUE - 1, MAX_VALUE - 1);
        checkException(MAX_VALUE, MAX_VALUE - 1, MAX_VALUE);

        //MAX_VALUE
        //and 2
        checkException(MAX_VALUE, 2, 1);
        checkException(MAX_VALUE, 2, 2);
        checkException(MAX_VALUE, 2, MAX_VALUE / 2);
        checkException(MAX_VALUE, 2, MAX_VALUE - 1);
        checkException(MAX_VALUE, 2, MAX_VALUE);

        checkException(2, MAX_VALUE, 1);
        checkException(2, MAX_VALUE, 2);
        checkException(2, MAX_VALUE, MAX_VALUE / 2);
        checkException(2, MAX_VALUE, MAX_VALUE - 1);
        checkException(2, MAX_VALUE, MAX_VALUE);

        //and MAX_VALUE
        checkException(MAX_VALUE, MAX_VALUE, 1);
        checkException(MAX_VALUE, MAX_VALUE, 2);
        checkException(MAX_VALUE, MAX_VALUE, MAX_VALUE / 2);
        checkException(MAX_VALUE, MAX_VALUE, MAX_VALUE - 1);
        checkException(MAX_VALUE, MAX_VALUE, MAX_VALUE);

        //non-positive numbers tests
        //first
        //with random negative
        checkException(MIN_VALUE, -75362, -23424);
        checkException(MIN_VALUE + 1, -1325, -42241);
        checkException(MIN_VALUE / 2, -3424, -634562);
        checkException(-1, -1374, -525);
        checkException(0, -6734, -13425);

        //with random positive
        checkException(MIN_VALUE, 1342, 1835345);
        checkException(MIN_VALUE + 1, 13414, 13213);
        checkException(MIN_VALUE / 2, 15535, 124313);
        checkException(-1, 14312, 123);
        checkException(0, 12365, 123137);

        //with 0
        checkException(MIN_VALUE, 0, 0);
        checkException(MIN_VALUE + 1, 0, 0);
        checkException(MIN_VALUE / 2, 0, 0);
        checkException(-1, 0, 0);
        checkException(0, 0, 0);

        //second
        //with random negative
        checkException(-52452, MIN_VALUE, -3425);
        checkException(-145, MIN_VALUE + 1, -725);
        checkException(-12313, MIN_VALUE / 2, -75643);
        checkException(-413413, -1, -5241);
        checkException(-84, 0, -3242);

        //with random positive
        checkException(13123, MIN_VALUE, 12314);
        checkException(6234, MIN_VALUE + 1, 12417);
        checkException(14124, MIN_VALUE / 2, 6);
        checkException(147234, -1, 1241);
        checkException(96425, 0, 16421);

        //with 0
        checkException(0, MIN_VALUE, 0);
        checkException(0, MIN_VALUE + 1, 0);
        checkException(0, MIN_VALUE / 2, 0);
        checkException(0, -1, 0);
        checkException(0, 0, 0);

        //third
        //with random negative
        checkException(-43, -524523, MIN_VALUE);
        checkException(-23424, -12315, MIN_VALUE + 1);
        checkException(-123414, -23424, MIN_VALUE / 2);
        checkException(-23521, -673, -1);
        checkException(-241, -63, 0);

        //with random positive
        checkException(131, 1755, MIN_VALUE);
        checkException(9465, 12575, MIN_VALUE + 1);
        checkException(1, 7514, MIN_VALUE / 2);
        checkException(21512, 14156, -1);
        checkException(1415, 12314, 0);

        //with 0
        checkException(0, 0, MIN_VALUE);
        checkException(0, 0, MIN_VALUE + 1);
        checkException(0, 0, MIN_VALUE / 2);
        checkException(0, 0, -1);
        checkException(0, 0, 0);
    }

    /**
     * Function for testing valid args for task2 (flats).
     * For inputted parameters define in which house and on which floor the flat is located.
     * @param floorsInHouse number of floors in house.
     * @param flatsOnFloor number of flats on floor.
     * @param numberOfFlat number of flat, for which have to define house and floor.
     * @param expectedHouse expected value of house.
     * @param expectedFloor expected value of floor.
     */
    private void check(int floorsInHouse, int flatsOnFloor, int numberOfFlat,
                       String expectedHouse, String expectedFloor) {
        String expected = numberOfFlat + ": " + expectedFloor + " floor, " + expectedHouse + " house";
        String actual = new Task2(floorsInHouse, flatsOnFloor).defineHouseAndFloor(numberOfFlat);
        assertEquals(expected, actual);
    }

    /**
     * Function for testing non-valid args for task2 (flats).
     * For inputted parameters an IncorrectArgumentException or
     * IntegerOverflowException should be thrown.
     * @see IncorrectArgumentException
     * @see IntegerOverflowException
     * @param floorsInHouse number of floors in house.
     * @param flatsOnFloor number of flats on floor.
     * @param numberOfFlat number of flat, for which have to define house and floor.
     */
    private void checkException(int floorsInHouse, int flatsOnFloor, int numberOfFlat) {
        try {
            new Task2(floorsInHouse, flatsOnFloor).defineHouseAndFloor(numberOfFlat);
            fail("Exception was not thrown");
        } catch (IncorrectArgumentException | IntegerOverflowException e) {
            //correct behavior
        }
    }
}
