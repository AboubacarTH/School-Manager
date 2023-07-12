package controller;

import bean.Adresse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdresseController {

    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public AdresseController(Connection connection) {
        this.connection = connection;
    }

    public void createTable() {
        try {
            String req = """
                         CREATE TABLE IF NOT EXISTS adresses (\r
                                         id INT NOT NULL,\r
                                         adresse VARCHAR(255) NOT NULL,\r
                                         \r
                                         port VARCHAR(255) NOT NULL,\r
                                                         db VARCHAR(255) NOT NULL,\r
                         primaire BOOLEAN DEFAULT 0,\r
                                                         PRIMARY KEY (id)\r
                                         );
                         """;
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
        } catch (SQLException e) {
        }
    }

    public void add(int id, String adresse, String port, String db, boolean primaire) {
        String req = "INSERT INTO adresses(id, adresse, port, db, primaire) VALUES (?, ?, ?, ?, ?) ";
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, adresse);
            preparedStatement.setString(3, port);
            preparedStatement.setString(4, db);
            preparedStatement.setBoolean(5, primaire);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void update(int id, String adresse, String port, String db, boolean primaire) {
        String req = "UPDATE adresses SET adresse = ?, port = ?, db = ?, primaire = ? WHERE id = ? ";
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, adresse);
            preparedStatement.setString(2, port);
            preparedStatement.setString(3, db);
            preparedStatement.setBoolean(4, primaire);
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void remove(int id) {
        String req = "DELETE FROM adresses WHERE id = ? ";
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public Adresse get(int id) {
        String req = "SELECT * FROM adresses WHERE id = ? ";
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new Adresse(resultSet.getInt("id"), resultSet.getString("adresse"), resultSet.getString("port"), resultSet.getString("db"), resultSet.getBoolean("primaire"));
            }
        } catch (SQLException e) {
            return null;
        }
        return null;
    }

    public ArrayList<Adresse> gets() {
        String req = "SELECT * FROM adresses ";
        try {
            ArrayList<Adresse> list = new ArrayList<>();
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                list.add(new Adresse(resultSet.getInt("id"), resultSet.getString("adresse"), resultSet.getString("port"), resultSet.getString("db"), resultSet.getBoolean("primaire")));
            }
            return list;
        } catch (SQLException e) {
            return null;
        }
    }
}
