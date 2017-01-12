package za.co.entelect.bootcamp;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author kevin.gouws
 *
 * Created on 2017/01/12.
 */
public class MainGame {
    private static Player playerOne, playerTwo;
    private static int playerChoice;
    private static RulesReader rules;
    private static Scanner inputScanner;
    private final static Logger LOGGER = Logger.getLogger(MainGame.class.getName());

    public static void main(String[] args) {
        LOGGER.setLevel(Level.INFO);
        playerOne = new Player("Computer");
        playerTwo = new Player();
        inputScanner = new Scanner(System.in);
        System.out.println("Welcome to the Roshambo Game");
        System.out.println("Please enter your name:");
        playerTwo.setPlayerName(inputScanner.nextLine());
        playGame();
    }

    public static void playGame() {
        String playAgain;
        rules = new RulesReader();
        try {
            rules.readDatabase();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Please select your weapon:");
        for (int i = 0; i < rules.getWeapons().size(); i++) {
            System.out.println((i + 1) + ". " + rules.getWeapons().get(i));
        }
        playerChoice = inputScanner.nextInt();
        playerTwo.setWeaponChoice(rules.getWeapon(rules.getWeapons().get(playerChoice - 1)));
        int index = (int) (Math.random() * rules.getWeapons().size());
        playerOne.setWeaponChoice(rules.getWeapon(rules.getWeapons().get(index)));
        String playerOneWeapon = playerOne.getWeaponChoice().getName();
        String playerTwoWeapon = playerTwo.getWeaponChoice().getName();
        System.out.println("=========================================================================================");
        if (playerOneWeapon.equals(playerTwoWeapon)) {
            System.out.println("It's a draw! You both selected " + playerOneWeapon);
        } else {
            for (int i = 0; i < playerTwo.getWeaponChoice().getWinConditions().size(); i++) {
                if (playerOneWeapon.equals(playerTwo.getWeaponChoice().getWinConditions().get(i).toString())) {
                    System.out.println(playerTwo.getPlayerName() + " Wins!");
                    System.out.println(playerTwoWeapon + " beats " + playerOneWeapon);
                }
            }
            for (int j = 0; j < playerOne.getWeaponChoice().getWinConditions().size(); j++) {
                if (playerTwoWeapon.equals(playerOne.getWeaponChoice().getWinConditions().get(j).toString())) {
                    System.out.println(playerOne.getPlayerName() + " Wins!");
                    System.out.println(playerOneWeapon + " beats " + playerTwoWeapon);
                }
            }
        }
        System.out.println("=========================================================================================");
        System.out.println("Play Again? (y/n)");
        inputScanner.nextLine();
        playAgain = inputScanner.nextLine();

        if (playAgain.equals("y")) {
            playGame();
        } else {
            System.exit(0);
        }
    }
}
