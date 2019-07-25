import com.implemica.bormashenko.*;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Main class.
 *
 * @author Mykhailo Bormashenko
 * @since 1.8
 */
class MainClassTest {

    /**
     * Constant for lineSeparator.
     */
    private static final String L_S = System.lineSeparator();

    /**
     * Message while choosing task.
     */
    private static final String FIRST_MESSAGE = "Input number of task from 1 to 5." + L_S;

    /**
     * Message while task1 (swap) have been chosen.
     */
    private static final String TASK_ONE_MESSAGE = "Task 1: swap." + L_S +
            "Input 2 integer numbers." + L_S;

    /**
     * Message while task2 (house) have been chosen.
     */
    private static final String TASK_TWO_MESSAGE = "Task 2: house." + L_S +
            "Input number of floors in house, number of flats on floor and number of flat." + L_S;

    /**
     * Message while task1 (gcd) have been chosen.
     */
    private static final String TASK_THREE_MESSAGE = "Task 3: gcd." + L_S +
            "Input 4 integer numbers." + L_S;

    /**
     * Message while task1 (fibonacci) have been chosen.
     */
    private static final String TASK_FOUR_MESSAGE = "Task 4: fibonacci." + L_S +
            "Input integer number." + L_S;

    /**
     * Message while task1 (day of week) have been chosen.
     */
    private static final String TASK_FIVE_MESSAGE = "Task 5: day of week." + L_S +
            "Input day of New Year, day to find, month to find." + L_S;

    /**
     * Message while input is wrong.
     */
    private static final String WRONG_INPUT_MESSAGE = "Wrong input. Expected: integer number." + L_S;

