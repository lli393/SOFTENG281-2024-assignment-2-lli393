package nz.ac.auckland.se281;

/** Easy Level class gets random strategy in every round. */
public class EasyLevel extends ArtificialIntelligence {

  @Override
  public Strategy getStrategy(int evenCount, int oddCount, boolean win) {
    // use random strategy
    return new RandomStrategy();
  }
}
