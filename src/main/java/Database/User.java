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
public class User {
    private String facebookId;
    private String name;
    private int score;
    private boolean isTurn;
    
    public User(String facebookId, String name, int score, boolean isTurn)
    {
        this.facebookId = facebookId;
        this.name = name;
        this.score = score;
        this.isTurn = isTurn;
    }
    
    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean getIsTurn() {
        return isTurn;
    }

    public void setIsTurn(boolean isTurn) {
        this.isTurn = isTurn;
    }
    
    
}
