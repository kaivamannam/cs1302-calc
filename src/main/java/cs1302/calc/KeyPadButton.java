package cs1302.calc;

import javafx.scene.control.Button;


/**
 * KeyPadButton represents a programmer's calculator's button.
 * All buttons are formatted to fit in the application, and
 * font styles and sizes are established for all button text.
 * It also contains a static isOperator method which returns
 * whether the supplied parameter is an operator
 *
 * @author Kaiva Mannam
 */

public class KeyPadButton extends Button {


    String name; // represents button name

    /**
     * This constructor creates the parent Button object via a a constructor call.
     * The buttons are styled and formatted.
     *
     * @param name name of button object
     */

    public KeyPadButton(String name) {


        super(name); // Button constructor call
        this.name = name; // assigns instance variable name
        super.setStyle("-fx-font-size: 15"); // sets font size of button text
        super.setPrefWidth(115); // sets width of button

        if (name.equals("Evaluate")) {
            super.setPrefWidth(240); // sets twice the width for the evaluate button
        }
    }

    /**
     * This method checks whether a String parameter is an operator.
     * A boolean true is returned if the parameter is an operator; false
     * otherwise.
     *
     * @param name term to be checked for being an operator
     * @return true if name is an operator, false otherwise
     */

    public static boolean isOperator(String name) {

        /* nested else-if structure to check for operators */

        if (name.equals("+")) {
            return true;
        } else if (name.equals("-")) {
            return true;
        } else if (name.equals("*")) {
            return true;
        } else if (name.equals("/")) {
            return true;
        } else if (name.equals("<<")) {
            return true;
        } else if (name.equals(">>")) {
            return true;
        } else if (name.equals("!")) {
            return true;
        } else if (name.equals("^^")) {
            return true;
        }

        return false; // return false if no above condition is true
    } // isOperator

} // KeyPadButton
