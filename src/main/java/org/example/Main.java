package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
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
        System.out.print("First number is width. Second number is depth. Put an interval between them, example: 5 5)");
        System.out.print("Put an interval between them. Example: 5 5). Here: ");
        String inputLine = scanner.nextLine();

        var inputs = inputLine.split(" ");
        if (inputs.length != 2) {
            System.out.println("Invalid format");
        }

        int width = Integer.parseInt(inputs[0]);
        int depth = Integer.parseInt(inputs[1]);

        System.out.println("You entered: " + width + " " + depth);
    }

    private static void GetPosition() {
        Scanner scanner = new Scanner(System.in);

        // Enter: Width Depth
        System.out.print("Enter the size of the field. Two numbers. ");
        System.out.print("First number is width. Second number is depth. Put an interval between them, example: 5 5)");
        System.out.print("Put an interval between them. Example: 5 5). Here: ");
        String inputLine = scanner.nextLine();

        var inputs = inputLine.split(" ");
        if (inputs.length != 2) {
            System.out.println("Invalid format");
        }

        int width = Integer.parseInt(inputs[0]);
        int depth = Integer.parseInt(inputs[1]);

        System.out.println("You entered: " + width + " " + depth);
    }
}