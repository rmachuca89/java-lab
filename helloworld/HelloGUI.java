import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * hello
 */
public class HelloGUI {

  public static void main(String[] args) {
    // Sets the frame title to passed string
    JFrame frame = new JFrame("Hello, Java!");
    JLabel label = new JLabel("Hello World!", JLabel.CENTER);
    frame.add(label);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 300);
    // frames by default are invisible
    frame.setVisible(true);
  }
}
