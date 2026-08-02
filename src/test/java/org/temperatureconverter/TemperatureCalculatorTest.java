package org.temperatureconverter;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TemperatureCalculatorTest {

    @Test
    public void testCelsiumFarenheit_freezingPoin() {
        double result = TemperatureCalculator.celsiusToFahrenheit(0.0);
        Assert.assertTrue(TestDataHelper.isCloseEnough(result, 32.0));
    }
}
