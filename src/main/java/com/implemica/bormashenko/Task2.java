package com.implemica.bormashenko;

/**
 * This class allows user to define number of floor
 * and house by number of flat.
 *
 * @author Mykhailo Bormashenko
 */
public class Task2 {

    /**
     * Number of floors in house.
     */
    private int floorsInHouse;

    /**
     * Number of flats on floor.
     */
    private int flatsOnFloor;

    /**
     * Number of flat to find.
     */
    private int flat;

    /**
     * Number of house where flat is located.
     */
    private int house;

    /**
     * Number of floor where flat is located.
     */
    private int floor;

    /**
     * Constructor with parameters.
     *
     * @param floorsInHouse value of floors in house.
     * @param flatsOnFloor  value of flats on floor.
     * @throws IncorrectArgumentException if any argument is non-positive.
     * @throws IntegerOverflowException   if result of multiplying these parameters is larger than Integer.MAX_VALUE.
     */
    public Task2(int floorsInHouse, int flatsOnFloor) {
        if (floorsInHouse <= 0 || flatsOnFloor <= 0) {
            throw new IncorrectArgumentException("Number should be positive.");
        }

        if (Integer.MAX_VALUE / floorsInHouse < flatsOnFloor) {
            throw new IntegerOverflowException("Numbers are too large.");
        }

        this.floorsInHouse = floorsInHouse;
        this.flatsOnFloor = flatsOnFloor;
    }

    /**
     * Defines number of house and floor for flat.
     *
     * @param flat number of flat to define.
     * @return string contains number of flat, house and floor where the flat located.
     * @throws IncorrectArgumentException if number of flat is non-positive.
     */
    public String defineHouseAndFloor(int flat) {
        if (flat <= 0) {
            throw new IncorrectArgumentException("Number should be positive.");
        }

        this.flat = flat;
        int flatsInHome = flatsOnFloor * floorsInHouse;
        int house = 1;

        if (flat > flatsInHome) {
            house += flat / flatsInHome;
            flat = flat % flatsInHome;
            if (flat == 0) {
                --house;
                this.house = house;
                this.floor = floorsInHouse;
                return toString();
            }
        }

        this.house = house;
        int floor = 1;

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