    /**
     * Tests with non-valid args for main method.
     * Includes tests with non-valid numbers or not an integer numbers, with any other args and without.
     * Each type of tests uses its own method (with different exception messages).
     * 52 tests for non-valid number of task;
     * 48 tests for task 1;
     * 72 tests for task 2;
     * 96 tests for task 3;
     * 24 tests for task 4;
     * 92 tests for task 5 (includes 20 tests for not a enum-item);
     * 384 tests at all.
     */
    @Test
    void nonValidInputTests() {
        //non valid number of task
        //non-positive
        //without any other args
        checkErrorNotATask("0");
        checkErrorNotATask("-1");
        checkErrorNotATask(String.valueOf(Integer.MIN_VALUE / 2));
        checkErrorNotATask(String.valueOf(Integer.MIN_VALUE + 1));
        checkErrorNotATask(String.valueOf(Integer.MIN_VALUE));

        //not integer
        checkErrorNotAIntegerTask(String.valueOf(Integer.MIN_VALUE - 1L));
        checkErrorNotAIntegerTask(String.valueOf(Long.MIN_VALUE / 2));
        checkErrorNotAIntegerTask(String.valueOf(Long.MIN_VALUE + 1));
        checkErrorNotAIntegerTask(String.valueOf(Long.MIN_VALUE));
        checkErrorNotAIntegerTask("-99999999999999999999");
        checkErrorNotAIntegerTask("-10000000000000000000");
        checkErrorNotAIntegerTask("-43180758917491874141");
        checkErrorNotAIntegerTask("-1318019883091");

        //with other args
        checkErrorNotATask("0", "2", "3");
        checkErrorNotATask("-1", "62431", "2424", "1313");
        checkErrorNotATask(String.valueOf(Integer.MIN_VALUE / 2), "-513", "-6141", "-513", "-7625");
        checkErrorNotATask(String.valueOf(Integer.MIN_VALUE + 1), "adgadas");
        checkErrorNotATask(String.valueOf(Integer.MIN_VALUE), "adadad", "asdt");

        //not integer
        checkErrorNotAIntegerTask(String.valueOf(Integer.MIN_VALUE - 1L), "qweqr", "sdfsdf", "hsfsf");
        checkErrorNotAIntegerTask(String.valueOf(Long.MIN_VALUE / 2), "hsdfads", "adasd", "adad", "gfadad");
        checkErrorNotAIntegerTask(String.valueOf(Long.MIN_VALUE + 1), "12313");
        checkErrorNotAIntegerTask(String.valueOf(Long.MIN_VALUE), "1");
        checkErrorNotAIntegerTask("-99999999999999999999", "2");
        checkErrorNotAIntegerTask("-10000000000000000000", "3");
        checkErrorNotAIntegerTask("-43180758917491874141", "4");
        checkErrorNotAIntegerTask("-1318019883091", "5");

        //positive
        //without any other args
        checkErrorNotATask("6");
        checkErrorNotATask("7");
        checkErrorNotATask(String.valueOf(Integer.MAX_VALUE / 2));
        checkErrorNotATask(String.valueOf(Integer.MAX_VALUE - 1));
        checkErrorNotATask(String.valueOf(Integer.MAX_VALUE));

        //not integer
        checkErrorNotAIntegerTask(String.valueOf(Integer.MAX_VALUE + 1L));
        checkErrorNotAIntegerTask(String.valueOf(Long.MAX_VALUE / 2));
        checkErrorNotAIntegerTask(String.valueOf(Long.MAX_VALUE - 1));
        checkErrorNotAIntegerTask(String.valueOf(Long.MAX_VALUE));
        checkErrorNotAIntegerTask("99999999999999999999");
        checkErrorNotAIntegerTask("10000000000000000000");
        checkErrorNotAIntegerTask("624313265425234726");
        checkErrorNotAIntegerTask("114127988623422423091");

        //with other args
        checkErrorNotATask("6", "1");
        checkErrorNotATask("7", "2", "3");
        checkErrorNotATask(String.valueOf(Integer.MAX_VALUE / 2), "5123", "62412", "1312313");
        checkErrorNotATask(String.valueOf(Integer.MAX_VALUE - 1), "-5131", "-62342", "-6523", "-141");
        checkErrorNotATask(String.valueOf(Integer.MAX_VALUE), "unfbed");

        //not integer
        checkErrorNotAIntegerTask(String.valueOf(Integer.MAX_VALUE + 1L), "asdaea", "dasrasd");
        checkErrorNotAIntegerTask(String.valueOf(Long.MAX_VALUE / 2), "aaeada", "wdasd", "tgdaew");
        checkErrorNotAIntegerTask(String.valueOf(Long.MAX_VALUE - 1), "adsad", "gadasd", "asdaeae", "twdasda");
        checkErrorNotAIntegerTask(String.valueOf(Long.MAX_VALUE), "1");
        checkErrorNotAIntegerTask("99999999999999999999", "2");
        checkErrorNotAIntegerTask("10000000000000000000", "3");
        checkErrorNotAIntegerTask("624313265425234726", "4");
        checkErrorNotAIntegerTask("114127988623422423091", "5");

        //valid number of task
        //task 1
        //not integer numbers
        //negative
        checkErrorTask1FirstParam("1", String.valueOf(Integer.MIN_VALUE - 1L), "12341");
        checkErrorTask1FirstParam("1", String.valueOf(Long.MIN_VALUE / 2), "141");
        checkErrorTask1FirstParam("1", String.valueOf(Long.MIN_VALUE + 1), "5353");
        checkErrorTask1FirstParam("1", String.valueOf(Long.MIN_VALUE), "9867");
        checkErrorTask1FirstParam("1", "-9999999999999999999", "141414");
        checkErrorTask1FirstParam("1", "-1000000000000000000", "123141");
        checkErrorTask1FirstParam("1", "-51234142129841749174", "312");
        checkErrorTask1FirstParam("1", "-63453459827349211464", "62452");

        checkErrorTask1SecondParam("1", "12341", String.valueOf(Integer.MIN_VALUE - 1L));
        checkErrorTask1SecondParam("1", "141", String.valueOf(Long.MIN_VALUE / 2));
        checkErrorTask1SecondParam("1", "5353", String.valueOf(Long.MIN_VALUE + 1));
        checkErrorTask1SecondParam("1", "9867", String.valueOf(Long.MIN_VALUE));
        checkErrorTask1SecondParam("1", "141414", "-9999999999999999999");
        checkErrorTask1SecondParam("1", "123141", "-1000000000000000000");
        checkErrorTask1SecondParam("1", "312", "-51234142129841749174");
        checkErrorTask1SecondParam("1", "62452", "-63453459827349211464");

        //positive
        checkErrorTask1FirstParam("1", String.valueOf(Integer.MAX_VALUE + 1L), "7624");
        checkErrorTask1FirstParam("1", String.valueOf(Long.MAX_VALUE / 2), "5234");
        checkErrorTask1FirstParam("1", String.valueOf(Long.MAX_VALUE - 1), "115");
        checkErrorTask1FirstParam("1", String.valueOf(Long.MAX_VALUE), "9876");
        checkErrorTask1FirstParam("1", "9999999999999999999", "62");
        checkErrorTask1FirstParam("1", "1000000000000000000", "6524");
        checkErrorTask1FirstParam("1", "7863987656789098765678", "8765");
        checkErrorTask1FirstParam("1", "98765456787654356789", "237");

        checkErrorTask1SecondParam("1", "652", String.valueOf(Integer.MAX_VALUE + 1L));
        checkErrorTask1SecondParam("1", "87", String.valueOf(Long.MAX_VALUE / 2));
        checkErrorTask1SecondParam("1", "235", String.valueOf(Long.MAX_VALUE - 1));
        checkErrorTask1SecondParam("1", "765", String.valueOf(Long.MAX_VALUE));
        checkErrorTask1SecondParam("1", "32", "9999999999999999999");
        checkErrorTask1SecondParam("1", "76524", "1000000000000000000");
        checkErrorTask1SecondParam("1", "765", "987465755654567654");
        checkErrorTask1SecondParam("1", "2", "987654567654467876");

        //not a number
        checkErrorTask1FirstParam("1", "wedafasda", "5234");
        checkErrorTask1FirstParam("1", "adsgjsgsg", "6523");
        checkErrorTask1FirstParam("1", "1454ygfsada", "641");
        checkErrorTask1FirstParam("1", "65416gasrfs", "61");
        checkErrorTask1FirstParam("1", "hdfgsgf453525", "6213");
        checkErrorTask1FirstParam("1", "sgkj6414", "852");
        checkErrorTask1FirstParam("1", "fadfaf562sdfsdf", "975");
        checkErrorTask1FirstParam("1", "dsfsf42342gsfgs", "890");

        checkErrorTask1SecondParam("1", "72353", "jfsfgsd");
        checkErrorTask1SecondParam("1", "73573", "jdgfs");
        checkErrorTask1SecondParam("1", "1514", "156hdgdgd");
        checkErrorTask1SecondParam("1", "62342", "625ddgsf");
        checkErrorTask1SecondParam("1", "6243", "gsfsf652");
        checkErrorTask1SecondParam("1", "14", "hsfsdf645");
        checkErrorTask1SecondParam("1", "5", "hdfgsf635dgdfg");
        checkErrorTask1SecondParam("1", "62342", "hdsfej735sfgsfs");

        //task 2
        //not integer numbers
        //negative
        checkErrorTask2FirstParam("2", String.valueOf(Integer.MIN_VALUE - 1L), "4131", "151");
        checkErrorTask2FirstParam("2", String.valueOf(Long.MIN_VALUE / 2), "141", "51231");
        checkErrorTask2FirstParam("2", String.valueOf(Long.MIN_VALUE + 1), "23", "51431");
        checkErrorTask2FirstParam("2", String.valueOf(Long.MIN_VALUE), "5161", "512341");
        checkErrorTask2FirstParam("2", "-9999999999999999999", "654", "41241");
        checkErrorTask2FirstParam("2", "-1000000000000000000", "624", "5114");
        checkErrorTask2FirstParam("2", "-65213426523523521425", "4", "511");
        checkErrorTask2FirstParam("2", "-635272342426234523623", "654", "124");

        checkErrorTask2SecondParam("2", "5124", String.valueOf(Integer.MIN_VALUE - 1L), "13131");
        checkErrorTask2SecondParam("2", "652", String.valueOf(Long.MIN_VALUE / 2), "13141");
        checkErrorTask2SecondParam("2", "151", String.valueOf(Long.MIN_VALUE + 1), "12314");
        checkErrorTask2SecondParam("2", "145", String.valueOf(Long.MIN_VALUE), "4131");
        checkErrorTask2SecondParam("2", "642", "-9999999999999999999", "421232");
        checkErrorTask2SecondParam("2", "124", "-1000000000000000000", "143124");
        checkErrorTask2SecondParam("2", "734", "-652411252235253252", "5124");
        checkErrorTask2SecondParam("2", "124", "-12315616234892563", "41151");

        checkErrorTask2ThirdParam("2", "1251", "541", String.valueOf(Integer.MIN_VALUE - 1L));
        checkErrorTask2ThirdParam("2", "624", "356", String.valueOf(Long.MIN_VALUE / 2));
        checkErrorTask2ThirdParam("2", "33", "234", String.valueOf(Long.MIN_VALUE + 1));
        checkErrorTask2ThirdParam("2", "624", "54", String.valueOf(Long.MIN_VALUE));
        checkErrorTask2ThirdParam("2", "141", "2", "-9999999999999999999");
        checkErrorTask2ThirdParam("2", "51", "425", "-1000000000000000000");
        checkErrorTask2ThirdParam("2", "765", "63", "-97663523423525267245");
        checkErrorTask2ThirdParam("2", "14", "4", "-98763452634526252525");

        //positive
        checkErrorTask2FirstParam("2", String.valueOf(Integer.MAX_VALUE + 1L), "1414", "131");
        checkErrorTask2FirstParam("2", String.valueOf(Long.MAX_VALUE / 2), "524", "1414");
        checkErrorTask2FirstParam("2", String.valueOf(Long.MAX_VALUE - 1), "345", "5141");
        checkErrorTask2FirstParam("2", String.valueOf(Long.MAX_VALUE), "65", "5141");
        checkErrorTask2FirstParam("2", "9999999999999999999", "341", "23");
        checkErrorTask2FirstParam("2", "1000000000000000000", "245", "3");
        checkErrorTask2FirstParam("2", "125267654765476543", "65", "42");
        checkErrorTask2FirstParam("2", "232527654876542348765", "234", "1414");

        checkErrorTask2SecondParam("2", "412", String.valueOf(Integer.MAX_VALUE + 1L), "14124");
        checkErrorTask2SecondParam("2", "4234", String.valueOf(Long.MAX_VALUE / 2), "513421");
        checkErrorTask2SecondParam("2", "35", String.valueOf(Long.MAX_VALUE - 1), "514141");
        checkErrorTask2SecondParam("2", "14", String.valueOf(Long.MAX_VALUE), "511");
        checkErrorTask2SecondParam("2", "64", "9999999999999999999", "414");
        checkErrorTask2SecondParam("2", "124", "1000000000000000000", "412");
        checkErrorTask2SecondParam("2", "652", "654643636622222565436", "142");
        checkErrorTask2SecondParam("2", "6", "2652376545654264643636", "4224");

        checkErrorTask2ThirdParam("2", "654", "54", String.valueOf(Integer.MAX_VALUE + 1L));
        checkErrorTask2ThirdParam("2", "34", "243", String.valueOf(Long.MAX_VALUE / 2));
        checkErrorTask2ThirdParam("2", "5", "23", String.valueOf(Long.MAX_VALUE - 1));
        checkErrorTask2ThirdParam("2", "245", "3", String.valueOf(Long.MAX_VALUE));
        checkErrorTask2ThirdParam("2", "543", "54", "9999999999999999999");
        checkErrorTask2ThirdParam("2", "54", "54", "1000000000000000000");
        checkErrorTask2ThirdParam("2", "45", "24", "76542765236723567363");
        checkErrorTask2ThirdParam("2", "234", "62", "927592856295295872983");

        //not a number
        checkErrorTask2FirstParam("2", "hkjhgar", "43", "51341");
        checkErrorTask2FirstParam("2", "uytradfghj", "62", "51342");
        checkErrorTask2FirstParam("2", "1456sdgkysf", "623", "52352");
        checkErrorTask2FirstParam("2", "1526765fdgsafsf", "7653", "52352");
        checkErrorTask2FirstParam("2", "sgdmy532", "43", "523452");
        checkErrorTask2FirstParam("2", "ytrf43", "852", "2356");
        checkErrorTask2FirstParam("2", "a4a", "62", "32");
        checkErrorTask2FirstParam("2", "asyy5265rkj", "43", "234");

        checkErrorTask2SecondParam("2", "234", "shjktws", "414");
        checkErrorTask2SecondParam("2", "625", "uyterr", "1241");
        checkErrorTask2SecondParam("2", "24", "246we", "411");
        checkErrorTask2SecondParam("2", "34", "436yy", "411");
        checkErrorTask2SecondParam("2", "15", "adsfg543", "4111");
        checkErrorTask2SecondParam("2", "43", "asdf54", "4141");
        checkErrorTask2SecondParam("2", "65", "agbn52adg", "41241");
        checkErrorTask2SecondParam("2", "654", "jhgf432f", "214");

        checkErrorTask2ThirdParam("2", "514", "654", "sgh");
        checkErrorTask2ThirdParam("2", "34", "34", "uytrf");
        checkErrorTask2ThirdParam("2", "14", "324", "4152hgf");
        checkErrorTask2ThirdParam("2", "54", "53", "7654jhg");
        checkErrorTask2ThirdParam("2", "423", "12", "adfg543");
        checkErrorTask2ThirdParam("2", "24", "65", "atyjk54");
        checkErrorTask2ThirdParam("2", "65", "23", "ashd43rfg");
        checkErrorTask2ThirdParam("2", "23", "152", "hgf456y");

        //task 3
        //not integer numbers
        //negative
        checkErrorTask3FirstParam("3", String.valueOf(Integer.MIN_VALUE - 1L), "124", "154", "414");
        checkErrorTask3FirstParam("3", String.valueOf(Long.MIN_VALUE / 2), "124", "65", "4124");
        checkErrorTask3FirstParam("3", String.valueOf(Long.MIN_VALUE + 1), "14", "65", "4141");
        checkErrorTask3FirstParam("3", String.valueOf(Long.MIN_VALUE), "124", "141", "4141");
        checkErrorTask3FirstParam("3", "-9999999999999999999", "65", "513", "4123");
        checkErrorTask3FirstParam("3", "-1000000000000000000", "12", "65", "4141");
        checkErrorTask3FirstParam("3", "-65416765432126876541", "65", "124", "41241");
        checkErrorTask3FirstParam("3", "-98141741274814965189", "124", "5132", "4124");

        checkErrorTask3SecondParam("3", "6534", String.valueOf(Integer.MIN_VALUE - 1L), "15612", "1513");
        checkErrorTask3SecondParam("3", "65252", String.valueOf(Long.MIN_VALUE / 2), "65175", "52352");
        checkErrorTask3SecondParam("3", "76517", String.valueOf(Long.MIN_VALUE + 1), "65422", "41342");
        checkErrorTask3SecondParam("3", "61375", String.valueOf(Long.MIN_VALUE), "12561", "42145");
        checkErrorTask3SecondParam("3", "129587", "-9999999999999999999", "763214", "42352");
        checkErrorTask3SecondParam("3", "62365", "-1000000000000000000", "914872", "5252");
        checkErrorTask3SecondParam("3", "9725", "-1452357295820582055", "51", "5235");
        checkErrorTask3SecondParam("3", "6237", "-6235235987015135151", "51561", "41241");

        checkErrorTask3ThirdParam("3", "265", "65141", String.valueOf(Integer.MIN_VALUE - 1L), "14141");
        checkErrorTask3ThirdParam("3", "235", "5256", String.valueOf(Long.MIN_VALUE / 2), "513511");
        checkErrorTask3ThirdParam("3", "234", "3523", String.valueOf(Long.MIN_VALUE + 1), "414141");
        checkErrorTask3ThirdParam("3", "6234", "65425", String.valueOf(Long.MIN_VALUE), "51251");
        checkErrorTask3ThirdParam("3", "6523", "642", "-9999999999999999999", "51351");
        checkErrorTask3ThirdParam("3", "235", "256", "-1000000000000000000", "513511");
        checkErrorTask3ThirdParam("3", "76352", "65", "-91875198275175984673", "121515");
        checkErrorTask3ThirdParam("3", "65237", "65", "-895162375623957295725", "151314");

        checkErrorTask3FourthParam("3", "6543", "634", "5165412", String.valueOf(Integer.MIN_VALUE - 1L));
        checkErrorTask3FourthParam("3", "6542", "5432", "91741", String.valueOf(Long.MIN_VALUE / 2));
        checkErrorTask3FourthParam("3", "654", "6542", "87461824", String.valueOf(Long.MIN_VALUE + 1));
        checkErrorTask3FourthParam("3", "81761", "6532", "6511", String.valueOf(Long.MIN_VALUE));
        checkErrorTask3FourthParam("3", "851", "1525", "6514", "-9999999999999999999");
        checkErrorTask3FourthParam("3", "541", "6542", "654237", "-1000000000000000000");
        checkErrorTask3FourthParam("3", "542", "6542", "1565", "-123789098461917419856");
        checkErrorTask3FourthParam("3", "98275", "65423", "1254", "-765159871509752523520");

        //positive
        checkErrorTask3FirstParam("3", String.valueOf(Integer.MAX_VALUE + 1L), "65425", "235", "54141");
        checkErrorTask3FirstParam("3", String.valueOf(Long.MAX_VALUE / 2), "65425", "8724", "4141");
        checkErrorTask3FirstParam("3", String.valueOf(Long.MAX_VALUE - 1), "76525", "92874", "5141");
        checkErrorTask3FirstParam("3", String.valueOf(Long.MAX_VALUE), "3625", "65435", "512351");
        checkErrorTask3FirstParam("3", "9999999999999999999", "65425", "2525", "4141");
        checkErrorTask3FirstParam("3", "1000000000000000000", "6542", "6542", "4141");
        checkErrorTask3FirstParam("3", "158927359285028502895", "6542", "41", "4124");
        checkErrorTask3FirstParam("3", "198571948157892759385", "53412", "51415", "4141");

        checkErrorTask3SecondParam("3", "456", String.valueOf(Integer.MAX_VALUE + 1L), "654", "5252");
        checkErrorTask3SecondParam("3", "54", String.valueOf(Long.MAX_VALUE / 2), "25", "521352");
        checkErrorTask3SecondParam("3", "235", String.valueOf(Long.MAX_VALUE - 1), "345", "52352");
        checkErrorTask3SecondParam("3", "6542", String.valueOf(Long.MAX_VALUE), "6526", "5235");
        checkErrorTask3SecondParam("3", "6534", "9999999999999999999", "6543", "5235");
        checkErrorTask3SecondParam("3", "257", "1000000000000000000", "65345", "5212");
        checkErrorTask3SecondParam("3", "65432", "29835729856207852252", "5432", "4213");
        checkErrorTask3SecondParam("3", "65", "8723569283570259828956", "51653", "4121");

        checkErrorTask3ThirdParam("3", "54235", "10000", String.valueOf(Integer.MAX_VALUE + 1L), "412131");
        checkErrorTask3ThirdParam("3", "6542", "243451", String.valueOf(Long.MAX_VALUE / 2), "5152151");
        checkErrorTask3ThirdParam("3", "6542", "542", String.valueOf(Long.MAX_VALUE - 1), "52532");
        checkErrorTask3ThirdParam("3", "6542", "65", String.valueOf(Long.MAX_VALUE), "5135565");
        checkErrorTask3ThirdParam("3", "654", "15", "9999999999999999999", "52155");
        checkErrorTask3ThirdParam("3", "239508", "654", "1000000000000000000", "42135");
        checkErrorTask3ThirdParam("3", "92850", "356", "2895725023094287895729", "46534");
        checkErrorTask3ThirdParam("3", "2320004", "254", "258923795205827t9053295", "4225");

        checkErrorTask3FourthParam("3", "234", "5424", "6542", String.valueOf(Integer.MAX_VALUE + 1L));
        checkErrorTask3FourthParam("3", "5", "6542", "543", String.valueOf(Long.MAX_VALUE / 2));
        checkErrorTask3FourthParam("3", "25", "542", "4554", String.valueOf(Long.MAX_VALUE - 1));
        checkErrorTask3FourthParam("3", "565", "2589", "151", String.valueOf(Long.MAX_VALUE));
        checkErrorTask3FourthParam("3", "54", "6542", "5423", "9999999999999999999");
        checkErrorTask3FourthParam("3", "625", "6543", "414", "1000000000000000000");
        checkErrorTask3FourthParam("3", "235", "5425", "14871", "1987012414141241950876");
        checkErrorTask3FourthParam("3", "526", "52", "54312", "654311957819204867586891");

        //not a number
        checkErrorTask3FirstParam("3", "sjhgs", "542", "5434", "411");
        checkErrorTask3FirstParam("3", "jhgsd", "65424", "24", "4141");
        checkErrorTask3FirstParam("3", "146sdg", "623", "534", "4141");
        checkErrorTask3FirstParam("3", "15412gsdf", "8762", "762", "41411");
        checkErrorTask3FirstParam("3", "sfg64", "76546", "843", "4146189741");
        checkErrorTask3FirstParam("3", "hsdf424", "267", "8734", "4141");
        checkErrorTask3FirstParam("3", "sdf55hgfs", "8764", "8764", "97814");
        checkErrorTask3FirstParam("3", "hsg6542hh", "5645", "7346", "418741");

        checkErrorTask3SecondParam("3", "762", "jhgsf", "637", "8716414");
        checkErrorTask3SecondParam("3", "7653", "jhesd", "73", "4129121");
        checkErrorTask3SecondParam("3", "87645", "145dsgfs", "8764", "41489714");
        checkErrorTask3SecondParam("3", "26", "7625dh", "7645", "91741");
        checkErrorTask3SecondParam("3", "8765", "hd5342", "76536", "4146");
        checkErrorTask3SecondParam("3", "87653", "gsd654", "8763", "14124");
        checkErrorTask3SecondParam("3", "87653", "ss25hgs", "8764", "416");
        checkErrorTask3SecondParam("3", "257", "gsd4ff", "76", "4141");

        checkErrorTask3ThirdParam("3", "132", "35", "ahsjd", "4124");
        checkErrorTask3ThirdParam("3", "5425", "35", ",mnaf", "41412");
        checkErrorTask3ThirdParam("3", "525", "7653", "234gs", "123");
        checkErrorTask3ThirdParam("3", "876", "7653", "2156fsf", "651");
        checkErrorTask3ThirdParam("3", "25", "76", "sdh22", "651");
        checkErrorTask3ThirdParam("3", "5345", "26", "sdjh33", "412");
        checkErrorTask3ThirdParam("3", "652", "25", "hgaf22222gsad", "465");
        checkErrorTask3ThirdParam("3", "26", "7652", "jhgs34qsf", "14");

        checkErrorTask3FourthParam("3", "87652", "8243", "765", "kjhgs");
        checkErrorTask3FourthParam("3", "14256", "763", "87652", ",;lkjhg");
        checkErrorTask3FourthParam("3", "8762", "76534", "90", "16gs");
        checkErrorTask3FourthParam("3", "678", "37", "893", "16jhd");
        checkErrorTask3FourthParam("3", "87653", "8764", "83", "gsd87");
        checkErrorTask3FourthParam("3", "17", "764", "763", "hgs87");
        checkErrorTask3FourthParam("3", "765", "9874", "873", "sgh43s");
        checkErrorTask3FourthParam("3", "765", "23", "374", "kjhd765gll");

        //task 4
        //not integer numbers
        //negative
        checkErrorTask4("4", String.valueOf(Integer.MIN_VALUE - 1L));
        checkErrorTask4("4", String.valueOf(Long.MIN_VALUE / 2));
        checkErrorTask4("4", String.valueOf(Long.MIN_VALUE + 1));
        checkErrorTask4("4", String.valueOf(Long.MIN_VALUE));
        checkErrorTask4("4", "-9999999999999999999");
        checkErrorTask4("4", "-1000000000000000000");
        checkErrorTask4("4", "-498765789098765467891");
        checkErrorTask4("4", "-1874890987654678956789");

        //positive
        checkErrorTask4("4", String.valueOf(Integer.MAX_VALUE + 1L));
        checkErrorTask4("4", String.valueOf(Long.MAX_VALUE / 2));
        checkErrorTask4("4", String.valueOf(Long.MAX_VALUE - 1));
        checkErrorTask4("4", String.valueOf(Long.MAX_VALUE));
        checkErrorTask4("4", "9999999999999999999");
        checkErrorTask4("4", "1000000000000000000");
        checkErrorTask4("4", "3465789078546789765");
        checkErrorTask4("4", "23456789076578900000076");

        //not a number
        checkErrorTask4("4", "jhgafkjytsaf");
        checkErrorTask4("4", "aidukjghbmn,kla;f");
        checkErrorTask4("4", "141gsfasf");
        checkErrorTask4("4", "165423hdgsdg");
        checkErrorTask4("4", "jhgsfgh54314");
        checkErrorTask4("4", "jhgfadsgh5342");
        checkErrorTask4("4", "hgsdh234dg");
        checkErrorTask4("4", "s4444444g");

        //task 5
        //not integer numbers
        //negative
        checkErrorTask5FirstParam("5", String.valueOf(Integer.MIN_VALUE - 1L), "1", "2");
        checkErrorTask5FirstParam("5", String.valueOf(Long.MIN_VALUE / 2), "3", "4");
        checkErrorTask5FirstParam("5", String.valueOf(Long.MIN_VALUE + 1), "5", "6");
        checkErrorTask5FirstParam("5", String.valueOf(Long.MIN_VALUE), "7", "8");
        checkErrorTask5FirstParam("5", "-9999999999999999999", "9", "10");
        checkErrorTask5FirstParam("5", "-1000000000000000000", "11", "12");
        checkErrorTask5FirstParam("5", "-908768907182471824719824", "1", "2");
        checkErrorTask5FirstParam("5", "-192857151295871256159", "3", "4");

        checkErrorTask5SecondParam("5", "5", String.valueOf(Integer.MIN_VALUE - 1L), "6");
        checkErrorTask5SecondParam("5", "7", String.valueOf(Long.MIN_VALUE / 2), "8");
        checkErrorTask5SecondParam("5", "1", String.valueOf(Long.MIN_VALUE + 1), "9");
        checkErrorTask5SecondParam("5", "2", String.valueOf(Long.MIN_VALUE), "10");
        checkErrorTask5SecondParam("5", "3", "-9999999999999999999", "11");
        checkErrorTask5SecondParam("5", "4", "-1000000000000000000", "12");
        checkErrorTask5SecondParam("5", "5", "-59082728902359528752", "6");
        checkErrorTask5SecondParam("5", "7", "-46578904123471246634", "8");

        checkErrorTask5ThirdParam("5", "1", "9", String.valueOf(Integer.MIN_VALUE - 1L));
        checkErrorTask5ThirdParam("5", "2", "10", String.valueOf(Long.MIN_VALUE / 2));
        checkErrorTask5ThirdParam("5", "3", "11", String.valueOf(Long.MIN_VALUE + 1));
        checkErrorTask5ThirdParam("5", "4", "12", String.valueOf(Long.MIN_VALUE));
        checkErrorTask5ThirdParam("5", "5", "6", "-9999999999999999999");
        checkErrorTask5ThirdParam("5", "7", "8", "-1000000000000000000");
        checkErrorTask5ThirdParam("5", "1", "2", "-4938250723857208352");
        checkErrorTask5ThirdParam("5", "3", "4", "-623526234243");

        //positive
        checkErrorTask5FirstParam("5", String.valueOf(Integer.MAX_VALUE + 1L), "5", "6");
        checkErrorTask5FirstParam("5", String.valueOf(Long.MAX_VALUE / 2), "7", "8");
        checkErrorTask5FirstParam("5", String.valueOf(Long.MAX_VALUE - 1), "9", "10");
        checkErrorTask5FirstParam("5", String.valueOf(Long.MAX_VALUE), "11", "12");
        checkErrorTask5FirstParam("5", "9999999999999999999", "1", "2");
        checkErrorTask5FirstParam("5", "1000000000000000000", "3", "4");
        checkErrorTask5FirstParam("5", "4289347237420875892752", "5", "6");
        checkErrorTask5FirstParam("5", "562674643636346363636362", "7", "8");

        checkErrorTask5SecondParam("5", "1", String.valueOf(Integer.MAX_VALUE + 1L), "9");
        checkErrorTask5SecondParam("5", "2", String.valueOf(Long.MAX_VALUE / 2), "10");
        checkErrorTask5SecondParam("5", "3", String.valueOf(Long.MAX_VALUE - 1), "11");
        checkErrorTask5SecondParam("5", "4", String.valueOf(Long.MAX_VALUE), "12");
        checkErrorTask5SecondParam("5", "5", "9999999999999999999", "6");
        checkErrorTask5SecondParam("5", "7", "1000000000000000000", "8");
        checkErrorTask5SecondParam("5", "1", "9087657890789076546786", "9");
        checkErrorTask5SecondParam("5", "2", "317819319023718037182031", "10");

        checkErrorTask5ThirdParam("5", "3", "11", String.valueOf(Integer.MAX_VALUE + 1L));
        checkErrorTask5ThirdParam("5", "4", "12", String.valueOf(Long.MAX_VALUE / 2));
        checkErrorTask5ThirdParam("5", "5", "6", String.valueOf(Long.MAX_VALUE - 1));
        checkErrorTask5ThirdParam("5", "7", "8", String.valueOf(Long.MAX_VALUE));
        checkErrorTask5ThirdParam("5", "1", "9", "9999999999999999999");
        checkErrorTask5ThirdParam("5", "2", "10", "1000000000000000000");
        checkErrorTask5ThirdParam("5", "3", "11", "9417289147981742914");
        checkErrorTask5ThirdParam("5", "4", "12", "124816478190470127410");

        //not a number
        checkErrorTask5FirstParam("5", "sdfsdghdsf", "5", "6");
        checkErrorTask5FirstParam("5", "ytafaasf", "7", "8");
        checkErrorTask5FirstParam("5", "14asda", "9", "10");
        checkErrorTask5FirstParam("5", "1t", "11", "12");
        checkErrorTask5FirstParam("5", "gsdfs4", "1", "2");
        checkErrorTask5FirstParam("5", "ad3", "3", "4");
        checkErrorTask5FirstParam("5", "asfs32asf", "5", "6");
        checkErrorTask5FirstParam("5", "afg3raf", "7", "8");

        checkErrorTask5SecondParam("5", "1", "yta", "9");
        checkErrorTask5SecondParam("5", "2", "yhgfas", "10");
        checkErrorTask5SecondParam("5", "3", "13asd", "11");
        checkErrorTask5SecondParam("5", "4", "54asd", "12");
        checkErrorTask5SecondParam("5", "5", "ysadf42", "6");
        checkErrorTask5SecondParam("5", "7", "asd2", "8");
        checkErrorTask5SecondParam("5", "1", "asd32t", "9");
        checkErrorTask5SecondParam("5", "2", "afda31afd", "10");

        checkErrorTask5ThirdParam("5", "3", "11", "tyuyas");
        checkErrorTask5ThirdParam("5", "4", "12", "ytras");
        checkErrorTask5ThirdParam("5", "5", "6", "13214asdad");
        checkErrorTask5ThirdParam("5", "7", "8", "5424adasd");
        checkErrorTask5ThirdParam("5", "1", "9", "hgfa131");
        checkErrorTask5ThirdParam("5", "2", "10", "adads21341");
        checkErrorTask5ThirdParam("5", "3", "11", "asdsf3241aca");
        checkErrorTask5ThirdParam("5", "4", "12", "asdas3q4ad");

        //ArrayIndexOfBoundException
        //for day of week
        checkErrorTask5ArrayBoundException("5", "0", "1", "2");
        checkErrorTask5ArrayBoundException("5", "-1", "3", "4");
        checkErrorTask5ArrayBoundException("5", String.valueOf(Integer.MIN_VALUE / 2), "5", "6");
        checkErrorTask5ArrayBoundException("5", String.valueOf(Integer.MIN_VALUE + 1), "7", "8");
        checkErrorTask5ArrayBoundException("5", String.valueOf(Integer.MIN_VALUE), "9", "10");

        checkErrorTask5ArrayBoundException("5", "8", "9", "10");
        checkErrorTask5ArrayBoundException("5", "9", "11", "12");
        checkErrorTask5ArrayBoundException("5", String.valueOf(Integer.MAX_VALUE / 2), "1", "2");
        checkErrorTask5ArrayBoundException("5", String.valueOf(Integer.MAX_VALUE - 1), "3", "4");
        checkErrorTask5ArrayBoundException("5", String.valueOf(Integer.MAX_VALUE), "5", "6");

        //for month
        checkErrorTask5ArrayBoundException("5", "5", "6", "0");
        checkErrorTask5ArrayBoundException("5", "7", "1", "-1");
        checkErrorTask5ArrayBoundException("5", "2", "3", String.valueOf(Integer.MIN_VALUE / 2));
        checkErrorTask5ArrayBoundException("5", "4", "5", String.valueOf(Integer.MIN_VALUE + 1));
        checkErrorTask5ArrayBoundException("5", "6", "7", String.valueOf(Integer.MIN_VALUE));

        checkErrorTask5ArrayBoundException("5", "4", "5", "13");
        checkErrorTask5ArrayBoundException("5", "6", "7", "14");
        checkErrorTask5ArrayBoundException("5", "1", "2", String.valueOf(Integer.MAX_VALUE / 2));
        checkErrorTask5ArrayBoundException("5", "3", "4", String.valueOf(Integer.MAX_VALUE - 1));
        checkErrorTask5ArrayBoundException("5", "5", "6", String.valueOf(Integer.MAX_VALUE));
    }

