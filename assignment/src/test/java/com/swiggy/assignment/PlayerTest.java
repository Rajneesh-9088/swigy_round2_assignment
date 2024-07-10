package com.swiggy.assignment; // Defines the package for this class

import static org.junit.Assert.assertTrue; // Imports the assertTrue method from JUnit

import org.junit.Test; // Imports the Test annotation from JUnit

public class PlayerTest { // Declares the PlayerTest class
    
    @Test // Indicates that this is a test method
    public void testAttack() { // Tests the attack functionality
        Player player = new Player(50, 5, 10); // Creates a new Player object
        int attackRoll = player.attack(); // Calls the attack method
        assertTrue("Attack roll should be between 1 and 6", attackRoll >= 1 && attackRoll <= 6); // Asserts the attack roll is valid
    }
    
    @Test // Indicates that this is a test method
    public void testDefend() { // Tests the defend functionality
        Player player = new Player(100, 5, 10); // Creates a new Player object
        int defenseRoll = player.defend(); // Calls the defend method
        assertTrue("Defense roll should be between 1 and 6", defenseRoll >= 1 && defenseRoll <= 6); // Asserts the defense roll is valid
    }
}
