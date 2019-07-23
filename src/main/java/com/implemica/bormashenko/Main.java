package com.implemica.bormashenko;

import java.util.NoSuchElementException;
import java.util.Scanner;

import static com.implemica.bormashenko.DayOfWeek.DaysOfWeek;
import static com.implemica.bormashenko.DayOfWeek.Months;

/**
 * Main class for first tasks.
 *
 * @author Mykhailo Bormashenko
 *
 * @todo remove throws from main
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
     * @throws IntegerOverflowException       while using {@code House} with incorrect args.
     * @throws ArrayIndexOutOfBoundsException while using {@code DayOfWeek} with incorrect args.
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
                throw new IncorrectArgumentException("For number of task " + task + ": number should be from 1 to 5");
            }
        }
    }

    /**
     * Allows user to check how {@code Swap} works.
     *
     * @param in scanner that allows user to input numbers from console input.
     * @throws NumberFormatException  if inputted args do not contain requested type (Integer).
     * @throws NoSuchElementException if inputted args do not contain enough parameters.
     * @see Swap for more information.
     */
    private static void task1(Scanner in) throws NumberFormatException, NoSuchElementException {
        System.out.println("Task 1: swap.");
        System.out.println("Input 2 integer numbers.");

        int a = in.nextInt();
        int b = in.nextInt();

        Swap swap = new Swap();
        swap.setA(a);
        swap.setB(b);
        swap.showSwapping();
    }

    /**
     * Allows user to check how {@code House} works.
     *
     * @param in scanner that allows user to input numbers from console input.
     * @throws IncorrectArgumentException if inputted args are non-valid for this task.
     * @throws NumberFormatException      if inputted args do not contain requested type (Integer).
     * @throws NoSuchElementException     if inputted args do not contain enough parameters.
     * @throws IntegerOverflowException   if one of inputted parameter is {@code Integer.MIN_VALUE}
     * @see House for more information.
     */
    private static void task2(Scanner in) throws IncorrectArgumentException, NumberFormatException,
            NoSuchElementException, IntegerOverflowException {
        System.out.println("Task 2: flat.");
        System.out.println("Input number of floors in house, number of flats on floor and number of flat.");

        int floorsInHouse = in.nextInt();
        int flatsOnFloor = in.nextInt();
        int flat = in.nextInt();

        House house = new House(floorsInHouse, flatsOnFloor);
        System.out.println(house.defineHouseAndFloor(flat));
    }

    /**
     * Allows user to check how {@code GreatestCommonDivisor} works.
     *
     * @param in scanner that allows user to input numbers from console input.
     * @throws IncorrectArgumentException if inputted args are non-valid for this task.
     * @throws NumberFormatException      if inputted args do not contain requested type (Integer).
     * @throws NoSuchElementException     if inputted args do not contain enough parameters.
     * @see GreatestCommonDivisor for more information.
     */
    private static void task3(Scanner in) throws IncorrectArgumentException, NumberFormatException,
            NoSuchElementException {
        System.out.println("Task 3: gcd.");
        System.out.println("Input 4 integer numbers.");

        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int d = in.nextInt();

        System.out.println(GreatestCommonDivisor.nod4args(a, b, c, d));
    }

    /**
     * Allows user to check how {@code Fibonacci} works.
     *
     * @param in scanner that allows user to input numbers from console input.
     * @throws IncorrectArgumentException if inputted args are non-valid for this task.
     * @throws NumberFormatException      if inputted args do not contain requested type (Integer).
     * @throws NoSuchElementException     if inputted args do not contain enough parameters.
     * @see Fibonacci for more information.
     */
    private static void task4(Scanner in) throws IncorrectArgumentException, NumberFormatException,
            NoSuchElementException {
        System.out.println("Task 4: fibonacci.");
        System.out.println("Input integer number.");

        int n = in.nextInt();

        System.out.println(Fibonacci.genNFib(n));
    }

    /**
     * Allows user to check how {@code DayOfWeek} works.
     *
     * @param in scanner that allows user to input numbers from console input.
     * @throws IncorrectArgumentException     if inputted args are non-valid for this task.
     * @throws NumberFormatException          if inputted args do not contain requested type (Integer).
     * @throws NoSuchElementException         if inputted args do not contain enough parameters.
     * @throws ArrayIndexOutOfBoundsException if inputted number of day of week is non-valid.
     * @see DayOfWeek for more information.
     */
    private static void task5(Scanner in) throws IncorrectArgumentException, NumberFormatException,
            NoSuchElementException, ArrayIndexOutOfBoundsException {
        System.out.println("Task 5: day of week.");
        System.out.println("Input day of New Year, day to find, month to find.");

        int dayOfNewYear = in.nextInt();
        int dayToFind = in.nextInt();
        int monthToFind = in.nextInt();

        DaysOfWeek[] daysOfWeeks = DaysOfWeek.values();
        Months[] months = Months.values();

        System.out.println(DayOfWeek.defineDayOfWeek(daysOfWeeks[dayOfNewYear - 1], dayToFind, months[monthToFind - 1]));
    }
}