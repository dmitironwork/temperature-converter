package org.temperatureconverter;

public class TestDataHelper {
    public static final double DELTA = 0.001;

    public static boolean isCloseEnough(double actual, double expected) {
        return Math.abs(actual - expected) < DELTA;
    }
}
