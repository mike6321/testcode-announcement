package com.example.example.step01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.testcontainers.shaded.com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorV1Test {

    @Test
    void Add_MultipleNumbers_ReturnsCorrectResults() {
        // when
        List<StringCalculator> testData = List.of(
                new StringCalculator(0, 0),
                new StringCalculator(1, 2),
                new StringCalculator(2, 4)
        );
        // then
        AtomicInteger expected = new AtomicInteger(0);
        testData.forEach(data -> {
            int result = data.add();
            assertEquals(result, expected.get());
            expected.getAndAdd(3);
        });
    }

    static class StringCalculator {

        private final int var1;
        private final int var2;

        public StringCalculator(int var1, int var2) {
            this.var1 = var1;
            this.var2 = var2;
        }

        public int add() {
            return var1 + var2;
        }

    }

}
