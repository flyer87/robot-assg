package org.yumer;

import org.yumer.exception.OutOfBoundsException;

public interface RobotInterface {
    void moveForward() throws OutOfBoundsException;

    void turnRight();

    void turnLeft();

    String reportPosition();
}