    /**
     * Method for testing non-valid integer parameter for number of task.
     *
     * @param args parameters to set in System.In. First parameter should be non-valid.
     */
    private void checkErrorNotATask(String... args) {
        String expected = FIRST_MESSAGE +
                "Wrong input. Expected: number of task from 1 to 5." + L_S +
                "Got: " + args[0] + " number of task" + L_S;
        runMain(expected, args);
    }

    /**
     * Method for testing non-valid not integer parameter for number of task.
     *
     * @param args parameters to set in System.In. First parameter should not be an integer.
     */
    private void checkErrorNotAIntegerTask(String... args) {
        String expected = FIRST_MESSAGE + WRONG_INPUT_MESSAGE +
                "Got: For input string: \"" + args[0] + "\"" + L_S;
        runMain(expected, args);
    }

    /**
     * Method for testing non-valid first parameter for task 1 (swap).
     *
     * @param args parameters to set in System.In. Second parameter should be non-valid for task 1.
     *             First parameter should be "1".
     */
    private void checkErrorTask1FirstParam(String... args) {
        String expected = FIRST_MESSAGE + TASK_ONE_MESSAGE + WRONG_INPUT_MESSAGE +
                "Got: For input string: \"" + args[1] + "\"" + L_S;
        runMain(expected, args);
    }

