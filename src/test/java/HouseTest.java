import com.implemica.bormashenko.IncorrectArgumentException;
import com.implemica.bormashenko.Main;
import com.implemica.bormashenko.House;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;
import static java.lang.String.valueOf;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for House (flats).
 *
 * @author Mykhailo Bormashenko
 */
class HouseTest {

    /**
     * Constant for lineSeparator.
     */
    private static final String L_S = System.lineSeparator();

    /**
     * Message shown for all cases in main.
     */
    private static final String MESSAGE = "Input number of task from 1 to 5." + L_S +
            "Task 2: house." + L_S +
            "Input number of floors in house, number of flats on floor and number of flat." + L_S;

    /**
     * Value of sqrt of Integer.MAX_VALUE, converted to int.
     */
    private static final int SQRT_MAX = (int) Math.sqrt(MAX_VALUE);

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
        check(100, MAX_VALUE / 100, MAX_VALUE / 2, "1", "51");
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
        //for floors in house
        //one invalid parameter
        checkExceptionForFloorsInHouse(-6134, 75134, 1);
        checkExceptionForFloorsInHouse(-5123, 12313, 5123);
        checkExceptionForFloorsInHouse(-824, 6134, 6412);
        checkExceptionForFloorsInHouse(-312314, 751, 641);
        checkExceptionForFloorsInHouse(-64, 1, 8652);
        checkExceptionForFloorsInHouse(-123, 214151, 876524);
        checkExceptionForFloorsInHouse(-8523, 15141, 8523);
        checkExceptionForFloorsInHouse(-41412, 12415, 124);
        checkExceptionForFloorsInHouse(-7452, 78513, 123);
        checkExceptionForFloorsInHouse(-123154, 123, 851);
        checkExceptionForFloorsInHouse(-6, -2, 725);
        checkExceptionForFloorsInHouse(-652, -7352, 2341);
        checkExceptionForFloorsInHouse(-252, -2424, 1623);
        checkExceptionForFloorsInHouse(0, -237, 234);
        checkExceptionForFloorsInHouse(-623, -6243, 752);
        checkExceptionForFloorsInHouse(-14, 6234, -65134);
        checkExceptionForFloorsInHouse(-312431, 124, -123);
        checkExceptionForFloorsInHouse(-16144, 123, -13);
        checkExceptionForFloorsInHouse(-1236, 1231, -6417);
        checkExceptionForFloorsInHouse(-513, 614, -86258);
        checkExceptionForFloorsInHouse(-132, -51, -6134);
        checkExceptionForFloorsInHouse(-265, -2424, -8083);
        checkExceptionForFloorsInHouse(-876234262, -621, -9734);
        checkExceptionForFloorsInHouse(-23524, -2424, -234);
        checkExceptionForFloorsInHouse(-234, -6243, -925);

        //for flats on floor
        checkExceptionForFlatsOnFloor(13124, -12313, 13123);
        checkExceptionForFlatsOnFloor(7513, -74213, 6412);
        checkExceptionForFlatsOnFloor(521, -1236, 12314);
        checkExceptionForFlatsOnFloor(8624, -513, 6142);
        checkExceptionForFlatsOnFloor(1235, -1416, 1246);
        checkExceptionForFlatsOnFloor(12, -151, 7523);
        checkExceptionForFlatsOnFloor(123, -7651, 97345);
        checkExceptionForFlatsOnFloor(1, -85143, 21141);
        checkExceptionForFlatsOnFloor(897651312, -5242, 6241);
        checkExceptionForFlatsOnFloor(1314, -8, 725);

        checkExceptionForFlat(13124, 52341, 0);
        checkExceptionForFlat(151, 1314, -1313);
        checkExceptionForFlat(7421, 52341, -723);
        checkExceptionForFlat(65134, 718, -72432);
        checkExceptionForFlat(1415, 148, -8523);
        checkExceptionForFlat(14216, 65341, -134);
        checkExceptionForFlat(17852, 98, -1);
        checkExceptionForFlat(13124, 7513, -65412);
        checkExceptionForFlat(7653, 5, -865243);
        checkExceptionForFlat(6, 6, -76523);

        checkExceptionForFlatsOnFloor(4143, -1512, -511);
        checkExceptionForFlatsOnFloor(125, -16, -7324);
        checkExceptionForFlatsOnFloor(725, -235, -625);
        checkExceptionForFlatsOnFloor(7852, -246, -62);
        checkExceptionForFlatsOnFloor(2345, -862, -234);

