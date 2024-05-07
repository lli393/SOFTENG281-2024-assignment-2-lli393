package nz.ac.auckland.se281;

public class RandomStrategy implements Strategy {

  @Override
  public int getRandomNumber() {
    // ai select random integers from 0-5
    return Utils.getRandomNumberRange(0, 5);
  }
}
