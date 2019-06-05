package cs1302.calc;

import javafx.scene.text.Text;

/**
 * Bit represents a single clickable bit text node.
 *
 * @author Kaiva Mannam
 */

public class Bit extends Text {

    private Integer value; // class variable representing current bit value

    /**
     * This constructor creates the bit text node
     */

    public Bit() {

        super("0"); // creates parent Text object
        super.setStyle("-fx-font-size: 20"); // sets font size

        value = 0; // sets initial bit value
        super.setText(value.toString()); // sets initial text for parent object
    } // constructor

    /**
     * Returns current bit value
     *
     * @return current bit value
     */

    public int getValue() {
        return value;
    } // getValue

    /**
     * Returns bit value as a String object
     *
     * @return String bit value
     */

    public String toString() {
        return value.toString();
    } // toString

    /**
     * Changes the bit value from 0 to 1 or 1 to 0.
     * Sets the new bit value to the text object.
     */

    public void toggle() {
        if (value == 0) value = 1; // sets value to 1 if value is 0
        else value = 0; // else, sets value to 0
        super.setText(value.toString()); // updates text object
    } // toggle
} // Bit
