/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import bean.EvaluationMatiereType;
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
public class EvaluationMatiereTypeController {

    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public EvaluationMatiereTypeController(Connection connection) {
        this.connection = connection;
    }

    private void add(Long id_eleve, Long id_classe, Long id_matiere_type, Long id_semestre) {
        try {
            String req = "INSERT INTO evaluation_matiere_types (id_eleve, id_classe, id_matiere_type, id_semestre) VALUES (?, ?, ?, ?) ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_eleve);
            preparedStatement.setLong(2, id_classe);
            preparedStatement.setLong(3, id_matiere_type);
            preparedStatement.setLong(4, id_semestre);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EvaluationMatiereTypeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Long id_eleve, Long id_classe, Long id_matiere_type, Long id_semestre) {
        if (get(id_eleve, id_classe, id_matiere_type, id_semestre) == null) {
            add(id_eleve, id_classe, id_matiere_type, id_semestre);
        }
        try {
            String req;
            req = "SELECT "
                    + "SUM(evaluation_matieres.coefficient) AS somme_coefficient, "
                    + "SUM(evaluation_matieres.note_coefficient) AS somme_note_coefficient "
                    + "FROM evaluation_matieres "
                    + "JOIN matiere_classes ON "
                    + "evaluation_matieres.id_matiere_classe = matiere_classes.id "
                    + "JOIN classes ON "
                    + "matiere_classes.id_classe = classes.id "
                    + "JOIN matieres ON "
                    + "matiere_classes.id_matiere = matieres.id "
                    + "WHERE evaluation_matieres.id_eleve = ? AND matiere_classes.id_classe = ? AND matieres.id_matiere_type = ? AND evaluation_matieres.id_semestre = ? AND evaluation_matieres.note_coefficient > '-1.00' AND evaluation_matieres.moyenne IS NOT NULL ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_eleve);
            preparedStatement.setLong(2, id_classe);
            preparedStatement.setLong(3, id_matiere_type);
            preparedStatement.setLong(4, id_semestre);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                double numerateur = resultSet.getDouble("somme_note_coefficient");
                int denomunateur = resultSet.getInt("somme_coefficient");
                if (denomunateur == 0) {
                    return;
                }
                req = "UPDATE evaluation_matiere_types SET moyenne = ?, coefficient = ? WHERE id_eleve = ? AND id_classe = ? AND id_matiere_type = ? AND id_semestre = ? ";
                preparedStatement = connection.prepareStatement(req);
                double moyenne = numerateur / denomunateur;
                preparedStatement.setDouble(1, moyenne);
                preparedStatement.setInt(2, denomunateur);
                preparedStatement.setLong(3, id_eleve);
                preparedStatement.setLong(4, id_classe);
                preparedStatement.setLong(5, id_matiere_type);
                preparedStatement.setLong(6, id_semestre);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(EvaluationMatiereTypeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Long id_classe, Long id_matiere_type, Long id_semestre) {
        try {
            String req;
            req = "DELETE FROM evaluation_matiere_types WHERE moyenne = '-1.00' AND id_classe = ? AND id_matiere_type = ? AND id_semestre = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_classe);
            preparedStatement.setLong(2, id_matiere_type);
            preparedStatement.setLong(3, id_semestre);
            preparedStatement.executeUpdate();
            req = "SELECT DISTINCT moyenne FROM evaluation_matiere_types WHERE id_classe = ? AND id_matiere_type = ? AND id_semestre = ? AND moyenne IS NOT NULL AND moyenne > '-1.00' GROUP BY moyenne ORDER BY moyenne DESC ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_classe);
            preparedStatement.setLong(2, id_matiere_type);
            preparedStatement.setLong(3, id_semestre);
            preparedStatement.execute();
            int rang = 1;
            int compteur = 0;
            String rangString = "";
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                rang += compteur;
                compteur = 0;
                req = "SELECT COUNT(id_eleve) AS compteur FROM evaluation_matiere_types WHERE id_classe = ? AND id_matiere_type = ? AND id_semestre = ? AND moyenne = ? ";
                preparedStatement = connection.prepareStatement(req);
                preparedStatement.setLong(1, id_classe);
                preparedStatement.setLong(2, id_matiere_type);
                preparedStatement.setLong(3, id_semestre);
                preparedStatement.setDouble(4, resultSet.getDouble("moyenne"));
                preparedStatement.execute();
                ResultSet rs = preparedStatement.getResultSet();
                if (rs.next()) {
                    if (rs.getInt("compteur") == 1) {
                        rangString = rang + "e";
                    } else {
                        rangString = rang + "ex";
                    }
                    compteur = rs.getInt("compteur");
                }
                req = "UPDATE evaluation_matiere_types SET rang = ? WHERE id_classe = ? AND id_matiere_type = ? AND id_semestre = ? AND moyenne = ? ";
                preparedStatement = connection.prepareStatement(req);
                preparedStatement.setString(1, rangString);
                preparedStatement.setLong(2, id_classe);
                preparedStatement.setLong(3, id_matiere_type);
                preparedStatement.setLong(4, id_semestre);
                preparedStatement.setDouble(5, resultSet.getDouble("moyenne"));
                preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(EvaluationMatiereTypeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private EvaluationMatiereType get(Long id_eleve, Long id_classe, Long id_matiere_type, Long id_semestre) {
        try {
            String req = "SELECT * FROM evaluation_matiere_types WHERE id_eleve = ? AND id_classe = ? AND id_matiere_type = ? AND id_semestre = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_eleve);
            preparedStatement.setLong(2, id_classe);
            preparedStatement.setLong(3, id_matiere_type);
            preparedStatement.setLong(4, id_semestre);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new EvaluationMatiereType(resultSet.getLong("id"), resultSet.getLong("id_eleve"), resultSet.getLong("id_classe"), resultSet.getLong("id_matiere_type"), resultSet.getLong("id_semestre"), resultSet.getDouble("moyenne"), resultSet.getString("rang"), resultSet.getInt("coefficient"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EvaluationMatiereTypeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
