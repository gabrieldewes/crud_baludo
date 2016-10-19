package br.ulbra.Data;


import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Gabriel on 19/10/2016.
 */
public class Database {

    private static final java.io.File DATABASE = new java.io.File(
            System.getProperty("user.home") +
            System.getProperty("file.separator") + "Desktop" +
            System.getProperty("file.separator") + ".baludo" +
            System.getProperty("file.separator") + "baludo.db");

    public Database() {
        try { checkDatabase(); }
        catch(Exception ex) { Logger.getLogger(Database.class.getName()).log(Level.SEVERE, ex.getLocalizedMessage()); }
    }

    private static void checkDatabase() throws Exception {
        if (!DATABASE.exists()) {
            createNewDatabase();
        }
    }

    private static void createNewDatabase() throws Exception {
        try {
            Logger.getLogger(Database.class.getName()).log(Level.INFO, "Criando diretórios e arquivo de banco de dados {0}", DATABASE.getAbsolutePath());
            DATABASE.getParentFile().mkdirs();
            DATABASE.createNewFile();
            if (!DATABASE.exists()) {
                throw new Exception("Não foi possível ter acesso ao sistema de arquivos.");
            }
            else {
                br.ulbra.Data.DBUtils.createDDL();
            }
        }
        catch (Exception ex) {
            throw new Exception("Não foi possível criar arquivo de banco de dados.\n"+ ex.getLocalizedMessage());
        }
    }

    public String getPath() {
        return DATABASE.getAbsolutePath();
    }
}
