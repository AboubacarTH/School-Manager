/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Retard;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ATH
 */
public class RetardController {

    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public RetardController(Connection connection) {
        this.connection = connection;
    }

    public void add(Long id_eleve_classe, Timestamp date, String commentaire) {
        try {
            String req = "INSERT INTO retards (id_eleve_classe, date, commentaire) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_eleve_classe);
            preparedStatement.setTimestamp(2, date);
            preparedStatement.setString(3, commentaire);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RetardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Long id, Long id_eleve_classe, Timestamp date, String commentaire) {
        try {
            String req = "UPDATE retards SET id_eleve_classe = ?, date = ?, commentaire = ? WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_eleve_classe);
            preparedStatement.setTimestamp(2, date);
            preparedStatement.setString(3, commentaire);
            preparedStatement.setLong(4, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RetardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void remove(Long id) {
        try {
            String req = "DELETE FROM retards WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RetardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Retard get(Long id) {
        try {
            String req = "SELECT * FROM retards WHERE id = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new Retard(resultSet.getLong("id"), resultSet.getLong("id_eleve_classe"), resultSet.getTimestamp("date"), resultSet.getString("commentaire"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RetardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Retard> gets(Long id_eleve, Long id_annee, Long id_classe, Timestamp date, String rechercher) {
        ArrayList<Retard> list = new ArrayList<>();
        try {
            String req = "SELECT retards.id, retards.id_eleve_classe, retards.date, retards.commentaire FROM retards "
                    + "JOIN eleve_classes ON eleve_classes.id = retards.id_eleve_classe "
                    + "JOIN eleves ON eleve_classes.id_eleve = eleves.id "
                    + "JOIN classes ON eleve_classes.id_classe = classes.id "
                    + "WHERE retards.id > '0' ";
            if (id_eleve != null) {
                req += "AND eleves.id = '" + id_eleve + "' ";
            }
            if (id_annee != null) {
                req += "AND classes.id_annee = '" + id_annee + "' ";
            }
            if (id_classe != null) {
                req += "AND classes.id = '" + id_classe + "' ";
            }
            if (date != null) {
                req += "AND retards.date = '" + date + "' ";
            }
            if (rechercher != null) {
                req += "AND (eleves.nom_prenom LIKE '%" + rechercher + "%' OR eleves.matricule LIKE '%" + rechercher + "%') ";
            }
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                list.add(new Retard(resultSet.getLong("id"), resultSet.getLong("id_eleve_classe"), resultSet.getTimestamp("date"), resultSet.getString("commentaire")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(RetardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
