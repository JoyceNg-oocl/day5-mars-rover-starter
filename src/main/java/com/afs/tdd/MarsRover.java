package com.afs.tdd;

public class MarsRover {
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
                default:
                    return Direction.WEST;
            }
        }

    }

    public MarsRover(int x, int y, String direction) {
        this.x = x;
        this.y = y;
        this.direction = Direction.fromString(direction);
    }

    public void executeCommand(String command) {
        if (command.equals("M")) {
            move();
        }
        if (command.equals("L")) {
            turnLeft();
        }
        if (command.equals("R")) {
            turnRight();
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

    public String getLocation() {
        return "(" + x + "," + y + "," + direction.toDirectionString() + ")";
    }
}
