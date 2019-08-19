package com.codurance;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class YahtzeeGameShould {

    @Test
    void chance_returns_sum_of_rolls() {
        int[] rolls = {1,1,3,3,6};
        YahtzeeGame game = new YahtzeeGame();

        int actual = game.score(rolls, "chance");
        int expected = 14;
        assertThat(actual).isEqualTo(expected);
    }
}
