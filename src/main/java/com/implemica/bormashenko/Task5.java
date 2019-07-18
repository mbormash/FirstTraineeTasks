package com.implemica.bormashenko;

/**
 * This utility class defines day of week by number of month
 * number of this day in the month.
 *
 * @author Mykhailo Bormashenko
 */
public class Task5 {

    private static final int DAYS_IN_MONTH_28 = 28;
    private static final int DAYS_IN_MONTH_30 = 30;
    private static final int DAYS_IN_MONTH_31 = 31;
    private static final int DAYS_IN_WEEK = 7;
    private static final int MONTHS_IN_YEAR = 12;

    /**
     * Defines day of week for inputted month and day.
     * @param dayOfNewYear day of week of New Year.
     * @param dayToFind day to find.
     * @param monthToFind month to find.
     * @return day of week for inputted month and day.
     *
     * @throws IncorrectArgumentException if validation for args is not passed.
     */
    public static String defineDayOfWeek(int dayOfNewYear, int dayToFind, int monthToFind) {
        if (!validation(dayOfNewYear, dayToFind, monthToFind)) {
            throw new IncorrectArgumentException("Wrong date for " + dayToFind + " day of " + monthToFind + " month");
        }

        int days = 0;

        switch (monthToFind) {
            case 12:
                days += DAYS_IN_MONTH_30; //november
            case 11:
                days += DAYS_IN_MONTH_31; //october
            case 10:
                days += DAYS_IN_MONTH_30; //september
            case 9:
                days += DAYS_IN_MONTH_31; //august
            case 8:
                days += DAYS_IN_MONTH_31; //july
            case 7:
                days += DAYS_IN_MONTH_30; //june
            case 6:
                days += DAYS_IN_MONTH_31; //may
            case 5:
                days += DAYS_IN_MONTH_30; //april
            case 4:
                days += DAYS_IN_MONTH_31; //march
            case 3:
                days += DAYS_IN_MONTH_28; //february
            case 2:
                days += DAYS_IN_MONTH_31; //january
            default:
                days += dayToFind;
                days += dayOfNewYear;
                days--;
        }

        days %= DAYS_IN_WEEK;
        String day;

        switch (days) {
            case 1:
                day = "Monday";
                break;
            case 2:
                day = "Tuesday";
                break;
            case 3:
                day = "Wednesday";
                break;
            case 4:
                day = "Thursday";
                break;
            case 5:
                day = "Friday";
                break;
            case 6:
                day = "Saturday";
                break;
            default:
                day = "Sunday";
        }
        return day;
    }

    /**
     * Validation for args.
     * @param dayOfNewYear should be from 1 to 7 inclusive.
     * @param dayToFind should be from 1 to max day of month (28, 30 or 31 - depends on month).
     * @param monthToFind should be from 1 to 12 inclusive.
     * @return true if validation passed or false if validation not passed.
     */
    private static boolean validation(int dayOfNewYear, int dayToFind, int monthToFind) {
        if (dayOfNewYear > DAYS_IN_WEEK || dayOfNewYear < 1) {
            return false;
        }

        if (monthToFind > MONTHS_IN_YEAR || monthToFind < 1) {
            return false;
        }

        if (dayToFind < 1) {
            return false;
        }

        int maxDay;

        switch (monthToFind) {
            case 2:
                maxDay = DAYS_IN_MONTH_28;
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                maxDay = DAYS_IN_MONTH_31;
                break;
            default:
                maxDay = DAYS_IN_MONTH_30;
        }

        return !(dayToFind > maxDay);
    }
}
