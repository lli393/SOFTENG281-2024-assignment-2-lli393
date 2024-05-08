package nz.ac.auckland.se281;

public class EasyLevel implements DifficultyLevel {

  @Override
  public AI getStrategy() {
    // create random object
    return new AI(new RandomStrategy());
  }
}
