package nz.ac.auckland.se281;

public class AI {

  private Strategy type;

  public AI(Strategy type) {
    this.type = type;
  }

  public int getAINum() {
    return type.getRandomNumber();
  }

  public void setStrategy(Strategy type) {
    this.type = type;
  }

  public Strategy getAIStrategy() {
    return type;
  }
}
