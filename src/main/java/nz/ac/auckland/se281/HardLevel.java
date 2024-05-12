package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

/**
 * HardLevel class gets the strategy if player have chosen hard difficulty base on the player's
 * choice and their predominant choice are tends to be even or odd.
 *
 * <p>Stay in random strategy for first three round and switch between top and random strategy every
 * time after player has won the last round.
 */
public class HardLevel extends ArtificialIntelligence {
  protected Choice choice;
  protected int evenCount;
  protected int oddCount;
  protected Strategy strategy;

  /**
   * This constructor gets the player's choice, therefore pass on to top strategy can determine
   * which choice ai would have to choose to win the game.
   *
   * @param choice choice chosen by player at the start of the game, determine the sum is either odd
   *     or even to win the game.
   */
  public HardLevel(Choice choice) {

    this.choice = choice;
    // counts doesn't include for this round, so minus 1
    oddCount = roundNumber - evenCount - 1;
  }

  @Override
  public Strategy getStrategy(int evenCount, int oddCount, boolean win) {

    // use random strategy for the first 3 round, can switch between random or top strategy
    // afterwards
    if (roundNumber <= 3) {
      strategy = new RandomStrategy();
    } else if (roundNumber > 3 && win) {
      // if player win and ai lose, switch the strategy
      // if ai is at random strategy change to top strategy
      if (strategy instanceof RandomStrategy) {
        strategy = new TopStrategy(choice, evenCount, oddCount);
      } else if (strategy instanceof TopStrategy) {
        // if ai is at top strategy change to random strategy
        strategy = new RandomStrategy();
      }
    }

    return strategy;
  }
}
