package nz.ac.auckland.se281;

public class AI {

  Strategy type;

  public AI(Strategy type) {
    this.type = type;
  }

  public int getNum() {
    return type.getRandomNumber();
  }

  public void setStrategy(Strategy type) {
    this.type = type;
  }
}
