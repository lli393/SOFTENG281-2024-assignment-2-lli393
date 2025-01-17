package nz.ac.auckland.se281;

/** RandomStrategy class gets a random number range from 0 to 5 without other considerations. */
public class RandomStrategy implements Strategy {

  @Override
  public int getRandomNumber() {
    // ai select random integers from 0-5
    return Utils.getRandomNumberRange(0, 5);
  }
}
