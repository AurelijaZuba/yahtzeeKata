package com.codurance;

import java.util.Arrays;

public class MultipleOfFives implements Rule{
    public MultipleOfFives() {
    }

    @Override
    public int score(int[] rolls) {
        return Arrays.stream(rolls).filter(roll1 -> roll1 == 5)
                .reduce(0, (a1, b1) -> a1 + b1);
    }
}