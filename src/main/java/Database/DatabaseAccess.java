/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cole
 */
public class DatabaseAccess {
    
    public DatabaseAccess()
    {
        
    }
    public TriviaQuestion getQuestion(){
        TriviaQuestion sendQuestion = new TriviaQuestion("Why did Ananias die?", "He lied", "He was persecuted by the Romans", "He was sick of the palsy", "He had leprosy");
        return sendQuestion;
    }
    public CurrentGame getGame(int gameId){
        //get from DB
        CurrentGame game = new CurrentGame(true, gameId, "FRIEND NAME", 14, 12);
        return game;
    }
    public CurrentGame createNewGame(String yourName, String friendName, String friendId){
    
        CurrentGame game = new CurrentGame(true, 0, friendName, 0, 0);
        return game;
    }
    public List<CurrentGame> getYourGameList(int userId){
        
        List<CurrentGame> listReturn = new ArrayList();
        CurrentGame game = new CurrentGame(true, 1, "FRIEND NAME", 14, 12);
        listReturn.add(game);
        game = new CurrentGame(true, 2, "COLE", 2, 4);
        listReturn.add(game);
        return listReturn;
    }
    public List<CurrentGame> getTheirGameList(int userId){
        CurrentGame game = new CurrentGame(false, 3, "Justin", 4, 7);
        List<CurrentGame> listReturn = new ArrayList();
        listReturn.add(game);
        game = new CurrentGame(false, 4, "Cordon", 4, 1);
        listReturn.add(game);
        return listReturn;
    }
    public List<CurrentGame> getGameList(int userId){
        CurrentGame game = new CurrentGame(true, 1, "FRIEND NAME", 14, 12);
        List<CurrentGame> listReturn = new ArrayList();
        listReturn.add(game);
        return listReturn;
    }
    
}
