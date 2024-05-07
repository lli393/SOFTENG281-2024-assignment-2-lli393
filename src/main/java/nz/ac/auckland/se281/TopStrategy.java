package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class TopStrategy implements Strategy {

  @Override
  public int getRandomNumber() {
    // get player's choice and most predominant choice
    Game game = new Game();
    Choice choice = game.choice;
    Choice mostChoice = game.mostChoice;
    // if player choose even to win, ai want sum to be odd
    if (choice == Choice.EVEN) {
      // if player is more likely to choose even, ai input odd
      if (mostChoice == Choice.EVEN) {
        return Utils.getRandomOddNumber();
      } else {
        return Utils.getRandomEvenNumber();
      }

      // if player choose odd to win, ai want sum to be even
    } else if (choice == Choice.ODD) {
      // if player is more likely to choose even, ai input even
      if (mostChoice == Choice.EVEN) {
        return Utils.getRandomEvenNumber();
      } else {
        return Utils.getRandomOddNumber();
      }
    }
    return -1;
  }
}
