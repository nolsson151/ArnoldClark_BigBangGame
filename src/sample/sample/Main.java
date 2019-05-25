package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent game = FXMLLoader.load(getClass().getResource("sample/game.fxml"));
        primaryStage.setTitle("Arnold Clark Big Bang Game");
        primaryStage.setScene(new Scene(game));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
