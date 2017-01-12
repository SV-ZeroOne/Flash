package za.co.entelect.bootcamp;

import java.util.Scanner;

/**
 * @author kevin.gouws
 *
 * Created on 2017/01/12.
 */
public class MainGame {
    private static Player playerOne, playerTwo;
    private static RulesReader rules;
    private static Scanner inputScanner;

    public static void main(String[] args) {
        inputScanner = new Scanner(System.in);
        playerOne = new Player();
        playerOne.setPlayerName("Computer");
        playerTwo = new Player();
        System.out.println("Welcome to the Roshambo Game");
        System.out.println("Please enter your name:");
        playerTwo.setPlayerName(inputScanner.nextLine());
        System.out.println("Please select your weapon:");
        // present player with numbered list of weapons
        // input numbered choice of weapon
        // assign weapon to player
        // randomize computer weapon
        // check rules list to determine winner
        // provide feedback
    }
}
