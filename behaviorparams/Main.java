package behaviorparams;

import java.util.ArrayList;
import java.util.List;

/** Main App entry point. */
public final class Main {

  private Main() {}

  public static void main(String[] args) {
    Apple myApple1 = new Apple(Apple.COLOR.GREEN, 150);
    Apple myApple2 = new Apple(Apple.COLOR.RED, 79);
    Apple myApple3 = new Apple(Apple.COLOR.RED, 89);
    Apple myApple4 = new Apple(Apple.COLOR.GREEN, 99);
    Apple myApple5 = new Apple(Apple.COLOR.GREEN, 76);

    List<Apple> apples = new ArrayList<>();

    apples.add(myApple1);
    apples.add(myApple2);
    apples.add(myApple3);
    apples.add(myApple4);
    apples.add(myApple5);

    /** Here we select the corresponding strategy to execute. */
    // prettyPrintApples(apples, new SimplePrintStrategy());
    // prettyPrintApples(apples, new PrettyPrintStrategy());

    /**
     * Anonymous class example (DISCOURAGED).
     *
     * <p>It supports adhoc implementations with anonymous classes to attempt to make implementation
     * less verbose by avoiding to having to declare a formal implementation class for each
     * strategy. However, they are still bulky and create even more complexity by having to read the
     * code body to understand what it does; and even worse, variable scoping may get tricky to get
     * right.
     */
    prettyPrintApples(
        apples,
        new PrintStrategy() {
          public void print(Apple a) {
            System.out.println("Adhoc anonymous class strategy. Oh! yes, my apple: " + a);
          }
        });
  }

  static void prettyPrintApples(List<Apple> apples, PrintStrategy ps) {
    for (Apple apple : apples) {
      ps.print(apple);
    }
  }
}

/** Print strategy interface to use when printing {@code Apple}. */
interface PrintStrategy {
  void print(Apple a);
}

class SimplePrintStrategy implements PrintStrategy {
  public void print(Apple a) {
    System.out.println(a);
  }
}

class PrettyPrintStrategy implements PrintStrategy {
  public void print(Apple a) {
    System.out.println(String.format("Pretty Apple:"));
    System.out.println(String.format("\tColor:%s", a.color));
    System.out.println(String.format("\tWeight:%s", a.weight));
  }
}
