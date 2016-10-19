package br.ulbra.Dao;

import br.ulbra.Data.DBConnection;
import br.ulbra.Domain.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Gabriel on 19/10/2016.
 */
public class UserDao implements Dao<User> {

    private DBConnection dbConnection;

    public UserDao() throws SQLException {
        if (dbConnection == null) dbConnection = new DBConnection();
    }

    public List<User> getAll() {
        List<User> list = new ArrayList<>();
        try {
            PreparedStatement ps = dbConnection.prepareStatement("SELECT * FROM users");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new User(
                        rs.getInt("id"),
                        rs.getString("fullname"),
                        rs.getString("username"),
                        rs.getString("password")
                ));
            }
            ps.close();
        }
        catch(SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void add(User u) {
        try {
            String query = "INSERT INTO users(fullname, username, password) VALUES (?, ?, ?)";
            PreparedStatement ps = dbConnection.prepareStatement(query);
            ps.setString(1, u.getFullname());
            ps.setString(2, u.getUsername());
            ps.setString(3, u.getPassword());
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(int id) {
        try {
            String query = "DELETE FROM users WHERE id = ?";
            PreparedStatement ps = dbConnection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
