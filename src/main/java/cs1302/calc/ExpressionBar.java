package cs1302.calc;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * ExpressionBar represents the current mathematical
 * expression being built. ExpressionBar reflects
 * changes corresponding to the user pressing operational
 * or numerical buttons. Evaluation of the expression
 * uses either a Recursive or Iterative implementation
 * of MathOps.
 *
 * @author Kaiva Mannam
 */

public class ExpressionBar extends HBox {

    String expressionString; // current expression as String object
    String mode = "r"; // mode, either "r" or "i" for recursive or iterative
    Text expressionText; // text node to display current expression
    MathOps mathOps; // reference variable to evaluate string math expressions

    /**
     * This constructor initializes the horizontal bar,
     * formats the bar to fit the application window, aligns
     * expression to build from the right and sets text styles
     */

    public ExpressionBar() {

        super(3); // calls constructor and sets spacing between nodes
        super.setAlignment(Pos.CENTER_RIGHT); // right aligns expression text
        super.setPrefHeight(20); // sets height to 20
        super.setPadding(new Insets(20, 0, 0, 0)); // sets padding
        expressionString = new String(); // instantiates a new String object
        expressionText = new Text(); // instantiates a new Text node
        expressionText.setStyle("-fx-font-family: 'Cambria Math'"); // sets font style
        expressionText.setStyle("-fx-font-size: 20"); // sets font size

        super.getChildren().add(expressionText); // adds text node to hBox layout
    } // constructor

    /**
     * This method updates the current expression by concatenating
     * the specified parameter to the current expression.
     *
     * @param newTerm the term to be concatenated to expression
     */

    public void updateExpression(String newTerm) {

        expressionString += newTerm; // concatenates new term to expression
        expressionText.setText(expressionString); // updates the text node with the new expression
    } // updateExpression

    /**
     * This method evaluates the current expression by using either a recursive or
     * iterative implementation of the MathOps interface. An error message is displayed
     * if the expression cannot be evaluated by the MathOpsEvaluator class.
     *
     * @return result of expression
     */

    public int evaluateExpression() {

        if (mode.equals("r")) {
            mathOps = new RecursiveMathOps(); // instantiates a Recursive implementation
        } else if (mode.equals("i")) {
            mathOps = new IterativeMathOps(); // instantiates an Iterative implementation
        }

        try {

                /* Uses the static evaluate() method of the MathOpsEvaluator
                   class to obtain an integer result using a mathOps implementation
                   and an expression string.
                 */

            int result = MathOpsEvaluator.evaluate(mathOps, expressionString);

            return result;

        } catch (Exception e) {
            displayErrorMessage(); // displays a secondary stage with a text node
        }

        return -1;
    } // evaluateExpression


    /**
     * This method clears the current expression. It assigns an
     * empty string to the expressionString reference variable
     * and sets the updated expressionString as the expression text.
     */

    public void clear() {
        expressionString = ""; // assigns an empty string
        expressionText.setText(expressionString); // sets the new expression text
    }

    /**
     * This method changes the mode of the application by setting
     * the String mode equal to the mode specified by the parameter.
     *
     * @param mode
     */

    public void setMode(String mode) {
        this.mode = mode; // assigns the specified String to the class variable mode
    }

    /**
     * This method backspaces a term from the current expression.
     * The string is manipulated based on whether the term to be
     * backspaced is a number or an operator.
     */

    public void backSpace() {

        if (!expressionString.equals("")) { // can only backspace a nonempty string


            /* If the last character is a space (" "), this implies an operator.
               Operators take up 3 characters: 2 spaces and the operator. Ex: " + " */
            if ((expressionString.substring(expressionString.length() - 1).equals(" "))) {

                // delete the last 3 characters
                expressionString = expressionString.substring(0, expressionString.length() - 3);

                // else, the last character is a number
            } else {

                // delete the last character
                expressionString = expressionString.substring(0, expressionString.length() - 1);
            }

            expressionText.setText(expressionString); // set the new expression text
        }
    } // backspace


    /**
     * This method creates a secondary stage to display
     * an error message. displayErrorMessage() is called when
     * an error is caught while trying to use the static
     * evaluate() method.
     */

    public void displayErrorMessage() {

        VBox pane = new VBox(); // root
        pane.setAlignment(Pos.CENTER); // center align text
        pane.setPadding(new Insets(20, 50, 20, 50)); // set padding
        Stage secondaryStage = new Stage(); // secondary stage
        Scene scene = new Scene(pane); // creates scene with pane as root

        /* adds 2 lines of Text nodes with error messages */
        pane.getChildren().add(new Text("This expression cannot be evaluated."));
        pane.getChildren().add(new Text("Please close this window and retype your expression."));

        secondaryStage.setTitle("Error Message"); // sets title "Error Message"
        secondaryStage.setScene(scene); // sets scene
        secondaryStage.show(); // displays window
    }

}
