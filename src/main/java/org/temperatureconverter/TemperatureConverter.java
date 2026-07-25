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
            while (!scanner.hasNextDouble()) {
                System.out.println("This is not a number. Please enter a number.");
                scanner.next();
            }
            double inputValue = scanner.nextDouble();

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


//package org.temperatureconverter;
//
//import java.util.Scanner;
//
//enum Command {
//    CELSIUS, FAHRENHEIT, KELVIN, EXIT
//}
//public class TemperatureConverter {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        while (true) {
//
//            System.out.println("To choose the temperature entre 'C', 'K' or 'F' \nPress 'E' + enter to exit");
//
//            String direction = scanner.next();
//
//            System.out.println("U entered " + direction);
//
//            Command command = null;
//
//            if (direction.equalsIgnoreCase("C")) {
//                command = Command.CELSIUS;
//            } else if (direction.equalsIgnoreCase("F")) {
//                command = Command.FAHRENHEIT;
//            } else if (direction.equalsIgnoreCase("K")) {
//                command = Command.KELVIN;
//            } else if (direction.equalsIgnoreCase("E")) {
//                command = Command.EXIT;
//            }
//
//            if (command == Command.CELSIUS) {
//                System.out.println("Enter temperature in Celsius");
//
//                while (!scanner.hasNextDouble()) {
//                    System.out.println("This is not number. Please enter a number.");
//                    scanner.next();
//                }
//
//                double celsius = scanner.nextDouble();
//                double fahrenheit = TemperatureCalculator.celsiusToFahrenheit(celsius);
//
//                System.out.println(celsius + "C =" + fahrenheit + "F");
//
//            } else if (command == Command.FAHRENHEIT) {
//                System.out.println("Enter temperature in Fahrenheit");
//
//                while (!scanner.hasNextDouble()) {
//                    System.out.println("This is not number. Please enter a number.");
//                    scanner.next();
//                }
//
//                double fahrenheit = scanner.nextDouble();
//                double celsius = TemperatureCalculator.fahrenheitToCelsius(fahrenheit);
//
//                System.out.println(celsius + "F =" + fahrenheit + "C");
//
//            } else if (command == Command.KELVIN) {
//                System.out.println("Enter temperature in Kelvin");
//
//                while (!scanner.hasNextDouble()) {
//                    System.out.println("This is not number. Please enter a number.");
//                    scanner.next();
//                }
//
//                double kelvin = scanner.nextDouble();
//                double celsius = TemperatureCalculator.kelvinToCelsius(kelvin);
//
//                System.out.println(kelvin + "K = " + celsius + "C");
//
//            } else if (command == Command.EXIT) {
//                System.out.println("Bye");
//                break;
//
//            } else {
//                System.out.println("Wrong choice, try again");
//            }
//        }
//    }
//}

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        while (true) {
//
//            System.out.println("To choose the temperature entre 'C', 'K' or 'F' \nPress 'E' + enter to exit");
//
//            String direction = scanner.next();
//
//            System.out.println("U entered " + direction);
//
//            String c = "C";
//            String f = "F";
//            String k = "K";
//            String e = "E";
//
//            if (direction.equalsIgnoreCase(c)) {
//                System.out.println("Enter temperature in Celsius");
//
//                while (!scanner.hasNextDouble()) {
//                    System.out.println("This is not number. Please enter a number.");
//                    scanner.next();
//                }
//
//                double celsius = scanner.nextDouble();
//                double fahrenheit = TemperatureCalculator.celsiusToFahrenheit(celsius);
//
//                System.out.println(celsius + "C =" + fahrenheit + "F");
//
//            } else if (direction.equalsIgnoreCase(f)) {
//                System.out.println("Enter temperature in Fahrenheit");
//
//                while (!scanner.hasNextDouble()) {
//                    System.out.println("This is not number. Please enter a number.");
//                    scanner.next();
//                }
//
//                double fahrenheit = scanner.nextDouble();
//                double celsius = TemperatureCalculator.fahrenheitToCelsius(fahrenheit);
//
//                System.out.println(celsius + "F =" + fahrenheit + "C");
//
//            } else if (direction.equalsIgnoreCase(k)) {
//                System.out.println("Enter temperature in Kelvin");
//
//                while (!scanner.hasNextDouble()) {
//                    System.out.println("This is not number. Please enter a number.");
//                    scanner.next();
//                }
//
//                double kelvin = scanner.nextDouble();
//                double celsius = TemperatureCalculator.kelvinToCelsius(kelvin);
//
//                System.out.println(kelvin + "K = " + celsius + "C");
//
//            } else if (direction.equalsIgnoreCase(e)) {
//                System.out.println("Bуе");
//                break;
//
//            } else {
//                System.out.println("Wrong choice, try again");
//            }
//        }
//    }
//}
