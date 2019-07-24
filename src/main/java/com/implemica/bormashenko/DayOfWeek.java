package com.implemica.bormashenko;

import org.apache.commons.lang3.StringUtils;

/**
 * This utility class defines day of week by months number
 * and the number of this day in the month. Day of week of
 * New Year should be specified.
 *
 * @author Mykhailo Bormashenko
 * @since 1.8
 */
public class DayOfWeek {

    /**
     * Number of days in week.
     */
    private static final int DAYS_IN_WEEK = 7;

    /**
     * Defines day of week by date (day and month) and
     * day of week of New Year. Only for non-leap year.
     *
     * @param dayOfNewYear day of week (enum {@code DaysOfWeek}) from which the year started.
     * @param dayToFind    day of the date to find. Must be validated before using.
     * @param monthToFind  month (enum {@code Months}) of date to find.
     * @return day of week (enum {@code DaysOfWeek}) as a capitalized string.
     * @throws IncorrectArgumentException if validation for day to find is not passed.
     * @see DaysOfWeek
     * @see Months
     */
    public static String defineDayOfWeek(DaysOfWeek dayOfNewYear, int dayToFind, Months monthToFind) {
        if (!isValidDate(dayToFind, monthToFind)) {
            throw new IncorrectArgumentException("Wrong date for " + dayToFind + " day of " + monthToFind + " month");
        }

        int numberOfDayOfNewYear = dayOfNewYear.ordinal();
        int searchDay = daysPassedFromNewYear(monthToFind) + numberOfDayOfNewYear + dayToFind;
        searchDay %= DAYS_IN_WEEK;

        if (searchDay == 0) {
            searchDay = DAYS_IN_WEEK;
        }

        String day = DaysOfWeek.values()[searchDay - 1].name();
        return StringUtils.capitalize(day.toLowerCase());
    }

    /**
     * Validation for date (day and month). Number of day should be
     * positive and not more than number of days in the month.
     *
     * @param dayToFind   day of the date to validate.
     * @param monthToFind month (enum {@code Months}) of date to validate.
     * @return true if validation passed or false otherwise.
     * @see Months
     */
    private static boolean isValidDate(int dayToFind, Months monthToFind) {
        return dayToFind > 0 && dayToFind <= monthToFind.daysInMonth;
    }

    /**
     * Counts how many days passed from the New Year to 1st day of requested month.
     *
     * @param month requested month (enum {@code Months}) for counting.
     * @return number of days passed from the New Year.
     * @see Months
     */
    private static int daysPassedFromNewYear(Months month) {
        int days = 0;
        Months[] months = Months.values();
        for (int i = 0; i < month.ordinal(); i++) {
            days += months[i].daysInMonth;
        }
        return days;
    }

    /**
     * Enum contains months and number of days in each month.
     */
    public enum Months {

        /**
         * 1st month, 31 days in the month.
         */
        JANUARY(31),

        /**
         * 2nd month, 28 days in the month.
         */
        FEBRUARY(28),

        /**
         * 3rd month, 31 days in the month.
         */
        MARCH(31),

        /**
         * 4th month, 30 days in the month.
         */
        APRIL(30),

        /**
         * 5th month, 31 days in the month.
         */
        MAY(31),

        /**
         * 6th month, 30 days in the month.
         */
        JUNE(30),

        /**
         * 7th month, 31 days in the month.
         */
        JULY(31),

        /**
         * 8th month, 31 days in the month.
         */
        AUGUST(31),

        /**
         * 9th month, 30 days in the month.
         */
        SEPTEMBER(30),

        /**
         * 10th month, 31 days in the month.
         */
        OCTOBER(31),

        /**
         * 11th month, 30 days in the month.
         */
        NOVEMBER(30),

        /**
         * 12th month, 31 days in the month.
         */
        DECEMBER(31);

        /**
         * Constant number of days in each month.
         */
        final int daysInMonth;

        /**
         * Constructor for creating enum values with parameter.
         *
         * @param daysInMonth number of days in each month.
         */
        Months(int daysInMonth) {
            this.daysInMonth = daysInMonth;
        }
    }

    /**
     * Enum contains days of week.
     */
    public enum DaysOfWeek {
        /**
         * 1st day of week.
         */
        MONDAY,

        /**
         * 2nd day of week.
         */
        TUESDAY,

        /**
         * 3rd day of week.
         */
        WEDNESDAY,

        /**
         * 4th day of week.
         */
        THURSDAY,

        /**
         * 5th day of week.
         */
        FRIDAY,

        /**
         * 6th day of week.
         */
        SATURDAY,

        /**
         * 7th day of week.
         */
        SUNDAY
    }
}