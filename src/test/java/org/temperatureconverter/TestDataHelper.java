package org.temperatureconverter;

import java.util.ArrayList;
import java.util.List;

public class TestDataHelper {
    public static final double DELTA = 0.001;

    public static List<Double> sampleCelsiusValues() {
        List<Double> values = new ArrayList<>();
        values.add(-273.15);
        values.add(-40.0);
        values.add(0.0);
        values.add(37.0);
        values.add(100.0);
        return values;
    }

    public static boolean isCloseEnough(double actual, double expected) {
        return Math.abs(actual - expected) < DELTA;
    }
}
