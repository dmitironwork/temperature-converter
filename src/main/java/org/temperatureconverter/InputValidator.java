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

    public static TemperatureConverter.Unit readToUnit(Scanner scanner, TemperatureConverter.Unit fromUnit) {
        while (true) {
            printToUnitPrompt(fromUnit);
            String toInput = scanner.next();

            TemperatureConverter.Unit toUnit = parseUnit(toInput);

            if (toUnit == TemperatureConverter.Unit.EXIT) {
                return null;
            }

            if (toUnit == null) {
                System.out.println("Wrong choice, try again");
                continue;
            }

            if (toUnit == fromUnit) {
                System.out.println("Same unit " + fromUnit + ", choose another one");
                continue;
            }

            return toUnit;
        }
    }

    private static void printToUnitPrompt(TemperatureConverter.Unit fromUnit) {
        if (fromUnit == TemperatureConverter.Unit.CELSIUS) {
            System.out.println("Enter TO unit ('F' or 'K'):");
        } else if (fromUnit == TemperatureConverter.Unit.FAHRENHEIT) {
            System.out.println("Enter TO unit ('C' or 'K'):");
        } else if (fromUnit == TemperatureConverter.Unit.KELVIN) {
            System.out.println("Enter TO unit ('C' or 'F'):");
        }
    }

    public static TemperatureConverter.Unit parseUnit(String input) {
        if (input.equalsIgnoreCase("C")) {
            return TemperatureConverter.Unit.CELSIUS;
        } else if (input.equalsIgnoreCase("F")) {
            return TemperatureConverter.Unit.FAHRENHEIT;
        } else if (input.equalsIgnoreCase("K")) {
            return TemperatureConverter.Unit.KELVIN;
        } else if (input.equalsIgnoreCase("E")) {
            return TemperatureConverter.Unit.EXIT;
        } else {
            return null;
        }
    }
}
