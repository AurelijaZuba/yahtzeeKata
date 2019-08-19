package com.codurance;

import java.util.Arrays;

public class SumOfSixes implements Rule{
    public SumOfSixes() {
    }

    @Override
    public int score(int[] rolls) {
        return Arrays.stream(rolls).filter(roll -> roll == 6)
                .reduce(0, (a, b) -> a + b);
    }
}