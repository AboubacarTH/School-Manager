/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import bean.Journal;
import java.sql.Connection;
import java.sql.Date;
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
public class JournalController {

    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public JournalController(Connection connection) {
        this.connection = connection;
    }

    public void add(Long id_user, java.util.Date date) {
        try {
            String req = "INSERT INTO journals (id_user, date) VALUES (?, ?) ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_user);
            preparedStatement.setTimestamp(2, new Timestamp(date.getTime()));
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(JournalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Long id, Long id_user, Date date) {
        try {
            String req = "UPDATE journals SET id_user = ?, date = ? WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_user);
            preparedStatement.setTimestamp(2, new Timestamp(date.getTime()));
            preparedStatement.setLong(3, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(JournalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void remove(Long id) {
        try {
            String req = "DELETE FROM journals WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(JournalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void remove() {
        try {
            String req = "DELETE FROM journals WHERE id > '0' ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(JournalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Journal get(Long id_user) {
        try {
            String req = "SELECT * FROM journals WHERE id_user = ? ORDER BY date DESC ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_user);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new Journal(resultSet.getLong("id"), resultSet.getLong("id_user"), resultSet.getTimestamp("date"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(JournalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Journal> gets(Long id_user, Date date, String rechercher) {
        try {
            ArrayList<Journal> list = new ArrayList<>();
            String req = "SELECT * FROM journals "
                    + "JOIN users ON "
                    + "journals.id_user = users.id "
                    + "WHERE journals.id > '0' ";
            if (id_user != null) {
                req += "AND id_user ='" + id_user + "' ";
            }
            if (date != null) {
                req += "AND date LIKE '%" + date + "%' ";
            }
            if (rechercher != null) {
                req += "AND nom_prenom LIKE '%" + rechercher + "%' ";
            }
            req += "ORDER BY date DESC ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                list.add(new Journal(resultSet.getLong("id"), resultSet.getLong("id_user"), resultSet.getTimestamp("date")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(JournalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
