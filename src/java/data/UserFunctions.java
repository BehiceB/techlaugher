
package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Havvanur BOZÖMEROĞLU
 */
public class UserFonksiyonlari {

    /**
     * Tablodaki en son (yüksek) id'i döndürür.
     *
     * @return ID
     */
    public static int getId() {
        int maxId = -1;

        try {

            String sql = "SELECT Max(ID) FROM T_USER ";
            PreparedStatement state = data.Database.getConnection().prepareStatement(sql);
            ResultSet set = state.executeQuery();

            if (set.next()) {
                maxId = set.getInt(1);
            }

        } catch (SQLException e) {
            
        }

        return maxId;
    }
    
   
    
    
    public static String getUser(String info_type) {
        String info = "";
        try {

            String sql = "SELECT " + info_type + " FROM T_USER WHERE id = ?";
            PreparedStatement state = data.Database.getConnection().prepareStatement(sql);
            state.setInt(1, user.id);
            ResultSet set = state.executeQuery();

            if (set.next()) {
                info = set.getString(1);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return info;
    }

    /**
     * Kullanıcı adı kontrolü
     *
     * @param username Kullanıcı adı
     * @return Uygunluk
     */
    public static boolean isNewUsername(String username) {
        if (username != null && username.length() > 0) {
            try {

                String sql = "SELECT username FROM T_USER WHERE username = ?";
                PreparedStatement statement = data.Database.getConnection().prepareStatement(sql);

                statement.setString(1, username);
                ResultSet set = statement.executeQuery();

                if (!set.next()) {
                    data.Database.close();
                    return true;
                }

                data.Database.close();

            } catch (SQLException e) {
               
            }
        }
        return false;
    }

    

    /**
     * Mail kontrolü
     *
     * @param email E-mail
     * @return Uygunluk
     */
    public static boolean isNewEmail(String email) {
        if (email != null && email.length() > 0) {
            try {
                String sql = "SELECT username FROM T_USER WHERE email = ?";
                PreparedStatement statement = data.Database.getConnection().prepareStatement(sql);

                statement.setString(1, email);
                ResultSet set = statement.executeQuery();

                if (!set.next()) {
                    return true;
                }

                data.Database.close();

            } catch (SQLException e) {
               
            }
        }
        return false;
    }

    /**
     * Üye kaydı oluşturma
     *
     * @param username Kullanıcı Adı
     * @param password Şifre
     * @param email Mail
     */
    public static void createUser(String username, String firstname, String lastname, String password, String email) {
        if (username.length() > 0 && email.length() > 0 && password.length() > 0) {
            try {

                String sql = "INSERT INTO T_USER (userId, firstname, lastname, username, email, password,school, job) "
                        + "VALUES (?,?,?,?,?,?,?,?)";

                int id = getId() + 1;

                PreparedStatement statement = data.Database.getConnection().prepareStatement(sql);

                statement.setInt(1, id);
                statement.setString(2, firstname);
                statement.setString(3, lastname);
                statement.setString(4, username);
                statement.setString(5, email);
                statement.setString(6, password);
                statement.setString(7, "  ");
                statement.setString(8, "  ");

                
                statement.executeUpdate();

                sql = "insert into T_USER (id) values (?)";

                statement = data.Database.getConnection().prepareStatement(sql);
                statement.setInt(1, id);
                statement.executeUpdate();

               

                data.Database.close();

            } catch (SQLException e) {
                
            }
        }
    }

  

    /**
     * Kullanıcı adı database'de aratır.
     * @param email 
     * @return Eğer bulunursa true
     */
    public static boolean checkEmail(String email) {
        if (email != null && email.length() > 0) {
            try {
                String sql = "SELECT email FROM T_USER WHERE email = ?";

                PreparedStatement statement = data.Database.getConnection().prepareStatement(sql);
                statement.setString(1, email);

                ResultSet rs = statement.executeQuery();

                if (rs.next()) {
                    data.Database.close();
                    return true;
                }

                data.Database.close();

            } catch (SQLException e) {
                
            }
        }
        return false;
    }

    public static boolean checkPassword(String password) {
        if (password != null && password.length() > 0) {
            try {
                String sql = "SELECT password FROM T_USER WHERE password = ?";

                PreparedStatement statement = data.Database.getConnection().prepareStatement(sql);
                statement.setString(1, password);

                ResultSet rs = statement.executeQuery();

                if (rs.next()) {
                    data.Database.close();
                    return true;
                }

                data.Database.close();

            } catch (SQLException e) {
                
            }
        }
        return false;
    }

   
  
   
}


