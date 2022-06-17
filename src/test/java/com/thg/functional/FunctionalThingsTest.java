package com.thg.functional;


import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionalThingsTest {

    private FunctionalThings things = new FunctionalThings();

    @Test
    public void helloWorldTest() {
        assertEquals("Hello world!", things.helloWorld());
    }

    @Test
    public void testDoubleIntegers() {
        var result = things.doubleIntegers(testIntegers());

        assertEquals(List.of(0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20), result);
    }

    @Test
    public void testDoubleFloats() {
        var result = things.doubleFloats(testFloats());

        assertEquals(List.of(0F, 2F, 4F, 6F, 8F, 10F, 12F, 14F, 16F, 18F, 20F), result);
    }

    @Test
    public void testDoubleString() {
        var result = things.doubleStrings(testStrings());

        assertEquals(List.of("ONEONE", "TWOTWO", "THREETHREE"), result);
    }

    @Test
    public void testToStrings() {
        var result = things.toStrings(List.of(1, 5, 17));

        assertEquals(List.of("ONE", "FIVE", "LOTS"), result);
    }

    @Test
    public void testSumIntegers() {
        var result = things.sumIntegers(testIntegers());

        assertEquals(55, result);
    }

    @Test
    public void testSumStrings() {
        var result = things.sumStrings(testStrings());

        assertEquals("ONETWOTHREE", result);
    }

    @Test
    public void testKeyValue() {
        var result = things.toKeyValue(List.of(2, 3, 17));

        assertEquals(Map.of("TWO", 2, "THREE", 3, "LOTS", 17), result);
    }

    private Collection<Integer> testIntegers() {
       return List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }


    private Collection<Float> testFloats() {
        return List.of(0.0F, 1F, 2F, 3F, 4F, 5F, 6F, 7F, 8F, 9F, 10F);
    }

    private Collection<String> testStrings() {
        return List.of("ONE", "TWO", "THREE");
    }
}
