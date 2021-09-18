package com.codecool;

import java.util.*;

// https://www.hackerrank.com/challenges/java-stack/problem
class Solution {

    public static void main(String[] argh) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.next();
            boolean valid = checkIfValidParenthesis(input);
            System.out.println(valid);
        }

    }

    private static boolean checkIfValidParenthesis(String input) {
        Stack<Character> notClosedBracketsYet = new Stack<>();
        Map<Character, Character> openedToClosed = getCharacterCharacterMap();
        List<Character> openings = Arrays.asList('(', '[', '{');

        for (char element : input.toCharArray()) {
            if (openings.contains(element)) {
                notClosedBracketsYet.push(element);
            } else {
                char matchingOpening = openedToClosed.get(element);
                if (notClosedBracketsYet.isEmpty()) {
                    return false;
                }
                char stackElement = notClosedBracketsYet.pop();
                if (stackElement != matchingOpening)
                    return false;
            }
        }


        return notClosedBracketsYet.isEmpty();
    }

    private static Map<Character, Character> getCharacterCharacterMap() {
        Map<Character, Character> openedToClosed = new HashMap<>();
        openedToClosed.put(')', '(');
        openedToClosed.put(']', '[');
        openedToClosed.put('}', '{');
        return openedToClosed;
    }
}