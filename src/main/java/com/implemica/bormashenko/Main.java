package com.implemica.bormashenko;

import java.util.NoSuchElementException;
import java.util.Scanner;

import static com.implemica.bormashenko.Task5.DaysOfWeek;
import static com.implemica.bormashenko.Task5.Months;

/**
 * Main class for first tasks.
 *
 * @author Mykhailo Bormashenko
 */
public class Main {

    /**
     * Entry point for program.
     * Allows user to choose number of task to work with.
     *
     * @param args command line args.
     * @throws IncorrectArgumentException     if inputted number of task or args for tasks are incorrect.
     * @throws NumberFormatException          if inputted args do not contain requested type.
     * @throws NoSuchElementException         if inputted args do not contain enough parameters.
     * @throws IntegerOverflowException       while using {@code Task2} with with incorrect args.
     */
    public static void main(String... args) throws IncorrectArgumentException, NumberFormatException,
            NoSuchElementException, IntegerOverflowException {
        System.out.println("Input number of task from 1 to 5.");

        try (Scanner in = new Scanner(System.in)) {
            int task;
            task = in.nextInt();

            if (task == 1) {
                task1(in);
            } else if (task == 2) {
                task2(in);
            } else if (task == 3) {
                task3(in);
            } else if (task == 4) {
                task4(in);
            } else if (task == 5) {
                task5(in);
            } else {
                throw new IncorrectArgumentException("Number should be from 1 to 5");
            }
        }
    }

    /**
     * Allows user to check how {@code Task1} works.
     *
     * @param in scanner that allows user to input numbers from console input.
     * @throws NumberFormatException  if inputted args do not contain requested type (Integer).
     * @throws NoSuchElementException if inputted args do not contain enough parameters.
     * @see Task1 for more information.
     */
    private static void task1(Scanner in) throws NumberFormatException, NoSuchElementException {
        System.out.println("Task 1: swap.");
        System.out.println("Input 2 integer numbers.");

        int a = in.nextInt();
        int b = in.nextInt();

        Task1 task1 = new Task1();
        task1.setA(a);
        task1.setB(b);
        task1.showSwapping();
    }

    /**
     * Allows user to check how {@code Task2} works.
     *
     * @param in scanner that allows user to input numbers from console input.
     * @throws IncorrectArgumentException if inputted args are non-valid for this task.
     * @throws NumberFormatException      if inputted args do not contain requested type (Integer).
     * @throws NoSuchElementException     if inputted args do not contain enough parameters.
     * @throws IntegerOverflowException   if one of inputted parameter is {@code Integer.MIN_VALUE}
     * @see Task2 for more information.
     */
    private static void task2(Scanner in) throws IncorrectArgumentException, NumberFormatException,
            NoSuchElementException, IntegerOverflowException {
        System.out.println("Task 2: flat.");
        System.out.println("Input number of floors in house, number of flats on floor and number of flat.");

        int floorsInHouse = in.nextInt();
        int flatsOnFloor = in.nextInt();
        int flat = in.nextInt();

        Task2 task2 = new Task2(floorsInHouse, flatsOnFloor);
        System.out.println(task2.defineHouseAndFloor(flat));
    }

    /**
     * Allows user to check how {@code Task3} works.
     *
     * @param in scanner that allows user to input numbers from console input.
     * @throws IncorrectArgumentException if inputted args are non-valid for this task.
     * @throws NumberFormatException      if inputted args do not contain requested type (Integer).
     * @throws NoSuchElementException     if inputted args do not contain enough parameters.
     * @see Task3 for more information.
     */
    private static void task3(Scanner in) throws IncorrectArgumentException, NumberFormatException,
            NoSuchElementException {
        System.out.println("Task 3: gcd.");
        System.out.println("Input 4 integer numbers.");

        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int d = in.nextInt();

        System.out.println(Task3.nod4args(a, b, c, d));
    }

    /**
     * Allows user to check how {@code Task4} works.
     *
     * @param in scanner that allows user to input numbers from console input.
     * @throws IncorrectArgumentException if inputted args are non-valid for this task.
     * @throws NumberFormatException      if inputted args do not contain requested type (Integer).
     * @throws NoSuchElementException     if inputted args do not contain enough parameters.
     * @see Task4 for more information.
     */
    private static void task4(Scanner in) throws IncorrectArgumentException, NumberFormatException,
            NoSuchElementException {
        System.out.println("Task 4: fibonacci.");
        System.out.println("Input integer number.");

        int n = in.nextInt();

        System.out.println(Task4.genNFib(n));
    }

    /**
     * Allows user to check how {@code Task5} works.
     *
     * @param in scanner that allows user to input numbers from console input.
     * @throws IncorrectArgumentException     if inputted args are non-valid for this task.
     * @throws NumberFormatException          if inputted args do not contain requested type (Integer).
     * @throws NoSuchElementException         if inputted args do not contain enough parameters.
     * @throws ArrayIndexOutOfBoundsException if inputted number of day of week is non-valid.
     * @see Task5 for more information.
     */
    private static void task5(Scanner in) throws IncorrectArgumentException, NumberFormatException,
            NoSuchElementException {
        System.out.println("Task 5: day of week.");
        System.out.println("Input day of New Year, day to find, month to find.");

        String dayOfNewYear = in.next();
        int dayToFind = in.nextInt();
        String monthToFind = in.next();

        System.out.println(Task5.defineDayOfWeek(defineDayOfWeek(dayOfNewYear), dayToFind, defineMonth(monthToFind)));
    }

    private static DaysOfWeek defineDayOfWeek(String dayOfWeek) {
        dayOfWeek = dayOfWeek.toUpperCase();

        if (dayOfWeek.equals("MONDAY")) {
            return DaysOfWeek.MONDAY;
        }

        if (dayOfWeek.equals("TUESDAY")) {
            return DaysOfWeek.TUESDAY;
        }

        if (dayOfWeek.equals("WEDNESDAY")) {
            return DaysOfWeek.WEDNESDAY;
        }

        if (dayOfWeek.equals("THURSDAY")) {
            return DaysOfWeek.THURSDAY;
        }

        if (dayOfWeek.equals("FRIDAY")) {
            return DaysOfWeek.FRIDAY;
        }

        if (dayOfWeek.equals("SATURDAY")) {
            return DaysOfWeek.SATURDAY;
        }

        if (dayOfWeek.equals("SUNDAY")) {
            return DaysOfWeek.SUNDAY;
        }

        throw new IncorrectArgumentException("String " + dayOfWeek + " is not day of week");
    }

    private static Months defineMonth(String month) {
        month = month.toUpperCase();

        if (month.equals("JANUARY")) {
            return Months.JANUARY;
        }

        if (month.equals("FEBRUARY")) {
            return Months.FEBRUARY;
        }

        if (month.equals("MARCH")) {
            return Months.MARCH;
        }

        if (month.equals("APRIL")) {
            return Months.APRIL;
        }

        if (month.equals("MAY")) {
            return Months.MAY;
        }

        if (month.equals("JUNE")) {
            return Months.JUNE;
        }

        if (month.equals("JULY")) {
            return Months.JULY;
        }

        if (month.equals("AUGUST")) {
            return Months.AUGUST;
        }

        if (month.equals("SEPTEMBER")) {
            return Months.SEPTEMBER;
        }

        if (month.equals("OCTOBER")) {
            return Months.OCTOBER;
        }

        if (month.equals("NOVEMBER")) {
            return Months.NOVEMBER;
        }

        if (month.equals("DECEMBER")) {
            return Months.DECEMBER;
        }

        throw new IncorrectArgumentException("String " + month + " is not a month");
    }
}