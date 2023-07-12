/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.MatiereType;
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
public class MatiereTypeController {

    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public MatiereTypeController(Connection connection) {
        this.connection = connection;
    }

    public void add(String type, int priorite) {
        try {
            String req = "INSERT INTO matiere_types (type, priorite) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, type);
            preparedStatement.setInt(2, priorite);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MatiereTypeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Long id, String type, int priorite) {
        try {
            String req = "UPDATE matiere_types SET type = ?, priorite = ? WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, type);
            preparedStatement.setInt(2, priorite);
            preparedStatement.setLong(3, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MatiereTypeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void remove(Long id) {
        try {
            String req = "DELETE FROM matiere_types WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MatiereTypeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public MatiereType get(Long id) {
        try {
            String req = "SELECT * FROM matiere_types WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new MatiereType(resultSet.getLong("id"), resultSet.getString("type"), resultSet.getInt("priorite"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MatiereTypeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public MatiereType get(String type) {
        try {
            String req = "SELECT * FROM matiere_types WHERE type = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, type);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new MatiereType(resultSet.getLong("id"), resultSet.getString("type"), resultSet.getInt("priorite"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MatiereTypeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<MatiereType> gets() {
        try {
            ArrayList<MatiereType> list = new ArrayList<>();
            String req = "SELECT * FROM matiere_types ORDER BY priorite ASC ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                list.add(new MatiereType(resultSet.getLong("id"), resultSet.getString("type"), resultSet.getInt("priorite")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(MatiereTypeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<MatiereType> gets(Long id_classe, Long id_professeur) {
        try {
            ArrayList<MatiereType> list = new ArrayList<>();
            String req = "SELECT DISTINCT "
                    + "matiere_types.id, "
                    + "matiere_types.type, "
                    + "matiere_types.priorite "
                    + "FROM matiere_types "
                    + "JOIN matieres ON "
                    + "matiere_types.id = matieres.id_matiere_type "
                    + "JOIN matiere_classes ON "
                    + "matieres.id = matiere_classes.id_matiere "
                    + "JOIN professeur_matiere_classes ON "
                    + "matiere_classes.id = professeur_matiere_classes.id_matiere_classe "
                    + "WHERE matiere_classes.id_classe = ? AND professeur_matiere_classes.id_professeur = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_classe);
            preparedStatement.setLong(2, id_professeur);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                list.add(new MatiereType(resultSet.getLong("id"), resultSet.getString("type"), resultSet.getInt("priorite")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(MatiereTypeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