    /**
     * Method for testing non-valid second parameter for task 1 (swap).
     *
     * @param args parameters to set in System.In. Third parameter should be non-valid for task 1.
     *             Previous parameter should be valid for task 1. First parameter should be "1".
     */
    private void checkErrorTask1SecondParam(String... args) {
        String expected = FIRST_MESSAGE + TASK_ONE_MESSAGE + WRONG_INPUT_MESSAGE +
                "Got: For input string: \"" + args[2] + "\"" + L_S;
        runMain(expected, args);
    }

    /**
     * Method for testing non-valid first parameter for task 2 (house).
     *
     * @param args parameters to set in System.In. Second parameter should be non-valid for task 2.
     *             First parameter should be "2".
     */
    private void checkErrorTask2FirstParam(String... args) {
        String expected = FIRST_MESSAGE + TASK_TWO_MESSAGE + WRONG_INPUT_MESSAGE +
                "Got: For input string: \"" + args[1] + "\"" + L_S;
        runMain(expected, args);
    }

    /**
     * Method for testing non-valid second parameter for task 2 (house).
     *
     * @param args parameters to set in System.In. Third parameter should be non-valid for task 2.
     *             Previous parameter should be valid for task 2. First parameter should be "2".
     */
    private void checkErrorTask2SecondParam(String... args) {
        String expected = FIRST_MESSAGE + TASK_TWO_MESSAGE + WRONG_INPUT_MESSAGE +
                "Got: For input string: \"" + args[2] + "\"" + L_S;
        runMain(expected, args);
    }

