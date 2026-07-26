package org.temperatureconverter;

import java.util.Scanner;

public class TemperatureConverter {

    public enum Unit {
        CELSIUS, FAHRENHEIT, KELVIN, EXIT
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\nEnter FROM unit ('C', 'F', 'K') or 'E' to exit:");
            String fromInput = scanner.next();

            Unit fromUnit = InputValidator.parseUnit(fromInput);

            if (fromUnit == Unit.EXIT) {
                System.out.println("Bye");
                break;
            }

            if (fromUnit == null) {
                System.out.println("Wrong choice, try again");
                continue;
            }

            Unit toUnit = InputValidator.readToUnit(scanner, fromUnit);

            if (toUnit == null) {
                System.out.println("Bye");
                break;
            }

            System.out.println("Enter the temperature value:");
            double inputValue = InputValidator.readValidDouble(scanner);

            double result = convert(fromUnit, toUnit, inputValue);

            System.out.println(inputValue + " " + fromUnit + " = " + result + " " + toUnit);
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