/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.ProfesseurMatiereClasse;
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
public class ProfesseurMatiereClasseController {

    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public ProfesseurMatiereClasseController(Connection connection) {
        this.connection = connection;

    }

    public void add(Long id_matiere_classe, Long id_professeur) {

        try {
            String req = "INSERT INTO professeur_matiere_classes (id_matiere_classe, id_professeur) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_matiere_classe);
            preparedStatement.setLong(2, id_professeur);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfesseurMatiereClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Long id, Long id_matiere_classe, Long id_professeur) {

        try {
            String req = "UPDATE professeur_matiere_classes SET id_matiere_classe = ?, id_professeur = ? WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_matiere_classe);
            preparedStatement.setLong(2, id_professeur);
            preparedStatement.setLong(3, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfesseurMatiereClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void remove(Long id) {

        try {
            String req = "DELETE FROM professeur_matiere_classes WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfesseurMatiereClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ProfesseurMatiereClasse get(Long id) {

        try {
            String req = "SELECT * FROM professeur_matiere_classes WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new ProfesseurMatiereClasse(resultSet.getLong("id"), resultSet.getLong("id_matiere_classe"), resultSet.getLong("id_professeur"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfesseurMatiereClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ProfesseurMatiereClasse get(Long id_matiere_classe, Long id_professeur) {

        try {
            String req = "SELECT * FROM professeur_matiere_classes WHERE id_matiere_classe = ? AND id_professeur = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_matiere_classe);
            preparedStatement.setLong(2, id_professeur);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new ProfesseurMatiereClasse(resultSet.getLong("id"), resultSet.getLong("id_matiere_classe"), resultSet.getLong("id_professeur"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfesseurMatiereClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ProfesseurMatiereClasse get(Long id_matiere, Long id_matiere_type, Long id_classe, Long id_cycle, Long id_professeur) {

        try {
            String req = "SELECT professeur_matiere_classes.id, professeur_matiere_classes.id_matiere_classe, professeur_matiere_classes.id_professeur FROM professeur_matiere_classes "
                    + "JOIN matiere_classes ON  professeur_matiere_classes.id_matiere_classe = matiere_classes.id "
                    + "JOIN matieres ON matiere_classes.id_matiere = matieres.id "
                    + "JOIN classes ON matiere_classes.id_classe = classes.id "
                    + "WHERE professeur_matiere_classes.id > '0' ";
            if (id_matiere != null) {
                req += "AND matieres.id ='" + id_matiere + "' ";
            }
            if (id_matiere_type != null) {
                req += "AND matieres.id_matiere_type ='" + id_matiere_type + "' ";
            }
            if (id_classe != null) {
                req += "AND classes.id ='" + id_classe + "' ";
            }
            if (id_cycle != null) {
                req += "AND classes.id_cycle ='" + id_cycle + "' ";
            }
            if (id_professeur != null) {
                req += "AND professeur_matiere_classes.id_professeur ='" + id_professeur + "' ";
            }
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new ProfesseurMatiereClasse(resultSet.getLong("id"), resultSet.getLong("id_matiere_classe"), resultSet.getLong("id_professeur"));
            }
        } catch (SQLException ex) {
            return null;
        }
        return null;
    }

    public ArrayList<ProfesseurMatiereClasse> gets(Long id_matiere, Long id_matiere_type, Long id_classe, Long id_cycle, Long id_professeur) {

        try {
            ArrayList<ProfesseurMatiereClasse> list = new ArrayList<>();
            String req = "SELECT professeur_matiere_classes.id, professeur_matiere_classes.id_matiere_classe, professeur_matiere_classes.id_professeur FROM professeur_matiere_classes "
                    + "JOIN matiere_classes ON  professeur_matiere_classes.id_matiere_classe = matiere_classes.id "
                    + "JOIN matieres ON matiere_classes.id_matiere = matieres.id "
                    + "JOIN classes ON matiere_classes.id_classe = classes.id "
                    + "WHERE professeur_matiere_classes.id > '0' ";
            if (id_matiere != null) {
                req += "AND matieres.id ='" + id_matiere + "' ";
            }
            if (id_matiere_type != null) {
                req += "AND matieres.id_matiere_type ='" + id_matiere_type + "' ";
            }
            if (id_classe != null) {
                req += "AND classes.id ='" + id_classe + "' ";
            }
            if (id_cycle != null) {
                req += "AND classes.id_cycle ='" + id_cycle + "' ";
            }
            if (id_professeur != null) {
                req += "AND professeur_matiere_classes.id_professeur ='" + id_professeur + "' ";
            }
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                list.add(new ProfesseurMatiereClasse(resultSet.getLong("id"), resultSet.getLong("id_matiere_classe"), resultSet.getLong("id_professeur")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ProfesseurMatiereClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
