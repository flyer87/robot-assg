package org.example;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Robot {
    static final String EAST = "E";
    static final String SOUTH = "S";
    static final String WEST = "W";
    static final String NORTH = "N";
    static final String RIGHT = "R";
    static final String LEFT = "L";
    static final String FORWARD = "F";

    private int current_width_pos;
    private int current_depth_pos;
    private String current_direction;
    private int grid_width;
    private int grid_depth;

    public Robot(int grid_depth, int grid_width, String current_direction, int current_depth_pos, int current_width_pos) {
        this.grid_depth = grid_depth;
        this.grid_width = grid_width;
        this.current_direction = current_direction;
        this.current_depth_pos = current_depth_pos;
        this.current_width_pos = current_width_pos;
    }

    public String executeCommand(String[] instructions) {
        AtomicInteger x_step = new AtomicInteger(0);
        AtomicInteger y_step = new AtomicInteger(0);

        for (String instruction : instructions) {
            // move
            if (instruction.equals(FORWARD)) {
                current_depth_pos += y_step.get();
                current_width_pos += x_step.get();
            }

            // turn
            if (!instruction.equals(FORWARD)) {
                x_step.set(0);
                y_step.set(0);
            }
        }

        return  null;
    }

    private void PrepareNextStep(AtomicReference currentDirection, String instruction, AtomicInteger x_step, AtomicInteger y_step) {
        switch ((String) currentDirection.get()) {
            case EAST -> TurnFromEast(currentDirection, instruction, y_step);
            case WEST -> TurnFromWest(currentDirection, instruction, y_step);
            case SOUTH -> TurnFromSouth(currentDirection, instruction, x_step);
            case NORTH -> TurnFromNorth(currentDirection, instruction, x_step);
            default -> throw new NullPointerException();
        }
    }
    private void TurnFromEast(AtomicReference currentDirection, String instruction, AtomicInteger y_step) {
        if (instruction.equals(RIGHT)) {
            currentDirection.set(SOUTH);
            y_step.getAndIncrement();
        }

        if (instruction.equals(LEFT)) {
            currentDirection.set(NORTH);
            y_step.getAndDecrement();
        }
    }

    private void TurnFromWest(AtomicReference currentDirection, String instruction, AtomicInteger yStep) {
        if (instruction.equals(RIGHT)) {
            currentDirection.set(NORTH);
            yStep.getAndDecrement();
        }

        if (instruction.equals(LEFT)) {
            currentDirection.set(SOUTH);
            yStep.getAndIncrement();
        }
    }

    private void TurnFromNorth(AtomicReference currentDirection, String instruction, AtomicInteger xStep) {
        if (instruction.equals(RIGHT)) {
            currentDirection.set(EAST);
            xStep.getAndIncrement();
        }

        if (instruction.equals(LEFT)) {
            currentDirection.set(WEST);
            xStep.getAndDecrement();
        }
    }

    private void TurnFromSouth(AtomicReference currentDirection, String instruction, AtomicInteger xStep) {
        if (instruction.equals(RIGHT)) {
            currentDirection.set(WEST);
            xStep.getAndDecrement();
        }

        if (instruction.equals(LEFT)) {
            currentDirection.set(EAST);
            xStep.getAndIncrement();
        }
    }
}