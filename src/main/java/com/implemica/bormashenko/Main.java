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
     * @throws ArrayIndexOutOfBoundsException while using {@code Task5} with incorrect args.
     */
    public static void main(String... args) throws IncorrectArgumentException, NumberFormatException,
            NoSuchElementException, IntegerOverflowException, ArrayIndexOutOfBoundsException {
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
            NoSuchElementException, ArrayIndexOutOfBoundsException {
        System.out.println("Task 5: day of week.");
        System.out.println("Input day of New Year, day to find, month to find.");
        int dayOfNewYear = in.nextInt();
        int dayToFind = in.nextInt();
        int monthToFind = in.nextInt();

        DaysOfWeek[] daysOfWeek = DaysOfWeek.values();
        Months[] months = Months.values();
        System.out.println(Task5.defineDayOfWeek(daysOfWeek[dayOfNewYear - 1], dayToFind, months[monthToFind - 1]));
    }
}