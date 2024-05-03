package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  // intialised fields
  int roundnumber = 0;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
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
    // if player's input is larger than 5
    if (Integer.parseInt(input) > 5) {
      // print error message
      MessageCli.INVALID_INPUT.printMessage();
    }
  }

  private boolean IntergerParseint(String input) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'IntergerParseint'");
  }

  public void endGame() {}

  public void showStats() {}
}
