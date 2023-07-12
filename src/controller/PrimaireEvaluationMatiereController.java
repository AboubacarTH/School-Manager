/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.EvaluationMatiere;
import bean.Note;
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
public class PrimaireEvaluationMatiereController {

    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public PrimaireEvaluationMatiereController(Connection connection) {
        this.connection = connection;
    }

    private void add(Long id_eleve, Long id_matiere_classe, Long id_semestre) {
        try {
            int coefficient = 1;
            String req;
            req = "SELECT coefficient FROM matiere_classes WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_matiere_classe);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                coefficient = resultSet.getInt("coefficient");
            }
            req = "INSERT INTO evaluation_matieres (id_eleve, id_matiere_classe, id_semestre, coefficient) VALUES (?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_eleve);
            preparedStatement.setLong(2, id_matiere_classe);
            preparedStatement.setLong(3, id_semestre);
            preparedStatement.setDouble(4, coefficient);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PrimaireEvaluationMatiereController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update_coefficient(Long id_matiere_classe) {
        try {
            int coefficient = 1;
            String req;
            req = "SELECT coefficient FROM matiere_classes WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_matiere_classe);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                coefficient = resultSet.getInt("coefficient");
            }
            req = "UPDATE evaluation_matieres SET coefficient = ? WHERE id_matiere_classe = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setDouble(1, coefficient);
            preparedStatement.setLong(2, id_matiere_classe);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PrimaireEvaluationMatiereController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void add(Long id_eleve, Long id_matiere_classe, Long id_semestre, String type_evaluation, double note_evaluation) {
        try {
            if (get(id_eleve, id_matiere_classe, id_semestre) == null) {
                add(id_eleve, id_matiere_classe, id_semestre);
            }
            String req;
            req = "UPDATE evaluation_matieres SET " + type_evaluation + " = ? WHERE id_eleve = ? AND id_matiere_classe = ? AND id_semestre = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setDouble(1, note_evaluation);
            preparedStatement.setLong(2, id_eleve);
            preparedStatement.setLong(3, id_matiere_classe);
            preparedStatement.setLong(4, id_semestre);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PrimaireEvaluationMatiereController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Long id_eleve, Long id_matiere_classe, Long id_semestre) {
        try {
            EvaluationMatiere evaluationMatiere = get(id_eleve, id_matiere_classe, id_semestre);
            if (evaluationMatiere == null) {
                return;
            }
            Long id = evaluationMatiere.getId();
            double composition = evaluationMatiere.getComposition();
            double coefficient = evaluationMatiere.getCoefficient();
            double note;
            if (composition != -1.00) {
                note = composition;
            } else {
                note = -1.00;
            }
            String appreciation = "";
            if (note > -1.00) {
                appreciation = getApreciation(note, coefficient);
            }
            String req;
            req = "UPDATE evaluation_matieres SET appreciation = ? WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, appreciation);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
            //matiere rang
            req = "SELECT DISTINCT composition FROM evaluation_matieres "
                    + "WHERE id_matiere_classe = ? AND id_semestre = ? AND composition > '-1.00' AND composition IS NOT NULL ORDER BY composition DESC ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_matiere_classe);
            preparedStatement.setLong(2, id_semestre);
            preparedStatement.execute();
            int rang = 1;
            int compteur = 0;
            String rangString = "";
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                rang += compteur;
                compteur = 0;
                req = "SELECT COUNT(id_eleve) AS compteur FROM evaluation_matieres "
                        + "WHERE id_matiere_classe = ? AND id_semestre = ? AND composition = ? ";
                preparedStatement = connection.prepareStatement(req);
                preparedStatement.setLong(1, id_matiere_classe);
                preparedStatement.setLong(2, id_semestre);
                preparedStatement.setDouble(3, resultSet.getDouble("composition"));
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
                req = "UPDATE evaluation_matieres SET rang = ? WHERE id_matiere_classe = ? AND id_semestre = ? AND composition = ? ";
                preparedStatement = connection.prepareStatement(req);
                preparedStatement.setString(1, rangString);
                preparedStatement.setLong(2, id_matiere_classe);
                preparedStatement.setLong(3, id_semestre);
                preparedStatement.setDouble(4, resultSet.getDouble("composition"));
                preparedStatement.executeUpdate();
            }
            req = "SELECT COUNT(id_eleve) AS effectif FROM evaluation_matieres "
                    + "WHERE id_matiere_classe = ? AND id_semestre = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_matiere_classe);
            preparedStatement.setLong(2, id_semestre);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            int effectif = 0;
            if (resultSet.next()) {
                effectif = resultSet.getInt("effectif");
            }
            if (effectif == 0) {
                return;
            }
            req = "SELECT SUM(composition) AS somme_moyenne FROM evaluation_matieres "
                    + "WHERE id_matiere_classe = ? AND id_semestre = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_matiere_classe);
            preparedStatement.setLong(2, id_semestre);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                req = "UPDATE evaluation_matieres SET moyenne_classe_matiere = ? WHERE id_matiere_classe = ? AND id_semestre = ? ";
                preparedStatement = connection.prepareStatement(req);
                preparedStatement.setDouble(1, resultSet.getDouble("somme_moyenne") / effectif);
                preparedStatement.setLong(2, id_matiere_classe);
                preparedStatement.setLong(3, id_semestre);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(PrimaireEvaluationMatiereController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Long id_matiere_classe, Long id_semestre) {
        try {
            //matiere rang
            String req = "SELECT DISTINCT moyenne FROM evaluation_matieres "
                    + "WHERE id_matiere_classe = ? AND id_semestre = ? AND moyenne IS NOT NULL AND moyenne > '-1.00' ORDER BY moyenne DESC";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_matiere_classe);
            preparedStatement.setLong(2, id_semestre);
            preparedStatement.execute();
            int rang = 1;
            int compteur = 0;
            String rangString = "";
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                rang += compteur;
                compteur = 0;
                req = "SELECT COUNT(id_eleve) AS compteur FROM evaluation_matieres "
                        + "WHERE id_matiere_classe = ? AND id_semestre = ? AND moyenne = ? ";
                preparedStatement = connection.prepareStatement(req);
                preparedStatement.setLong(1, id_matiere_classe);
                preparedStatement.setLong(2, id_semestre);
                preparedStatement.setDouble(3, resultSet.getDouble("moyenne"));
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
                req = "UPDATE evaluation_matieres SET rang = ? WHERE id_matiere_classe = ? AND id_semestre = ? AND moyenne = ? ";
                preparedStatement = connection.prepareStatement(req);
                preparedStatement.setString(1, rangString);
                preparedStatement.setLong(2, id_matiere_classe);
                preparedStatement.setLong(3, id_semestre);
                preparedStatement.setDouble(4, resultSet.getDouble("moyenne"));
                preparedStatement.executeUpdate();
            }
            req = "SELECT COUNT(id_eleve) AS effectif FROM evaluation_matieres "
                    + "WHERE id_matiere_classe = ? AND id_semestre = ? AND moyenne IS NOT NULL AND moyenne > '-1.00' ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_matiere_classe);
            preparedStatement.setLong(2, id_semestre);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            int effectif = 0;
            if (resultSet.next()) {
                effectif = resultSet.getInt("effectif");
            }
            if (effectif == 0) {
                return;
            }
            req = "SELECT SUM(moyenne) AS somme_moyenne FROM evaluation_matieres "
                    + "WHERE id_matiere_classe = ? AND id_semestre = ? AND moyenne IS NOT NULL AND moyenne > '-1.00' ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_matiere_classe);
            preparedStatement.setLong(2, id_semestre);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                req = "UPDATE evaluation_matieres SET moyenne_classe_matiere = ? WHERE id_matiere_classe = ? AND id_semestre = ? AND moyenne IS NOT NULL AND moyenne > '-1.00' ";
                preparedStatement = connection.prepareStatement(req);
                preparedStatement.setDouble(1, resultSet.getDouble("somme_moyenne") / effectif);
                preparedStatement.setLong(2, id_matiere_classe);
                preparedStatement.setLong(3, id_semestre);
                preparedStatement.executeUpdate();
            }

        } catch (SQLException ex) {
        }
    }

    public void remove(Long id_eleve, Long id_matiere_classe, Long id_semestre) {
        try {
            String req = "DELETE FROM evaluation_matieres WHERE id_eleve = ? AND id_matiere_classe = ? AND id_semestre = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_eleve);
            preparedStatement.setLong(2, id_matiere_classe);
            preparedStatement.setLong(3, id_semestre);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PrimaireEvaluationMatiereController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void remove(Long id_eleve, Long id_matiere_classe, Long id_semestre, String type_matiere) {
        try {
            String req = "UPDATE evaluation_matieres SET " + type_matiere + " = ? WHERE id_eleve = ? AND id_matiere_classe = ? AND id_semestre = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setDouble(1, -1.00);
            preparedStatement.setLong(2, id_eleve);
            preparedStatement.setLong(3, id_matiere_classe);
            preparedStatement.setLong(4, id_semestre);
            preparedStatement.executeUpdate();
            update(id_eleve, id_matiere_classe, id_semestre);
        } catch (SQLException ex) {
            Logger.getLogger(PrimaireEvaluationMatiereController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public EvaluationMatiere get(Long id_eleve, Long id_matiere_classe, Long id_semestre) {
        try {
            String req = "SELECT * FROM evaluation_matieres WHERE id_eleve = ? AND id_matiere_classe = ? AND id_semestre = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_eleve);
            preparedStatement.setLong(2, id_matiere_classe);
            preparedStatement.setLong(3, id_semestre);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new EvaluationMatiere(resultSet.getLong("id"), resultSet.getLong("id_eleve"), resultSet.getLong("id_matiere_classe"), resultSet.getLong("id_semestre"), resultSet.getDouble("composition"), resultSet.getString("rang"), resultSet.getString("appreciation"), resultSet.getInt("coefficient"));
            }
        } catch (SQLException ex) {
            return null;
        }
        return null;
    }

    public ArrayList<EvaluationMatiere> gets() {
        try {
            ArrayList<EvaluationMatiere> list = new ArrayList<>();
            String req = "SELECT * FROM evaluation_matieres ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                list.add(new EvaluationMatiere(resultSet.getLong("id"), resultSet.getLong("id_eleve"), resultSet.getLong("id_matiere_classe"), resultSet.getLong("id_semestre"), resultSet.getDouble("composition"), resultSet.getString("rang"), resultSet.getString("appreciation"), resultSet.getInt("coefficient")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(PrimaireEvaluationMatiereController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Note> gets(Long id_annee, Long id_cycle, Long id_classe, Long id_matiere) {
        ArrayList<Note> list = new ArrayList<>();
        try {
            String req = "SELECT eleves.id AS id_eleve, matiere_classes.id AS id_matiere_classe FROM eleves JOIN matiere_classes ON "
                    + "eleves.id_classe = matiere_classes.id_classe "
                    + "JOIN classes ON "
                    + "matiere_classes.id_classe = classes.id "
                    + "WHERE classes.id_annee = ? AND classes.id_cycle = ? AND classes.id = ? AND matiere_classes.id_matiere = ? ORDER BY eleves.numero_table ASC ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_annee);
            preparedStatement.setLong(2, id_cycle);
            preparedStatement.setLong(3, id_classe);
            preparedStatement.setLong(4, id_matiere);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                list.add(new Note(resultSet.getLong("id_eleve"), resultSet.getLong("id_matiere_classe"), resultSet.getString("nom_prenom")));
            }
            return list;
        } catch (SQLException ex) {
            return null;
        }
    }

    private String getApreciation(double moyenne, double coefficient) {
        if (coefficient == 1.00) {
            if (moyenne == 5) {
                return "Excellent";
            }
            if (moyenne == 4.5) {
                return "Très-Bien";
            }
            if (moyenne >= 4) {
                return "Bien";
            }
            if (moyenne >= 3) {
                return "Assez-Bien";
            }
            if (moyenne >= 2.5) {
                return "Passable";
            }
            if (moyenne >= 2) {
                return "Insuffisant";
            }
            if (moyenne >= 1.5) {
                return "Mal";
            }
            if (moyenne >= 1) {
                return "Médiocre";
            }
            if (moyenne >= 0) {
                return "Mauvais";
            }
            return "";
        }
        if (coefficient == 2.00) {
            if (moyenne == 10) {
                return "Excellent";
            }
            if (moyenne >= 9) {
                return "Très-Bien";
            }
            if (moyenne >= 8) {
                return "Bien";
            }
            if (moyenne >= 6) {
                return "Assez-Bien";
            }
            if (moyenne >= 5) {
                return "Passable";
            }
            if (moyenne >= 4) {
                return "Insuffisant";
            }
            if (moyenne >= 3) {
                return "Mal";
            }
            if (moyenne >= 2) {
                return "Médiocre";
            }
            if (moyenne >= 0) {
                return "Mauvais";
            }
            return "";
        }
        if (coefficient == 4.00) {
            if (moyenne >= 19) {
                return "Excellent";
            }
            if (moyenne >= 17) {
                return "Très-Bien";
            }
            if (moyenne >= 14) {
                return "Bien";
            }
            if (moyenne >= 12) {
                return "Assez-Bien";
            }
            if (moyenne >= 10) {
                return "Passable";
            }
            if (moyenne >= 8) {
                return "Insuffisant";
            }
            if (moyenne >= 6) {
                return "Mal";
            }
            if (moyenne >= 4) {
                return "Médiocre";
            }
            if (moyenne >= 0) {
                return "Mauvais";
            }
            return "";
        }
        if (coefficient == 8) {
            if (moyenne >= 38) {
                return "Excellent";
            }
            if (moyenne >= 34) {
                return "Très-Bien";
            }
            if (moyenne >= 28) {
                return "Bien";
            }
            if (moyenne >= 24) {
                return "Assez-Bien";
            }
            if (moyenne >= 20) {
                return "Passable";
            }
            if (moyenne >= 16) {
                return "Insuffisant";
            }
            if (moyenne >= 12) {
                return "Mal";
            }
            if (moyenne >= 8) {
                return "Médiocre";
            }
            if (moyenne >= 0) {
                return "Mauvais";
            }
            return "";
        }
        return "";
    }
}
