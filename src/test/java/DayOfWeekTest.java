import com.implemica.bormashenko.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static com.implemica.bormashenko.DayOfWeek.DaysOfWeek;
import static com.implemica.bormashenko.DayOfWeek.Months;

/**
 * Test class for DayOfWeek (day of week).
 *
 * @author Mykhailo Bormashenko
 */
class DayOfWeekTest {

    /**
     * Constant for lineSeparator.
     */
    private static final String L_S = System.lineSeparator();

    /**
     * Max amount of days in 28-day month.
     */
    private static final int MAX_DAY_OF_MONTH_28 = 28;

    /**
     * Max amount of days in 30-day months.
     */
    private static final int MAX_DAY_OF_MONTH_30 = 30;

    /**
     * Max amount of days in 31-day months.
     */
    private static final int MAX_DAY_OF_MONTH_31 = 31;

    /**
     * Message shown for all cases in main.
     */
    private static final String MESSAGE = "Input number of task from 1 to 5." + L_S +
            "Task 5: day of week." + L_S +
            "Input day of New Year, day to find, month to find." + L_S;

    /**
     * Tests with valid args for task5 (day of week).
     * 7 tests for several values return from "Monday" to "Sunday";
     * 7 * 12 * 7 (168) boundary and special values tests;
     * 175 tests at all.
     */
    @Test
    void validArgsTests() {
        //several random tests
        check(2, 27, 5, "Monday");
        check(3, 15, 7, "Tuesday");
        check(5, 7, 7, "Wednesday");
        check(2, 28, 3, "Thursday");
        check(2, 20, 12, "Friday");
        check(5, 1, 5, "Saturday");
        check(5, 10, 10, "Sunday");

        //day of New Year is Monday
        //month is 1
        check(1, 1, 1, "Monday");
        check(1, 2, 1, "Tuesday");
        check(1, 7, 1, "Sunday");
        check(1, 8, 1, "Monday");
        check(1, 9, 1, "Tuesday");
        check(1, MAX_DAY_OF_MONTH_31 - 1, 1, "Tuesday");
        check(1, MAX_DAY_OF_MONTH_31, 1, "Wednesday");
        //month is 2
        check(1, 1, 2, "Thursday");
        check(1, 2, 2, "Friday");
        check(1, 7, 2, "Wednesday");
        check(1, 8, 2, "Thursday");
        check(1, 9, 2, "Friday");
        check(1, MAX_DAY_OF_MONTH_28 - 1, 2, "Tuesday");
        check(1, MAX_DAY_OF_MONTH_28, 2, "Wednesday");
        //month is 3
        check(1, 1, 3, "Thursday");
        check(1, 2, 3, "Friday");
        check(1, 7, 3, "Wednesday");
        check(1, 8, 3, "Thursday");
        check(1, 9, 3, "Friday");
        check(1, MAX_DAY_OF_MONTH_31 - 1, 3, "Friday");
        check(1, MAX_DAY_OF_MONTH_31, 3, "Saturday");
        //month is 4
        check(1, 1, 4, "Sunday");
        check(1, 2, 4, "Monday");
        check(1, 7, 4, "Saturday");
        check(1, 8, 4, "Sunday");
        check(1, 9, 4, "Monday");
        check(1, MAX_DAY_OF_MONTH_30 - 1, 4, "Sunday");
        check(1, MAX_DAY_OF_MONTH_30, 4, "Monday");
        //month is 5
        check(1, 1, 5, "Tuesday");
        check(1, 2, 5, "Wednesday");
        check(1, 7, 5, "Monday");
        check(1, 8, 5, "Tuesday");
        check(1, 9, 5, "Wednesday");
        check(1, MAX_DAY_OF_MONTH_31 - 1, 5, "Wednesday");
        check(1, MAX_DAY_OF_MONTH_31, 5, "Thursday");
        //month is 6
        check(1, 1, 6, "Friday");
        check(1, 2, 6, "Saturday");
        check(1, 7, 6, "Thursday");
        check(1, 8, 6, "Friday");
        check(1, 9, 6, "Saturday");
        check(1, MAX_DAY_OF_MONTH_30 - 1, 6, "Friday");
        check(1, MAX_DAY_OF_MONTH_30, 6, "Saturday");
        //month is 7
        check(1, 1, 7, "Sunday");
        check(1, 2, 7, "Monday");
        check(1, 7, 7, "Saturday");
        check(1, 8, 7, "Sunday");
        check(1, 9, 7, "Monday");
        check(1, MAX_DAY_OF_MONTH_31 - 1, 7, "Monday");
        check(1, MAX_DAY_OF_MONTH_31, 7, "Tuesday");
        //month is 8
        check(1, 1, 8, "Wednesday");
        check(1, 2, 8, "Thursday");
        check(1, 7, 8, "Tuesday");
        check(1, 8, 8, "Wednesday");
        check(1, 9, 8, "Thursday");
        check(1, MAX_DAY_OF_MONTH_31 - 1, 8, "Thursday");
        check(1, MAX_DAY_OF_MONTH_31, 8, "Friday");
        //month is 9
        check(1, 1, 9, "Saturday");
        check(1, 2, 9, "Sunday");
        check(1, 7, 9, "Friday");
        check(1, 8, 9, "Saturday");
        check(1, 9, 9, "Sunday");
        check(1, MAX_DAY_OF_MONTH_30 - 1, 9, "Saturday");
        check(1, MAX_DAY_OF_MONTH_30, 9, "Sunday");
        //month is 10
        check(1, 1, 10, "Monday");
        check(1, 2, 10, "Tuesday");
        check(1, 7, 10, "Sunday");
        check(1, 8, 10, "Monday");
        check(1, 9, 10, "Tuesday");
        check(1, MAX_DAY_OF_MONTH_31 - 1, 10, "Tuesday");
        check(1, MAX_DAY_OF_MONTH_31, 10, "Wednesday");
        //month is 11
        check(1, 1, 11, "Thursday");
        check(1, 2, 11, "Friday");
        check(1, 7, 11, "Wednesday");
        check(1, 8, 11, "Thursday");
        check(1, 9, 11, "Friday");
        check(1, MAX_DAY_OF_MONTH_30 - 1, 11, "Thursday");
        check(1, MAX_DAY_OF_MONTH_30, 11, "Friday");
        //month is 12
        check(1, 1, 12, "Saturday");
        check(1, 2, 12, "Sunday");
        check(1, 7, 12, "Friday");
        check(1, 8, 12, "Saturday");
        check(1, 9, 12, "Sunday");
        check(1, MAX_DAY_OF_MONTH_31 - 1, 12, "Sunday");
        check(1, MAX_DAY_OF_MONTH_31, 12, "Monday");

        //day of New Year is Tuesday
        //month is 1
        check(2, 1, 1, "Tuesday");
        check(2, 2, 1, "Wednesday");
        check(2, 7, 1, "Monday");
        check(2, 8, 1, "Tuesday");
        check(2, 9, 1, "Wednesday");
        check(2, MAX_DAY_OF_MONTH_31 - 1, 1, "Wednesday");
        check(2, MAX_DAY_OF_MONTH_31, 1, "Thursday");
        //month is 2
        check(2, 1, 2, "Friday");
        check(2, 2, 2, "Saturday");
        check(2, 7, 2, "Thursday");
        check(2, 8, 2, "Friday");
        check(2, 9, 2, "Saturday");
        check(2, MAX_DAY_OF_MONTH_28 - 1, 2, "Wednesday");
        check(2, MAX_DAY_OF_MONTH_28, 2, "Thursday");
        //month is 3
        check(2, 1, 3, "Friday");
        check(2, 2, 3, "Saturday");
        check(2, 7, 3, "Thursday");
        check(2, 8, 3, "Friday");
        check(2, 9, 3, "Saturday");
        check(2, MAX_DAY_OF_MONTH_31 - 1, 3, "Saturday");
        check(2, MAX_DAY_OF_MONTH_31, 3, "Sunday");
        //month is 4
        check(2, 1, 4, "Monday");
        check(2, 2, 4, "Tuesday");
        check(2, 7, 4, "Sunday");
        check(2, 8, 4, "Monday");
        check(2, 9, 4, "Tuesday");
        check(2, MAX_DAY_OF_MONTH_30 - 1, 4, "Monday");
        check(2, MAX_DAY_OF_MONTH_30, 4, "Tuesday");
        //month is 5
        check(2, 1, 5, "Wednesday");
        check(2, 2, 5, "Thursday");
        check(2, 7, 5, "Tuesday");
        check(2, 8, 5, "Wednesday");
        check(2, 9, 5, "Thursday");
        check(2, MAX_DAY_OF_MONTH_31 - 1, 5, "Thursday");
        check(2, MAX_DAY_OF_MONTH_31, 5, "Friday");
        //month is 6
        check(2, 1, 6, "Saturday");
        check(2, 2, 6, "Sunday");
        check(2, 7, 6, "Friday");
        check(2, 8, 6, "Saturday");
        check(2, 9, 6, "Sunday");
        check(2, MAX_DAY_OF_MONTH_30 - 1, 6, "Saturday");
        check(2, MAX_DAY_OF_MONTH_30, 6, "Sunday");
        //month is 7
        check(2, 1, 7, "Monday");
        check(2, 2, 7, "Tuesday");
        check(2, 7, 7, "Sunday");
        check(2, 8, 7, "Monday");
        check(2, 9, 7, "Tuesday");
        check(2, MAX_DAY_OF_MONTH_31 - 1, 7, "Tuesday");
        check(2, MAX_DAY_OF_MONTH_31, 7, "Wednesday");
        //month is 8
        check(2, 1, 8, "Thursday");
        check(2, 2, 8, "Friday");
        check(2, 7, 8, "Wednesday");
        check(2, 8, 8, "Thursday");
        check(2, 9, 8, "Friday");
        check(2, MAX_DAY_OF_MONTH_31 - 1, 8, "Friday");
        check(2, MAX_DAY_OF_MONTH_31, 8, "Saturday");
        //month is 9
        check(2, 1, 9, "Sunday");
        check(2, 2, 9, "Monday");
        check(2, 7, 9, "Saturday");
        check(2, 8, 9, "Sunday");
        check(2, 9, 9, "Monday");
        check(2, MAX_DAY_OF_MONTH_30 - 1, 9, "Sunday");
        check(2, MAX_DAY_OF_MONTH_30, 9, "Monday");
        //month is 10
        check(2, 1, 10, "Tuesday");
        check(2, 2, 10, "Wednesday");
        check(2, 7, 10, "Monday");
        check(2, 8, 10, "Tuesday");
        check(2, 9, 10, "Wednesday");
        check(2, MAX_DAY_OF_MONTH_31 - 1, 10, "Wednesday");
        check(2, MAX_DAY_OF_MONTH_31, 10, "Thursday");
        //month is 11
        check(2, 1, 11, "Friday");
        check(2, 2, 11, "Saturday");
        check(2, 7, 11, "Thursday");
        check(2, 8, 11, "Friday");
        check(2, 9, 11, "Saturday");
        check(2, MAX_DAY_OF_MONTH_30 - 1, 11, "Friday");
        check(2, MAX_DAY_OF_MONTH_30, 11, "Saturday");
        //month is 12
        check(2, 1, 12, "Sunday");
        check(2, 2, 12, "Monday");
        check(2, 7, 12, "Saturday");
        check(2, 8, 12, "Sunday");
        check(2, 9, 12, "Monday");
        check(2, MAX_DAY_OF_MONTH_31 - 1, 12, "Monday");
        check(2, MAX_DAY_OF_MONTH_31, 12, "Tuesday");

        //day of New Year is Wednesday
        //month is 1
        check(3, 1, 1, "Wednesday");
        check(3, 2, 1, "Thursday");
        check(3, 7, 1, "Tuesday");
        check(3, 8, 1, "Wednesday");
        check(3, 9, 1, "Thursday");
        check(3, MAX_DAY_OF_MONTH_31 - 1, 1, "Thursday");
        check(3, MAX_DAY_OF_MONTH_31, 1, "Friday");
        //month is 2
        check(3, 1, 2, "Saturday");
        check(3, 2, 2, "Sunday");
        check(3, 7, 2, "Friday");
        check(3, 8, 2, "Saturday");
        check(3, 9, 2, "Sunday");
        check(3, MAX_DAY_OF_MONTH_28 - 1, 2, "Thursday");
        check(3, MAX_DAY_OF_MONTH_28, 2, "Friday");
        //month is 3
        check(3, 1, 3, "Saturday");
        check(3, 2, 3, "Sunday");
        check(3, 7, 3, "Friday");
        check(3, 8, 3, "Saturday");
        check(3, 9, 3, "Sunday");
        check(3, MAX_DAY_OF_MONTH_31 - 1, 3, "Sunday");
        check(3, MAX_DAY_OF_MONTH_31, 3, "Monday");
        //month is 4
        check(3, 1, 4, "Tuesday");
        check(3, 2, 4, "Wednesday");
        check(3, 7, 4, "Monday");
        check(3, 8, 4, "Tuesday");
        check(3, 9, 4, "Wednesday");
        check(3, MAX_DAY_OF_MONTH_30 - 1, 4, "Tuesday");
        check(3, MAX_DAY_OF_MONTH_30, 4, "Wednesday");
        //month is 5
        check(3, 1, 5, "Thursday");
        check(3, 2, 5, "Friday");
        check(3, 7, 5, "Wednesday");
        check(3, 8, 5, "Thursday");
        check(3, 9, 5, "Friday");
        check(3, MAX_DAY_OF_MONTH_31 - 1, 5, "Friday");
        check(3, MAX_DAY_OF_MONTH_31, 5, "Saturday");
        //month is 6
        check(3, 1, 6, "Sunday");
        check(3, 2, 6, "Monday");
        check(3, 7, 6, "Saturday");
        check(3, 8, 6, "Sunday");
        check(3, 9, 6, "Monday");
        check(3, MAX_DAY_OF_MONTH_30 - 1, 6, "Sunday");
        check(3, MAX_DAY_OF_MONTH_30, 6, "Monday");
        //month is 7
        check(3, 1, 7, "Tuesday");
        check(3, 2, 7, "Wednesday");
        check(3, 7, 7, "Monday");
        check(3, 8, 7, "Tuesday");
        check(3, 9, 7, "Wednesday");
        check(3, MAX_DAY_OF_MONTH_31 - 1, 7, "Wednesday");
        check(3, MAX_DAY_OF_MONTH_31, 7, "Thursday");
        //month is 8
        check(3, 1, 8, "Friday");
        check(3, 2, 8, "Saturday");
        check(3, 7, 8, "Thursday");
        check(3, 8, 8, "Friday");
        check(3, 9, 8, "Saturday");
        check(3, MAX_DAY_OF_MONTH_31 - 1, 8, "Saturday");
        check(3, MAX_DAY_OF_MONTH_31, 8, "Sunday");
        //month is 9
        check(3, 1, 9, "Monday");
        check(3, 2, 9, "Tuesday");
        check(3, 7, 9, "Sunday");
        check(3, 8, 9, "Monday");
        check(3, 9, 9, "Tuesday");
        check(3, MAX_DAY_OF_MONTH_30 - 1, 9, "Monday");
        check(3, MAX_DAY_OF_MONTH_30, 9, "Tuesday");
        //month is 10
        check(3, 1, 10, "Wednesday");
        check(3, 2, 10, "Thursday");
        check(3, 7, 10, "Tuesday");
        check(3, 8, 10, "Wednesday");
        check(3, 9, 10, "Thursday");
        check(3, MAX_DAY_OF_MONTH_31 - 1, 10, "Thursday");
        check(3, MAX_DAY_OF_MONTH_31, 10, "Friday");
        //month is 11
        check(3, 1, 11, "Saturday");
        check(3, 2, 11, "Sunday");
        check(3, 7, 11, "Friday");
        check(3, 8, 11, "Saturday");
        check(3, 9, 11, "Sunday");
        check(3, MAX_DAY_OF_MONTH_30 - 1, 11, "Saturday");
        check(3, MAX_DAY_OF_MONTH_30, 11, "Sunday");
        //month is 12
        check(3, 1, 12, "Monday");
        check(3, 2, 12, "Tuesday");
        check(3, 7, 12, "Sunday");
        check(3, 8, 12, "Monday");
        check(3, 9, 12, "Tuesday");
        check(3, MAX_DAY_OF_MONTH_31 - 1, 12, "Tuesday");
        check(3, MAX_DAY_OF_MONTH_31, 12, "Wednesday");

        //day of New Year is Thursday
        //month is 1
        check(4, 1, 1, "Thursday");
        check(4, 2, 1, "Friday");
        check(4, 7, 1, "Wednesday");
        check(4, 8, 1, "Thursday");
        check(4, 9, 1, "Friday");
        check(4, MAX_DAY_OF_MONTH_31 - 1, 1, "Friday");
        check(4, MAX_DAY_OF_MONTH_31, 1, "Saturday");
        //month is 2
        check(4, 1, 2, "Sunday");
        check(4, 2, 2, "Monday");
        check(4, 7, 2, "Saturday");
        check(4, 8, 2, "Sunday");
        check(4, 9, 2, "Monday");
        check(4, MAX_DAY_OF_MONTH_28 - 1, 2, "Friday");
        check(4, MAX_DAY_OF_MONTH_28, 2, "Saturday");
        //month is 3
        check(4, 1, 3, "Sunday");
        check(4, 2, 3, "Monday");
        check(4, 7, 3, "Saturday");
        check(4, 8, 3, "Sunday");
        check(4, 9, 3, "Monday");
        check(4, MAX_DAY_OF_MONTH_31 - 1, 3, "Monday");
        check(4, MAX_DAY_OF_MONTH_31, 3, "Tuesday");
        //month is 4
        check(4, 1, 4, "Wednesday");
        check(4, 2, 4, "Thursday");
        check(4, 7, 4, "Tuesday");
        check(4, 8, 4, "Wednesday");
        check(4, 9, 4, "Thursday");
        check(4, MAX_DAY_OF_MONTH_30 - 1, 4, "Wednesday");
        check(4, MAX_DAY_OF_MONTH_30, 4, "Thursday");
        //month is 5
        check(4, 1, 5, "Friday");
        check(4, 2, 5, "Saturday");
        check(4, 7, 5, "Thursday");
        check(4, 8, 5, "Friday");
        check(4, 9, 5, "Saturday");
        check(4, MAX_DAY_OF_MONTH_31 - 1, 5, "Saturday");
        check(4, MAX_DAY_OF_MONTH_31, 5, "Sunday");
        //month is 6
        check(4, 1, 6, "Monday");
        check(4, 2, 6, "Tuesday");
        check(4, 7, 6, "Sunday");
        check(4, 8, 6, "Monday");
        check(4, 9, 6, "Tuesday");
        check(4, MAX_DAY_OF_MONTH_30 - 1, 6, "Monday");
        check(4, MAX_DAY_OF_MONTH_30, 6, "Tuesday");
        //month is 7
        check(4, 1, 7, "Wednesday");
        check(4, 2, 7, "Thursday");
        check(4, 7, 7, "Tuesday");
        check(4, 8, 7, "Wednesday");
        check(4, 9, 7, "Thursday");
        check(4, MAX_DAY_OF_MONTH_31 - 1, 7, "Thursday");
        check(4, MAX_DAY_OF_MONTH_31, 7, "Friday");
        //month is 8
        check(4, 1, 8, "Saturday");
        check(4, 2, 8, "Sunday");
        check(4, 7, 8, "Friday");
        check(4, 8, 8, "Saturday");
        check(4, 9, 8, "Sunday");
        check(4, MAX_DAY_OF_MONTH_31 - 1, 8, "Sunday");
        check(4, MAX_DAY_OF_MONTH_31, 8, "Monday");
        //month is 9
        check(4, 1, 9, "Tuesday");
        check(4, 2, 9, "Wednesday");
        check(4, 7, 9, "Monday");
        check(4, 8, 9, "Tuesday");
        check(4, 9, 9, "Wednesday");
        check(4, MAX_DAY_OF_MONTH_30 - 1, 9, "Tuesday");
        check(4, MAX_DAY_OF_MONTH_30, 9, "Wednesday");
        //month is 10
        check(4, 1, 10, "Thursday");
        check(4, 2, 10, "Friday");
        check(4, 7, 10, "Wednesday");
        check(4, 8, 10, "Thursday");
        check(4, 9, 10, "Friday");
        check(4, MAX_DAY_OF_MONTH_31 - 1, 10, "Friday");
        check(4, MAX_DAY_OF_MONTH_31, 10, "Saturday");
        //month is 11
        check(4, 1, 11, "Sunday");
        check(4, 2, 11, "Monday");
        check(4, 7, 11, "Saturday");
        check(4, 8, 11, "Sunday");
        check(4, 9, 11, "Monday");
        check(4, MAX_DAY_OF_MONTH_30 - 1, 11, "Sunday");
        check(4, MAX_DAY_OF_MONTH_30, 11, "Monday");
        //month is 12
        check(4, 1, 12, "Tuesday");
        check(4, 2, 12, "Wednesday");
        check(4, 7, 12, "Monday");
        check(4, 8, 12, "Tuesday");
        check(4, 9, 12, "Wednesday");
        check(4, MAX_DAY_OF_MONTH_31 - 1, 12, "Wednesday");
        check(4, MAX_DAY_OF_MONTH_31, 12, "Thursday");

        //day of New Year is Friday
        //month is 1
        check(5, 1, 1, "Friday");
        check(5, 2, 1, "Saturday");
        check(5, 7, 1, "Thursday");
        check(5, 8, 1, "Friday");
        check(5, 9, 1, "Saturday");
        check(5, MAX_DAY_OF_MONTH_31 - 1, 1, "Saturday");
        check(5, MAX_DAY_OF_MONTH_31, 1, "Sunday");
        //month is 2
        check(5, 1, 2, "Monday");
        check(5, 2, 2, "Tuesday");
        check(5, 7, 2, "Sunday");
        check(5, 8, 2, "Monday");
        check(5, 9, 2, "Tuesday");
        check(5, MAX_DAY_OF_MONTH_28 - 1, 2, "Saturday");
        check(5, MAX_DAY_OF_MONTH_28, 2, "Sunday");
        //month is 3
        check(5, 1, 3, "Monday");
        check(5, 2, 3, "Tuesday");
        check(5, 7, 3, "Sunday");
        check(5, 8, 3, "Monday");
        check(5, 9, 3, "Tuesday");
        check(5, MAX_DAY_OF_MONTH_31 - 1, 3, "Tuesday");
        check(5, MAX_DAY_OF_MONTH_31, 3, "Wednesday");
        //month is 4
        check(5, 1, 4, "Thursday");
        check(5, 2, 4, "Friday");
        check(5, 7, 4, "Wednesday");
        check(5, 8, 4, "Thursday");
        check(5, 9, 4, "Friday");
        check(5, MAX_DAY_OF_MONTH_30 - 1, 4, "Thursday");
        check(5, MAX_DAY_OF_MONTH_30, 4, "Friday");
        //month is 5
        check(5, 1, 5, "Saturday");
        check(5, 2, 5, "Sunday");
        check(5, 7, 5, "Friday");
        check(5, 8, 5, "Saturday");
        check(5, 9, 5, "Sunday");
        check(5, MAX_DAY_OF_MONTH_31 - 1, 5, "Sunday");
        check(5, MAX_DAY_OF_MONTH_31, 5, "Monday");
        //month is 6
        check(5, 1, 6, "Tuesday");
        check(5, 2, 6, "Wednesday");
        check(5, 7, 6, "Monday");
        check(5, 8, 6, "Tuesday");
        check(5, 9, 6, "Wednesday");
        check(5, MAX_DAY_OF_MONTH_30 - 1, 6, "Tuesday");
        check(5, MAX_DAY_OF_MONTH_30, 6, "Wednesday");
        //month is 7
        check(5, 1, 7, "Thursday");
        check(5, 2, 7, "Friday");
        check(5, 7, 7, "Wednesday");
        check(5, 8, 7, "Thursday");
        check(5, 9, 7, "Friday");
        check(5, MAX_DAY_OF_MONTH_31 - 1, 7, "Friday");
        check(5, MAX_DAY_OF_MONTH_31, 7, "Saturday");
        //month is 8
        check(5, 1, 8, "Sunday");
        check(5, 2, 8, "Monday");
        check(5, 7, 8, "Saturday");
        check(5, 8, 8, "Sunday");
        check(5, 9, 8, "Monday");
        check(5, MAX_DAY_OF_MONTH_31 - 1, 8, "Monday");
        check(5, MAX_DAY_OF_MONTH_31, 8, "Tuesday");
        //month is 9
        check(5, 1, 9, "Wednesday");
        check(5, 2, 9, "Thursday");
        check(5, 7, 9, "Tuesday");
        check(5, 8, 9, "Wednesday");
        check(5, 9, 9, "Thursday");
        check(5, MAX_DAY_OF_MONTH_30 - 1, 9, "Wednesday");
        check(5, MAX_DAY_OF_MONTH_30, 9, "Thursday");
        //month is 10
        check(5, 1, 10, "Friday");
        check(5, 2, 10, "Saturday");
        check(5, 7, 10, "Thursday");
        check(5, 8, 10, "Friday");
        check(5, 9, 10, "Saturday");
        check(5, MAX_DAY_OF_MONTH_31 - 1, 10, "Saturday");
        check(5, MAX_DAY_OF_MONTH_31, 10, "Sunday");
        //month is 11
        check(5, 1, 11, "Monday");
        check(5, 2, 11, "Tuesday");
        check(5, 7, 11, "Sunday");
        check(5, 8, 11, "Monday");
        check(5, 9, 11, "Tuesday");
        check(5, MAX_DAY_OF_MONTH_30 - 1, 11, "Monday");
        check(5, MAX_DAY_OF_MONTH_30, 11, "Tuesday");
        //month is 12
        check(5, 1, 12, "Wednesday");
        check(5, 2, 12, "Thursday");
        check(5, 7, 12, "Tuesday");
        check(5, 8, 12, "Wednesday");
        check(5, 9, 12, "Thursday");
        check(5, MAX_DAY_OF_MONTH_31 - 1, 12, "Thursday");
        check(5, MAX_DAY_OF_MONTH_31, 12, "Friday");

        //day of New Year is Saturday
        //month is 1
        check(6, 1, 1, "Saturday");
        check(6, 2, 1, "Sunday");
        check(6, 7, 1, "Friday");
        check(6, 8, 1, "Saturday");
        check(6, 9, 1, "Sunday");
        check(6, MAX_DAY_OF_MONTH_31 - 1, 1, "Sunday");
        check(6, MAX_DAY_OF_MONTH_31, 1, "Monday");
        //month is 2
        check(6, 1, 2, "Tuesday");
        check(6, 2, 2, "Wednesday");
        check(6, 7, 2, "Monday");
        check(6, 8, 2, "Tuesday");
        check(6, 9, 2, "Wednesday");
        check(6, MAX_DAY_OF_MONTH_28 - 1, 2, "Sunday");
        check(6, MAX_DAY_OF_MONTH_28, 2, "Monday");
        //month is 3
        check(6, 1, 3, "Tuesday");
        check(6, 2, 3, "Wednesday");
        check(6, 7, 3, "Monday");
        check(6, 8, 3, "Tuesday");
        check(6, 9, 3, "Wednesday");
        check(6, MAX_DAY_OF_MONTH_31 - 1, 3, "Wednesday");
        check(6, MAX_DAY_OF_MONTH_31, 3, "Thursday");
        //month is 4
        check(6, 1, 4, "Friday");
        check(6, 2, 4, "Saturday");
        check(6, 7, 4, "Thursday");
        check(6, 8, 4, "Friday");
        check(6, 9, 4, "Saturday");
        check(6, MAX_DAY_OF_MONTH_30 - 1, 4, "Friday");
        check(6, MAX_DAY_OF_MONTH_30, 4, "Saturday");
        //month is 5
        check(6, 1, 5, "Sunday");
        check(6, 2, 5, "Monday");
        check(6, 7, 5, "Saturday");
        check(6, 8, 5, "Sunday");
        check(6, 9, 5, "Monday");
        check(6, MAX_DAY_OF_MONTH_31 - 1, 5, "Monday");
        check(6, MAX_DAY_OF_MONTH_31, 5, "Tuesday");
        //month is 6
        check(6, 1, 6, "Wednesday");
        check(6, 2, 6, "Thursday");
        check(6, 7, 6, "Tuesday");
        check(6, 8, 6, "Wednesday");
        check(6, 9, 6, "Thursday");
        check(6, MAX_DAY_OF_MONTH_30 - 1, 6, "Wednesday");
        check(6, MAX_DAY_OF_MONTH_30, 6, "Thursday");
        //month is 7
        check(6, 1, 7, "Friday");
        check(6, 2, 7, "Saturday");
        check(6, 7, 7, "Thursday");
        check(6, 8, 7, "Friday");
        check(6, 9, 7, "Saturday");
        check(6, MAX_DAY_OF_MONTH_31 - 1, 7, "Saturday");
        check(6, MAX_DAY_OF_MONTH_31, 7, "Sunday");
        //month is 8
        check(6, 1, 8, "Monday");
        check(6, 2, 8, "Tuesday");
        check(6, 7, 8, "Sunday");
        check(6, 8, 8, "Monday");
        check(6, 9, 8, "Tuesday");
        check(6, MAX_DAY_OF_MONTH_31 - 1, 8, "Tuesday");
        check(6, MAX_DAY_OF_MONTH_31, 8, "Wednesday");
        //month is 9
        check(6, 1, 9, "Thursday");
        check(6, 2, 9, "Friday");
        check(6, 7, 9, "Wednesday");
        check(6, 8, 9, "Thursday");
        check(6, 9, 9, "Friday");
        check(6, MAX_DAY_OF_MONTH_30 - 1, 9, "Thursday");
        check(6, MAX_DAY_OF_MONTH_30, 9, "Friday");
        //month is 10
        check(6, 1, 10, "Saturday");
        check(6, 2, 10, "Sunday");
        check(6, 7, 10, "Friday");
        check(6, 8, 10, "Saturday");
        check(6, 9, 10, "Sunday");
        check(6, MAX_DAY_OF_MONTH_31 - 1, 10, "Sunday");
        check(6, MAX_DAY_OF_MONTH_31, 10, "Monday");
        //month is 11
        check(6, 1, 11, "Tuesday");
        check(6, 2, 11, "Wednesday");
        check(6, 7, 11, "Monday");
        check(6, 8, 11, "Tuesday");
        check(6, 9, 11, "Wednesday");
        check(6, MAX_DAY_OF_MONTH_30 - 1, 11, "Tuesday");
        check(6, MAX_DAY_OF_MONTH_30, 11, "Wednesday");
        //month is 12
        check(6, 1, 12, "Thursday");
        check(6, 2, 12, "Friday");
        check(6, 7, 12, "Wednesday");
        check(6, 8, 12, "Thursday");
        check(6, 9, 12, "Friday");
        check(6, MAX_DAY_OF_MONTH_31 - 1, 12, "Friday");
        check(6, MAX_DAY_OF_MONTH_31, 12, "Saturday");

        //day of New Year is Sunday
        //month is 1
        check(7, 1, 1, "Sunday");
        check(7, 2, 1, "Monday");
        check(7, 7, 1, "Saturday");
        check(7, 8, 1, "Sunday");
        check(7, 9, 1, "Monday");
        check(7, MAX_DAY_OF_MONTH_31 - 1, 1, "Monday");
        check(7, MAX_DAY_OF_MONTH_31, 1, "Tuesday");
        //month is 2
        check(7, 1, 2, "Wednesday");
        check(7, 2, 2, "Thursday");
        check(7, 7, 2, "Tuesday");
        check(7, 8, 2, "Wednesday");
        check(7, 9, 2, "Thursday");
        check(7, MAX_DAY_OF_MONTH_28 - 1, 2, "Monday");
        check(7, MAX_DAY_OF_MONTH_28, 2, "Tuesday");
        //month is 3
        check(7, 1, 3, "Wednesday");
        check(7, 2, 3, "Thursday");
        check(7, 7, 3, "Tuesday");
        check(7, 8, 3, "Wednesday");
        check(7, 9, 3, "Thursday");
        check(7, MAX_DAY_OF_MONTH_31 - 1, 3, "Thursday");
        check(7, MAX_DAY_OF_MONTH_31, 3, "Friday");
        //month is 4
        check(7, 1, 4, "Saturday");
        check(7, 2, 4, "Sunday");
        check(7, 7, 4, "Friday");
        check(7, 8, 4, "Saturday");
        check(7, 9, 4, "Sunday");
        check(7, MAX_DAY_OF_MONTH_30 - 1, 4, "Saturday");
        check(7, MAX_DAY_OF_MONTH_30, 4, "Sunday");
        //month is 5
        check(7, 1, 5, "Monday");
        check(7, 2, 5, "Tuesday");
        check(7, 7, 5, "Sunday");
        check(7, 8, 5, "Monday");
        check(7, 9, 5, "Tuesday");
        check(7, MAX_DAY_OF_MONTH_31 - 1, 5, "Tuesday");
        check(7, MAX_DAY_OF_MONTH_31, 5, "Wednesday");
        //month is 6
        check(7, 1, 6, "Thursday");
        check(7, 2, 6, "Friday");
        check(7, 7, 6, "Wednesday");
        check(7, 8, 6, "Thursday");
        check(7, 9, 6, "Friday");
        check(7, MAX_DAY_OF_MONTH_30 - 1, 6, "Thursday");
        check(7, MAX_DAY_OF_MONTH_30, 6, "Friday");
        //month is 7
        check(7, 1, 7, "Saturday");
        check(7, 2, 7, "Sunday");
        check(7, 7, 7, "Friday");
        check(7, 8, 7, "Saturday");
        check(7, 9, 7, "Sunday");
        check(7, MAX_DAY_OF_MONTH_31 - 1, 7, "Sunday");
        check(7, MAX_DAY_OF_MONTH_31, 7, "Monday");
        //month is 8
        check(7, 1, 8, "Tuesday");
        check(7, 2, 8, "Wednesday");
        check(7, 7, 8, "Monday");
        check(7, 8, 8, "Tuesday");
        check(7, 9, 8, "Wednesday");
        check(7, MAX_DAY_OF_MONTH_31 - 1, 8, "Wednesday");
        check(7, MAX_DAY_OF_MONTH_31, 8, "Thursday");
        //month is 9
        check(7, 1, 9, "Friday");
        check(7, 2, 9, "Saturday");
        check(7, 7, 9, "Thursday");
        check(7, 8, 9, "Friday");
        check(7, 9, 9, "Saturday");
        check(7, MAX_DAY_OF_MONTH_30 - 1, 9, "Friday");
        check(7, MAX_DAY_OF_MONTH_30, 9, "Saturday");
        //month is 10
        check(7, 1, 10, "Sunday");
        check(7, 2, 10, "Monday");
        check(7, 7, 10, "Saturday");
        check(7, 8, 10, "Sunday");
        check(7, 9, 10, "Monday");
        check(7, MAX_DAY_OF_MONTH_31 - 1, 10, "Monday");
        check(7, MAX_DAY_OF_MONTH_31, 10, "Tuesday");
        //month is 11
        check(7, 1, 11, "Wednesday");
        check(7, 2, 11, "Thursday");
        check(7, 7, 11, "Tuesday");
        check(7, 8, 11, "Wednesday");
        check(7, 9, 11, "Thursday");
        check(7, MAX_DAY_OF_MONTH_30 - 1, 11, "Wednesday");
        check(7, MAX_DAY_OF_MONTH_30, 11, "Thursday");
        //month is 12
        check(7, 1, 12, "Friday");
        check(7, 2, 12, "Saturday");
        check(7, 7, 12, "Thursday");
        check(7, 8, 12, "Friday");
        check(7, 9, 12, "Saturday");
        check(7, MAX_DAY_OF_MONTH_31 - 1, 12, "Saturday");
        check(7, MAX_DAY_OF_MONTH_31, 12, "Sunday");
    }

