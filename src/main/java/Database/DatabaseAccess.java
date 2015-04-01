/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import java.sql.Connection;

/**
 *
 * @author Cole
 */
public class DatabaseAccess {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost/scripture_trivia";
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
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

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
   
    public TriviaQuestion getQuestion(String category){
        String sql;
        ResultSet rs = null;
        String trivia_question = null;
        String cAnswer = null;
        String iAnswer1 = null;
        String iAnswer2 = null;
        String iAnswer3 = null;
        
        //STEP 4: Execute a query
        try{
            stmt = conn.createStatement();
            
            sql = "SELECT count(*) AS num_questions "
                    + "FROM question AS q "
                    + "JOIN category AS c on c.id = q.category_id "
                    + "WHERE c.name = '" + category + "'";
            rs = stmt.executeQuery(sql);
            
            rs.next();
            int max = rs.getInt("num_questions");
            System.out.print("num_questions: " + max);
            System.out.print("connect: " + DB_URL);
            
            int row = (int) (1 + Math.random() * (max ));
            System.out.print("row: " + row);
            
            sql = "SELECT q.trivia_question, q.id "
                    + "FROM question AS q "
                    + "JOIN category AS c on c.id = q.category_id "
                    + "WHERE c.name = '" + category + "' "
                    + "ORDER BY q.id";
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
            
            //test section
//            User user = new User("wutev", "whateve", 123, true);
//            User user2 = new User("number2", "number2.buhaha", 321, false);
//            createGame(user, user2);
//            
//            
//            List<Game> games = getGames(user);
//            games.get(2).getUser().setScore(45);
//            games.get(2).getFriend().setScore(57);
//            games.get(2).getUser().setIsTurn(false);
//            games.get(2).getFriend().setIsTurn(true);
//            saveGame(games.get(2));
            
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
                 
        TriviaQuestion sendQuestion = new TriviaQuestion(trivia_question, cAnswer, iAnswer1, iAnswer2, iAnswer3);
        return sendQuestion;
    }
    
    public void removeGame(int gameId){
        //STEP 4: Execute a query
        String sql;
        ResultSet rs = null;
        
        try{
            stmt = conn.createStatement();
            
            sql = "Delete FROM game_user "
                    + "WHERE game_id = " + gameId;
            stmt.executeQuery(sql);   
            
            sql = "Delete FROM game "
                    + "WHERE id = " + gameId;
            stmt.executeQuery(sql);   
            
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
    }
    
    public CurrentGame getGame(int gameId){
        //get from DB
        CurrentGame game = new CurrentGame(true, 2, "FRIEND NAME", "", 21, 21);
        return game;
    }
    
    public List<Game> getGames(User user){
        List<Game> gameList = new ArrayList<>();
        String sql = null;
        //ResultSet rs = null;
        
        try{
            stmt = conn.createStatement();
            
            sql = "SELECT g.id FROM game AS g "
                    + "JOIN game_user AS gu ON gu.game_id = g.id "
                    + "JOIN user AS u ON u.id = gu.user_id "
                    + "WHERE u.facebook_id = '" + user.getFacebookId() + "' "
                    + "ORDER BY g.id";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next())
            {
                Statement stm = conn.createStatement();
                ResultSet r = null;
                Game game = null;
                User opponent = null ; 
                sql = "SELECT u.facebook_id, u.name, gu.score, gu.isTurn FROM user AS u "
                        + "JOIN game_user AS gu ON gu.user_id = u.id "
                        + "JOIN game AS g ON g.id = gu.game_id "
                        + "WHERE g.id = " + rs.getInt("g.id") + " AND u.facebook_id != '" + user.getFacebookId() + "'";
         
                r = stm.executeQuery(sql);
                
                r.next();
                //System.out.println("check this value:" + r.getBoolean("gu.isTurn"));
                boolean isTurn = false;
                
                if(r.getInt("gu.isTurn") == 0)
                    isTurn = false;
                else
                    isTurn = true;
                
                opponent = new User(r.getString("u.facebook_id"), r.getString("u.name"), r.getInt("gu.score"), isTurn);

                sql = "SELECT u.facebook_id, u.name, gu.score, gu.isTurn FROM user AS u "
                        + "JOIN game_user AS gu ON gu.user_id = u.id "
                        + "JOIN game AS g ON g.id = gu.game_id "
                        + "WHERE g.id = " + rs.getInt("g.id") + " AND u.facebook_id = '" + user.getFacebookId() + "'";
         
                r = stm.executeQuery(sql);
                
                r.next();
                //System.out.println("check this value:" + r.getBoolean("gu.isTurn"));
                isTurn = false;
                
                if(r.getInt("gu.isTurn") == 0)
                    isTurn = false;
                else
                    isTurn = true;
                
                //hopefully this doesnt cause an interesting bug.
                User userGame = new User(r.getString("u.facebook_id"), r.getString("u.name"), r.getInt("gu.score"), isTurn);
                game = new Game(userGame, opponent, rs.getInt("g.id"));
                gameList.add(game);
            }
            
            
            
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
         }
        
        return gameList;
    }
    
    public Game createGame(User user, User opponent){
        checkUser(user);
        checkUser(opponent);
        Game game = null;
        int autoId;
        
        try{
            String sql = "INSERT INTO game () VALUES ()";
            stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            autoId = rs.getInt(1);
            
            sql = "INSERT INTO game_user(user_id, game_id, score, isTurn) "
                    + "VALUES((SELECT id FROM user WHERE facebook_id = '" + user.getFacebookId() + "'), "
                    + "'" + autoId + "', 0, true)";
            
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO game_user(user_id, game_id, score, isTurn) "
                    + "VALUES((SELECT id FROM user WHERE facebook_id = '" + opponent.getFacebookId() + "'),"
                    + "'" + autoId + "', 0, false)";
            
            stmt.executeUpdate(sql);
            
            game = new Game(user, opponent, autoId);
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }        
        return game;
    }
    
    public void checkUser(User user){
        String sql;
        ResultSet rs = null;
        
        try{
            stmt = conn.createStatement();
            
            sql = "SELECT COUNT(*) as rowcount FROM user "
                    + "WHERE facebook_id = '" + user.getFacebookId() +"'";
          
            rs = stmt.executeQuery(sql);   
            
            rs.next();
                
            int count = rs.getInt("rowcount");
            
            if(count == 0)
                addNewUser(user);
            
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        } 
    }
    
    public void addNewUser(User user){
        String sql;
        
        try{
            stmt = conn.createStatement();
            
            sql = "INSERT INTO user (facebook_id, name) "
                    + "VALUES('" + user.getFacebookId() + "', '" + user.getName() + "')";
            stmt.executeUpdate(sql);      
            
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
         }
    }
            
    public List<CurrentGame> getGameList(int userId){
        CurrentGame game = new CurrentGame(true, 1, "FRIEND NAME", "", 14, 12);
        List<CurrentGame> listReturn = new ArrayList();
        listReturn.add(game);
        return listReturn;
    }
        
    public void saveGame(Game game){
        
        try{
            stmt = conn.createStatement();
            String sql = null;
            sql = "UPDATE user AS u "
                    + "JOIN game_user AS gu ON gu.user_id = u.id "
                    + "JOIN game AS g ON g.id = gu.game_id "
                    + "SET gu.score = " + game.getUser().getScore() + ", "
                    + "isTurn = " + game.getUser().getIsTurn() + " "
                    + "where g.id = " + game.getGameId() + " AND u.facebook_id = '" + game.getUser().getFacebookId() + "'";
            
            stmt.executeUpdate(sql);
            
            sql = "UPDATE user AS u "
                    + "JOIN game_user AS gu ON gu.user_id = u.id "
                    + "JOIN game AS g ON g.id = gu.game_id "
                    + "SET gu.score = " + game.getFriend().getScore() + ", "
                    + "isTurn = " + game.getFriend().getIsTurn() + " "
                    + "where g.id = " + game.getGameId() + " AND u.facebook_id = '" + game.getFriend().getFacebookId() + "'";
            
            stmt.executeUpdate(sql);
            
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }        
    } 
}
