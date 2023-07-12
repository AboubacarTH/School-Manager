/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import bean.Droit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ATH
 */
public class DroitController {

    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public DroitController(Connection connection) {
        this.connection = connection;
    }

    public void add(Long id, boolean administration, boolean professeur, boolean ajouter, boolean modifier, boolean suprimer, boolean s1, boolean s2, boolean s3) {
        try {
            String req = "INSERT INTO droits (id, administration, professeur, ajouter, modifier, suprimer, s1, s2, s3) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.setBoolean(2, administration);
            preparedStatement.setBoolean(3, professeur);
            preparedStatement.setBoolean(4, ajouter);
            preparedStatement.setBoolean(5, modifier);
            preparedStatement.setBoolean(6, suprimer);
            preparedStatement.setBoolean(7, s1);
            preparedStatement.setBoolean(8, s2);
            preparedStatement.setBoolean(9, s3);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AnneeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Long id, boolean administration, boolean professeur, boolean ajouter, boolean modifier, boolean suprimer, boolean s1, boolean s2, boolean s3) {
        try {
            String req = "UPDATE droits SET administration = ?, professeur = ?, ajouter = ?, modifier = ?, suprimer = ?, s1 = ?, s2 = ?, s3 = ? WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setBoolean(1, administration);
            preparedStatement.setBoolean(2, professeur);
            preparedStatement.setBoolean(3, ajouter);
            preparedStatement.setBoolean(4, modifier);
            preparedStatement.setBoolean(5, suprimer);
            preparedStatement.setBoolean(6, s1);
            preparedStatement.setBoolean(7, s2);
            preparedStatement.setBoolean(8, s3);
            preparedStatement.setLong(9, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AnneeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void activeAllSaisieProfS1() {
        try {
            String req = "UPDATE droits SET ajouter = ?, modifier = ?, suprimer = ?, s1 = ?, s2 = ?, s3 = ? WHERE professeur = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setBoolean(1, true);
            preparedStatement.setBoolean(2, true);
            preparedStatement.setBoolean(3, true);
            preparedStatement.setBoolean(4, true);
            preparedStatement.setBoolean(5, false);
            preparedStatement.setBoolean(6, false);
            preparedStatement.setBoolean(7, true);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AnneeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void activeAllSaisieProfS2() {
        try {
            String req = "UPDATE droits SET ajouter = ?, modifier = ?, suprimer = ?, s1 = ?, s2 = ?, s3 = ? WHERE professeur = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setBoolean(1, true);
            preparedStatement.setBoolean(2, true);
            preparedStatement.setBoolean(3, true);
            preparedStatement.setBoolean(4, false);
            preparedStatement.setBoolean(5, true);
            preparedStatement.setBoolean(6, false);
            preparedStatement.setBoolean(7, true);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AnneeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void activeAllSaisieProfS3() {
        try {
            String req = "UPDATE droits SET ajouter = ?, modifier = ?, suprimer = ?, s1 = ?, s2 = ?, s3 = ? WHERE professeur = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setBoolean(1, true);
            preparedStatement.setBoolean(2, true);
            preparedStatement.setBoolean(3, true);
            preparedStatement.setBoolean(4, false);
            preparedStatement.setBoolean(5, false);
            preparedStatement.setBoolean(6, true);
            preparedStatement.setBoolean(7, true);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AnneeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void desactiveAllSaisieProfS1() {
        try {
            String req = "UPDATE droits SET ajouter = ?, modifier = ?, suprimer = ?, s1 = ? WHERE professeur = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setBoolean(1, false);
            preparedStatement.setBoolean(2, false);
            preparedStatement.setBoolean(3, false);
            preparedStatement.setBoolean(4, false);
            preparedStatement.setBoolean(5, true);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AnneeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void desactiveAllSaisieProfS2() {
        try {
            String req = "UPDATE droits SET ajouter = ?, modifier = ?, suprimer = ?, s2 = ? WHERE professeur = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setBoolean(1, false);
            preparedStatement.setBoolean(2, false);
            preparedStatement.setBoolean(3, false);
            preparedStatement.setBoolean(4, false);
            preparedStatement.setBoolean(5, true);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AnneeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void desactiveAllSaisieProfS3() {
        try {
            String req = "UPDATE droits SET ajouter = ?, modifier = ?, suprimer = ?, s3 = ? WHERE professeur = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setBoolean(1, false);
            preparedStatement.setBoolean(2, false);
            preparedStatement.setBoolean(3, false);
            preparedStatement.setBoolean(4, false);
            preparedStatement.setBoolean(5, true);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AnneeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void remove(Long id) {
        try {
            String req = "DELETE FROM droits WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AnneeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Droit get(Long id) {
        try {
            String req = "SELECT * FROM droits WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new Droit(resultSet.getLong("id"), resultSet.getBoolean("administration"), resultSet.getBoolean("professeur"), resultSet.getBoolean("ajouter"), resultSet.getBoolean("modifier"), resultSet.getBoolean("suprimer"), resultSet.getBoolean("s1"), resultSet.getBoolean("s2"), resultSet.getBoolean("s3"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnneeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
