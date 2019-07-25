import com.implemica.bormashenko.Main;
import com.implemica.bormashenko.GreatestCommonDivisor;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

/**
 * Test class for GreatestCommonDivisor (gcd).
 *
 * @author Mykhailo Bormashenko
 */
class GreatestCommonDivisorTest {

    /**
     * Constant for lineSeparator.
     */
    private static final String L_S = System.lineSeparator();

    /**
     * Message shown for all cases in main.
     */
    private static final String MESSAGE = "Input number of task from 1 to 5." + L_S +
            "Task 3: gcd." + L_S +
            "Input 4 integer numbers." + L_S;

    /**
     * Tests with valid args for task3 (gcd).
     * 10 tests for several values return from 1 to 10;
     * 14 tests for mutually prime with primes;
     * 3 tests for mutually prime without primes;
     * 173 boundary tests;
     * 200 tests at all.
     */
    @Test
    void validArgsTests() {
        //several values return from 1 to 10
        check(17, 19, 20, 45, 1);
        check(2, 100, 50, 10, 2);
        check(9, 12, 15, 24, 3);
        check(80, 120, 36, 92, 4);
        check(5, 10, 15, 20, 5);
        check(36, 72, 66, 42, 6);
        check(49, 63, 35, 21, 7);
        check(88, 8, 16, 104, 8);
        check(999, 99, 126, 54, 9);
        check(40, 20, 50, 100, 10);

        //mutually prime
        //with primes
        check(7, 20, 15, 45, 1);
        check(45, 11, 49, 22, 1);
        check(34, 12, 5, 25, 1);
        check(123, 120, 99, 31, 1);
        check(13, 28, 26, 19, 1);
        check(19, 190, 23, 102, 1);
        check(29, 41, 55, 140, 1);
        check(72, 43, 44, 47, 1);
        check(60, 53, 59, 54, 1);
        check(77, 78, 61, 67, 1);
        check(71, 73, 79, 100, 1);
        check(83, 89, 24, 97, 1);
        check(101, 206, 103, 107, 1);
        check(109, 113, 127, 131, 1);
        //without primes
        check(4, 9, 25, 49, 1);
        check(12, 16, 70, 147, 1);
        check(49, 77, 55, 36, 1);

        //first is MIN_VALUE + 1
        //second is MIN_VALUE + 1
        //third is MIN_VALUE + 1
        check(MIN_VALUE + 1, MIN_VALUE + 1, MIN_VALUE + 1, MIN_VALUE + 1, MAX_VALUE);
        check(MIN_VALUE + 1, MIN_VALUE + 1, MIN_VALUE + 1, MIN_VALUE + 2, 1);
        check(MIN_VALUE + 1, MIN_VALUE + 1, MIN_VALUE + 1, MIN_VALUE / 2, 1);
        check(MIN_VALUE + 1, MIN_VALUE + 1, MIN_VALUE + 1, -1, 1);
        check(MIN_VALUE + 1, MIN_VALUE + 1, MIN_VALUE + 1, 0, 0);
        check(MIN_VALUE + 1, MIN_VALUE + 1, MIN_VALUE + 1, 1, 1);
        check(MIN_VALUE + 1, MIN_VALUE + 1, MIN_VALUE + 1, MAX_VALUE / 2, 1);
        check(MIN_VALUE + 1, MIN_VALUE + 1, MIN_VALUE + 1, MAX_VALUE - 1, 1);
        check(MIN_VALUE + 1, MIN_VALUE + 1, MIN_VALUE + 1, MAX_VALUE, MAX_VALUE);
        //third is MIN_VALUE + 2
        check(MIN_VALUE + 1, MIN_VALUE + 1, MIN_VALUE + 2, MIN_VALUE + 2, 1);
        check(MIN_VALUE + 1, MIN_VALUE + 1, MIN_VALUE + 2, MIN_VALUE / 2, 1);
        check(MIN_VALUE + 1, MIN_VALUE + 1, MIN_VALUE + 2, -1, 1);
        check(MIN_VALUE + 1, MIN_VALUE + 1, MIN_VALUE + 2, 0, 0);
        check(MIN_VALUE + 1, MIN_VALUE + 1, MIN_VALUE + 2, 1, 1);
        check(MIN_VALUE + 1, MIN_VALUE + 1, MIN_VALUE + 2, MAX_VALUE / 2, 1);
        check(MIN_VALUE + 1, MIN_VALUE + 1, MIN_VALUE + 2, MAX_VALUE - 1, 1);
        check(MIN_VALUE + 1, MIN_VALUE + 1, MIN_VALUE + 2, MAX_VALUE, 1);
        //third is MIN_VALUE / 2
        check(MIN_VALUE + 1, MIN_VALUE + 1, MIN_VALUE / 2, MIN_VALUE / 2, 1);
        check(MIN_VALUE + 1, MIN_VALUE + 1, MIN_VALUE / 2, -1, 1);
        check(MIN_VALUE + 1, MIN_VALUE + 1, MIN_VALUE / 2, 0, 0);
        check(MIN_VALUE + 1, MIN_VALUE + 1, MIN_VALUE / 2, 1, 1);
        check(MIN_VALUE + 1, MIN_VALUE + 1, MIN_VALUE / 2, MAX_VALUE / 2, 1);
        check(MIN_VALUE + 1, MIN_VALUE + 1, MIN_VALUE / 2, MAX_VALUE - 1, 1);
        check(MIN_VALUE + 1, MIN_VALUE + 1, MIN_VALUE / 2, MAX_VALUE, 1);
        //third is -1
        check(MIN_VALUE + 1, MIN_VALUE + 1, -1, -1, 1);
        check(MIN_VALUE + 1, MIN_VALUE + 1, -1, 0, 0);
        check(MIN_VALUE + 1, MIN_VALUE + 1, -1, 1, 1);
        check(MIN_VALUE + 1, MIN_VALUE + 1, -1, MAX_VALUE / 2, 1);
        check(MIN_VALUE + 1, MIN_VALUE + 1, -1, MAX_VALUE - 1, 1);
        check(MIN_VALUE + 1, MIN_VALUE + 1, -1, MAX_VALUE, 1);
        //third is 0
        check(MIN_VALUE + 1, MIN_VALUE + 1, 0, 0, 0);
        check(MIN_VALUE + 1, MIN_VALUE + 1, 0, 1, 0);
        check(MIN_VALUE + 1, MIN_VALUE + 1, 0, MAX_VALUE / 2, 0);
        check(MIN_VALUE + 1, MIN_VALUE + 1, 0, MAX_VALUE - 1, 0);
        check(MIN_VALUE + 1, MIN_VALUE + 1, 0, MAX_VALUE, 0);
        //third is 1
        check(MIN_VALUE + 1, MIN_VALUE + 1, 1, 1, 1);
        check(MIN_VALUE + 1, MIN_VALUE + 1, 1, MAX_VALUE / 2, 1);
        check(MIN_VALUE + 1, MIN_VALUE + 1, 1, MAX_VALUE - 1, 1);
        check(MIN_VALUE + 1, MIN_VALUE + 1, 1, MAX_VALUE, 1);
        //third is MAX_VALUE / 2
        check(MIN_VALUE + 1, MIN_VALUE + 1, MAX_VALUE / 2, MAX_VALUE / 2, 1);
        check(MIN_VALUE + 1, MIN_VALUE + 1, MAX_VALUE / 2, MAX_VALUE - 1, 1);
        check(MIN_VALUE + 1, MIN_VALUE + 1, MAX_VALUE / 2, MAX_VALUE, 1);
        //third is MAX_VALUE - 1
        check(MIN_VALUE + 1, MIN_VALUE + 1, MAX_VALUE - 1, MAX_VALUE - 1, 1);
        check(MIN_VALUE + 1, MIN_VALUE + 1, MAX_VALUE - 1, MAX_VALUE, 1);
        //third is MAX_VALUE
        check(MIN_VALUE + 1, MIN_VALUE + 1, MAX_VALUE, MAX_VALUE, MAX_VALUE);

        //second is MIN_VALUE + 2
        //third is MIN_VALUE + 2
        check(MIN_VALUE + 1, MIN_VALUE + 2, MIN_VALUE + 2, MIN_VALUE + 2, 1);
        check(MIN_VALUE + 1, MIN_VALUE + 2, MIN_VALUE + 2, MIN_VALUE / 2, 1);
        check(MIN_VALUE + 1, MIN_VALUE + 2, MIN_VALUE + 2, -1, 1);
        check(MIN_VALUE + 1, MIN_VALUE + 2, MIN_VALUE + 2, 0, 0);
        check(MIN_VALUE + 1, MIN_VALUE + 2, MIN_VALUE + 2, 1, 1);
        check(MIN_VALUE + 1, MIN_VALUE + 2, MIN_VALUE + 2, MAX_VALUE / 2, 1);
        check(MIN_VALUE + 1, MIN_VALUE + 2, MIN_VALUE + 2, MAX_VALUE - 1, 1);
        check(MIN_VALUE + 1, MIN_VALUE + 2, MIN_VALUE + 2, MAX_VALUE, 1);
        //third is MIN_VALUE / 2
        check(MIN_VALUE + 1, MIN_VALUE + 2, MIN_VALUE / 2, MIN_VALUE / 2, 1);
        check(MIN_VALUE + 1, MIN_VALUE + 2, MIN_VALUE / 2, -1, 1);
        check(MIN_VALUE + 1, MIN_VALUE + 2, MIN_VALUE / 2, 0, 0);
        check(MIN_VALUE + 1, MIN_VALUE + 2, MIN_VALUE / 2, 1, 1);
        check(MIN_VALUE + 1, MIN_VALUE + 2, MIN_VALUE / 2, MAX_VALUE / 2, 1);
        check(MIN_VALUE + 1, MIN_VALUE + 2, MIN_VALUE / 2, MAX_VALUE - 1, 1);
        check(MIN_VALUE + 1, MIN_VALUE + 2, MIN_VALUE / 2, MAX_VALUE, 1);
        //third is -1
        check(MIN_VALUE + 1, MIN_VALUE + 2, -1, -1, 1);
        check(MIN_VALUE + 1, MIN_VALUE + 2, -1, 0, 0);
        check(MIN_VALUE + 1, MIN_VALUE + 2, -1, 1, 1);
        check(MIN_VALUE + 1, MIN_VALUE + 2, -1, MAX_VALUE / 2, 1);
        check(MIN_VALUE + 1, MIN_VALUE + 2, -1, MAX_VALUE - 1, 1);
        check(MIN_VALUE + 1, MIN_VALUE + 2, -1, MAX_VALUE, 1);
        //third is 0
        check(MIN_VALUE + 1, MIN_VALUE + 2, 0, 0, 0);
        check(MIN_VALUE + 1, MIN_VALUE + 2, 0, 1, 0);
        check(MIN_VALUE + 1, MIN_VALUE + 2, 0, MAX_VALUE / 2, 0);
        check(MIN_VALUE + 1, MIN_VALUE + 2, 0, MAX_VALUE - 1, 0);
        check(MIN_VALUE + 1, MIN_VALUE + 2, 0, MAX_VALUE, 0);
        //third is 1
        check(MIN_VALUE + 1, MIN_VALUE + 2, 1, 1, 1);
        check(MIN_VALUE + 1, MIN_VALUE + 2, 1, MAX_VALUE / 2, 1);
        check(MIN_VALUE + 1, MIN_VALUE + 2, 1, MAX_VALUE - 1, 1);
        check(MIN_VALUE + 1, MIN_VALUE + 2, 1, MAX_VALUE, 1);
        //third is MAX_VALUE / 2
        check(MIN_VALUE + 1, MIN_VALUE + 2, MAX_VALUE / 2, MAX_VALUE / 2, 1);
        check(MIN_VALUE + 1, MIN_VALUE + 2, MAX_VALUE / 2, MAX_VALUE - 1, 1);
        check(MIN_VALUE + 1, MIN_VALUE + 2, MAX_VALUE / 2, MAX_VALUE, 1);
        //third is MAX_VALUE - 1
        check(MIN_VALUE + 1, MIN_VALUE + 2, MAX_VALUE - 1, MAX_VALUE - 1, 1);
        check(MIN_VALUE + 1, MIN_VALUE + 2, MAX_VALUE - 1, MAX_VALUE, 1);
        //third is MAX_VALUE
        check(MIN_VALUE + 1, MIN_VALUE + 2, MAX_VALUE, MAX_VALUE, 1);

        //second is MIN_VALUE / 2
        //third is MIN_VALUE / 2
        check(MIN_VALUE + 1, MIN_VALUE / 2, MIN_VALUE / 2, MIN_VALUE / 2, 1);
        check(MIN_VALUE + 1, MIN_VALUE / 2, MIN_VALUE / 2, -1, 1);
        check(MIN_VALUE + 1, MIN_VALUE / 2, MIN_VALUE / 2, 0, 0);
        check(MIN_VALUE + 1, MIN_VALUE / 2, MIN_VALUE / 2, 1, 1);
        check(MIN_VALUE + 1, MIN_VALUE / 2, MIN_VALUE / 2, MAX_VALUE / 2, 1);
        check(MIN_VALUE + 1, MIN_VALUE / 2, MIN_VALUE / 2, MAX_VALUE - 1, 1);
        check(MIN_VALUE + 1, MIN_VALUE / 2, MIN_VALUE / 2, MAX_VALUE, 1);
        //third is -1
        check(MIN_VALUE + 1, MIN_VALUE / 2, -1, -1, 1);
        check(MIN_VALUE + 1, MIN_VALUE / 2, -1, 0, 0);
        check(MIN_VALUE + 1, MIN_VALUE / 2, -1, 1, 1);
        check(MIN_VALUE + 1, MIN_VALUE / 2, -1, MAX_VALUE / 2, 1);
        check(MIN_VALUE + 1, MIN_VALUE / 2, -1, MAX_VALUE - 1, 1);
        check(MIN_VALUE + 1, MIN_VALUE / 2, -1, MAX_VALUE, 1);
        //third is 0
        check(MIN_VALUE + 1, MIN_VALUE / 2, 0, 0, 0);
        check(MIN_VALUE + 1, MIN_VALUE / 2, 0, 1, 0);
        check(MIN_VALUE + 1, MIN_VALUE / 2, 0, MAX_VALUE / 2, 0);
        check(MIN_VALUE + 1, MIN_VALUE / 2, 0, MAX_VALUE - 1, 0);
        check(MIN_VALUE + 1, MIN_VALUE / 2, 0, MAX_VALUE, 0);
        //third is 1
        check(MIN_VALUE + 1, MIN_VALUE / 2, 1, 1, 1);
        check(MIN_VALUE + 1, MIN_VALUE / 2, 1, MAX_VALUE / 2, 1);
        check(MIN_VALUE + 1, MIN_VALUE / 2, 1, MAX_VALUE - 1, 1);
        check(MIN_VALUE + 1, MIN_VALUE / 2, 1, MAX_VALUE, 1);
        //third is MAX_VALUE / 2
        check(MIN_VALUE + 1, MIN_VALUE / 2, MAX_VALUE / 2, MAX_VALUE / 2, 1);
        check(MIN_VALUE + 1, MIN_VALUE / 2, MAX_VALUE / 2, MAX_VALUE - 1, 1);
        check(MIN_VALUE + 1, MIN_VALUE / 2, MAX_VALUE / 2, MAX_VALUE, 1);
        //third is MAX_VALUE - 1
        check(MIN_VALUE + 1, MIN_VALUE / 2, MAX_VALUE - 1, MAX_VALUE - 1, 1);
        check(MIN_VALUE + 1, MIN_VALUE / 2, MAX_VALUE - 1, MAX_VALUE, 1);
        //third is MAX_VALUE
        check(MIN_VALUE + 1, MIN_VALUE / 2, MAX_VALUE, MAX_VALUE, 1);

        //second is -1
        //third is -1
        check(MIN_VALUE + 1, -1, -1, -1, 1);
        check(MIN_VALUE + 1, -1, -1, 0, 0);
        check(MIN_VALUE + 1, -1, -1, 1, 1);
        check(MIN_VALUE + 1, -1, -1, MAX_VALUE / 2, 1);
        check(MIN_VALUE + 1, -1, -1, MAX_VALUE - 1, 1);
        check(MIN_VALUE + 1, -1, -1, MAX_VALUE, 1);
        //third is 0
        check(MIN_VALUE + 1, -1, 0, 0, 0);
        check(MIN_VALUE + 1, -1, 0, 1, 0);
        check(MIN_VALUE + 1, -1, 0, MAX_VALUE / 2, 0);
        check(MIN_VALUE + 1, -1, 0, MAX_VALUE - 1, 0);
        check(MIN_VALUE + 1, -1, 0, MAX_VALUE, 0);
        //third is 1
        check(MIN_VALUE + 1, -1, 1, 1, 1);
        check(MIN_VALUE + 1, -1, 1, MAX_VALUE / 2, 1);
        check(MIN_VALUE + 1, -1, 1, MAX_VALUE - 1, 1);
        check(MIN_VALUE + 1, -1, 1, MAX_VALUE, 1);
        //third is MAX_VALUE / 2
        check(MIN_VALUE + 1, -1, MAX_VALUE / 2, MAX_VALUE / 2, 1);
        check(MIN_VALUE + 1, -1, MAX_VALUE / 2, MAX_VALUE - 1, 1);
        check(MIN_VALUE + 1, -1, MAX_VALUE / 2, MAX_VALUE, 1);
        //third is MAX_VALUE - 1
        check(MIN_VALUE + 1, -1, MAX_VALUE - 1, MAX_VALUE - 1, 1);
        check(MIN_VALUE + 1, -1, MAX_VALUE - 1, MAX_VALUE, 1);
        //third is MAX_VALUE
        check(MIN_VALUE + 1, -1, MAX_VALUE, MAX_VALUE, 1);

        //second is 0
        //third is 0
        check(MIN_VALUE + 1, 0, 0, 0, 0);
        check(MIN_VALUE + 1, 0, 0, 1, 0);
        check(MIN_VALUE + 1, 0, 0, MAX_VALUE / 2, 0);
        check(MIN_VALUE + 1, 0, 0, MAX_VALUE - 1, 0);
        check(MIN_VALUE + 1, 0, 0, MAX_VALUE, 0);
        //third is 1
        check(MIN_VALUE + 1, 0, 1, 1, 0);
        check(MIN_VALUE + 1, 0, 1, MAX_VALUE / 2, 0);
        check(MIN_VALUE + 1, 0, 1, MAX_VALUE - 1, 0);
        check(MIN_VALUE + 1, 0, 1, MAX_VALUE, 0);
        //third is MAX_VALUE / 2
        check(MIN_VALUE + 1, 0, MAX_VALUE / 2, MAX_VALUE / 2, 0);
        check(MIN_VALUE + 1, 0, MAX_VALUE / 2, MAX_VALUE - 1, 0);
        check(MIN_VALUE + 1, 0, MAX_VALUE / 2, MAX_VALUE, 0);
        //third is MAX_VALUE - 1
        check(MIN_VALUE + 1, 0, MAX_VALUE - 1, MAX_VALUE - 1, 0);
        check(MIN_VALUE + 1, 0, MAX_VALUE - 1, MAX_VALUE, 0);
        //third is MAX_VALUE
        check(MIN_VALUE + 1, 0, MAX_VALUE, MAX_VALUE, 0);

        //second is 1
        //third is 1
        check(MIN_VALUE + 1, 1, 1, 1, 1);
        check(MIN_VALUE + 1, 1, 1, MAX_VALUE / 2, 1);
        check(MIN_VALUE + 1, 1, 1, MAX_VALUE - 1, 1);
        check(MIN_VALUE + 1, 1, 1, MAX_VALUE, 1);
        //third is MAX_VALUE / 2
        check(MIN_VALUE + 1, 1, MAX_VALUE / 2, MAX_VALUE / 2, 1);
        check(MIN_VALUE + 1, 1, MAX_VALUE / 2, MAX_VALUE - 1, 1);
        check(MIN_VALUE + 1, 1, MAX_VALUE / 2, MAX_VALUE, 1);
        //third is MAX_VALUE - 1
        check(MIN_VALUE + 1, 1, MAX_VALUE - 1, MAX_VALUE - 1, 1);
        check(MIN_VALUE + 1, 1, MAX_VALUE - 1, MAX_VALUE, 1);
        //third is MAX_VALUE
        check(MIN_VALUE + 1, 1, MAX_VALUE, MAX_VALUE, 1);

        //second is MAX_VALUE / 2
        //third is MAX_VALUE / 2
        check(MIN_VALUE + 1, MAX_VALUE / 2, MAX_VALUE / 2, MAX_VALUE / 2, 1);
        check(MIN_VALUE + 1, MAX_VALUE / 2, MAX_VALUE / 2, MAX_VALUE - 1, 1);
        check(MIN_VALUE + 1, MAX_VALUE / 2, MAX_VALUE / 2, MAX_VALUE, 1);
        //third is MAX_VALUE - 1
        check(MIN_VALUE + 1, MAX_VALUE / 2, MAX_VALUE - 1, MAX_VALUE - 1, 1);
        check(MIN_VALUE + 1, MAX_VALUE / 2, MAX_VALUE - 1, MAX_VALUE, 1);
        //third is MAX_VALUE
        check(MIN_VALUE + 1, MAX_VALUE / 2, MAX_VALUE, MAX_VALUE, 1);

        //second is MAX_VALUE - 1
        //third is MAX_VALUE - 1
        check(MIN_VALUE + 1, MAX_VALUE - 1, MAX_VALUE - 1, MAX_VALUE - 1, 1);
        check(MIN_VALUE + 1, MAX_VALUE - 1, MAX_VALUE - 1, MAX_VALUE, 1);
        //third is MAX_VALUE
        check(MIN_VALUE + 1, MAX_VALUE - 1, MAX_VALUE, MAX_VALUE, 1);

        //second is MAX_VALUE
        //third is MAX_VALUE
        check(MIN_VALUE + 1, MAX_VALUE - 1, MAX_VALUE, MAX_VALUE, 1);

        //first is MIN_VALUE + 2
        check(MIN_VALUE + 2, MIN_VALUE + 2, MIN_VALUE + 2, MIN_VALUE + 2, MAX_VALUE - 1);
        //first is MIN_VALUE / 2
        check(MIN_VALUE / 2, MIN_VALUE / 2, MIN_VALUE / 2, MIN_VALUE / 2, (MIN_VALUE / 2) * -1);
        //first is -1
        check(-1, -1, -1, -1, 1);
        //first is 0
        check(0, 0, 0, 0, 0);
        //first is 1
        check(1, 1, 1, 1, 1);
        //first is MAX_VALUE / 2
        check(MAX_VALUE / 2, MAX_VALUE / 2, MAX_VALUE / 2, MAX_VALUE / 2, MAX_VALUE / 2);
        //first is MAX_VALUE - 1
        check(MAX_VALUE - 1, MAX_VALUE - 1, MAX_VALUE - 1, MAX_VALUE - 1, MAX_VALUE - 1);
        //first is MAX_VALUE
        check(MAX_VALUE, MAX_VALUE, MAX_VALUE, MAX_VALUE, MAX_VALUE);
    }

