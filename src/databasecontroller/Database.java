/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasecontroller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import javax.net.ssl.HttpsURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import foodmodel.FoodModel;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import moodmodel.MoodModel;
/**
 *
 * @author Alex
 */
public class Database {
    
    private static Connection connection = null;
    private static Statement statement;
    public static String username;
    private String password;
    private static Database db;
    
    private Database() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:FoodMood.db");
        statement = connection.createStatement();
        statement.setQueryTimeout(30);
    }
    
    public static Database getInstance() throws ClassNotFoundException, SQLException
    {
        if(connection == null){db = new Database();}
        return db;
    }
    //*********************************************************************Profile Section********************************************************************
 
    public static boolean authProfile(String username, String password) throws ClassNotFoundException, SQLException
    {
        Database db = getInstance();
        ResultSet results = db.getRows("SELECT * FROM users WHERE username='"+username+"'");
        String pw = null;
        while (results.next()) {
            pw = results.getString("password");
            System.out.println(pw);
        }
        if (password.equals(pw)) {
            Database.username = username;
        }
        return password.equals(pw);
    }
    
    /**
     * checks for existing profile, returns true if profile exists
     * @param username the username to be checked
     */
    public static boolean checkProfile(String username) throws ClassNotFoundException, SQLException {
        Database db = getInstance();
        ResultSet results = db.getRows("SELECT * FROM users WHERE username='"+username+"'");
        return results.next();
    }
    
