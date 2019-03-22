package model.persist;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import model.User;

/**
 * Clase conector a bbdd Users
 *
 * @author obp
 */
public class UserDAO {

    private static DBConnect dataSource;
    private final Properties queries;
    private static String PROPS_FILE;

    public UserDAO(String ruta) throws IOException {
        queries = new Properties();
        PROPS_FILE = ruta + "/resources/user_queries.properties";
        queries.load(new FileInputStream(PROPS_FILE));

        dataSource = DBConnect.getInstance();
    }

    public String getQuery(String queryName) {
        return queries.getProperty(queryName);
    }

    /**
     * Select all users of BBDD
     *
     * @return
     */
    public ArrayList<User> findAll() {
        ArrayList<User> list = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
                Statement st = conn.createStatement();) {
            ResultSet res = st.executeQuery(getQuery("FIND_ALL"));

            while (res.next()) {
                User user = new User();
                user.setUsername(res.getString("name"));
                user.setPassword(res.getString("password"));
                user.setRole(res.getString("role"));
                list.add(user);
            }

        } catch (SQLException e) {
            list = new ArrayList<>();
        }

        return list;
    }

    /**
     * insert user a bbdd
     * @param u object user to add
     * @return result 1=ok 0 = fail
     */
    public int addUser(User u) {
        int rowsAffected;

        try (Connection conn = dataSource.getConnection();
                PreparedStatement pst = conn.prepareStatement(getQuery("INSERT"));) {
            pst.setString(1, u.getUsername());
            pst.setString(2, u.getPassword());
            pst.setString(3, u.getRole());
            rowsAffected = pst.executeUpdate();
        } catch (SQLException e) {
            rowsAffected = 0;
        }

        return rowsAffected;
    }
    /**
     * Select find by username and password

     * @param user object user to find
     * @return  object user finded
     */
    public User findOne(User user) {
        User userFind = null;

        try (Connection conn = dataSource.getConnection();
                PreparedStatement st = conn.prepareStatement(getQuery("FIND_ONE"));) {
            st.setString(1, user.getUsername());
            st.setString(2, user.getPassword());

            ResultSet res = st.executeQuery();
            while (res.next()) {
                userFind = new User();
                userFind.setUsername(res.getString("name"));
                userFind.setPassword(res.getString("password"));
                userFind.setRole(res.getString("role"));
            }

        } catch (SQLException e) {
        }

        return userFind;
    }

    /**
     * delete user from bbdd
     * @param username to delete
     * @return int result 0=fail 1=ok
     */
    public int deleteUser(String username) {
        int rowsAffected;

        try (Connection conn = dataSource.getConnection();
                PreparedStatement pst = conn.prepareStatement(getQuery("DELETE"));) {
            pst.setString(1, username);
            rowsAffected = pst.executeUpdate();
        } catch (SQLException e) {
            rowsAffected = -2;
        }

        return rowsAffected;
    }
}
