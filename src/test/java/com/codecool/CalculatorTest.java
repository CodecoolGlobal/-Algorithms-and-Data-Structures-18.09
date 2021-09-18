package com.codecool;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    // @BeforeAll, @BeforeEach @AfterEach, @AfterAll

    private static Calculator calculator;

    @BeforeAll
    public static void setup() {
        System.out.println("Setting up a calculator");
        calculator = new Calculator();
    }


    @BeforeEach
    public void logNewTest() {
        System.out.println("Starting new test");
    }

    @Test
    @DisplayName("Adding 2 numbers ;)")
    public void whenAddingTwoNumbers_ExpectCorrectResult() {
        int result = calculator.add(1, 1);

//        assertTrue(false);
//        assertFalse(false);
        assertEquals(2, result);
        assertNotEquals(3, result);
        assertNotNull(calculator);
    }

    @Test
    @Disabled("Calculator is not null work in progress")
    public void whenCalculatorIsNull_ExpectNullCalculator() {
        Calculator nullCalculator = null;
        assertNull(nullCalculator);
    }

    @Test
    public void whenDivideNumbers_expectCorrectResult() {

        int result = calculator.divide(4, 2);

        assertEquals(2, result);
    }

    @Test
    public void whenDivideByZero_expectArithmeticException() {

        assertThrows(ArithmeticException.class, () -> {
            int result = calculator.divide(4, 0);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, -3, 15})
    public void isOdd_ShouldReturnTrueForOddNumbers(int number) {
        assertTrue(calculator.isOdd(number));
    }


    @ParameterizedTest
    @MethodSource("provideStringsForIsBlank")
    public void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input, boolean expected) {
        assertEquals(expected, StringUtils.isBlank(input));
    }


    public static List<Arguments> provideStringsForIsBlank() {
        return Arrays.asList(
                Arguments.of(null, true),
                Arguments.of("", true),
                Arguments.of("  ", true),
                Arguments.of("not blank", false)
        );
    }
}