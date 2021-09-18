package com.codecool;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");
        // write function that finds most occurring element in list
    }

    // O(n^2)
    private static int findMostOccurringElement1(List<Integer> elements) {
        int maxOccurrences = 0;
        int maxValue = -1;

        for (int i = 0; i < elements.size(); i++) {
            int currentValue = elements.get(i);
            int currentValueOccurrences = 0;

            for (int j = i; j < elements.size(); j++) {
                int nextElement = elements.get(j);
                if (currentValue == nextElement) {
                    currentValueOccurrences++;
                }
            }

            if (currentValueOccurrences > maxOccurrences) {
                maxOccurrences = currentValueOccurrences;
                maxValue = currentValue;
            }

        }
        return maxValue;
    }

    // O(n*log(n))
    private static int findMostOccurringElement2(List<Integer> elements) {
        Collections.sort(elements);

        int maxOccurrences = 0;
        int maxValue = -1;
        // 1 1 1 1 2
        for (int i = 0; i < elements.size(); i++) {
            int currentElement = elements.get(i);
            int occurrences = 1;
            while (i < elements.size() - 1 && elements.get(i + 1) == currentElement) {
                occurrences++;
                i++;
            }

            if (occurrences > maxOccurrences) {
                maxOccurrences = occurrences;
                maxValue = currentElement;
            }

        }
        return maxValue;
    }

    // O(n)
    private static int findMostOccurringElement3(List<Integer> elements) {

        Map<Integer, Integer> elementToOccurrences = new HashMap<>();
        for (int element : elements) {
            int currentOccurrences = elementToOccurrences.getOrDefault(element, 0);
            currentOccurrences++;
            elementToOccurrences.put(element, currentOccurrences);
        }

        int maxOccurrences = 0;
        int maxValue = -1;

        for (int element : elements) {
            int occurrences = elementToOccurrences.get(element);
            if (maxOccurrences < occurrences) {
                maxOccurrences = occurrences;
                maxValue = element;
            }
        }
        return maxValue;
    }
}
