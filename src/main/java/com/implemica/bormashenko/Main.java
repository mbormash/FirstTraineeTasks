package com.implemica.bormashenko;

import java.util.Scanner;

import static com.implemica.bormashenko.DayOfWeek.DaysOfWeek;
import static com.implemica.bormashenko.DayOfWeek.Months;

/**
 * Main class for first tasks.
 *
 * @author Mykhailo Bormashenko
 * @since 1.8.
 */
public class Main {

    /**
     * Entry point for program.
     *
     * @param args command line args.
     */
    public static void main(String... args) {
        try {
            chooseTask();
        } catch (IncorrectArgumentException e) {
            System.out.println("Wrong input. " + e.getMessage());
        }
    }

    /**
     * Allows user to choose number of task to work with.
     * 1st task is Swap;
     * 2nd task is House;
     * 3rd task is GCD;
     * 4th task is Fibonacci;
     * 5th task is DayOfWeek.
     *
     * @throws IncorrectArgumentException if inputted number of task or args for tasks are incorrect.
     */
    private static void chooseTask() throws IncorrectArgumentException {
        System.out.println("Input number of task from 1 to 5.");

        try (Scanner in = new Scanner(System.in)) {
            String taskStr = in.next();
            int task = Integer.parseInt(taskStr);

            if (task == 1) {
                taskSwap(in);
            } else if (task == 2) {
                taskHouse(in);
            } else if (task == 3) {
                taskGCD(in);
            } else if (task == 4) {
                taskFibonacci(in);
            } else if (task == 5) {
                taskDayOfWeek(in);
            } else {
                String message = "Expected: number of task from 1 to 5." + System.lineSeparator() +
                        "Got: " + task + " number of task";
                throw new IncorrectArgumentException(message);
            }

        } catch (NumberFormatException e) {
            String message = "Expected: integer number." + System.lineSeparator() +
                    "Got: " + e.getMessage();
            throw new IncorrectArgumentException(message);
        }
    }

    /**
     * Allows user to check how {@code Swap} works.
     *
     * @param in scanner that allows user to input numbers from console input.
     * @throws NumberFormatException if inputted args do not contain requested type (Integer).
     * @see Swap for more information.
     */
    private static void taskSwap(Scanner in) throws NumberFormatException {
        System.out.println("Task 1: swap.");
        System.out.println("Input 2 integer numbers.");

        int a = Integer.parseInt(in.next());
        int b = Integer.parseInt(in.next());

        Swap swap = new Swap();
        swap.setA(a);
        swap.setB(b);

        System.out.println(swap.showSwapping());
    }

    /**
     * Allows user to check how {@code House} works.
     *
     * @param in scanner that allows user to input numbers from console input.
     * @throws IncorrectArgumentException if inputted args are non-valid for this task.
     * @throws NumberFormatException      if inputted args do not contain requested type (Integer).
     * @see House for more information.
     */
    private static void taskHouse(Scanner in) throws IncorrectArgumentException, NumberFormatException {
        System.out.println("Task 2: house.");
        System.out.println("Input number of floors in house, number of flats on floor and number of flat.");

        int floorsInHouse = Integer.parseInt(in.next());
        int flatsOnFloor = Integer.parseInt(in.next());
        int flat = Integer.parseInt(in.next());

        House house = new House(floorsInHouse, flatsOnFloor);

        System.out.println(house.defineHouseAndFloor(flat));
    }

    /**
     * Allows user to check how {@code GreatestCommonDivisor} works.
     *
     * @param in scanner that allows user to input numbers from console input.
     * @throws IncorrectArgumentException if inputted args are non-valid for this task.
     * @throws NumberFormatException      if inputted args do not contain requested type (Integer).
     * @see GreatestCommonDivisor for more information.
     */
    private static void taskGCD(Scanner in) throws IncorrectArgumentException, NumberFormatException {
        System.out.println("Task 3: gcd.");
        System.out.println("Input 4 integer numbers.");

        int a = Integer.parseInt(in.next());
        int b = Integer.parseInt(in.next());
        int c = Integer.parseInt(in.next());
        int d = Integer.parseInt(in.next());

        System.out.println(GreatestCommonDivisor.nod4args(a, b, c, d));
    }

    /**
     * Allows user to check how {@code Fibonacci} works.
     *
     * @param in scanner that allows user to input numbers from console input.
     * @throws IncorrectArgumentException if inputted args are non-valid for this task.
     * @throws NumberFormatException      if inputted args do not contain requested type (Integer).
     * @see Fibonacci for more information.
     */
    private static void taskFibonacci(Scanner in) throws IncorrectArgumentException, NumberFormatException {
        System.out.println("Task 4: fibonacci.");
        System.out.println("Input integer number.");

        int n = Integer.parseInt(in.next());

        System.out.println(Fibonacci.genNFib(n));
    }

    /**
     * Allows user to check how {@code DayOfWeek} works.
     *
     * @param in scanner that allows user to input numbers from console input.
     * @throws IncorrectArgumentException if inputted args are non-valid for this task.
     * @throws NumberFormatException      if inputted args do not contain requested type (Integer).
     * @see DayOfWeek for more information.
     */
    private static void taskDayOfWeek(Scanner in) throws IncorrectArgumentException, NumberFormatException {
        System.out.println("Task 5: day of week.");
        System.out.println("Input day of New Year, day to find, month to find.");

        int dayOfNewYear = Integer.parseInt(in.next());
        int dayToFind = Integer.parseInt(in.next());
        int monthToFind = Integer.parseInt(in.next());

        DaysOfWeek[] daysOfWeeks = DaysOfWeek.values();
        Months[] months = Months.values();

        try {
            System.out.println(DayOfWeek.defineDayOfWeek(daysOfWeeks[dayOfNewYear - 1],
                    dayToFind, months[monthToFind - 1]));
        } catch (ArrayIndexOutOfBoundsException e) {
            String message = "Expected: day of week of New Year from 1 to 7, month from 1 to 12." + System.lineSeparator() +
                    "Got: " + dayOfNewYear + " day of week of New Year, " + monthToFind + " month";
            throw new IncorrectArgumentException(message);
        }
    }
}