package com.implemica.bormashenko;

/**
 * Enum contains months, number of days in each month
 * and number of days passed from New Year for each month.
 *
 * @author Mykhailo Bormashenko
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

    int daysInMonth;

    Months(int daysInMonth) {
        this.daysInMonth = daysInMonth;
    }
}
