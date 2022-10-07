package behaviorparams;
/** Apple bean. */
public class Apple {

  enum COLOR {
    GREEN,
    RED,
  }

  COLOR color;
  double weight;

  public Apple(Apple.COLOR color, double weight) {
    this.color = color;
    this.weight = weight;
  }

  @Override
  public String toString() {
    return String.format("Apple{color:%s, weight:%s}", this.color, this.weight);
  }
}
