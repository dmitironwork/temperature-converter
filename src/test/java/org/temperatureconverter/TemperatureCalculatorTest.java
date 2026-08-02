package org.temperatureconverter;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class TemperatureCalculatorTest {

    @Test
    public void testCelsiumFarenheit_freezingPoin() {
        double result = TemperatureCalculator.celsiusToFahrenheit(0.0);
        Assert.assertTrue(TestDataHelper.isCloseEnough(result, 32.0));
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
