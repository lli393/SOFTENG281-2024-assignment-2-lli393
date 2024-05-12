package nz.ac.auckland.se281;

public class EasyLevel extends AIInstance {

  @Override
  public Strategy getStrategy(int evenCount, int oddCount, boolean win) {
    // use random strategy
    return new RandomStrategy();
  }
}