        //25 random too large numbers
        checkExceptionForTooLarge(444444444, 5, 1239);
        checkExceptionForTooLarge(1235141, 1242313123, 3);
        checkExceptionForTooLarge(92184014, 151251251, 13124);
        checkExceptionForTooLarge(734252352, 2342342, 98423);
        checkExceptionForTooLarge(897149814, 182571, 1234);
        checkExceptionForTooLarge(1249871491, 142141, 131231);
        checkExceptionForTooLarge(124109481, 1412414, 5141);
        checkExceptionForTooLarge(20213, 62351151, 141241);
        checkExceptionForTooLarge(6135411, 513141, 625412415);
        checkExceptionForTooLarge(511513121, 512512412, 151231);
        checkExceptionForTooLarge(51412311, 141276, 1143123);
        checkExceptionForTooLarge(21471864, 7816481, 413139999);
        checkExceptionForTooLarge(6551515, 565464, 5656546);
        checkExceptionForTooLarge(169286336, 555892314, 48899166);
        checkExceptionForTooLarge(15313216, 3151651, 9155233);
        checkExceptionForTooLarge(6525665, 565656, 8949433);
        checkExceptionForTooLarge(265626403, 6565648, 234526532);
        checkExceptionForTooLarge(8532702, 965275638, 65236523);
        checkExceptionForTooLarge(514, 51231141, 612412431);
        checkExceptionForTooLarge(125154, 141231, 15124);
        checkExceptionForTooLarge(124141, 51141, 1512);
        checkExceptionForTooLarge(62356, 97815, 5171);
        checkExceptionForTooLarge(91748214, 154124, 51412);
        checkExceptionForTooLarge(982198274, 1421314, 1412);
        checkExceptionForTooLarge(1412414, 12414, 692481);

        //boundary tests for too large numbers
        //(int)(MAX_VALUE + 1L) / 2 and 2
        //for floors in house
        checkExceptionForTooLarge((int) ((MAX_VALUE + 1L) / 2), 2, 1);
        checkExceptionForTooLarge((int) ((MAX_VALUE + 1L) / 2), 2, 2);
        checkExceptionForTooLarge((int) ((MAX_VALUE + 1L) / 2), 2, MAX_VALUE / 2);
        checkExceptionForTooLarge((int) ((MAX_VALUE + 1L) / 2), 2, MAX_VALUE - 1);
        checkExceptionForTooLarge((int) ((MAX_VALUE + 1L) / 2), 2, MAX_VALUE);

        checkExceptionForTooLarge(2, (int) ((MAX_VALUE + 1L) / 2), 1);
        checkExceptionForTooLarge(2, (int) ((MAX_VALUE + 1L) / 2), 2);
        checkExceptionForTooLarge(2, (int) ((MAX_VALUE + 1L) / 2), MAX_VALUE / 2);
        checkExceptionForTooLarge(2, (int) ((MAX_VALUE + 1L) / 2), MAX_VALUE - 1);
        checkExceptionForTooLarge(2, (int) ((MAX_VALUE + 1L) / 2), MAX_VALUE);

        //MAX_VALUE / 2
        //and 3
        //for floors in house
        checkExceptionForTooLarge(MAX_VALUE / 2, 3, 1);
        checkExceptionForTooLarge(MAX_VALUE / 2, 3, 2);
        checkExceptionForTooLarge(MAX_VALUE / 2, 3, MAX_VALUE / 2);
        checkExceptionForTooLarge(MAX_VALUE / 2, 3, MAX_VALUE - 1);
        checkExceptionForTooLarge(MAX_VALUE / 2, 3, MAX_VALUE);

        checkExceptionForTooLarge(3, MAX_VALUE / 2, 1);
        checkExceptionForTooLarge(3, MAX_VALUE / 2, 2);
        checkExceptionForTooLarge(3, MAX_VALUE / 2, MAX_VALUE / 2);
        checkExceptionForTooLarge(3, MAX_VALUE / 2, MAX_VALUE - 1);
        checkExceptionForTooLarge(3, MAX_VALUE / 2, MAX_VALUE);

