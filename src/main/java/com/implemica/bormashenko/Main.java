package com.implemica.bormashenko;

/**
 * Main class for first tasks.
 *
 * @author Mykhailo Bormashenko
 */
public class Main {

    /**
     * Entry point for program.
     * @param args command line args.
     */
    public static void main(String... args) {
        task1(100, 200);
        task2(9, 4, 100);
        task3(90, 12, 45, 63);
        task4(15);
        task5(3, 18, 7);
    }

    /**
     * Shows how task1 works.
     * @see Task1
     * @param a first parameter.
     * @param b second parameter.
     */
    private static void task1(int a, int b) {
        System.out.println("Task 1: swap.");
        Task1 task1 = new Task1();
        task1.setA(a);
        task1.setB(b);
        task1.showSwapping();
    }

    /**
     * Shows how task2 works.
     * @see Task2
     * @param floorsInHouse number of floors in house.
     * @param flatsOnFloor number of flats on floor.
     * @param flat number of flat, for which have to define house and floor.
     */
    private static void task2(int floorsInHouse, int flatsOnFloor, int flat) {
        System.out.println("Task 2: flat");
        Task2 task2 = new Task2(floorsInHouse, flatsOnFloor);
        System.out.println(task2.defineHouseAndFloor(flat));
    }

    /**
     * Shows how task3 works.
     * @see Task3
     * @param a first parameter.
     * @param b second parameter.
     * @param c third parameter.
     * @param d fourth parameter.
     */
    private static void task3(int a, int b, int c, int d) {
        System.out.println("Task 3: gcd");
        System.out.println(Task3.nod4args(a, b, c, d));
    }

    /**
     * Shows how task4 works.
     * @see Task4
     * @param n number of fibonacci's value.
     */
    private static void task4(int n) {
        System.out.println("Task 4: fibonacci");
        System.out.println(Task4.genNFib(n));
    }

    /**
     * Shows how task5 works.
     * @see Task5
     * @param dayOfNewYear day of week from which the year started.
     * @param dayToFind number of day to define day of week.
     * @param monthToFind number of month to define day of week.
     */
    private static void task5(int dayOfNewYear, int dayToFind, int monthToFind) {
        System.out.println("Task 5: day of week");
        System.out.println(Task5.defineDayOfWeek(dayOfNewYear, dayToFind, monthToFind));
    }
}
