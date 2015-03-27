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
    public CurrentGame (String friendName, String friendId){
        //CREATE NEW FROM DATABASE
        this.friendName = friendName;
        this.friendId = friendId;
        //hard coded
        this.friendScore = 0;
        this.gameId = 0;
        this.yourScore = 0;
        this.yourTurn = true;
    }
    public CurrentGame(boolean yourTurn, int gameId, String friendName, String friendId, int friendScore, int yourScore){
        this.yourTurn = yourTurn;
        this.gameId = gameId;
        this.friendName = friendName;
        this.friendId = friendId;
        this.friendScore = friendScore;
        this.yourScore = yourScore;
    }
    private boolean yourTurn;
    private int gameId;
    private String friendName;
    private String friendId;
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

    public String getFriendId() {
        return friendId;
    }

    public void setFriendId(String friendId) {
        this.friendName = friendId;
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