        //and MAX_VALUE / 2
        //for floors in house
        checkExceptionForTooLarge(MAX_VALUE / 2, MAX_VALUE / 2, 1);
        checkExceptionForTooLarge(MAX_VALUE / 2, MAX_VALUE / 2, 2);
        checkExceptionForTooLarge(MAX_VALUE / 2, MAX_VALUE / 2, MAX_VALUE / 2);
        checkExceptionForTooLarge(MAX_VALUE / 2, MAX_VALUE / 2, MAX_VALUE - 1);
        checkExceptionForTooLarge(MAX_VALUE / 2, MAX_VALUE / 2, MAX_VALUE);

        //and MAX_VALUE - 1
        checkExceptionForTooLarge(MAX_VALUE / 2, MAX_VALUE - 1, 1);
        checkExceptionForTooLarge(MAX_VALUE / 2, MAX_VALUE - 1, 2);
        checkExceptionForTooLarge(MAX_VALUE / 2, MAX_VALUE - 1, MAX_VALUE / 2);
        checkExceptionForTooLarge(MAX_VALUE / 2, MAX_VALUE - 1, MAX_VALUE - 1);
        checkExceptionForTooLarge(MAX_VALUE / 2, MAX_VALUE - 1, MAX_VALUE);

        checkExceptionForTooLarge(MAX_VALUE - 1, MAX_VALUE / 2, 1);
        checkExceptionForTooLarge(MAX_VALUE - 1, MAX_VALUE / 2, 2);
        checkExceptionForTooLarge(MAX_VALUE - 1, MAX_VALUE / 2, MAX_VALUE / 2);
        checkExceptionForTooLarge(MAX_VALUE - 1, MAX_VALUE / 2, MAX_VALUE - 1);
        checkExceptionForTooLarge(MAX_VALUE - 1, MAX_VALUE / 2, MAX_VALUE);

        //and MAX_VALUE
        checkExceptionForTooLarge(MAX_VALUE / 2, MAX_VALUE, 1);
        checkExceptionForTooLarge(MAX_VALUE / 2, MAX_VALUE, 2);
        checkExceptionForTooLarge(MAX_VALUE / 2, MAX_VALUE, MAX_VALUE / 2);
        checkExceptionForTooLarge(MAX_VALUE / 2, MAX_VALUE, MAX_VALUE - 1);
        checkExceptionForTooLarge(MAX_VALUE / 2, MAX_VALUE, MAX_VALUE);

        checkExceptionForTooLarge(MAX_VALUE, MAX_VALUE / 2, 1);
        checkExceptionForTooLarge(MAX_VALUE, MAX_VALUE / 2, 2);
        checkExceptionForTooLarge(MAX_VALUE, MAX_VALUE / 2, MAX_VALUE / 2);
        checkExceptionForTooLarge(MAX_VALUE, MAX_VALUE / 2, MAX_VALUE - 1);
        checkExceptionForTooLarge(MAX_VALUE, MAX_VALUE / 2, MAX_VALUE);

        //MAX_VALUE - 1
        //and 2
        checkExceptionForTooLarge(MAX_VALUE - 1, 2, 1);
        checkExceptionForTooLarge(MAX_VALUE - 1, 2, 2);
        checkExceptionForTooLarge(MAX_VALUE - 1, 2, MAX_VALUE / 2);
        checkExceptionForTooLarge(MAX_VALUE - 1, 2, MAX_VALUE - 1);
        checkExceptionForTooLarge(MAX_VALUE - 1, 2, MAX_VALUE);

        checkExceptionForTooLarge(2, MAX_VALUE - 1, 1);
        checkExceptionForTooLarge(2, MAX_VALUE - 1, 2);
        checkExceptionForTooLarge(2, MAX_VALUE - 1, MAX_VALUE / 2);
        checkExceptionForTooLarge(2, MAX_VALUE - 1, MAX_VALUE - 1);
        checkExceptionForTooLarge(2, MAX_VALUE - 1, MAX_VALUE);

        //and MAX_VALUE - 1
        checkExceptionForTooLarge(MAX_VALUE - 1, MAX_VALUE - 1, 1);
        checkExceptionForTooLarge(MAX_VALUE - 1, MAX_VALUE - 1, 2);
        checkExceptionForTooLarge(MAX_VALUE - 1, MAX_VALUE - 1, MAX_VALUE / 2);
        checkExceptionForTooLarge(MAX_VALUE - 1, MAX_VALUE - 1, MAX_VALUE - 1);
        checkExceptionForTooLarge(MAX_VALUE - 1, MAX_VALUE - 1, MAX_VALUE);

