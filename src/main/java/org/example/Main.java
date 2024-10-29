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

        for (int i = 0; i < instructions.length; i++) {
            // turn
            if (!instructions[i].equals(FORWARD)){
                // turn right
                PrepareNextStep(current_direction, instructions[i], x_step, y_step);
            }

//            if (instructions[i].equals("L")){
//                // turn left
//                PrepareNextStep(current_direction, instructions[i], x_step, y_step);
//            }

            // move
            if (instructions[i].equals(FORWARD)) {
                // move
                curent_depth_pos += y_step.get();
                curent_width_pos += x_step.get();
            }
        }

        // report
        System.out.println("Report: " + curent_width_pos + " " + curent_depth_pos + " " + current_direction);

        scanner.close();
    }

    private static void PrepareNextStep(AtomicReference currentDirection, String instruction, AtomicInteger x_step, AtomicInteger y_step) {
        switch ((String) currentDirection.get()) {
            case EAST -> TurnFromEast(currentDirection, instruction, y_step);
//            case "S" -> TurnFromSouth(curent_width_pos, instruction);
//            case "W" -> TurnFromWest(curent_depth_pos, instruction);
//            case "N" -> TurnFromNorth(curent_width_pos, instruction);
            default -> throw new NullPointerException();
        }
    }

    private static void TurnFromEast(AtomicReference currentDirection, String instruction, AtomicInteger y_step) {
        if (instruction.equals(RIGHT)){
            currentDirection.set(SOUTH);
            y_step.getAndIncrement();
        }

        if (instruction.equals(LEFT)){
            currentDirection.set(NORTH);
            y_step.getAndDecrement();
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