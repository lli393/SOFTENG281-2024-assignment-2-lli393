package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public abstract class AIInstance {

  int roundNumber;
  Choice choice;
  int evenCount;
  int oddCount;
  boolean win;

  Strategy strategy;

  public int getAIRandomNumber(int evenCount, boolean win) {
    // in every round this function will be run
    // this counter can counts every round
    roundNumber++;
    this.evenCount = evenCount;
    oddCount = roundNumber - evenCount - 1; // count does not include current round so minus one
    this.win = win;
    strategy = getStrategy(evenCount, oddCount, win);
    return strategy.getRandomNumber();
  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  public abstract Strategy getStrategy(int evenCount, int oddCount, boolean win);
}
