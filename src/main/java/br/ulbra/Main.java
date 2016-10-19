package br.ulbra;

import br.ulbra.Data.Database;
import br.ulbra.Domain.User;
import br.ulbra.Dao.UserDao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Gabriel on 19/10/2016.
 */
public class Main {

    public static void main(String[] args) throws SQLException {
        Database db = new Database();
        //DBConnection db = new DBConnection();
        UserDao userDao = new UserDao();

        userDao.add(new User("Gabriel", "gabriel", "123333"));
        //userDao.delete(1);

        List<User> users = userDao.getAll();

        users.stream().forEach(u -> {
            System.out.println(u.toString());
        });
    }
}
