package com.codurance;

import java.util.Arrays;

public class SumOfFives implements Rule{
    public SumOfFives() {
    }

    @Override
    public int score(int[] rolls) {
        return Arrays.stream(rolls).filter(roll -> roll == 5)
                .reduce(0, (a, b) -> a + b);
    }
}