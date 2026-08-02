package org.temperatureconverter;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class TemperatureCalculatorTest {

    @DataProvider(name = "fahrenheitToCelsiusData")
    public Object[][] fahrenheitToCelsiusData() {
        return new Object[][] {
                {212.0, 100.0},
                {98.6, 37.0},
                {-40.0, -40.0}
        };
    }

    @Test(dataProvider = "fahrenheitToCelsiusData", groups = {"fahrenheit"})
    public void testFahrenheitToCelsius_variousValues(double fahrenheit, double expectedCelsius) {
        double result = TemperatureCalculator.fahrenheitToCelsius(fahrenheit);
        Assert.assertTrue(TestDataHelper.isCloseEnough(result, expectedCelsius));
    }

    @DataProvider(name = "celsiusToFahrenheitData")
    public Object[][] celsiusToFahrenheitData() {
        return new Object[][] {
                {-40.0, -40.0},
                {37.0, 98.6},
                {-273.15, -459.67}
        };
    }

    @Test(dataProvider = "celsiusToFahrenheitData", groups = {"celsius"})
    public void testCelsiusToFahrenheit_variousValues(double celsius, double expectedFahrenheit) {
        double result = TemperatureCalculator.celsiusToFahrenheit(celsius);
        Assert.assertTrue(TestDataHelper.isCloseEnough(result, expectedFahrenheit));
    }

    @Test(groups = {"celsius", "smoke"})
    public void testCelsiusToFahrenheit_freezingPoint() {
        double result = TemperatureCalculator.celsiusToFahrenheit(0.0);
        Assert.assertTrue(TestDataHelper.isCloseEnough(result, 32.0));
    }

    @Test(groups = {"celsius", "smoke"})
    public void testCelsiusToFahrenheit_boilingPoint() {
        double result = TemperatureCalculator.celsiusToFahrenheit(100);
        Assert.assertTrue(TestDataHelper.isCloseEnough(result, 212.0));
    }

    @Test(groups = {"kelvin", "smoke"})
    public void testCelsiusToKelvin_zero() {
        double result = TemperatureCalculator.celsiusToKelvin(0.0);
        Assert.assertTrue(TestDataHelper.isCloseEnough(result, 273.15));
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
