package com.swiggy.assignment; // Defines the package for this class

import java.util.Random; // Imports the Random class

class Player { // Defines the Player class
    int health; // Player's health attribute
    int strength; // Player's strength attribute
    int attack; // Player's attack attribute
    Random random; // Random object for dice rolls

    public Player(int health, int strength, int attack) { // Constructor for Player class
        this.health = health;
        this.strength = strength;
        this.attack = attack;
        this.random = new Random(); // Initialize the Random object
    }

    int getHealth() { // Getter for health
        return health;
    }

    int attack() { // Simulates an attack roll
        int res = random.nextInt(6) + 1; // 6-sided die roll
        return res; // Return the result of the die roll
    }

    int defend() { // Simulates a defense roll
        int res = random.nextInt(6) + 1; // 6-sided die roll
        return res; // Return the result of the die roll
    }

    void reduceHealth(int damage) { // Reduces the player's health by the given damage
        health -= damage;
    }

    boolean isAlive() { // Checks if the player is still alive
        return health > 0;
    }
}

class MagicalArena { // Defines the MagicalArena class
    Player playerA; // Player A
    Player playerB; // Player B

    public MagicalArena(Player playerA, Player playerB) { // Constructor for MagicalArena class
        this.playerA = playerA;
        this.playerB = playerB;
    }

    public boolean special_case(Player A1, Player D1) { // Checks for a special case draw condition
        if (A1.attack * 6 < D1.strength && D1.attack * 6 < A1.strength) {
            return true;
        } else {
            return false;
        }
    }

    void fight() { // Simulates a fight between two players
        Player attacker = playerA.health < playerB.health ? playerA : playerB; // Determine the initial attacker
        Player defender = attacker == playerA ? playerB : playerA; // Determine the initial defender
        Boolean flag = special_case(attacker, defender); // Check for special case draw condition
        if (flag == true) {
            System.out.print("Draw");
            return;
        }
        while (playerA.isAlive() && playerB.isAlive() && flag == false) { // Fight continues until one player dies or a special case draw occurs
            int attackRoll = attacker.attack(); // Attacker rolls the attack die
            int defenseRoll = defender.defend(); // Defender rolls the defense die

            int damage = attackRoll * attacker.attack - defenseRoll * defender.strength; // Calculate the damage
            if (damage > 0) {
                defender.reduceHealth(damage); // Apply damage to the defender's health
            }

            // Swap roles for the next round
            Player temp = attacker;
            attacker = defender;
            defender = temp;
            flag = special_case(attacker, defender); // Check for special case draw condition after swapping
            if (flag == true) {
                System.out.print("Draw");
                return;
            }
        }

        if (playerA.isAlive()) { // Check if player A is still alive
            System.out.println("Player A wins!");
        } else { // Otherwise, player B wins
            System.out.println("Player B wins!");
        }
    }
}

public class Main { // Main class to run the program
    public static void main(String[] args) {
        // Initialize players
        // Player playerA = new Player(50, 5, 10); 
        Player playerA = new Player(0, 37, 1); 
        // Player playerB = new Player(100, 10, 5);
        Player playerB = new Player(0, 37, 1);

        MagicalArena arena = new MagicalArena(playerA, playerB); // Create a new MagicalArena object with player A and player B

        if (playerA.health == 0 || playerB.health == 0) { // Check for initial conditions where either player has 0 health
            if (playerA.health == 0 && playerB.health == 0) { // Both players have 0 health
                System.out.println("Draw");
            } else if (playerA.health == 0) { // Player A has 0 health
                System.out.println("Player B wins!");
            } else { // Player B has 0 health
                System.out.println("Player A wins!");
            }
            return; // Exit the program
        } else {
            arena.fight(); // Start the fight
        }
    }
}
