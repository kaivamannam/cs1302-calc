
package cs1302.calc;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.layout.HBox;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CalcApp extends Application {

    @Override
    public void start(Stage stage) {
	HBox pane = new HBox();
        Scene scene = new Scene(pane);
	stage.setMaxWidth(640);
	stage.setMaxHeight(480);
        stage.setTitle("cs1302-calc!");
        stage.setScene(scene);
	stage.sizeToScene();
        stage.show();
    } // start

    public static void main(String[] args) {
	try {
	    Application.launch(args);
	} catch (UnsupportedOperationException e) {
	    System.out.println(e);
	    System.err.println("If this is a DISPLAY problem, then your X server connection");
	    System.err.println("has likely timed out. This can generally be fixed by logging");
	    System.err.println("out and logging back in.");
	    System.exit(1);
	} // try
    } // main

} // CalcApp
