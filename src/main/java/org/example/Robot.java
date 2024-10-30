package org.example;

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
    private final int grid_width;
    private final int grid_depth;

    public Robot(int grid_depth, int grid_width, String current_direction, int current_depth_pos, int current_width_pos) {
        this.grid_depth = grid_depth;
        this.grid_width = grid_width;
        this.current_direction = current_direction;
        this.current_depth_pos = current_depth_pos;
        this.current_width_pos = current_width_pos;
    }

    public String executeCommand(String[] instructions) {
        for (String instruction : instructions) {
            if (instruction.equals(FORWARD)) {
                moveForward();
            }

            if (!instruction.equals(FORWARD)) {
                turn(instruction);
            }
        }

        if (outOfBounds()) {
            return "Robot moved outside the area";
        }

        return String.format("Report: %d %d %s", current_width_pos, current_depth_pos, current_direction);
    }

    private boolean outOfBounds() {
        return current_width_pos >= grid_width || current_width_pos < 0
                || current_depth_pos >= grid_depth || current_depth_pos < 0;
    }

    private void moveForward() {
        switch (current_direction) {
            case NORTH -> current_depth_pos--;
            case SOUTH -> current_depth_pos++;
            case EAST -> current_width_pos++;
            case WEST -> current_width_pos--;

            default -> throw new IllegalArgumentException();
        }
    }

    private void turn(String instruction) {
        switch (instruction) {
            case RIGHT -> turnRight();
            case LEFT -> turnLeft();
            default -> throw new IllegalArgumentException();
        }
    }

    private void turnRight() {
        switch (current_direction) {
            case NORTH -> current_direction = EAST;
            case EAST -> current_direction = SOUTH;
            case SOUTH -> current_direction = WEST;
            case WEST -> current_direction = NORTH;
        }
    }

    private void turnLeft() {
        switch (current_direction) {
            case NORTH -> current_direction = WEST;
            case WEST -> current_direction = SOUTH;
            case SOUTH -> current_direction = EAST;
            case EAST -> current_direction = NORTH;
        }
    }
}