    /**
     * Method for testing non-valid third parameter for task 2 (house).
     *
     * @param args parameters to set in System.In. Fourth parameter should be non-valid for task 2.
     *             Previous parameters should be valid for task 2. First parameter should be "2".
     */
    private void checkErrorTask2ThirdParam(String... args) {
        String expected = FIRST_MESSAGE + TASK_TWO_MESSAGE + WRONG_INPUT_MESSAGE +
                "Got: For input string: \"" + args[3] + "\"" + L_S;
        runMain(expected, args);
    }

    /**
     * Method for testing non-valid first parameter for task 3 (gcd).
     *
     * @param args parameters to set in System.In. Second parameter should be non-valid for task 3.
     *             First parameter should be "3".
     */
    private void checkErrorTask3FirstParam(String... args) {
        String expected = FIRST_MESSAGE + TASK_THREE_MESSAGE + WRONG_INPUT_MESSAGE +
                "Got: For input string: \"" + args[1] + "\"" + L_S;
        runMain(expected, args);
    }

    /**
     * Method for testing non-valid second parameter for task 3 (gcd).
     *
     * @param args parameters to set in System.In. Third parameter should be non-valid for task 3.
     *             Previous parameter should be valid for task 3. First parameter should be "3".
     */
    private void checkErrorTask3SecondParam(String... args) {
        String expected = FIRST_MESSAGE + TASK_THREE_MESSAGE + WRONG_INPUT_MESSAGE +
                "Got: For input string: \"" + args[2] + "\"" + L_S;
        runMain(expected, args);
    }