    /**
     * Tests with non-valid args for task3 (gcd).
     * 50 tests for random non-valid args;
     * 220 boundary tests;
     * 270 tests at all.
     */
    @Test
    void nonValidArgsTests() { //50 + 220
        //50 random not valid args
        checkException(MIN_VALUE, 521, 1425, 5234);
        checkException(MIN_VALUE, 614, 6241, 242);
        checkException(MIN_VALUE, -762341, 752, 2);
        checkException(MIN_VALUE, -7141, 6523, 252);
        checkException(MIN_VALUE, 651341, -763, 752);
        checkException(MIN_VALUE, 14141, -8764, 9063);
        checkException(MIN_VALUE, 2414, 651, -624);
        checkException(MIN_VALUE, 8735, 12356, -252);
        checkException(MIN_VALUE, -512, 8624, -2411);
        checkException(MIN_VALUE, -76352, -313, -754);
        checkException(-513, MIN_VALUE, 1314, 13126);
        checkException(1316, MIN_VALUE, -6411, 7523);
        checkException(13, MIN_VALUE, -61341, -146);
        checkException(-143, MIN_VALUE, 651, 6414);
        checkException(-1313, MIN_VALUE, 1275214, 6131);
        checkException(132, MIN_VALUE, -5141, 1231);
        checkException(61, MIN_VALUE, -1316, -1541);
        checkException(641, MIN_VALUE, 751, -1313);
        checkException(-132, MIN_VALUE, 751, 2342);
        checkException(7655, MIN_VALUE, 65134, -7652);
        checkException(65123, 3414, MIN_VALUE, 1414);
        checkException(-6411, 55, MIN_VALUE, -1246);
        checkException(-124, 1755, MIN_VALUE, 6423);
        checkException(7124, 145, MIN_VALUE, -666);
        checkException(165, -6412, MIN_VALUE, -5241);
        checkException(-1412, 1246, MIN_VALUE, 145);
        checkException(86, -2614, MIN_VALUE, 124);
        checkException(-14, -1415, MIN_VALUE, 652);
        checkException(624, 1314, MIN_VALUE, -641);
        checkException(7242, 5, MIN_VALUE, -14);
        checkException(124, -72, 13, MIN_VALUE);
        checkException(54, 2514, 641, MIN_VALUE);
        checkException(-21, -522, -6513, MIN_VALUE);
        checkException(514, 6242, -166, MIN_VALUE);
        checkException(1, -141, -7512, MIN_VALUE);
        checkException(-123, -1313, 16, MIN_VALUE);
        checkException(-124, -414, 4141, MIN_VALUE);
        checkException(-65, 7414, 145, MIN_VALUE);
        checkException(51, 87, 1541, MIN_VALUE);
        checkException(-14, 14, -14, MIN_VALUE);
        checkException(MIN_VALUE, 3124, 74132, MIN_VALUE);
        checkException(MIN_VALUE, -15, MIN_VALUE, 613);
        checkException(MIN_VALUE, MIN_VALUE, -124, -124);
        checkException(MIN_VALUE, 124, MIN_VALUE, MIN_VALUE);
        checkException(MIN_VALUE, MIN_VALUE, MIN_VALUE, 15);
        checkException(614, MIN_VALUE, -124, MIN_VALUE);
        checkException(752, MIN_VALUE, MIN_VALUE, 735);
        checkException(234, MIN_VALUE, MIN_VALUE, MIN_VALUE);
        checkException(23, -125, MIN_VALUE, MIN_VALUE);
        checkException(MIN_VALUE, MIN_VALUE, MIN_VALUE, MIN_VALUE);

        //first is MIN_VALUE
        //second is MIN_VALUE
        //third is MIN_VALUE
        checkException(MIN_VALUE, MIN_VALUE, MIN_VALUE, MIN_VALUE);
        checkException(MIN_VALUE, MIN_VALUE, MIN_VALUE, MIN_VALUE + 1);
        checkException(MIN_VALUE, MIN_VALUE, MIN_VALUE, MIN_VALUE + 2);
        checkException(MIN_VALUE, MIN_VALUE, MIN_VALUE, MIN_VALUE / 2);
        checkException(MIN_VALUE, MIN_VALUE, MIN_VALUE, -1);
        checkException(MIN_VALUE, MIN_VALUE, MIN_VALUE, 0);
        checkException(MIN_VALUE, MIN_VALUE, MIN_VALUE, 1);
        checkException(MIN_VALUE, MIN_VALUE, MIN_VALUE, MAX_VALUE / 2);
        checkException(MIN_VALUE, MIN_VALUE, MIN_VALUE, MAX_VALUE - 1);
        checkException(MIN_VALUE, MIN_VALUE, MIN_VALUE, MAX_VALUE);
        //third is MIN_VALUE + 1
        checkException(MIN_VALUE, MIN_VALUE, MIN_VALUE + 1, MIN_VALUE + 1);
        checkException(MIN_VALUE, MIN_VALUE, MIN_VALUE + 1, MIN_VALUE + 2);
        checkException(MIN_VALUE, MIN_VALUE, MIN_VALUE + 1, MIN_VALUE / 2);
        checkException(MIN_VALUE, MIN_VALUE, MIN_VALUE + 1, -1);
        checkException(MIN_VALUE, MIN_VALUE, MIN_VALUE + 1, 0);
        checkException(MIN_VALUE, MIN_VALUE, MIN_VALUE + 1, 1);
        checkException(MIN_VALUE, MIN_VALUE, MIN_VALUE + 1, MAX_VALUE / 2);
        checkException(MIN_VALUE, MIN_VALUE, MIN_VALUE + 1, MAX_VALUE - 1);
        checkException(MIN_VALUE, MIN_VALUE, MIN_VALUE + 1, MAX_VALUE);
        //third is MIN_VALUE + 2
        checkException(MIN_VALUE, MIN_VALUE, MIN_VALUE + 2, MIN_VALUE + 2);
        checkException(MIN_VALUE, MIN_VALUE, MIN_VALUE + 2, MIN_VALUE / 2);
        checkException(MIN_VALUE, MIN_VALUE, MIN_VALUE + 2, -1);
        checkException(MIN_VALUE, MIN_VALUE, MIN_VALUE + 2, 0);
        checkException(MIN_VALUE, MIN_VALUE, MIN_VALUE + 2, 1);
        checkException(MIN_VALUE, MIN_VALUE, MIN_VALUE + 2, MAX_VALUE / 2);
        checkException(MIN_VALUE, MIN_VALUE, MIN_VALUE + 2, MAX_VALUE - 1);
        checkException(MIN_VALUE, MIN_VALUE, MIN_VALUE + 2, MAX_VALUE);
        //third is MIN_VALUE / 2
        checkException(MIN_VALUE, MIN_VALUE, MIN_VALUE / 2, MIN_VALUE / 2);
        checkException(MIN_VALUE, MIN_VALUE, MIN_VALUE / 2, -1);
        checkException(MIN_VALUE, MIN_VALUE, MIN_VALUE / 2, 0);
        checkException(MIN_VALUE, MIN_VALUE, MIN_VALUE / 2, 1);
        checkException(MIN_VALUE, MIN_VALUE, MIN_VALUE / 2, MAX_VALUE / 2);
        checkException(MIN_VALUE, MIN_VALUE, MIN_VALUE / 2, MAX_VALUE - 1);
        checkException(MIN_VALUE, MIN_VALUE, MIN_VALUE / 2, MAX_VALUE);
        //third is -1
        checkException(MIN_VALUE, MIN_VALUE, -1, -1);
        checkException(MIN_VALUE, MIN_VALUE, -1, 0);
        checkException(MIN_VALUE, MIN_VALUE, -1, 1);
        checkException(MIN_VALUE, MIN_VALUE, -1, MAX_VALUE / 2);
        checkException(MIN_VALUE, MIN_VALUE, -1, MAX_VALUE - 1);
        checkException(MIN_VALUE, MIN_VALUE, -1, MAX_VALUE);
        //third is 0
        checkException(MIN_VALUE, MIN_VALUE, 0, 0);
        checkException(MIN_VALUE, MIN_VALUE, 0, 1);
        checkException(MIN_VALUE, MIN_VALUE, 0, MAX_VALUE / 2);
        checkException(MIN_VALUE, MIN_VALUE, 0, MAX_VALUE - 1);
        checkException(MIN_VALUE, MIN_VALUE, 0, MAX_VALUE);
        //third is 1
        checkException(MIN_VALUE, MIN_VALUE, 1, 1);
        checkException(MIN_VALUE, MIN_VALUE, 1, MAX_VALUE / 2);
        checkException(MIN_VALUE, MIN_VALUE, 1, MAX_VALUE - 1);
        checkException(MIN_VALUE, MIN_VALUE, 1, MAX_VALUE);
        //third is MAX_VALUE / 2
        checkException(MIN_VALUE, MIN_VALUE, MAX_VALUE / 2, MAX_VALUE / 2);
        checkException(MIN_VALUE, MIN_VALUE, MAX_VALUE / 2, MAX_VALUE - 1);
        checkException(MIN_VALUE, MIN_VALUE, MAX_VALUE / 2, MAX_VALUE);
        //third is MAX_VALUE - 1
        checkException(MIN_VALUE, MIN_VALUE, MAX_VALUE - 1, MAX_VALUE - 1);
        checkException(MIN_VALUE, MIN_VALUE, MAX_VALUE - 1, MAX_VALUE);
        //third is MAX_VALUE
        checkException(MIN_VALUE, MIN_VALUE, MAX_VALUE, MAX_VALUE);

        //second is MIN_VALUE + 1
        //third is MIN_VALUE + 1
        checkException(MIN_VALUE, MIN_VALUE + 1, MIN_VALUE + 1, MIN_VALUE + 1);
        checkException(MIN_VALUE, MIN_VALUE + 1, MIN_VALUE + 1, MIN_VALUE + 2);
        checkException(MIN_VALUE, MIN_VALUE + 1, MIN_VALUE + 1, MIN_VALUE / 2);
        checkException(MIN_VALUE, MIN_VALUE + 1, MIN_VALUE + 1, -1);
        checkException(MIN_VALUE, MIN_VALUE + 1, MIN_VALUE + 1, 0);
        checkException(MIN_VALUE, MIN_VALUE + 1, MIN_VALUE + 1, 1);
        checkException(MIN_VALUE, MIN_VALUE + 1, MIN_VALUE + 1, MAX_VALUE / 2);
        checkException(MIN_VALUE, MIN_VALUE + 1, MIN_VALUE + 1, MAX_VALUE - 1);
        checkException(MIN_VALUE, MIN_VALUE + 1, MIN_VALUE + 1, MAX_VALUE);
        //third is MIN_VALUE + 2
        checkException(MIN_VALUE, MIN_VALUE + 1, MIN_VALUE + 2, MIN_VALUE + 2);
        checkException(MIN_VALUE, MIN_VALUE + 1, MIN_VALUE + 2, MIN_VALUE / 2);
        checkException(MIN_VALUE, MIN_VALUE + 1, MIN_VALUE + 2, -1);
        checkException(MIN_VALUE, MIN_VALUE + 1, MIN_VALUE + 2, 0);
        checkException(MIN_VALUE, MIN_VALUE + 1, MIN_VALUE + 2, 1);
        checkException(MIN_VALUE, MIN_VALUE + 1, MIN_VALUE + 2, MAX_VALUE / 2);
        checkException(MIN_VALUE, MIN_VALUE + 1, MIN_VALUE + 2, MAX_VALUE - 1);
        checkException(MIN_VALUE, MIN_VALUE + 1, MIN_VALUE + 2, MAX_VALUE);
        //third is MIN_VALUE / 2
        checkException(MIN_VALUE, MIN_VALUE + 1, MIN_VALUE / 2, MIN_VALUE / 2);
        checkException(MIN_VALUE, MIN_VALUE + 1, MIN_VALUE / 2, -1);
        checkException(MIN_VALUE, MIN_VALUE + 1, MIN_VALUE / 2, 0);
        checkException(MIN_VALUE, MIN_VALUE + 1, MIN_VALUE / 2, 1);
        checkException(MIN_VALUE, MIN_VALUE + 1, MIN_VALUE / 2, MAX_VALUE / 2);
        checkException(MIN_VALUE, MIN_VALUE + 1, MIN_VALUE / 2, MAX_VALUE - 1);
        checkException(MIN_VALUE, MIN_VALUE + 1, MIN_VALUE / 2, MAX_VALUE);
        //third is -1
        checkException(MIN_VALUE, MIN_VALUE + 1, -1, -1);
        checkException(MIN_VALUE, MIN_VALUE + 1, -1, 0);
        checkException(MIN_VALUE, MIN_VALUE + 1, -1, 1);
        checkException(MIN_VALUE, MIN_VALUE + 1, -1, MAX_VALUE / 2);
        checkException(MIN_VALUE, MIN_VALUE + 1, -1, MAX_VALUE - 1);
        checkException(MIN_VALUE, MIN_VALUE + 1, -1, MAX_VALUE);
        //third is 0
        checkException(MIN_VALUE, MIN_VALUE + 1, 0, 0);
        checkException(MIN_VALUE, MIN_VALUE + 1, 0, 1);
        checkException(MIN_VALUE, MIN_VALUE + 1, 0, MAX_VALUE / 2);
        checkException(MIN_VALUE, MIN_VALUE + 1, 0, MAX_VALUE - 1);
        checkException(MIN_VALUE, MIN_VALUE + 1, 0, MAX_VALUE);
        //third is 1
        checkException(MIN_VALUE, MIN_VALUE + 1, 1, 1);
        checkException(MIN_VALUE, MIN_VALUE + 1, 1, MAX_VALUE / 2);
        checkException(MIN_VALUE, MIN_VALUE + 1, 1, MAX_VALUE - 1);
        checkException(MIN_VALUE, MIN_VALUE + 1, 1, MAX_VALUE);
        //third is MAX_VALUE / 2
        checkException(MIN_VALUE, MIN_VALUE + 1, MAX_VALUE / 2, MAX_VALUE / 2);
        checkException(MIN_VALUE, MIN_VALUE + 1, MAX_VALUE / 2, MAX_VALUE - 1);
        checkException(MIN_VALUE, MIN_VALUE + 1, MAX_VALUE / 2, MAX_VALUE);
        //third is MAX_VALUE - 1
        checkException(MIN_VALUE, MIN_VALUE + 1, MAX_VALUE - 1, MAX_VALUE - 1);
        checkException(MIN_VALUE, MIN_VALUE + 1, MAX_VALUE - 1, MAX_VALUE);
        //third is MAX_VALUE
        checkException(MIN_VALUE, MIN_VALUE + 1, MAX_VALUE, MAX_VALUE);

        //second is MIN_VALUE + 2
        //third is MIN_VALUE + 2
        checkException(MIN_VALUE, MIN_VALUE + 2, MIN_VALUE + 2, MIN_VALUE + 2);
        checkException(MIN_VALUE, MIN_VALUE + 2, MIN_VALUE + 2, MIN_VALUE / 2);
        checkException(MIN_VALUE, MIN_VALUE + 2, MIN_VALUE + 2, -1);
        checkException(MIN_VALUE, MIN_VALUE + 2, MIN_VALUE + 2, 0);
        checkException(MIN_VALUE, MIN_VALUE + 2, MIN_VALUE + 2, 1);
        checkException(MIN_VALUE, MIN_VALUE + 2, MIN_VALUE + 2, MAX_VALUE / 2);
        checkException(MIN_VALUE, MIN_VALUE + 2, MIN_VALUE + 2, MAX_VALUE - 1);
        checkException(MIN_VALUE, MIN_VALUE + 2, MIN_VALUE + 2, MAX_VALUE);
        //third is MIN_VALUE / 2
        checkException(MIN_VALUE, MIN_VALUE + 2, MIN_VALUE / 2, MIN_VALUE / 2);
        checkException(MIN_VALUE, MIN_VALUE + 2, MIN_VALUE / 2, -1);
        checkException(MIN_VALUE, MIN_VALUE + 2, MIN_VALUE / 2, 0);
        checkException(MIN_VALUE, MIN_VALUE + 2, MIN_VALUE / 2, 1);
        checkException(MIN_VALUE, MIN_VALUE + 2, MIN_VALUE / 2, MAX_VALUE / 2);
        checkException(MIN_VALUE, MIN_VALUE + 2, MIN_VALUE / 2, MAX_VALUE - 1);
        checkException(MIN_VALUE, MIN_VALUE + 2, MIN_VALUE / 2, MAX_VALUE);
        //third is -1
        checkException(MIN_VALUE, MIN_VALUE + 2, -1, -1);
        checkException(MIN_VALUE, MIN_VALUE + 2, -1, 0);
        checkException(MIN_VALUE, MIN_VALUE + 2, -1, 1);
        checkException(MIN_VALUE, MIN_VALUE + 2, -1, MAX_VALUE / 2);
        checkException(MIN_VALUE, MIN_VALUE + 2, -1, MAX_VALUE - 1);
        checkException(MIN_VALUE, MIN_VALUE + 2, -1, MAX_VALUE);
        //third is 0
        checkException(MIN_VALUE, MIN_VALUE + 2, 0, 0);
        checkException(MIN_VALUE, MIN_VALUE + 2, 0, 1);
        checkException(MIN_VALUE, MIN_VALUE + 2, 0, MAX_VALUE / 2);
        checkException(MIN_VALUE, MIN_VALUE + 2, 0, MAX_VALUE - 1);
        checkException(MIN_VALUE, MIN_VALUE + 2, 0, MAX_VALUE);
        //third is 1
        checkException(MIN_VALUE, MIN_VALUE + 2, 1, 1);
        checkException(MIN_VALUE, MIN_VALUE + 2, 1, MAX_VALUE / 2);
        checkException(MIN_VALUE, MIN_VALUE + 2, 1, MAX_VALUE - 1);
        checkException(MIN_VALUE, MIN_VALUE + 2, 1, MAX_VALUE);
        //third is MAX_VALUE / 2
        checkException(MIN_VALUE, MIN_VALUE + 2, MAX_VALUE / 2, MAX_VALUE / 2);
        checkException(MIN_VALUE, MIN_VALUE + 2, MAX_VALUE / 2, MAX_VALUE - 1);
        checkException(MIN_VALUE, MIN_VALUE + 2, MAX_VALUE / 2, MAX_VALUE);
        //third is MAX_VALUE - 1
        checkException(MIN_VALUE, MIN_VALUE + 2, MAX_VALUE - 1, MAX_VALUE - 1);
        checkException(MIN_VALUE, MIN_VALUE + 2, MAX_VALUE - 1, MAX_VALUE);
        //third is MAX_VALUE
        checkException(MIN_VALUE, MIN_VALUE + 2, MAX_VALUE, MAX_VALUE);

        //second is MIN_VALUE / 2
        //third is MIN_VALUE / 2
        checkException(MIN_VALUE, MIN_VALUE / 2, MIN_VALUE / 2, MIN_VALUE / 2);
        checkException(MIN_VALUE, MIN_VALUE / 2, MIN_VALUE / 2, -1);
        checkException(MIN_VALUE, MIN_VALUE / 2, MIN_VALUE / 2, 0);
        checkException(MIN_VALUE, MIN_VALUE / 2, MIN_VALUE / 2, 1);
        checkException(MIN_VALUE, MIN_VALUE / 2, MIN_VALUE / 2, MAX_VALUE / 2);
        checkException(MIN_VALUE, MIN_VALUE / 2, MIN_VALUE / 2, MAX_VALUE - 1);
        checkException(MIN_VALUE, MIN_VALUE / 2, MIN_VALUE / 2, MAX_VALUE);
        //third is -1
        checkException(MIN_VALUE, MIN_VALUE / 2, -1, -1);
        checkException(MIN_VALUE, MIN_VALUE / 2, -1, 0);
        checkException(MIN_VALUE, MIN_VALUE / 2, -1, 1);
        checkException(MIN_VALUE, MIN_VALUE / 2, -1, MAX_VALUE / 2);
        checkException(MIN_VALUE, MIN_VALUE / 2, -1, MAX_VALUE - 1);
        checkException(MIN_VALUE, MIN_VALUE / 2, -1, MAX_VALUE);
        //third is 0
        checkException(MIN_VALUE, MIN_VALUE / 2, 0, 0);
        checkException(MIN_VALUE, MIN_VALUE / 2, 0, 1);
        checkException(MIN_VALUE, MIN_VALUE / 2, 0, MAX_VALUE / 2);
        checkException(MIN_VALUE, MIN_VALUE / 2, 0, MAX_VALUE - 1);
        checkException(MIN_VALUE, MIN_VALUE / 2, 0, MAX_VALUE);
        //third is 1
        checkException(MIN_VALUE, MIN_VALUE / 2, 1, 1);
        checkException(MIN_VALUE, MIN_VALUE / 2, 1, MAX_VALUE / 2);
        checkException(MIN_VALUE, MIN_VALUE / 2, 1, MAX_VALUE - 1);
        checkException(MIN_VALUE, MIN_VALUE / 2, 1, MAX_VALUE);
        //third is MAX_VALUE / 2
        checkException(MIN_VALUE, MIN_VALUE / 2, MAX_VALUE / 2, MAX_VALUE / 2);
        checkException(MIN_VALUE, MIN_VALUE / 2, MAX_VALUE / 2, MAX_VALUE - 1);
        checkException(MIN_VALUE, MIN_VALUE / 2, MAX_VALUE / 2, MAX_VALUE);
        //third is MAX_VALUE - 1
        checkException(MIN_VALUE, MIN_VALUE / 2, MAX_VALUE - 1, MAX_VALUE - 1);
        checkException(MIN_VALUE, MIN_VALUE / 2, MAX_VALUE - 1, MAX_VALUE);
        //third is MAX_VALUE
        checkException(MIN_VALUE, MIN_VALUE / 2, MAX_VALUE, MAX_VALUE);

        //second is -1
        //third is -1
        checkException(MIN_VALUE, -1, -1, -1);
        checkException(MIN_VALUE, -1, -1, 0);
        checkException(MIN_VALUE, -1, -1, 1);
        checkException(MIN_VALUE, -1, -1, MAX_VALUE / 2);
        checkException(MIN_VALUE, -1, -1, MAX_VALUE - 1);
        checkException(MIN_VALUE, -1, -1, MAX_VALUE);
        //third is 0
        checkException(MIN_VALUE, -1, 0, 0);
        checkException(MIN_VALUE, -1, 0, 1);
        checkException(MIN_VALUE, -1, 0, MAX_VALUE / 2);
        checkException(MIN_VALUE, -1, 0, MAX_VALUE - 1);
        checkException(MIN_VALUE, -1, 0, MAX_VALUE);
        //third is 1
        checkException(MIN_VALUE, -1, 1, 1);
        checkException(MIN_VALUE, -1, 1, MAX_VALUE / 2);
        checkException(MIN_VALUE, -1, 1, MAX_VALUE - 1);
        checkException(MIN_VALUE, -1, 1, MAX_VALUE);
        //third is MAX_VALUE / 2
        checkException(MIN_VALUE, -1, MAX_VALUE / 2, MAX_VALUE / 2);
        checkException(MIN_VALUE, -1, MAX_VALUE / 2, MAX_VALUE - 1);
        checkException(MIN_VALUE, -1, MAX_VALUE / 2, MAX_VALUE);
        //third is MAX_VALUE - 1
        checkException(MIN_VALUE, -1, MAX_VALUE - 1, MAX_VALUE - 1);
        checkException(MIN_VALUE, -1, MAX_VALUE - 1, MAX_VALUE);
        //third is MAX_VALUE
        checkException(MIN_VALUE, -1, MAX_VALUE, MAX_VALUE);

        //second is 0
        //third is 0
        checkException(MIN_VALUE, 0, 0, 0);
        checkException(MIN_VALUE, 0, 0, 1);
        checkException(MIN_VALUE, 0, 0, MAX_VALUE / 2);
        checkException(MIN_VALUE, 0, 0, MAX_VALUE - 1);
        checkException(MIN_VALUE, 0, 0, MAX_VALUE);
        //third is 1
        checkException(MIN_VALUE, 0, 1, 1);
        checkException(MIN_VALUE, 0, 1, MAX_VALUE / 2);
        checkException(MIN_VALUE, 0, 1, MAX_VALUE - 1);
        checkException(MIN_VALUE, 0, 1, MAX_VALUE);
        //third is MAX_VALUE / 2
        checkException(MIN_VALUE, 0, MAX_VALUE / 2, MAX_VALUE / 2);
        checkException(MIN_VALUE, 0, MAX_VALUE / 2, MAX_VALUE - 1);
        checkException(MIN_VALUE, 0, MAX_VALUE / 2, MAX_VALUE);
        //third is MAX_VALUE - 1
        checkException(MIN_VALUE, 0, MAX_VALUE - 1, MAX_VALUE - 1);
        checkException(MIN_VALUE, 0, MAX_VALUE - 1, MAX_VALUE);
        //third is MAX_VALUE
        checkException(MIN_VALUE, 0, MAX_VALUE, MAX_VALUE);

        //second is 1
        //third is 1
        checkException(MIN_VALUE, 1, 1, 1);
        checkException(MIN_VALUE, 1, 1, MAX_VALUE / 2);
        checkException(MIN_VALUE, 1, 1, MAX_VALUE - 1);
        checkException(MIN_VALUE, 1, 1, MAX_VALUE);
        //third is MAX_VALUE / 2
        checkException(MIN_VALUE, 1, MAX_VALUE / 2, MAX_VALUE / 2);
        checkException(MIN_VALUE, 1, MAX_VALUE / 2, MAX_VALUE - 1);
        checkException(MIN_VALUE, 1, MAX_VALUE / 2, MAX_VALUE);
        //third is MAX_VALUE - 1
        checkException(MIN_VALUE, 1, MAX_VALUE - 1, MAX_VALUE - 1);
        checkException(MIN_VALUE, 1, MAX_VALUE - 1, MAX_VALUE);
        //third is MAX_VALUE
        checkException(MIN_VALUE, 1, MAX_VALUE, MAX_VALUE);

        //second is MAX_VALUE / 2
        //third is MAX_VALUE / 2
        checkException(MIN_VALUE, MAX_VALUE / 2, MAX_VALUE / 2, MAX_VALUE / 2);
        checkException(MIN_VALUE, MAX_VALUE / 2, MAX_VALUE / 2, MAX_VALUE - 1);
        checkException(MIN_VALUE, MAX_VALUE / 2, MAX_VALUE / 2, MAX_VALUE);
        //third is MAX_VALUE - 1
        checkException(MIN_VALUE, MAX_VALUE / 2, MAX_VALUE - 1, MAX_VALUE - 1);
        checkException(MIN_VALUE, MAX_VALUE / 2, MAX_VALUE - 1, MAX_VALUE);
        //third is MAX_VALUE
        checkException(MIN_VALUE, MAX_VALUE / 2, MAX_VALUE, MAX_VALUE);

        //second is MAX_VALUE - 1
        //third is MAX_VALUE - 1
        checkException(MIN_VALUE, MAX_VALUE - 1, MAX_VALUE - 1, MAX_VALUE - 1);
        checkException(MIN_VALUE, MAX_VALUE - 1, MAX_VALUE - 1, MAX_VALUE);
        //third is MAX_VALUE
        checkException(MIN_VALUE, MAX_VALUE - 1, MAX_VALUE, MAX_VALUE);

        //second is MAX_VALUE
        //third is MAX_VALUE
        checkException(MIN_VALUE, MAX_VALUE, MAX_VALUE, MAX_VALUE);
    }

