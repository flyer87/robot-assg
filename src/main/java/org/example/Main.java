package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GetGridSize();
    }

    private static void GetGridSize() {
        Scanner scanner = new Scanner(System.in);

        // Enter: Width Depth
        System.out.print("Size of the field (Example: 5 5): ");
        String inputLine = scanner.nextLine();

        var inputs = inputLine.split(" ");
        if (inputs.length != 2) {
            System.out.println("Invalid format");
        }

        int grid_width = Integer.parseInt(inputs[0]);
        int grid_depth = Integer.parseInt(inputs[1]);

        System.out.print("Start position (Example: 0 0 E): ");
        var positionLine = scanner.nextLine();
        String[] positions = positionLine.split(" ");
        var start_width_pos = Integer.parseInt(positions[0]);
        var start_depth_pos = Integer.parseInt(positions[1]);
        var start_direction = positions[2];

        System.out.print("Instructions (Example: RFRF): ");
        String instructionsLine = scanner.nextLine();
        String[] instructions = instructionsLine.split("");

        Robot robot = new Robot(grid_depth, grid_width, start_direction,
                start_depth_pos, start_width_pos);
        System.out.println(robot.executeCommand(instructions));

        scanner.close();
    }

    private static void GetPosition() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Size of the matrix. Example: 5 5): ");
        String inputLine = scanner.nextLine();

        var inputs = inputLine.split(" ");
        if (inputs.length != 2) {
            System.out.println("Invalid format");
        }

        int width = Integer.parseInt(inputs[0]);
        int depth = Integer.parseInt(inputs[1]);
    }
}