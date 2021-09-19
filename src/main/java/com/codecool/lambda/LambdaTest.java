package com.codecool.lambda;

import java.util.Arrays;
import java.util.List;

public class LambdaTest {

    public static void main(String[] args) {

        repeat(5, new DisplayRepeatOperation());
        repeat(5, new RepeatOperation() {
            @Override
            public void execute(int iteration) {
                System.out.println("Iteration nr." + iteration);
            }
        });
        repeat(5, (i) -> System.out.println("Iteration nr." + i));

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 2, 3, 4, 4, 5, 6, 7, 8, 5);
        displayAll(1, 2, 3, 4, 5);
    }

    public static void displayAll(Integer... integers) {
        for (Integer i : integers) {
            System.out.println(i);
        }
    }

    public static void repeat(int times, RepeatOperation testInterface) {
        for (int i = 0; i < times; i++) {
            testInterface.execute(i);
        }
    }
}
