/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.tstc.depanfilis.depanfilis_mastery6;

/**
 *
 * @author Anthony
 */
public class Player {
    //declaring variables
    private String name;
    private int guesses;
    //constructors
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public int getGuesses() {
        return guesses;
    }
    
    public void addGuesses() { //increments guesses after each attempt or even solving the phrase
        guesses++;
    }
    
    public void resetGuessAttempts() { //set guesses to 0 at the end of the game and beginning
        guesses = 0;
    }
    
}
