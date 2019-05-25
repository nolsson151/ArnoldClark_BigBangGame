package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class GameController {
    @FXML
    private Text title, playerHand,oppHand,result,wins,loses,announcment;
    @FXML
    private ImageView playerImage;
    @FXML
    private ImageView opponentImage;
    private int winsCount = 0;
    private  int losesCount = 0;

    private HashMap handToInt;
    private int[][] winMatrix;
    private String[][] actionMatrix;
    private Scene secondScene;

    public GameController() {
        winMatrix = new int[][]{
                {2, 1, 0, 1, 0},
                {0, 2, 1, 0, 1},
                {1, 0, 2, 1, 0},
                {0, 1, 0, 2, 1},
                {1, 0, 1, 0, 2}};
        actionMatrix = new String[][]{
                {"Ties", "Cuts", "Crushes", "Decapitates", "Smashes"},
                {"Cuts", "Ties", "Covers", "Eats", "Disproves"},
                {"Crushes","Covers","Ties","Crushes","Vaporizes"},
                {"Decapitates","Eats","Crushes","Ties","Poisons"},
                {"Smashes","Disproves","Vaporizes","Poisons","Ties"}};
        handToInt = new HashMap<String, Integer>() {{
            put("Scissors", 0);
            put("Paper", 1);
            put("Rock", 2);
            put("Lizard", 3);
            put("Spock", 4);
        }};
    }
    public void setSecondScene(Scene scene) {
        secondScene = scene;
    }

    public void openSecondScene(ActionEvent actionEvent) {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(secondScene);
    }

    @FXML
    public void processAction(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();
        playerHand.setText(value);
        decideWinner(value);
        wins.setText("Wins: "+winsCount);
        loses.setText("Loses: "+losesCount);
    }

    public void decideWinner(String s) {
        int playerChoice = (int) handToInt.get(s);
        Random random = new Random();
        int rand = random.nextInt(5);
        int decision = winMatrix[playerChoice][rand];
        String opponentChoice = (String) getKeyFromValue(handToInt, rand);
        oppHand.setText(opponentChoice);
        if (decision > 0 && decision != 2) {
            announcment.setText(s +" "+actionMatrix[playerChoice][rand]+ " "+opponentChoice);
            result.setText("Winner!");
            winsCount++;
        } else if (decision == 2) {
            result.setText("Draw!");
            announcment.setText(s +" "+actionMatrix[playerChoice][rand]+ " "+opponentChoice);
        } else {
            result.setText("Loser!");
            announcment.setText( opponentChoice+" "+actionMatrix[playerChoice][rand]+ " "+s);
            losesCount++;
        }

    }

    public static Object getKeyFromValue(Map hm, Object value) {
        for (Object o : hm.keySet()) {
            if (hm.get(o).equals(value)) {
                return o;
            }
        }
        return null;
    }
}


