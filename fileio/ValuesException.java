/**
 * Thrown when a SynonymDict is loaded without synonyms.
 */
public class ValuesException extends RuntimeException {
  public ValuesException(String string) {
    super(string);
  }
}
