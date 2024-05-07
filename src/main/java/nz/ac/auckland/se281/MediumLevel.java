package nz.ac.auckland.se281;

public class MediumLevel implements DifficultyLevel {

  @Override
  public Strategy getStrategy() {
    // create new game object, get round number
    Game game = new Game();
    int roundNumber = game.roundNumber;
    // use random strategy for the first 3 round, switch to top strategy afterwards
    if (roundNumber <= 3) {
      return new RandomStrategy();
    } else {
      return new TopStrategy();
    }
  }
}
