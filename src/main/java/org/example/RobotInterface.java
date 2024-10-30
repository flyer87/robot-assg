package org.example;

public interface RobotInterface {
    void moveForward();

    void turnRight();

    void turnLeft();

    String reportPosition();

    boolean isOutOfBounds();
}
