package nz.ac.auckland.se281;

import java.util.Random;
import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  // intialise fields
  int roundnumber = 0;
  Difficulty difficulty;

  // player's detail
  String playername;
  String playerinput;
  // ai's detail
  int aiinput;
  // sum of wins
  int playerwin;
  int aiwin;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    playername = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    this.difficulty = difficulty;
  }

  public void play() {
    // increment on round number each iteration
    roundnumber++;
    MessageCli.START_ROUND.printMessage(Integer.toString(roundnumber));
    // ask player for finger
    MessageCli.ASK_INPUT.printMessage();
    // fetch for player's input
    playerinput = Utils.scanner.nextLine();
    // as long as player's input is outside of range 0-5
    while (Integer.parseInt(playerinput) > 5 || Integer.parseInt(playerinput) < 0) {
      // print error message
      MessageCli.INVALID_INPUT.printMessage();
      // ask player for finger again
      MessageCli.ASK_INPUT.printMessage();
      // fetch for player's input, exit while loop with appropriate input
      playerinput = Utils.scanner.nextLine();
    }
    // print player's name and finger input amount
    MessageCli.PRINT_INFO_HAND.printMessage(playername, playerinput);

    // get ai's input
    // if the player choose easy
    if (difficulty == Difficulty.EASY) {
      // ai select random integers from 0-5
      // https://stackoverflow.com/questions/5887709/getting-random-numbers-in-java#:~:text=import%20java.util.Random%3B%20Random%20rand%20%3D%20new%20Random%28%29%3B%20%2F%2F,to%20get%20a%20number%20from%20the%20required%20range
      Random randomnumber = new Random();
      aiinput = randomnumber.nextInt(6); // range: 0-n bound/inside bracket=n+1
    }
    // print ai's name and finger input amount
    MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", Integer.toString(aiinput));
  }

  public void endGame() {}

  public void showStats() {}
}
