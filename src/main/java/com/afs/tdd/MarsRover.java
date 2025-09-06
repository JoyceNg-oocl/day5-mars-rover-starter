package com.afs.tdd;

public class MarsRover {
    public static final String MOVE = "M";
    public static final String LEFT = "L";
    public static final String RIGHT = "R";
    public static final String BACK = "B";
    public static final int FORWARD = 1;
    public static final int BACKWARD = -1;
    public static final int LEFTWARD = -1;
    public static final int RIGHTWARD = 1;

    private final CommandFactory commandFactory;
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
        this.commandFactory = new CommandFactory(this);
    }

    public void executeCommand(String commands) {
        commands.chars()
                .mapToObj(c -> String.valueOf((char) c))
                .filter(s -> !s.trim().isEmpty())
                .forEach(commandString -> {
                    Command command = commandFactory.getCommand(commandString);
                    command.execute();
                });
    }

    protected void movement(int longitudinal) {
        switch (direction) {
            case NORTH:
                y += longitudinal;
                break;
            case EAST:
                x += longitudinal;
                break;
            case SOUTH:
                y -= longitudinal;
                break;
            case WEST:
                x -= longitudinal;
                break;
        }
    }

    protected void rotate(int lateral) {
        Direction[] dirs = Direction.values();
        int len = dirs.length;
        int newIndex = (direction.ordinal() + lateral + len) % len;
        direction = dirs[newIndex];
    }

    public String getLocation() {
        return "(" + x + "," + y + "," + direction.toDirectionString() + ")";
    }
}
