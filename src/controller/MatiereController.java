/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Matiere;
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
public class MatiereController {

    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public MatiereController(Connection connection) {
        this.connection = connection;
    }

    public void add(String matiere, Long id_matiere_type, int priorite) {
        try {
            String req = "INSERT INTO matieres (matiere, id_matiere_type, priorite) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, matiere);
            preparedStatement.setLong(2, id_matiere_type);
            preparedStatement.setInt(3, priorite);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MatiereController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Long id, String matiere, Long id_matiere_type, int priorite) {
        try {
            String req = "UPDATE matieres SET matiere = ?, id_matiere_type = ?, priorite = ? WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, matiere);
            preparedStatement.setLong(2, id_matiere_type);
            preparedStatement.setInt(3, priorite);
            preparedStatement.setLong(4, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MatiereController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void remove(Long id) {
        try {
            String req = "DELETE FROM matieres WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MatiereController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Matiere get(Long id) {
        try {
            String req = "SELECT * FROM matieres WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new Matiere(resultSet.getLong("id"), resultSet.getString("matiere"), resultSet.getLong("id_matiere_type"), resultSet.getInt("priorite"));
            }
        } catch (SQLException ex) {
            return null;
        }
        return null;
    }

    public Matiere get(String matiere) {
        try {
            String req = "SELECT * FROM matieres WHERE matiere = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, matiere);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new Matiere(resultSet.getLong("id"), resultSet.getString("matiere"), resultSet.getLong("id_matiere_type"), resultSet.getInt("priorite"));
            }
        } catch (SQLException ex) {
            return null;
        }
        return null;
    }

    public ArrayList<Matiere> gets(Long id_matiere_type) {
        try {
            ArrayList<Matiere> list = new ArrayList<>();
            String req = "SELECT * FROM matieres WHERE id > '0' ";
            if (id_matiere_type != null) {
                req += "AND id_matiere_type = '" + id_matiere_type + "' ";
            }
            req += "ORDER BY priorite ASC ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                list.add(new Matiere(resultSet.getLong("id"), resultSet.getString("matiere"), resultSet.getLong("id_matiere_type"), resultSet.getInt("priorite")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(MatiereController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
