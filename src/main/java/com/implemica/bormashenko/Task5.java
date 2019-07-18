package com.implemica.bormashenko;

/**
 * This utility class defines day of week by number of month
 * number of this day in the month.
 *
 * @author Mykhailo Bormashenko
 */
public class Task5 {

    private static final int DAYS_IN_WEEK = 7;

    public static String defineDayOfWeek(DaysOfWeek dayOfNewYear, int dayToFind, Months monthToFind) {
        if (!validation(dayToFind, monthToFind)) {
            throw new IncorrectArgumentException("Wrong date for " + dayToFind + " day of " + monthToFind + " month");
        }

        int numberOfDayOfNewYear = dayOfNewYear.ordinal();
        int days = monthToFind.daysPassedFromNewYear + numberOfDayOfNewYear + dayToFind;
        days %= DAYS_IN_WEEK;
        if (days == 0) {
            days = 7;
        }

        String day = DaysOfWeek.values()[days - 1].name();
        return day.charAt(0) + day.substring(1).toLowerCase();
}

    private static boolean validation(int dayToFind, Months monthToFind) {
        return dayToFind > 0 && dayToFind <= monthToFind.daysInMonth;
    }
}