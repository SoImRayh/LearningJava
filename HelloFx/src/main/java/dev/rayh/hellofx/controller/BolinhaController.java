package dev.rayh.hellofx.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;

public class BolinhaController {

    @FXML
    private Circle circle;

    @FXML
    private Button downButton;

    @FXML
    private Button leftButton;

    @FXML
    private Button rightButton;

    @FXML
    private Button upButton;

    @FXML
    void handleWhenDownButtonIsPressed(ActionEvent event) {
        circle.setCenterY(circle.getCenterY() + 10);
    }

    @FXML
    void handleWhenLeftButtonIsPressed(ActionEvent event) {
        circle.setCenterX(circle.getCenterX() - 10);
    }

    @FXML
    void handleWhenRightButtonIsPressed(ActionEvent event) {
        circle.setCenterX(circle.getCenterX() + 10);
    }

    @FXML
    void handleWhenUpButtonIsPressed(ActionEvent event) {
        circle.setCenterY(circle.getCenterY() - 10);
    }

}
