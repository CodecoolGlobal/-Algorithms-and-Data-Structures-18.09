package com.codecool.lambda;

public class DisplayRepeatOperation implements RepeatOperation{
    @Override
    public void execute(int iteration) {
        System.out.println("Iteration nr." + iteration);
    }
}
