package com.codurance;

import java.util.Arrays;

public class Chance implements Rule {
    public Chance() {
    }

    @Override
    public int score(int[] rolls) {

        return Arrays.stream(rolls).reduce(0, (a, b) -> a + b);
    }
}