/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Annee;
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
public class AnneeController {

    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public AnneeController(Connection connection) {
        this.connection = connection;
    }

    /**
     *
     * @param annee
     */
    public void add(String annee) {
        try {
            String req = "INSERT INTO annees (annee) VALUES (?) ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, annee);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AnneeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param id
     * @param annee
     */
    public void update(Long id, String annee) {
        try {
            String req = "UPDATE annees SET annee = ? WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, annee);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AnneeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param id
     */
    public void remove(Long id) {
        try {
            String req = "DELETE FROM annees WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AnneeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Annee get(Long id) {
        try {
            String req = "SELECT * FROM annees WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new Annee(resultSet.getLong("id"), resultSet.getString("annee"));
            }
        } catch (SQLException ex) {
            return null;
        }
        return null;
    }

    /**
     *
     * @param annee
     * @return
     */
    public Annee get(String annee) {
        try {
            String req = "SELECT * FROM annees WHERE annee = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, annee);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new Annee(resultSet.getLong("id"), resultSet.getString("annee"));
            }
        } catch (SQLException ex) {
            return null;
        }
        return null;
    }

    /**
     *
     * @return
     */
    public ArrayList<Annee> gets() {
        ArrayList<Annee> listAnnee = new ArrayList<>();
        try {
            String req = "SELECT * FROM annees ORDER BY id DESC ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                listAnnee.add(new Annee(resultSet.getLong("id"), resultSet.getString("annee")));
            }
            return listAnnee;
        } catch (SQLException ex) {
            return null;
        }
    }
}
