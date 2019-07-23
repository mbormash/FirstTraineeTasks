import com.implemica.bormashenko.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static com.implemica.bormashenko.Task5.DaysOfWeek;
import static com.implemica.bormashenko.Task5.Months;

import static com.implemica.bormashenko.Task5.DaysOfWeek.MONDAY;
import static com.implemica.bormashenko.Task5.DaysOfWeek.TUESDAY;
import static com.implemica.bormashenko.Task5.DaysOfWeek.WEDNESDAY;
import static com.implemica.bormashenko.Task5.DaysOfWeek.THURSDAY;
import static com.implemica.bormashenko.Task5.DaysOfWeek.FRIDAY;
import static com.implemica.bormashenko.Task5.DaysOfWeek.SATURDAY;
import static com.implemica.bormashenko.Task5.DaysOfWeek.SUNDAY;

import static com.implemica.bormashenko.Task5.Months.JANUARY;
import static com.implemica.bormashenko.Task5.Months.FEBRUARY;
import static com.implemica.bormashenko.Task5.Months.MARCH;
import static com.implemica.bormashenko.Task5.Months.APRIL;
import static com.implemica.bormashenko.Task5.Months.MAY;
import static com.implemica.bormashenko.Task5.Months.JUNE;
import static com.implemica.bormashenko.Task5.Months.JULY;
import static com.implemica.bormashenko.Task5.Months.AUGUST;
import static com.implemica.bormashenko.Task5.Months.SEPTEMBER;
import static com.implemica.bormashenko.Task5.Months.OCTOBER;
import static com.implemica.bormashenko.Task5.Months.NOVEMBER;
import static com.implemica.bormashenko.Task5.Months.DECEMBER;

/**
 * Test class for Task5 (day of week).
 *
 * @author Mykhailo Bormashenko
 */
