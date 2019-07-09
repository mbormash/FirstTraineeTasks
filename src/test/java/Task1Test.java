import com.implemica.bormashenko.Task1;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static java.lang.Integer.MIN_VALUE;
import static java.lang.Integer.MAX_VALUE;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for Task1 (swap).
 *
 * @author Mykhailo Bormashenko
 */
class Task1Test {

    /**
     * Object of Task1.
     */
    private static Task1 obj;

    /**
     * Function for testing task1 (swap).
     * Values of two parameters should be swapped between each other.
     * @param aBefore value of first test parameter.
     * @param bBefore value of second test parameter.
     */
    private void check(int aBefore, int bBefore) {
        obj.setA(aBefore);
        obj.setB(bBefore);
        obj.swap();
        int aAfter = obj.getA();
        int bAfter = obj.getB();
        assertEquals(bBefore, aAfter);
        assertEquals(aBefore, bAfter);
    }

    /**
     * Setting up object.
     */
    @BeforeAll
    static void setupBeforeTests() {
        obj = new Task1();
    }

    /**
     * Tests for task1 (swap).
     */
    @Test
    void tests() { //24 + 24 + 12 + 81
        //positive and positive
        check(9, 10);
        check(99, 100);
        check(999, 1000);
        check(9999, 10000);
        check(99999, 100000);
        check(999999, 1000000);
        //negative and negative
        check(-9, -100);
        check(-99, -1000);
        check(-999, -10000);
        check(-9999, -100000);
        check(-99999, -1000000);
        check(-999999, -10000000);
        //positive and negative
        check(10, -9);
        check(100, -99);
        check(1000, -999);
        check(10000, -9999);
        check(100000, -99999);
        check(1000000, -999999);
        //negative and positive
        check(-100, 99);
        check(-1000, 999);
        check(-10000, 9999);
        check(-100000, 99999);
        check(-1000000, 999999);
        check(-10000000, 9999999);
        //random
        check(123, 762);
        check(1257, -62234);
        check(352435, 2431);
        check(-92341999, 12311);
        check(-991231999, 86252);
        check(3213, -63452);
        check(-132, -3452);
        check(913139, -323);
        check(91213199, -13235);
        check(-321312, -345241);
        check(313, -2432424);
        check(8763, -2);
        check(10, 0);
        check(-2341, 324234);
        check(12313, -3452);
        check(-1312, -1468);
        check(1234, -2452);
        check(681, 234);
        check(-975, 8);
        check(44, 335);
        check(662, 123);
        check(-2756, 762);
        check(13, 8664);
        check(1231, 12);
        //same numbers
        check(11, 11);
        check(5434, 5434);
        check(11231231, 11231231);
        check(-6345, -6345);
        check(75, 75);
        check(2341, 2341);
        check(-112, -112);
        check(8873, 8873);
        check(12346, 12346);
        check(975, 975);
        check(-732, -732);
        check(-1314, -1314);

        //first is MAX_VALUE
        check(MAX_VALUE, MAX_VALUE);
        check(MAX_VALUE, MAX_VALUE - 1);
        check(MAX_VALUE, MAX_VALUE / 2);
        check(MAX_VALUE, 1);
        check(MAX_VALUE, 0);
        check(MAX_VALUE, -1);
        check(MAX_VALUE, MIN_VALUE / 2);
        check(MAX_VALUE, MIN_VALUE + 1);
        check(MAX_VALUE, MIN_VALUE);

        //first is MAX_VALUE - 1
        check(MAX_VALUE - 1, MAX_VALUE);
        check(MAX_VALUE - 1, MAX_VALUE - 1);
        check(MAX_VALUE - 1, MAX_VALUE / 2);
        check(MAX_VALUE - 1, 1);
        check(MAX_VALUE - 1, 0);
        check(MAX_VALUE - 1, -1);
        check(MAX_VALUE - 1, MIN_VALUE / 2);
        check(MAX_VALUE - 1, MIN_VALUE + 1);
        check(MAX_VALUE - 1, MIN_VALUE);

        //first is MAX_VALUE / 2
        check(MAX_VALUE / 2, MAX_VALUE);
        check(MAX_VALUE / 2, MAX_VALUE - 1);
        check(MAX_VALUE / 2, MAX_VALUE / 2);
        check(MAX_VALUE / 2, 1);
        check(MAX_VALUE / 2, 0);
        check(MAX_VALUE / 2, -1);
        check(MAX_VALUE / 2, MIN_VALUE / 2);
        check(MAX_VALUE / 2, MIN_VALUE + 1);
        check(MAX_VALUE / 2, MIN_VALUE);

        //first is 1
        check(1, MAX_VALUE);
        check(1, MAX_VALUE - 1);
        check(1, MAX_VALUE / 2);
        check(1, 1);
        check(1, 0);
        check(1, -1);
        check(1, MIN_VALUE / 2);
        check(1, MIN_VALUE + 1);
        check(1, MIN_VALUE);

        //first is 0
        check(0, MAX_VALUE);
        check(0, MAX_VALUE - 1);
        check(0, MAX_VALUE / 2);
        check(0, 1);
        check(0, 0);
        check(0, -1);
        check(0, MIN_VALUE / 2);
        check(0, MIN_VALUE + 1);
        check(0, MIN_VALUE);

        //first is -1
        check(-1, MAX_VALUE);
        check(-1, MAX_VALUE - 1);
        check(-1, MAX_VALUE / 2);
        check(-1, 1);
        check(-1, 0);
        check(-1, -1);
        check(-1, MIN_VALUE / 2);
        check(-1, MIN_VALUE + 1);
        check(-1, MIN_VALUE);

        //first is MIN_VALUE / 2
        check(MIN_VALUE / 2, MAX_VALUE);
        check(MIN_VALUE / 2, MAX_VALUE - 1);
        check(MIN_VALUE / 2, MAX_VALUE / 2);
        check(MIN_VALUE / 2, 1);
        check(MIN_VALUE / 2, 0);
        check(MIN_VALUE / 2, -1);
        check(MIN_VALUE / 2, MIN_VALUE / 2);
        check(MIN_VALUE / 21, MIN_VALUE + 1);
        check(MIN_VALUE / 2, MIN_VALUE);

        //first is MIN_VALUE + 1
        check(MIN_VALUE + 1, MAX_VALUE);
        check(MIN_VALUE + 1, MAX_VALUE - 1);
        check(MIN_VALUE + 1, MAX_VALUE / 2);
        check(MIN_VALUE + 1, 1);
        check(MIN_VALUE + 1, 0);
        check(MIN_VALUE + 1, -1);
        check(MIN_VALUE + 1, MIN_VALUE / 2);
        check(MIN_VALUE + 1, MIN_VALUE + 1);
        check(MIN_VALUE + 1, MIN_VALUE);

        //first is MIN_VALUE
        check(MIN_VALUE, MAX_VALUE);
        check(MIN_VALUE, MAX_VALUE - 1);
        check(MIN_VALUE, MAX_VALUE / 2);
        check(MIN_VALUE, 1);
        check(MIN_VALUE, 0);
        check(MIN_VALUE, -1);
        check(MIN_VALUE, MIN_VALUE / 2);
        check(MIN_VALUE, MIN_VALUE + 1);
        check(MIN_VALUE, MIN_VALUE);
    }
}
