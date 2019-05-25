package sample;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

import java.util.HashMap;


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
            put("Scissors", 1);
            put("Paper",2);
            put("Rock",3);
            put("Lizard", 4);
            put("Spock",5);
        }};
    }
    
    @FXML
    public void processAction(){


    }
}
