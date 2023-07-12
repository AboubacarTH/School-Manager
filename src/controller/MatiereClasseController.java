/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.MatiereClasse;
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
public class MatiereClasseController {

    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public MatiereClasseController(Connection connection) {
        this.connection = connection;
    }

    public void add(Long id_matiere, Long id_classe, int volume_horaire, int coefficient) {
        try {
            String req = "INSERT INTO matiere_classes (id_matiere, id_classe, volume_horaire, coefficient) VALUES (?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_matiere);
            preparedStatement.setLong(2, id_classe);
            preparedStatement.setInt(3, volume_horaire);
            preparedStatement.setInt(4, coefficient);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MatiereClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Long id, Long id_matiere, Long id_classe, int volume_horaire, int coefficient) {
        try {
            String req = "UPDATE matiere_classes SET id_matiere = ?, id_classe = ?, volume_horaire = ?, coefficient = ? WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_matiere);
            preparedStatement.setLong(2, id_classe);
            preparedStatement.setInt(3, volume_horaire);
            preparedStatement.setInt(4, coefficient);
            preparedStatement.setLong(5, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MatiereClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void remove(Long id) {
        try {
            String req = "DELETE FROM matiere_classes WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MatiereClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public MatiereClasse get(Long id) {
        try {
            String req = "SELECT * FROM matiere_classes WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new MatiereClasse(resultSet.getLong("id"), resultSet.getLong("id_matiere"), resultSet.getLong("id_classe"), resultSet.getInt("volume_horaire"), resultSet.getInt("coefficient"));
            }
        } catch (SQLException ex) {
            return null;
        }
        return null;
    }

    /**
     * Permet de recuperer la matiere d'une classe
     *
     * @param id_matiere
     * @param id_classe
     * @param id_cycle
     * @param id_professeur
     * @return
     */
    public MatiereClasse get(Long id_matiere, Long id_classe, Long id_cycle, Long id_professeur) {
        try {
            String req = "SELECT "
                    + "matiere_classes.id, "
                    + "matiere_classes.id_matiere, "
                    + "matiere_classes.id_classe, "
                    + "matiere_classes.volume_horaire, "
                    + "matiere_classes.coefficient "
                    + "FROM matiere_classes "
                    + "JOIN classes ON "
                    + "matiere_classes.id_classe = classes.id "
                    + "JOIN professeur_matiere_classes "
                    + "ON matiere_classes.id = professeur_matiere_classes.id_matiere_classe "
                    + "WHERE matiere_classes.id > '0' ";
            if (id_matiere != null) {
                req += "AND matiere_classes.id_matiere ='" + id_matiere + "' ";
            }
            if (id_classe != null) {
                req += "AND matiere_classes.id_classe ='" + id_classe + "' ";
            }
            if (id_cycle != null) {
                req += "AND classe.id_cycle ='" + id_cycle + "' ";
            }
            if (id_professeur != null) {
                req += "AND professeur_matiere_classes.id_professeur ='" + id_professeur + "' ";
            }
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new MatiereClasse(resultSet.getLong("id"), resultSet.getLong("id_matiere"), resultSet.getLong("id_classe"), resultSet.getInt("volume_horaire"), resultSet.getInt("coefficient"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MatiereClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public MatiereClasse get(Long id_matiere, Long id_classe) {
        try {
            String req = "SELECT * FROM matiere_classes WHERE id_matiere = ? AND id_classe = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_matiere);
            preparedStatement.setLong(2, id_classe);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new MatiereClasse(resultSet.getLong("id"), resultSet.getLong("id_matiere"), resultSet.getLong("id_classe"), resultSet.getInt("volume_horaire"), resultSet.getInt("coefficient"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MatiereClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<MatiereClasse> gets(Long id_matiere, Long id_matiere_type, Long id_classe, Long id_cycle) {
        try {
            ArrayList<MatiereClasse> list = new ArrayList<>();
            String req = "SELECT "
                    + "matiere_classes.id, "
                    + "matiere_classes.id_matiere, "
                    + "matiere_classes.id_classe, "
                    + "matiere_classes.volume_horaire, "
                    + "matiere_classes.coefficient "
                    + "FROM matiere_classes "
                    + "JOIN matieres ON "
                    + "matiere_classes.id_matiere = matieres.id "
                    + "JOIN classes ON "
                    + "matiere_classes.id_classe = classes.id "
                    + "WHERE matiere_classes.id > '0' ";
            if (id_matiere != null) {
                req += "AND matiere_classes.id_matiere = '" + id_matiere + "' ";
            }
            if (id_matiere_type != null) {
                req += "AND matieres.id_matiere_type = '" + id_matiere_type + "' ";
            }
            if (id_classe != null) {
                req += "AND matiere_classes.id_classe = '" + id_classe + "' ";
            }
            if (id_cycle != null) {
                req += "AND classes.id_cycle = '" + id_cycle + "' ";
            }
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                list.add(new MatiereClasse(resultSet.getLong("id"), resultSet.getLong("id_matiere"), resultSet.getLong("id_classe"), resultSet.getInt("volume_horaire"), resultSet.getInt("coefficient")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(MatiereClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<MatiereClasse> gets(Long id_matiere, Long id_matiere_type, Long id_classe, Long id_cycle, Long id_professeur) {
        try {
            ArrayList<MatiereClasse> list = new ArrayList<>();
            String req = "SELECT "
                    + "matiere_classes.id, "
                    + "matiere_classes.id_matiere, "
                    + "matiere_classes.id_classe, "
                    + "matiere_classes.volume_horaire, "
                    + "matiere_classes.coefficient "
                    + "FROM matiere_classes "
                    + "JOIN matieres ON "
                    + "matiere_classes.id_matiere = matieres.id "
                    + "JOIN classes ON "
                    + "matiere_classes.id_classe = classes.id "
                    + "JOIN professeur_matiere_classes "
                    + "ON matiere_classes.id = professeur_matiere_classes.id_matiere_classe "
                    + " WHERE matiere_classes.id > '0' ";
            if (id_matiere != null) {
                req += "AND matiere_classes.id_matiere = '" + id_matiere + "' ";
            }
            if (id_matiere_type != null) {
                req += "AND matieres.id_matiere_type = '" + id_matiere_type + "' ";
            }
            if (id_classe != null) {
                req += "AND matiere_classes.id_classe = '" + id_classe + "' ";
            }
            if (id_cycle != null) {
                req += "AND classes.id_cycle = '" + id_cycle + "' ";
            }
            if (id_professeur != null) {
                req += "AND professeur_matiere_classes.id_professeur ='" + id_professeur + "' ";
            }
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                list.add(new MatiereClasse(resultSet.getLong("id"), resultSet.getLong("id_matiere"), resultSet.getLong("id_classe"), resultSet.getInt("volume_horaire"), resultSet.getInt("coefficient")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(MatiereClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
