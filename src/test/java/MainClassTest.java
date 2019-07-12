import com.implemica.bormashenko.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.NoSuchElementException;

import static java.lang.System.lineSeparator;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Test class for Main class.
 *
 * @author Mykhailo Bormashenko
 */
class MainClassTest {

    /**
     * Returns standard System.in and System.out.
     */
    @AfterEach
    void returnSystemInAndOut() {
        System.setIn(System.in);
        System.setOut(System.out);
    }

    /**
     * Tests for task 1, called from main.
     * Simulates user input from keyboard and
     * console output. Tests from task 1 used with
     * override check method.
     * @see Task1Test
     */
    @Test
    void testTask1() {
        Task1Test task1Test = new Task1Test() {
            /**
             * Overrides method from task1Test, used in tests.
             * Simulates user input from console with valid args.
             * @param aBefore value of first test parameter.
             * @param bBefore value of second test parameter.
             */
            @Override
            void check(int aBefore, int bBefore) {
                String input = "1" + lineSeparator() + aBefore + lineSeparator() + bBefore;
                String expected = "Input number of task from 1 to 5." + lineSeparator() +
                        "Task 1: swap." + lineSeparator() +
                        "Input 2 integer numbers." + lineSeparator() +
                        "Before reversing:" + lineSeparator() +
                        "a: " + aBefore + ", b: " + bBefore + lineSeparator() +
                        "After reversing:" + lineSeparator() +
                        "a: " + bBefore + ", b: " + aBefore + lineSeparator();

                ByteArrayOutputStream output = setInAndOut(input);
                Main.main();
                assertEquals(expected, output.toString());
            }
        };
        task1Test.tests();
    }

    /**
     * Tests for task 2, called from main.
     * Simulates user input from keyboard and
     * console output. Tests from task 2 used with
     * override check method.
     * @see Task2Test
     */
    @Test
    void testTask2() {
        Task2Test task2Test = new Task2Test() {
            /**
             * Overrides method from task2Test, used in tests.
             * Simulates user input from console with valid args.
             * @param floorsInHouse number of floors in house.
             * @param flatsOnFloor number of flats on floor.
             * @param numberOfFlat number of flat, for which have to define house and floor.
             * @param expectedHouse expected value of house.
             * @param expectedFloor expected value of floor.
             */
            @Override
            void check(int floorsInHouse, int flatsOnFloor, int numberOfFlat,
                       String expectedHouse, String expectedFloor) {
                String input = "2" + lineSeparator() + floorsInHouse + lineSeparator() +
                        flatsOnFloor + lineSeparator() + numberOfFlat;
                String expected = "Input number of task from 1 to 5." + lineSeparator() +
                        "Task 2: flat." + lineSeparator() +
                        "Input number of floors in house, number of flats on floor and number of flat." + lineSeparator() +
                        numberOfFlat + ": " + expectedFloor + " floor, " + expectedHouse + " house" + lineSeparator();

                ByteArrayOutputStream output = setInAndOut(input);
                Main.main();
                assertEquals(expected, output.toString());
            }

            /**
             * Overrides method from task2Test, used in tests.
             * Simulates user input from console with valid args.
             * @param floorsInHouse number of floors in house.
             * @param flatsOnFloor number of flats on floor.
             * @param numberOfFlat number of flat, for which have to define house and floor.
             */
            @Override
            void checkException(int floorsInHouse, int flatsOnFloor, int numberOfFlat) {
                try {
                    String input = "2" + lineSeparator() + floorsInHouse + lineSeparator() +
                            flatsOnFloor + lineSeparator() + numberOfFlat;

                    setInAndOut(input);
                    Main.main();
                    fail("Exception was not thrown.");
                } catch (IncorrectArgumentException | IntegerOverflowException e) {
                    //correct behavior
                }
            }
        };
        task2Test.validArgsTests();
        task2Test.nonValidArgsTests();
    }

