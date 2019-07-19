package com.implemica.bormashenko;

/**
 * Enum contains months, number of days in each month
 * and number of days passed from New Year for each month.
 *
 * @author Mykhailo Bormashenko
 */
public enum Months {

    JANUARY(31, 0),
    FEBRUARY(28, 31),
    MARCH(31, 59),
    APRIL(30, 90),
    MAY(31, 120),
    JUNE(30, 151),
    JULY(31, 181),
    AUGUST(31, 212),
    SEPTEMBER(30, 243),
    OCTOBER(31, 273),
    NOVEMBER(30, 304),
    DECEMBER(31, 334);

    int daysInMonth;
    int daysPassedFromNewYear;

    Months(int daysInMonth, int daysPassedFromNewYear) {
        this.daysInMonth = daysInMonth;
        this.daysPassedFromNewYear = daysPassedFromNewYear;
    }
}