    /**
     * Method for testing non-valid third parameter for task 3 (gcd).
     *
     * @param args parameters to set in System.In. Fourth parameter should be non-valid for task 3.
     *             Previous parameters should be valid for task 3. First parameter should be "3".
     */
    private void checkErrorTask3ThirdParam(String... args) {
        String expected = FIRST_MESSAGE + TASK_THREE_MESSAGE + WRONG_INPUT_MESSAGE +
                "Got: For input string: \"" + args[3] + "\"" + L_S;
        runMain(expected, args);
    }

    /**
     * Method for testing non-valid fourth parameter for task 3 (gcd).
     *
     * @param args parameters to set in System.In. Fifth parameter should be non-valid for task 3.
     *             Previous parameters should be valid for task 3. First parameter should be "3".
     */
    private void checkErrorTask3FourthParam(String... args) {
        String expected = FIRST_MESSAGE + TASK_THREE_MESSAGE + WRONG_INPUT_MESSAGE +
                "Got: For input string: \"" + args[4] + "\"" + L_S;
        runMain(expected, args);
    }

    /**
     * Method for testing non-valid first parameter for task 4 (fibonacci).
     *
     * @param args parameters to set in System.In. Second parameter should be non-valid for task 4.
     *             First parameter should be "4".
     */
    private void checkErrorTask4(String... args) {
        String expected = FIRST_MESSAGE + TASK_FOUR_MESSAGE + WRONG_INPUT_MESSAGE +
                "Got: For input string: \"" + args[1] + "\"" + L_S;
        runMain(expected, args);
    }