        //and MAX_VALUE
        checkExceptionForTooLarge(MAX_VALUE - 1, MAX_VALUE, 1);
        checkExceptionForTooLarge(MAX_VALUE - 1, MAX_VALUE, 2);
        checkExceptionForTooLarge(MAX_VALUE - 1, MAX_VALUE, MAX_VALUE / 2);
        checkExceptionForTooLarge(MAX_VALUE - 1, MAX_VALUE, MAX_VALUE - 1);
        checkExceptionForTooLarge(MAX_VALUE - 1, MAX_VALUE, MAX_VALUE);

        checkExceptionForTooLarge(MAX_VALUE, MAX_VALUE - 1, 1);
        checkExceptionForTooLarge(MAX_VALUE, MAX_VALUE - 1, 2);
        checkExceptionForTooLarge(MAX_VALUE, MAX_VALUE - 1, MAX_VALUE / 2);
        checkExceptionForTooLarge(MAX_VALUE, MAX_VALUE - 1, MAX_VALUE - 1);
        checkExceptionForTooLarge(MAX_VALUE, MAX_VALUE - 1, MAX_VALUE);

        //MAX_VALUE
        //and 2
        checkExceptionForTooLarge(MAX_VALUE, 2, 1);
        checkExceptionForTooLarge(MAX_VALUE, 2, 2);
        checkExceptionForTooLarge(MAX_VALUE, 2, MAX_VALUE / 2);
        checkExceptionForTooLarge(MAX_VALUE, 2, MAX_VALUE - 1);
        checkExceptionForTooLarge(MAX_VALUE, 2, MAX_VALUE);

        checkExceptionForTooLarge(2, MAX_VALUE, 1);
        checkExceptionForTooLarge(2, MAX_VALUE, 2);
        checkExceptionForTooLarge(2, MAX_VALUE, MAX_VALUE / 2);
        checkExceptionForTooLarge(2, MAX_VALUE, MAX_VALUE - 1);
        checkExceptionForTooLarge(2, MAX_VALUE, MAX_VALUE);

        //and MAX_VALUE
        checkExceptionForTooLarge(MAX_VALUE, MAX_VALUE, 1);
        checkExceptionForTooLarge(MAX_VALUE, MAX_VALUE, 2);
        checkExceptionForTooLarge(MAX_VALUE, MAX_VALUE, MAX_VALUE / 2);
        checkExceptionForTooLarge(MAX_VALUE, MAX_VALUE, MAX_VALUE - 1);
        checkExceptionForTooLarge(MAX_VALUE, MAX_VALUE, MAX_VALUE);

        //non-positive numbers tests
        //first
        //with random negative
        //for floors in house
        checkExceptionForFloorsInHouse(MIN_VALUE, -75362, -23424);
        checkExceptionForFloorsInHouse(MIN_VALUE + 1, -1325, -42241);
        checkExceptionForFloorsInHouse(MIN_VALUE / 2, -3424, -634562);
        checkExceptionForFloorsInHouse(-1, -1374, -525);
        checkExceptionForFloorsInHouse(0, -6734, -13425);

        //with random positive
        checkExceptionForFloorsInHouse(MIN_VALUE, 1342, 1835345);
        checkExceptionForFloorsInHouse(MIN_VALUE + 1, 13414, 13213);
        checkExceptionForFloorsInHouse(MIN_VALUE / 2, 15535, 124313);
        checkExceptionForFloorsInHouse(-1, 14312, 123);
        checkExceptionForFloorsInHouse(0, 12365, 123137);

        //with 0
        checkExceptionForFloorsInHouse(MIN_VALUE, 0, 0);
        checkExceptionForFloorsInHouse(MIN_VALUE + 1, 0, 0);
        checkExceptionForFloorsInHouse(MIN_VALUE / 2, 0, 0);
        checkExceptionForFloorsInHouse(-1, 0, 0);
        checkExceptionForFloorsInHouse(0, 0, 0);

