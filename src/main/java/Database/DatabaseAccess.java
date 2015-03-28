/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cole
 */
public class DatabaseAccess {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://127.4.137.2:3306/scripture_trivia";
    static final String USER = "trivia";
    static final String PASS = "trivia"; 
    private Connection conn = null;
    private Statement stmt = null;  
   public DatabaseAccess()
    {

        
        try{
            //Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //Open a connection
            System.out.println("Connecting to database...");
            conn = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);

         }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
         }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
         }
    }
   
   public void finialize(){
                  //finally block used to close resources
            try{
               if(stmt!=null)
                  stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
               if(conn!=null)
                  conn.close();
            }catch(SQLException se){
               se.printStackTrace();
            }//end finally try
       System.out.println("Goodbye!");
   }
    public TriviaQuestion getQuestion(){
        String sql;
        ResultSet rs = null;
        String trivia_question = null;
        String cAnswer = null;
        String iAnswer1 = null;
        String iAnswer2 = null;
        String iAnswer3 = null;
        
        //STEP 4: Execute a query
        try{
            stmt = (Statement) conn.createStatement();
            
            sql = "SELECT count(*) AS num_questions FROM question";
            rs = stmt.executeQuery(sql);
            
            rs.next();
            int max = rs.getInt("num_questions");
            System.out.print("num_questions: " + max);
            System.out.print("connect: " + DB_URL);
            
            int row = (int) (1 + Math.random() * (max ));
            System.out.print("row: " + row);
            
            sql = "SELECT trivia_question, id FROM question ORDER BY id";
            rs = stmt.executeQuery(sql);
            
            //STEP 5: Extract data from result set
            for(int i = 0; i < row; i++)
                rs.next();
            trivia_question = rs.getString("trivia_question");
            int question_id = rs.getInt("id");
            
            System.out.print("question: " + trivia_question);
            
            sql = "SELECT text FROM answer AS a " +
                  "JOIN question AS q ON q.id = question_id " +
                  "WHERE q.id = " + question_id;
            rs = stmt.executeQuery(sql);
            
            rs.next();
            cAnswer = rs.getString("text");
            
            rs.next();
            iAnswer1 = rs.getString("text");
            
            rs.next();
            iAnswer2 = rs.getString("text");
            
            rs.next();
            iAnswer3 = rs.getString("text");
            
            
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
         }
                 
        TriviaQuestion sendQuestion = new TriviaQuestion(trivia_question, cAnswer, iAnswer1, iAnswer2, iAnswer3);
        return sendQuestion;
    }
    
    public void removeGame(int gameId){
        
    }
    
    public CurrentGame getGame(int gameId){
        //get from DB
        CurrentGame game = new CurrentGame(true, 2, "FRIEND NAME", "", 21, 21);
        return game;
    }
    
    public CurrentGame createNewGame(String yourName, String friendName, String friendId){
    
        CurrentGame game = new CurrentGame(true, 0, friendName, friendId, 20, 20);
        return game;
    }
    
    public List<CurrentGame> getYourGameList(int userId){
        
        List<CurrentGame> listReturn = new ArrayList();
        CurrentGame game = new CurrentGame(true, 1, "FRIEND NAME", "", 14, 12);
        listReturn.add(game);
        game = new CurrentGame(true, 2, "COLE", "", 2, 4);
        listReturn.add(game);
        return listReturn;
    }
    
    public List<CurrentGame> getTheirGameList(int userId){
        CurrentGame game = new CurrentGame(false, 3, "Justin", "", 4, 7);
        List<CurrentGame> listReturn = new ArrayList();
        listReturn.add(game);
        game = new CurrentGame(false, 4, "Cordon", "", 4, 1);
        listReturn.add(game);
        return listReturn;
    }
    
    public List<CurrentGame> getGameList(int userId){
        CurrentGame game = new CurrentGame(true, 1, "FRIEND NAME", "", 14, 12);
        List<CurrentGame> listReturn = new ArrayList();
        listReturn.add(game);
        return listReturn;
    }
    
    public void addUser(String name){
        
    }
}
