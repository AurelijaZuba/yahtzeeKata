package com.codurance;

import java.util.Arrays;

public class MultiplesOfOne implements Rule{
    public MultiplesOfOne() {
    }

    @Override
    public int score(int[] rolls) {
        return Arrays.stream(rolls).filter(roll -> roll == 1)
                .reduce(0, (a, b) -> a + b);
    }
}