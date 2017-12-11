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
        }

    }
    // This method should return a profile model object.
    public void readProfileData(String username) {
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
        //return new ProfileModel();
    }
    // this method will take a profilemodel, user data parameter (e.g. weight) and the value of the parameter (e.g. 180)
    public void updateProfileData(String username)
    {
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
        }
    
    }
    // this method will take a ProfileModel object
    public void deleteProfileData(String username)
    {
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
        }
    }
    // **************************************************************FOODS SECTION***************************************************************************
    public static void POSTFood(FoodModel newFood) throws Exception {
        try {
            System.out.print(newFood.getInfo());
            URL urlConnection = new URL("https://foodmood-a4f9d.firebaseio.com/profiles/" + Database.username + "/.json");

            HttpsURLConnection con = (HttpsURLConnection) urlConnection.openConnection();
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            con.setRequestProperty("X-HTTP-Method-Override", "PATCH");
            con.setRequestMethod("POST");
// User profile info gets translated into JSON to be used in the next line. Use .getname() kinda stuff.
            String jsonFormattedUserData = " { \"" + newFood.getID() + "\": { \"name\": \"" + newFood.getName() + "\" , \"date\": \"" + newFood.getDateTime() + "\" , \"userID\": \"" + newFood.getParentUserID() + "\" } }";

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
        }

    }
    // This method should return a profile model object.
    public static void readFoodData(String foodID) {
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
        //return new ProfileModel();
    }
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
    }
    
    // this method will take a profilemodel, user data parameter (e.g. weight) and the value of the parameter (e.g. 180)
    public static void updateFoodData(String foodID, String newFoodName, LocalDateTime consumedAt)
    {
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
        }
    
    }
    // this method will take a ProfileModel object
    public void deleteFoodData(String foodID)
    {
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
        }
    }
    
     // **************************************************************Moods SECTION***************************************************************************
    public static void POSTMood(MoodModel newMood) throws Exception {
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
        }

    }
    // This method should return a profile model object.
    public void readMoodData(String moodID) {
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
        //return new ProfileModel();
    }
    // this method will take a profilemodel, user data parameter (e.g. weight) and the value of the parameter (e.g. 180)
    public void updateMoodData(String moodID, String newMoodName)
    {
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
        }
    
    }
    // this method will take a ProfileModel object
    public void deleteMoodData(String moodID)
    {
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
        }
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
        db.insertSql("create table users (id integer PRIMARY KEY, username text, password text, weight text)");
        db.insertSql("insert into users (username, password, weight) values ('zhewei', 'password', '150')");
    }
}
