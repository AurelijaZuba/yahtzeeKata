package com.codurance;

import java.util.Arrays;

public class MultipleOfFours implements Rule{
    public MultipleOfFours() {
    }

    @Override
    public int score(int[] rolls) {
        return Arrays.stream(rolls).filter(roll2 -> roll2 == 4)
                .reduce(0, (a2, b2) -> a2 + b2);
    }
}