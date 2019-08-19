package com.codurance;

import java.util.Arrays;

public class SumOfThrees implements Rule{
    public SumOfThrees() {
    }

    @Override
    public int score(int[] rolls) {
        return Arrays.stream(rolls).filter(roll -> roll == 3)
                .reduce(0, (a, b) -> a + b);
    }
}