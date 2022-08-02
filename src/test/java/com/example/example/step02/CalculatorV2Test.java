package com.example.example.step02;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.*;

class CalculatorV2Test {

    @ParameterizedTest
    @MethodSource("provider")
    void Add_MultipleNumbers_ReturnsCorrectResults(int var1, int var2, int result) {
        // when
        StringCalculator stringCalculator = new StringCalculator(var1, var2);
        // then
        int addResult = stringCalculator.add();
        assertEquals(addResult, result);
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

    private static Stream<Arguments> provider() {
        return Stream.of(
                arguments(0, 0, 0),
                arguments(1, 2, 3),
                arguments(2, 4, 6)
        );
    }

}