    /**
     * Tests for task 3, called from main.
     * Simulates user input from keyboard and
     * console output. Tests from task 3 used with
     * override check method.
     * @see Task3Test
     */
    @Test
    void testTask3() {
        Task3Test task3Test = new Task3Test() {
            /**
             * Overrides method from task3Test, used in tests.
             * Simulates user input from console with valid args.
             * @param a first parameter.
             * @param b second parameter.
             * @param c third parameter.
             * @param d fourth parameter.
             * @param expected expected result of gcd for inputted args.
             */
            @Override
            void check(int a, int b, int c, int d, int expected) {
                String input = "3" + lineSeparator() + a + lineSeparator() +
                        b + lineSeparator() + c + lineSeparator() + d;
                String expectedOutput = "Input number of task from 1 to 5." + lineSeparator() +
                        "Task 3: gcd." + lineSeparator() +
                        "Input 4 integer numbers." + lineSeparator() +
                        expected + lineSeparator();

                ByteArrayOutputStream output = setInAndOut(input);
                Main.main();
                assertEquals(expectedOutput, output.toString());
            }

            /**
             * Overrides method from task3Test, used in tests.
             * Simulates user input from console with valid args.
             * @param a first parameter.
             * @param b second parameter.
             * @param c third parameter.
             * @param d fourth parameter.
             */
            @Override
            void checkException(int a, int b, int c, int d) {
                try {
                    String input = "3" + lineSeparator() + a + lineSeparator() +
                            b + lineSeparator() + c + lineSeparator() + d;

                    setInAndOut(input);
                    Main.main();
                    fail("Exception was not thrown.");
                } catch (IncorrectArgumentException e) {
                    //correct behavior
                }
            }
        };
        task3Test.validArgsTests();
        task3Test.nonValidArgsTests();
    }

    /**
     * Tests for task 4, called from main.
     * Simulates user input from keyboard and
     * console output. Tests from task 4 used with
     * override check method.
     * @see Task4Test
     */
    @Test
    void testTask4() {
        Task4Test task4Test = new Task4Test() {
            /**
             * Overrides method from task4Test, used in tests.
             * Simulates user input from console with valid args.
             * @param n number of fibonacci's value.
             * @param expected expected fibonacci's value.
             */
            @Override
            void check(int n, String expected) {
                String input = "4" + lineSeparator() + n;
                expected = "Input number of task from 1 to 5." + lineSeparator() +
                        "Task 4: fibonacci." + lineSeparator() +
                        "Input integer number." + lineSeparator() +
                        expected + lineSeparator();

                ByteArrayOutputStream output = setInAndOut(input);
                Main.main();
                assertEquals(expected, output.toString());
            }

            /**
             * Overrides method from task4Test, used in tests.
             * Simulates user input from console with valid args.
             * @param n number of fibonacci's value.
             */
            @Override
            void checkException(int n) {
                try {
                    String input = "4" + lineSeparator() + n;

                    setInAndOut(input);
                    Main.main();
                    fail("Exception was not thrown.");
                } catch (IncorrectArgumentException e) {
                    //correct behavior
                }
            }
        };
        task4Test.validArgsTests();
        task4Test.nonValidArgsTests();
    }

    /**
     * Tests for task 5, called from main.
     * Simulates user input from keyboard and
     * console output. Tests from task 5 used with
     * override check method.
     * @see Task5Test
     */
    @Test
    void testTask5() {
        Task5Test task5Test = new Task5Test() {
            /**
             * Overrides method from task5Test, used in tests.
             * Simulates user input from console with valid args.
             * @param dayOfNewYear day of week from which the year started.
             * @param dayToFind number of day to define day of week.
             * @param monthToFind number of month to define day of week.
             * @param expected expected day of week.
             */
            @Override
            void check(int dayOfNewYear, int dayToFind, int monthToFind, String expected) {
                String input = "5" + lineSeparator() + dayOfNewYear + lineSeparator() +
                        dayToFind + lineSeparator() + monthToFind;
                expected = "Input number of task from 1 to 5." + lineSeparator() +
                        "Task 5: day of week." + lineSeparator() +
                        "Input day of New Year, day to find, month to find." + lineSeparator() +
                        expected + lineSeparator();

                ByteArrayOutputStream output = setInAndOut(input);
                Main.main();
                assertEquals(expected, output.toString());
            }

            /**
             * Overrides method from task5Test, used in tests.
             * Simulates user input from console with non-valid args.
             * @param dayOfNewYear day of week from which the year started.
             * @param dayToFind number of day to define day of week.
             * @param monthToFind number of month to define day of week.
             */
            @Override
            void checkException(int dayOfNewYear, int dayToFind, int monthToFind) {
                try {
                    String input = "5" + lineSeparator() + dayOfNewYear + lineSeparator() +
                            dayToFind + lineSeparator() + monthToFind;

                    setInAndOut(input);
                    Main.main();
                    fail("Exception was not thrown.");
                } catch (IncorrectArgumentException e) {
                    //correct behavior
                }
            }
        };
        task5Test.validArgsTests();
        task5Test.nonValidArgsTests();
    }

