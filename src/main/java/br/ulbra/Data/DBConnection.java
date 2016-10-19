package br.ulbra.Data;

import org.sqlite.SQLiteConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Gabriel on 19/10/2016.
 */
public class DBConnection extends SQLiteConnection {

    private static final String URL = "jdbc:sqlite:";
    private static final Database DATABASE = new Database();

    public DBConnection() throws SQLException {
        super(URL, DATABASE.getPath());
    }

    public void rawSQL(String query) {
        try {
            PreparedStatement ps = this.prepareStatement(query);
            ps.executeUpdate();
            Logger.getLogger(DBConnection.class.getName()).log(Level.INFO, "Raw line {0}", query);
            ps.close();
            this.close();
        }
        catch(SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void rawBatch(String[] query) {
        try {
            Statement stmt = this.createStatement();
            for (String q:query) {
                stmt.addBatch(q);
            }
            int[] i = stmt.executeBatch();
            Logger.getLogger(DBConnection.class.getName()).log(Level.INFO, "Raw lines {0}", query);
            stmt.close();
            this.close();
        }
        catch(SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