    /**
     * Method for testing non-valid first parameter for task 5 (day of week).
     *
     * @param args parameters to set in System.In. Second parameter should be non-valid for task 5.
     *             First parameter should be "5".
     */
    private void checkErrorTask5FirstParam(String... args) {
        String expected = FIRST_MESSAGE + TASK_FIVE_MESSAGE + WRONG_INPUT_MESSAGE +
                "Got: For input string: \"" + args[1] + "\"" + L_S;
        runMain(expected, args);
    }

    /**
     * Method for testing non-valid second parameter for task 5 (day of week).
     *
     * @param args parameters to set in System.In. Third parameter should be non-valid for task 5.
     *             Previous parameter should be valid for task 5. First parameter should be "5".
     */
    private void checkErrorTask5SecondParam(String... args) {
        String expected = FIRST_MESSAGE + TASK_FIVE_MESSAGE + WRONG_INPUT_MESSAGE +
                "Got: For input string: \"" + args[2] + "\"" + L_S;
        runMain(expected, args);
    }

    /**
     * Method for testing non-valid third parameter for task 5 (day of week).
     *
     * @param args parameters to set in System.In. Fourth parameter should be non-valid for task 5.
     *             Previous parameters should be valid for task 5. First parameter should be "5".
     */
    private void checkErrorTask5ThirdParam(String... args) {
        String expected = FIRST_MESSAGE + TASK_FIVE_MESSAGE + WRONG_INPUT_MESSAGE +
                "Got: For input string: \"" + args[3] + "\"" + L_S;
        runMain(expected, args);
    }

