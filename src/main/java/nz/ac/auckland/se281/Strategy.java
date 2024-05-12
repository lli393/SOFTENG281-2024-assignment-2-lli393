package nz.ac.auckland.se281;

/**
 * This interface gets a random number base on the selected strategy (Top strategy or random
 * strategy)
 */
public interface Strategy {
  // get a random number base on strategy
  public int getRandomNumber();
}
