/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import bean.User;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
public class UserController {

    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public UserController(Connection connection) {
        this.connection = connection;
    }

    public void add(String nom_prenom, String login, String password) {
        try {
            String req = "INSERT INTO users (nom_prenom, login, password) VALUES (?, ?, ?) ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, nom_prenom);
            preparedStatement.setString(2, login);
            preparedStatement.setString(3, encryptPass(password));
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AnneeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Long id, String nom_prenom, String login, String password) {
        try {
            String req = "UPDATE users SET nom_prenom = ?, login = ?, password = ? WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, nom_prenom);
            preparedStatement.setString(2, login);
            preparedStatement.setString(3, encryptPass(password));
            preparedStatement.setLong(4, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AnneeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void remove(Long id) {
        try {
            String req = "DELETE FROM users WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AnneeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void remove(String login) {
        try {
            String req = "DELETE FROM users WHERE BINARY login = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, login);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AnneeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public User get(Long id) {
        try {
            String req = "SELECT * FROM users WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new User(resultSet.getLong("id"), resultSet.getString("nom_prenom"), resultSet.getString("login"), resultSet.getString("password"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnneeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public User get(String login, String password) {
        try {
            String req = "SELECT * FROM users WHERE BINARY login = ? AND BINARY password = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, encryptPass(password));
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new User(resultSet.getLong("id"), resultSet.getString("nom_prenom"), resultSet.getString("login"), resultSet.getString("password"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnneeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<User> gets(Long id) {
        try {
            ArrayList<User> list = new ArrayList<>();
            String req = "SELECT * FROM users ";
            if (id != null) {
                req += "WHERE id ='" + id + "' ";
            }
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                list.add(new User(resultSet.getLong("id"), resultSet.getString("nom_prenom"), resultSet.getString("login"), resultSet.getString("password")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(AnneeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean isEmpty() {
        try {
            String req = "SELECT COUNT(id) AS effectif FROM users ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                if (resultSet.getInt("effectif") != 0) {
                    return false;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnneeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    private String encryptPass(String password) {
        try {
            MessageDigest digestor = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digestor.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder encryptionValue = new StringBuilder(2 * encodedhash.length);
            for (int i = 0; i < encodedhash.length; i++) {
                String hexVal = Integer.toHexString(0xff & encodedhash[i]);
                if (hexVal.length() == 1) {
                    encryptionValue.append('0');
                }
                encryptionValue.append(hexVal);
            }
            return encryptionValue.toString();
        } catch (NoSuchAlgorithmException ex) {
            return ex.getMessage();
        }

    }
}
