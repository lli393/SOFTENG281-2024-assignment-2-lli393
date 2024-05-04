package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  // intialise fields
  int roundNumber = 0;
  Difficulty difficulty;
  Choice choice;
  // player's detail
  String playerName;
  String playerInput;
  // ai's detail
  int aiInput;
  // result of sum
  int sumInput;
  String sumChoice;
  // sum of wins
  int playerWin;
  int aiWin;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    playerName = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(playerName);
    this.difficulty = difficulty;
    this.choice = choice;
  }

  public void play() {
    // increment on round number each iteration
    roundNumber++;
    MessageCli.START_ROUND.printMessage(Integer.toString(roundNumber));
    // ask player for finger
    MessageCli.ASK_INPUT.printMessage();
    // fetch for player's input
    playerInput = Utils.scanner.nextLine();
    // as long as player's input is outside of range 0-5
    while (Integer.parseInt(playerInput) > 5 || Integer.parseInt(playerInput) < 0) {
      // print error message
      MessageCli.INVALID_INPUT.printMessage();
      // ask player for finger again
      MessageCli.ASK_INPUT.printMessage();
      // fetch for player's input, exit while loop with appropriate input
      playerInput = Utils.scanner.nextLine();
    }
    // print player's name and finger input amount
    MessageCli.PRINT_INFO_HAND.printMessage(playerName, playerInput);

    // get ai's input
    // if the player choose easy
    if (difficulty == Difficulty.EASY) {
      // ai select random integers from 0-5
      aiInput = Utils.getRandomNumberRange(0, 5); // range: 0-n bound/inside bracket=n+1
    }
    // print ai's name and finger input amount
    MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", Integer.toString(aiInput));
  }

  public void endGame() {}

  public void showStats() {}
}
