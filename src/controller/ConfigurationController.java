/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ATH
 */
public class ConfigurationController {

    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public ConfigurationController(Connection connection) {
        this.connection = connection;
    }

    public int getSMSRestant() {
        try {
            String req = "SELECT nombre_sms_restant FROM configuration WHERE ath_config = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, "boube");
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return resultSet.getInt("nombre_sms_restant");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConfigurationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    private Date getDate() {
        try {
            String req = "SELECT date_expiratoire FROM configuration WHERE ath_config = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, "boube");
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return resultSet.getDate("date_expiratoire");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConfigurationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private void restorSMS() {
        try {
            String req = "UPDATE configuration SET nombre_sms_restant = ? WHERE ath_config = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, 0);
            preparedStatement.setString(2, "boube");
            preparedStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ConfigurationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void controlSMSRestant() {
        if (getDate() == null || getDate().compareTo(Date.valueOf(LocalDate.now())) < 0) {
            restorSMS();
        }
    }

    public void sendSMS(String contact, String sms) {
        int sms_restant = getSMSRestant();
        if (sms_restant > 0) {
            try {
                //sending sms here
                String req = "UPDATE configuration SET nombre_sms_restant = ? WHERE ath_config = ?";
                preparedStatement = connection.prepareStatement(req);
                preparedStatement.setInt(1, sms_restant - 1);
                preparedStatement.setString(2, "boube");
                preparedStatement.executeUpdate();
                controlSMSRestant();
                success_information();
            } catch (SQLException ex) {
                Logger.getLogger(ConfigurationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            error_information();
        }
    }

    private void success_information() {
        JOptionPane.showMessageDialog(null, "Opération effectuée avec succes ", "Réussie !", JOptionPane.INFORMATION_MESSAGE);
    }

    private void error_information() {
        JOptionPane.showMessageDialog(null, "Stock SMS vide ", "Echec !", JOptionPane.WARNING_MESSAGE);
    }

    public void sendSMS(ArrayList<String> list_contact, String text) {
        int sms_restant = getSMSRestant();
        int nombre_sms = list_contact.size();
        if (sms_restant > 0) {
            try {
                //sending sms here
                String req = "UPDATE configuration SET nombre_sms_restant = ? WHERE ath_config = ?";
                preparedStatement = connection.prepareStatement(req);
                preparedStatement.setInt(1, sms_restant - nombre_sms);
                preparedStatement.setString(2, "boube");
                preparedStatement.executeUpdate();
                controlSMSRestant();
                success_information();
            } catch (SQLException ex) {
                Logger.getLogger(ConfigurationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            error_information();
        }
    }
}
