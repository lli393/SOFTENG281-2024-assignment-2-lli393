package nz.ac.auckland.se281;


/**
 * ArtificialIntelligence can be used to get a number, get strategy and set strategy. It provide a
 * strategy and base on the strategy gives a number for the ai in Game class.
 */
public abstract class ArtificialIntelligence {

  protected int roundNumber;
  protected int evenCount;
  protected int oddCount;
  protected boolean win;

  private Strategy strategy;

  /**
   * This method gets a number for ai to input in the game, base on the strategy and player's
   * predominant choice. This is run every new round, when play method is used in Game class.
   *
   * @param evenCount counter to keep track of player's decision
   * @param win whether the player has win in the previous round
   * @return a integer base on the strategy in getStrategy method
   */
  public int getRobotNumber(int evenCount, boolean win) {
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
