package Battle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Controller {


    public void doSomething() {
        System.out.println("The button was clicked!");
    }

    private void SinglePlayer  (ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("blueprint.fxml"));
    }


}
