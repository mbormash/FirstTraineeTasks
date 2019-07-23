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
        int days = daysPassedFromNewYear(monthToFind) + numberOfDayOfNewYear + dayToFind;
        days %= DAYS_IN_WEEK;

        if (days == 0) {
            days = 7;
        }

        String day = DaysOfWeek.values()[days - 1].name();
        return firstUpperCase(day);
    }

    private static boolean validation(int dayToFind, Months monthToFind) {
        return dayToFind > 0 && dayToFind <= monthToFind.daysInMonth;
    }

    private static int daysPassedFromNewYear(Months month) {
        int days = 0;
        Months[] months = Months.values();
        for (int i = 0; i < month.ordinal(); i++) {
            days += months[i].daysInMonth;
        }
        return days;
    }

    private static String firstUpperCase(String word) {
        if (word == null || word.isEmpty()) {
            return word;
        }

        return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
    }
}