package database;

import bean.Adresse;
import controller.AdresseController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static main.Main.setPrimaire;
import view.dialog.AdresseDialog;

public class ConnectorDB {

    private Connection connection;
    private String url;
    private String user;
    private String password;
    private final AdresseController adresseController;

    public ConnectorDB(Connection connection) {
        adresseController = new AdresseController(connection);
        try {
            String ip = "localhost";
            String port = "3306";
            String db = "ges";
            Adresse adresse = adresseController.get(1);
            if (adresse != null) {
                ip = adresse.getAdresse();
                port = adresse.getPort();
                db = adresse.getDb();
                setPrimaire(adresse.isPrimaire());
            }
            url = "jdbc:mysql://" + ip + ":" + port + "/" + db;
            user = "root";
            password = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection to SQL local has been established.");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Connection to SQL local has not been established.");
            AdresseDialog adresseDialog = new AdresseDialog(null, true);
            adresseDialog.setVisible(true);
            System.exit(0);
        }
    }

    /**
     * @return the connection
     */
    public Connection getConnection() {
        return connection;
    }

}
