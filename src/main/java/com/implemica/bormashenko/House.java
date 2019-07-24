package com.implemica.bormashenko;

/**
 * This class allows user to find number of floor
 * and house by number of flat.
 *
 * @author Mykhailo Bormashenko
 * @since 1.8
 */
public class House {

    /**
     * Number of floors in house in which the search flat located.
     */
    private int floorsInHouse;

    /**
     * Number of flats on floor in house in which the search flat located.
     */
    private int flatsOnFloor;

    /**
     * Number of flat to find.
     */
    private int flat;

    /**
     * Number of house in which search flat is located.
     */
    private int house;

    /**
     * Number of floor on which search flat is located.
     */
    private int floor;

    /**
     * Constructor with parameters that defines house.
     *
     * @param floorsInHouse number of floors in house.
     * @param flatsOnFloor  number of flats on floor.
     * @throws IncorrectArgumentException if any argument is non-positive.
     * @throws IntegerOverflowException   if result of multiplying these parameters is larger than Integer.MAX_VALUE.
     */
    public House(int floorsInHouse, int flatsOnFloor) {
        if (floorsInHouse <= 0) {
            String message = "Expected: positive number of floors in house" + System.lineSeparator() +
                    "Got: " + floorsInHouse;
            throw new IncorrectArgumentException(message);
        }

        if (flatsOnFloor <= 0) {
            String message = "Expected: positive number of flats on floor" + System.lineSeparator() +
                    "Got: " + flatsOnFloor;
            throw new IncorrectArgumentException(message);
        }

        if (Integer.MAX_VALUE / floorsInHouse < flatsOnFloor) {
            String message = "Expected: numbers of floors in house and flats on floor so that result of" +
                    " multiplying them is not more than " + Integer.MAX_VALUE + System.lineSeparator() +
                    "Got: " + floorsInHouse + ", " + flatsOnFloor;
            throw new IntegerOverflowException(message);
        }

        this.floorsInHouse = floorsInHouse;
        this.flatsOnFloor = flatsOnFloor;
    }

    /**
     * Finds number of house and floor for flat.
     *
     * @param flat number of flat to search
     * @return string contains number of flat, house and floor where the flat located.
     * @throws IncorrectArgumentException if number of flat is non-positive.
     */
    public String defineHouseAndFloor(int flat) {
        if (flat <= 0) {
            String message = "Expected: positive number of flat " + System.lineSeparator() +
                    "Got: " + flat;
            throw new IncorrectArgumentException(message);
        }

        this.flat = flat;

        int flatsInHome = flatsOnFloor * floorsInHouse;
        defineHouse(flat, flatsInHome);
        defineFloor(flat, flatsInHome);

        return toString();
    }

    /**
     * Finds number of house for flat.
     * @param flat number of flat to search.
     */
    private void defineHouse(int flat, int flatsInHome) {
        int house = 1;

        if (flat > flatsInHome) {
            house += flat / flatsInHome;
            if (flat % flatsInHome == 0) {
                house--;
            }
        }

        this.house = house;
    }

    /**
     * Finds number of floor for flat.
     * @param flat number of flat to search.
     */
    private void defineFloor(int flat, int flatsInHome) {
        if (flat % flatsInHome == 0) {
            this.floor = floorsInHouse;
            return;
        }

        flat = flat % flatsInHome;
        int floor = 1;

        if (flat > flatsOnFloor) {
            floor = flat / flatsOnFloor;
            if (flat % flatsOnFloor != 0) {
                floor++;
            }
        }

        this.floor = floor;
    }

    /**
     * String representation of this class.
     *
     * @return string contains number of flat, house and floor where
     * the flat located.
     */
    @Override
    public String toString() {
        return flat + ": " + floor + " floor, " + house + " house";
    }
}
