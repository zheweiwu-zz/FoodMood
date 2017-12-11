/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasecontroller;

import foodmodel.FoodModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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

    public static Database getInstance() throws ClassNotFoundException, SQLException {
        if (connection == null) {
            db = new Database();
        }
        return db;
    }
    //*********************************************************************Profile Section********************************************************************

    public static boolean authProfile(String username, String password) throws ClassNotFoundException, SQLException {
        Database db = getInstance();
        ResultSet results = db.getRows("SELECT * FROM users WHERE username='" + username + "'");
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
     *
     * @param username the username to be checked
     */
    public static boolean checkProfile(String username) throws ClassNotFoundException, SQLException {
        Database db = getInstance();
        ResultSet results = db.getRows("SELECT * FROM users WHERE username='" + username + "'");
        return results.next();
    }

//This method should take a ProfileModel object.
    public static void POSTProfile(String username, String password, String age, String weight) throws Exception {
        Database db = getInstance();
        //System.out.println("INSERT into users (username, password, age, weight) VALUES ('"+username+"','"+password+"','"+age+"', '"+weight+"')");
        db.insertSql("insert into users (username, password, age, weight) values('" + username + "','" + password + "','" + age + "', '" + weight + "')");
    }

    // This method should return a profile model object.
    public void readProfileData(String username) throws ClassNotFoundException, SQLException {

        Database db = getInstance();
        ResultSet results = db.getRows("SELECT * FROM users WHERE username='" + Database.username + "'");
    }

    // this method will take a profilemodel, user data parameter (e.g. weight) and the value of the parameter (e.g. 180)
    public void updateProfileData(String username, String colToUpdate, String colValue, String condition, String conditionValue) throws ClassNotFoundException, SQLException {
        Database db = getInstance();
        String set = colToUpdate;
        String cond = condition;
        String sql = "UPDATE users SET " + set + " = ? , "
                + "WHERE " + cond + " = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, colValue);
            pstmt.setString(2, conditionValue);
            sql = pstmt.toString();
            pstmt = null;
            db.getRows(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // this method will take a ProfileModel object
    public void deleteProfileData(String username, String condition, String conditionValue) throws ClassNotFoundException, SQLException {
        Database db = getInstance();
        String cond = condition;
        String sql = "DELETE FROM users, "
                + "WHERE " + cond + " = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, conditionValue);
            sql = pstmt.toString();
            pstmt = null;
            db.getRows(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // **************************************************************FOODS SECTION***************************************************************************
    public static void POSTFood(FoodModel newFood) throws Exception {
        Database db = getInstance();
        db.insertSql("INSERT into foods (userid, food, datetime) VALUES ('" + Database.username + "','" + newFood.getName() + "', '" + newFood.getDateTime().toString() + "')");
    }

    // This method should return a profile model object.
    public static ArrayList<FoodModel> readFoodData() throws ClassNotFoundException, SQLException {

        Database db = getInstance();
        ResultSet results = db.getRows("SELECT * FROM foods WHERE userid='" + Database.username + "'");
        ArrayList<FoodModel> foods = new ArrayList<>();
        while (results.next()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
            LocalDateTime dateTime = LocalDateTime.parse(results.getString("datetime"), formatter);
            foods.add(new FoodModel(results.getString("food"), dateTime, results.getString("id")));
        }
        return foods;

    }

    // this method will take a profilemodel, user data parameter (e.g. weight) and the value of the parameter (e.g. 180)
    public static void updateFoodData(String id, String newName) throws ClassNotFoundException, SQLException {
        Database db = getInstance();
        db.insertSql("UPDATE foods SET food = '" + newName + "' WHERE id = '" + id + "'");
    }

    // this method will take a ProfileModel object
    public static void deleteFoodData(String foodID) throws ClassNotFoundException, SQLException {
        Database db = getInstance();
        db.insertSql("DELETE from foods WHERE id='"+foodID+"'");
    }

    // **************************************************************Moods SECTION***************************************************************************
    public static void POSTMood(MoodModel newMood) throws Exception {

        Database db = getInstance();
        db.insertSql("INSERT into moods (userid, rating, datetime) VALUES ('"+Database.username+"', '"+newMood.getMoodRating()+"', '"+newMood.getDateTime().toString()+"')");

    }

    // This method should return a profile model object.
    public void readMoodData(String moodID) throws ClassNotFoundException, SQLException {

        Database db = getInstance();
        ResultSet results = db.getRows("SELECT * FROM foods WHERE userid='" + Database.username + "'");
    }

    // this method will take a profilemodel, user data parameter (e.g. weight) and the value of the parameter (e.g. 180)
    public void updateMoodData(String moodID, String newMoodName, String colToUpdate, String colValue, String condition, String conditionValue) throws ClassNotFoundException, SQLException {

        Database db = getInstance();
        String set = colToUpdate;
        String cond = condition;
        String sql = "UPDATE users SET " + set + " = ? , "
                + "WHERE " + cond + " = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, colValue);
            pstmt.setString(2, conditionValue);
            sql = pstmt.toString();
            pstmt = null;
            db.getRows(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // this method will take a ProfileModel object
    public void deleteMoodData(String moodID, String condition, String conditionValue) throws ClassNotFoundException, SQLException {
        Database db = getInstance();
        String cond = condition;
        String sql = "DELETE FROM users, "
                + "WHERE " + cond + " = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, conditionValue);
            sql = pstmt.toString();
            pstmt = null;
            db.getRows(sql);
        } catch (SQLException e) {
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
          ResultSet results = db.getRows("SELECT * FROM moods WHERE userid = 'zhewei'");
          while (results.next()) {
              System.out.println(results.getString("rating"));
          }
//        db.insertSql("drop table if exists users");
//        db.insertSql("create table users (id integer PRIMARY KEY, username text, password text, age text, weight text)");
//        db.insertSql("insert into users (username, password, age, weight) values ('zhewei', 'password', '22' ,'150')");
//        db.insertSql("drop table if exists foods");
//        db.insertSql("drop table if exists moods");
//        db.insertSql("create table foods (id integer PRIMARY KEY, userid integer, food text, datetime text)");
//        db.insertSql("create table moods (id integer PRIMARY KEY, userid integer, rating integer, datetime text)");

    }

}
