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

    public boolean isYourTurn() {
        return yourTurn;
    }

    public void setYourTurn(boolean yourTurn) {
        this.yourTurn = yourTurn;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    public int getFriendScore() {
        return friendScore;
    }

    public void setFriendScore(int friendScore) {
        this.friendScore = friendScore;
    }

    public int getYourScore() {
        return yourScore;
    }

    public void setYourScore(int yourScore) {
        this.yourScore = yourScore;
    }
    
}
