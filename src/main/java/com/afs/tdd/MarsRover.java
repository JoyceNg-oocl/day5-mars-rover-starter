package com.afs.tdd;

public class MarsRover {
    public static final String MOVE = "M";
    public static final String LEFT = "L";
    public static final String RIGHT = "R";
    public static final String BACK = "B";
    private int x;
    private int y;
    private Direction direction;

    public enum Direction {
        NORTH, EAST, SOUTH, WEST;

        public String toDirectionString() {
            return String.valueOf(name().charAt(0));
        }

        public static Direction fromString(String direction) {
            switch (direction) {
                case "N":
                    return Direction.NORTH;
                case "E":
                    return Direction.EAST;
                case "S":
                    return Direction.SOUTH;
                case "W":
                    return Direction.WEST;
                default:
                    throw new IllegalArgumentException("Invalid direction: " + direction);
            }
        }

    }

    public MarsRover(int x, int y, String direction) {
        this.x = x;
        this.y = y;
        this.direction = Direction.fromString(direction);
    }

    public void executeCommand(String command) {
        if (MOVE.equals(command)) {
            move();
        } else if (LEFT.equals(command)) {
            turnLeft();
        } else if (RIGHT.equals(command)) {
            turnRight();
        } else if (BACK.equals(command)) {
            back();
        } else {
            throw new IllegalArgumentException("Invalid command: " + command);
        }
    }

    private void move() {
        switch (direction) {
            case NORTH:
                y += 1;
                break;
            case EAST:
                x += 1;
                break;
            case SOUTH:
                y -= 1;
                break;
            case WEST:
                x -= 1;
                break;
        }
    }

    private void turnLeft() {
        switch (direction) {
            case NORTH:
                direction = Direction.WEST;
                break;
            case EAST:
                direction = Direction.NORTH;
                break;
            case SOUTH:
                direction = Direction.EAST;
                break;
            case WEST:
                direction = Direction.SOUTH;
                break;
        }
    }

    private void turnRight() {
        switch (direction) {
            case NORTH:
                direction = Direction.EAST;
                break;
            case EAST:
                direction = Direction.SOUTH;
                break;
            case SOUTH:
                direction = Direction.WEST;
                break;
            case WEST:
                direction = Direction.NORTH;
                break;
        }
    }

    private void back() {
        switch (direction) {
            case NORTH:
                y -= 1;
                break;
            case EAST:
                x -= 1;
                break;
            case SOUTH:
                y += 1;
                break;
            case WEST:
                x += 1;
                break;
        }
    }

    public String getLocation() {
        return "(" + x + "," + y + "," + direction.toDirectionString() + ")";
    }
}
