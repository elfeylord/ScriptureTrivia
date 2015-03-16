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
    public List<CurrentGame> getGameList(int userId){
        CurrentGame game = new CurrentGame(true, 1, "FRIEND NAME", 14, 12);
        List<CurrentGame> listReturn = new ArrayList();
        listReturn.add(game);
        return listReturn;
    }
    
}
