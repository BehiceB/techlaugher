/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Havvanur BOZÖMEROĞLU
 */
public class PostFonksiyonlari {
    
    
     public static String getUsername(String email) {
          String username = "";

        
            try {
                String sql = "SELECT username FROM T_USER WHERE email = ?";

                PreparedStatement statement = Database.getConnection().prepareStatement(sql);
                statement.setString(1, email);

                ResultSet rs = statement.executeQuery();

                if (rs.next()) {
                    username = rs.getString(1);
                }

                Database.close();

            } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        

        return username;
    }
    
    public static String getUsername(int postId) {
          String username = "";

        
            try {
                String sql = "SELECT username FROM POST WHERE postId = ?";

                PreparedStatement statement = Database.getConnection().prepareStatement(sql);
                statement.setInt(1, postId);

                ResultSet rs = statement.executeQuery();

                if (rs.next()) {
                    username = rs.getString(1);
                }

                Database.close();

            } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        

        return username;
    }
     
     
     public static int getPostId() {
        int maxId = -1;

        try {

            String sql = "SELECT Max(postId) FROM POST ";
            PreparedStatement state = data.Database.getConnection().prepareStatement(sql);
            ResultSet set = state.executeQuery();

            if (set.next()) {
                maxId = set.getInt(1);
            }

        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }

        return maxId;
    }
    
     public static int getPostIdd(String description) {
        int postId =0;

        try {

            String sql = "SELECT postId FROM POST WHERE description=? ";
            PreparedStatement statement = data.Database.getConnection().prepareStatement(sql);
            statement.setString(1, description);
            ResultSet set = statement.executeQuery();

            if (set.next()) {
                postId= set.getInt(1);
            }

        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }

        return postId;
    }
    
    public static void addPost( String username, String description, String field) {
       
            try {

                String sql = "INSERT INTO POST (postId,  username, likeNum, savedNum, description, field) VALUES (?,?,?,?,?,?)";

                int postId = getPostId() + 1;

                PreparedStatement statement = data.Database.getConnection().prepareStatement(sql);

                statement.setInt(1, postId);
                statement.setString(2, username);
                statement.setInt(3, 0);
                statement.setInt(4, 0);
                statement.setString(5, description);
                statement.setString(6, field);
                
                
                statement.executeUpdate();
                
                sql = "insert into POST (postId) values (?)";

                statement = data.Database.getConnection().prepareStatement(sql);
                statement.setInt(1, postId);
                statement.executeUpdate();

               

                data.Database.close();

             } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
             
        
    }
    
    public static String getField(int postId){
       
        String field = "";

        
            try {
                String sql = "SELECT field FROM POST WHERE postId=? ";

                PreparedStatement statement = Database.getConnection().prepareStatement(sql);
                 statement.setInt(1, postId);

                ResultSet rs = statement.executeQuery();

                if (rs.next()) {
                    field = rs.getString(1);
                }

                Database.close();
        
        
            
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
     
        }
            return field;
    }
    
     public static int getLikeNum(int postId){
       
        int likeNum = 0;

        
            try {
                String sql = "SELECT likeNum FROM POST  WHERE postId=?";

                PreparedStatement statement = Database.getConnection().prepareStatement(sql);
                 statement.setInt(1, postId);

                ResultSet rs = statement.executeQuery();

                if (rs.next()) {
                    likeNum = rs.getInt(1);
                }

                Database.close();
        
        
            
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
     
        }
            return likeNum;
    }
    
     public static String getDescription(int postId){
       
        String description = "";

        
            try {
                String sql = "SELECT description FROM POST WHERE postId=? ";

                PreparedStatement statement = Database.getConnection().prepareStatement(sql);
                statement.setInt(1, postId);

                ResultSet rs = statement.executeQuery();

                if (rs.next()) {
                    description = rs.getString(1);
                }

                Database.close();
        
        
            
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
     
        }
            return description;
    }
     
     
     
     
     public static ArrayList<Integer> showAl(){
          ArrayList<Integer> postList= new ArrayList<Integer>();
         
          try {
              
          String sql = "SELECT DISTINCT postId FROM POST WHERE field = 'Al' ";
          PreparedStatement statement = Database.getConnection().prepareStatement(sql);
          ResultSet rs=statement.executeQuery();
          while(rs.next()){
              postList.add(rs.getInt(1));
              //int postt = rs.getInt(1);
             // postList.add(postt);
             
          }
          
      }catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
     
        }
          return postList;
      }
     
     
     
     
     public static ArrayList showCyberIds(){
          ArrayList<String> postList = new ArrayList();
          //String post="";
          try {
              
          String sql = "SELECT DISTINCT description FROM POST where field='Al' ";
          PreparedStatement statement = Database.getConnection().prepareStatement(sql);
          ResultSet rs=statement.executeQuery(sql);
          if(rs.next()){
              postList.add(rs.getString("description"));
          }
          
      }catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
     
        }
          return postList;
      }

     
     
      public static ArrayList<Message> GetFollowTweets() {
        ArrayList<Message> obj = new ArrayList<>();
        
       
          

        try {
            String sql = "select * from POST where field = 'Al' order by postId  ";
          PreparedStatement statement = Database.getConnection().prepareStatement(sql);
          ResultSet rs=statement.executeQuery(sql);
            
            
           
            while (rs.next()) {
                obj.add(new Message(rs.getString("username"), rs.getString("description"), rs.getInt("likeNum")));
            }
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
     
        }
        
        return obj;
    }
    
     
     
     
    public static void main(String args[]){
        
      String username = PostFonksiyonlari.getUsername("havva@gmail.com");
        System.out.println("caliştiiii");
        String des = PostFonksiyonlari.getDescription(12);
        ArrayList<Integer> postList= new ArrayList<>();
        postList = PostFonksiyonlari.showAl();
        for(int i = 0; i < postList.size(); i++){
            int postt = postList.get(i);
            System.out.println(postt);
            System.out.println(postList.size());
            
        }
        System.out.println(des);
        System.out.println(username);
    }
    
}
