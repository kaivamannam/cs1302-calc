package cs1302.calc;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * CalcApp represents a programmer's calculator. Users
 * can enter and evaluate mathematical expressions by
 * interacting with number and operation buttons. A menu bar
 * and a bar of clickable bits displaying the current result
 * is also provided. Recursive and Iterative modes provide
 * different mathematical implementations to the operations.
 *
 * @author Kaiva Mannam
 */

public class CalcApp extends Application {

    ModeBar modeBar;
    CalcMenuBar menuBar;
    ExpressionBar expressionBar;
    ResultBar resultBar;
    BitBar bitBar;
    KeyPad keyPad;

    /**
     * This method provides the entry point into
     * the application. The app's key layouts are added to the
     * GUI via a root @code{VBox}. Layouts added include a mode
     * bar, menu bar, expression bar, result bar, bit bar, and
     * key pad.
     *
     * @param stage main application window
     */

    @Override
    public void start(Stage stage) {

        VBox vbox = new VBox(); // root for stage
        vbox.setPadding(new Insets(10, 10, 10, 10)); // padding for root

        Scene scene = new Scene(vbox); // scene for stage
        stage.setScene(scene); // sets the scene for stage

        modeBar = new ModeBar(); // text bar to display current mode
        vbox.getChildren().add(modeBar); // adds modeBar to root

        menuBar = new CalcMenuBar(); // menu bar for a calculator
        vbox.getChildren().add(menuBar); // adds menuBar to root

        expressionBar = new ExpressionBar(); // builds and displays expression
        vbox.getChildren().add(expressionBar); // adds expressionBar to root

        resultBar = new ResultBar(); // displays expression result
        vbox.getChildren().add(resultBar); // adds resultBar to root

        bitBar = new BitBar(this); // displays clickable bit string form of result
        vbox.getChildren().add(bitBar); // adds bitBar to root

        keyPad = new KeyPad(this); // displays a keypad to interact with expression
        vbox.getChildren().add(keyPad); // adds keyPad to root

        menuBar.initialize(stage, vbox, bitBar); // preliminary setup for menu Bar


        stage.sizeToScene(); // fits stage size to scene size
        stage.setTitle("cs1302-calc!"); // sets title
        stage.show(); // displays application window
    } // start

    public ModeBar getModeBar() {
        return  modeBar;
    }

    public ExpressionBar getExpressionBar() {
        return expressionBar;
    }

    public ResultBar getResultBar() {
        return resultBar;
    }

    public BitBar getBitBar() {
        return bitBar;
    }

    /**
     * Main method for launching application
     *
     * @param args main method parameters
     */

    public static void main(String[] args) {
        try {
            Application.launch(args); // launch application
        } catch (UnsupportedOperationException e) { // handles X server connection exception

            System.out.println(e); // prints out exception
            System.err.println("If this is a DISPLAY problem, then your X server connection");
            System.err.println("has likely timed out. This can generally be fixed by logging");
            System.err.println("out and logging back in.");
            System.exit(1); // exits application with error status
        } // try
    } // main

} // CalcApp

