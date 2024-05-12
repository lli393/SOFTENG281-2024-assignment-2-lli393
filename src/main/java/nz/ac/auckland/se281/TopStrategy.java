package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

/**
 * TopStrategy class gets a random number considering player's choice to win, player's predominant
 * choice to determine whether ai will win by generating a random even number or a random odd
 * number.
 */
public class TopStrategy implements Strategy {

  protected Choice choice;
  protected int evenCount;
  protected int oddCount;

  /**
   * This method returns one even number or odd number base on player's choice and player's
   * predominant choice.
   *
   * @param choice player's choice to win, ai win by doing the opposite
   * @param evenCount count of if player's input is even
   * @param oddCount count of if player's input is odd
   */
  public TopStrategy(Choice choice, int evenCount, int oddCount) {
    this.choice = choice;
    this.evenCount = evenCount;
    this.oddCount = oddCount;
  }

  @Override
  public int getRandomNumber() {

    // if player choose even to win, ai want sum to be odd
    if (choice == Choice.EVEN) {
      // if player is more likely to choose even, ai input odd
      if (evenCount > oddCount) {
        return Utils.getRandomOddNumber();
      } else if (oddCount > evenCount) {
        return Utils.getRandomEvenNumber();
      } else {
        // if even == odd do random strategy
        return Utils.getRandomNumberRange(0, 5);
      }

      // if player choose odd to win, ai want sum to be even
    } else if (choice == Choice.ODD) {
      // if player is more likely to choose even, ai input even
      if (evenCount > oddCount) {
        return Utils.getRandomEvenNumber();
      } else if (oddCount > evenCount) {
        return Utils.getRandomOddNumber();
      } else {
        return Utils.getRandomNumberRange(0, 5);
      }
    }
    return -1;
  }
}
