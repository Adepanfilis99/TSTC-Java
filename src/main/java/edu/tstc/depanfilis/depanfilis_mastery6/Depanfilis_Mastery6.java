/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package edu.tstc.depanfilis.depanfilis_mastery6;

/**
 *
 * @author Anthony
 */
import java.util.Scanner;
import java.util.Random;
public class Depanfilis_Mastery6 {


    
    public static void main(String[] args) {
        String[] phrases = {"java is life", "did it run", "program builder", "debug and try again", "complicated code"};
        Random rand = new Random();
        Player player = new Player();//creating object from player class
        Scanner input = new Scanner(System.in); // creating input
        System.out.println("Welcome to the guessing game!"); // message to welcome user to the game
        System.out.println("The Objective of the game is to guess letters of the hidden phrase, you have enough guesses as the length of the phrase");
        System.out.print("What is your name: ");
        String playerName = input.nextLine();
        player.setName(playerName);
        boolean playAgain = true;
        
        while (playAgain) { // building the clue to subsitute the phrases characters for * , also resetting the game if the user does want to play again
            String phrase = phrases[rand.nextInt(phrases.length)]; //selects the random index of the array
            player.getGuesses();// initialzing guess counter from player class
            StringBuilder clue = new StringBuilder(); //building the string clue using append 
            for (int i = 0; i < phrase.length(); i++) {
                if (phrase.charAt(i) == ' ') {
                    clue.append(' ');
                } else {
                    clue.append('*');
                }
            }
            
            boolean solved = false;
            while (!solved && player.getGuesses() < phrase.length()) {/// player has finite # guesses which is length of the phrase
                System.out.println("\n" + clue); // presents the clue which shows the amount of characters
                System.out.print("Guess a single letter or the whole phrase: ");//giving user the rule
                
                String guess =input.nextLine().toLowerCase();
                
                if (guess.length() == 1) { // if input is 1 character the problem is not solved but will add the found character and reveal its location in the phrase
                    boolean found = false;
                    for (int i = 0; i < phrase.length(); i++) {
                        if (phrase.charAt(i) == guess.charAt(0)) { // equals character 
                            clue.setCharAt(i, guess.charAt(0)); // sets the character 
                            found = true;
                        }
                    }
                    if (found) {
                        System.out.println("Correct, keep guessing"); // if found it will let user no their guess is right and will move on to next guess while adding to the guess count
                        player.addGuesses();
                    } else {
                        System.out.println("That is not a letter in the phrase, guess again!"); // if not found it will let user know that there guesss is not right and will move to the next guess while adding to the guess count
                        player.addGuesses();
                    }
                } else if (guess.equals(phrase)) { // if the entire phrase is guessed the program will display a message to the player
                    System.out.println("\nCongratulations, you solved the secret phrase!");
                    System.out.println("-------------------------------------------------");
                    solved = true;
                    player.addGuesses();;// guessing the phrase will still count as a guess 
                } else {
                    System.out.println("Incorrect.");
                    player.addGuesses();;// if the phrase was not entered correctly, the program will let the user know it was incorrect and add to the guess count
                }
            }
            
            if (!solved) {
                System.out.println("\nSorry, you ran out of guesses. The secret phrase was: " + phrase);// user runs out of guesses 
            } else {
                System.out.println("\nNice guessing skills " + player.getName() + ", you solved the secret phrase in " + (player.getGuesses()) + " guess!"); // message to user if solved, which tells user they solved the hidden phrase in x amount of guesses
            }
            
            System.out.print("\nPlay again? (y/n): "); //asking to play again
            String playAgainInput = input.nextLine().toLowerCase();
            playAgain = playAgainInput.equals("y"); // input from user to play again bringing them back to the game 
            player.resetGuessAttempts();// reset the guesses to 0. pulled from player class 
            if(playAgainInput.equals("n")){
                System.out.println("Thank you for playing"); // message if they decclare no
            }
        }
        
        input.close();
    }
}
        
    