//This method should take a ProfileModel object.
    public static void POSTProfile(String username, String password, String age, String weight) throws Exception {
        Database db = getInstance();
        db.insertSql("INSERT into users (username, password, age, weight) VALUES ('"+Database.username+"','"+password+"','"+age+"', '"+weight+"')");
        
        //for firebase
        /*
        try {
            URL urlConnection = new URL("https://foodmood-a4f9d.firebaseio.com/profiles.json");

            HttpURLConnection con = (HttpURLConnection) urlConnection.openConnection();
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            con.setRequestProperty("X-HTTP-Method-Override", "PATCH");
            con.setRequestMethod("POST");
// User profile info gets translated into JSON to be used in the next line. Use .getname() kinda stuff.
            String jsonFormattedUserData = "{ \"" + username + "\": { \"username\": \"" + username + "\" , \"password\" :\"" + password + "\" , \"age\" :\"" + age + "\" , \"weight\" :\"" + weight + "\" } }";

            try ( //System.out.println("");
                    OutputStreamWriter osw = new OutputStreamWriter(con.getOutputStream())) {
                osw.write(jsonFormattedUserData);
                osw.flush();
            }

            if (con.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
                System.out.print("HTTP code : "
                        + con.getResponseCode());
            }

        } catch (MalformedURLException e) {
            System.out.print("URL Malformed");
        }*/

    }
    
    // This method should return a profile model object.
    public void readProfileData(String username) throws ClassNotFoundException, SQLException{
        
        Database db = getInstance();
        ResultSet results = db.getRows("SELECT * FROM users WHERE username='"+Database.username+"'");
        
        /*
        //for firebase
        String url = "https://foodmood-a4f9d.firebaseio.com/profiles/" + username + ".json";
        String inputLine = "";
        //System.out.println(url);
        try {
            URL urlConnect = new URL(url);
            HttpURLConnection con = (HttpURLConnection) urlConnect.openConnection();
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));

            inputLine = in.readLine();

            //System.out.println(inputLine);//testline
        } catch (Exception e) {
            e.printStackTrace();
        }
        // This will construct a profile model object.
        //return new ProfileModel();*/
    }
    
    // this method will take a profilemodel, user data parameter (e.g. weight) and the value of the parameter (e.g. 180)
    public void updateProfileData(String username, String colToUpdate, String colValue, String condition, String conditionValue)throws ClassNotFoundException, SQLException
    {
        Database db = getInstance();
        String sql = "UPDATE users SET ? = ? , "
                + "WHERE ? = ?";
       try{ PreparedStatement pstmt = connection.prepareStatement(sql);
        
        pstmt.setString(1,colToUpdate);
        pstmt.setString(2,colValue);
        pstmt.setString(3,condition);
        pstmt.setString(4,conditionValue);   
        sql = pstmt.toString();
        pstmt = null;
        db.getRows(sql);
       }catch (SQLException e){
           e.printStackTrace();
       }
    
       /*
    //for firebase   
    try {
        String url = "https://foodmood-a4f9d.firebaseio.com/profiles/" + username + ".json";
            URL urlConnect = new URL(url);
            HttpURLConnection con = (HttpURLConnection) urlConnect.openConnection();
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestProperty("X-HTTP-Method-Override", "PATCH");
            con.setRequestMethod("POST");            
          // User profile info gets translated into JSON to be used in the next line. Use .getname() kinda stuff.
            String jsonFormattedUserData = new String();
        } 
    catch (Exception e) 
        {
            e.printStackTrace();
        }*/    
    }
    
    // this method will take a ProfileModel object
    public void deleteProfileData(String username, String condition, String conditionValue) throws ClassNotFoundException, SQLException
    {
        Database db = getInstance();
        String sql = "DELETE FROM users, "
                + "WHERE ? = ?";
       try{ PreparedStatement pstmt = connection.prepareStatement(sql);
        
        pstmt.setString(1,condition);
        pstmt.setString(2,conditionValue);   
        sql = pstmt.toString();
        pstmt = null;
        db.getRows(sql);
       }catch (SQLException e){
           e.printStackTrace();
       }
    
       /*
    //for firebase
    try {
            String url = "https://foodmood-a4f9d.firebaseio.com/profiles/" + username + ".json";
            URL urlConnect = new URL(url);
            HttpURLConnection con = (HttpURLConnection) urlConnect.openConnection();
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestProperty("X-HTTP-Method-Override", "PATCH");
            con.setRequestMethod("POST");

            
          // User profile info gets translated into JSON to be used in the next line. Use .getname() kinda stuff.
            String jsonFormattedUserData = new String();
            
            
        } 
    catch (Exception e) 
        {
            e.printStackTrace();
        }*/
    }
    
    // **************************************************************FOODS SECTION***************************************************************************
    public static void POSTFood(FoodModel newFood) throws Exception {
        Database db = getInstance();
        db.insertSql("INSERT into foods (userid, food, foodid, datetime) VALUES ('"+Database.username+"','"+newFood.getName()+"', ' "+newFood.getID()+"', '"+newFood.getDateTime().toString()+"')");
    }
    
    // This method should return a profile model object.
    public static void readFoodData(String foodID)throws ClassNotFoundException, SQLException{
        
        Database db = getInstance();
        ResultSet results = db.getRows("SELECT * FROM foods WHERE userid='"+Database.username+"'");        
        
        /*
        //for firebase
        String url = "https://foodmood-a4f9d.firebaseio.com/foods/" + foodID + ".json";
        String inputLine = "";
        //System.out.println(url);
        try {
            URL urlConnect = new URL(url);
            HttpURLConnection con = (HttpURLConnection) urlConnect.openConnection();
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));

            inputLine = in.readLine();

            //System.out.println(inputLine);//testline
        } catch (Exception e) {
            e.printStackTrace();
        }
        // This will construct a profile model object.
        //return new ProfileModel();*/
    }
    
    /*
    //Nate - not sure if this is still needed seems redundant to readFoodData
    public static String readAllFoodData() {
        String url = "https://foodmood-a4f9d.firebaseio.com/foods.json";
        String inputLine = "";
        //System.out.println(url);
        try {
            URL urlConnect = new URL(url);
            HttpURLConnection con = (HttpURLConnection) urlConnect.openConnection();
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));

            inputLine = in.readLine();

            //System.out.println(inputLine);//testline
        } catch (Exception e) {
            e.printStackTrace();
        }
        // This will construct a profile model object.
        //return new ProfileModel();
        return inputLine;
    }*/
    
    // this method will take a profilemodel, user data parameter (e.g. weight) and the value of the parameter (e.g. 180)
    public static void updateFoodData(String foodID, String newFoodName, LocalDateTime consumedAt, String colToUpdate, String colValue, String condition, String conditionValue)throws ClassNotFoundException, SQLException
    {
        //newFoodName and consumedAt can probably be removed
        
        Database db = getInstance();
        String sql = "UPDATE foods SET ? = ? , "
                + "WHERE ? = ?";
       try{ PreparedStatement pstmt = connection.prepareStatement(sql);
        
        pstmt.setString(1,colToUpdate);
        pstmt.setString(2,colValue);
        pstmt.setString(3,condition);
        pstmt.setString(4,conditionValue);   
        sql = pstmt.toString();
        pstmt = null;
        db.getRows(sql);
       }catch (SQLException e){
           e.printStackTrace();
       }
    
       /*
    //for firebase
    try {
        String url = "https://foodmood-a4f9d.firebaseio.com/foods/" + foodID + ".json";
            URL urlConnect = new URL(url);
            HttpURLConnection con = (HttpURLConnection) urlConnect.openConnection();
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestProperty("X-HTTP-Method-Override", "PATCH");
            con.setRequestMethod("POST");            
          // User profile info gets translated into JSON to be used in the next line. Use .getname() kinda stuff.
            String jsonFormattedUserData = " { \"name\": \"" + newFoodName + "\" , \"date\": \"" + consumedAt + "\" } ";           
        } 
    catch (Exception e) 
        {
            e.printStackTrace();
        }*/
    
    }
    // this method will take a ProfileModel object
    public void deleteFoodData(String foodID, String condition, String conditionValue) throws ClassNotFoundException, SQLException
    {
        Database db = getInstance();
        String sql = "DELETE FROM foods, "
                + "WHERE ? = ?";
       try{ PreparedStatement pstmt = connection.prepareStatement(sql);
        
        pstmt.setString(1,condition);
        pstmt.setString(2,conditionValue);   
        sql = pstmt.toString();
        pstmt = null;
        db.getRows(sql);
       }catch (SQLException e){
           e.printStackTrace();
       }
        
        /*
        for firebase
    try {
            String url = "https://foodmood-a4f9d.firebaseio.com/foods/" + foodID + ".json";
            URL urlConnect = new URL(url);
            HttpURLConnection con = (HttpURLConnection) urlConnect.openConnection();
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestProperty("X-HTTP-Method-Override", "PATCH");
            con.setRequestMethod("POST");

            
          // User profile info gets translated into JSON to be used in the next line. Use .getname() kinda stuff.
            String jsonFormattedUserData = new String("");
            
            
        } 
    catch (Exception e) 
        {
            e.printStackTrace();
        }*/
    }
    
     // **************************************************************Moods SECTION***************************************************************************
    public static void POSTMood(MoodModel newMood) throws Exception {
        
        Database db = getInstance();
        db.insertSql("INSERT into moods (userid, mood, moodid, datetime, associated foodID) VALUES ('"+Database.username+"','"+newMood.getDescription()+"', ' "+newMood.getID()+"', '"+newMood.getDateTime().toString()+"', '"+newMood.getParentFoodID()+"')");
        
        /*
        for firebase
        try {
            URL urlConnection = new URL("https://foodmood-a4f9d.firebaseio.com/profiles/" + Database.username + "/" +"/.json");

            HttpURLConnection con = (HttpURLConnection) urlConnection.openConnection();
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            con.setRequestProperty("X-HTTP-Method-Override", "PATCH");
            con.setRequestMethod("POST");
// User profile info gets translated into JSON to be used in the next line. Use .getname() kinda stuff.
            String jsonFormattedUserData = " { \"" + newMood.getID() + "\": { \"name\": \"" + newMood.getDescription() + "\" , \"date\": \"" + newMood.getDateTime() + "\" } }";

            //System.out.println("");

            OutputStreamWriter osw = new OutputStreamWriter(con.getOutputStream());
            osw.write(jsonFormattedUserData);
            osw.flush();
            osw.close();

            if (con.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
                System.out.print("HTTP code : "
                        + con.getResponseCode());
            }

        } catch (MalformedURLException e) {
            System.out.print("URL Malformed");
        }*/

    }
    // This method should return a profile model object.
    public void readMoodData(String moodID) throws ClassNotFoundException, SQLException{
        
        Database db = getInstance();
        ResultSet results = db.getRows("SELECT * FROM foods WHERE userid='"+Database.username+"'");
        
        /*
        for firebase
        String url = "https://foodmood-a4f9d.firebaseio.com/moods/" + moodID + ".json";
        String inputLine = "";
        //System.out.println(url);
        try {
            URL urlConnect = new URL(url);
            HttpURLConnection con = (HttpURLConnection) urlConnect.openConnection();
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));

            inputLine = in.readLine();

            //System.out.println(inputLine);//testline
        } catch (Exception e) {
            e.printStackTrace();
        }
        // This will construct a profile model object.
        //return new ProfileModel(); */
    }
    
    // this method will take a profilemodel, user data parameter (e.g. weight) and the value of the parameter (e.g. 180)
    public void updateMoodData(String moodID, String newMoodName, String colToUpdate, String colValue, String condition, String conditionValue) throws ClassNotFoundException, SQLException
    {
        
        Database db = getInstance();
        String sql = "UPDATE users SET ? = ? , "
                + "WHERE ? = ?";
       try{ PreparedStatement pstmt = connection.prepareStatement(sql);
        
        pstmt.setString(1,colToUpdate);
        pstmt.setString(2,colValue);
        pstmt.setString(3,condition);
        pstmt.setString(4,conditionValue);   
        sql = pstmt.toString();
        pstmt = null;
        db.getRows(sql);
       }catch (SQLException e){
           e.printStackTrace();
       }
        
        /*
        for firebase
    try {
        String url = "https://foodmood-a4f9d.firebaseio.com/foods/" + moodID + ".json";
            URL urlConnect = new URL(url);
            HttpURLConnection con = (HttpURLConnection) urlConnect.openConnection();
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestProperty("X-HTTP-Method-Override", "PATCH");
            con.setRequestMethod("POST");

            
          // User profile info gets translated into JSON to be used in the next line. Use .getname() kinda stuff.
            String jsonFormattedUserData = new String();
            
            
        } 
    catch (Exception e) 
        {
            e.printStackTrace();
        }*/
    
    }
    
    // this method will take a ProfileModel object
    public void deleteMoodData(String moodID,String condition, String conditionValue) throws ClassNotFoundException, SQLException
    {
        Database db = getInstance();
        String sql = "DELETE FROM foods, "
                + "WHERE ? = ?";
       try{ PreparedStatement pstmt = connection.prepareStatement(sql);
        
        pstmt.setString(1,condition);
        pstmt.setString(2,conditionValue);   
        sql = pstmt.toString();
        pstmt = null;
        db.getRows(sql);
       }catch (SQLException e){
           e.printStackTrace();
       }
        
        /*
        for firebase
    try {
            String url = "https://foodmood-a4f9d.firebaseio.com/foods/" + moodID + ".json";
            URL urlConnect = new URL(url);
            HttpURLConnection con = (HttpURLConnection) urlConnect.openConnection();
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestProperty("X-HTTP-Method-Override", "PATCH");
            con.setRequestMethod("POST");

            
          // User profile info gets translated into JSON to be used in the next line. Use .getname() kinda stuff.
            String jsonFormattedUserData = new String();
            
            
        } 
    catch (Exception e) 
        {
            e.printStackTrace();
        }*/
    }
    
    public void insertSql(String sql) throws SQLException {
        statement.executeUpdate(sql);
    }

    public ResultSet getRows(String sql) throws SQLException {
        ResultSet rs = statement.executeQuery(sql);
        return rs;
    }

    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Database db = new Database();
        db.insertSql("drop table if exists users");
        db.insertSql("create table users (id integer PRIMARY KEY, username text, password text, age text, weight text)");
        db.insertSql("insert into users (username, password, age, weight) values ('zhewei', 'password', '21', '150')");
        db.insertSql("drop table if exists foods");
        db.insertSql("drop table if exists moods");
        db.insertSql("create table foods (id integer PRIMARY KEY, userid integer, food text, foodid text, datetime text)");
        db.insertSql("create table moods (id integer PRIMARY KEY, userid integer, mood text, moodid text, datetime text, foodid text)");
    }
        
}
