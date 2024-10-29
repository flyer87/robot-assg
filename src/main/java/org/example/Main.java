package org.example;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    static final String EAST = "E";
    static final String SOUTH = "S";
    static final String WEST = "W";
    static final String NORTH = "N";
    static final String RIGHT = "R";
    static final String LEFT = "L";
    static final String FORWARD = "F";

    public static void main(String[] args) {
        GetGridSize();

//        // Enter: X Y Direction
//        System.out.print("Enter the position of the robot and the direction it is facing");
//        System.out.print("Two number and a letter. Divide by intervals");
//        System.out.print("Directions: N=north, E=east, S=south, W=west");
//        System.out.print("Example: 0 0 N");
//
//        // Enter: Path
//        System.out.println("Enter the instruction. Example: RLFFF");
//
//        // Report
    }

    private static void GetGridSize() {
        Scanner scanner = new Scanner(System.in);

        // Enter: Width Depth
        System.out.print("Enter the size of the field. Two numbers. ");
        System.out.print("First number is width. Second number is grid_depth. Put an interval between them, example: 5 5)");
        System.out.print("Put an interval between them. Example: 5 5). Here: ");
        String inputLine = scanner.nextLine();

        var inputs = inputLine.split(" ");
        if (inputs.length != 2) {
            System.out.println("Invalid format");
        }

        int grid_width = Integer.parseInt(inputs[0]);
        int grid_depth = Integer.parseInt(inputs[1]);

        // System.out.println("You entered: " + grid_width + " " + grid_depth);

        System.out.print("Start position: ");
        var positionLine = scanner.nextLine();
        String[] postions = positionLine.split(" ");

        // start
        var start_width_pos = Integer.parseInt(postions[0]);
        var start_depth_pos = Integer.parseInt(postions[1]);
        var start_direction = postions[2];

        // current
        int curent_width_pos = start_width_pos;
        int curent_depth_pos = start_depth_pos;
        AtomicReference<String> current_direction = new AtomicReference<>(start_direction);

        // System.out.println(start_width_pos + " " + start_depth_pos + " " + start_direction);

        AtomicInteger x_step = new AtomicInteger(0);
        AtomicInteger y_step = new AtomicInteger(0);

        System.out.print("Instructions: ");
        String instructionsLine = scanner.nextLine();
        String[] instructions = instructionsLine.split("");

        // invalid input TODO

        // System.out.println("Entered instructions: " + instructionsLine);

        for (String instruction : instructions) {
            // move
            if (instruction.equals(FORWARD)) {
                curent_depth_pos += y_step.get();
                curent_width_pos += x_step.get();
            }

            // turn
            if (!instruction.equals(FORWARD)) {
                x_step.set(0);
                y_step.set(0);

                PrepareNextStep(current_direction, instruction, x_step, y_step);
            }
        }

        // report
        System.out.println("Report: " + curent_width_pos + " " + curent_depth_pos + " " + current_direction);

        scanner.close();
    }

    private static void PrepareNextStep(AtomicReference currentDirection, String instruction, AtomicInteger x_step, AtomicInteger y_step) {
        switch ((String) currentDirection.get()) {
            case EAST -> TurnFromEast(currentDirection, instruction, y_step);
            case WEST -> TurnFromWest(currentDirection, instruction, y_step);
            case SOUTH -> TurnFromSouth(currentDirection, instruction, x_step);
            case NORTH -> TurnFromNorth(currentDirection, instruction, x_step);
            default -> throw new NullPointerException();
        }
    }

    private static void TurnFromEast(AtomicReference currentDirection, String instruction, AtomicInteger y_step) {
        if (instruction.equals(RIGHT)) {
            currentDirection.set(SOUTH);
            y_step.getAndIncrement();
        }

        if (instruction.equals(LEFT)) {
            currentDirection.set(NORTH);
            y_step.getAndDecrement();
        }
    }

    private static void TurnFromWest(AtomicReference currentDirection, String instruction, AtomicInteger yStep) {
        if (instruction.equals(RIGHT)) {
            currentDirection.set(NORTH);
            yStep.getAndDecrement();
        }

        if (instruction.equals(LEFT)) {
            currentDirection.set(SOUTH);
            yStep.getAndIncrement();
        }
    }

    private static void TurnFromNorth(AtomicReference currentDirection, String instruction, AtomicInteger xStep) {
        if (instruction.equals(RIGHT)) {
            currentDirection.set(EAST);
            xStep.getAndIncrement();
        }

        if (instruction.equals(LEFT)) {
            currentDirection.set(WEST);
            xStep.getAndDecrement();
        }
    }

    private static void TurnFromSouth(AtomicReference currentDirection, String instruction, AtomicInteger xStep) {
        if (instruction.equals(RIGHT)) {
            currentDirection.set(WEST);
            xStep.getAndDecrement();
        }

        if (instruction.equals(LEFT)) {
            currentDirection.set(EAST);
            xStep.getAndIncrement();
        }
    }


    private static void GetPosition() {
        Scanner scanner = new Scanner(System.in);

        // Enter: Width Depth
        System.out.println("Size of the matrix. Example: 5 5): ");
        String inputLine = scanner.nextLine();

        var inputs = inputLine.split(" ");
        if (inputs.length != 2) {
            System.out.println("Invalid format");
        }

        int width = Integer.parseInt(inputs[0]);
        int depth = Integer.parseInt(inputs[1]);

        // System.out.println("You entered: " + width + " " + depth);
    }
}