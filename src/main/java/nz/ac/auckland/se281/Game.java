package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  // intialise fields
  private int roundNumber = 0;
  protected Choice choice;
  // player's detail
  private String playerName = null;
  private String playerInput;
  // record user's predominant choice by odd and even counter
  protected int evenCount = 0;
  // ai's detail
  private int aiInput;
  private ArtificialIntelligence ArtificialIntelligence;
  // result of sum
  private int sumInput;
  private Choice sumChoice;
  // sum of wins
  private int playerWin;
  private int aiWin;
  protected boolean win = false;
  private String winName;

  /**
   * This method creates a new game. Every element is cleared when new game is created, doesn't
   * store previous player's informations.
   *
   * @param difficulty the difficulty of the game base on player's input (Easy, medium, hard)
   * @param choice the choice of the player, player want sum to be this in order to win (Even, odd)
   * @param options an array of String, first element is the name of player
   */
  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    playerName = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(playerName);

    // give input of difficulty to factory that returns which method to use(Easy, Medium, Hard)
    // create in here avoid new object every time game method is run
    ArtificialIntelligence = new DifficultyFactory().createDifficulty(difficulty, choice);

    this.choice = choice;
    // intialise all counts
    roundNumber = 0;
    evenCount = 0;
    playerWin = 0;
    aiWin = 0;
    win = false;
  }

  /**
   * This method asks player for finger input amount, response with ai's finger input amount, get
   * the sum and displays who is the winner of this round. This method can only run when a game is
   * running.
   */
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
    aiInput = ArtificialIntelligence.getRobotNumber(evenCount, win);

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
      // set value to the following if player has win the game
      playerWin++;
      win = true;
      winName = playerName;
    } else {
      // set value to the following if ai win the game
      aiWin++;
      win = false;
      winName = "HAL-9000";
    }

    // print result of this round for winner
    MessageCli.PRINT_OUTCOME_ROUND.printMessage(
        Integer.toString(sumInput), sumChoice.toString(), winName);
  }

  /**
   * This method prints the overall output of the game, by displaying the statistics and the winner.
   */
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

  /**
   * This method is used to show the statistic of both player and ai on the current round. This
   * method can only run when a game is running, it shows for each player how many rounds they won
   * and how many rounds they need to win the game.
   */
  public void showStats() {
    // check if they are in a game, if not the playerName should be null
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
