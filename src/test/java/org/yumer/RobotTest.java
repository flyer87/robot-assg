package org.yumer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import org.yumer.exception.OutOfBoundsException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class RobotTest {
    @Test
    public void moveForward_outsideBounds_throwsException(){
        Robot robot = new Robot(5,5, "W",
                0, 0);

        assertThrows(OutOfBoundsException.class, robot::moveForward);
    }

    @Test
    public void moveForward_insideBounds_isSuccessful() throws OutOfBoundsException {
        Robot robot = new Robot(5,5, "E",
                0, 0);

        robot.moveForward();

        assertEquals(robot.reportPosition(), "Report: 1 0 E");
    }

    @Test
    public void turnRight_whenEast_turnedSouth() {
        Robot robot = new Robot(5,5, "E",
                0, 0);

        robot.turnRight();

        assertEquals(robot.reportPosition(), "Report: 0 0 S");
    }

    @Test
    public void turnLeft_whenEast_turnedNorth() {
        Robot robot = new Robot(5, 5, "E",
                0, 0);

        robot.turnLeft();

        assertEquals(robot.reportPosition(), "Report: 0 0 N");
    }
}
