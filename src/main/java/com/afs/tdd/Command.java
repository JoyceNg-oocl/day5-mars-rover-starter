package com.afs.tdd;

import java.util.HashMap;
import java.util.Map;

public interface Command {
    void execute();
}

class MoveCommand implements Command {
    private final MarsRover rover;

    public MoveCommand(MarsRover rover) {
        this.rover = rover;
    }

    @Override
    public void execute() {
        rover.movement(MarsRover.FORWARD);
    }
}

class BackCommand implements Command {
    private final MarsRover rover;

    public BackCommand(MarsRover rover) {
        this.rover = rover;
    }

    @Override
    public void execute() {
        rover.movement(MarsRover.BACKWARD);
    }
}

class TurnLeftCommand implements Command {
    private final MarsRover rover;

    public TurnLeftCommand(MarsRover rover) {
        this.rover = rover;
    }

    @Override
    public void execute() {
        rover.rotate(MarsRover.LEFTWARD);
    }
}

class TurnRightCommand implements Command {
    private final MarsRover rover;

    public TurnRightCommand(MarsRover rover) {
        this.rover = rover;
    }

    @Override
    public void execute() {
        rover.rotate(MarsRover.RIGHTWARD);
    }
}

class CommandFactory {
    private final Map<String, Command> commandMap = new HashMap<>();

    public CommandFactory(MarsRover rover) {
        commandMap.put(MarsRover.MOVE, new MoveCommand(rover));
        commandMap.put(MarsRover.LEFT, new TurnLeftCommand(rover));
        commandMap.put(MarsRover.RIGHT, new TurnRightCommand(rover));
        commandMap.put(MarsRover.BACK, new BackCommand(rover));
    }

    public Command getCommand(String commandKey) {
        Command command = commandMap.get(commandKey);
        if (command == null) {
            throw new IllegalArgumentException("Invalid command: " + commandKey);
        }
        return command;
    }
}