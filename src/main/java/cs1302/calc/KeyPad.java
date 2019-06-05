package cs1302.calc;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

import static cs1302.calc.KeyPadButton.isOperator;

/**
 * KeyPad represents a GridPane layout with several button
 * nodes to perform different calculator functions. KeyPad
 * defines nodes of type KeyPadButton - a child of Button.
 * Buttons include numbers, operations, modes, clear, and backspace.
 * Different layouts whose methods need to be accessed are declared as
 * instance variables. The current instance of CalcApp is passed as a
 * parameter in order to obtain these instance data.
 *
 * @author Kaiva Mannam
 */

public class KeyPad extends GridPane {

    ModeBar modeBar; // reference variable for driver's ModeBar instance
    ExpressionBar expressionBar; // reference variable for driver's ExpressionBar instance
    ResultBar resultBar; // reference variable for driver's ResultBar instance
    BitBar bitBar; // reference variable for driver's BitBar instance


    /**
     * This constructor initializes a set of KeyPadButtons by calling
     * the makeNewButton method. The buttons are placed in a grid pane.
     *
     * @param myApp
     */

    public KeyPad(CalcApp myApp) {

        super(); // call to constructor

        modeBar = myApp.getModeBar(); // gets driver's ModeBar
        expressionBar = myApp.getExpressionBar(); // gets driver's ExpressionBar
        resultBar = myApp.getResultBar(); // gets driver's ResultBar
        bitBar = myApp.getBitBar(); // gets driver's BitBar.

        /* Formats GridPane parent object */
        super.setHgap(10);
        super.setVgap(10);
        super.setPadding(new Insets(10,0,10,0));


        /* Adds first row of KeyPadButtons */
        super.add(makeNewButton("Iterative"), 0,0); // adds iterative mode button
        super.add(makeNewButton("Recursive"), 1, 0); // adds recursive mode button
        super.add(makeNewButton("BACKSPACE"), 2, 0); // adds backspace button
        super.add(makeNewButton("CLEAR"), 3, 0); // adds clear button

        /* Adds second row of KeyPadButtons */
        super.add(makeNewButton("<<"), 0, 1); // left shift operator
        super.add(makeNewButton(">>"), 1, 1); // right shift operator
        super.add(makeNewButton("^^"), 2, 1); // exponent operator
        super.add(makeNewButton("!"), 3, 1); // factorial operator

        // Adds third row of KeyPadButtons */
        super.add(makeNewButton("7"), 0,2);  // adds "7" numerical button
        super.add(makeNewButton("8"), 1, 2); // adds "8" numerical button
        super.add(makeNewButton("9"), 2, 2); // adds "9" numerical button
        super.add(makeNewButton("/"), 3, 2); // adds "/" numerical button

        // Adds fourth row of KeyPadButtons */
        super.add(makeNewButton("4"), 0, 3); // adds "4" numerical button
        super.add(makeNewButton("5"), 1, 3); // adds "5" numerical button
        super.add(makeNewButton("6"), 2, 3); // adds "6" numerical button
        super.add(makeNewButton("*"), 3, 3); // adds "*" numerical button

        // Adds fifth row of KeyPadButtons */
        super.add(makeNewButton("1"), 0, 4); // adds "1" numerical button
        super.add(makeNewButton("2"), 1, 4); // adds "2" numerical button
        super.add(makeNewButton("3"), 2, 4); // adds "3" numerical button
        super.add(makeNewButton("-"), 3, 4); // adds subtraction operator
        super.add(makeNewButton("0"), 0, 5);

        /* Creates and formats the evaluate button */
        KeyPadButton evaluateButton = makeNewButton("Evaluate");
        super.add(evaluateButton, 1, 5);
        super.setColumnSpan(evaluateButton, 2); // spans two grid columns

        super.add(makeNewButton("+"), 3, 5); // adds addition operator


    } // constructor


    /**
     * This method instantiates a new KeyPadButton object and assigns
     * a particular setOnAction functionality depending on the name
     * supplied as a method parameter. The method returns the KeyPadButton
     * object.
     *
     * @param name
     * @return click action defined KeyPadButton object
     */

    public KeyPadButton makeNewButton(String name) {

        KeyPadButton btn = new KeyPadButton(name); // assigns and creates a new KeyPadButton object
        if (name.equals("Evaluate")) {

            btn.setOnAction(event -> { // sets functionality for Evaluate button

                Integer result = expressionBar.evaluateExpression(); // integer expression result
                resultBar.displayResult(result); // displays the integer result
                bitBar.evaluateToBits(result); // displays the integer result in BitBar

            });
        } else if (name.equals("BACKSPACE")) {
            btn.setOnAction(event -> { // sets functionality for backspace button

                expressionBar.backSpace(); // call non-static backSpace() method

            });
        } else if (name.equals("CLEAR")) {
            btn.setOnAction(event -> { // sets functionality for clear button

                expressionBar.clear(); // calls non-static clear() method

            });
        } else if (name.equals("Iterative")) {
            btn.setOnAction(event -> { // sets functionality for iterative button

                expressionBar.setMode("i"); // sets expressionBar mode to iterative
                modeBar.setMode("i"); // sets modeBar mode to iterative

            });
        } else if (name.equals("Recursive")) {
            btn.setOnAction(event -> { // sets functionality for recursive button

                expressionBar.setMode("r"); // sets expressionBar mode to iterative
                modeBar.setMode("r"); // sets modeBar mode to recursive

            });
        } else if (isOperator(name)) {
            btn.setOnAction(event -> {

                /* If the button name is an operator, the updateExpression
                    method is called with extra spaces */
                expressionBar.updateExpression(" " + name + " ");

            });
        } else {
            btn.setOnAction(event -> {

                /* Otherwise, the updateExpression is simply called by its
                    numerical value which needs no extra spaces
                 */
                expressionBar.updateExpression(name);

            });
        }
        return btn; // returns the KeyPadButton object
    } // makeNewButton



} // KeyPad
