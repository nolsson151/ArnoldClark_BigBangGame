package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader gamePaneLoader = new FXMLLoader(getClass().getResource("game.fxml"));
        Parent gamePane = gamePaneLoader.load();
        Scene gameScene = new Scene(gamePane);
        FXMLLoader replayPageLoader = new FXMLLoader(getClass().getResource("replay.fxml"));
        Parent replayPane = replayPageLoader.load();
        Scene replayScene = new Scene(replayPane);

        GameController gameController = (GameController) gamePaneLoader.getController();
        gameController.setSecondScene(replayScene);
        ReplayController replayController = (ReplayController) replayPageLoader.getController();
        replayController.setFirstScene(gameScene);

        primaryStage.setTitle("Arnold Clark Big Bang Game");
        primaryStage.setScene(gameScene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
