package br.ulbra.Data;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Gabriel on 19/10/2016.
 */
public class DBUtils {

    public static void createDDL() {
        try {
            DBConnection db = new DBConnection();
            Logger.getLogger(DBUtils.class.getName()).log(Level.INFO, "Criando Tabelas", "");
            String[] batch = {USERS_DDL};
            db.rawBatch(batch);
        }
        catch(Exception ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static final String USERS_DDL = "" +
            "CREATE TABLE IF NOT EXISTS users(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "fullname TEXT, " +
            "username TEXT, " +
            "password TEXT)";
}