    /**
     * Function for testing valid args for task3 (gcd).
     * For inputted args define greatest common divisor.
     * Simulates user input from console with valid args.
     *
     * @param a        first parameter.
     * @param b        second parameter.
     * @param c        third parameter.
     * @param d        fourth parameter.
     * @param expected expected result of gcd for inputted args.
     */
    void check(int a, int b, int c, int d, int expected) {
        //Task 3 by itself
        int actual = GreatestCommonDivisor.nod4args(a, b, c, d);
        assertEquals(expected, actual);

        //Task 3 in main
        String input = "3" + L_S + a + L_S + b + L_S + c + L_S + d;
        String expectedMain = MESSAGE +
                expected + L_S;

        runMain(input, expectedMain);
    }

    /**
     * Function for testing non-valid args for task3 (gcd).
     * For inputted parameters an IllegalArgumentException should be thrown.
     * Simulates user input from console with non-valid args.
     *
     * @param a first parameter.
     * @param b second parameter.
     * @param c third parameter.
     * @param d fourth parameter.
     * @see IllegalArgumentException
     */
    void checkException(int a, int b, int c, int d) {
        //Task 3 by itself
        try {
            GreatestCommonDivisor.nod4args(a, b, c, d);
            fail("Exception was not thrown");
        } catch (IllegalArgumentException e) {
            //correct behavior
        }

        //Task 3 in main
        String input = "3" + L_S + a + L_S + b + L_S + c + L_S + d;
        String expectedMain = MESSAGE +
                "Wrong input. Expected: numbers not less than " + MIN_VALUE + L_S +
                "Got: " + a + ", " + b + ", " + c + ", " + d + L_S;

        runMain(input, expectedMain);
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
