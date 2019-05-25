package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class Controller {
    @FXML
    private Text title;
    @FXML
    private Text playerHand;
    @FXML
    private Text oppHand;
    private HashMap handToInt;
    private int[][] winMatrix;

    public Controller(){
        winMatrix = new int[][] {
                {2,1,0,1,0},
                {0,2,1,0,1},
                {1,0,2,1,0},
                {0,1,0,2,1},
                {1,0,1,0,2}};
        handToInt = new HashMap<String,Integer>(){{
            put("Scissors", 0);
            put("Paper",1);
            put("Rock",2);
            put("Lizard", 3);
            put("Spock",4);
        }};
    }
    
    @FXML
    public void processAction(ActionEvent event){
    String value = ((Button)event.getSource()).getText();
    playerHand.setText(value);
    decideWinner(value);

    }
    public void decideWinner(String s){
        int playerChoice = (int) handToInt.get(s);
        Random random = new Random();
        int rand = random.nextInt(5);
        int decision = winMatrix[playerChoice] [rand];
        String opponentChoice = (String) getKeyFromValue(handToInt,rand);
        oppHand.setText(opponentChoice);
//        if( decision > 0 && decision!= 2){
//            String opponentChoice = (String) getKeyFromValue(handToInt, rand);
//            oppHand.setText(opponentChoice);
//            return true;
//        }

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
