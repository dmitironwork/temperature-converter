package org.temperatureconverter;

import java.util.Scanner;

public class TemperatureConverter {

    enum Unit {
        CELSIUS, FAHRENHEIT, KELVIN, EXIT
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\nEnter FROM unit ('C', 'F', 'K') or 'E' to exit:");
            String fromInput = scanner.next();

            Unit fromUnit = parseUnit(fromInput);

            if (fromUnit == Unit.EXIT) {
                System.out.println("Bye");
                break;
            }

            if (fromUnit == null) {
                System.out.println("Wrong choice, try again");
                continue;
            }

            System.out.println("Enter TO unit ('C', 'F', 'K'):");
            String toInput = scanner.next();

            Unit toUnit = parseUnit(toInput);

            if (toUnit == null || toUnit == Unit.EXIT) {
                System.out.println("Wrong choice, try again");
                continue;
            }

            System.out.println("Enter the temperature value:");
            double inputValue = InputValidator.readValidDouble(scanner);

            double result = convert(fromUnit, toUnit, inputValue);

            System.out.println(inputValue + " " + fromUnit + " = " + result + " " + toUnit);
        }
    }

    private static Unit parseUnit(String input) {
        if (input.equalsIgnoreCase("C")) {
            return Unit.CELSIUS;
        } else if (input.equalsIgnoreCase("F")) {
            return Unit.FAHRENHEIT;
        } else if (input.equalsIgnoreCase("K")) {
            return Unit.KELVIN;
        } else if (input.equalsIgnoreCase("E")) {
            return Unit.EXIT;
        } else {
            return null;
        }
    }

    private static double convert(Unit from, Unit to, double value) {
        if (from == to) {
            return value;
        }

        if (from == Unit.CELSIUS) {
            if (to == Unit.FAHRENHEIT) {
                return TemperatureCalculator.celsiusToFahrenheit(value);
            } else if (to == Unit.KELVIN) {
                return TemperatureCalculator.celsiusToKelvin(value);
            }
        } else if (from == Unit.FAHRENHEIT) {
            if (to == Unit.CELSIUS) {
                return TemperatureCalculator.fahrenheitToCelsius(value);
            } else if (to == Unit.KELVIN) {
                return TemperatureCalculator.fahrenheitToKelvin(value);
            }
        } else if (from == Unit.KELVIN) {
            if (to == Unit.CELSIUS) {
                return TemperatureCalculator.kelvinToCelsius(value);
            } else if (to == Unit.FAHRENHEIT) {
                return TemperatureCalculator.kelvinToFahrenheit(value);
            }
        }

        return value;
    }
}