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
            throw new IncorrectArgumentException("For number of floors in house " + floorsInHouse +
                    ": number should be positive.");
        }

        if (flatsOnFloor <= 0) {
            throw new IncorrectArgumentException("For number of flats on floor " + flatsOnFloor +
                    ": number should be positive.");
        }

        if (Integer.MAX_VALUE / floorsInHouse < flatsOnFloor) {
            throw new IntegerOverflowException("For numbers of floors in house and flats on floor " +
                    floorsInHouse + ", " + flatsOnFloor + ": numbers are too large.");
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
            throw new IncorrectArgumentException("For number of flat " + flat + " : number should be positive.");
        }

        this.flat = flat;
        int flatsInHome = flatsOnFloor * floorsInHouse;
        int house = 1;
        int floor = 1;

        if (flat > flatsInHome) {
            house += flat / flatsInHome;
            flat = flat % flatsInHome;
            if (flat == 0) {
                house--;
                this.house = house;
                this.floor = floorsInHouse;
                return toString();
            }
        }

        this.house = house;

        if (flat > flatsOnFloor) {
            floor = flat / flatsOnFloor;
            if (flat % flatsOnFloor != 0) {
                floor++;
            }
        }

        this.floor = floor;
        return toString();
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
