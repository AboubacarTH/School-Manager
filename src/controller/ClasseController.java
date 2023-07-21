/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Classe;
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
public class ClasseController {

    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public ClasseController(Connection connection) {
        this.connection = connection;
    }

    /**
     *
     * @param id_annee
     * @param id_cycle
     * @param classe
     */
    public void add(Long id_annee, Long id_cycle, String classe) {
        try {
            String req = "INSERT INTO classes (id_annee, id_cycle, classe) VALUES (?,?,?)";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_annee);
            preparedStatement.setLong(2, id_cycle);
            preparedStatement.setString(3, classe);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param id
     * @param id_annee
     * @param id_cycle
     * @param classe
     */
    public void update(Long id, Long id_annee, Long id_cycle, String classe) {
        try {
            String req = "UPDATE classes SET id_annee = ?, id_cycle = ?, classe = ? WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_annee);
            preparedStatement.setLong(2, id_cycle);
            preparedStatement.setString(3, classe);
            preparedStatement.setLong(4, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void remove(Long id) {
        try {
            String req = "DELETE FROM classes WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Classe get(Long id) {
        try {
            String req = "SELECT * FROM classes WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new Classe(resultSet.getLong("id"), resultSet.getLong("id_annee"), resultSet.getLong("id_cycle"), resultSet.getString("classe"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Classe get(Long id_annee, Long id_cycle, String classe) {
        try {
            String req = "SELECT * FROM classes WHERE id_annee = ? AND  id_cycle = ? AND classe = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_annee);
            preparedStatement.setLong(2, id_cycle);
            preparedStatement.setString(3, classe);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new Classe(resultSet.getLong("id"), resultSet.getLong("id_annee"), resultSet.getLong("id_cycle"), resultSet.getString("classe"));
            }
        } catch (SQLException ex) {
            return null;
        }
        return null;
    }

    public ArrayList<Classe> gets(Long id_annee, Long id_cycle) {
        try {
            ArrayList<Classe> list = new ArrayList<>();
            String req = "SELECT * FROM classes WHERE id > '0' ";
            if (id_annee != null) {
                req += "AND id_annee = '" + id_annee + "' ";
            }
            if (id_cycle != null) {
                req += "AND id_cycle = '" + id_cycle + "' ";
            }
            req += "ORDER BY id ASC";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                list.add(new Classe(resultSet.getLong("id"), resultSet.getLong("id_annee"), resultSet.getLong("id_cycle"), resultSet.getString("classe")));
            }
            return list;
        } catch (SQLException ex) {
            return null;
        }
    }

    public ArrayList<Classe> gets(Long id_annee, Long id_cycle, Long id_professeur) {
        try {
            ArrayList<Classe> list = new ArrayList<>();
            String req = "SELECT DISTINCT "
                    + "classes.id, "
                    + "classes.id_annee, "
                    + "classes.id_cycle, "
                    + "classes.classe  "
                    + "FROM classes "
                    + "INNER JOIN matiere_classes ON "
                    + "classes.id = matiere_classes.id_classe "
                    + "INNER JOIN professeur_matiere_classes ON "
                    + "matiere_classes.id = professeur_matiere_classes.id_matiere_classe "
                    + "WHERE classes.id_annee = ? AND classes.id_cycle = ? AND professeur_matiere_classes.id_professeur = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_annee);
            preparedStatement.setLong(2, id_cycle);
            preparedStatement.setLong(3, id_professeur);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                list.add(new Classe(resultSet.getLong("id"), resultSet.getLong("id_annee"), resultSet.getLong("id_cycle"), resultSet.getString("classe")));
            }
            return list;
        } catch (SQLException ex) {
            return null;
        }
    }
}
