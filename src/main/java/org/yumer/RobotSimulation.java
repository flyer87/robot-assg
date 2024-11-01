package org.yumer;

import java.util.Scanner;

public class RobotSimulation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Size of the field (Example: 5 5): ");
        String inputLine = scanner.nextLine();

        var inputs = inputLine.split(" ");
        if (inputs.length != 2) {
            System.out.println("Invalid format!");
            return;
        }
        int grid_width = Integer.parseInt(inputs[0]);
        int grid_depth = Integer.parseInt(inputs[1]);

        System.out.print("Start position (Example: 0 0 E): ");
        var positionLine = scanner.nextLine();
        String[] positions = positionLine.split(" ");
        if (positions.length != 3) {
            System.out.println("Invalid format!");
            return;
        }

        var start_width_pos = Integer.parseInt(positions[0]);
        var start_depth_pos = Integer.parseInt(positions[1]);
        var start_direction = positions[2];

        System.out.print("Instructions (Example: RFRF): ");
        String instructionsLine = scanner.nextLine();
        if (instructionsLine.isBlank()) {
            System.out.println("Invalid format!");
            return;
        }
        String[] instructions = instructionsLine.split("");

        scanner.close();

        Robot robot = new Robot(grid_depth, grid_width, start_direction,
                start_depth_pos, start_width_pos);
        RobotController robotController = new RobotController(robot);
        System.out.println(robotController.executeCommands(instructions));
    }
}