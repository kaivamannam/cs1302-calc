package cs1302.calc;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CalcMenuBar extends MenuBar {

    Menu fileMenu;
    Menu windowMenu;
    Menu helpMenu;

    MenuItem exitItem;
    MenuItem bitToggle;
    MenuItem aboutItem;

    public CalcMenuBar() {

        super();

        fileMenu = new Menu("File");
        windowMenu = new Menu("Window");
        helpMenu = new Menu("Help");

        exitItem = new MenuItem("Exit");
        exitItem.setOnAction(event -> Platform.exit());

        bitToggle = new MenuItem("Remove Bit Toggle");

        aboutItem = new MenuItem("About");
        aboutItem.setOnAction(event -> makeAboutMe());

        fileMenu.getItems().add(exitItem);
        windowMenu.getItems().add(bitToggle);
        helpMenu.getItems().add(aboutItem);

        super.getMenus().addAll(fileMenu, windowMenu, helpMenu);
    }

    public void initialize(Stage stage, VBox vbox, BitBar bitBar) {

        bitToggle.setOnAction(event -> {

            if (bitToggle.getText().equals("Remove Bit Toggle")) {
                vbox.getChildren().remove(4);
                bitToggle.setText("Show Bit Toggle");
            } else {
                vbox.getChildren().add(4, bitBar);
                bitToggle.setText("Remove Bit Toggle");
            }

            System.out.println("Scene Width: " + stage.getScene().widthProperty());
            System.out.println("Scene Height: " + stage.getScene().heightProperty());

        });

    }

    public void makeAboutMe() {


        Pane pane = new Pane();

        ImageView imageView = new ImageView("https://i.imgur.com/JC1mPpB.jpg");
        pane.getChildren().add(imageView);

        VBox vbox = new VBox();


        pane.getChildren().add(vbox);

        HBox hbox1 = new HBox();
        HBox hbox2 = new HBox();
        HBox hbox3 = new HBox();
        HBox hbox4 = new HBox();

        vbox.getChildren().addAll(hbox1, hbox2, hbox3, hbox4);

        Text text1 = new Text("Application Version: 1.0");
        Text text2 = new Text("Kaiva Mannam");
        Text text3 = new Text("knrmpeace@gmail.com");
        Text text4 = new Text("770-490-2224");

        hbox1.getChildren().add(text1);
        hbox2.getChildren().add(text2);
        hbox3.getChildren().add(text3);
        hbox4.getChildren().add(text4);


        hbox1.setPadding(new Insets(50, 0, 10, 10));
        hbox2.setPadding(new Insets(0, 0, 10, 10));
        hbox3.setPadding(new Insets(0, 0, 10, 10));
        hbox4.setPadding(new Insets(0, 0, 10, 10));


        Scene aboutScene = new Scene(pane, 600, 600);

        imageView.fitWidthProperty().bind(pane.widthProperty());
        imageView.fitHeightProperty().bind(pane.heightProperty());


        Stage aboutStage = new Stage();


        aboutStage.setTitle("About Kaiva Mannam");
        aboutStage.setScene(aboutScene);
        aboutStage.sizeToScene();
        aboutStage.show();
    }


}
