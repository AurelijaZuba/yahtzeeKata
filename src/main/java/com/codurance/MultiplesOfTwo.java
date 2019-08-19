package com.codurance;

import java.util.Arrays;

public class MultiplesOfTwo implements Rule{
    public MultiplesOfTwo() {
    }

    @Override
    public int score(int[] rolls) {
        return Arrays.stream(rolls).filter(roll4 -> roll4 == 2)
                .reduce(0, (a4, b4) -> a4 + b4);
    }
}