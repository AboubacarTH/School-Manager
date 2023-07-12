/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import bean.Tranche;
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
public class TrancheController {

    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public TrancheController(Connection connection) {
        this.connection = connection;
    }

    public void add(String tranche, Double pourcentage) {
        try {
            String req = "INSERT INTO tranches (tranche, pourcentage) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, tranche);
            preparedStatement.setDouble(2, pourcentage);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TrancheController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Long id, String tranche, Double pourcentage) {
        try {
            String req = "UPDATE tranches SET tranche = ?, pourcentage = ? WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, tranche);
            preparedStatement.setDouble(2, pourcentage);
            preparedStatement.setLong(3, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TrancheController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void remove(Long id) {
        try {
            String req = "DELETE FROM tranches WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TrancheController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Tranche get(Long id) {
        try {
            String req = "SELECT * FROM tranches WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new Tranche(resultSet.getLong("id"), resultSet.getString("tranche"), resultSet.getDouble("pourcentage"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TrancheController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Tranche get(String tranche) {
        try {
            String req = "SELECT * FROM tranches WHERE tranche = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, tranche);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new Tranche(resultSet.getLong("id"), resultSet.getString("tranche"), resultSet.getDouble("pourcentage"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TrancheController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Tranche> gets() {
        try {
            ArrayList<Tranche> list = new ArrayList<>();
            String req = "SELECT * FROM tranches ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                list.add(new Tranche(resultSet.getLong("id"), resultSet.getString("tranche"), resultSet.getDouble("pourcentage")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(TrancheController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
