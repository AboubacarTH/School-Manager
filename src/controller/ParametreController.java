/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
public class ParametreController {

    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public ParametreController(Connection connection) {
        this.connection = connection;
    }

    public boolean getDevoir1Permission() {
        try {
            String req = "SELECT devoir_1 FROM parametre WHERE id_parametre = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, 1);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return resultSet.getBoolean("devoir_1");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ParametreController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean getDevoir2Permission() {
        try {
            String req = "SELECT devoir_2 FROM parametre WHERE id_parametre = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, 1);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return resultSet.getBoolean("devoir_2");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ParametreController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean getInterro1Permission() {
        try {
            String req = "SELECT interro_1 FROM parametre WHERE id_parametre = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, 1);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return resultSet.getBoolean("interro_1");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ParametreController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean getInterro2Permission() {
        try {
            String req = "SELECT interro_2 FROM parametre WHERE id_parametre = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, 1);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return resultSet.getBoolean("interro_2");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ParametreController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean getCompositionPermission() {
        try {
            String req = "SELECT composition FROM parametre WHERE id_parametre = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, 1);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return resultSet.getBoolean("composition");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ParametreController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean getAddPermission() {
        try {
            String req = "SELECT ajout FROM parametre WHERE id_parametre = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, 1);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return resultSet.getBoolean("ajout");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ParametreController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean getUpdatePermission() {
        try {
            String req = "SELECT modification FROM parametre WHERE id_parametre = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, 1);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return resultSet.getBoolean("modification");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ParametreController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean getRemovePermission() {
        try {
            String req = "SELECT suppression FROM parametre WHERE id_parametre = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, 1);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return resultSet.getBoolean("suppression");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ParametreController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void setDevoir1Permission(boolean value) {
        try {
            String req = "UPDATE parametre SET devoir_1 = ? WHERE id_parametre = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setBoolean(1, value);
            preparedStatement.setInt(2, 1);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ParametreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setDevoir2Permission(boolean value) {
        try {
            String req = "UPDATE parametre SET devoir_2 = ? WHERE id_parametre = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setBoolean(1, value);
            preparedStatement.setInt(2, 1);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ParametreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setInterro1Permission(boolean value) {
        try {
            String req = "UPDATE parametre SET interro_1 = ? WHERE id_parametre = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setBoolean(1, value);
            preparedStatement.setInt(2, 1);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ParametreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setInterro2Permission(boolean value) {
        try {
            String req = "UPDATE parametre SET interro_2 = ? WHERE id_parametre = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setBoolean(1, value);
            preparedStatement.setInt(2, 1);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ParametreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setCompositionPermission(boolean value) {
        try {
            String req = "UPDATE parametre SET composition = ? WHERE id_parametre = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setBoolean(1, value);
            preparedStatement.setInt(2, 1);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ParametreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setAddPermission(boolean value) {
        try {
            String req = "UPDATE parametre SET ajout = ? WHERE id_parametre = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setBoolean(1, value);
            preparedStatement.setInt(2, 1);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ParametreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setUpdatePermission(boolean value) {
        try {
            String req = "UPDATE parametre SET modification = ? WHERE id_parametre = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setBoolean(1, value);
            preparedStatement.setInt(2, 1);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ParametreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setRemovePermission(boolean value) {
        try {
            String req = "UPDATE parametre SET suppression = ? WHERE id_parametre = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setBoolean(1, value);
            preparedStatement.setInt(2, 1);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ParametreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
