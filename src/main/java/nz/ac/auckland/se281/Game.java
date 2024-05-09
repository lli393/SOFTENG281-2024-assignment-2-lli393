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
  String playerName = null;
  String playerInput;
  Choice playerChoice;
  // record user's predominant choice by odd and even counter
  int evenCount = 0;
  // ai's detail
  int aiInput;
  // result of sum
  int sumInput;
  Choice sumChoice;
  // sum of wins
  int playerWin;
  boolean win = false;
  int aiWin;
  String winName;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    playerName = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(playerName);
    this.difficulty = difficulty;
    this.choice = choice;
  }

  public void play() {
    // check if they started a new game
    if (playerName == null) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }
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
    // determine whether player's input is even or odd
    if (Utils.isEven(Integer.parseInt(playerInput))) {
      playerChoice = Choice.EVEN;
      evenCount++;
    } else {
      playerChoice = Choice.ODD;
    }

    // give input of difficulty to factory that returns which method to use(Easy, Medium, Hard)
    DifficultyLevel level =
        new DifficultyFactory(roundNumber, evenCount, choice, win).createDifficulty(difficulty);
    // use the method to get strategy
    // create ai
    AIInstance ai = level.getStrategy();
    aiInput = ai.getAINum();

    // print ai's name and finger input amount
    MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", Integer.toString(aiInput));

    // get result sum for player and ai
    sumInput = Integer.parseInt(playerInput) + aiInput;
    // get result sum is even or odd
    if (Utils.isEven(sumInput)) {
      // if even store winning choice
      sumChoice = Choice.EVEN;
    } else if (Utils.isOdd(sumInput)) {
      // if odd
      sumChoice = Choice.ODD;
    }
    // check what player have choosen and check if it matches with the winning choice
    if (choice == sumChoice) {
      // player win
      playerWin++;
      win = true;
      winName = playerName;
    } else {
      // ai win
      aiWin++;
      win = false;
      winName = "HAL-9000";
    }

    // print result of this round for winner
    // print result of this round for winner
    MessageCli.PRINT_OUTCOME_ROUND.printMessage(
        Integer.toString(sumInput), sumChoice.toString(), winName);
  }

  public void endGame() {}

  public void showStats() {}
}