class Task5Test {

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
     * Tests with valid args for task5 (day of week).
     * 7 tests for several values return from "Monday" to "Sunday";
     * 7 * 12 * 7 (168) boundary and special values tests;
     * 175 tests at all.
     */
    @Test
    void validArgsTests() {
        //several random tests
        check(TUESDAY, 27, MAY, "Monday");
        check(WEDNESDAY, 15, JULY, "Tuesday");
        check(FRIDAY, 7, JULY, "Wednesday");
        check(TUESDAY, 28, MARCH, "Thursday");
        check(TUESDAY, 20, DECEMBER, "Friday");
        check(FRIDAY, 1, MAY, "Saturday");
        check(FRIDAY, 10, OCTOBER, "Sunday");

        //day of New Year is Monday
        //month is 1
        check(MONDAY, 1, JANUARY, "Monday");
        check(MONDAY, 2, JANUARY, "Tuesday");
        check(MONDAY, 7, JANUARY, "Sunday");
        check(MONDAY, 8, JANUARY, "Monday");
        check(MONDAY, 9, JANUARY, "Tuesday");
        check(MONDAY, MAX_DAY_OF_MONTH_31 - 1, JANUARY, "Tuesday");
        check(MONDAY, MAX_DAY_OF_MONTH_31, JANUARY, "Wednesday");
        //month is 2
        check(MONDAY, 1, FEBRUARY, "Thursday");
        check(MONDAY, 2, FEBRUARY, "Friday");
        check(MONDAY, 7, FEBRUARY, "Wednesday");
        check(MONDAY, 8, FEBRUARY, "Thursday");
        check(MONDAY, 9, FEBRUARY, "Friday");
        check(MONDAY, MAX_DAY_OF_MONTH_28 - 1, FEBRUARY, "Tuesday");
        check(MONDAY, MAX_DAY_OF_MONTH_28, FEBRUARY, "Wednesday");
        //month is 3
        check(MONDAY, 1, MARCH, "Thursday");
        check(MONDAY, 2, MARCH, "Friday");
        check(MONDAY, 7, MARCH, "Wednesday");
        check(MONDAY, 8, MARCH, "Thursday");
        check(MONDAY, 9, MARCH, "Friday");
        check(MONDAY, MAX_DAY_OF_MONTH_31 - 1, MARCH, "Friday");
        check(MONDAY, MAX_DAY_OF_MONTH_31, MARCH, "Saturday");
        //month is 4
        check(MONDAY, 1, APRIL, "Sunday");
        check(MONDAY, 2, APRIL, "Monday");
        check(MONDAY, 7, APRIL, "Saturday");
        check(MONDAY, 8, APRIL, "Sunday");
        check(MONDAY, 9, APRIL, "Monday");
        check(MONDAY, MAX_DAY_OF_MONTH_30 - 1, APRIL, "Sunday");
        check(MONDAY, MAX_DAY_OF_MONTH_30, APRIL, "Monday");
        //month is 5
        check(MONDAY, 1, MAY, "Tuesday");
        check(MONDAY, 2, MAY, "Wednesday");
        check(MONDAY, 7, MAY, "Monday");
        check(MONDAY, 8, MAY, "Tuesday");
        check(MONDAY, 9, MAY, "Wednesday");
        check(MONDAY, MAX_DAY_OF_MONTH_31 - 1, MAY, "Wednesday");
        check(MONDAY, MAX_DAY_OF_MONTH_31, MAY, "Thursday");
        //month is 6
        check(MONDAY, 1, JUNE, "Friday");
        check(MONDAY, 2, JUNE, "Saturday");
        check(MONDAY, 7, JUNE, "Thursday");
        check(MONDAY, 8, JUNE, "Friday");
        check(MONDAY, 9, JUNE, "Saturday");
        check(MONDAY, MAX_DAY_OF_MONTH_30 - 1, JUNE, "Friday");
        check(MONDAY, MAX_DAY_OF_MONTH_30, JUNE, "Saturday");
        //month is 7
        check(MONDAY, 1, JULY, "Sunday");
        check(MONDAY, 2, JULY, "Monday");
        check(MONDAY, 7, JULY, "Saturday");
        check(MONDAY, 8, JULY, "Sunday");
        check(MONDAY, 9, JULY, "Monday");
        check(MONDAY, MAX_DAY_OF_MONTH_31 - 1, JULY, "Monday");
        check(MONDAY, MAX_DAY_OF_MONTH_31, JULY, "Tuesday");
        //month is 8
        check(MONDAY, 1, AUGUST, "Wednesday");
        check(MONDAY, 2, AUGUST, "Thursday");
        check(MONDAY, 7, AUGUST, "Tuesday");
        check(MONDAY, 8, AUGUST, "Wednesday");
        check(MONDAY, 9, AUGUST, "Thursday");
        check(MONDAY, MAX_DAY_OF_MONTH_31 - 1, AUGUST, "Thursday");
        check(MONDAY, MAX_DAY_OF_MONTH_31, AUGUST, "Friday");
        //month is 9
        check(MONDAY, 1, SEPTEMBER, "Saturday");
        check(MONDAY, 2, SEPTEMBER, "Sunday");
        check(MONDAY, 7, SEPTEMBER, "Friday");
        check(MONDAY, 8, SEPTEMBER, "Saturday");
        check(MONDAY, 9, SEPTEMBER, "Sunday");
        check(MONDAY, MAX_DAY_OF_MONTH_30 - 1, SEPTEMBER, "Saturday");
        check(MONDAY, MAX_DAY_OF_MONTH_30, SEPTEMBER, "Sunday");
        //month is 10
        check(MONDAY, 1, OCTOBER, "Monday");
        check(MONDAY, 2, OCTOBER, "Tuesday");
        check(MONDAY, 7, OCTOBER, "Sunday");
        check(MONDAY, 8, OCTOBER, "Monday");
        check(MONDAY, 9, OCTOBER, "Tuesday");
        check(MONDAY, MAX_DAY_OF_MONTH_31 - 1, OCTOBER, "Tuesday");
        check(MONDAY, MAX_DAY_OF_MONTH_31, OCTOBER, "Wednesday");
        //month is 11
        check(MONDAY, 1, NOVEMBER, "Thursday");
        check(MONDAY, 2, NOVEMBER, "Friday");
        check(MONDAY, 7, NOVEMBER, "Wednesday");
        check(MONDAY, 8, NOVEMBER, "Thursday");
        check(MONDAY, 9, NOVEMBER, "Friday");
        check(MONDAY, MAX_DAY_OF_MONTH_30 - 1, NOVEMBER, "Thursday");
        check(MONDAY, MAX_DAY_OF_MONTH_30, NOVEMBER, "Friday");
        //month is 12
        check(MONDAY, 1, DECEMBER, "Saturday");
        check(MONDAY, 2, DECEMBER, "Sunday");
        check(MONDAY, 7, DECEMBER, "Friday");
        check(MONDAY, 8, DECEMBER, "Saturday");
        check(MONDAY, 9, DECEMBER, "Sunday");
        check(MONDAY, MAX_DAY_OF_MONTH_31 - 1, DECEMBER, "Sunday");
        check(MONDAY, MAX_DAY_OF_MONTH_31, DECEMBER, "Monday");

        //day of New Year is Tuesday
        //month is 1
        check(TUESDAY, 1, JANUARY, "Tuesday");
        check(TUESDAY, 2, JANUARY, "Wednesday");
        check(TUESDAY, 7, JANUARY, "Monday");
        check(TUESDAY, 8, JANUARY, "Tuesday");
        check(TUESDAY, 9, JANUARY, "Wednesday");
        check(TUESDAY, MAX_DAY_OF_MONTH_31 - 1, JANUARY, "Wednesday");
        check(TUESDAY, MAX_DAY_OF_MONTH_31, JANUARY, "Thursday");
        //month is 2
        check(TUESDAY, 1, FEBRUARY, "Friday");
        check(TUESDAY, 2, FEBRUARY, "Saturday");
        check(TUESDAY, 7, FEBRUARY, "Thursday");
        check(TUESDAY, 8, FEBRUARY, "Friday");
        check(TUESDAY, 9, FEBRUARY, "Saturday");
        check(TUESDAY, MAX_DAY_OF_MONTH_28 - 1, FEBRUARY, "Wednesday");
        check(TUESDAY, MAX_DAY_OF_MONTH_28, FEBRUARY, "Thursday");
        //month is 3
        check(TUESDAY, 1, MARCH, "Friday");
        check(TUESDAY, 2, MARCH, "Saturday");
        check(TUESDAY, 7, MARCH, "Thursday");
        check(TUESDAY, 8, MARCH, "Friday");
        check(TUESDAY, 9, MARCH, "Saturday");
        check(TUESDAY, MAX_DAY_OF_MONTH_31 - 1, MARCH, "Saturday");
        check(TUESDAY, MAX_DAY_OF_MONTH_31, MARCH, "Sunday");
        //month is 4
        check(TUESDAY, 1, APRIL, "Monday");
        check(TUESDAY, 2, APRIL, "Tuesday");
        check(TUESDAY, 7, APRIL, "Sunday");
        check(TUESDAY, 8, APRIL, "Monday");
        check(TUESDAY, 9, APRIL, "Tuesday");
        check(TUESDAY, MAX_DAY_OF_MONTH_30 - 1, APRIL, "Monday");
        check(TUESDAY, MAX_DAY_OF_MONTH_30, APRIL, "Tuesday");
        //month is 5
        check(TUESDAY, 1, MAY, "Wednesday");
        check(TUESDAY, 2, MAY, "Thursday");
        check(TUESDAY, 7, MAY, "Tuesday");
        check(TUESDAY, 8, MAY, "Wednesday");
        check(TUESDAY, 9, MAY, "Thursday");
        check(TUESDAY, MAX_DAY_OF_MONTH_31 - 1, MAY, "Thursday");
        check(TUESDAY, MAX_DAY_OF_MONTH_31, MAY, "Friday");
        //month is 6
        check(TUESDAY, 1, JUNE, "Saturday");
        check(TUESDAY, 2, JUNE, "Sunday");
        check(TUESDAY, 7, JUNE, "Friday");
        check(TUESDAY, 8, JUNE, "Saturday");
        check(TUESDAY, 9, JUNE, "Sunday");
        check(TUESDAY, MAX_DAY_OF_MONTH_30 - 1, JUNE, "Saturday");
        check(TUESDAY, MAX_DAY_OF_MONTH_30, JUNE, "Sunday");
        //month is 7
        check(TUESDAY, 1, JULY, "Monday");
        check(TUESDAY, 2, JULY, "Tuesday");
        check(TUESDAY, 7, JULY, "Sunday");
        check(TUESDAY, 8, JULY, "Monday");
        check(TUESDAY, 9, JULY, "Tuesday");
        check(TUESDAY, MAX_DAY_OF_MONTH_31 - 1, JULY, "Tuesday");
        check(TUESDAY, MAX_DAY_OF_MONTH_31, JULY, "Wednesday");
        //month is 8
        check(TUESDAY, 1, AUGUST, "Thursday");
        check(TUESDAY, 2, AUGUST, "Friday");
        check(TUESDAY, 7, AUGUST, "Wednesday");
        check(TUESDAY, 8, AUGUST, "Thursday");
        check(TUESDAY, 9, AUGUST, "Friday");
        check(TUESDAY, MAX_DAY_OF_MONTH_31 - 1, AUGUST, "Friday");
        check(TUESDAY, MAX_DAY_OF_MONTH_31, AUGUST, "Saturday");
        //month is 9
        check(TUESDAY, 1, SEPTEMBER, "Sunday");
        check(TUESDAY, 2, SEPTEMBER, "Monday");
        check(TUESDAY, 7, SEPTEMBER, "Saturday");
        check(TUESDAY, 8, SEPTEMBER, "Sunday");
        check(TUESDAY, 9, SEPTEMBER, "Monday");
        check(TUESDAY, MAX_DAY_OF_MONTH_30 - 1, SEPTEMBER, "Sunday");
        check(TUESDAY, MAX_DAY_OF_MONTH_30, SEPTEMBER, "Monday");
        //month is 10
        check(TUESDAY, 1, OCTOBER, "Tuesday");
        check(TUESDAY, 2, OCTOBER, "Wednesday");
        check(TUESDAY, 7, OCTOBER, "Monday");
        check(TUESDAY, 8, OCTOBER, "Tuesday");
        check(TUESDAY, 9, OCTOBER, "Wednesday");
        check(TUESDAY, MAX_DAY_OF_MONTH_31 - 1, OCTOBER, "Wednesday");
        check(TUESDAY, MAX_DAY_OF_MONTH_31, OCTOBER, "Thursday");
        //month is 11
        check(TUESDAY, 1, NOVEMBER, "Friday");
        check(TUESDAY, 2, NOVEMBER, "Saturday");
        check(TUESDAY, 7, NOVEMBER, "Thursday");
        check(TUESDAY, 8, NOVEMBER, "Friday");
        check(TUESDAY, 9, NOVEMBER, "Saturday");
        check(TUESDAY, MAX_DAY_OF_MONTH_30 - 1, NOVEMBER, "Friday");
        check(TUESDAY, MAX_DAY_OF_MONTH_30, NOVEMBER, "Saturday");
        //month is 12
        check(TUESDAY, 1, DECEMBER, "Sunday");
        check(TUESDAY, 2, DECEMBER, "Monday");
        check(TUESDAY, 7, DECEMBER, "Saturday");
        check(TUESDAY, 8, DECEMBER, "Sunday");
        check(TUESDAY, 9, DECEMBER, "Monday");
        check(TUESDAY, MAX_DAY_OF_MONTH_31 - 1, DECEMBER, "Monday");
        check(TUESDAY, MAX_DAY_OF_MONTH_31, DECEMBER, "Tuesday");

        //day of New Year is Tuesday
        //month is 1
        check(WEDNESDAY, 1, JANUARY, "Wednesday");
        check(WEDNESDAY, 2, JANUARY, "Thursday");
        check(WEDNESDAY, 7, JANUARY, "Tuesday");
        check(WEDNESDAY, 8, JANUARY, "Wednesday");
        check(WEDNESDAY, 9, JANUARY, "Thursday");
        check(WEDNESDAY, MAX_DAY_OF_MONTH_31 - 1, JANUARY, "Thursday");
        check(WEDNESDAY, MAX_DAY_OF_MONTH_31, JANUARY, "Friday");
        //month is 2
        check(WEDNESDAY, 1, FEBRUARY, "Saturday");
        check(WEDNESDAY, 2, FEBRUARY, "Sunday");
        check(WEDNESDAY, 7, FEBRUARY, "Friday");
        check(WEDNESDAY, 8, FEBRUARY, "Saturday");
        check(WEDNESDAY, 9, FEBRUARY, "Sunday");
        check(WEDNESDAY, MAX_DAY_OF_MONTH_28 - 1, FEBRUARY, "Thursday");
        check(WEDNESDAY, MAX_DAY_OF_MONTH_28, FEBRUARY, "Friday");
        //month is 3
        check(WEDNESDAY, 1, MARCH, "Saturday");
        check(WEDNESDAY, 2, MARCH, "Sunday");
        check(WEDNESDAY, 7, MARCH, "Friday");
        check(WEDNESDAY, 8, MARCH, "Saturday");
        check(WEDNESDAY, 9, MARCH, "Sunday");
        check(WEDNESDAY, MAX_DAY_OF_MONTH_31 - 1, MARCH, "Sunday");
        check(WEDNESDAY, MAX_DAY_OF_MONTH_31, MARCH, "Monday");
        //month is 4
        check(WEDNESDAY, 1, APRIL, "Tuesday");
        check(WEDNESDAY, 2, APRIL, "Wednesday");
        check(WEDNESDAY, 7, APRIL, "Monday");
        check(WEDNESDAY, 8, APRIL, "Tuesday");
        check(WEDNESDAY, 9, APRIL, "Wednesday");
        check(WEDNESDAY, MAX_DAY_OF_MONTH_30 - 1, APRIL, "Tuesday");
        check(WEDNESDAY, MAX_DAY_OF_MONTH_30, APRIL, "Wednesday");
        //month is 5
        check(WEDNESDAY, 1, MAY, "Thursday");
        check(WEDNESDAY, 2, MAY, "Friday");
        check(WEDNESDAY, 7, MAY, "Wednesday");
        check(WEDNESDAY, 8, MAY, "Thursday");
        check(WEDNESDAY, 9, MAY, "Friday");
        check(WEDNESDAY, MAX_DAY_OF_MONTH_31 - 1, MAY, "Friday");
        check(WEDNESDAY, MAX_DAY_OF_MONTH_31, MAY, "Saturday");
        //month is 6
        check(WEDNESDAY, 1, JUNE, "Sunday");
        check(WEDNESDAY, 2, JUNE, "Monday");
        check(WEDNESDAY, 7, JUNE, "Saturday");
        check(WEDNESDAY, 8, JUNE, "Sunday");
        check(WEDNESDAY, 9, JUNE, "Monday");
        check(WEDNESDAY, MAX_DAY_OF_MONTH_30 - 1, JUNE, "Sunday");
        check(WEDNESDAY, MAX_DAY_OF_MONTH_30, JUNE, "Monday");
        //month is 7
        check(WEDNESDAY, 1, JULY, "Tuesday");
        check(WEDNESDAY, 2, JULY, "Wednesday");
        check(WEDNESDAY, 7, JULY, "Monday");
        check(WEDNESDAY, 8, JULY, "Tuesday");
        check(WEDNESDAY, 9, JULY, "Wednesday");
        check(WEDNESDAY, MAX_DAY_OF_MONTH_31 - 1, JULY, "Wednesday");
        check(WEDNESDAY, MAX_DAY_OF_MONTH_31, JULY, "Thursday");
        //month is 8
        check(WEDNESDAY, 1, AUGUST, "Friday");
        check(WEDNESDAY, 2, AUGUST, "Saturday");
        check(WEDNESDAY, 7, AUGUST, "Thursday");
        check(WEDNESDAY, 8, AUGUST, "Friday");
        check(WEDNESDAY, 9, AUGUST, "Saturday");
        check(WEDNESDAY, MAX_DAY_OF_MONTH_31 - 1, AUGUST, "Saturday");
        check(WEDNESDAY, MAX_DAY_OF_MONTH_31, AUGUST, "Sunday");
        //month is 9
        check(WEDNESDAY, 1, SEPTEMBER, "Monday");
        check(WEDNESDAY, 2, SEPTEMBER, "Tuesday");
        check(WEDNESDAY, 7, SEPTEMBER, "Sunday");
        check(WEDNESDAY, 8, SEPTEMBER, "Monday");
        check(WEDNESDAY, 9, SEPTEMBER, "Tuesday");
        check(WEDNESDAY, MAX_DAY_OF_MONTH_30 - 1, SEPTEMBER, "Monday");
        check(WEDNESDAY, MAX_DAY_OF_MONTH_30, SEPTEMBER, "Tuesday");
        //month is 10
        check(WEDNESDAY, 1, OCTOBER, "Wednesday");
        check(WEDNESDAY, 2, OCTOBER, "Thursday");
        check(WEDNESDAY, 7, OCTOBER, "Tuesday");
        check(WEDNESDAY, 8, OCTOBER, "Wednesday");
        check(WEDNESDAY, 9, OCTOBER, "Thursday");
        check(WEDNESDAY, MAX_DAY_OF_MONTH_31 - 1, OCTOBER, "Thursday");
        check(WEDNESDAY, MAX_DAY_OF_MONTH_31, OCTOBER, "Friday");
        //month is 11
        check(WEDNESDAY, 1, NOVEMBER, "Saturday");
        check(WEDNESDAY, 2, NOVEMBER, "Sunday");
        check(WEDNESDAY, 7, NOVEMBER, "Friday");
        check(WEDNESDAY, 8, NOVEMBER, "Saturday");
        check(WEDNESDAY, 9, NOVEMBER, "Sunday");
        check(WEDNESDAY, MAX_DAY_OF_MONTH_30 - 1, NOVEMBER, "Saturday");
        check(WEDNESDAY, MAX_DAY_OF_MONTH_30, NOVEMBER, "Sunday");
        //month is 12
        check(WEDNESDAY, 1, DECEMBER, "Monday");
        check(WEDNESDAY, 2, DECEMBER, "Tuesday");
        check(WEDNESDAY, 7, DECEMBER, "Sunday");
        check(WEDNESDAY, 8, DECEMBER, "Monday");
        check(WEDNESDAY, 9, DECEMBER, "Tuesday");
        check(WEDNESDAY, MAX_DAY_OF_MONTH_31 - 1, DECEMBER, "Tuesday");
        check(WEDNESDAY, MAX_DAY_OF_MONTH_31, DECEMBER, "Wednesday");

        //day of New Year is Thursday
        //month is 1
        check(THURSDAY, 1, JANUARY, "Thursday");
        check(THURSDAY, 2, JANUARY, "Friday");
        check(THURSDAY, 7, JANUARY, "Wednesday");
        check(THURSDAY, 8, JANUARY, "Thursday");
        check(THURSDAY, 9, JANUARY, "Friday");
        check(THURSDAY, MAX_DAY_OF_MONTH_31 - 1, JANUARY, "Friday");
        check(THURSDAY, MAX_DAY_OF_MONTH_31, JANUARY, "Saturday");
        //month is 2
        check(THURSDAY, 1, FEBRUARY, "Sunday");
        check(THURSDAY, 2, FEBRUARY, "Monday");
        check(THURSDAY, 7, FEBRUARY, "Saturday");
        check(THURSDAY, 8, FEBRUARY, "Sunday");
        check(THURSDAY, 9, FEBRUARY, "Monday");
        check(THURSDAY, MAX_DAY_OF_MONTH_28 - 1, FEBRUARY, "Friday");
        check(THURSDAY, MAX_DAY_OF_MONTH_28, FEBRUARY, "Saturday");
        //month is 3
        check(THURSDAY, 1, MARCH, "Sunday");
        check(THURSDAY, 2, MARCH, "Monday");
        check(THURSDAY, 7, MARCH, "Saturday");
        check(THURSDAY, 8, MARCH, "Sunday");
        check(THURSDAY, 9, MARCH, "Monday");
        check(THURSDAY, MAX_DAY_OF_MONTH_31 - 1, MARCH, "Monday");
        check(THURSDAY, MAX_DAY_OF_MONTH_31, MARCH, "Tuesday");
        //month is 4
        check(THURSDAY, 1, APRIL, "Wednesday");
        check(THURSDAY, 2, APRIL, "Thursday");
        check(THURSDAY, 7, APRIL, "Tuesday");
        check(THURSDAY, 8, APRIL, "Wednesday");
        check(THURSDAY, 9, APRIL, "Thursday");
        check(THURSDAY, MAX_DAY_OF_MONTH_30 - 1, APRIL, "Wednesday");
        check(THURSDAY, MAX_DAY_OF_MONTH_30, APRIL, "Thursday");
        //month is 5
        check(THURSDAY, 1, MAY, "Friday");
        check(THURSDAY, 2, MAY, "Saturday");
        check(THURSDAY, 7, MAY, "Thursday");
        check(THURSDAY, 8, MAY, "Friday");
        check(THURSDAY, 9, MAY, "Saturday");
        check(THURSDAY, MAX_DAY_OF_MONTH_31 - 1, MAY, "Saturday");
        check(THURSDAY, MAX_DAY_OF_MONTH_31, MAY, "Sunday");
        //month is 6
        check(THURSDAY, 1, JUNE, "Monday");
        check(THURSDAY, 2, JUNE, "Tuesday");
        check(THURSDAY, 7, JUNE, "Sunday");
        check(THURSDAY, 8, JUNE, "Monday");
        check(THURSDAY, 9, JUNE, "Tuesday");
        check(THURSDAY, MAX_DAY_OF_MONTH_30 - 1, JUNE, "Monday");
        check(THURSDAY, MAX_DAY_OF_MONTH_30, JUNE, "Tuesday");
        //month is 7
        check(THURSDAY, 1, JULY, "Wednesday");
        check(THURSDAY, 2, JULY, "Thursday");
        check(THURSDAY, 7, JULY, "Tuesday");
        check(THURSDAY, 8, JULY, "Wednesday");
        check(THURSDAY, 9, JULY, "Thursday");
        check(THURSDAY, MAX_DAY_OF_MONTH_31 - 1, JULY, "Thursday");
        check(THURSDAY, MAX_DAY_OF_MONTH_31, JULY, "Friday");
        //month is 8
        check(THURSDAY, 1, AUGUST, "Saturday");
        check(THURSDAY, 2, AUGUST, "Sunday");
        check(THURSDAY, 7, AUGUST, "Friday");
        check(THURSDAY, 8, AUGUST, "Saturday");
        check(THURSDAY, 9, AUGUST, "Sunday");
        check(THURSDAY, MAX_DAY_OF_MONTH_31 - 1, AUGUST, "Sunday");
        check(THURSDAY, MAX_DAY_OF_MONTH_31, AUGUST, "Monday");
        //month is 9
        check(THURSDAY, 1, SEPTEMBER, "Tuesday");
        check(THURSDAY, 2, SEPTEMBER, "Wednesday");
        check(THURSDAY, 7, SEPTEMBER, "Monday");
        check(THURSDAY, 8, SEPTEMBER, "Tuesday");
        check(THURSDAY, 9, SEPTEMBER, "Wednesday");
        check(THURSDAY, MAX_DAY_OF_MONTH_30 - 1, SEPTEMBER, "Tuesday");
        check(THURSDAY, MAX_DAY_OF_MONTH_30, SEPTEMBER, "Wednesday");
        //month is 10
        check(THURSDAY, 1, OCTOBER, "Thursday");
        check(THURSDAY, 2, OCTOBER, "Friday");
        check(THURSDAY, 7, OCTOBER, "Wednesday");
        check(THURSDAY, 8, OCTOBER, "Thursday");
        check(THURSDAY, 9, OCTOBER, "Friday");
        check(THURSDAY, MAX_DAY_OF_MONTH_31 - 1, OCTOBER, "Friday");
        check(THURSDAY, MAX_DAY_OF_MONTH_31, OCTOBER, "Saturday");
        //month is 11
        check(THURSDAY, 1, NOVEMBER, "Sunday");
        check(THURSDAY, 2, NOVEMBER, "Monday");
        check(THURSDAY, 7, NOVEMBER, "Saturday");
        check(THURSDAY, 8, NOVEMBER, "Sunday");
        check(THURSDAY, 9, NOVEMBER, "Monday");
        check(THURSDAY, MAX_DAY_OF_MONTH_30 - 1, NOVEMBER, "Sunday");
        check(THURSDAY, MAX_DAY_OF_MONTH_30, NOVEMBER, "Monday");
        //month is 12
        check(THURSDAY, 1, DECEMBER, "Tuesday");
        check(THURSDAY, 2, DECEMBER, "Wednesday");
        check(THURSDAY, 7, DECEMBER, "Monday");
        check(THURSDAY, 8, DECEMBER, "Tuesday");
        check(THURSDAY, 9, DECEMBER, "Wednesday");
        check(THURSDAY, MAX_DAY_OF_MONTH_31 - 1, DECEMBER, "Wednesday");
        check(THURSDAY, MAX_DAY_OF_MONTH_31, DECEMBER, "Thursday");

        //day of New Year is Friday
        //month is 1
        check(FRIDAY, 1, JANUARY, "Friday");
        check(FRIDAY, 2, JANUARY, "Saturday");
        check(FRIDAY, 7, JANUARY, "Thursday");
        check(FRIDAY, 8, JANUARY, "Friday");
        check(FRIDAY, 9, JANUARY, "Saturday");
        check(FRIDAY, MAX_DAY_OF_MONTH_31 - 1, JANUARY, "Saturday");
        check(FRIDAY, MAX_DAY_OF_MONTH_31, JANUARY, "Sunday");
        //month is 2
        check(FRIDAY, 1, FEBRUARY, "Monday");
        check(FRIDAY, 2, FEBRUARY, "Tuesday");
        check(FRIDAY, 7, FEBRUARY, "Sunday");
        check(FRIDAY, 8, FEBRUARY, "Monday");
        check(FRIDAY, 9, FEBRUARY, "Tuesday");
        check(FRIDAY, MAX_DAY_OF_MONTH_28 - 1, FEBRUARY, "Saturday");
        check(FRIDAY, MAX_DAY_OF_MONTH_28, FEBRUARY, "Sunday");
        //month is 3
        check(FRIDAY, 1, MARCH, "Monday");
        check(FRIDAY, 2, MARCH, "Tuesday");
        check(FRIDAY, 7, MARCH, "Sunday");
        check(FRIDAY, 8, MARCH, "Monday");
        check(FRIDAY, 9, MARCH, "Tuesday");
        check(FRIDAY, MAX_DAY_OF_MONTH_31 - 1, MARCH, "Tuesday");
        check(FRIDAY, MAX_DAY_OF_MONTH_31, MARCH, "Wednesday");
        //month is 4
        check(FRIDAY, 1, APRIL, "Thursday");
        check(FRIDAY, 2, APRIL, "Friday");
        check(FRIDAY, 7, APRIL, "Wednesday");
        check(FRIDAY, 8, APRIL, "Thursday");
        check(FRIDAY, 9, APRIL, "Friday");
        check(FRIDAY, MAX_DAY_OF_MONTH_30 - 1, APRIL, "Thursday");
        check(FRIDAY, MAX_DAY_OF_MONTH_30, APRIL, "Friday");
        //month is 5
        check(FRIDAY, 1, MAY, "Saturday");
        check(FRIDAY, 2, MAY, "Sunday");
        check(FRIDAY, 7, MAY, "Friday");
        check(FRIDAY, 8, MAY, "Saturday");
        check(FRIDAY, 9, MAY, "Sunday");
        check(FRIDAY, MAX_DAY_OF_MONTH_31 - 1, MAY, "Sunday");
        check(FRIDAY, MAX_DAY_OF_MONTH_31, MAY, "Monday");
        //month is 6
        check(FRIDAY, 1, JUNE, "Tuesday");
        check(FRIDAY, 2, JUNE, "Wednesday");
        check(FRIDAY, 7, JUNE, "Monday");
        check(FRIDAY, 8, JUNE, "Tuesday");
        check(FRIDAY, 9, JUNE, "Wednesday");
        check(FRIDAY, MAX_DAY_OF_MONTH_30 - 1, JUNE, "Tuesday");
        check(FRIDAY, MAX_DAY_OF_MONTH_30, JUNE, "Wednesday");
        //month is 7
        check(FRIDAY, 1, JULY, "Thursday");
        check(FRIDAY, 2, JULY, "Friday");
        check(FRIDAY, 7, JULY, "Wednesday");
        check(FRIDAY, 8, JULY, "Thursday");
        check(FRIDAY, 9, JULY, "Friday");
        check(FRIDAY, MAX_DAY_OF_MONTH_31 - 1, JULY, "Friday");
        check(FRIDAY, MAX_DAY_OF_MONTH_31, JULY, "Saturday");
        //month is 8
        check(FRIDAY, 1, AUGUST, "Sunday");
        check(FRIDAY, 2, AUGUST, "Monday");
        check(FRIDAY, 7, AUGUST, "Saturday");
        check(FRIDAY, 8, AUGUST, "Sunday");
        check(FRIDAY, 9, AUGUST, "Monday");
        check(FRIDAY, MAX_DAY_OF_MONTH_31 - 1, AUGUST, "Monday");
        check(FRIDAY, MAX_DAY_OF_MONTH_31, AUGUST, "Tuesday");
        //month is 9
        check(FRIDAY, 1, SEPTEMBER, "Wednesday");
        check(FRIDAY, 2, SEPTEMBER, "Thursday");
        check(FRIDAY, 7, SEPTEMBER, "Tuesday");
        check(FRIDAY, 8, SEPTEMBER, "Wednesday");
        check(FRIDAY, 9, SEPTEMBER, "Thursday");
        check(FRIDAY, MAX_DAY_OF_MONTH_30 - 1, SEPTEMBER, "Wednesday");
        check(FRIDAY, MAX_DAY_OF_MONTH_30, SEPTEMBER, "Thursday");
        //month is 10
        check(FRIDAY, 1, OCTOBER, "Friday");
        check(FRIDAY, 2, OCTOBER, "Saturday");
        check(FRIDAY, 7, OCTOBER, "Thursday");
        check(FRIDAY, 8, OCTOBER, "Friday");
        check(FRIDAY, 9, OCTOBER, "Saturday");
        check(FRIDAY, MAX_DAY_OF_MONTH_31 - 1, OCTOBER, "Saturday");
        check(FRIDAY, MAX_DAY_OF_MONTH_31, OCTOBER, "Sunday");
        //month is 11
        check(FRIDAY, 1, NOVEMBER, "Monday");
        check(FRIDAY, 2, NOVEMBER, "Tuesday");
        check(FRIDAY, 7, NOVEMBER, "Sunday");
        check(FRIDAY, 8, NOVEMBER, "Monday");
        check(FRIDAY, 9, NOVEMBER, "Tuesday");
        check(FRIDAY, MAX_DAY_OF_MONTH_30 - 1, NOVEMBER, "Monday");
        check(FRIDAY, MAX_DAY_OF_MONTH_30, NOVEMBER, "Tuesday");
        //month is 12
        check(FRIDAY, 1, DECEMBER, "Wednesday");
        check(FRIDAY, 2, DECEMBER, "Thursday");
        check(FRIDAY, 7, DECEMBER, "Tuesday");
        check(FRIDAY, 8, DECEMBER, "Wednesday");
        check(FRIDAY, 9, DECEMBER, "Thursday");
        check(FRIDAY, MAX_DAY_OF_MONTH_31 - 1, DECEMBER, "Thursday");
        check(FRIDAY, MAX_DAY_OF_MONTH_31, DECEMBER, "Friday");

        //day of New Year is Saturday
        //month is 1
        check(SATURDAY, 1, JANUARY, "Saturday");
        check(SATURDAY, 2, JANUARY, "Sunday");
        check(SATURDAY, 7, JANUARY, "Friday");
        check(SATURDAY, 8, JANUARY, "Saturday");
        check(SATURDAY, 9, JANUARY, "Sunday");
        check(SATURDAY, MAX_DAY_OF_MONTH_31 - 1, JANUARY, "Sunday");
        check(SATURDAY, MAX_DAY_OF_MONTH_31, JANUARY, "Monday");
        //month is 2
        check(SATURDAY, 1, FEBRUARY, "Tuesday");
        check(SATURDAY, 2, FEBRUARY, "Wednesday");
        check(SATURDAY, 7, FEBRUARY, "Monday");
        check(SATURDAY, 8, FEBRUARY, "Tuesday");
        check(SATURDAY, 9, FEBRUARY, "Wednesday");
        check(SATURDAY, MAX_DAY_OF_MONTH_28 - 1, FEBRUARY, "Sunday");
        check(SATURDAY, MAX_DAY_OF_MONTH_28, FEBRUARY, "Monday");
        //month is 3
        check(SATURDAY, 1, MARCH, "Tuesday");
        check(SATURDAY, 2, MARCH, "Wednesday");
        check(SATURDAY, 7, MARCH, "Monday");
        check(SATURDAY, 8, MARCH, "Tuesday");
        check(SATURDAY, 9, MARCH, "Wednesday");
        check(SATURDAY, MAX_DAY_OF_MONTH_31 - 1, MARCH, "Wednesday");
        check(SATURDAY, MAX_DAY_OF_MONTH_31, MARCH, "Thursday");
        //month is 4
        check(SATURDAY, 1, APRIL, "Friday");
        check(SATURDAY, 2, APRIL, "Saturday");
        check(SATURDAY, 7, APRIL, "Thursday");
        check(SATURDAY, 8, APRIL, "Friday");
        check(SATURDAY, 9, APRIL, "Saturday");
        check(SATURDAY, MAX_DAY_OF_MONTH_30 - 1, APRIL, "Friday");
        check(SATURDAY, MAX_DAY_OF_MONTH_30, APRIL, "Saturday");
        //month is 5
        check(SATURDAY, 1, MAY, "Sunday");
        check(SATURDAY, 2, MAY, "Monday");
        check(SATURDAY, 7, MAY, "Saturday");
        check(SATURDAY, 8, MAY, "Sunday");
        check(SATURDAY, 9, MAY, "Monday");
        check(SATURDAY, MAX_DAY_OF_MONTH_31 - 1, MAY, "Monday");
        check(SATURDAY, MAX_DAY_OF_MONTH_31, MAY, "Tuesday");
        //month is 6
        check(SATURDAY, 1, JUNE, "Wednesday");
        check(SATURDAY, 2, JUNE, "Thursday");
        check(SATURDAY, 7, JUNE, "Tuesday");
        check(SATURDAY, 8, JUNE, "Wednesday");
        check(SATURDAY, 9, JUNE, "Thursday");
        check(SATURDAY, MAX_DAY_OF_MONTH_30 - 1, JUNE, "Wednesday");
        check(SATURDAY, MAX_DAY_OF_MONTH_30, JUNE, "Thursday");
        //month is 7
        check(SATURDAY, 1, JULY, "Friday");
        check(SATURDAY, 2, JULY, "Saturday");
        check(SATURDAY, 7, JULY, "Thursday");
        check(SATURDAY, 8, JULY, "Friday");
        check(SATURDAY, 9, JULY, "Saturday");
        check(SATURDAY, MAX_DAY_OF_MONTH_31 - 1, JULY, "Saturday");
        check(SATURDAY, MAX_DAY_OF_MONTH_31, JULY, "Sunday");
        //month is 8
        check(SATURDAY, 1, AUGUST, "Monday");
        check(SATURDAY, 2, AUGUST, "Tuesday");
        check(SATURDAY, 7, AUGUST, "Sunday");
        check(SATURDAY, 8, AUGUST, "Monday");
        check(SATURDAY, 9, AUGUST, "Tuesday");
        check(SATURDAY, MAX_DAY_OF_MONTH_31 - 1, AUGUST, "Tuesday");
        check(SATURDAY, MAX_DAY_OF_MONTH_31, AUGUST, "Wednesday");
        //month is 9
        check(SATURDAY, 1, SEPTEMBER, "Thursday");
        check(SATURDAY, 2, SEPTEMBER, "Friday");
        check(SATURDAY, 7, SEPTEMBER, "Wednesday");
        check(SATURDAY, 8, SEPTEMBER, "Thursday");
        check(SATURDAY, 9, SEPTEMBER, "Friday");
        check(SATURDAY, MAX_DAY_OF_MONTH_30 - 1, SEPTEMBER, "Thursday");
        check(SATURDAY, MAX_DAY_OF_MONTH_30, SEPTEMBER, "Friday");
        //month is 10
        check(SATURDAY, 1, OCTOBER, "Saturday");
        check(SATURDAY, 2, OCTOBER, "Sunday");
        check(SATURDAY, 7, OCTOBER, "Friday");
        check(SATURDAY, 8, OCTOBER, "Saturday");
        check(SATURDAY, 9, OCTOBER, "Sunday");
        check(SATURDAY, MAX_DAY_OF_MONTH_31 - 1, OCTOBER, "Sunday");
        check(SATURDAY, MAX_DAY_OF_MONTH_31, OCTOBER, "Monday");
        //month is 11
        check(SATURDAY, 1, NOVEMBER, "Tuesday");
        check(SATURDAY, 2, NOVEMBER, "Wednesday");
        check(SATURDAY, 7, NOVEMBER, "Monday");
        check(SATURDAY, 8, NOVEMBER, "Tuesday");
        check(SATURDAY, 9, NOVEMBER, "Wednesday");
        check(SATURDAY, MAX_DAY_OF_MONTH_30 - 1, NOVEMBER, "Tuesday");
        check(SATURDAY, MAX_DAY_OF_MONTH_30, NOVEMBER, "Wednesday");
        //month is 12
        check(SATURDAY, 1, DECEMBER, "Thursday");
        check(SATURDAY, 2, DECEMBER, "Friday");
        check(SATURDAY, 7, DECEMBER, "Wednesday");
        check(SATURDAY, 8, DECEMBER, "Thursday");
        check(SATURDAY, 9, DECEMBER, "Friday");
        check(SATURDAY, MAX_DAY_OF_MONTH_31 - 1, DECEMBER, "Friday");
        check(SATURDAY, MAX_DAY_OF_MONTH_31, DECEMBER, "Saturday");

        //day of New Year is Sunday
        //month is 1
        check(SUNDAY, 1, JANUARY, "Sunday");
        check(SUNDAY, 2, JANUARY, "Monday");
        check(SUNDAY, 7, JANUARY, "Saturday");
        check(SUNDAY, 8, JANUARY, "Sunday");
        check(SUNDAY, 9, JANUARY, "Monday");
        check(SUNDAY, MAX_DAY_OF_MONTH_31 - 1, JANUARY, "Monday");
        check(SUNDAY, MAX_DAY_OF_MONTH_31, JANUARY, "Tuesday");
        //month is 2
        check(SUNDAY, 1, FEBRUARY, "Wednesday");
        check(SUNDAY, 2, FEBRUARY, "Thursday");
        check(SUNDAY, 7, FEBRUARY, "Tuesday");
        check(SUNDAY, 8, FEBRUARY, "Wednesday");
        check(SUNDAY, 9, FEBRUARY, "Thursday");
        check(SUNDAY, MAX_DAY_OF_MONTH_28 - 1, FEBRUARY, "Monday");
        check(SUNDAY, MAX_DAY_OF_MONTH_28, FEBRUARY, "Tuesday");
        //month is 3
        check(SUNDAY, 1, MARCH, "Wednesday");
        check(SUNDAY, 2, MARCH, "Thursday");
        check(SUNDAY, 7, MARCH, "Tuesday");
        check(SUNDAY, 8, MARCH, "Wednesday");
        check(SUNDAY, 9, MARCH, "Thursday");
        check(SUNDAY, MAX_DAY_OF_MONTH_31 - 1, MARCH, "Thursday");
        check(SUNDAY, MAX_DAY_OF_MONTH_31, MARCH, "Friday");
        //month is 4
        check(SUNDAY, 1, APRIL, "Saturday");
        check(SUNDAY, 2, APRIL, "Sunday");
        check(SUNDAY, 7, APRIL, "Friday");
        check(SUNDAY, 8, APRIL, "Saturday");
        check(SUNDAY, 9, APRIL, "Sunday");
        check(SUNDAY, MAX_DAY_OF_MONTH_30 - 1, APRIL, "Saturday");
        check(SUNDAY, MAX_DAY_OF_MONTH_30, APRIL, "Sunday");
        //month is 5
        check(SUNDAY, 1, MAY, "Monday");
        check(SUNDAY, 2, MAY, "Tuesday");
        check(SUNDAY, 7, MAY, "Sunday");
        check(SUNDAY, 8, MAY, "Monday");
        check(SUNDAY, 9, MAY, "Tuesday");
        check(SUNDAY, MAX_DAY_OF_MONTH_31 - 1, MAY, "Tuesday");
        check(SUNDAY, MAX_DAY_OF_MONTH_31, MAY, "Wednesday");
        //month is 6
        check(SUNDAY, 1, JUNE, "Thursday");
        check(SUNDAY, 2, JUNE, "Friday");
        check(SUNDAY, 7, JUNE, "Wednesday");
        check(SUNDAY, 8, JUNE, "Thursday");
        check(SUNDAY, 9, JUNE, "Friday");
        check(SUNDAY, MAX_DAY_OF_MONTH_30 - 1, JUNE, "Thursday");
        check(SUNDAY, MAX_DAY_OF_MONTH_30, JUNE, "Friday");
        //month is 7
        check(SUNDAY, 1, JULY, "Saturday");
        check(SUNDAY, 2, JULY, "Sunday");
        check(SUNDAY, 7, JULY, "Friday");
        check(SUNDAY, 8, JULY, "Saturday");
        check(SUNDAY, 9, JULY, "Sunday");
        check(SUNDAY, MAX_DAY_OF_MONTH_31 - 1, JULY, "Sunday");
        check(SUNDAY, MAX_DAY_OF_MONTH_31, JULY, "Monday");
        //month is 8
        check(SUNDAY, 1, AUGUST, "Tuesday");
        check(SUNDAY, 2, AUGUST, "Wednesday");
        check(SUNDAY, 7, AUGUST, "Monday");
        check(SUNDAY, 8, AUGUST, "Tuesday");
        check(SUNDAY, 9, AUGUST, "Wednesday");
        check(SUNDAY, MAX_DAY_OF_MONTH_31 - 1, AUGUST, "Wednesday");
        check(SUNDAY, MAX_DAY_OF_MONTH_31, AUGUST, "Thursday");
        //month is 9
        check(SUNDAY, 1, SEPTEMBER, "Friday");
        check(SUNDAY, 2, SEPTEMBER, "Saturday");
        check(SUNDAY, 7, SEPTEMBER, "Thursday");
        check(SUNDAY, 8, SEPTEMBER, "Friday");
        check(SUNDAY, 9, SEPTEMBER, "Saturday");
        check(SUNDAY, MAX_DAY_OF_MONTH_30 - 1, SEPTEMBER, "Friday");
        check(SUNDAY, MAX_DAY_OF_MONTH_30, SEPTEMBER, "Saturday");
        //month is 10
        check(SUNDAY, 1, OCTOBER, "Sunday");
        check(SUNDAY, 2, OCTOBER, "Monday");
        check(SUNDAY, 7, OCTOBER, "Saturday");
        check(SUNDAY, 8, OCTOBER, "Sunday");
        check(SUNDAY, 9, OCTOBER, "Monday");
        check(SUNDAY, MAX_DAY_OF_MONTH_31 - 1, OCTOBER, "Monday");
        check(SUNDAY, MAX_DAY_OF_MONTH_31, OCTOBER, "Tuesday");
        //month is 11
        check(SUNDAY, 1, NOVEMBER, "Wednesday");
        check(SUNDAY, 2, NOVEMBER, "Thursday");
        check(SUNDAY, 7, NOVEMBER, "Tuesday");
        check(SUNDAY, 8, NOVEMBER, "Wednesday");
        check(SUNDAY, 9, NOVEMBER, "Thursday");
        check(SUNDAY, MAX_DAY_OF_MONTH_30 - 1, NOVEMBER, "Wednesday");
        check(SUNDAY, MAX_DAY_OF_MONTH_30, NOVEMBER, "Thursday");
        //month is 12
        check(SUNDAY, 1, DECEMBER, "Friday");
        check(SUNDAY, 2, DECEMBER, "Saturday");
        check(SUNDAY, 7, DECEMBER, "Thursday");
        check(SUNDAY, 8, DECEMBER, "Friday");
        check(SUNDAY, 9, DECEMBER, "Saturday");
        check(SUNDAY, MAX_DAY_OF_MONTH_31 - 1, DECEMBER, "Saturday");
        check(SUNDAY, MAX_DAY_OF_MONTH_31, DECEMBER, "Sunday");
    }

