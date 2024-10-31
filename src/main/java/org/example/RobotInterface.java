package org.example;

import org.example.exception.OutOfBoundsException;

public interface RobotInterface {
    void moveForward() throws OutOfBoundsException;

    void turnRight();

    void turnLeft();

    String reportPosition();
}
