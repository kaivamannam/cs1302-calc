package cs1302.calc;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

/**
 * ModeBar represents the text to display the current mode of the calculator.
 * The mode can either be Iterative or Recursive. A single setMode() method
 * can change the mode and consequently the text.
 *
 * @author Kaiva Mannam
 */

public class ModeBar extends HBox {

    Text modeText; // text to be displayed

    /**
     * This constructor creates the HBox, formats it, and sets the initial
     * default text. The text is added to the HBox layout.
     */

    public ModeBar() {

        super(); // creates parent HBox object
        super.setPadding(new Insets(0,10,5,15)); // formats HBox
        modeText = new Text("RECURSIVE MODE"); // sets default mode
        super.getChildren().add(modeText); // displays text in HBox

    }

    /**
     * This method changes the mode of the ModeBar by setting
     * modeText text to the appropriate specified mode.
     *
     * @param newMode mode to be set - either "r" or "i"
     */

    public void setMode(String newMode) {
        if (newMode.equals("r")) {
            modeText.setText("RECURSIVE MODE");
        } else if (newMode.equals("i")) {
            modeText.setText("ITERATIVE MODE");
        }
    } // setMode
} // ModeBar
