package org.temperatureconverter;

import java.util.Scanner;

public class InputValidator {
    public static double readValidDouble(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.println("This is not a number. Please enter a number.");
            scanner.next();
        }
        return scanner.nextDouble();
    }
}
