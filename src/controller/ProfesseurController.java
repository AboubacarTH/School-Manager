/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Professeur;
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
public class ProfesseurController {

    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public ProfesseurController(Connection connection) {
        this.connection = connection;
    }

    public void add(String matricule, Long id_nationalite, String nom_prenom, Date date_de_naissance, String lieu_de_naissance, String contact, String titre, String diplome, boolean etat, String mot_de_passe, String sexe) {
        try {
            String req = "INSERT INTO professeurs (matricule, id_nationalite, nom_prenom, date_de_naissance, lieu_de_naissance, contact, titre, diplome, etat, mot_de_passe, sexe) VALUES (?,?,?,?,?,?,?,?,?,?,?) ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, matricule);
            preparedStatement.setLong(2, id_nationalite);
            preparedStatement.setString(3, nom_prenom);
            preparedStatement.setDate(4, date_de_naissance);
            preparedStatement.setString(5, lieu_de_naissance);
            preparedStatement.setString(6, contact);
            preparedStatement.setString(7, titre);
            preparedStatement.setString(8, diplome);
            preparedStatement.setBoolean(9, etat);
            preparedStatement.setString(10, mot_de_passe);
            preparedStatement.setString(11, sexe);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfesseurController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Long id, String matricule, Long id_nationalite, String nom_prenom, Date date_de_naissance, String lieu_de_naissance, String contact, String titre, String diplome, boolean etat, String mot_de_passe, String sexe) {
        try {
            String req = "UPDATE professeurs SET matricule = ?, id_nationalite = ?, nom_prenom = ?, date_de_naissance = ?, lieu_de_naissance = ?, contact = ?, titre = ?, diplome = ?, etat = ?, mot_de_passe = ?, sexe = ? WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, matricule);
            preparedStatement.setLong(2, id_nationalite);
            preparedStatement.setString(3, nom_prenom);
            preparedStatement.setDate(4, date_de_naissance);
            preparedStatement.setString(5, lieu_de_naissance);
            preparedStatement.setString(6, contact);
            preparedStatement.setString(7, titre);
            preparedStatement.setString(8, diplome);
            preparedStatement.setBoolean(9, etat);
            preparedStatement.setString(10, mot_de_passe);
            preparedStatement.setString(11, sexe);
            preparedStatement.setLong(12, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfesseurController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void remove(Long id) {
        try {
            String req = "DELETE FROM professeurs WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfesseurController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Professeur get(String matricule) {
        try {
            String req = "SELECT * FROM professeurs WHERE matricule = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, matricule);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new Professeur(resultSet.getLong("id"), resultSet.getString("matricule"), resultSet.getLong("id_nationalite"), resultSet.getString("nom_prenom"), resultSet.getDate("date_de_naissance"), resultSet.getString("lieu_de_naissance"), resultSet.getString("contact"), resultSet.getString("titre"), resultSet.getString("diplome"), resultSet.getBoolean("etat"), resultSet.getString("mot_de_passe"), resultSet.getString("sexe"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfesseurController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Professeur get(Long id) {
        try {
            String req = "SELECT * FROM professeurs WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new Professeur(resultSet.getLong("id"), resultSet.getString("matricule"), resultSet.getLong("id_nationalite"), resultSet.getString("nom_prenom"), resultSet.getDate("date_de_naissance"), resultSet.getString("lieu_de_naissance"), resultSet.getString("contact"), resultSet.getString("titre"), resultSet.getString("diplome"), resultSet.getBoolean("etat"), resultSet.getString("mot_de_passe"), resultSet.getString("sexe"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfesseurController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Long getMaxID() {
        try {
            String req = "SELECT MAX(id) AS id_max FROM professeurs ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return resultSet.getLong("id_max");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfesseurController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Professeur> gets() {
        ArrayList<Professeur> listProfesseur = new ArrayList<>();
        try {
            String req = "SELECT "
                    + "professeurs.id, "
                    + "professeurs.matricule, "
                    + "professeurs.id_nationalite, "
                    + "professeurs.nom_prenom, "
                    + "professeurs.date_de_naissance, "
                    + "professeurs.lieu_de_naissance, "
                    + "professeurs.contact, "
                    + "professeurs.titre, "
                    + "professeurs.diplome, "
                    + "professeurs.etat, "
                    + "professeurs.mot_de_passe, "
                    + "professeurs.sexe "
                    + "FROM professeurs "
                    + "WHERE professeurs.id > '0' ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                listProfesseur.add(new Professeur(resultSet.getLong("id"), resultSet.getString("matricule"), resultSet.getLong("id_nationalite"), resultSet.getString("nom_prenom"), resultSet.getDate("date_de_naissance"), resultSet.getString("lieu_de_naissance"), resultSet.getString("contact"), resultSet.getString("titre"), resultSet.getString("diplome"), resultSet.getBoolean("etat"), resultSet.getString("mot_de_passe"), resultSet.getString("sexe")));
            }
            return listProfesseur;
        } catch (SQLException ex) {
            Logger.getLogger(ProfesseurController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Professeur> gets(Long id_nationalite, String titre, String sexe, String recherche) {
        ArrayList<Professeur> listProfesseur = new ArrayList<>();
        try {
            String req = "SELECT "
                    + "professeurs.id, "
                    + "professeurs.matricule, "
                    + "professeurs.id_nationalite, "
                    + "professeurs.nom_prenom, "
                    + "professeurs.date_de_naissance, "
                    + "professeurs.lieu_de_naissance, "
                    + "professeurs.contact, "
                    + "professeurs.titre, "
                    + "professeurs.diplome, "
                    + "professeurs.etat, "
                    + "professeurs.mot_de_passe, "
                    + "professeurs.sexe "
                    + "FROM professeurs "
                    + "WHERE professeurs.id > '0' ";
            if (id_nationalite != null) {
                req += "AND professeurs.id_nationalite = '" + id_nationalite + "' ";
            }
            if (titre != null) {
                req += "AND professeurs.titre = '" + titre + "' ";
            }
            if (sexe != null) {
                req += "AND professeurs.sexe = '" + sexe + "' ";
            }
            if (recherche != null) {
                req += "AND ((professeurs.matricule LIKE '%" + recherche + "%') OR (professeurs.nom_prenom LIKE '%" + recherche + "%')) ";
            }
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                listProfesseur.add(new Professeur(resultSet.getLong("id"), resultSet.getString("matricule"), resultSet.getLong("id_nationalite"), resultSet.getString("nom_prenom"), resultSet.getDate("date_de_naissance"), resultSet.getString("lieu_de_naissance"), resultSet.getString("contact"), resultSet.getString("titre"), resultSet.getString("diplome"), resultSet.getBoolean("etat"), resultSet.getString("mot_de_passe"), resultSet.getString("sexe")));
            }
            return listProfesseur;
        } catch (SQLException ex) {
            return null;
        }
    }
}