    /**
     * Method for testing non-valid first and second parameter for task 5 (day of week).
     *
     * @param args parameters to set in System.In.  Second and third parameters (in pair) should be
     *             non-valid for task 5. First parameter should be "5".
     */
    private void checkErrorTask5ArrayBoundException(String... args) {
        String expected = FIRST_MESSAGE + TASK_FIVE_MESSAGE +
                "Wrong input. Expected: day of week of New Year from 1 to 7, month from 1 to 12." + L_S +
                "Got: " + args[1] + " day of week of New Year, " + args[3] + " month" + L_S;
        runMain(expected, args);
    }


    /**
     * Runs main method with args in System.In and checks if
     * the expected string is the same as in System.Out.
     *
     * @param expected string to compare with System.Out.
     * @param args     parameters to put into System.In.
     */
    private void runMain(String expected, String... args) {
        StringBuilder input = new StringBuilder();

        for (String s : args) {
            input.append(s);
            input.append(" ");
        }
        input.deleteCharAt(input.length() - 1);

        ByteArrayOutputStream output = setInAndOut(input.toString());
        Main.main();
        assertEquals(expected, output.toString());
    }

    /**
     * Overrides System.in and System.out.
     *
     * @param input string that should be converted to System.in.
     * @return System.out that should be converted to ByteArrayOutputStream.
     */
    private ByteArrayOutputStream setInAndOut(String input) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        return output;
    }
}
