package com.implemica.bormashenko;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Main class for first tasks.
 *
 * @author Mykhailo Bormashenko
 */
public class Main {

    public static void main(String... args) throws IncorrectArgumentException, NumberFormatException,
            NoSuchElementException, IntegerOverflowException,
            ArrayIndexOutOfBoundsException {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Input number of task from 1 to 5.");
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

    private static void task2(Scanner in) throws IncorrectArgumentException, NumberFormatException,
                                                 NoSuchElementException {
        System.out.println("Task 2: flat.");
        System.out.println("Input number of floors in house, number of flats on floor and number of flat.");
        int floorsInHouse = in.nextInt();
        int flatsOnFloor = in.nextInt();
        int flat = in.nextInt();

        Task2 task2 = new Task2(floorsInHouse, flatsOnFloor);
        System.out.println(task2.defineHouseAndFloor(flat));
    }

    private static void task3(Scanner in) throws IncorrectArgumentException, NumberFormatException,
                                                 NoSuchElementException, IntegerOverflowException {
        System.out.println("Task 3: gcd.");
        System.out.println("Input 4 integer numbers.");
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int d = in.nextInt();

        System.out.println(Task3.nod4args(a, b, c, d));
    }

    private static void task4(Scanner in) throws IncorrectArgumentException, NumberFormatException,
                                                 NoSuchElementException {
        System.out.println("Task 4: fibonacci.");
        System.out.println("Input integer number.");
        int n = in.nextInt();

        System.out.println(Task4.genNFib(n));
    }

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