    /**
     * Tests with non-valid args for main.
     * 55 tests for non-valid number of task (non-positive, positive, without and with any other input).
     * Tests for valid number of task include tests with not enough args, with not integer numbers
     * (negative and positive), with not-a-number-string (containing digits or not) in args. In this way:
     * 50 tests for task1;
     * 75 tests for task2;
     * 112 tests for task3;
     * 19 tests for task4;
     * 75 tests for task5;
     * 386 tests at all.
     */
    @Test
    void nonValidInputTests() {
        //non valid number of task
        //non-positive
        //without any other args
        checkException();
        checkException("");
        checkException("0");
        checkException("-1");
        checkException(String.valueOf(Integer.MIN_VALUE / 2));
        checkException(String.valueOf(Integer.MIN_VALUE + 1));
        checkException(String.valueOf(Integer.MIN_VALUE));
        checkException(String.valueOf(Integer.MIN_VALUE - 1L));
        checkException(String.valueOf(Long.MIN_VALUE / 2));
        checkException(String.valueOf(Long.MIN_VALUE + 1));
        checkException(String.valueOf(Long.MIN_VALUE));
        checkException("-99999999999999999999");
        checkException("-10000000000000000000");
        checkException("-43180758917491874141");
        checkException("-1318019883091");

        //with other args
        checkException("", "1");
        checkException("0", "2", "3");
        checkException("-1", "62431", "2424", "1313");
        checkException(String.valueOf(Integer.MIN_VALUE / 2), "-513", "-6141", "-513", "-7625");
        checkException(String.valueOf(Integer.MIN_VALUE + 1), "adgadas");
        checkException(String.valueOf(Integer.MIN_VALUE), "adadad", "asdt");
        checkException(String.valueOf(Integer.MIN_VALUE - 1L), "qweqr", "sdfsdf", "hsfsf");
        checkException(String.valueOf(Long.MIN_VALUE / 2), "hsdfads", "adasd", "adad", "gfadad");
        checkException(String.valueOf(Long.MIN_VALUE + 1), "12313");
        checkException(String.valueOf(Long.MIN_VALUE), "1");
        checkException("-99999999999999999999", "2");
        checkException("-10000000000000000000", "3");
        checkException("-43180758917491874141", "4");
        checkException("-1318019883091", "5");

        //positive
        //without any other args
        checkException("6");
        checkException("7");
        checkException(String.valueOf(Integer.MAX_VALUE / 2));
        checkException(String.valueOf(Integer.MAX_VALUE - 1));
        checkException(String.valueOf(Integer.MAX_VALUE));
        checkException(String.valueOf(Integer.MAX_VALUE + 1L));
        checkException(String.valueOf(Long.MAX_VALUE / 2));
        checkException(String.valueOf(Long.MAX_VALUE - 1));
        checkException(String.valueOf(Long.MAX_VALUE));
        checkException("99999999999999999999");
        checkException("10000000000000000000");
        checkException("624313265425234726");
        checkException("114127988623422423091");

        //with other args
        checkException("6", "1");
        checkException("7", "2", "3");
        checkException(String.valueOf(Integer.MAX_VALUE / 2), "5123", "62412", "1312313");
        checkException(String.valueOf(Integer.MAX_VALUE - 1), "-5131", "-62342", "-6523", "-141");
        checkException(String.valueOf(Integer.MAX_VALUE), "unfbed");
        checkException(String.valueOf(Integer.MAX_VALUE + 1L), "asdaea", "dasrasd");
        checkException(String.valueOf(Long.MAX_VALUE / 2), "aaeada", "wdasd", "tgdaew");
        checkException(String.valueOf(Long.MAX_VALUE - 1), "adsad", "gadasd", "asdaeae", "twdasda");
        checkException(String.valueOf(Long.MAX_VALUE), "1");
        checkException("99999999999999999999", "2");
        checkException("10000000000000000000", "3");
        checkException("624313265425234726", "4");
        checkException("114127988623422423091", "5");

        //valid number of task
        //task 1
        //not enough args
        checkException("1");
        checkException("1", "2");

        //not integer numbers
        //negative
        checkException("1", String.valueOf(Integer.MIN_VALUE - 1L), "12341");
        checkException("1", String.valueOf(Long.MIN_VALUE / 2), "141");
        checkException("1", String.valueOf(Long.MIN_VALUE + 1), "5353");
        checkException("1", String.valueOf(Long.MIN_VALUE), "9867");
        checkException("1", "-9999999999999999999", "141414");
        checkException("1", "-1000000000000000000", "123141");
        checkException("1", "-51234142129841749174", "312");
        checkException("1", "-63453459827349211464", "62452");

        checkException("1", "12341", String.valueOf(Integer.MIN_VALUE - 1L));
        checkException("1", "141", String.valueOf(Long.MIN_VALUE / 2));
        checkException("1", "5353", String.valueOf(Long.MIN_VALUE + 1));
        checkException("1", "9867", String.valueOf(Long.MIN_VALUE));
        checkException("1", "141414", "-9999999999999999999");
        checkException("1", "123141", "-1000000000000000000");
        checkException("1", "312", "-51234142129841749174");
        checkException("1", "62452", "-63453459827349211464");

        //positive
        checkException("1", String.valueOf(Integer.MAX_VALUE + 1L), "7624");
        checkException("1", String.valueOf(Long.MAX_VALUE / 2), "5234");
        checkException("1", String.valueOf(Long.MAX_VALUE - 1), "115");
        checkException("1", String.valueOf(Long.MAX_VALUE), "9876");
        checkException("1", "9999999999999999999", "62");
        checkException("1", "1000000000000000000", "6524");
        checkException("1", "7863987656789098765678", "8765");
        checkException("1", "98765456787654356789", "237");

        checkException("1", "652", String.valueOf(Integer.MAX_VALUE + 1L));
        checkException("1", "87", String.valueOf(Long.MAX_VALUE / 2));
        checkException("1", "235", String.valueOf(Long.MAX_VALUE - 1));
        checkException("1", "765", String.valueOf(Long.MAX_VALUE));
        checkException("1", "32", "9999999999999999999");
        checkException("1", "76524", "1000000000000000000");
        checkException("1", "765", "987465755654567654");
        checkException("1", "2", "987654567654467876");

        //not a number
        checkException("1", "wedafasda", "5234");
        checkException("1", "adsgjsgsg", "6523");
        checkException("1", "1454ygfsada", "641");
        checkException("1", "65416gasrfs", "61");
        checkException("1", "hdfgsgf453525", "6213");
        checkException("1", "sgkj6414", "852");
        checkException("1", "fadfaf562sdfsdf", "975");
        checkException("1", "dsfsf42342gsfgs", "890");

        checkException("1", "72353", "jfsfgsd");
        checkException("1", "73573", "jdgfs");
        checkException("1", "1514", "156hdgdgd");
        checkException("1", "62342", "625ddgsf");
        checkException("1", "6243", "gsfsf652");
        checkException("1", "14", "hsfsdf645");
        checkException("1", "5", "hdfgsf635dgdfg");
        checkException("1", "62342", "hdsfej735sfgsfs");

        //task 2
        //not enough args
        checkException("2");
        checkException("2", "1");
        checkException("2", "1", "3");

        //not integer numbers
        //negative
        checkException("2", String.valueOf(Integer.MIN_VALUE - 1L), "4131", "151");
        checkException("2", String.valueOf(Long.MIN_VALUE / 2), "141", "51231");
        checkException("2", String.valueOf(Long.MIN_VALUE + 1), "23", "51431");
        checkException("2", String.valueOf(Long.MIN_VALUE), "5161", "512341");
        checkException("2", "-9999999999999999999", "654", "41241");
        checkException("2", "-1000000000000000000", "624", "5114");
        checkException("2", "-65213426523523521425", "4", "511");
        checkException("2", "-635272342426234523623", "654", "124");

        checkException("2", "5124", String.valueOf(Integer.MIN_VALUE - 1L), "13131");
        checkException("2", "652", String.valueOf(Long.MIN_VALUE / 2), "13141");
        checkException("2", "151", String.valueOf(Long.MIN_VALUE + 1), "12314");
        checkException("2", "145", String.valueOf(Long.MIN_VALUE), "4131");
        checkException("2", "642", "-9999999999999999999", "421232");
        checkException("2", "124", "-1000000000000000000", "143124");
        checkException("2", "734", "-652411252235253252", "5124");
        checkException("2", "124", "-12315616234892563", "41151");

        checkException("2", "1251", "541", String.valueOf(Integer.MIN_VALUE - 1L));
        checkException("2", "624", "356", String.valueOf(Long.MIN_VALUE / 2));
        checkException("2", "33", "234", String.valueOf(Long.MIN_VALUE + 1));
        checkException("2", "624", "54", String.valueOf(Long.MIN_VALUE));
        checkException("2", "141", "2", "-9999999999999999999");
        checkException("2", "51", "425", "-1000000000000000000");
        checkException("2", "765", "63", "-97663523423525267245");
        checkException("2", "14", "4", "-98763452634526252525");

        //positive
        checkException("2", String.valueOf(Integer.MAX_VALUE + 1L), "1414", "131");
        checkException("2", String.valueOf(Long.MAX_VALUE / 2), "524", "1414");
        checkException("2", String.valueOf(Long.MAX_VALUE - 1), "345", "5141");
        checkException("2", String.valueOf(Long.MAX_VALUE), "65", "5141");
        checkException("2", "9999999999999999999", "341", "23");
        checkException("2", "1000000000000000000", "245", "3");
        checkException("2", "125267654765476543", "65", "42");
        checkException("2", "232527654876542348765", "234", "1414");

        checkException("2", "412", String.valueOf(Integer.MAX_VALUE + 1L), "14124");
        checkException("2", "4234", String.valueOf(Long.MAX_VALUE / 2), "513421");
        checkException("2", "35", String.valueOf(Long.MAX_VALUE - 1), "514141");
        checkException("2", "14", String.valueOf(Long.MAX_VALUE), "511");
        checkException("2", "64", "9999999999999999999", "414");
        checkException("2", "124", "1000000000000000000", "412");
        checkException("2", "652", "654643636622222565436", "142");
        checkException("2", "6", "2652376545654264643636", "4224");

        checkException("2", "654", "54", String.valueOf(Integer.MAX_VALUE + 1L));
        checkException("2", "34", "243", String.valueOf(Long.MAX_VALUE / 2));
        checkException("2", "5", "23", String.valueOf(Long.MAX_VALUE - 1));
        checkException("2", "245", "3", String.valueOf(Long.MAX_VALUE));
        checkException("2", "543", "54", "9999999999999999999");
        checkException("2", "54", "54", "1000000000000000000");
        checkException("2", "45", "24", "76542765236723567363");
        checkException("2", "234", "62", "927592856295295872983");

        //not a number
        checkException("2", "hkjhgar", "43", "51341");
        checkException("2", "uytradfghj", "62", "51342");
        checkException("2", "1456sdgkysf", "623", "52352");
        checkException("2", "1526765fdgsafsf", "7653", "52352");
        checkException("2", "sgdmy532", "43", "523452");
        checkException("2", "ytrf43", "852", "2356");
        checkException("2", "a4a", "62", "32");
        checkException("2", "asyy5265rkj", "43", "234");

        checkException("2", "234", "shjktws", "414");
        checkException("2", "625", "uyterr", "1241");
        checkException("2", "24", "246we", "411");
        checkException("2", "34", "436yy", "411");
        checkException("2", "15", "adsfg543", "4111");
        checkException("2", "43", "asdf54", "4141");
        checkException("2", "65", "agbn52adg", "41241");
        checkException("2", "654", "jhgf432f", "214");

        checkException("2", "514", "654", "sgh");
        checkException("2", "34", "34", "uytrf");
        checkException("2", "14", "324", "4152hgf");
        checkException("2", "54", "53", "7654jhg");
        checkException("2", "423", "12", "adfg543");
        checkException("2", "24", "65", "atyjk54");
        checkException("2", "65", "23", "ashd43rfg");
        checkException("2", "23", "152", "hgf456y");

        //task 3
        //not enough args
        checkException("3");
        checkException("3", "1");
        checkException("3", "1", "2");
        checkException("3", "1", "2", "4");

        //not integer numbers
        //negative
        checkException("3", String.valueOf(Integer.MIN_VALUE - 1L), "124", "154", "414");
        checkException("3", String.valueOf(Long.MIN_VALUE / 2), "124", "65", "4124");
        checkException("3", String.valueOf(Long.MIN_VALUE + 1), "14", "65", "4141");
        checkException("3", String.valueOf(Long.MIN_VALUE), "124", "141", "4141");
        checkException("3", "-9999999999999999999", "65", "513", "4123");
        checkException("3", "-1000000000000000000", "12", "65", "4141");
        checkException("3", "-65416765432126876541", "65", "124", "41241");
        checkException("3", "-98141741274814965189", "124", "5132", "4124");

        checkException("3", "6534", String.valueOf(Integer.MIN_VALUE - 1L), "15612", "1513");
        checkException("3", "65252", String.valueOf(Long.MIN_VALUE / 2), "65175", "52352");
        checkException("3", "76517", String.valueOf(Long.MIN_VALUE + 1), "65422", "41342");
        checkException("3", "61375", String.valueOf(Long.MIN_VALUE), "12561", "42145");
        checkException("3", "129587", "-9999999999999999999", "763214", "42352");
        checkException("3", "62365", "-1000000000000000000", "914872", "5252");
        checkException("3", "9725", "-1452357295820582055", "51", "5235");
        checkException("3", "6237", "-6235235987015135151", "51561", "41241");

        checkException("3", "265", "65141", String.valueOf(Integer.MIN_VALUE - 1L), "14141");
        checkException("3", "235", "5256", String.valueOf(Long.MIN_VALUE / 2), "513511");
        checkException("3", "234", "3523", String.valueOf(Long.MIN_VALUE + 1), "414141");
        checkException("3", "6234", "65425", String.valueOf(Long.MIN_VALUE), "51251");
        checkException("3", "6523", "642", "-9999999999999999999", "51351");
        checkException("3", "235", "256", "-1000000000000000000", "513511");
        checkException("3", "76352", "65", "-91875198275175984673", "121515");
        checkException("3", "65237", "65", "-895162375623957295725", "151314");

        checkException("3", "6543", "634", "5165412", String.valueOf(Integer.MIN_VALUE - 1L));
        checkException("3", "6542", "5432", "91741", String.valueOf(Long.MIN_VALUE / 2));
        checkException("3", "654", "6542", "87461824", String.valueOf(Long.MIN_VALUE + 1));
        checkException("3", "81761", "6532", "6511", String.valueOf(Long.MIN_VALUE));
        checkException("3", "851", "1525", "6514", "-9999999999999999999");
        checkException("3", "541", "6542", "654237", "-1000000000000000000");
        checkException("3", "542", "6542", "1565", "-123789098461917419856");
        checkException("3", "98275", "65423", "1254", "-765159871509752523520");

        //positive
        checkException("3", String.valueOf(Integer.MAX_VALUE + 1L), "65425", "235", "54141");
        checkException("3", String.valueOf(Long.MAX_VALUE / 2), "65425", "8724", "4141");
        checkException("3", String.valueOf(Long.MAX_VALUE - 1), "76525", "92874", "5141");
        checkException("3", String.valueOf(Long.MAX_VALUE), "3625", "65435", "512351");
        checkException("3", "9999999999999999999", "65425", "2525", "4141");
        checkException("3", "1000000000000000000", "6542", "6542", "4141");
        checkException("3", "158927359285028502895", "6542", "41", "4124");
        checkException("3", "198571948157892759385", "53412", "51415", "4141");

        checkException("3", "456", String.valueOf(Integer.MAX_VALUE + 1L), "654", "5252");
        checkException("3", "54", String.valueOf(Long.MAX_VALUE / 2), "25", "521352");
        checkException("3", "235", String.valueOf(Long.MAX_VALUE - 1), "345", "52352");
        checkException("3", "6542", String.valueOf(Long.MAX_VALUE), "6526", "5235");
        checkException("3", "6534", "9999999999999999999", "6543", "5235");
        checkException("3", "257", "1000000000000000000", "65345", "5212");
        checkException("3", "65432", "29835729856207852252", "5432", "4213");
        checkException("3", "65", "8723569283570259828956", "51653", "4121");

        checkException("3", "54235", "10000", String.valueOf(Integer.MAX_VALUE + 1L), "412131");
        checkException("3", "6542", "243451", String.valueOf(Long.MAX_VALUE / 2), "5152151");
        checkException("3", "6542", "542", String.valueOf(Long.MAX_VALUE - 1), "52532");
        checkException("3", "6542", "65", String.valueOf(Long.MAX_VALUE), "5135565");
        checkException("3", "654", "15", "9999999999999999999", "52155");
        checkException("3", "239508", "654", "1000000000000000000", "42135");
        checkException("3", "92850", "356", "2895725023094287895729", "46534");
        checkException("3", "2320004", "254", "258923795205827t9053295", "4225");

        checkException("3", "234", "5424", "6542", String.valueOf(Integer.MAX_VALUE + 1L));
        checkException("3", "5", "6542", "543", String.valueOf(Long.MAX_VALUE / 2));
        checkException("3", "25", "542", "4554", String.valueOf(Long.MAX_VALUE - 1));
        checkException("3", "565", "2589", "151", String.valueOf(Long.MAX_VALUE));
        checkException("3", "54", "6542", "5423", "9999999999999999999");
        checkException("3", "625", "6543", "414", "1000000000000000000");
        checkException("3", "235", "5425", "14871", "1987012414141241950876");
        checkException("3", "526", "52", "54312", "654311957819204867586891");

        //not a number
        checkException("3", "sjhgs", "542", "5434", "411");
        checkException("3", "jhgsd", "65424", "24", "4141");
        checkException("3", "146sdg", "623", "534", "4141");
        checkException("3", "15412gsdf", "8762", "762", "41411");
        checkException("3", "sfg64", "76546", "843", "4146189741");
        checkException("3", "hsdf424", "267", "8734", "4141");
        checkException("3", "sdf55hgfs", "8764", "8764", "97814");
        checkException("3", "hsg6542hh", "5645", "7346", "418741");

        checkException("3", "762", "jhgsf", "637", "8716414");
        checkException("3", "7653", "jhesd", "73", "4129121");
        checkException("3", "87645", "145dsgfs", "8764", "41489714");
        checkException("3", "26", "7625dh", "7645", "91741");
        checkException("3", "8765", "hd5342", "76536", "4146");
        checkException("3", "87653", "gsd654", "8763", "14124");
        checkException("3", "87653", "ss25hgs", "8764", "416");
        checkException("3", "257", "gsd4ff", "76", "4141");

        checkException("3", "132", "35", "ahsjd", "4124");
        checkException("3", "5425", "35", ",mnaf", "41412");
        checkException("3", "525", "7653", "234gs", "123");
        checkException("3", "876", "7653", "2156fsf", "651");
        checkException("3", "25", "76", "sdh22", "651");
        checkException("3", "5345", "26", "sdjh33", "412");
        checkException("3", "652", "25", "hgaf22222gsad", "465");
        checkException("3", "26", "7652", "jhgs34qsf", "14");

        checkException("3", "87652", "8243", "765", "kjhgs");
        checkException("3", "14256", "763", "87652", ",;lkjhg");
        checkException("3", "8762", "76534", "90", "16gs");
        checkException("3", "678", "37", "893", "16jhd");
        checkException("3", "87653", "8764", "83", "gsd87");
        checkException("3", "17", "764", "763", "hgs87");
        checkException("3", "765", "9874", "873", "sgh43s");
        checkException("3", "765", "23", "374", "kjhd765gll");

        //task 4
        //not enough args
        checkException("4");

        //not integer numbers
        //negative
        checkException("4", String.valueOf(Integer.MIN_VALUE - 1L));
        checkException("4", String.valueOf(Long.MIN_VALUE / 2));
        checkException("4", String.valueOf(Long.MIN_VALUE + 1));
        checkException("4", String.valueOf(Long.MIN_VALUE));
        checkException("4", "-9999999999999999999");
        checkException("4", "-1000000000000000000");
        checkException("4", "-498765789098765467891");
        checkException("4", "-1874890987654678956789");

        //positive
        checkException("4", String.valueOf(Integer.MAX_VALUE + 1L));
        checkException("4", String.valueOf(Long.MAX_VALUE / 2));
        checkException("4", String.valueOf(Long.MAX_VALUE - 1));
        checkException("4", String.valueOf(Long.MAX_VALUE));
        checkException("4", "9999999999999999999");
        checkException("4", "1000000000000000000");
        checkException("4", "3465789078546789765");
        checkException("4", "23456789076578900000076");

        //not a number
        checkException("4", "jhgafkjytsaf");
        checkException("4", "aidukjghbmn,kla;f");
        checkException("4", "141gsfasf");
        checkException("4", "165423hdgsdg");
        checkException("4", "jhgsfgh54314");
        checkException("4", "jhgfadsgh5342");
        checkException("4", "hgsdh234dg");
        checkException("4", "s4444444g");

        //task 5
        //not enough args
        checkException("5");
        checkException("5", "1");
        checkException("5", "1", "3");

        //not integer numbers
        //negative
        checkException("5", String.valueOf(Integer.MIN_VALUE - 1L), "1", "2");
        checkException("5", String.valueOf(Long.MIN_VALUE / 2), "3", "4");
        checkException("5", String.valueOf(Long.MIN_VALUE + 1), "5", "6");
        checkException("5", String.valueOf(Long.MIN_VALUE), "7", "8");
        checkException("5", "-9999999999999999999", "9", "10");
        checkException("5", "-1000000000000000000", "11", "12");
        checkException("5", "-908768907182471824719824", "1", "2");
        checkException("5", "-192857151295871256159", "3", "4");

        checkException("5", "5", String.valueOf(Integer.MIN_VALUE - 1L), "6");
        checkException("5", "7", String.valueOf(Long.MIN_VALUE / 2), "8");
        checkException("5", "1", String.valueOf(Long.MIN_VALUE + 1), "9");
        checkException("5", "2", String.valueOf(Long.MIN_VALUE), "10");
        checkException("5", "3", "-9999999999999999999", "11");
        checkException("5", "4", "-1000000000000000000", "12");
        checkException("5", "5", "-59082728902359528752", "6");
        checkException("5", "7", "-46578904123471246634", "8");

        checkException("5", "1", "9", String.valueOf(Integer.MIN_VALUE - 1L));
        checkException("5", "2", "10", String.valueOf(Long.MIN_VALUE / 2));
        checkException("5", "3", "11", String.valueOf(Long.MIN_VALUE + 1));
        checkException("5", "4", "12", String.valueOf(Long.MIN_VALUE));
        checkException("5", "5", "6", "-9999999999999999999");
        checkException("5", "7", "8", "-1000000000000000000");
        checkException("5", "1", "2", "-4938250723857208352");
        checkException("5", "3", "4", "-623526234243");

        //positive
        checkException("5", String.valueOf(Integer.MAX_VALUE + 1L), "5", "6");
        checkException("5", String.valueOf(Long.MAX_VALUE / 2), "7", "8");
        checkException("5", String.valueOf(Long.MAX_VALUE - 1), "9", "10");
        checkException("5", String.valueOf(Long.MAX_VALUE), "11", "12");
        checkException("5", "9999999999999999999", "1", "2");
        checkException("5", "1000000000000000000", "3", "4");
        checkException("5", "4289347237420875892752", "5", "6");
        checkException("5", "52", "7", "8");

        checkException("5", "1", String.valueOf(Integer.MAX_VALUE + 1L), "9");
        checkException("5", "2", String.valueOf(Long.MAX_VALUE / 2), "10");
        checkException("5", "3", String.valueOf(Long.MAX_VALUE - 1), "11");
        checkException("5", "4", String.valueOf(Long.MAX_VALUE), "12");
        checkException("5", "5", "9999999999999999999", "6");
        checkException("5", "7", "1000000000000000000", "8");
        checkException("5", "1", "9087657890789076546786", "9");
        checkException("5", "2", "317819319023718037182031", "10");

        checkException("5", "3", "11", String.valueOf(Integer.MAX_VALUE + 1L));
        checkException("5", "4", "12", String.valueOf(Long.MAX_VALUE / 2));
        checkException("5", "5", "6", String.valueOf(Long.MAX_VALUE - 1));
        checkException("5", "7", "8", String.valueOf(Long.MAX_VALUE));
        checkException("5", "1", "9", "9999999999999999999");
        checkException("5", "2", "10", "1000000000000000000");
        checkException("5", "3", "11", "9417289147981742914");
        checkException("5", "4", "12", "124816478190470127410");

        //not a number
        checkException("5", "sdfsdghdsf", "5", "6");
        checkException("5", "ytafaasf", "7", "8");
        checkException("5", "14asda", "9", "10");
        checkException("5", "1t", "11", "12");
        checkException("5", "gsdfs4", "1", "2");
        checkException("5", "ad3", "3", "4");
        checkException("5", "asfs32asf", "5", "6");
        checkException("5", "afg3raf", "7", "8");

        checkException("5", "1", "yta", "9");
        checkException("5", "2", "yhgfas", "10");
        checkException("5", "3", "13asd", "11");
        checkException("5", "4", "54asd", "12");
        checkException("5", "5", "ysadf42", "6");
        checkException("5", "7", "asd2", "8");
        checkException("5", "1", "asd32t", "9");
        checkException("5", "2", "afda31afd", "10");

        checkException("5", "3", "11", "tyuyas");
        checkException("5", "4", "12", "ytras");
        checkException("5", "5", "6", "13214asdad");
        checkException("5", "7", "8", "5424adasd");
        checkException("5", "1", "9", "hgfa131");
        checkException("5", "2", "10", "adads21341");
        checkException("5", "3", "11", "asdsf3241aca");
        checkException("5", "4", "12", "asdas3q4ad");
    }

    /**
     * Function for testing non-valid args for main.
     * Emulates input from keyboard.
     * For inputted parameters an IncorrectArgumentException or
     * NoSuchElementException should be thrown.
     * @see IncorrectArgumentException
     * @see NoSuchElementException
     * @param args strings that could be inputted from keyboard.
     */
    private void checkException(String... args) {
        try {
            StringBuilder input = new StringBuilder();
            for (String s: args) {
                input.append(s);
                input.append(lineSeparator());
            }
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            System.setOut(new PrintStream(output));
            System.setIn(new ByteArrayInputStream(input.toString().getBytes()));
            Main.main();
            fail("Exception was not thrown.");
        } catch (NoSuchElementException | IncorrectArgumentException e) {
            //correct behavior
        }
    }

    /**
     * Overrides System.in and System.out for simulating user
     * input from keyboard and console output.
     * @param input the line that the user could enter.
     * @return ByteArrayStream in which output (that should be in console) would be written.
     */
    private ByteArrayOutputStream setInAndOut(String input) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        return output;
    }
}
