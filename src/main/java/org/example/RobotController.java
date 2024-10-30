package org.example;

public class RobotController {
    Robot robot;

    final String RIGHT = "R";
    final String LEFT = "L";
    final String FORWARD = "F";

    public RobotController(Robot robot) {
        this.robot = robot;
    }

    public void executeCommands(String[] instructions) {
        for (String instruction : instructions) {
            switch (instruction) {
                case RIGHT -> robot.turnRight();
                case LEFT -> robot.turnLeft();
                case FORWARD -> {
                    robot.moveForward();
                    if (robot.isOutOfBounds()) {
                        throw new IndexOutOfBoundsException("Robot moved outside of room bounds");
                    }
                }
                default -> throw new IllegalArgumentException();
            }
        }

        System.out.println(robot.reportPosition());
    }
}
