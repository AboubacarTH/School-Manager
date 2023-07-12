/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Semestre;
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
public class SemestreController {

    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public SemestreController(Connection connection) {
        this.connection = connection;
    }

    public void add(String semestre, String description) {
        try {
            String req = "INSERT INTO semestres (semestre, description) VALUES (?, ?) ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, semestre);
            preparedStatement.setString(2, description);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SemestreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Semestre get(String semestre) {
        try {
            String req = "SELECT * FROM semestres WHERE semestre = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, semestre);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new Semestre(resultSet.getLong("id"), resultSet.getString("semestre"), resultSet.getString("description"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SemestreController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Semestre get(Long id) {
        try {
            String req = "SELECT * FROM semestres WHERE id = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new Semestre(resultSet.getLong("id"), resultSet.getString("semestre"), resultSet.getString("description"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SemestreController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Semestre> gets() {
        ArrayList<Semestre> listSemestre = new ArrayList<>();
        try {
            String req = "SELECT * FROM semestres ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                listSemestre.add(new Semestre(resultSet.getLong("id"), resultSet.getString("semestre"), resultSet.getString("description")));
            }
            return listSemestre;
        } catch (SQLException ex) {
            Logger.getLogger(SemestreController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void update(Long id, String semestre, String description) {
        try {
            String req = "UPDATE semestres SET semestre = ?, description = ? WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, semestre);
            preparedStatement.setString(2, description);
            preparedStatement.setLong(3, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SemestreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void remove(Long id) {
        try {
            String req = "DELETE FROM semestres WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SemestreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
