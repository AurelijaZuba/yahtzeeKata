package com.codurance;

import java.util.Arrays;

public class MultipleOfThrees implements Rule{
    public MultipleOfThrees() {
    }

    @Override
    public int score(int[] rolls) {
        return Arrays.stream(rolls).filter(roll3 -> roll3 == 3)
                .reduce(0, (a3, b3) -> a3 + b3);
    }
}