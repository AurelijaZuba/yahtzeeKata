package com.codurance;

import java.util.Arrays;

public class SumOfTwos implements Rule{
    public SumOfTwos() {
    }

    @Override
    public int score(int[] rolls) {
        return Arrays.stream(rolls).filter(roll -> roll == 2)
                .reduce(0, (a, b) -> a + b);
    }
}