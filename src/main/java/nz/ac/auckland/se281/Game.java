package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  // intialise fields
  int roundNumber = 0;
  Choice choice;
  // player's detail
  String playerName = null;
  String playerInput;
  // record user's predominant choice by odd and even counter
  int evenCount = 0;
  // ai's detail
  int aiInput;
  AIInstance aiInstance;
  // result of sum
  int sumInput;
  Choice sumChoice;
  // sum of wins
  int playerWin;
  int aiWin;
  boolean win = false;
  String winName;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    playerName = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(playerName);

    // give input of difficulty to factory that returns which method to use(Easy, Medium, Hard)
    // create in here avoid new object every time game method is run
    aiInstance = new DifficultyFactory().createDifficulty(difficulty, choice);

    this.choice = choice;
    // intialise all counts
    roundNumber = 0;
    evenCount = 0;
    playerWin = 0;
    aiWin = 0;
    win = false;
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
    // as long as player's input is outside of range 0-5 or not a number
    while (!Utils.isInteger(playerInput)
        || Integer.parseInt(playerInput) > 5
        || Integer.parseInt(playerInput) < 0) {
      // print error message
      MessageCli.INVALID_INPUT.printMessage();
      // ask player for finger again
      MessageCli.ASK_INPUT.printMessage();
      // fetch for player's input, exit while loop with appropriate input
      playerInput = Utils.scanner.nextLine();
    }
    // print player's name and finger input amount
    MessageCli.PRINT_INFO_HAND.printMessage(playerName, playerInput);

    // get aiInput from method in aiInstance class
    aiInput = aiInstance.getAIRandomNumber(evenCount, win);

    // print ai's name and finger input amount
    MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", Integer.toString(aiInput));

    // determine whether player's input is even or odd
    if (Utils.isEven(Integer.parseInt(playerInput))) {
      evenCount++;
    }

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
    MessageCli.PRINT_OUTCOME_ROUND.printMessage(
        Integer.toString(sumInput), sumChoice.toString(), winName);
  }

  public void endGame() {
    this.showStats();
    if (playerName != null) {
      // check if tie
      if (playerWin == aiWin) {
        MessageCli.PRINT_END_GAME_TIE.printMessage();
      } else if (playerWin > aiWin) {
        // if player wins
        MessageCli.PRINT_END_GAME.printMessage(playerName);
      } else if (aiWin > playerWin) {
        MessageCli.PRINT_END_GAME.printMessage("HAL-9000");
      }
      // set playerName to null as a sign of game ended
      playerName = null;
    }
  }

  public void showStats() {
    // check if they started a new game
    if (playerName == null) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    // return total result of player
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        playerName, Integer.toString(playerWin), Integer.toString(aiWin));
    // return total result of player
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        "HAL-9000", Integer.toString(aiWin), Integer.toString(playerWin));
  }
}
