/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Cycle;
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
public class CycleController {

    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public CycleController(Connection connection) {
        this.connection = connection;
    }

    /**
     *
     * @param cycle
     */
    public void add(String cycle) {
        try {
            String req = "INSERT INTO cycles (cycle) VALUES (?)";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, cycle);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CycleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Long id, String cycle) {
        try {
            String req = "UPDATE cycles SET cycle = ? WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, cycle);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CycleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param id
     */
    public void remove(Long id) {
        try {
            String req = "DELETE FROM cycles WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CycleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param id
     * @return
     */
    public Cycle get(Long id) {
        try {
            String req = "SELECT * FROM cycles WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new Cycle(resultSet.getLong("id"), resultSet.getString("cycle"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CycleController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Cycle get(String cycle) {
        try {
            String req = "SELECT * FROM cycles WHERE cycle = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, cycle);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new Cycle(resultSet.getLong("id"), resultSet.getString("cycle"));
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
    public ArrayList<Cycle> gets() {
        try {
            ArrayList<Cycle> list = new ArrayList<>();
            String req = "SELECT * FROM cycles ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                list.add(new Cycle(resultSet.getLong("id"), resultSet.getString("cycle")));
            }
            return list;
        } catch (SQLException ex) {
            return null;
        }
    }

    public ArrayList<Cycle> gets(Long id_annee, Long id_professeur) {
        try {
            ArrayList<Cycle> list = new ArrayList<>();
            String req = "SELECT DISTINCT cycles.id, cycles.cycle FROM cycles "
                    + "JOIN classes ON "
                    + "cycles.id = classes.id_cycle "
                    + "JOIN matiere_classes ON "
                    + "classes.id = matiere_classes.id_classe "
                    + "JOIN professeur_matiere_classes ON "
                    + "matiere_classes.id = professeur_matiere_classes.id_matiere_classe "
                    + "WHERE classes.id_annee = ? AND professeur_matiere_classes.id_professeur = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_annee);
            preparedStatement.setLong(2, id_professeur);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                list.add(new Cycle(resultSet.getLong("id"), resultSet.getString("cycle")));
            }
            return list;
        } catch (SQLException ex) {
            return null;
        }
    }
}
