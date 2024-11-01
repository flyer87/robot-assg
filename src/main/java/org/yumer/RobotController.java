package org.yumer;

import org.yumer.exception.OutOfBoundsException;

public class RobotController {
    RobotInterface robot;

    final String RIGHT = "R";
    final String LEFT = "L";
    final String FORWARD = "F";

    public RobotController(RobotInterface robot) {
        this.robot = robot;
    }

    public String executeCommands(String[] instructions) {
        try {
            for (String instruction : instructions) {
                switch (instruction) {
                    case RIGHT -> robot.turnRight();
                    case LEFT -> robot.turnLeft();
                    case FORWARD -> robot.moveForward();
                    default -> throw new IllegalArgumentException("Invalid instruction: " + instruction);
                }
            }
        } catch (OutOfBoundsException | IllegalArgumentException exception) {
            return exception.getMessage();
        }

        return robot.reportPosition();
    }
}
