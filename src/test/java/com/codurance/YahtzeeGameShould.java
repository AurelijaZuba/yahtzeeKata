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

    @Test
    void ones_returns_sum_of_all_ones() {
        int[] rolls = {1,1,2,4,4};
        YahtzeeGame game = new YahtzeeGame();

        int expected = 2;
        int actual = game.score(rolls, "ones");
        assertThat(actual).isEqualTo(expected);
    }
}
