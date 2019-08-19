package com.codurance;

import java.util.Arrays;

public class YahtzeeGame {
    public int chance(int[] rolls) {
        return Arrays.stream(rolls).reduce(0, (a, b) -> a + b);
    }
}
