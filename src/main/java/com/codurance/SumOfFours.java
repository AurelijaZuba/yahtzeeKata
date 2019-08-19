package com.codurance;

import java.util.Arrays;

public class SumOfFours implements Rule{
    public SumOfFours() {
    }

    @Override
    public int score(int[] rolls) {
        return Arrays.stream(rolls).filter(roll -> roll == 4)
                .reduce(0, (a, b) -> a + b);
    }
}