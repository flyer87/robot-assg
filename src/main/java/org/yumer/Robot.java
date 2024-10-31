package org.yumer;

import org.yumer.exception.OutOfBoundsException;

public class Robot implements RobotInterface {
    private final String EAST = "E";
    private final String SOUTH = "S";
    private final String WEST = "W";
    private final String NORTH = "N";

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

    @Override
    public void moveForward() throws OutOfBoundsException {
        switch (current_direction) {
            case NORTH -> current_depth_pos--;
            case SOUTH -> current_depth_pos++;
            case EAST -> current_width_pos++;
            case WEST -> current_width_pos--;
        }

        if (isOutOfBounds()) {
            throw new OutOfBoundsException("Error: Robot moved outside of room bounds");
        }
    }

    @Override
    public void turnRight() {
        switch (current_direction) {
            case NORTH -> current_direction = EAST;
            case EAST -> current_direction = SOUTH;
            case SOUTH -> current_direction = WEST;
            case WEST -> current_direction = NORTH;
        }
    }

    @Override
    public void turnLeft() {
        switch (current_direction) {
            case NORTH -> current_direction = WEST;
            case WEST -> current_direction = SOUTH;
            case SOUTH -> current_direction = EAST;
            case EAST -> current_direction = NORTH;
        }
    }

    @Override
    public String reportPosition() {
        if (isOutOfBounds()) {
            return "Report: Robot moved out of bounds.";
        }
        return String.format("Report: %d %d %s", current_width_pos, current_depth_pos, current_direction);
    }

    private boolean isOutOfBounds() {
        return current_width_pos >= grid_width || current_width_pos < 0
                || current_depth_pos >= grid_depth || current_depth_pos < 0;
    }
}