    /**
     * Tests with non-valid args for task5 (day of week).
     * 9 tests for every day of week of New Year for every month;
     * 756 tests at all.
     */
    @Test
    void nonValidArgsTests() {
        //non valid day of month (for february)
        //day of New Year is monday
        checkException(MONDAY, Integer.MIN_VALUE, FEBRUARY);
        checkException(MONDAY, Integer.MIN_VALUE + 1, FEBRUARY);
        checkException(MONDAY, Integer.MIN_VALUE / 2, FEBRUARY);
        checkException(MONDAY, -1, FEBRUARY);
        checkException(MONDAY, 0, FEBRUARY);
        checkException(MONDAY, MAX_DAY_OF_MONTH_28 + 1, FEBRUARY);
        checkException(MONDAY, Integer.MAX_VALUE / 2, FEBRUARY);
        checkException(MONDAY, Integer.MAX_VALUE - 1, FEBRUARY);
        checkException(MONDAY, Integer.MAX_VALUE, FEBRUARY);

        //day of New Year is tuesday
        checkException(TUESDAY, Integer.MIN_VALUE, FEBRUARY);
        checkException(TUESDAY, Integer.MIN_VALUE + 1, FEBRUARY);
        checkException(TUESDAY, Integer.MIN_VALUE / 2, FEBRUARY);
        checkException(TUESDAY, -1, FEBRUARY);
        checkException(TUESDAY, 0, FEBRUARY);
        checkException(TUESDAY, MAX_DAY_OF_MONTH_28 + 1, FEBRUARY);
        checkException(TUESDAY, Integer.MAX_VALUE / 2, FEBRUARY);
        checkException(TUESDAY, Integer.MAX_VALUE - 1, FEBRUARY);
        checkException(TUESDAY, Integer.MAX_VALUE, FEBRUARY);

        //day of New Year is wednesday
        checkException(WEDNESDAY, Integer.MIN_VALUE, FEBRUARY);
        checkException(WEDNESDAY, Integer.MIN_VALUE + 1, FEBRUARY);
        checkException(WEDNESDAY, Integer.MIN_VALUE / 2, FEBRUARY);
        checkException(WEDNESDAY, -1, FEBRUARY);
        checkException(WEDNESDAY, 0, FEBRUARY);
        checkException(WEDNESDAY, MAX_DAY_OF_MONTH_28 + 1, FEBRUARY);
        checkException(WEDNESDAY, Integer.MAX_VALUE / 2, FEBRUARY);
        checkException(WEDNESDAY, Integer.MAX_VALUE - 1, FEBRUARY);
        checkException(WEDNESDAY, Integer.MAX_VALUE, FEBRUARY);

        //day of New Year is thursday
        checkException(THURSDAY, Integer.MIN_VALUE, FEBRUARY);
        checkException(THURSDAY, Integer.MIN_VALUE + 1, FEBRUARY);
        checkException(THURSDAY, Integer.MIN_VALUE / 2, FEBRUARY);
        checkException(THURSDAY, -1, FEBRUARY);
        checkException(THURSDAY, 0, FEBRUARY);
        checkException(THURSDAY, MAX_DAY_OF_MONTH_28 + 1, FEBRUARY);
        checkException(THURSDAY, Integer.MAX_VALUE / 2, FEBRUARY);
        checkException(THURSDAY, Integer.MAX_VALUE - 1, FEBRUARY);
        checkException(THURSDAY, Integer.MAX_VALUE, FEBRUARY);

        //day of New Year is friday
        checkException(FRIDAY, Integer.MIN_VALUE, FEBRUARY);
        checkException(FRIDAY, Integer.MIN_VALUE + 1, FEBRUARY);
        checkException(FRIDAY, Integer.MIN_VALUE / 2, FEBRUARY);
        checkException(FRIDAY, -1, FEBRUARY);
        checkException(FRIDAY, 0, FEBRUARY);
        checkException(FRIDAY, MAX_DAY_OF_MONTH_28 + 1, FEBRUARY);
        checkException(FRIDAY, Integer.MAX_VALUE / 2, FEBRUARY);
        checkException(FRIDAY, Integer.MAX_VALUE - 1, FEBRUARY);
        checkException(FRIDAY, Integer.MAX_VALUE, FEBRUARY);

        //day of New Year is saturday
        checkException(SATURDAY, Integer.MIN_VALUE, FEBRUARY);
        checkException(SATURDAY, Integer.MIN_VALUE + 1, FEBRUARY);
        checkException(SATURDAY, Integer.MIN_VALUE / 2, FEBRUARY);
        checkException(SATURDAY, -1, FEBRUARY);
        checkException(SATURDAY, 0, FEBRUARY);
        checkException(SATURDAY, MAX_DAY_OF_MONTH_28 + 1, FEBRUARY);
        checkException(SATURDAY, Integer.MAX_VALUE / 2, FEBRUARY);
        checkException(SATURDAY, Integer.MAX_VALUE - 1, FEBRUARY);
        checkException(SATURDAY, Integer.MAX_VALUE, FEBRUARY);

        //day of New Year is sunday
        checkException(SUNDAY, Integer.MIN_VALUE, FEBRUARY);
        checkException(SUNDAY, Integer.MIN_VALUE + 1, FEBRUARY);
        checkException(SUNDAY, Integer.MIN_VALUE / 2, FEBRUARY);
        checkException(SUNDAY, -1, FEBRUARY);
        checkException(SUNDAY, 0, FEBRUARY);
        checkException(SUNDAY, MAX_DAY_OF_MONTH_28 + 1, FEBRUARY);
        checkException(SUNDAY, Integer.MAX_VALUE / 2, FEBRUARY);
        checkException(SUNDAY, Integer.MAX_VALUE - 1, FEBRUARY);
        checkException(SUNDAY, Integer.MAX_VALUE, FEBRUARY);

        //non valid day of month (for 30-days months)
        //month is april
        //day of New Year is monday
        checkException(MONDAY, Integer.MIN_VALUE, APRIL);
        checkException(MONDAY, Integer.MIN_VALUE + 1, APRIL);
        checkException(MONDAY, Integer.MIN_VALUE / 2, APRIL);
        checkException(MONDAY, -1, APRIL);
        checkException(MONDAY, 0, APRIL);
        checkException(MONDAY, MAX_DAY_OF_MONTH_30 + 1, APRIL);
        checkException(MONDAY, Integer.MAX_VALUE / 2, APRIL);
        checkException(MONDAY, Integer.MAX_VALUE - 1, APRIL);
        checkException(MONDAY, Integer.MAX_VALUE, APRIL);

        //day of New Year is tuesday
        checkException(TUESDAY, Integer.MIN_VALUE, APRIL);
        checkException(TUESDAY, Integer.MIN_VALUE + 1, APRIL);
        checkException(TUESDAY, Integer.MIN_VALUE / 2, APRIL);
        checkException(TUESDAY, -1, APRIL);
        checkException(TUESDAY, 0, APRIL);
        checkException(TUESDAY, MAX_DAY_OF_MONTH_30 + 1, APRIL);
        checkException(TUESDAY, Integer.MAX_VALUE / 2, APRIL);
        checkException(TUESDAY, Integer.MAX_VALUE - 1, APRIL);
        checkException(TUESDAY, Integer.MAX_VALUE, APRIL);

        //day of New Year is wednesday
        checkException(WEDNESDAY, Integer.MIN_VALUE, APRIL);
        checkException(WEDNESDAY, Integer.MIN_VALUE + 1, APRIL);
        checkException(WEDNESDAY, Integer.MIN_VALUE / 2, APRIL);
        checkException(WEDNESDAY, -1, APRIL);
        checkException(WEDNESDAY, 0, APRIL);
        checkException(WEDNESDAY, MAX_DAY_OF_MONTH_30 + 1, APRIL);
        checkException(WEDNESDAY, Integer.MAX_VALUE / 2, APRIL);
        checkException(WEDNESDAY, Integer.MAX_VALUE - 1, APRIL);
        checkException(WEDNESDAY, Integer.MAX_VALUE, APRIL);

        //day of New Year is thursday
        checkException(THURSDAY, Integer.MIN_VALUE, APRIL);
        checkException(THURSDAY, Integer.MIN_VALUE + 1, APRIL);
        checkException(THURSDAY, Integer.MIN_VALUE / 2, APRIL);
        checkException(THURSDAY, -1, APRIL);
        checkException(THURSDAY, 0, APRIL);
        checkException(THURSDAY, MAX_DAY_OF_MONTH_30 + 1, APRIL);
        checkException(THURSDAY, Integer.MAX_VALUE / 2, APRIL);
        checkException(THURSDAY, Integer.MAX_VALUE - 1, APRIL);
        checkException(THURSDAY, Integer.MAX_VALUE, APRIL);

        //day of New Year is friday
        checkException(FRIDAY, Integer.MIN_VALUE, APRIL);
        checkException(FRIDAY, Integer.MIN_VALUE + 1, APRIL);
        checkException(FRIDAY, Integer.MIN_VALUE / 2, APRIL);
        checkException(FRIDAY, -1, APRIL);
        checkException(FRIDAY, 0, APRIL);
        checkException(FRIDAY, MAX_DAY_OF_MONTH_30 + 1, APRIL);
        checkException(FRIDAY, Integer.MAX_VALUE / 2, APRIL);
        checkException(FRIDAY, Integer.MAX_VALUE - 1, APRIL);
        checkException(FRIDAY, Integer.MAX_VALUE, APRIL);

        //day of New Year is saturday
        checkException(SATURDAY, Integer.MIN_VALUE, APRIL);
        checkException(SATURDAY, Integer.MIN_VALUE + 1, APRIL);
        checkException(SATURDAY, Integer.MIN_VALUE / 2, APRIL);
        checkException(SATURDAY, -1, APRIL);
        checkException(SATURDAY, 0, APRIL);
        checkException(SATURDAY, MAX_DAY_OF_MONTH_30 + 1, APRIL);
        checkException(SATURDAY, Integer.MAX_VALUE / 2, APRIL);
        checkException(SATURDAY, Integer.MAX_VALUE - 1, APRIL);
        checkException(SATURDAY, Integer.MAX_VALUE, APRIL);

        //day of New Year is sunday
        checkException(SUNDAY, Integer.MIN_VALUE, APRIL);
        checkException(SUNDAY, Integer.MIN_VALUE + 1, APRIL);
        checkException(SUNDAY, Integer.MIN_VALUE / 2, APRIL);
        checkException(SUNDAY, -1, APRIL);
        checkException(SUNDAY, 0, APRIL);
        checkException(SUNDAY, MAX_DAY_OF_MONTH_30 + 1, APRIL);
        checkException(SUNDAY, Integer.MAX_VALUE / 2, APRIL);
        checkException(SUNDAY, Integer.MAX_VALUE - 1, APRIL);
        checkException(SUNDAY, Integer.MAX_VALUE, APRIL);

        //month is june
        //day of New Year is monday
        checkException(MONDAY, Integer.MIN_VALUE, JUNE);
        checkException(MONDAY, Integer.MIN_VALUE + 1, JUNE);
        checkException(MONDAY, Integer.MIN_VALUE / 2, JUNE);
        checkException(MONDAY, -1, JUNE);
        checkException(MONDAY, 0, JUNE);
        checkException(MONDAY, MAX_DAY_OF_MONTH_30 + 1, JUNE);
        checkException(MONDAY, Integer.MAX_VALUE / 2, JUNE);
        checkException(MONDAY, Integer.MAX_VALUE - 1, JUNE);
        checkException(MONDAY, Integer.MAX_VALUE, JUNE);

        //day of New Year is tuesday
        checkException(TUESDAY, Integer.MIN_VALUE, JUNE);
        checkException(TUESDAY, Integer.MIN_VALUE + 1, JUNE);
        checkException(TUESDAY, Integer.MIN_VALUE / 2, JUNE);
        checkException(TUESDAY, -1, JUNE);
        checkException(TUESDAY, 0, JUNE);
        checkException(TUESDAY, MAX_DAY_OF_MONTH_30 + 1, JUNE);
        checkException(TUESDAY, Integer.MAX_VALUE / 2, JUNE);
        checkException(TUESDAY, Integer.MAX_VALUE - 1, JUNE);
        checkException(TUESDAY, Integer.MAX_VALUE, JUNE);

        //day of New Year is wednesday
        checkException(WEDNESDAY, Integer.MIN_VALUE, JUNE);
        checkException(WEDNESDAY, Integer.MIN_VALUE + 1, JUNE);
        checkException(WEDNESDAY, Integer.MIN_VALUE / 2, JUNE);
        checkException(WEDNESDAY, -1, JUNE);
        checkException(WEDNESDAY, 0, JUNE);
        checkException(WEDNESDAY, MAX_DAY_OF_MONTH_30 + 1, JUNE);
        checkException(WEDNESDAY, Integer.MAX_VALUE / 2, JUNE);
        checkException(WEDNESDAY, Integer.MAX_VALUE - 1, JUNE);
        checkException(WEDNESDAY, Integer.MAX_VALUE, JUNE);

        //day of New Year is thursday
        checkException(THURSDAY, Integer.MIN_VALUE, JUNE);
        checkException(THURSDAY, Integer.MIN_VALUE + 1, JUNE);
        checkException(THURSDAY, Integer.MIN_VALUE / 2, JUNE);
        checkException(THURSDAY, -1, JUNE);
        checkException(THURSDAY, 0, JUNE);
        checkException(THURSDAY, MAX_DAY_OF_MONTH_30 + 1, JUNE);
        checkException(THURSDAY, Integer.MAX_VALUE / 2, JUNE);
        checkException(THURSDAY, Integer.MAX_VALUE - 1, JUNE);
        checkException(THURSDAY, Integer.MAX_VALUE, JUNE);

        //day of New Year is friday
        checkException(FRIDAY, Integer.MIN_VALUE, JUNE);
        checkException(FRIDAY, Integer.MIN_VALUE + 1, JUNE);
        checkException(FRIDAY, Integer.MIN_VALUE / 2, JUNE);
        checkException(FRIDAY, -1, JUNE);
        checkException(FRIDAY, 0, JUNE);
        checkException(FRIDAY, MAX_DAY_OF_MONTH_30 + 1, JUNE);
        checkException(FRIDAY, Integer.MAX_VALUE / 2, JUNE);
        checkException(FRIDAY, Integer.MAX_VALUE - 1, JUNE);
        checkException(FRIDAY, Integer.MAX_VALUE, JUNE);

        //day of New Year is saturday
        checkException(SATURDAY, Integer.MIN_VALUE, JUNE);
        checkException(SATURDAY, Integer.MIN_VALUE + 1, JUNE);
        checkException(SATURDAY, Integer.MIN_VALUE / 2, JUNE);
        checkException(SATURDAY, -1, JUNE);
        checkException(SATURDAY, 0, JUNE);
        checkException(SATURDAY, MAX_DAY_OF_MONTH_30 + 1, JUNE);
        checkException(SATURDAY, Integer.MAX_VALUE / 2, JUNE);
        checkException(SATURDAY, Integer.MAX_VALUE - 1, JUNE);
        checkException(SATURDAY, Integer.MAX_VALUE, JUNE);

        //day of New Year is sunday
        checkException(SUNDAY, Integer.MIN_VALUE, JUNE);
        checkException(SUNDAY, Integer.MIN_VALUE + 1, JUNE);
        checkException(SUNDAY, Integer.MIN_VALUE / 2, JUNE);
        checkException(SUNDAY, -1, JUNE);
        checkException(SUNDAY, 0, JUNE);
        checkException(SUNDAY, MAX_DAY_OF_MONTH_30 + 1, JUNE);
        checkException(SUNDAY, Integer.MAX_VALUE / 2, JUNE);
        checkException(SUNDAY, Integer.MAX_VALUE - 1, JUNE);
        checkException(SUNDAY, Integer.MAX_VALUE, JUNE);

        //month is september
        //day of New Year is monday
        checkException(MONDAY, Integer.MIN_VALUE, SEPTEMBER);
        checkException(MONDAY, Integer.MIN_VALUE + 1, SEPTEMBER);
        checkException(MONDAY, Integer.MIN_VALUE / 2, SEPTEMBER);
        checkException(MONDAY, -1, SEPTEMBER);
        checkException(MONDAY, 0, SEPTEMBER);
        checkException(MONDAY, MAX_DAY_OF_MONTH_30 + 1, SEPTEMBER);
        checkException(MONDAY, Integer.MAX_VALUE / 2, SEPTEMBER);
        checkException(MONDAY, Integer.MAX_VALUE - 1, SEPTEMBER);
        checkException(MONDAY, Integer.MAX_VALUE, SEPTEMBER);

        //day of New Year is tuesday
        checkException(TUESDAY, Integer.MIN_VALUE, SEPTEMBER);
        checkException(TUESDAY, Integer.MIN_VALUE + 1, SEPTEMBER);
        checkException(TUESDAY, Integer.MIN_VALUE / 2, SEPTEMBER);
        checkException(TUESDAY, -1, SEPTEMBER);
        checkException(TUESDAY, 0, SEPTEMBER);
        checkException(TUESDAY, MAX_DAY_OF_MONTH_30 + 1, SEPTEMBER);
        checkException(TUESDAY, Integer.MAX_VALUE / 2, SEPTEMBER);
        checkException(TUESDAY, Integer.MAX_VALUE - 1, SEPTEMBER);
        checkException(TUESDAY, Integer.MAX_VALUE, SEPTEMBER);

        //day of New Year is wednesday
        checkException(WEDNESDAY, Integer.MIN_VALUE, SEPTEMBER);
        checkException(WEDNESDAY, Integer.MIN_VALUE + 1, SEPTEMBER);
        checkException(WEDNESDAY, Integer.MIN_VALUE / 2, SEPTEMBER);
        checkException(WEDNESDAY, -1, SEPTEMBER);
        checkException(WEDNESDAY, 0, SEPTEMBER);
        checkException(WEDNESDAY, MAX_DAY_OF_MONTH_30 + 1, SEPTEMBER);
        checkException(WEDNESDAY, Integer.MAX_VALUE / 2, SEPTEMBER);
        checkException(WEDNESDAY, Integer.MAX_VALUE - 1, SEPTEMBER);
        checkException(WEDNESDAY, Integer.MAX_VALUE, SEPTEMBER);

        //day of New Year is thursday
        checkException(THURSDAY, Integer.MIN_VALUE, SEPTEMBER);
        checkException(THURSDAY, Integer.MIN_VALUE + 1, SEPTEMBER);
        checkException(THURSDAY, Integer.MIN_VALUE / 2, SEPTEMBER);
        checkException(THURSDAY, -1, SEPTEMBER);
        checkException(THURSDAY, 0, SEPTEMBER);
        checkException(THURSDAY, MAX_DAY_OF_MONTH_30 + 1, SEPTEMBER);
        checkException(THURSDAY, Integer.MAX_VALUE / 2, SEPTEMBER);
        checkException(THURSDAY, Integer.MAX_VALUE - 1, SEPTEMBER);
        checkException(THURSDAY, Integer.MAX_VALUE, SEPTEMBER);

        //day of New Year is friday
        checkException(FRIDAY, Integer.MIN_VALUE, SEPTEMBER);
        checkException(FRIDAY, Integer.MIN_VALUE + 1, SEPTEMBER);
        checkException(FRIDAY, Integer.MIN_VALUE / 2, SEPTEMBER);
        checkException(FRIDAY, -1, SEPTEMBER);
        checkException(FRIDAY, 0, SEPTEMBER);
        checkException(FRIDAY, MAX_DAY_OF_MONTH_30 + 1, SEPTEMBER);
        checkException(FRIDAY, Integer.MAX_VALUE / 2, SEPTEMBER);
        checkException(FRIDAY, Integer.MAX_VALUE - 1, SEPTEMBER);
        checkException(FRIDAY, Integer.MAX_VALUE, SEPTEMBER);

        //day of New Year is saturday
        checkException(SATURDAY, Integer.MIN_VALUE, SEPTEMBER);
        checkException(SATURDAY, Integer.MIN_VALUE + 1, SEPTEMBER);
        checkException(SATURDAY, Integer.MIN_VALUE / 2, SEPTEMBER);
        checkException(SATURDAY, -1, SEPTEMBER);
        checkException(SATURDAY, 0, SEPTEMBER);
        checkException(SATURDAY, MAX_DAY_OF_MONTH_30 + 1, SEPTEMBER);
        checkException(SATURDAY, Integer.MAX_VALUE / 2, SEPTEMBER);
        checkException(SATURDAY, Integer.MAX_VALUE - 1, SEPTEMBER);
        checkException(SATURDAY, Integer.MAX_VALUE, SEPTEMBER);

        //day of New Year is sunday
        checkException(SUNDAY, Integer.MIN_VALUE, SEPTEMBER);
        checkException(SUNDAY, Integer.MIN_VALUE + 1, SEPTEMBER);
        checkException(SUNDAY, Integer.MIN_VALUE / 2, SEPTEMBER);
        checkException(SUNDAY, -1, SEPTEMBER);
        checkException(SUNDAY, 0, SEPTEMBER);
        checkException(SUNDAY, MAX_DAY_OF_MONTH_30 + 1, SEPTEMBER);
        checkException(SUNDAY, Integer.MAX_VALUE / 2, SEPTEMBER);
        checkException(SUNDAY, Integer.MAX_VALUE - 1, SEPTEMBER);
        checkException(SUNDAY, Integer.MAX_VALUE, SEPTEMBER);

        //month is november
        //day of New Year is monday
        checkException(MONDAY, Integer.MIN_VALUE, NOVEMBER);
        checkException(MONDAY, Integer.MIN_VALUE + 1, NOVEMBER);
        checkException(MONDAY, Integer.MIN_VALUE / 2, NOVEMBER);
        checkException(MONDAY, -1, NOVEMBER);
        checkException(MONDAY, 0, NOVEMBER);
        checkException(MONDAY, MAX_DAY_OF_MONTH_30 + 1, NOVEMBER);
        checkException(MONDAY, Integer.MAX_VALUE / 2, NOVEMBER);
        checkException(MONDAY, Integer.MAX_VALUE - 1, NOVEMBER);
        checkException(MONDAY, Integer.MAX_VALUE, NOVEMBER);

        //day of New Year is tuesday
        checkException(TUESDAY, Integer.MIN_VALUE, NOVEMBER);
        checkException(TUESDAY, Integer.MIN_VALUE + 1, NOVEMBER);
        checkException(TUESDAY, Integer.MIN_VALUE / 2, NOVEMBER);
        checkException(TUESDAY, -1, NOVEMBER);
        checkException(TUESDAY, 0, NOVEMBER);
        checkException(TUESDAY, MAX_DAY_OF_MONTH_30 + 1, NOVEMBER);
        checkException(TUESDAY, Integer.MAX_VALUE / 2, NOVEMBER);
        checkException(TUESDAY, Integer.MAX_VALUE - 1, NOVEMBER);
        checkException(TUESDAY, Integer.MAX_VALUE, NOVEMBER);

        //day of New Year is wednesday
        checkException(WEDNESDAY, Integer.MIN_VALUE, NOVEMBER);
        checkException(WEDNESDAY, Integer.MIN_VALUE + 1, NOVEMBER);
        checkException(WEDNESDAY, Integer.MIN_VALUE / 2, NOVEMBER);
        checkException(WEDNESDAY, -1, NOVEMBER);
        checkException(WEDNESDAY, 0, NOVEMBER);
        checkException(WEDNESDAY, MAX_DAY_OF_MONTH_30 + 1, NOVEMBER);
        checkException(WEDNESDAY, Integer.MAX_VALUE / 2, NOVEMBER);
        checkException(WEDNESDAY, Integer.MAX_VALUE - 1, NOVEMBER);
        checkException(WEDNESDAY, Integer.MAX_VALUE, NOVEMBER);

        //day of New Year is thursday
        checkException(THURSDAY, Integer.MIN_VALUE, NOVEMBER);
        checkException(THURSDAY, Integer.MIN_VALUE + 1, NOVEMBER);
        checkException(THURSDAY, Integer.MIN_VALUE / 2, NOVEMBER);
        checkException(THURSDAY, -1, NOVEMBER);
        checkException(THURSDAY, 0, NOVEMBER);
        checkException(THURSDAY, MAX_DAY_OF_MONTH_30 + 1, NOVEMBER);
        checkException(THURSDAY, Integer.MAX_VALUE / 2, NOVEMBER);
        checkException(THURSDAY, Integer.MAX_VALUE - 1, NOVEMBER);
        checkException(THURSDAY, Integer.MAX_VALUE, NOVEMBER);

        //day of New Year is friday
        checkException(FRIDAY, Integer.MIN_VALUE, NOVEMBER);
        checkException(FRIDAY, Integer.MIN_VALUE + 1, NOVEMBER);
        checkException(FRIDAY, Integer.MIN_VALUE / 2, NOVEMBER);
        checkException(FRIDAY, -1, NOVEMBER);
        checkException(FRIDAY, 0, NOVEMBER);
        checkException(FRIDAY, MAX_DAY_OF_MONTH_30 + 1, NOVEMBER);
        checkException(FRIDAY, Integer.MAX_VALUE / 2, NOVEMBER);
        checkException(FRIDAY, Integer.MAX_VALUE - 1, NOVEMBER);
        checkException(FRIDAY, Integer.MAX_VALUE, NOVEMBER);

        //day of New Year is saturday
        checkException(SATURDAY, Integer.MIN_VALUE, NOVEMBER);
        checkException(SATURDAY, Integer.MIN_VALUE + 1, NOVEMBER);
        checkException(SATURDAY, Integer.MIN_VALUE / 2, NOVEMBER);
        checkException(SATURDAY, -1, NOVEMBER);
        checkException(SATURDAY, 0, NOVEMBER);
        checkException(SATURDAY, MAX_DAY_OF_MONTH_30 + 1, NOVEMBER);
        checkException(SATURDAY, Integer.MAX_VALUE / 2, NOVEMBER);
        checkException(SATURDAY, Integer.MAX_VALUE - 1, NOVEMBER);
        checkException(SATURDAY, Integer.MAX_VALUE, NOVEMBER);

        //day of New Year is sunday
        checkException(SUNDAY, Integer.MIN_VALUE, NOVEMBER);
        checkException(SUNDAY, Integer.MIN_VALUE + 1, NOVEMBER);
        checkException(SUNDAY, Integer.MIN_VALUE / 2, NOVEMBER);
        checkException(SUNDAY, -1, NOVEMBER);
        checkException(SUNDAY, 0, NOVEMBER);
        checkException(SUNDAY, MAX_DAY_OF_MONTH_30 + 1, NOVEMBER);
        checkException(SUNDAY, Integer.MAX_VALUE / 2, NOVEMBER);
        checkException(SUNDAY, Integer.MAX_VALUE - 1, NOVEMBER);
        checkException(SUNDAY, Integer.MAX_VALUE, NOVEMBER);

        //non valid day of month (for 31-days months)
        //month is january
        //day of New Year is monday
        checkException(MONDAY, Integer.MIN_VALUE, JANUARY);
        checkException(MONDAY, Integer.MIN_VALUE + 1, JANUARY);
        checkException(MONDAY, Integer.MIN_VALUE / 2, JANUARY);
        checkException(MONDAY, -1, JANUARY);
        checkException(MONDAY, 0, JANUARY);
        checkException(MONDAY, MAX_DAY_OF_MONTH_31 + 1, JANUARY);
        checkException(MONDAY, Integer.MAX_VALUE / 2, JANUARY);
        checkException(MONDAY, Integer.MAX_VALUE - 1, JANUARY);
        checkException(MONDAY, Integer.MAX_VALUE, JANUARY);

        //day of New Year is tuesday
        checkException(TUESDAY, Integer.MIN_VALUE, JANUARY);
        checkException(TUESDAY, Integer.MIN_VALUE + 1, JANUARY);
        checkException(TUESDAY, Integer.MIN_VALUE / 2, JANUARY);
        checkException(TUESDAY, -1, JANUARY);
        checkException(TUESDAY, 0, JANUARY);
        checkException(TUESDAY, MAX_DAY_OF_MONTH_31 + 1, JANUARY);
        checkException(TUESDAY, Integer.MAX_VALUE / 2, JANUARY);
        checkException(TUESDAY, Integer.MAX_VALUE - 1, JANUARY);
        checkException(TUESDAY, Integer.MAX_VALUE, JANUARY);

        //day of New Year is wednesday
        checkException(WEDNESDAY, Integer.MIN_VALUE, JANUARY);
        checkException(WEDNESDAY, Integer.MIN_VALUE + 1, JANUARY);
        checkException(WEDNESDAY, Integer.MIN_VALUE / 2, JANUARY);
        checkException(WEDNESDAY, -1, JANUARY);
        checkException(WEDNESDAY, 0, JANUARY);
        checkException(WEDNESDAY, MAX_DAY_OF_MONTH_31 + 1, JANUARY);
        checkException(WEDNESDAY, Integer.MAX_VALUE / 2, JANUARY);
        checkException(WEDNESDAY, Integer.MAX_VALUE - 1, JANUARY);
        checkException(WEDNESDAY, Integer.MAX_VALUE, JANUARY);

        //day of New Year is thursday
        checkException(THURSDAY, Integer.MIN_VALUE, JANUARY);
        checkException(THURSDAY, Integer.MIN_VALUE + 1, JANUARY);
        checkException(THURSDAY, Integer.MIN_VALUE / 2, JANUARY);
        checkException(THURSDAY, -1, JANUARY);
        checkException(THURSDAY, 0, JANUARY);
        checkException(THURSDAY, MAX_DAY_OF_MONTH_31 + 1, JANUARY);
        checkException(THURSDAY, Integer.MAX_VALUE / 2, JANUARY);
        checkException(THURSDAY, Integer.MAX_VALUE - 1, JANUARY);
        checkException(THURSDAY, Integer.MAX_VALUE, JANUARY);

        //day of New Year is friday
        checkException(FRIDAY, Integer.MIN_VALUE, JANUARY);
        checkException(FRIDAY, Integer.MIN_VALUE + 1, JANUARY);
        checkException(FRIDAY, Integer.MIN_VALUE / 2, JANUARY);
        checkException(FRIDAY, -1, JANUARY);
        checkException(FRIDAY, 0, JANUARY);
        checkException(FRIDAY, MAX_DAY_OF_MONTH_31 + 1, JANUARY);
        checkException(FRIDAY, Integer.MAX_VALUE / 2, JANUARY);
        checkException(FRIDAY, Integer.MAX_VALUE - 1, JANUARY);
        checkException(FRIDAY, Integer.MAX_VALUE, JANUARY);

        //day of New Year is saturday
        checkException(SATURDAY, Integer.MIN_VALUE, JANUARY);
        checkException(SATURDAY, Integer.MIN_VALUE + 1, JANUARY);
        checkException(SATURDAY, Integer.MIN_VALUE / 2, JANUARY);
        checkException(SATURDAY, -1, JANUARY);
        checkException(SATURDAY, 0, JANUARY);
        checkException(SATURDAY, MAX_DAY_OF_MONTH_31 + 1, JANUARY);
        checkException(SATURDAY, Integer.MAX_VALUE / 2, JANUARY);
        checkException(SATURDAY, Integer.MAX_VALUE - 1, JANUARY);
        checkException(SATURDAY, Integer.MAX_VALUE, JANUARY);

        //day of New Year is sunday
        checkException(SUNDAY, Integer.MIN_VALUE, JANUARY);
        checkException(SUNDAY, Integer.MIN_VALUE + 1, JANUARY);
        checkException(SUNDAY, Integer.MIN_VALUE / 2, JANUARY);
        checkException(SUNDAY, -1, JANUARY);
        checkException(SUNDAY, 0, JANUARY);
        checkException(SUNDAY, MAX_DAY_OF_MONTH_31 + 1, JANUARY);
        checkException(SUNDAY, Integer.MAX_VALUE / 2, JANUARY);
        checkException(SUNDAY, Integer.MAX_VALUE - 1, JANUARY);
        checkException(SUNDAY, Integer.MAX_VALUE, JANUARY);

        //month is march
        //day of New Year is monday
        checkException(MONDAY, Integer.MIN_VALUE, MARCH);
        checkException(MONDAY, Integer.MIN_VALUE + 1, MARCH);
        checkException(MONDAY, Integer.MIN_VALUE / 2, MARCH);
        checkException(MONDAY, -1, MARCH);
        checkException(MONDAY, 0, MARCH);
        checkException(MONDAY, MAX_DAY_OF_MONTH_31 + 1, MARCH);
        checkException(MONDAY, Integer.MAX_VALUE / 2, MARCH);
        checkException(MONDAY, Integer.MAX_VALUE - 1, MARCH);
        checkException(MONDAY, Integer.MAX_VALUE, MARCH);

        //day of New Year is tuesday
        checkException(TUESDAY, Integer.MIN_VALUE, MARCH);
        checkException(TUESDAY, Integer.MIN_VALUE + 1, MARCH);
        checkException(TUESDAY, Integer.MIN_VALUE / 2, MARCH);
        checkException(TUESDAY, -1, MARCH);
        checkException(TUESDAY, 0, MARCH);
        checkException(TUESDAY, MAX_DAY_OF_MONTH_31 + 1, MARCH);
        checkException(TUESDAY, Integer.MAX_VALUE / 2, MARCH);
        checkException(TUESDAY, Integer.MAX_VALUE - 1, MARCH);
        checkException(TUESDAY, Integer.MAX_VALUE, MARCH);

        //day of New Year is wednesday
        checkException(WEDNESDAY, Integer.MIN_VALUE, MARCH);
        checkException(WEDNESDAY, Integer.MIN_VALUE + 1, MARCH);
        checkException(WEDNESDAY, Integer.MIN_VALUE / 2, MARCH);
        checkException(WEDNESDAY, -1, MARCH);
        checkException(WEDNESDAY, 0, MARCH);
        checkException(WEDNESDAY, MAX_DAY_OF_MONTH_31 + 1, MARCH);
        checkException(WEDNESDAY, Integer.MAX_VALUE / 2, MARCH);
        checkException(WEDNESDAY, Integer.MAX_VALUE - 1, MARCH);
        checkException(WEDNESDAY, Integer.MAX_VALUE, MARCH);

        //day of New Year is thursday
        checkException(THURSDAY, Integer.MIN_VALUE, MARCH);
        checkException(THURSDAY, Integer.MIN_VALUE + 1, MARCH);
        checkException(THURSDAY, Integer.MIN_VALUE / 2, MARCH);
        checkException(THURSDAY, -1, MARCH);
        checkException(THURSDAY, 0, MARCH);
        checkException(THURSDAY, MAX_DAY_OF_MONTH_31 + 1, MARCH);
        checkException(THURSDAY, Integer.MAX_VALUE / 2, MARCH);
        checkException(THURSDAY, Integer.MAX_VALUE - 1, MARCH);
        checkException(THURSDAY, Integer.MAX_VALUE, MARCH);

        //day of New Year is friday
        checkException(FRIDAY, Integer.MIN_VALUE, MARCH);
        checkException(FRIDAY, Integer.MIN_VALUE + 1, MARCH);
        checkException(FRIDAY, Integer.MIN_VALUE / 2, MARCH);
        checkException(FRIDAY, -1, MARCH);
        checkException(FRIDAY, 0, MARCH);
        checkException(FRIDAY, MAX_DAY_OF_MONTH_31 + 1, MARCH);
        checkException(FRIDAY, Integer.MAX_VALUE / 2, MARCH);
        checkException(FRIDAY, Integer.MAX_VALUE - 1, MARCH);
        checkException(FRIDAY, Integer.MAX_VALUE, MARCH);

        //day of New Year is saturday
        checkException(SATURDAY, Integer.MIN_VALUE, MARCH);
        checkException(SATURDAY, Integer.MIN_VALUE + 1, MARCH);
        checkException(SATURDAY, Integer.MIN_VALUE / 2, MARCH);
        checkException(SATURDAY, -1, MARCH);
        checkException(SATURDAY, 0, MARCH);
        checkException(SATURDAY, MAX_DAY_OF_MONTH_31 + 1, MARCH);
        checkException(SATURDAY, Integer.MAX_VALUE / 2, MARCH);
        checkException(SATURDAY, Integer.MAX_VALUE - 1, MARCH);
        checkException(SATURDAY, Integer.MAX_VALUE, MARCH);

        //day of New Year is sunday
        checkException(SUNDAY, Integer.MIN_VALUE, MARCH);
        checkException(SUNDAY, Integer.MIN_VALUE + 1, MARCH);
        checkException(SUNDAY, Integer.MIN_VALUE / 2, MARCH);
        checkException(SUNDAY, -1, MARCH);
        checkException(SUNDAY, 0, MARCH);
        checkException(SUNDAY, MAX_DAY_OF_MONTH_31 + 1, MARCH);
        checkException(SUNDAY, Integer.MAX_VALUE / 2, MARCH);
        checkException(SUNDAY, Integer.MAX_VALUE - 1, MARCH);
        checkException(SUNDAY, Integer.MAX_VALUE, MARCH);

        //month is may
        //day of New Year is monday
        checkException(MONDAY, Integer.MIN_VALUE, MAY);
        checkException(MONDAY, Integer.MIN_VALUE + 1, MAY);
        checkException(MONDAY, Integer.MIN_VALUE / 2, MAY);
        checkException(MONDAY, -1, MAY);
        checkException(MONDAY, 0, MAY);
        checkException(MONDAY, MAX_DAY_OF_MONTH_31 + 1, MAY);
        checkException(MONDAY, Integer.MAX_VALUE / 2, MAY);
        checkException(MONDAY, Integer.MAX_VALUE - 1, MAY);
        checkException(MONDAY, Integer.MAX_VALUE, MAY);

        //day of New Year is tuesday
        checkException(TUESDAY, Integer.MIN_VALUE, MAY);
        checkException(TUESDAY, Integer.MIN_VALUE + 1, MAY);
        checkException(TUESDAY, Integer.MIN_VALUE / 2, MAY);
        checkException(TUESDAY, -1, MAY);
        checkException(TUESDAY, 0, MAY);
        checkException(TUESDAY, MAX_DAY_OF_MONTH_31 + 1, MAY);
        checkException(TUESDAY, Integer.MAX_VALUE / 2, MAY);
        checkException(TUESDAY, Integer.MAX_VALUE - 1, MAY);
        checkException(TUESDAY, Integer.MAX_VALUE, MAY);

        //day of New Year is wednesday
        checkException(WEDNESDAY, Integer.MIN_VALUE, MAY);
        checkException(WEDNESDAY, Integer.MIN_VALUE + 1, MAY);
        checkException(WEDNESDAY, Integer.MIN_VALUE / 2, MAY);
        checkException(WEDNESDAY, -1, MAY);
        checkException(WEDNESDAY, 0, MAY);
        checkException(WEDNESDAY, MAX_DAY_OF_MONTH_31 + 1, MAY);
        checkException(WEDNESDAY, Integer.MAX_VALUE / 2, MAY);
        checkException(WEDNESDAY, Integer.MAX_VALUE - 1, MAY);
        checkException(WEDNESDAY, Integer.MAX_VALUE, MAY);

        //day of New Year is thursday
        checkException(THURSDAY, Integer.MIN_VALUE, MAY);
        checkException(THURSDAY, Integer.MIN_VALUE + 1, MAY);
        checkException(THURSDAY, Integer.MIN_VALUE / 2, MAY);
        checkException(THURSDAY, -1, MAY);
        checkException(THURSDAY, 0, MAY);
        checkException(THURSDAY, MAX_DAY_OF_MONTH_31 + 1, MAY);
        checkException(THURSDAY, Integer.MAX_VALUE / 2, MAY);
        checkException(THURSDAY, Integer.MAX_VALUE - 1, MAY);
        checkException(THURSDAY, Integer.MAX_VALUE, MAY);

        //day of New Year is friday
        checkException(FRIDAY, Integer.MIN_VALUE, MAY);
        checkException(FRIDAY, Integer.MIN_VALUE + 1, MAY);
        checkException(FRIDAY, Integer.MIN_VALUE / 2, MAY);
        checkException(FRIDAY, -1, MAY);
        checkException(FRIDAY, 0, MAY);
        checkException(FRIDAY, MAX_DAY_OF_MONTH_31 + 1, MAY);
        checkException(FRIDAY, Integer.MAX_VALUE / 2, MAY);
        checkException(FRIDAY, Integer.MAX_VALUE - 1, MAY);
        checkException(FRIDAY, Integer.MAX_VALUE, MAY);

        //day of New Year is saturday
        checkException(SATURDAY, Integer.MIN_VALUE, MAY);
        checkException(SATURDAY, Integer.MIN_VALUE + 1, MAY);
        checkException(SATURDAY, Integer.MIN_VALUE / 2, MAY);
        checkException(SATURDAY, -1, MAY);
        checkException(SATURDAY, 0, MAY);
        checkException(SATURDAY, MAX_DAY_OF_MONTH_31 + 1, MAY);
        checkException(SATURDAY, Integer.MAX_VALUE / 2, MAY);
        checkException(SATURDAY, Integer.MAX_VALUE - 1, MAY);
        checkException(SATURDAY, Integer.MAX_VALUE, MAY);

        //day of New Year is sunday
        checkException(SUNDAY, Integer.MIN_VALUE, MAY);
        checkException(SUNDAY, Integer.MIN_VALUE + 1, MAY);
        checkException(SUNDAY, Integer.MIN_VALUE / 2, MAY);
        checkException(SUNDAY, -1, MAY);
        checkException(SUNDAY, 0, MAY);
        checkException(SUNDAY, MAX_DAY_OF_MONTH_31 + 1, MAY);
        checkException(SUNDAY, Integer.MAX_VALUE / 2, MAY);
        checkException(SUNDAY, Integer.MAX_VALUE - 1, MAY);
        checkException(SUNDAY, Integer.MAX_VALUE, MAY);

        //month is july
        //day of New Year is monday
        checkException(MONDAY, Integer.MIN_VALUE, JULY);
        checkException(MONDAY, Integer.MIN_VALUE + 1, JULY);
        checkException(MONDAY, Integer.MIN_VALUE / 2, JULY);
        checkException(MONDAY, -1, JULY);
        checkException(MONDAY, 0, JULY);
        checkException(MONDAY, MAX_DAY_OF_MONTH_31 + 1, JULY);
        checkException(MONDAY, Integer.MAX_VALUE / 2, JULY);
        checkException(MONDAY, Integer.MAX_VALUE - 1, JULY);
        checkException(MONDAY, Integer.MAX_VALUE, JULY);

        //day of New Year is tuesday
        checkException(TUESDAY, Integer.MIN_VALUE, JULY);
        checkException(TUESDAY, Integer.MIN_VALUE + 1, JULY);
        checkException(TUESDAY, Integer.MIN_VALUE / 2, JULY);
        checkException(TUESDAY, -1, JULY);
        checkException(TUESDAY, 0, JULY);
        checkException(TUESDAY, MAX_DAY_OF_MONTH_31 + 1, JULY);
        checkException(TUESDAY, Integer.MAX_VALUE / 2, JULY);
        checkException(TUESDAY, Integer.MAX_VALUE - 1, JULY);
        checkException(TUESDAY, Integer.MAX_VALUE, JULY);

        //day of New Year is wednesday
        checkException(WEDNESDAY, Integer.MIN_VALUE, JULY);
        checkException(WEDNESDAY, Integer.MIN_VALUE + 1, JULY);
        checkException(WEDNESDAY, Integer.MIN_VALUE / 2, JULY);
        checkException(WEDNESDAY, -1, JULY);
        checkException(WEDNESDAY, 0, JULY);
        checkException(WEDNESDAY, MAX_DAY_OF_MONTH_31 + 1, JULY);
        checkException(WEDNESDAY, Integer.MAX_VALUE / 2, JULY);
        checkException(WEDNESDAY, Integer.MAX_VALUE - 1, JULY);
        checkException(WEDNESDAY, Integer.MAX_VALUE, JULY);

        //day of New Year is thursday
        checkException(THURSDAY, Integer.MIN_VALUE, JULY);
        checkException(THURSDAY, Integer.MIN_VALUE + 1, JULY);
        checkException(THURSDAY, Integer.MIN_VALUE / 2, JULY);
        checkException(THURSDAY, -1, JULY);
        checkException(THURSDAY, 0, JULY);
        checkException(THURSDAY, MAX_DAY_OF_MONTH_31 + 1, JULY);
        checkException(THURSDAY, Integer.MAX_VALUE / 2, JULY);
        checkException(THURSDAY, Integer.MAX_VALUE - 1, JULY);
        checkException(THURSDAY, Integer.MAX_VALUE, JULY);

        //day of New Year is friday
        checkException(FRIDAY, Integer.MIN_VALUE, JULY);
        checkException(FRIDAY, Integer.MIN_VALUE + 1, JULY);
        checkException(FRIDAY, Integer.MIN_VALUE / 2, JULY);
        checkException(FRIDAY, -1, JULY);
        checkException(FRIDAY, 0, JULY);
        checkException(FRIDAY, MAX_DAY_OF_MONTH_31 + 1, JULY);
        checkException(FRIDAY, Integer.MAX_VALUE / 2, JULY);
        checkException(FRIDAY, Integer.MAX_VALUE - 1, JULY);
        checkException(FRIDAY, Integer.MAX_VALUE, JULY);

        //day of New Year is saturday
        checkException(SATURDAY, Integer.MIN_VALUE, JULY);
        checkException(SATURDAY, Integer.MIN_VALUE + 1, JULY);
        checkException(SATURDAY, Integer.MIN_VALUE / 2, JULY);
        checkException(SATURDAY, -1, JULY);
        checkException(SATURDAY, 0, JULY);
        checkException(SATURDAY, MAX_DAY_OF_MONTH_31 + 1, JULY);
        checkException(SATURDAY, Integer.MAX_VALUE / 2, JULY);
        checkException(SATURDAY, Integer.MAX_VALUE - 1, JULY);
        checkException(SATURDAY, Integer.MAX_VALUE, JULY);

        //day of New Year is sunday
        checkException(SUNDAY, Integer.MIN_VALUE, JULY);
        checkException(SUNDAY, Integer.MIN_VALUE + 1, JULY);
        checkException(SUNDAY, Integer.MIN_VALUE / 2, JULY);
        checkException(SUNDAY, -1, JULY);
        checkException(SUNDAY, 0, JULY);
        checkException(SUNDAY, MAX_DAY_OF_MONTH_31 + 1, JULY);
        checkException(SUNDAY, Integer.MAX_VALUE / 2, JULY);
        checkException(SUNDAY, Integer.MAX_VALUE - 1, JULY);
        checkException(SUNDAY, Integer.MAX_VALUE, JULY);

        //month is august
        //day of New Year is monday
        checkException(MONDAY, Integer.MIN_VALUE, AUGUST);
        checkException(MONDAY, Integer.MIN_VALUE + 1, AUGUST);
        checkException(MONDAY, Integer.MIN_VALUE / 2, AUGUST);
        checkException(MONDAY, -1, AUGUST);
        checkException(MONDAY, 0, AUGUST);
        checkException(MONDAY, MAX_DAY_OF_MONTH_31 + 1, AUGUST);
        checkException(MONDAY, Integer.MAX_VALUE / 2, AUGUST);
        checkException(MONDAY, Integer.MAX_VALUE - 1, AUGUST);
        checkException(MONDAY, Integer.MAX_VALUE, AUGUST);

        //day of New Year is tuesday
        checkException(TUESDAY, Integer.MIN_VALUE, AUGUST);
        checkException(TUESDAY, Integer.MIN_VALUE + 1, AUGUST);
        checkException(TUESDAY, Integer.MIN_VALUE / 2, AUGUST);
        checkException(TUESDAY, -1, AUGUST);
        checkException(TUESDAY, 0, AUGUST);
        checkException(TUESDAY, MAX_DAY_OF_MONTH_31 + 1, AUGUST);
        checkException(TUESDAY, Integer.MAX_VALUE / 2, AUGUST);
        checkException(TUESDAY, Integer.MAX_VALUE - 1, AUGUST);
        checkException(TUESDAY, Integer.MAX_VALUE, AUGUST);

        //day of New Year is wednesday
        checkException(WEDNESDAY, Integer.MIN_VALUE, AUGUST);
        checkException(WEDNESDAY, Integer.MIN_VALUE + 1, AUGUST);
        checkException(WEDNESDAY, Integer.MIN_VALUE / 2, AUGUST);
        checkException(WEDNESDAY, -1, AUGUST);
        checkException(WEDNESDAY, 0, AUGUST);
        checkException(WEDNESDAY, MAX_DAY_OF_MONTH_31 + 1, AUGUST);
        checkException(WEDNESDAY, Integer.MAX_VALUE / 2, AUGUST);
        checkException(WEDNESDAY, Integer.MAX_VALUE - 1, AUGUST);
        checkException(WEDNESDAY, Integer.MAX_VALUE, AUGUST);

        //day of New Year is thursday
        checkException(THURSDAY, Integer.MIN_VALUE, AUGUST);
        checkException(THURSDAY, Integer.MIN_VALUE + 1, AUGUST);
        checkException(THURSDAY, Integer.MIN_VALUE / 2, AUGUST);
        checkException(THURSDAY, -1, AUGUST);
        checkException(THURSDAY, 0, AUGUST);
        checkException(THURSDAY, MAX_DAY_OF_MONTH_31 + 1, AUGUST);
        checkException(THURSDAY, Integer.MAX_VALUE / 2, AUGUST);
        checkException(THURSDAY, Integer.MAX_VALUE - 1, AUGUST);
        checkException(THURSDAY, Integer.MAX_VALUE, AUGUST);

        //day of New Year is friday
        checkException(FRIDAY, Integer.MIN_VALUE, AUGUST);
        checkException(FRIDAY, Integer.MIN_VALUE + 1, AUGUST);
        checkException(FRIDAY, Integer.MIN_VALUE / 2, AUGUST);
        checkException(FRIDAY, -1, AUGUST);
        checkException(FRIDAY, 0, AUGUST);
        checkException(FRIDAY, MAX_DAY_OF_MONTH_31 + 1, AUGUST);
        checkException(FRIDAY, Integer.MAX_VALUE / 2, AUGUST);
        checkException(FRIDAY, Integer.MAX_VALUE - 1, AUGUST);
        checkException(FRIDAY, Integer.MAX_VALUE, AUGUST);

        //day of New Year is saturday
        checkException(SATURDAY, Integer.MIN_VALUE, AUGUST);
        checkException(SATURDAY, Integer.MIN_VALUE + 1, AUGUST);
        checkException(SATURDAY, Integer.MIN_VALUE / 2, AUGUST);
        checkException(SATURDAY, -1, AUGUST);
        checkException(SATURDAY, 0, AUGUST);
        checkException(SATURDAY, MAX_DAY_OF_MONTH_31 + 1, AUGUST);
        checkException(SATURDAY, Integer.MAX_VALUE / 2, AUGUST);
        checkException(SATURDAY, Integer.MAX_VALUE - 1, AUGUST);
        checkException(SATURDAY, Integer.MAX_VALUE, AUGUST);

        //day of New Year is sunday
        checkException(SUNDAY, Integer.MIN_VALUE, AUGUST);
        checkException(SUNDAY, Integer.MIN_VALUE + 1, AUGUST);
        checkException(SUNDAY, Integer.MIN_VALUE / 2, AUGUST);
        checkException(SUNDAY, -1, AUGUST);
        checkException(SUNDAY, 0, AUGUST);
        checkException(SUNDAY, MAX_DAY_OF_MONTH_31 + 1, AUGUST);
        checkException(SUNDAY, Integer.MAX_VALUE / 2, AUGUST);
        checkException(SUNDAY, Integer.MAX_VALUE - 1, AUGUST);
        checkException(SUNDAY, Integer.MAX_VALUE, AUGUST);

        //month is october
        //day of New Year is monday
        checkException(MONDAY, Integer.MIN_VALUE, OCTOBER);
        checkException(MONDAY, Integer.MIN_VALUE + 1, OCTOBER);
        checkException(MONDAY, Integer.MIN_VALUE / 2, OCTOBER);
        checkException(MONDAY, -1, OCTOBER);
        checkException(MONDAY, 0, OCTOBER);
        checkException(MONDAY, MAX_DAY_OF_MONTH_31 + 1, OCTOBER);
        checkException(MONDAY, Integer.MAX_VALUE / 2, OCTOBER);
        checkException(MONDAY, Integer.MAX_VALUE - 1, OCTOBER);
        checkException(MONDAY, Integer.MAX_VALUE, OCTOBER);

        //day of New Year is tuesday
        checkException(TUESDAY, Integer.MIN_VALUE, OCTOBER);
        checkException(TUESDAY, Integer.MIN_VALUE + 1, OCTOBER);
        checkException(TUESDAY, Integer.MIN_VALUE / 2, OCTOBER);
        checkException(TUESDAY, -1, OCTOBER);
        checkException(TUESDAY, 0, OCTOBER);
        checkException(TUESDAY, MAX_DAY_OF_MONTH_31 + 1, OCTOBER);
        checkException(TUESDAY, Integer.MAX_VALUE / 2, OCTOBER);
        checkException(TUESDAY, Integer.MAX_VALUE - 1, OCTOBER);
        checkException(TUESDAY, Integer.MAX_VALUE, OCTOBER);

        //day of New Year is wednesday
        checkException(WEDNESDAY, Integer.MIN_VALUE, OCTOBER);
        checkException(WEDNESDAY, Integer.MIN_VALUE + 1, OCTOBER);
        checkException(WEDNESDAY, Integer.MIN_VALUE / 2, OCTOBER);
        checkException(WEDNESDAY, -1, OCTOBER);
        checkException(WEDNESDAY, 0, OCTOBER);
        checkException(WEDNESDAY, MAX_DAY_OF_MONTH_31 + 1, OCTOBER);
        checkException(WEDNESDAY, Integer.MAX_VALUE / 2, OCTOBER);
        checkException(WEDNESDAY, Integer.MAX_VALUE - 1, OCTOBER);
        checkException(WEDNESDAY, Integer.MAX_VALUE, OCTOBER);

        //day of New Year is thursday
        checkException(THURSDAY, Integer.MIN_VALUE, OCTOBER);
        checkException(THURSDAY, Integer.MIN_VALUE + 1, OCTOBER);
        checkException(THURSDAY, Integer.MIN_VALUE / 2, OCTOBER);
        checkException(THURSDAY, -1, OCTOBER);
        checkException(THURSDAY, 0, OCTOBER);
        checkException(THURSDAY, MAX_DAY_OF_MONTH_31 + 1, OCTOBER);
        checkException(THURSDAY, Integer.MAX_VALUE / 2, OCTOBER);
        checkException(THURSDAY, Integer.MAX_VALUE - 1, OCTOBER);
        checkException(THURSDAY, Integer.MAX_VALUE, OCTOBER);

        //day of New Year is friday
        checkException(FRIDAY, Integer.MIN_VALUE, OCTOBER);
        checkException(FRIDAY, Integer.MIN_VALUE + 1, OCTOBER);
        checkException(FRIDAY, Integer.MIN_VALUE / 2, OCTOBER);
        checkException(FRIDAY, -1, OCTOBER);
        checkException(FRIDAY, 0, OCTOBER);
        checkException(FRIDAY, MAX_DAY_OF_MONTH_31 + 1, OCTOBER);
        checkException(FRIDAY, Integer.MAX_VALUE / 2, OCTOBER);
        checkException(FRIDAY, Integer.MAX_VALUE - 1, OCTOBER);
        checkException(FRIDAY, Integer.MAX_VALUE, OCTOBER);

        //day of New Year is saturday
        checkException(SATURDAY, Integer.MIN_VALUE, OCTOBER);
        checkException(SATURDAY, Integer.MIN_VALUE + 1, OCTOBER);
        checkException(SATURDAY, Integer.MIN_VALUE / 2, OCTOBER);
        checkException(SATURDAY, -1, OCTOBER);
        checkException(SATURDAY, 0, OCTOBER);
        checkException(SATURDAY, MAX_DAY_OF_MONTH_31 + 1, OCTOBER);
        checkException(SATURDAY, Integer.MAX_VALUE / 2, OCTOBER);
        checkException(SATURDAY, Integer.MAX_VALUE - 1, OCTOBER);
        checkException(SATURDAY, Integer.MAX_VALUE, OCTOBER);

        //day of New Year is sunday
        checkException(SUNDAY, Integer.MIN_VALUE, OCTOBER);
        checkException(SUNDAY, Integer.MIN_VALUE + 1, OCTOBER);
        checkException(SUNDAY, Integer.MIN_VALUE / 2, OCTOBER);
        checkException(SUNDAY, -1, OCTOBER);
        checkException(SUNDAY, 0, OCTOBER);
        checkException(SUNDAY, MAX_DAY_OF_MONTH_31 + 1, OCTOBER);
        checkException(SUNDAY, Integer.MAX_VALUE / 2, OCTOBER);
        checkException(SUNDAY, Integer.MAX_VALUE - 1, OCTOBER);
        checkException(SUNDAY, Integer.MAX_VALUE, OCTOBER);

        //month is december
        //day of New Year is monday
        checkException(MONDAY, Integer.MIN_VALUE, DECEMBER);
        checkException(MONDAY, Integer.MIN_VALUE + 1, DECEMBER);
        checkException(MONDAY, Integer.MIN_VALUE / 2, DECEMBER);
        checkException(MONDAY, -1, DECEMBER);
        checkException(MONDAY, 0, DECEMBER);
        checkException(MONDAY, MAX_DAY_OF_MONTH_31 + 1, DECEMBER);
        checkException(MONDAY, Integer.MAX_VALUE / 2, DECEMBER);
        checkException(MONDAY, Integer.MAX_VALUE - 1, DECEMBER);
        checkException(MONDAY, Integer.MAX_VALUE, DECEMBER);

        //day of New Year is tuesday
        checkException(TUESDAY, Integer.MIN_VALUE, DECEMBER);
        checkException(TUESDAY, Integer.MIN_VALUE + 1, DECEMBER);
        checkException(TUESDAY, Integer.MIN_VALUE / 2, DECEMBER);
        checkException(TUESDAY, -1, DECEMBER);
        checkException(TUESDAY, 0, DECEMBER);
        checkException(TUESDAY, MAX_DAY_OF_MONTH_31 + 1, DECEMBER);
        checkException(TUESDAY, Integer.MAX_VALUE / 2, DECEMBER);
        checkException(TUESDAY, Integer.MAX_VALUE - 1, DECEMBER);
        checkException(TUESDAY, Integer.MAX_VALUE, DECEMBER);

        //day of New Year is wednesday
        checkException(WEDNESDAY, Integer.MIN_VALUE, DECEMBER);
        checkException(WEDNESDAY, Integer.MIN_VALUE + 1, DECEMBER);
        checkException(WEDNESDAY, Integer.MIN_VALUE / 2, DECEMBER);
        checkException(WEDNESDAY, -1, DECEMBER);
        checkException(WEDNESDAY, 0, DECEMBER);
        checkException(WEDNESDAY, MAX_DAY_OF_MONTH_31 + 1, DECEMBER);
        checkException(WEDNESDAY, Integer.MAX_VALUE / 2, DECEMBER);
        checkException(WEDNESDAY, Integer.MAX_VALUE - 1, DECEMBER);
        checkException(WEDNESDAY, Integer.MAX_VALUE, DECEMBER);

        //day of New Year is thursday
        checkException(THURSDAY, Integer.MIN_VALUE, DECEMBER);
        checkException(THURSDAY, Integer.MIN_VALUE + 1, DECEMBER);
        checkException(THURSDAY, Integer.MIN_VALUE / 2, DECEMBER);
        checkException(THURSDAY, -1, DECEMBER);
        checkException(THURSDAY, 0, DECEMBER);
        checkException(THURSDAY, MAX_DAY_OF_MONTH_31 + 1, DECEMBER);
        checkException(THURSDAY, Integer.MAX_VALUE / 2, DECEMBER);
        checkException(THURSDAY, Integer.MAX_VALUE - 1, DECEMBER);
        checkException(THURSDAY, Integer.MAX_VALUE, DECEMBER);

        //day of New Year is friday
        checkException(FRIDAY, Integer.MIN_VALUE, DECEMBER);
        checkException(FRIDAY, Integer.MIN_VALUE + 1, DECEMBER);
        checkException(FRIDAY, Integer.MIN_VALUE / 2, DECEMBER);
        checkException(FRIDAY, -1, DECEMBER);
        checkException(FRIDAY, 0, DECEMBER);
        checkException(FRIDAY, MAX_DAY_OF_MONTH_31 + 1, DECEMBER);
        checkException(FRIDAY, Integer.MAX_VALUE / 2, DECEMBER);
        checkException(FRIDAY, Integer.MAX_VALUE - 1, DECEMBER);
        checkException(FRIDAY, Integer.MAX_VALUE, DECEMBER);

        //day of New Year is saturday
        checkException(SATURDAY, Integer.MIN_VALUE, DECEMBER);
        checkException(SATURDAY, Integer.MIN_VALUE + 1, DECEMBER);
        checkException(SATURDAY, Integer.MIN_VALUE / 2, DECEMBER);
        checkException(SATURDAY, -1, DECEMBER);
        checkException(SATURDAY, 0, DECEMBER);
        checkException(SATURDAY, MAX_DAY_OF_MONTH_31 + 1, DECEMBER);
        checkException(SATURDAY, Integer.MAX_VALUE / 2, DECEMBER);
        checkException(SATURDAY, Integer.MAX_VALUE - 1, DECEMBER);
        checkException(SATURDAY, Integer.MAX_VALUE, DECEMBER);

        //day of New Year is sunday
        checkException(SUNDAY, Integer.MIN_VALUE, DECEMBER);
        checkException(SUNDAY, Integer.MIN_VALUE + 1, DECEMBER);
        checkException(SUNDAY, Integer.MIN_VALUE / 2, DECEMBER);
        checkException(SUNDAY, -1, DECEMBER);
        checkException(SUNDAY, 0, DECEMBER);
        checkException(SUNDAY, MAX_DAY_OF_MONTH_31 + 1, DECEMBER);
        checkException(SUNDAY, Integer.MAX_VALUE / 2, DECEMBER);
        checkException(SUNDAY, Integer.MAX_VALUE - 1, DECEMBER);
        checkException(SUNDAY, Integer.MAX_VALUE, DECEMBER);

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
    void check(DaysOfWeek dayOfNewYear, int dayToFind, Months monthToFind, String expected) {
        //Task 5 by itself
        String actual = Task5.defineDayOfWeek(dayOfNewYear, dayToFind, monthToFind);
        assertEquals(expected, actual);

        //Task 5 in main
        String input = "5" + L_S + dayOfNewYear + L_S + dayToFind + L_S + monthToFind;
        String expectedMain =
                "Input number of task from 1 to 5." + L_S +
                        "Task 5: day of week." + L_S +
                        "Input day of New Year, day to find, month to find." + L_S +
                        expected + L_S;

        ByteArrayOutputStream output = setInAndOut(input);
        Main.main();
        assertEquals(expectedMain, output.toString());
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
    void checkException(DaysOfWeek dayOfNewYear, int dayToFind, Months monthToFind) {
        //Task 5 by itself
        try {
            Task5.defineDayOfWeek(dayOfNewYear, dayToFind, monthToFind);
            fail("Exception was not thrown");
        } catch (IncorrectArgumentException e) {
            //correct behavior
        }

        //Task 5 in main
        try {
            String input = "5" + L_S + dayOfNewYear + L_S + dayToFind + L_S + monthToFind;
            setInAndOut(input);
            Main.main();
            fail("Exception was not thrown.");
        } catch (IncorrectArgumentException e) {
            //correct behavior
        }
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
