package com.thg.functional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionalThings {
    public String[] numbers = {"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN"};

    public String helloWorld() {
        return "Hello world!";
    }

    public <T, R> Collection<R> map(Collection<T> values, Function<T, R> function) {
        var result = new ArrayList<R>();
        for (var value: values) {
            result.add(function.apply(value));
        }
        return result;
    }

    public Collection<Float> doubleFloats(Collection<Float> values) {
        return map(values, (a) -> a * 2F);
    }

    public Collection<Integer> doubleIntegers(Collection<Integer> values) {
        return map(values, (a) -> a * 2);
    }

    public Collection<String> doubleStrings(Collection<String> values) {
        return map(values, (a) -> a + a);
    }

    public Collection<String> toStrings(Collection<Integer> values) {
        Function<Integer, String> function = (Integer value) -> {
            if (value <= 10) {
                return numbers[value];
            } else {
                return "LOTS";
            }
        };
        return map(values, function);
    }

    public <T, R> R sumThings(Collection<T> values, R acc, BiFunction<R, T, R> function) {
        for (var value: values) {
            acc = function.apply(acc, value);
        }
        return acc;
    }

    public Integer sumIntegers(Collection<Integer> values) {
        return sumThings(values, 0, (a, b) -> a + b);
    }

    public String sumStrings(Collection<String> values) {
        return sumThings(values, "", (a, b) -> a + b);
    }

    public Map<String, Integer> toKeyValue(Collection<Integer> values) {
        return sumThings(values, new HashMap<>(), (acc, value) -> {
            if (value <= 10) {
                acc.put(numbers[value], value);
            } else {
                acc.put("LOTS", value);
            }
            return acc;
        });

    }
}
