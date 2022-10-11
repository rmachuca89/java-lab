package streams;

import static java.util.Comparator.comparing;

import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {

    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario", "Milan");
    Trader alan = new Trader("Alan", "Cambridge");
    Trader brian = new Trader("Brian", "Cambridge");
    List<Transaction> transactions =
        Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950));

    /**
     * Stream data processing exercises:
     *
     * <ol>
     *   <li>1. Find all transactions in the year 2011 and sort them by value (small to high).
     *   <li>2. What are all the unique cities where the traders work?
     *   <li>3. Find all traders from Cambridge and sort them by name.
     *   <li>4. Return a string of all traders’ names sorted alphabetically.
     *   <li>5. Are any traders based in Milan?
     *   <li>6. Print the values of all transactions from the traders living in Cambridge.
     *   <li>7. What's the highest value of all the transactions?
     *   <li>8. Find the transaction with the smallest value.
     * </ol>
     */
    System.out.println("======================================================");
    System.out.println("All transactions:");
    transactions.stream().forEach(System.out::println);
    System.out.println("======================================================");

    System.out.println(
        "1. Find all transactions in the year 2011 and sort them by value (small to high).");
    transactions.stream()
        .filter(t -> t.getYear() == 2011)
        .sorted((a, b) -> Integer.compare(a.getValue(), b.getValue()))
        .forEach(System.out::println);

    System.out.println("2. What are all the unique cities where the traders work?");
    transactions.stream().map(t -> t.getTrader().getCity()).distinct().forEach(System.out::println);

    System.out.println("3. Find all traders from Cambridge and sort them by name.");
    transactions.stream()
        .filter(t -> "Cambridge".equals(t.getTrader().getCity()))
        .map(t -> t.getTrader())
        .distinct()
        .sorted(comparing(Trader::getName))
        .forEach(System.out::println);

    System.out.println("4. Return a single string of all traders names sorted alphabetically.");
    /**
     * This solution is inefficient; all Strings are repeatedly concatenated, which creates a new
     * String object at each iteration. Could be improved by joining() instead; which internally
     * makes use of a StringBuilder.
     */
    System.out.println(
        transactions.stream()
            .map(t -> t.getTrader().getName())
            .distinct()
            .sorted()
            .reduce("", (n1, n2) -> n1 + n2));

    System.out.println("5. Are any traders based in Milan?");
    if (transactions.stream().anyMatch(t -> "Milan".equals(t.getTrader().getCity()))) {
      System.out.println("Yes!");
    } else {
      System.out.println("No :(");
    }

    System.out.println(
        "6. Print the values of all transactions from the traders living in Cambridge.");
    transactions.stream()
        .filter(t -> "Cambridge".equals(t.getTrader().getCity()))
        .map(t -> t.getValue())
        .forEach(System.out::println);

    System.out.println("7. What's the highest value of all the transactions?");
    System.out.println(transactions.stream().map(t -> t.getValue()).reduce(Integer::max).orElse(0));

    System.out.println("8. Find the transaction with the smallest value.");
    /** Using reduce with manual min value comparison. */
    // System.out.println(
    //     transactions.stream()
    //         .reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2)
    //         .orElseThrow());
    /** Using built in Stream.min() comparison. */
    System.out.println(transactions.stream().min(comparing(Transaction::getValue)).orElseThrow());
  }
}
