/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Nationalite;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ATH
 */
public class NationaliteController {

    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public NationaliteController(Connection connection) {
        this.connection = connection;
    }

    public void add(String nationalite) {
        try {
            String req = "INSERT INTO nationalites (nationalite) VALUES (?) ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, nationalite);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NationaliteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Long id, String nationalite) {
        try {
            String req = "UPDATE nationalites SET nationalite = ? WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, nationalite);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NationaliteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Nationalite get(String nationalite) {
        try {
            String req = "SELECT * FROM nationalites WHERE nationalite = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, nationalite);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new Nationalite(resultSet.getLong("id"), resultSet.getString("nationalite"));
            }
        } catch (SQLException ex) {
            return null;
        }
        return null;
    }

    public Nationalite get(Long id) {
        try {
            String req = "SELECT * FROM nationalites WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new Nationalite(resultSet.getLong("id"), resultSet.getString("nationalite"));
            }
        } catch (SQLException ex) {
            return null;
        }
        return null;
    }

    public ArrayList<Nationalite> gets() {
        ArrayList<Nationalite> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM nationalites ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                list.add(new Nationalite(resultSet.getLong("id"), resultSet.getString("nationalite")));
            }
            return list;
        } catch (SQLException ex) {
            return null;
        }
    }

    public void remove(Long id) {
        try {
            String req = "DELETE FROM nationalites WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NationaliteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
