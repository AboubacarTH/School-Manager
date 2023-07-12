/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Eleve;
import java.sql.Connection;
import java.sql.Date;
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
public class EleveController {

    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public EleveController(Connection connection) {
        this.connection = connection;
    }

    /**
     *
     * @param id_nationalite
     * @param matricule
     * @param nom_prenom
     * @param date_de_naissance
     * @param lieu_de_naissance
     * @param contact
     * @param sexe
     * @param qr_code
     * @param photo
     * @param numero_table
     */
    public void add(Long id_nationalite, String matricule, String nom_prenom, Date date_de_naissance, String lieu_de_naissance, String contact, String sexe, String qr_code, String photo, int numero_table) {
        try {
            String req = "INSERT INTO eleves (id_nationalite, matricule, nom_prenom, date_de_naissance, lieu_de_naissance, contact, sexe, qr_code, photo, numero_table) VALUES (?,?,?,?,?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_nationalite);
            preparedStatement.setString(2, matricule);
            preparedStatement.setString(3, nom_prenom);
            preparedStatement.setDate(4, date_de_naissance);
            preparedStatement.setString(5, lieu_de_naissance);
            preparedStatement.setString(6, contact);
            preparedStatement.setString(7, sexe);
            preparedStatement.setString(8, qr_code);
            preparedStatement.setString(9, photo);
            preparedStatement.setInt(10, numero_table);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EleveController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Long id, Long id_nationalite, String matricule, String nom_prenom, Date date_de_naissance, String lieu_de_naissance, String contact, String sexe, String qr_code, String photo, int numero_table) {
        try {
            String req = "UPDATE eleves SET id_nationalite = ?, matricule = ?, nom_prenom = ?, date_de_naissance = ?, lieu_de_naissance = ?, contact = ?, sexe = ?, qr_code = ?, photo = ?, numero_table = ? WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_nationalite);
            preparedStatement.setString(2, matricule);
            preparedStatement.setString(3, nom_prenom);
            preparedStatement.setDate(4, date_de_naissance);
            preparedStatement.setString(5, lieu_de_naissance);
            preparedStatement.setString(6, contact);
            preparedStatement.setString(7, sexe);
            preparedStatement.setString(8, qr_code);
            preparedStatement.setString(9, photo);
            preparedStatement.setInt(10, numero_table);
            preparedStatement.setLong(11, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EleveController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param id
     */
    public void remove(Long id) {
        try {
            String req = "DELETE FROM eleves WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EleveController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param id
     * @return
     */
    public Eleve get(Long id) {
        try {
            String req = "SELECT * FROM eleves WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new Eleve(resultSet.getLong("id"), resultSet.getLong("id_nationalite"), resultSet.getString("matricule"), resultSet.getString("nom_prenom"), resultSet.getDate("date_de_naissance"), resultSet.getString("lieu_de_naissance"), resultSet.getString("contact"), resultSet.getString("sexe"), resultSet.getString("qr_code"), resultSet.getString("photo"), resultSet.getInt("numero_table"));
            }
        } catch (SQLException ex) {
            return null;
        }
        return null;
    }

    /**
     *
     * @param matricule
     * @return
     */
    public Eleve get(String matricule) {
        try {
            String req = "SELECT * FROM eleves WHERE matricule = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, matricule);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new Eleve(resultSet.getLong("id"), resultSet.getLong("id_nationalite"), resultSet.getString("matricule"), resultSet.getString("nom_prenom"), resultSet.getDate("date_de_naissance"), resultSet.getString("lieu_de_naissance"), resultSet.getString("contact"), resultSet.getString("sexe"), resultSet.getString("qr_code"), resultSet.getString("photo"), resultSet.getInt("numero_table"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EleveController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * @param rechercher
     * @param id_nationalite
     * @param sexe
     * @return
     */
    public ArrayList<Eleve> gets(String rechercher, Long id_nationalite, String sexe) {
        ArrayList<Eleve> listEleve = new ArrayList<>();
        try {
            String req = "SELECT * FROM eleves WHERE id > '0' ";

            if (rechercher != null) {
                req += "AND (eleves.matricule LIKE '%" + rechercher + "%' OR eleves.nom_prenom LIKE '%" + rechercher + "%')";
            }
            if (id_nationalite != null) {
                req += "AND eleves.id_nationalite = '" + id_nationalite + "' ";
            }
            if (sexe != null && !"Tous".equals(sexe)) {
                req += "AND eleves.sexe = '" + sexe + "' ";
            }
            req += "ORDER BY eleves.numero_table ASC";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                listEleve.add(new Eleve(resultSet.getLong("id"), resultSet.getLong("id_nationalite"), resultSet.getString("matricule"), resultSet.getString("nom_prenom"), resultSet.getDate("date_de_naissance"), resultSet.getString("lieu_de_naissance"), resultSet.getString("contact"), resultSet.getString("sexe"), resultSet.getString("qr_code"), resultSet.getString("photo"), resultSet.getInt("numero_table")));
            }
            return listEleve;
        } catch (SQLException ex) {
        }
        return null;
    }
}
