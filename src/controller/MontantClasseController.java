/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import bean.MontantClasse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Toukou Habi
 */
public class MontantClasseController {

    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public MontantClasseController(Connection connection) {
        this.connection = connection;
    }

    public void add(Long id_classe, Double montant) {
        try {
            String req = "INSERT INTO montant_classes (id_classe, montant) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_classe);
            preparedStatement.setDouble(2, montant);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MontantClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Long id, Long id_classe, Double montant) {
        try {
            String req = "UPDATE montant_classes SET id_classe = ?, montant = ? WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_classe);
            preparedStatement.setDouble(2, montant);
            preparedStatement.setLong(3, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MontantClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void remove(Long id) {
        try {
            String req = "DELETE FROM montant_classes WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MontantClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public MontantClasse get(Long id) {
        try {
            String req = "SELECT * FROM montant_classes WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new MontantClasse(resultSet.getLong("id"), resultSet.getLong("id_classe"), resultSet.getDouble("montant"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MontantClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public MontantClasse get(Long id, Long id_classe) {
        try {
            String req = "SELECT * FROM montant_classes WHERE id_classe = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_classe);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new MontantClasse(resultSet.getLong("id"), resultSet.getLong("id_classe"), resultSet.getDouble("montant"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MontantClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<MontantClasse> gets(Long id_annee, Long id_cycle, Long id_classe) {
        try {
            ArrayList<MontantClasse> list = new ArrayList<>();
            String req = "SELECT montant_classes.id, montant_classes.id_classe, montant_classes.montant FROM montant_classes "
                    + "JOIN classes ON montant_classes.id_classe = classes.id WHERE montant_classes.id > '0' ";
            if (id_annee != null) {
                req += "AND classes.id_annee ='" + id_annee + "' ";
            }
            if (id_cycle != null) {
                req += "AND classes.id_cycle ='" + id_cycle + "' ";
            }
            if (id_classe != null) {
                req += "AND classes.id ='" + id_classe + "' ";
            }
            req += "ORDER BY montant_classes.id_classe ASC ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                list.add(new MontantClasse(resultSet.getLong("id"), resultSet.getLong("id_classe"), resultSet.getDouble("montant")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(MontantClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
