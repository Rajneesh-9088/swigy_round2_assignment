package com.swiggy.assignment;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class MagicalArenaTest {
    @Test
    public void testFight() {
        Player playerA = new Player(50, 5, 10);
        Player playerB = new Player(100, 10, 5);

        MagicalArena arena = new MagicalArena(playerA, playerB);
        arena.fight();
        assertFalse(playerA.isAlive() && playerB.isAlive()); // Either playerA or playerB should be dead after the fight
    }
}
