package com.codecool;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    public void whenFindMostOccurringElement1_FindCorrectResult() {
        List<Integer> elements = Arrays.asList(1, 1, 1, 2, 2, 3);
        int expected = 1;

        int result = Main.findMostOccurringElement1(elements);

        assertEquals(expected, result);
    }

    @Test
    public void whenFindMostOccurringElement1ForEmptyList_FindCorrectResult() {
        List<Integer> elements = Collections.emptyList();
        int expected = -1;

        int result = Main.findMostOccurringElement1(elements);

        assertEquals(expected, result);
    }

}