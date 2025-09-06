package com.afs.tdd;

public class MarsRover {
    private int x;
    private int y;
    private String direction;

    public MarsRover(int x, int y, String direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void executeCommand(String command) {
        if (command.equals("M")) {
            move();
        }
    }

    private void move() {
        switch (direction) {
            case "N":
                y += 1;
                break;
            case "E":
                x += 1;
                break;
            case "S":
                y -= 1;
                break;
            case "W":
                x -= 1;
                break;
        }
    }

    public String getLocation() {
        return "(" + x + "," + y + "," + direction + ")";
    }
}
