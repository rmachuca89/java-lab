import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SynonymDict {

  private Map<String, List<String>> dict;
  private boolean isInitialized;

  /**
    * Returns whether the dictionary has been loaded at least once.
    */
  public boolean isInitialized() {
    return isInitialized;
  }

  /**
   * Loads the dictionary from the file provided. The file should contain a series of lines with
   * words on each. The first word on a line is entered into the dictionary, with the other words
   * serving as synonyms.
   */
  public void loadDictionary(File file) throws IOException {
    BufferedReader reader = null;

    try {
      reader = new BufferedReader(new FileReader(file));

      Map<String, List<String>> newDict = new HashMap<String, List<String>>();

      String line = null;
      while ((line = reader.readLine()) != null) {
        String[] strings = line.split(" ");
        List<String> list = Arrays.asList(strings);
        List<String> subList = list.subList(1, list.size());
        Collections.sort(subList);
        newDict.put(list.get(0), subList);
      }

      if (newDict.isEmpty()) {
        throw new ValuesException("bad file: " + file);
      }

      dict = newDict;
      isInitialized = true;
    } catch(Exception ex){
      System.out.println("Could not load dictionary file:" + ex);
    } finally {
      reader.close();
    }
  }

  /**
   * Returns a list of synonyms stored for a given word.
   */
  public List<String> getSynonyms(String string){

    List<String> mySynonyms = dict.get(string);
    return mySynonyms == null ? new ArrayList<String>() : mySynonyms;
  }

  public static void main(String[] args) {
    Path testDataDir = Paths.get(System.getProperty("user.home"), "sandbox/java-lab/fileio/testdata");
    File myFile = testDataDir.resolve("synonyms-good1.txt").toFile();

    SynonymDict dict = new SynonymDict();

    try {
      dict.loadDictionary(myFile);
    } catch (IOException ioex) {
      System.out.println("Could not load dictionary file: " + ioex);
    }

    if (dict.isInitialized) {
      List<String> synonyms = dict.getSynonyms("cat");
      System.out.println("Found synonims: " + synonyms);
    }

  }

}
