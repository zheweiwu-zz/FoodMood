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
import java.time.LocalDateTime;
import moodmodel.MoodModel;
import java.util.Date;
/**
 *
 * @author Alex
 */
public class Database {
    
    public static String url = "https://foodmood-a4f9d.firebaseio.com/";
    public static String url2 = "https://foodmood-a4f9d.firebaseio.com/profiles.json";
    public static String username;
    private String password;
    public static String lastFoodID;
    private static Database instance = null;
    
    
    
    public static Database getInstance()
    {
    if(instance == null){instance = new Database();}
    return instance;
    }
    //*********************************************************************Profile Section********************************************************************
 
    public static boolean authProfile(String username, String password)
    {
     String url = "https://foodmood-a4f9d.firebaseio.com/profiles/" + username + ".json";
        String inputLine;
       
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
            
            System.out.print(inputLine);

         if (inputLine.contains(username) && inputLine.contains(password))
         {
             Database.username = username;
         return true;
         }
//System.out.println("Holy shit it works!");
        } catch (IOException e) {
        }
        return false;
    }
    
    /**
     * checks for existing profile, returns true if profile exists
     * @param username the username to be checked
     */
    public static boolean checkProfile(String username) {
        String url = "https://foodmood-a4f9d.firebaseio.com/profiles/" + username + ".json";
        String inputLine;
       
        //System.out.println(url);
        try {
            URL urlConnect = new URL(url);
            HttpURLConnection con = (HttpURLConnection) urlConnect.openConnection();
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            inputLine = in.readLine();
            
            System.out.print(inputLine);

        if (inputLine.contains(username)) {
            Database.username = username;
            return true;
        }

        } catch (IOException e) {
        
        }
        return false;
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
            Database.lastFoodID = newFood.getID();
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
            URL urlConnection = new URL("https://foodmood-a4f9d.firebaseio.com/profiles/" + Database.username + "/"+ Database.lastFoodID +"/.json");

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

}
