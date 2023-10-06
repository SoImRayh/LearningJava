package dev.rayh.hellofx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppBolinha extends Application {



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        var loader = new FXMLLoader(getClass().getResource("scenes/bolinha.fxml"));

        Scene scene = new Scene(loader.load());

        stage.setTitle("Bolinha");
        stage.setScene(scene);
        stage.show();
    }
}