        //second
        //with random negative
        checkExceptionForFloorsInHouse(-52452, MIN_VALUE, -3425);
        checkExceptionForFloorsInHouse(-145, MIN_VALUE + 1, -725);
        checkExceptionForFloorsInHouse(-12313, MIN_VALUE / 2, -75643);
        checkExceptionForFloorsInHouse(-413413, -1, -5241);
        checkExceptionForFloorsInHouse(-84, 0, -3242);

        //with random positive
        checkExceptionForFlatsOnFloor(13123, MIN_VALUE, 12314);
        checkExceptionForFlatsOnFloor(6234, MIN_VALUE + 1, 12417);
        checkExceptionForFlatsOnFloor(14124, MIN_VALUE / 2, 6);
        checkExceptionForFlatsOnFloor(147234, -1, 1241);
        checkExceptionForFlatsOnFloor(96425, 0, 16421);

        //with 0
        checkExceptionForFloorsInHouse(0, MIN_VALUE, 0);
        checkExceptionForFloorsInHouse(0, MIN_VALUE + 1, 0);
        checkExceptionForFloorsInHouse(0, MIN_VALUE / 2, 0);
        checkExceptionForFloorsInHouse(0, -1, 0);
        checkExceptionForFloorsInHouse(0, 0, 0);

        //third
        //with random negative
        checkExceptionForFloorsInHouse(-43, -524523, MIN_VALUE);
        checkExceptionForFloorsInHouse(-23424, -12315, MIN_VALUE + 1);
        checkExceptionForFloorsInHouse(-123414, -23424, MIN_VALUE / 2);
        checkExceptionForFloorsInHouse(-23521, -673, -1);
        checkExceptionForFloorsInHouse(-241, -63, 0);

        //with random positive
        checkExceptionForFlat(131, 1755, MIN_VALUE);
        checkExceptionForFlat(9465, 12575, MIN_VALUE + 1);
        checkExceptionForFlat(1, 7514, MIN_VALUE / 2);
        checkExceptionForFlat(21512, 14156, -1);
        checkExceptionForFlat(1415, 12314, 0);

