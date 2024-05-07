package nz.ac.auckland.se281;

public class EasyLevel implements DifficultyLevel {

  @Override
  public Strategy getStrategy() {
    // create random object
    return new RandomStrategy();
  }
}
