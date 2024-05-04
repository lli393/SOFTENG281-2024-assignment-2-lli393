package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  // intialise fields
  int roundnumber = 0;
  String playername;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    playername = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
  }

  public void play() {
    // increment on round number each iteration
    roundnumber++;
    MessageCli.START_ROUND.printMessage(Integer.toString(roundnumber));
    // ask player for finger
    MessageCli.ASK_INPUT.printMessage();
    // fetch for player's input
    String input = Utils.scanner.nextLine();
    // as long as player's input is outside of range 0-5
    while (Integer.parseInt(input) > 5 || Integer.parseInt(input) < 0) {
      // print error message
      MessageCli.INVALID_INPUT.printMessage();
      // ask player for finger again
      MessageCli.ASK_INPUT.printMessage();
      // fetch for player's input, exit while loop with appropriate input
      input = Utils.scanner.nextLine();
    }
    MessageCli.PRINT_INFO_HAND.printMessage(playername, input);
  }

  public void endGame() {}

  public void showStats() {}
}
