package database;

import bean.Adresse;
import controller.AdresseController;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ConnectorLite connectorLite = new ConnectorLite();
        ArrayList<Adresse> adresse = new AdresseController(connectorLite.getConnection()).gets();
        for (Adresse adresse1 : adresse) {
            System.out.println("id " + adresse1.getId() + " Serveur local : ip " + adresse1.getAdresse() + " port " + adresse1.getPort() + " db " + adresse1.getDb());
        }
//        createTable();
    }

//    private static void createTable() {
//        ConnectorLite connectorLite = new ConnectorLite();
//        String req = "CREATE TABLE adresses (\r\n" + "                "
//                + "id INT NOT NULL,\r\n"
//                + "                adresse_distant VARCHAR(255) NOT NULL,\r\n" + "                \r\n"
//                + "                port_distant VARCHAR(255) NOT NULL,\r\n" + "                "
//                + "                db_distant VARCHAR(255) NOT NULL,\r\n" + "                "
//                + "                adresse_local VARCHAR(255) NOT NULL,\r\n" + "                \r\n"
//                + "                port_local VARCHAR(255) NOT NULL,\r\n" + "                "
//                + "                db_local VARCHAR(255) NOT NULL,\r\n" + "                "
//                + "                PRIMARY KEY (id)\r\n"
//                + "                );";
//        PreparedStatement preparedStatement;
//        try {
//            preparedStatement = connectorLite.getConnection().prepareStatement(req);
//            preparedStatement.execute();
//        } catch (SQLException e) {
//        }
//    }
}