    /**
     * Tests with non-valid args for task5 (day of week).
     * 9 tests for non-valid day of month for each month for each day of week of New Year;
     * 9 * 12 * 7 = 756 tests at all.
     */
    @Test
    void nonValidArgsTests() {
        //non valid day of month (for February)
        //day of week is 1
        checkException(1, Integer.MIN_VALUE, 2);
        checkException(1, Integer.MIN_VALUE + 1, 2);
        checkException(1, Integer.MIN_VALUE / 2, 2);
        checkException(1, -1, 2);
        checkException(1, 0, 2);
        checkException(1, MAX_DAY_OF_MONTH_28 + 1, 2);
        checkException(1, Integer.MAX_VALUE / 2, 2);
        checkException(1, Integer.MAX_VALUE - 1, 2);
        checkException(1, Integer.MAX_VALUE, 2);

        //day of week is 2
        checkException(2, Integer.MIN_VALUE, 2);
        checkException(2, Integer.MIN_VALUE + 1, 2);
        checkException(2, Integer.MIN_VALUE / 2, 2);
        checkException(2, -1, 2);
        checkException(2, 0, 2);
        checkException(2, MAX_DAY_OF_MONTH_28 + 1, 2);
        checkException(2, Integer.MAX_VALUE / 2, 2);
        checkException(2, Integer.MAX_VALUE - 1, 2);
        checkException(2, Integer.MAX_VALUE, 2);

        //day of week is 3
        checkException(3, Integer.MIN_VALUE, 2);
        checkException(3, Integer.MIN_VALUE + 1, 2);
        checkException(3, Integer.MIN_VALUE / 2, 2);
        checkException(3, -1, 2);
        checkException(3, 0, 2);
        checkException(3, MAX_DAY_OF_MONTH_28 + 1, 2);
        checkException(3, Integer.MAX_VALUE / 2, 2);
        checkException(3, Integer.MAX_VALUE - 1, 2);
        checkException(3, Integer.MAX_VALUE, 2);

        //day of week is 4
        checkException(4, Integer.MIN_VALUE, 2);
        checkException(4, Integer.MIN_VALUE + 1, 2);
        checkException(4, Integer.MIN_VALUE / 2, 2);
        checkException(4, -1, 2);
        checkException(4, 0, 2);
        checkException(4, MAX_DAY_OF_MONTH_28 + 1, 2);
        checkException(4, Integer.MAX_VALUE / 2, 2);
        checkException(4, Integer.MAX_VALUE - 1, 2);
        checkException(4, Integer.MAX_VALUE, 2);

        //day of week is 5
        checkException(5, Integer.MIN_VALUE, 2);
        checkException(5, Integer.MIN_VALUE + 1, 2);
        checkException(5, Integer.MIN_VALUE / 2, 2);
        checkException(5, -1, 2);
        checkException(5, 0, 2);
        checkException(5, MAX_DAY_OF_MONTH_28 + 1, 2);
        checkException(5, Integer.MAX_VALUE / 2, 2);
        checkException(5, Integer.MAX_VALUE - 1, 2);
        checkException(5, Integer.MAX_VALUE, 2);

        //day of week is 6
        checkException(6, Integer.MIN_VALUE, 2);
        checkException(6, Integer.MIN_VALUE + 1, 2);
        checkException(6, Integer.MIN_VALUE / 2, 2);
        checkException(6, -1, 2);
        checkException(6, 0, 2);
        checkException(6, MAX_DAY_OF_MONTH_28 + 1, 2);
        checkException(6, Integer.MAX_VALUE / 2, 2);
        checkException(6, Integer.MAX_VALUE - 1, 2);
        checkException(6, Integer.MAX_VALUE, 2);

        //day of week is 7
        checkException(7, Integer.MIN_VALUE, 2);
        checkException(7, Integer.MIN_VALUE + 1, 2);
        checkException(7, Integer.MIN_VALUE / 2, 2);
        checkException(7, -1, 2);
        checkException(7, 0, 2);
        checkException(7, MAX_DAY_OF_MONTH_28 + 1, 2);
        checkException(7, Integer.MAX_VALUE / 2, 2);
        checkException(7, Integer.MAX_VALUE - 1, 2);
        checkException(7, Integer.MAX_VALUE, 2);

        //non valid day of month (for 30-days months)
        //month is 4
        //day of week is 1
        checkException(1, Integer.MIN_VALUE, 4);
        checkException(1, Integer.MIN_VALUE + 1, 4);
        checkException(1, Integer.MIN_VALUE / 2, 4);
        checkException(1, -1, 4);
        checkException(1, 0, 4);
        checkException(1, MAX_DAY_OF_MONTH_30 + 1, 4);
        checkException(1, Integer.MAX_VALUE / 2, 4);
        checkException(1, Integer.MAX_VALUE - 1, 4);
        checkException(1, Integer.MAX_VALUE, 4);

        //day of week is 2
        checkException(2, Integer.MIN_VALUE, 4);
        checkException(2, Integer.MIN_VALUE + 1, 4);
        checkException(2, Integer.MIN_VALUE / 2, 4);
        checkException(2, -1, 4);
        checkException(2, 0, 4);
        checkException(2, MAX_DAY_OF_MONTH_30 + 1, 4);
        checkException(2, Integer.MAX_VALUE / 2, 4);
        checkException(2, Integer.MAX_VALUE - 1, 4);
        checkException(2, Integer.MAX_VALUE, 4);

        //day of week is 3
        checkException(3, Integer.MIN_VALUE, 4);
        checkException(3, Integer.MIN_VALUE + 1, 4);
        checkException(3, Integer.MIN_VALUE / 2, 4);
        checkException(3, -1, 4);
        checkException(3, 0, 4);
        checkException(3, MAX_DAY_OF_MONTH_30 + 1, 4);
        checkException(3, Integer.MAX_VALUE / 2, 4);
        checkException(3, Integer.MAX_VALUE - 1, 4);
        checkException(3, Integer.MAX_VALUE, 4);

        //day of week is 4
        checkException(4, Integer.MIN_VALUE, 4);
        checkException(4, Integer.MIN_VALUE + 1, 4);
        checkException(4, Integer.MIN_VALUE / 2, 4);
        checkException(4, -1, 4);
        checkException(4, 0, 4);
        checkException(4, MAX_DAY_OF_MONTH_30 + 1, 4);
        checkException(4, Integer.MAX_VALUE / 2, 4);
        checkException(4, Integer.MAX_VALUE - 1, 4);
        checkException(4, Integer.MAX_VALUE, 4);

        //day of week is 5
        checkException(5, Integer.MIN_VALUE, 4);
        checkException(5, Integer.MIN_VALUE + 1, 4);
        checkException(5, Integer.MIN_VALUE / 2, 4);
        checkException(5, -1, 4);
        checkException(5, 0, 4);
        checkException(5, MAX_DAY_OF_MONTH_30 + 1, 4);
        checkException(5, Integer.MAX_VALUE / 2, 4);
        checkException(5, Integer.MAX_VALUE - 1, 4);
        checkException(5, Integer.MAX_VALUE, 4);

        //day of week is 6
        checkException(6, Integer.MIN_VALUE, 4);
        checkException(6, Integer.MIN_VALUE + 1, 4);
        checkException(6, Integer.MIN_VALUE / 2, 4);
        checkException(6, -1, 4);
        checkException(6, 0, 4);
        checkException(6, MAX_DAY_OF_MONTH_30 + 1, 4);
        checkException(6, Integer.MAX_VALUE / 2, 4);
        checkException(6, Integer.MAX_VALUE - 1, 4);
        checkException(6, Integer.MAX_VALUE, 4);

        //day of week is 7
        checkException(7, Integer.MIN_VALUE, 4);
        checkException(7, Integer.MIN_VALUE + 1, 4);
        checkException(7, Integer.MIN_VALUE / 2, 4);
        checkException(7, -1, 4);
        checkException(7, 0, 4);
        checkException(7, MAX_DAY_OF_MONTH_30 + 1, 4);
        checkException(7, Integer.MAX_VALUE / 2, 4);
        checkException(7, Integer.MAX_VALUE - 1, 4);
        checkException(7, Integer.MAX_VALUE, 4);

        //month is 6
        //day of week is 1
        checkException(1, Integer.MIN_VALUE, 6);
        checkException(1, Integer.MIN_VALUE + 1, 6);
        checkException(1, Integer.MIN_VALUE / 2, 6);
        checkException(1, -1, 6);
        checkException(1, 0, 6);
        checkException(1, MAX_DAY_OF_MONTH_30 + 1, 6);
        checkException(1, Integer.MAX_VALUE / 2, 6);
        checkException(1, Integer.MAX_VALUE - 1, 6);
        checkException(1, Integer.MAX_VALUE, 6);

        //day of week is 2
        checkException(2, Integer.MIN_VALUE, 6);
        checkException(2, Integer.MIN_VALUE + 1, 6);
        checkException(2, Integer.MIN_VALUE / 2, 6);
        checkException(2, -1, 6);
        checkException(2, 0, 6);
        checkException(2, MAX_DAY_OF_MONTH_30 + 1, 6);
        checkException(2, Integer.MAX_VALUE / 2, 6);
        checkException(2, Integer.MAX_VALUE - 1, 6);
        checkException(2, Integer.MAX_VALUE, 6);

        //day of week is 3
        checkException(3, Integer.MIN_VALUE, 6);
        checkException(3, Integer.MIN_VALUE + 1, 6);
        checkException(3, Integer.MIN_VALUE / 2, 6);
        checkException(3, -1, 6);
        checkException(3, 0, 6);
        checkException(3, MAX_DAY_OF_MONTH_30 + 1, 6);
        checkException(3, Integer.MAX_VALUE / 2, 6);
        checkException(3, Integer.MAX_VALUE - 1, 6);
        checkException(3, Integer.MAX_VALUE, 6);

        //day of week is 4
        checkException(4, Integer.MIN_VALUE, 6);
        checkException(4, Integer.MIN_VALUE + 1, 6);
        checkException(4, Integer.MIN_VALUE / 2, 6);
        checkException(4, -1, 6);
        checkException(4, 0, 6);
        checkException(4, MAX_DAY_OF_MONTH_30 + 1, 6);
        checkException(4, Integer.MAX_VALUE / 2, 6);
        checkException(4, Integer.MAX_VALUE - 1, 6);
        checkException(4, Integer.MAX_VALUE, 6);

        //day of week is 5
        checkException(5, Integer.MIN_VALUE, 6);
        checkException(5, Integer.MIN_VALUE + 1, 6);
        checkException(5, Integer.MIN_VALUE / 2, 6);
        checkException(5, -1, 6);
        checkException(5, 0, 6);
        checkException(5, MAX_DAY_OF_MONTH_30 + 1, 6);
        checkException(5, Integer.MAX_VALUE / 2, 6);
        checkException(5, Integer.MAX_VALUE - 1, 6);
        checkException(5, Integer.MAX_VALUE, 6);

        //day of week is 6
        checkException(6, Integer.MIN_VALUE, 6);
        checkException(6, Integer.MIN_VALUE + 1, 6);
        checkException(6, Integer.MIN_VALUE / 2, 6);
        checkException(6, -1, 6);
        checkException(6, 0, 6);
        checkException(6, MAX_DAY_OF_MONTH_30 + 1, 6);
        checkException(6, Integer.MAX_VALUE / 2, 6);
        checkException(6, Integer.MAX_VALUE - 1, 6);
        checkException(6, Integer.MAX_VALUE, 6);

        //day of week is 7
        checkException(7, Integer.MIN_VALUE, 6);
        checkException(7, Integer.MIN_VALUE + 1, 6);
        checkException(7, Integer.MIN_VALUE / 2, 6);
        checkException(7, -1, 6);
        checkException(7, 0, 6);
        checkException(7, MAX_DAY_OF_MONTH_30 + 1, 6);
        checkException(7, Integer.MAX_VALUE / 2, 6);
        checkException(7, Integer.MAX_VALUE - 1, 6);
        checkException(7, Integer.MAX_VALUE, 6);

        //month is 9
        //day of week is 1
        checkException(1, Integer.MIN_VALUE, 9);
        checkException(1, Integer.MIN_VALUE + 1, 9);
        checkException(1, Integer.MIN_VALUE / 2, 9);
        checkException(1, -1, 9);
        checkException(1, 0, 9);
        checkException(1, MAX_DAY_OF_MONTH_30 + 1, 9);
        checkException(1, Integer.MAX_VALUE / 2, 9);
        checkException(1, Integer.MAX_VALUE - 1, 9);
        checkException(1, Integer.MAX_VALUE, 9);

        //day of week is 2
        checkException(2, Integer.MIN_VALUE, 9);
        checkException(2, Integer.MIN_VALUE + 1, 9);
        checkException(2, Integer.MIN_VALUE / 2, 9);
        checkException(2, -1, 9);
        checkException(2, 0, 9);
        checkException(2, MAX_DAY_OF_MONTH_30 + 1, 9);
        checkException(2, Integer.MAX_VALUE / 2, 9);
        checkException(2, Integer.MAX_VALUE - 1, 9);
        checkException(2, Integer.MAX_VALUE, 9);

        //day of week is 3
        checkException(3, Integer.MIN_VALUE, 9);
        checkException(3, Integer.MIN_VALUE + 1, 9);
        checkException(3, Integer.MIN_VALUE / 2, 9);
        checkException(3, -1, 9);
        checkException(3, 0, 9);
        checkException(3, MAX_DAY_OF_MONTH_30 + 1, 9);
        checkException(3, Integer.MAX_VALUE / 2, 9);
        checkException(3, Integer.MAX_VALUE - 1, 9);
        checkException(3, Integer.MAX_VALUE, 9);

        //day of week is 4
        checkException(4, Integer.MIN_VALUE, 9);
        checkException(4, Integer.MIN_VALUE + 1, 9);
        checkException(4, Integer.MIN_VALUE / 2, 9);
        checkException(4, -1, 9);
        checkException(4, 0, 9);
        checkException(4, MAX_DAY_OF_MONTH_30 + 1, 9);
        checkException(4, Integer.MAX_VALUE / 2, 9);
        checkException(4, Integer.MAX_VALUE - 1, 9);
        checkException(4, Integer.MAX_VALUE, 9);

        //day of week is 5
        checkException(5, Integer.MIN_VALUE, 9);
        checkException(5, Integer.MIN_VALUE + 1, 9);
        checkException(5, Integer.MIN_VALUE / 2, 9);
        checkException(5, -1, 9);
        checkException(5, 0, 9);
        checkException(5, MAX_DAY_OF_MONTH_30 + 1, 9);
        checkException(5, Integer.MAX_VALUE / 2, 9);
        checkException(5, Integer.MAX_VALUE - 1, 9);
        checkException(5, Integer.MAX_VALUE, 9);

        //day of week is 6
        checkException(6, Integer.MIN_VALUE, 9);
        checkException(6, Integer.MIN_VALUE + 1, 9);
        checkException(6, Integer.MIN_VALUE / 2, 9);
        checkException(6, -1, 9);
        checkException(6, 0, 9);
        checkException(6, MAX_DAY_OF_MONTH_30 + 1, 9);
        checkException(6, Integer.MAX_VALUE / 2, 9);
        checkException(6, Integer.MAX_VALUE - 1, 9);
        checkException(6, Integer.MAX_VALUE, 9);

        //day of week is 7
        checkException(7, Integer.MIN_VALUE, 9);
        checkException(7, Integer.MIN_VALUE + 1, 9);
        checkException(7, Integer.MIN_VALUE / 2, 9);
        checkException(7, -1, 9);
        checkException(7, 0, 9);
        checkException(7, MAX_DAY_OF_MONTH_30 + 1, 9);
        checkException(7, Integer.MAX_VALUE / 2, 9);
        checkException(7, Integer.MAX_VALUE - 1, 9);
        checkException(7, Integer.MAX_VALUE, 9);

        //month is 11
        //day of week is 1
        checkException(1, Integer.MIN_VALUE, 11);
        checkException(1, Integer.MIN_VALUE + 1, 11);
        checkException(1, Integer.MIN_VALUE / 2, 11);
        checkException(1, -1, 11);
        checkException(1, 0, 11);
        checkException(1, MAX_DAY_OF_MONTH_30 + 1, 11);
        checkException(1, Integer.MAX_VALUE / 2, 11);
        checkException(1, Integer.MAX_VALUE - 1, 11);
        checkException(1, Integer.MAX_VALUE, 11);

        //day of week is 2
        checkException(2, Integer.MIN_VALUE, 11);
        checkException(2, Integer.MIN_VALUE + 1, 11);
        checkException(2, Integer.MIN_VALUE / 2, 11);
        checkException(2, -1, 11);
        checkException(2, 0, 11);
        checkException(2, MAX_DAY_OF_MONTH_30 + 1, 11);
        checkException(2, Integer.MAX_VALUE / 2, 11);
        checkException(2, Integer.MAX_VALUE - 1, 11);
        checkException(2, Integer.MAX_VALUE, 11);

        //day of week is 3
        checkException(3, Integer.MIN_VALUE, 11);
        checkException(3, Integer.MIN_VALUE + 1, 11);
        checkException(3, Integer.MIN_VALUE / 2, 11);
        checkException(3, -1, 11);
        checkException(3, 0, 11);
        checkException(3, MAX_DAY_OF_MONTH_30 + 1, 11);
        checkException(3, Integer.MAX_VALUE / 2, 11);
        checkException(3, Integer.MAX_VALUE - 1, 11);
        checkException(3, Integer.MAX_VALUE, 11);

        //day of week is 4
        checkException(4, Integer.MIN_VALUE, 11);
        checkException(4, Integer.MIN_VALUE + 1, 11);
        checkException(4, Integer.MIN_VALUE / 2, 11);
        checkException(4, -1, 11);
        checkException(4, 0, 11);
        checkException(4, MAX_DAY_OF_MONTH_30 + 1, 11);
        checkException(4, Integer.MAX_VALUE / 2, 11);
        checkException(4, Integer.MAX_VALUE - 1, 11);
        checkException(4, Integer.MAX_VALUE, 11);

        //day of week is 5
        checkException(5, Integer.MIN_VALUE, 11);
        checkException(5, Integer.MIN_VALUE + 1, 11);
        checkException(5, Integer.MIN_VALUE / 2, 11);
        checkException(5, -1, 11);
        checkException(5, 0, 11);
        checkException(5, MAX_DAY_OF_MONTH_30 + 1, 11);
        checkException(5, Integer.MAX_VALUE / 2, 11);
        checkException(5, Integer.MAX_VALUE - 1, 11);
        checkException(5, Integer.MAX_VALUE, 11);

        //day of week is 6
        checkException(6, Integer.MIN_VALUE, 11);
        checkException(6, Integer.MIN_VALUE + 1, 11);
        checkException(6, Integer.MIN_VALUE / 2, 11);
        checkException(6, -1, 11);
        checkException(6, 0, 11);
        checkException(6, MAX_DAY_OF_MONTH_30 + 1, 11);
        checkException(6, Integer.MAX_VALUE / 2, 11);
        checkException(6, Integer.MAX_VALUE - 1, 11);
        checkException(6, Integer.MAX_VALUE, 11);

        //day of week is 7
        checkException(7, Integer.MIN_VALUE, 11);
        checkException(7, Integer.MIN_VALUE + 1, 11);
        checkException(7, Integer.MIN_VALUE / 2, 11);
        checkException(7, -1, 11);
        checkException(7, 0, 11);
        checkException(7, MAX_DAY_OF_MONTH_30 + 1, 11);
        checkException(7, Integer.MAX_VALUE / 2, 11);
        checkException(7, Integer.MAX_VALUE - 1, 11);
        checkException(7, Integer.MAX_VALUE, 11);

        //non valid day of month (for 31-days months)
        //month is 1
        //day of week is 1
        checkException(1, Integer.MIN_VALUE, 1);
        checkException(1, Integer.MIN_VALUE + 1, 1);
        checkException(1, Integer.MIN_VALUE / 2, 1);
        checkException(1, -1, 1);
        checkException(1, 0, 1);
        checkException(1, MAX_DAY_OF_MONTH_31 + 1, 1);
        checkException(1, Integer.MAX_VALUE / 2, 1);
        checkException(1, Integer.MAX_VALUE - 1, 1);
        checkException(1, Integer.MAX_VALUE, 1);

        //day of week is 2
        checkException(2, Integer.MIN_VALUE, 1);
        checkException(2, Integer.MIN_VALUE + 1, 1);
        checkException(2, Integer.MIN_VALUE / 2, 1);
        checkException(2, -1, 1);
        checkException(2, 0, 1);
        checkException(2, MAX_DAY_OF_MONTH_31 + 1, 1);
        checkException(2, Integer.MAX_VALUE / 2, 1);
        checkException(2, Integer.MAX_VALUE - 1, 1);
        checkException(2, Integer.MAX_VALUE, 1);

        //day of week is 3
        checkException(3, Integer.MIN_VALUE, 1);
        checkException(3, Integer.MIN_VALUE + 1, 1);
        checkException(3, Integer.MIN_VALUE / 2, 1);
        checkException(3, -1, 1);
        checkException(3, 0, 1);
        checkException(3, MAX_DAY_OF_MONTH_31 + 1, 1);
        checkException(3, Integer.MAX_VALUE / 2, 1);
        checkException(3, Integer.MAX_VALUE - 1, 1);
        checkException(3, Integer.MAX_VALUE, 1);

        //day of week is 4
        checkException(4, Integer.MIN_VALUE, 1);
        checkException(4, Integer.MIN_VALUE + 1, 1);
        checkException(4, Integer.MIN_VALUE / 2, 1);
        checkException(4, -1, 1);
        checkException(4, 0, 1);
        checkException(4, MAX_DAY_OF_MONTH_31 + 1, 1);
        checkException(4, Integer.MAX_VALUE / 2, 1);
        checkException(4, Integer.MAX_VALUE - 1, 1);
        checkException(4, Integer.MAX_VALUE, 1);

        //day of week is 5
        checkException(5, Integer.MIN_VALUE, 1);
        checkException(5, Integer.MIN_VALUE + 1, 1);
        checkException(5, Integer.MIN_VALUE / 2, 1);
        checkException(5, -1, 1);
        checkException(5, 0, 1);
        checkException(5, MAX_DAY_OF_MONTH_31 + 1, 1);
        checkException(5, Integer.MAX_VALUE / 2, 1);
        checkException(5, Integer.MAX_VALUE - 1, 1);
        checkException(5, Integer.MAX_VALUE, 1);

        //day of week is 6
        checkException(6, Integer.MIN_VALUE, 1);
        checkException(6, Integer.MIN_VALUE + 1, 1);
        checkException(6, Integer.MIN_VALUE / 2, 1);
        checkException(6, -1, 1);
        checkException(6, 0, 1);
        checkException(6, MAX_DAY_OF_MONTH_31 + 1, 1);
        checkException(6, Integer.MAX_VALUE / 2, 1);
        checkException(6, Integer.MAX_VALUE - 1, 1);
        checkException(6, Integer.MAX_VALUE, 1);

        //day of week is 7
        checkException(7, Integer.MIN_VALUE, 1);
        checkException(7, Integer.MIN_VALUE + 1, 1);
        checkException(7, Integer.MIN_VALUE / 2, 1);
        checkException(7, -1, 1);
        checkException(7, 0, 1);
        checkException(7, MAX_DAY_OF_MONTH_31 + 1, 1);
        checkException(7, Integer.MAX_VALUE / 2, 1);
        checkException(7, Integer.MAX_VALUE - 1, 1);
        checkException(7, Integer.MAX_VALUE, 1);

        //month is 3
        //day of week is 1
        checkException(1, Integer.MIN_VALUE, 3);
        checkException(1, Integer.MIN_VALUE + 1, 3);
        checkException(1, Integer.MIN_VALUE / 2, 3);
        checkException(1, -1, 3);
        checkException(1, 0, 3);
        checkException(1, MAX_DAY_OF_MONTH_31 + 1, 3);
        checkException(1, Integer.MAX_VALUE / 2, 3);
        checkException(1, Integer.MAX_VALUE - 1, 3);
        checkException(1, Integer.MAX_VALUE, 3);

        //day of week is 2
        checkException(2, Integer.MIN_VALUE, 3);
        checkException(2, Integer.MIN_VALUE + 1, 3);
        checkException(2, Integer.MIN_VALUE / 2, 3);
        checkException(2, -1, 3);
        checkException(2, 0, 3);
        checkException(2, MAX_DAY_OF_MONTH_31 + 1, 3);
        checkException(2, Integer.MAX_VALUE / 2, 3);
        checkException(2, Integer.MAX_VALUE - 1, 3);
        checkException(2, Integer.MAX_VALUE, 3);

        //day of week is 3
        checkException(3, Integer.MIN_VALUE, 3);
        checkException(3, Integer.MIN_VALUE + 1, 3);
        checkException(3, Integer.MIN_VALUE / 2, 3);
        checkException(3, -1, 3);
        checkException(3, 0, 3);
        checkException(3, MAX_DAY_OF_MONTH_31 + 1, 3);
        checkException(3, Integer.MAX_VALUE / 2, 3);
        checkException(3, Integer.MAX_VALUE - 1, 3);
        checkException(3, Integer.MAX_VALUE, 3);

        //day of week is 4
        checkException(4, Integer.MIN_VALUE, 3);
        checkException(4, Integer.MIN_VALUE + 1, 3);
        checkException(4, Integer.MIN_VALUE / 2, 3);
        checkException(4, -1, 3);
        checkException(4, 0, 3);
        checkException(4, MAX_DAY_OF_MONTH_31 + 1, 3);
        checkException(4, Integer.MAX_VALUE / 2, 3);
        checkException(4, Integer.MAX_VALUE - 1, 3);
        checkException(4, Integer.MAX_VALUE, 3);

        //day of week is 5
        checkException(5, Integer.MIN_VALUE, 3);
        checkException(5, Integer.MIN_VALUE + 1, 3);
        checkException(5, Integer.MIN_VALUE / 2, 3);
        checkException(5, -1, 3);
        checkException(5, 0, 3);
        checkException(5, MAX_DAY_OF_MONTH_31 + 1, 3);
        checkException(5, Integer.MAX_VALUE / 2, 3);
        checkException(5, Integer.MAX_VALUE - 1, 3);
        checkException(5, Integer.MAX_VALUE, 3);

        //day of week is 6
        checkException(6, Integer.MIN_VALUE, 3);
        checkException(6, Integer.MIN_VALUE + 1, 3);
        checkException(6, Integer.MIN_VALUE / 2, 3);
        checkException(6, -1, 3);
        checkException(6, 0, 3);
        checkException(6, MAX_DAY_OF_MONTH_31 + 1, 3);
        checkException(6, Integer.MAX_VALUE / 2, 3);
        checkException(6, Integer.MAX_VALUE - 1, 3);
        checkException(6, Integer.MAX_VALUE, 3);

        //day of week is 7
        checkException(7, Integer.MIN_VALUE, 3);
        checkException(7, Integer.MIN_VALUE + 1, 3);
        checkException(7, Integer.MIN_VALUE / 2, 3);
        checkException(7, -1, 3);
        checkException(7, 0, 3);
        checkException(7, MAX_DAY_OF_MONTH_31 + 1, 3);
        checkException(7, Integer.MAX_VALUE / 2, 3);
        checkException(7, Integer.MAX_VALUE - 1, 3);
        checkException(7, Integer.MAX_VALUE, 3);

        //month is 5
        //day of week is 1
        checkException(1, Integer.MIN_VALUE, 5);
        checkException(1, Integer.MIN_VALUE + 1, 5);
        checkException(1, Integer.MIN_VALUE / 2, 5);
        checkException(1, -1, 5);
        checkException(1, 0, 5);
        checkException(1, MAX_DAY_OF_MONTH_31 + 1, 5);
        checkException(1, Integer.MAX_VALUE / 2, 5);
        checkException(1, Integer.MAX_VALUE - 1, 5);
        checkException(1, Integer.MAX_VALUE, 5);

        //day of week is 2
        checkException(2, Integer.MIN_VALUE, 5);
        checkException(2, Integer.MIN_VALUE + 1, 5);
        checkException(2, Integer.MIN_VALUE / 2, 5);
        checkException(2, -1, 5);
        checkException(2, 0, 5);
        checkException(2, MAX_DAY_OF_MONTH_31 + 1, 5);
        checkException(2, Integer.MAX_VALUE / 2, 5);
        checkException(2, Integer.MAX_VALUE - 1, 5);
        checkException(2, Integer.MAX_VALUE, 5);

        //day of week is 3
        checkException(3, Integer.MIN_VALUE, 5);
        checkException(3, Integer.MIN_VALUE + 1, 5);
        checkException(3, Integer.MIN_VALUE / 2, 5);
        checkException(3, -1, 5);
        checkException(3, 0, 5);
        checkException(3, MAX_DAY_OF_MONTH_31 + 1, 5);
        checkException(3, Integer.MAX_VALUE / 2, 5);
        checkException(3, Integer.MAX_VALUE - 1, 5);
        checkException(3, Integer.MAX_VALUE, 5);

        //day of week is 4
        checkException(4, Integer.MIN_VALUE, 5);
        checkException(4, Integer.MIN_VALUE + 1, 5);
        checkException(4, Integer.MIN_VALUE / 2, 5);
        checkException(4, -1, 5);
        checkException(4, 0, 5);
        checkException(4, MAX_DAY_OF_MONTH_31 + 1, 5);
        checkException(4, Integer.MAX_VALUE / 2, 5);
        checkException(4, Integer.MAX_VALUE - 1, 5);
        checkException(4, Integer.MAX_VALUE, 5);

        //day of week is 5
        checkException(5, Integer.MIN_VALUE, 5);
        checkException(5, Integer.MIN_VALUE + 1, 5);
        checkException(5, Integer.MIN_VALUE / 2, 5);
        checkException(5, -1, 5);
        checkException(5, 0, 5);
        checkException(5, MAX_DAY_OF_MONTH_31 + 1, 5);
        checkException(5, Integer.MAX_VALUE / 2, 5);
        checkException(5, Integer.MAX_VALUE - 1, 5);
        checkException(5, Integer.MAX_VALUE, 5);

        //day of week is 6
        checkException(6, Integer.MIN_VALUE, 5);
        checkException(6, Integer.MIN_VALUE + 1, 5);
        checkException(6, Integer.MIN_VALUE / 2, 5);
        checkException(6, -1, 5);
        checkException(6, 0, 5);
        checkException(6, MAX_DAY_OF_MONTH_31 + 1, 5);
        checkException(6, Integer.MAX_VALUE / 2, 5);
        checkException(6, Integer.MAX_VALUE - 1, 5);
        checkException(6, Integer.MAX_VALUE, 5);

        //day of week is 7
        checkException(7, Integer.MIN_VALUE, 5);
        checkException(7, Integer.MIN_VALUE + 1, 5);
        checkException(7, Integer.MIN_VALUE / 2, 5);
        checkException(7, -1, 5);
        checkException(7, 0, 5);
        checkException(7, MAX_DAY_OF_MONTH_31 + 1, 5);
        checkException(7, Integer.MAX_VALUE / 2, 5);
        checkException(7, Integer.MAX_VALUE - 1, 5);
        checkException(7, Integer.MAX_VALUE, 5);

        //month is 7
        //day of week is 1
        checkException(1, Integer.MIN_VALUE, 7);
        checkException(1, Integer.MIN_VALUE + 1, 7);
        checkException(1, Integer.MIN_VALUE / 2, 7);
        checkException(1, -1, 7);
        checkException(1, 0, 7);
        checkException(1, MAX_DAY_OF_MONTH_31 + 1, 7);
        checkException(1, Integer.MAX_VALUE / 2, 7);
        checkException(1, Integer.MAX_VALUE - 1, 7);
        checkException(1, Integer.MAX_VALUE, 7);

        //day of week is 2
        checkException(2, Integer.MIN_VALUE, 7);
        checkException(2, Integer.MIN_VALUE + 1, 7);
        checkException(2, Integer.MIN_VALUE / 2, 7);
        checkException(2, -1, 7);
        checkException(2, 0, 7);
        checkException(2, MAX_DAY_OF_MONTH_31 + 1, 7);
        checkException(2, Integer.MAX_VALUE / 2, 7);
        checkException(2, Integer.MAX_VALUE - 1, 7);
        checkException(2, Integer.MAX_VALUE, 7);

        //day of week is 3
        checkException(3, Integer.MIN_VALUE, 7);
        checkException(3, Integer.MIN_VALUE + 1, 7);
        checkException(3, Integer.MIN_VALUE / 2, 7);
        checkException(3, -1, 7);
        checkException(3, 0, 7);
        checkException(3, MAX_DAY_OF_MONTH_31 + 1, 7);
        checkException(3, Integer.MAX_VALUE / 2, 7);
        checkException(3, Integer.MAX_VALUE - 1, 7);
        checkException(3, Integer.MAX_VALUE, 7);

        //day of week is 4
        checkException(4, Integer.MIN_VALUE, 7);
        checkException(4, Integer.MIN_VALUE + 1, 7);
        checkException(4, Integer.MIN_VALUE / 2, 7);
        checkException(4, -1, 7);
        checkException(4, 0, 7);
        checkException(4, MAX_DAY_OF_MONTH_31 + 1, 7);
        checkException(4, Integer.MAX_VALUE / 2, 7);
        checkException(4, Integer.MAX_VALUE - 1, 7);
        checkException(4, Integer.MAX_VALUE, 7);

        //day of week is 5
        checkException(5, Integer.MIN_VALUE, 7);
        checkException(5, Integer.MIN_VALUE + 1, 7);
        checkException(5, Integer.MIN_VALUE / 2, 7);
        checkException(5, -1, 7);
        checkException(5, 0, 7);
        checkException(5, MAX_DAY_OF_MONTH_31 + 1, 7);
        checkException(5, Integer.MAX_VALUE / 2, 7);
        checkException(5, Integer.MAX_VALUE - 1, 7);
        checkException(5, Integer.MAX_VALUE, 7);

        //day of week is 6
        checkException(6, Integer.MIN_VALUE, 7);
        checkException(6, Integer.MIN_VALUE + 1, 7);
        checkException(6, Integer.MIN_VALUE / 2, 7);
        checkException(6, -1, 7);
        checkException(6, 0, 7);
        checkException(6, MAX_DAY_OF_MONTH_31 + 1, 7);
        checkException(6, Integer.MAX_VALUE / 2, 7);
        checkException(6, Integer.MAX_VALUE - 1, 7);
        checkException(6, Integer.MAX_VALUE, 7);

        //day of week is 7
        checkException(7, Integer.MIN_VALUE, 7);
        checkException(7, Integer.MIN_VALUE + 1, 7);
        checkException(7, Integer.MIN_VALUE / 2, 7);
        checkException(7, -1, 7);
        checkException(7, 0, 7);
        checkException(7, MAX_DAY_OF_MONTH_31 + 1, 7);
        checkException(7, Integer.MAX_VALUE / 2, 7);
        checkException(7, Integer.MAX_VALUE - 1, 7);
        checkException(7, Integer.MAX_VALUE, 7);

        //month is 8
        //day of week is 1
        checkException(1, Integer.MIN_VALUE, 8);
        checkException(1, Integer.MIN_VALUE + 1, 8);
        checkException(1, Integer.MIN_VALUE / 2, 8);
        checkException(1, -1, 8);
        checkException(1, 0, 8);
        checkException(1, MAX_DAY_OF_MONTH_31 + 1, 8);
        checkException(1, Integer.MAX_VALUE / 2, 8);
        checkException(1, Integer.MAX_VALUE - 1, 8);
        checkException(1, Integer.MAX_VALUE, 8);

        //day of week is 2
        checkException(2, Integer.MIN_VALUE, 8);
        checkException(2, Integer.MIN_VALUE + 1, 8);
        checkException(2, Integer.MIN_VALUE / 2, 8);
        checkException(2, -1, 8);
        checkException(2, 0, 8);
        checkException(2, MAX_DAY_OF_MONTH_31 + 1, 8);
        checkException(2, Integer.MAX_VALUE / 2, 8);
        checkException(2, Integer.MAX_VALUE - 1, 8);
        checkException(2, Integer.MAX_VALUE, 8);

        //day of week is 3
        checkException(3, Integer.MIN_VALUE, 8);
        checkException(3, Integer.MIN_VALUE + 1, 8);
        checkException(3, Integer.MIN_VALUE / 2, 8);
        checkException(3, -1, 8);
        checkException(3, 0, 8);
        checkException(3, MAX_DAY_OF_MONTH_31 + 1, 8);
        checkException(3, Integer.MAX_VALUE / 2, 8);
        checkException(3, Integer.MAX_VALUE - 1, 8);
        checkException(3, Integer.MAX_VALUE, 8);

        //day of week is 4
        checkException(4, Integer.MIN_VALUE, 8);
        checkException(4, Integer.MIN_VALUE + 1, 8);
        checkException(4, Integer.MIN_VALUE / 2, 8);
        checkException(4, -1, 8);
        checkException(4, 0, 8);
        checkException(4, MAX_DAY_OF_MONTH_31 + 1, 8);
        checkException(4, Integer.MAX_VALUE / 2, 8);
        checkException(4, Integer.MAX_VALUE - 1, 8);
        checkException(4, Integer.MAX_VALUE, 8);

        //day of week is 5
        checkException(5, Integer.MIN_VALUE, 8);
        checkException(5, Integer.MIN_VALUE + 1, 8);
        checkException(5, Integer.MIN_VALUE / 2, 8);
        checkException(5, -1, 8);
        checkException(5, 0, 8);
        checkException(5, MAX_DAY_OF_MONTH_31 + 1, 8);
        checkException(5, Integer.MAX_VALUE / 2, 8);
        checkException(5, Integer.MAX_VALUE - 1, 8);
        checkException(5, Integer.MAX_VALUE, 8);

        //day of week is 6
        checkException(6, Integer.MIN_VALUE, 8);
        checkException(6, Integer.MIN_VALUE + 1, 8);
        checkException(6, Integer.MIN_VALUE / 2, 8);
        checkException(6, -1, 8);
        checkException(6, 0, 8);
        checkException(6, MAX_DAY_OF_MONTH_31 + 1, 8);
        checkException(6, Integer.MAX_VALUE / 2, 8);
        checkException(6, Integer.MAX_VALUE - 1, 8);
        checkException(6, Integer.MAX_VALUE, 8);

        //day of week is 7
        checkException(7, Integer.MIN_VALUE, 8);
        checkException(7, Integer.MIN_VALUE + 1, 8);
        checkException(7, Integer.MIN_VALUE / 2, 8);
        checkException(7, -1, 8);
        checkException(7, 0, 8);
        checkException(7, MAX_DAY_OF_MONTH_31 + 1, 8);
        checkException(7, Integer.MAX_VALUE / 2, 8);
        checkException(7, Integer.MAX_VALUE - 1, 8);
        checkException(7, Integer.MAX_VALUE, 8);

        //month is 12
        //day of week is 1
        checkException(1, Integer.MIN_VALUE, 12);
        checkException(1, Integer.MIN_VALUE + 1, 12);
        checkException(1, Integer.MIN_VALUE / 2, 12);
        checkException(1, -1, 12);
        checkException(1, 0, 12);
        checkException(1, MAX_DAY_OF_MONTH_31 + 1, 12);
        checkException(1, Integer.MAX_VALUE / 2, 12);
        checkException(1, Integer.MAX_VALUE - 1, 12);
        checkException(1, Integer.MAX_VALUE, 12);

        //day of week is 2
        checkException(2, Integer.MIN_VALUE, 12);
        checkException(2, Integer.MIN_VALUE + 1, 12);
        checkException(2, Integer.MIN_VALUE / 2, 12);
        checkException(2, -1, 12);
        checkException(2, 0, 12);
        checkException(2, MAX_DAY_OF_MONTH_31 + 1, 12);
        checkException(2, Integer.MAX_VALUE / 2, 12);
        checkException(2, Integer.MAX_VALUE - 1, 12);
        checkException(2, Integer.MAX_VALUE, 12);

        //day of week is 3
        checkException(3, Integer.MIN_VALUE, 12);
        checkException(3, Integer.MIN_VALUE + 1, 12);
        checkException(3, Integer.MIN_VALUE / 2, 12);
        checkException(3, -1, 12);
        checkException(3, 0, 12);
        checkException(3, MAX_DAY_OF_MONTH_31 + 1, 12);
        checkException(3, Integer.MAX_VALUE / 2, 12);
        checkException(3, Integer.MAX_VALUE - 1, 12);
        checkException(3, Integer.MAX_VALUE, 12);

        //day of week is 4
        checkException(4, Integer.MIN_VALUE, 12);
        checkException(4, Integer.MIN_VALUE + 1, 12);
        checkException(4, Integer.MIN_VALUE / 2, 12);
        checkException(4, -1, 12);
        checkException(4, 0, 12);
        checkException(4, MAX_DAY_OF_MONTH_31 + 1, 12);
        checkException(4, Integer.MAX_VALUE / 2, 12);
        checkException(4, Integer.MAX_VALUE - 1, 12);
        checkException(4, Integer.MAX_VALUE, 12);

        //day of week is 5
        checkException(5, Integer.MIN_VALUE, 12);
        checkException(5, Integer.MIN_VALUE + 1, 12);
        checkException(5, Integer.MIN_VALUE / 2, 12);
        checkException(5, -1, 12);
        checkException(5, 0, 12);
        checkException(5, MAX_DAY_OF_MONTH_31 + 1, 12);
        checkException(5, Integer.MAX_VALUE / 2, 12);
        checkException(5, Integer.MAX_VALUE - 1, 12);
        checkException(5, Integer.MAX_VALUE, 12);

        //day of week is 6
        checkException(6, Integer.MIN_VALUE, 12);
        checkException(6, Integer.MIN_VALUE + 1, 12);
        checkException(6, Integer.MIN_VALUE / 2, 12);
        checkException(6, -1, 12);
        checkException(6, 0, 12);
        checkException(6, MAX_DAY_OF_MONTH_31 + 1, 12);
        checkException(6, Integer.MAX_VALUE / 2, 12);
        checkException(6, Integer.MAX_VALUE - 1, 12);
        checkException(6, Integer.MAX_VALUE, 12);

        //day of week is 7
        checkException(7, Integer.MIN_VALUE, 12);
        checkException(7, Integer.MIN_VALUE + 1, 12);
        checkException(7, Integer.MIN_VALUE / 2, 12);
        checkException(7, -1, 12);
        checkException(7, 0, 12);
        checkException(7, MAX_DAY_OF_MONTH_31 + 1, 12);
        checkException(7, Integer.MAX_VALUE / 2, 12);
        checkException(7, Integer.MAX_VALUE - 1, 12);
        checkException(7, Integer.MAX_VALUE, 12);

        //month is 8
        //day of week is 1
        checkException(1, Integer.MIN_VALUE, 8);
        checkException(1, Integer.MIN_VALUE + 1, 8);
        checkException(1, Integer.MIN_VALUE / 2, 8);
        checkException(1, -1, 8);
        checkException(1, 0, 8);
        checkException(1, MAX_DAY_OF_MONTH_31 + 1, 8);
        checkException(1, Integer.MAX_VALUE / 2, 8);
        checkException(1, Integer.MAX_VALUE - 1, 8);
        checkException(1, Integer.MAX_VALUE, 8);

        //day of week is 2
        checkException(2, Integer.MIN_VALUE, 8);
        checkException(2, Integer.MIN_VALUE + 1, 8);
        checkException(2, Integer.MIN_VALUE / 2, 8);
        checkException(2, -1, 8);
        checkException(2, 0, 8);
        checkException(2, MAX_DAY_OF_MONTH_31 + 1, 8);
        checkException(2, Integer.MAX_VALUE / 2, 8);
        checkException(2, Integer.MAX_VALUE - 1, 8);
        checkException(2, Integer.MAX_VALUE, 8);

        //day of week is 3
        checkException(3, Integer.MIN_VALUE, 8);
        checkException(3, Integer.MIN_VALUE + 1, 8);
        checkException(3, Integer.MIN_VALUE / 2, 8);
        checkException(3, -1, 8);
        checkException(3, 0, 8);
        checkException(3, MAX_DAY_OF_MONTH_31 + 1, 8);
        checkException(3, Integer.MAX_VALUE / 2, 8);
        checkException(3, Integer.MAX_VALUE - 1, 8);
        checkException(3, Integer.MAX_VALUE, 8);

        //day of week is 4
        checkException(4, Integer.MIN_VALUE, 8);
        checkException(4, Integer.MIN_VALUE + 1, 8);
        checkException(4, Integer.MIN_VALUE / 2, 8);
        checkException(4, -1, 8);
        checkException(4, 0, 8);
        checkException(4, MAX_DAY_OF_MONTH_31 + 1, 8);
        checkException(4, Integer.MAX_VALUE / 2, 8);
        checkException(4, Integer.MAX_VALUE - 1, 8);
        checkException(4, Integer.MAX_VALUE, 8);

        //day of week is 5
        checkException(5, Integer.MIN_VALUE, 8);
        checkException(5, Integer.MIN_VALUE + 1, 8);
        checkException(5, Integer.MIN_VALUE / 2, 8);
        checkException(5, -1, 8);
        checkException(5, 0, 8);
        checkException(5, MAX_DAY_OF_MONTH_31 + 1, 8);
        checkException(5, Integer.MAX_VALUE / 2, 8);
        checkException(5, Integer.MAX_VALUE - 1, 8);
        checkException(5, Integer.MAX_VALUE, 8);

        //day of week is 6
        checkException(6, Integer.MIN_VALUE, 8);
        checkException(6, Integer.MIN_VALUE + 1, 8);
        checkException(6, Integer.MIN_VALUE / 2, 8);
        checkException(6, -1, 8);
        checkException(6, 0, 8);
        checkException(6, MAX_DAY_OF_MONTH_31 + 1, 8);
        checkException(6, Integer.MAX_VALUE / 2, 8);
        checkException(6, Integer.MAX_VALUE - 1, 8);
        checkException(6, Integer.MAX_VALUE, 8);

        //day of week is 7
        checkException(7, Integer.MIN_VALUE, 8);
        checkException(7, Integer.MIN_VALUE + 1, 8);
        checkException(7, Integer.MIN_VALUE / 2, 8);
        checkException(7, -1, 8);
        checkException(7, 0, 8);
        checkException(7, MAX_DAY_OF_MONTH_31 + 1, 8);
        checkException(7, Integer.MAX_VALUE / 2, 8);
        checkException(7, Integer.MAX_VALUE - 1, 8);
        checkException(7, Integer.MAX_VALUE, 8);
    }

