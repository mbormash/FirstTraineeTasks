package com.implemica.bormashenko;

import org.apache.commons.lang3.StringUtils;

/**
 * This utility class defines day of week by number of month
 * number of this day in the month.
 *
 * @author Mykhailo Bormashenko
 */
public class DayOfWeek {

    /**
     * Amount of days in week.
     */
    private static final int DAYS_IN_WEEK = 7;

    /**
     * Defines day of week for inputted args.
     *
     * @param dayOfNewYear name of day from which the year started.
     * @param dayToFind    number of day on month to find.
     * @param monthToFind  name month to find.
     * @return name day of week for inputted args.
     * @throws IncorrectArgumentException if number of day to find is incorrect for inputted month.
     */
    public static String defineDayOfWeek(DaysOfWeek dayOfNewYear, int dayToFind, Months monthToFind) {
        if (!validation(dayToFind, monthToFind)) {
            throw new IncorrectArgumentException("Wrong date for " + dayToFind + " day of " + monthToFind + " month");
        }

        int numberOfDayOfNewYear = dayOfNewYear.ordinal();
        int days = daysPassedFromNewYear(monthToFind) + numberOfDayOfNewYear + dayToFind;
        days %= DAYS_IN_WEEK;

        if (days == 0) {
            days = 7;
        }

        String day = DaysOfWeek.values()[days - 1].name();
        return firstUpperCase(day);
    }

    /**
     * Validation for inputted day and month.
     *
     * @param dayToFind   number of day.
     * @param monthToFind name of month.
     * @return true if number of day is not more than days in the month.
     */
    private static boolean validation(int dayToFind, Months monthToFind) {
        return dayToFind > 0 && dayToFind <= monthToFind.daysInMonth;
    }

    /**
     * Shows how many days passed from the New Year to 1st day of requested month.
     *
     * @param month name of month.
     * @return number of days passed from the New Year.
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
     * Makes first symbol in string in upped case and other in lower case.
     *
     * @param word string to change.
     * @return changed string with first symbol in upper case and other in lower case.
     */
    private static String firstUpperCase(String word) {
        if (word == null || word.isEmpty()) {
            return word;
        }

        return StringUtils.capitalize(word.toLowerCase());
    }

    /**
     * Enum contains months and number of days in each month.
     */
    public enum Months {

        JANUARY(31),
        FEBRUARY(28),
        MARCH(31),
        APRIL(30),
        MAY(31),
        JUNE(30),
        JULY(31),
        AUGUST(31),
        SEPTEMBER(30),
        OCTOBER(31),
        NOVEMBER(30),
        DECEMBER(31);

        final int daysInMonth;

        Months(int daysInMonth) {
            this.daysInMonth = daysInMonth;
        }
    }

    /**
     * Enum contains days of week.
     */
    public enum DaysOfWeek {
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY
    }
}