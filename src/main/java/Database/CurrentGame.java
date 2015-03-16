/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

/**
 *
 * @author Cole
 */
public class CurrentGame {
    public CurrentGame(boolean yourTurn, int gameId, String friendName, int friendScore, int yourScore){
        this.yourTurn = yourTurn;
        this.gameId = gameId;
        this.friendName = friendName;
        this.friendScore = friendScore;
        this.yourScore = yourScore;
    }
    private boolean yourTurn;
    private int gameId;
    private String friendName;
    private int friendScore;
    private int yourScore;
    
}
