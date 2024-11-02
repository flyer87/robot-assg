package org.yumer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.yumer.exception.OutOfBoundsException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RobotControllerTest {
    @Mock
    private Robot robot;

    @InjectMocks
    private RobotController controller;

    @Test
    public void executeCommands_move_returnPosition() {
        // Arrange
        final var expectedReport = "Report: 0 0 E";
        when(robot.reportPosition()).thenReturn(expectedReport);

        // Act
        var report = controller.executeCommands(new String[]{"F"});

        // Assert
        assertEquals(expectedReport, report);
        verify(robot, times(1)).reportPosition();
    }

    @Test
    public void executeCommands_moveOutsideBounds_returnExceptionMessage() throws OutOfBoundsException{
        // Arrange
        var exceptionMessage = "Out of bounds";
        doThrow(new OutOfBoundsException(exceptionMessage)).when(robot).moveForward();

        // Act
        var result = controller.executeCommands(new String[] {"F"});

        // Assert
        assertEquals(exceptionMessage, result);
    }


}
