package nz.ac.auckland.se281;

public class EasyLevel implements DifficultyLevel {

  @Override
  public AIInstance getStrategy() {
    // create random object
    return new AIInstance(new RandomStrategy());
  }
}
