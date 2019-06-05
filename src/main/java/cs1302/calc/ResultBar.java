package cs1302.calc;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

/**
 * ResultBar represents a HBox with text that displays the expression
 * result.
 *
 * @author Kaiva Mannam
 */

public class ResultBar extends HBox {

    Text text; // Text object

    /**
     *  This constructor formats the parent HBox object and creates the
     *  Text object. The Text object is added to the HBox.
     */

    public ResultBar() {

        super(8); // creates parent HBox object
        super.setAlignment(Pos.CENTER_RIGHT); // right-aligns text
        super.setPrefHeight(25); // sets height
        super.setPadding(new Insets(10, 10, 10, 10)); // sets padding

        text = new Text(); // creates Text object
        text.setStyle("-fx-font-size: 30"); // sets font size

        super.getChildren().add(text); // adds text object to HBox
    }

    /**
     * This method takes an integer parameter and displays the
     * integer in the result bar.
     *
     * @param result
     */

    public void displayResult(Integer result) {

        if (result != -1) {
            text.setText(result.toString()); // sets text only if result is valid
        }
    } // displayResult

} // ResultBar
