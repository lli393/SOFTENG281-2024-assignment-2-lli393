package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class HardLevel implements DifficultyLevel {
  int roundNumber;
  Choice choice;
  int evenCount;
  int oddCount;
  boolean win = false;

  public HardLevel(int roundNumber, Choice choice, int evenCount, boolean win) {
    this.roundNumber = roundNumber;
    this.choice = choice;
    this.evenCount = evenCount;
    oddCount = roundNumber - evenCount;
    this.win = win;
  }

  @Override
  public AI getStrategy() {
    // create ai
    AI ai = new AI(new RandomStrategy());

    // use random strategy for the first 3 round, switch to random or top strategy afterwards
    if (roundNumber <= 3) {
      return ai;
    } else if (win) {
      // if player win and ai lose, switch the strategy
      // if ai is at random strategy change to top
      if (ai.getAIStrategy().equals(new RandomStrategy())) {
        ai.setStrategy(new TopStrategy(choice, evenCount, oddCount));
        // else if ai is at top change to random
      } else {
        ai.setStrategy(new RandomStrategy());
      }
      return ai;
    } else {
      // keep the strategy
      return ai;
    }
  }
}
