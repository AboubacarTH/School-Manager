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
public class EvaluationMatiereController {

    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public EvaluationMatiereController(Connection connection) {
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
            Logger.getLogger(EvaluationMatiereController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void add(Long id_eleve, Long id_matiere_classe, Long id_semestre, String type_evaluation, double note_evaluation) {
        if (get(id_eleve, id_matiere_classe, id_semestre) == null) {
            add(id_eleve, id_matiere_classe, id_semestre);
        }
        try {
            String req = "UPDATE evaluation_matieres SET " + type_evaluation + " = ? WHERE id_eleve = ? AND id_matiere_classe = ? AND id_semestre = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setDouble(1, note_evaluation);
            preparedStatement.setLong(2, id_eleve);
            preparedStatement.setLong(3, id_matiere_classe);
            preparedStatement.setLong(4, id_semestre);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EvaluationMatiereController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Long id_eleve, Long id_matiere_classe, Long id_semestre) {
        try {
            EvaluationMatiere evaluationMatiere = get(id_eleve, id_matiere_classe, id_semestre);
            if (evaluationMatiere == null) {
                return;
            }
            Long id = evaluationMatiere.getId();
            double devoir_1 = evaluationMatiere.getDevoir_1();
            double devoir_2 = evaluationMatiere.getDevoir_2();
            double interro_1 = evaluationMatiere.getInterro_1();
            double interro_2 = evaluationMatiere.getInterro_2();
            double interro_3 = evaluationMatiere.getInterro_3();
            double interro_4 = evaluationMatiere.getInterro_4();
            double composition = evaluationMatiere.getComposition();
            double coefficient = evaluationMatiere.getCoefficient();
            double moyenne_classe;
            double moyenne_interro;
            double moyenne_devoir;
            double moyenne = -1.00;
            double note_devoir;
            double note_interro;
            double note_devoir_1 = 0, note_devoir_2 = 0, note_interro_1 = 0, note_interro_2 = 0, note_interro_3 = 0, note_interro_4 = 0;
            int nombre_devoir = 0, nombre_interro = 0;
            if (devoir_1 != -1.00) {
                note_devoir_1 = devoir_1;
                nombre_devoir++;
            }
            if (devoir_2 != -1.00) {
                note_devoir_2 = devoir_2;
                nombre_devoir++;
            }
            if (nombre_devoir == 0) {
                note_devoir = -1.00;
            } else {
                note_devoir = (note_devoir_1 + note_devoir_2) / nombre_devoir;
            }
            if (interro_1 != -1.00) {
                note_interro_1 = interro_1;
                nombre_interro++;
            }
            if (interro_2 != -1.00) {
                note_interro_2 = interro_2;
                nombre_interro++;
            }
            if (interro_3 != -1.00) {
                note_interro_3 = interro_3;
                nombre_interro++;
            }
            if (interro_4 != -1.00) {
                note_interro_4 = interro_4;
                nombre_interro++;
            }
            if (nombre_interro == 0) {
                note_interro = -1.00;
            } else {
                note_interro = (note_interro_1 + note_interro_2 + note_interro_3 + note_interro_4) / nombre_interro;
                note_interro *= 2;
            }

            moyenne_devoir = note_devoir;
            moyenne_interro = note_interro;

            moyenne_classe = switch (nombre_interro) {
                case 0 ->
                    (note_interro_1 + note_interro_2 + note_interro_3 + note_interro_4 + note_devoir_1 + note_devoir_2) / 2;
                case 1 ->
                    (note_interro_1 + note_interro_2 + note_interro_3 + note_interro_4 + note_devoir_1 + note_devoir_2) / 2.5;
                case 2 ->
                    (note_interro_1 + note_interro_2 + note_interro_3 + note_interro_4 + note_devoir_1 + note_devoir_2) / 3;
                case 3 ->
                    (note_interro_1 + note_interro_2 + note_interro_3 + note_interro_4 + note_devoir_1 + note_devoir_2) / 3.5;
                case 4 ->
                    (note_interro_1 + note_interro_2 + note_interro_3 + note_interro_4 + note_devoir_1 + note_devoir_2) / 4;
                default ->
                    -1.00;
            };
            String req;
            req = "UPDATE evaluation_matieres SET moyenne_interro = ?, moyenne_devoir = ?, moyenne_classe = ? WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setDouble(1, moyenne_interro);
            preparedStatement.setDouble(2, moyenne_devoir);
            preparedStatement.setDouble(3, moyenne_classe);
            preparedStatement.setLong(4, id);
            preparedStatement.executeUpdate();
            req = "SELECT moyenne_classe FROM evaluation_matieres WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                if (composition != -1.00 && moyenne_classe != -1.00) {
                    moyenne = (resultSet.getDouble("moyenne_classe") + composition) / 2;
                } else if (moyenne_classe != -1.00) {
                    moyenne = resultSet.getDouble("moyenne_classe");
                } else if (composition != -1.00) {
                    moyenne = composition;
                } else {
                    moyenne = -1.00;
                }
            }
            String appreciation = "";
            if (moyenne > -1.00) {
                appreciation = getApreciation(moyenne);
            }
            req = "UPDATE evaluation_matieres SET moyenne = ?, appreciation = ? WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setDouble(1, moyenne);
            preparedStatement.setString(2, appreciation);
            preparedStatement.setLong(3, id);
            preparedStatement.executeUpdate();
            req = "SELECT moyenne FROM evaluation_matieres WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                req = "UPDATE evaluation_matieres SET note_coefficient = ? WHERE id = ? ";
                preparedStatement = connection.prepareStatement(req);
                preparedStatement.setDouble(1, resultSet.getDouble("moyenne") * coefficient);
                preparedStatement.setLong(2, id);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(EvaluationMatiereController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Long id_matiere_classe, Long id_semestre) {
        try {
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
            Logger.getLogger(EvaluationMatiereController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(EvaluationMatiereController.class.getName()).log(Level.SEVERE, null, ex);
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
            //update(id_eleve, id_matiere_classe, id_semestre);
        } catch (SQLException ex) {
            Logger.getLogger(EvaluationMatiereController.class.getName()).log(Level.SEVERE, null, ex);
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
                return new EvaluationMatiere(resultSet.getLong("id"), resultSet.getLong("id_eleve"), resultSet.getLong("id_matiere_classe"), resultSet.getLong("id_semestre"), resultSet.getDouble("interro_1"), resultSet.getDouble("interro_2"), resultSet.getDouble("interro_3"), resultSet.getDouble("interro_4"), resultSet.getDouble("composition"), resultSet.getDouble("devoir_1"), resultSet.getDouble("devoir_2"), resultSet.getString("rang"), resultSet.getString("appreciation"), resultSet.getDouble("moyenne"), resultSet.getDouble("moyenne_classe"), resultSet.getInt("coefficient"), resultSet.getDouble("note_coefficient"), resultSet.getDouble("moyenne_interro"), resultSet.getDouble("moyenne_devoir"));
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
                list.add(new EvaluationMatiere(resultSet.getLong("id"), resultSet.getLong("id_eleve"), resultSet.getLong("id_matiere_classe"), resultSet.getLong("id_semestre"), resultSet.getDouble("interro_1"), resultSet.getDouble("interro_2"), resultSet.getDouble("interro_3"), resultSet.getDouble("interro_4"), resultSet.getDouble("composition"), resultSet.getDouble("devoir_1"), resultSet.getDouble("devoir_2"), resultSet.getString("rang"), resultSet.getString("appreciation"), resultSet.getDouble("moyenne"), resultSet.getDouble("moyenne_classe"), resultSet.getInt("coefficient"), resultSet.getDouble("note_coefficient"), resultSet.getDouble("moyenne_interro"), resultSet.getDouble("moyenne_devoir")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(EvaluationMatiereController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Note> gets(Long id_annee, Long id_cycle, Long id_classe, Long id_matiere) {
        ArrayList<Note> list = new ArrayList<>();
        try {
            String req = "SELECT eleves.id AS id_eleve, eleves.nom_prenom AS nom_prenom, matiere_classes.id AS id_matiere_classe FROM eleve_classes "
                    + "JOIN eleves ON eleve_classes.id_eleve = eleves.id "
                    + "JOIN classes ON eleve_classes.id_classe = classes.id "
                    + "JOIN matiere_classes ON "
                    + "eleve_classes.id_classe = matiere_classes.id_classe "
                    + "WHERE classes.id_annee = ? AND classes.id_cycle = ? AND eleve_classes.id_classe = ? AND matiere_classes.id_matiere = ? ORDER BY eleve_classes.id_eleve ASC ";
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

    private String getApreciation(double moyenne) {
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
            return "Très-Insuffisant";
        }
        if (moyenne >= 4) {
            return "Médiocre";
        }
        if (moyenne >= 0) {
            return "Nul";
        }
        return "Nul";
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
            Logger.getLogger(EvaluationMatiereController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
