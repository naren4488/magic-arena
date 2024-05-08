package test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import src.*;

public class MainClassTest {

    @Test
    public void testRollDie() {
        int dieValue = MainClass.rollDie();

        // Die value should be between 1 and 6
        assertEquals(true, dieValue >= 1 && dieValue <= 6);
    }

    @Test
    public void testPlayerObjectCreation() {
        int health = 50;
        int strength = 5;
        int attack = 10;
        Player playerA = new Player(health, 5, 10);

        // Player should be created with provided values
        assertEquals(playerA.getHealth(), health);
        assertEquals(playerA.getStrength(), strength);
        assertEquals(playerA.getAttack(), attack);
    }

    @Test
    public void testLowerHealthInitialAttacker() {
        Player playerA = new Player(50, 5, 10);
        Player playerB = new Player(100, 10, 5);

        Player[] initialAttacker = MainClass.getInitiaPlayers(playerA, playerB);

        // Player with lower health should be initial attacker
        assertEquals(playerA, initialAttacker[0]);
        assertEquals(playerB, initialAttacker[1]);
    }

    @Test
    public void testLoserHealthZeroOrNegative() {
        Player playerA = new Player(100, 10, 5);
        Player playerB = new Player(50, 5, 10);

        Player winner[] = MainClass.fight(playerA, playerB);

        // health of loser should be zero or negative
        assertEquals(true, winner[1].getHealth() <= 0);
    }

    @Test
    public void testWinnerHealthPositive() {
        Player playerA = new Player(100, 10, 5);
        Player playerB = new Player(50, 5, 10);

        Player winner[] = MainClass.fight(playerA, playerB);

        // health of winner should be positive
        assertEquals(true, winner[0].getHealth() > 0);
    }

}
