/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import bean.EleveClasse;
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
public class EleveClasseController {

    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public EleveClasseController(Connection connection) {
        this.connection = connection;
    }

    public void add(Long id_eleve, Long id_classe) {
        if (get(id_eleve, id_classe) != null) {
            return;
        }
        try {
            String req = "INSERT INTO eleve_classes (id_eleve, id_classe) VALUES (?, ?) ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_eleve);
            preparedStatement.setLong(2, id_classe);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EleveClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Long id, Long id_eleve, Long id_classe) {
        try {
            String req = "UPDATE eleve_classes SET id_eleve = ?, id_classe = ? WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_eleve);
            preparedStatement.setLong(2, id_classe);
            preparedStatement.setLong(3, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EleveClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void remove(Long id) {
        try {
            String req = "DELETE FROM eleve_classes WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EleveClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void remove(Long id_eleve, Long id_classe) {
        try {
            String req = "DELETE FROM eleve_classes WHERE id_eleve = ? AND id_classe = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_eleve);
            preparedStatement.setLong(2, id_classe);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EleveClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public EleveClasse get(Long id) {
        try {
            String req = "SELECT * FROM eleve_classes WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new EleveClasse(resultSet.getLong("id"), resultSet.getLong("id_eleve"), resultSet.getLong("id_classe"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EleveClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public EleveClasse get(Long id_eleve, Long id_classe) {
        try {
            String req = "SELECT * FROM eleve_classes WHERE id_eleve = ? AND id_classe = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_eleve);
            preparedStatement.setLong(2, id_classe);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new EleveClasse(resultSet.getLong("id"), resultSet.getLong("id_eleve"), resultSet.getLong("id_classe"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EleveClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<EleveClasse> gets(Long id_eleve, Long id_annee, Long id_cycle, Long id_classe, String rechercher, Long id_nationalite, String sexe) {
        try {
            ArrayList<EleveClasse> list = new ArrayList<>();
            String req = "SELECT eleve_classes.id, eleve_classes.id_eleve, eleve_classes.id_classe "
                    + "FROM eleve_classes "
                    + "INNER JOIN eleves ON eleve_classes.id_eleve = eleves.id "
                    + "INNER JOIN classes ON eleve_classes.id_classe = classes.id "
                    + "WHERE eleve_classes.id > '0' ";
            if (id_eleve != null) {
                req += "AND eleve_classes.id_eleve = '" + id_eleve + "' ";
            }
            if (id_annee != null) {
                req += "AND classes.id_annee = '" + id_annee + "' ";
            }
            if (id_cycle != null) {
                req += "AND classes.id_cycle = '" + id_cycle + "' ";
            }
            if (id_classe != null) {
                req += "AND eleve_classes.id_classe = '" + id_classe + "' ";
            }
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
                list.add(new EleveClasse(resultSet.getLong("id"), resultSet.getLong("id_eleve"), resultSet.getLong("id_classe")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(EleveClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int getEffectif(Long id_annee, Long id_cycle, Long id_classe, String sexe) {
        try {
            String req = "SELECT COUNT(eleve_classes.id_eleve) AS effectif FROM eleve_classes JOIN eleves ON eleve_classes.id_eleve = eleves.id JOIN classes ON eleve_classes.id_classe = classes.id "
                    + "WHERE eleve_classes.id > '0' ";
            if (id_annee != null) {
                req += "AND classes.id_annee = '" + id_annee + "' ";
            }
            if (id_cycle != null) {
                req += "AND classes.id_cycle = '" + id_cycle + "' ";
            }
            if (id_classe != null) {
                req += "AND classes.id = '" + id_classe + "' ";
            }
            if (sexe != null) {
                req += "AND eleves.sexe = '" + sexe + "' ";
            }
            req += "ORDER BY eleves.numero_table ASC";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return resultSet.getInt("effectif");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EleveClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

}
