package com.implemica.bormashenko;

/**
 * This class allows user to define number of floor
 * and house by number of flat.
 *
 * @author Mykhailo Bormashenko
 */
public class Task2 {

    private int floorsInHouse;
    private int flatsOnFloor;
    private int flat;
    private int house;
    private int floor;

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

    @Override
    public String toString() {
        return flat + ": " + floor + " floor, " + house + " house";
    }
}
