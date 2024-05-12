package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class TopStrategy implements Strategy {

  Choice choice;
  int evenCount;
  int oddCount;

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