        //with 0
        checkExceptionForFloorsInHouse(0, 0, MIN_VALUE);
        checkExceptionForFloorsInHouse(0, 0, MIN_VALUE + 1);
        checkExceptionForFloorsInHouse(0, 0, MIN_VALUE / 2);
        checkExceptionForFloorsInHouse(0, 0, -1);
        checkExceptionForFloorsInHouse(0, 0, 0);
    }

    /**
     * Function for testing valid args for task2 (flats).
     * For inputted parameters define in which house and on which floor the flat is located.
     * Simulates user input from console with valid args.
     *
     * @param floorsInHouse number of floors in house.
     * @param flatsOnFloor  number of flats on floor.
     * @param numberOfFlat  number of flat, for which have to define house and floor.
     * @param expectedHouse expected value of house.
     * @param expectedFloor expected value of floor.
     */
    void check(int floorsInHouse, int flatsOnFloor, int numberOfFlat,
               String expectedHouse, String expectedFloor) {
        //Task 2 by itself
        String expected = numberOfFlat + ": " + expectedFloor + " floor, " + expectedHouse + " house";
        String actual = new House(floorsInHouse, flatsOnFloor).defineHouseAndFloor(numberOfFlat);
        assertEquals(expected, actual);

        //Task 2 in main
        String input = "2" + L_S + floorsInHouse + L_S + flatsOnFloor + L_S + numberOfFlat;
        String expectedMain = MESSAGE +
                numberOfFlat + ": " + expectedFloor + " floor, " + expectedHouse + " house" + L_S;

        runMain(input, expectedMain);
    }

    /**
     * Function for testing non-valid args for task2 (flats).
     * For inputted parameters an IncorrectArgumentException should be thrown.
     *
     * @param floorsInHouse number of floors in house.
     * @param flatsOnFloor  number of flats on floor.
     * @param numberOfFlat  non-valid number of flat to find.
     */
    private void checkExceptionInTask(int floorsInHouse, int flatsOnFloor, int numberOfFlat) {
        try {
            new House(floorsInHouse, flatsOnFloor).defineHouseAndFloor(numberOfFlat);
            fail("Exception was not thrown");
        } catch (IncorrectArgumentException e) {
            //correct behavior
        }
    }

    /**
     * Function for testing non-valid args for task2 (flats) where first parameter is non-valid.
     * For inputted parameters an exception with message should be thrown.
     * Simulates user input from console with non-valid args.
     *
     * @param floorsInHouse non-valid number of floors in house.
     * @param flatsOnFloor  number of flats on floor.
     * @param numberOfFlat  number of flat to find.
     */
    private void checkExceptionForFloorsInHouse(int floorsInHouse, int flatsOnFloor, int numberOfFlat) {
        //Task 2 by itself
        checkExceptionInTask(floorsInHouse, flatsOnFloor, numberOfFlat);

        //Task 2 in main
        String input = "2" + L_S + floorsInHouse + L_S + flatsOnFloor + L_S + numberOfFlat;

        String expected = MESSAGE +
                "Wrong input. Expected: positive number of floors in house" + L_S +
                "Got: " + floorsInHouse + L_S;

        runMain(input, expected);
    }

    /**
     * Function for testing non-valid args for task2 (flats) where second parameter is non-valid.
     * For inputted parameters an exception with message should be thrown.
     * Simulates user input from console with non-valid args.
     *
     * @param floorsInHouse number of floors in house.
     * @param flatsOnFloor  non-valid number of flats on floor.
     * @param numberOfFlat  number of flat to find.
     */
    private void checkExceptionForFlatsOnFloor(int floorsInHouse, int flatsOnFloor, int numberOfFlat) {
        //Task 2 by itself
        checkExceptionInTask(floorsInHouse, flatsOnFloor, numberOfFlat);

        //Task 2 in main
        String input = "2" + L_S + floorsInHouse + L_S + flatsOnFloor + L_S + numberOfFlat;

        String expected = MESSAGE +
                "Wrong input. Expected: positive number of flats on floor" + L_S +
                "Got: " + flatsOnFloor + L_S;

        runMain(input, expected);
    }

    /**
     * Function for testing non-valid args for task2 (flats) where third parameter is non-valid.
     * For inputted parameters an exception with message should be thrown.
     * Simulates user input from console with non-valid args.
     *
     * @param floorsInHouse number of floors in house.
     * @param flatsOnFloor  number of flats on floor.
     * @param numberOfFlat  non-valid number of flat to find.
     */
    private void checkExceptionForFlat(int floorsInHouse, int flatsOnFloor, int numberOfFlat) {
        //Task 2 by itself
        checkExceptionInTask(floorsInHouse, flatsOnFloor, numberOfFlat);

        //Task 2 in main
        String input = "2" + L_S + floorsInHouse + L_S + flatsOnFloor + L_S + numberOfFlat;

        String expected = MESSAGE +
                "Wrong input. Expected: positive number of flat" + L_S +
                "Got: " + numberOfFlat + L_S;

        runMain(input, expected);
    }

    /**
     * Function for testing non-valid args for task2 (flats) where args are too large.
     * For inputted parameters an exception with message should be thrown.
     * Simulates user input from console with non-valid args where args are too large.
     *
     * @param floorsInHouse number of floors in house.
     * @param flatsOnFloor  number of flats on floor.
     * @param numberOfFlat  number of flat to find.
     */
    private void checkExceptionForTooLarge(int floorsInHouse, int flatsOnFloor, int numberOfFlat) {
        //Task 2 by itself
        checkExceptionInTask(floorsInHouse, flatsOnFloor, numberOfFlat);

        //Task 2 in main
        String input = "2" + L_S + floorsInHouse + L_S + flatsOnFloor + L_S + numberOfFlat;

        String expected = MESSAGE +
                "Wrong input. Expected: numbers of floors in house and flats on floor so that result " +
                "of multiplying them is not more than " + MAX_VALUE + L_S +
                "Got: " + floorsInHouse + ", " + flatsOnFloor + L_S;

        runMain(input, expected);
    }

    /**
     * Runs main method with args in System.In and checks if
     * the expected string is the same as in System.Out.
     *
     * @param input    string to put into System.In.
     * @param expected string to compare with System.Out.
     */
    private void runMain(String input, String expected) {
        ByteArrayOutputStream output = setInAndOut(input);
        Main.main();
        assertEquals(expected, output.toString());
    }

    /**
     * Overrides System.in and System.out.
     *
     * @param input string that should be converted to System.in.
     * @return System.out that should be converted to ByteArrayOutputStream.
     */
    private ByteArrayOutputStream setInAndOut(String input) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        return output;
    }
}