    /**
     * Function for testing valid args for task5 (day of week).
     * For inputted args define day of week.
     * Simulates user input from console with valid args.
     *
     * @param dayOfNewYear day of week from which the year started.
     * @param dayToFind    number of day to define day of week.
     * @param monthToFind  number of month to define day of week.
     * @param expected     expected day of week.
     */
    void check(int dayOfNewYear, int dayToFind, int monthToFind, String expected) {
        //Task 5 by itself
        DaysOfWeek[] daysOfWeeks = DaysOfWeek.values();
        Months[] months = Months.values();
        String actual = DayOfWeek.defineDayOfWeek(daysOfWeeks[dayOfNewYear - 1], dayToFind, months[monthToFind - 1]);
        assertEquals(expected, actual);

        //Task 5 in main
        String input = "5" + L_S + dayOfNewYear + L_S + dayToFind + L_S + monthToFind;
        String expectedMain = MESSAGE +
                expected + L_S;

        runMain(input, expectedMain);
    }

    /**
     * Function for testing non-valid args for task5 (day of week).
     * For inputted parameters an IncorrectArgumentException should be thrown.
     * Simulates user input from console with non-valid args.
     *
     * @param dayOfNewYear day of week from which the year started.
     * @param dayToFind    number of day to define day of week.
     * @param monthToFind  number of month to define day of week.
     * @see IncorrectArgumentException
     */
    void checkException(int dayOfNewYear, int dayToFind, int monthToFind) {
        //Task 5 by itself
        DaysOfWeek[] daysOfWeeks = DaysOfWeek.values();
        Months[] months = Months.values();

        try {
            DayOfWeek.defineDayOfWeek(daysOfWeeks[dayOfNewYear - 1], dayToFind, months[monthToFind - 1]);
            fail("Exception was not thrown");
        } catch (IncorrectArgumentException e) {
            //correct behavior
        }

        //Task 5 in main
        String input = "5" + L_S + dayOfNewYear + L_S + dayToFind + L_S + monthToFind;

        String expected = MESSAGE +
                "Wrong input. Expected: valid date for day and month." + L_S +
                "Got: " + dayToFind + " day, " + months[monthToFind - 1].name() + " month" + L_S;

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
