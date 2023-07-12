/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.NoteEvaluationClasse;
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
public class NoteEvaluationController {

    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public NoteEvaluationController(Connection connection) {
        this.connection = connection;
    }

    public ArrayList<NoteEvaluationClasse> gets(Long id_annee, Long id_cycle, Long id_classe, String rechercher) {
        ArrayList<NoteEvaluationClasse> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM evaluation_classes "
                    + "JOIN classes ON "
                    + "evaluation_classes.id_classe = classes.id "
                    + "JOIN eleves ON "
                    + "evaluation_classes.id_eleve = eleve.id "
                    + "WHERE evaluation_classes.id > = '0' ";
            if (id_annee != null) {
                req += "AND classes.id_annee = '" + id_annee + "' ";
            }
            if (id_cycle != null) {
                req += "AND classes.id_cycle = '" + id_cycle + "' ";
            }
            if (id_classe != null) {
                req += "AND classes.id = '" + id_classe + "' ";
            }
            if (rechercher != null) {
                req += "AND (eleves.matricule LIKE  = '%" + rechercher + "%' OR eleves.nom_prenom LIKE = '%" + rechercher + "%')";
            }
            req += "ORDER BY evaluation_classes.moyenne DESC";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setBoolean(1, true);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                list.add(new NoteEvaluationClasse(resultSet.getLong("id_eleve"), resultSet.getLong("id_classe"), resultSet.getLong("id_semestre")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(EvaluationMatiereController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
