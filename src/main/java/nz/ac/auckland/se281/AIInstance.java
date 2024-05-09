package nz.ac.auckland.se281;

public class AIInstance {

  private Strategy type;

  public AIInstance(Strategy type) {
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
