package org.temperatureconverter;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import java.util.List;

public class TemperatureCalculatorTest {

    @Test(groups = {"celsius"},
            description = "UA-00005: Verify round-trip conversion (Celsius -> Fahrenheit -> Celsius) returns original value")
    public void testMultipleCelsiusValuesRoundTrip() {
        List<Double> celsiusValues = TestDataHelper.sampleCelsiusValues();

        for (double celsius : celsiusValues) {
            double fahrenheit = TemperatureCalculator.celsiusToFahrenheit(celsius);
            double backToCelsius = TemperatureCalculator.fahrenheitToCelsius(fahrenheit);
            Assert.assertTrue(TestDataHelper.isCloseEnough(backToCelsius, celsius),
                    "Round trip failed for %.2f°C: got back %.2f°C".formatted(celsius, backToCelsius));
        }
    }

    @DataProvider(name = "fahrenheitToCelsiusData")
    public Object[][] fahrenheitToCelsiusData() {
        return new Object[][] {
                {212.0, 100.0},
                {98.6, 37.0},
                {-40.0, -40.0}
        };
    }

    @Test(dataProvider = "fahrenheitToCelsiusData", groups = {"fahrenheit"},
            description = "UA-00001: Verify conversion Fahrenheit to Celsius")
    public void testFahrenheitToCelsius_variousValues(double fahrenheit, double expectedCelsius) {
        double result = TemperatureCalculator.fahrenheitToCelsius(fahrenheit);
        Assert.assertTrue(TestDataHelper.isCloseEnough(result, expectedCelsius),
                "%.2f°F should convert to %.2f°C, but got %.2f°C".formatted(fahrenheit, expectedCelsius, result));
    }

    @DataProvider(name = "celsiusToFahrenheitData")
    public Object[][] celsiusToFahrenheitData() {
        return new Object[][] {
                {-40.0, -40.0},
                {37.0, 98.6},
                {-273.15, -459.67}
        };
    }

    @Test(dataProvider = "celsiusToFahrenheitData", groups = {"celsius"},
            description = "UA-00002: Verify conversion Celsius to Fahrenheit")
    public void testCelsiusToFahrenheit_variousValues(double celsius, double expectedFahrenheit) {
        double result = TemperatureCalculator.celsiusToFahrenheit(celsius);
        Assert.assertTrue(TestDataHelper.isCloseEnough(result, expectedFahrenheit),
                "%.2f°C should convert to %.2f°F, but got %.2f°F".formatted(celsius, expectedFahrenheit, result));
    }

    @Test(groups = {"celsius", "smoke"},
            description = "UA-00003: Verify freezing point of water (0°C = 32°F)")
    public void testCelsiusToFahrenheit_freezingPoint() {
        double result = TemperatureCalculator.celsiusToFahrenheit(0.0);
        Assert.assertTrue(TestDataHelper.isCloseEnough(result, 32.0),
                "Freezing point mismatch. Expected: %.2f, Actual: %.2f".formatted(32.0, result));
    }

    @Test(groups = {"celsius", "smoke"},
            description = "UA-00004: Verify boiling point of water (100°C = 212°F)")
    public void testCelsiusToFahrenheit_boilingPoint() {
        double result = TemperatureCalculator.celsiusToFahrenheit(100);
        Assert.assertTrue(TestDataHelper.isCloseEnough(result, 212.0),
                "Boiling point mismatch. Expected: %.2f, Actual: %.2f".formatted(212.0, result));
    }

    @Test(groups = {"kelvin", "smoke"},
            description = "UA-00006: Verify 0°C equals 273.15K (absolute zero reference point)")
    public void testCelsiusToKelvin_zero() {
        double result = TemperatureCalculator.celsiusToKelvin(0.0);
        Assert.assertTrue(TestDataHelper.isCloseEnough(result, 273.15),
                "Kelvin conversion mismatch. Expected: %.2f, Actual: %.2f".formatted(273.15, result));
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("Start test...");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Test finished.\n");
    }
}