package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class TestSchermpje1Controller {

    @FXML
    private AnchorPane rootPane;

    public void back(MouseEvent mouseEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/ShopHome.fxml"));
        rootPane.getChildren().setAll(pane);
    }

}
