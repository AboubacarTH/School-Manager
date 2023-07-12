/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.EvaluationClasse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ATH
 */
public class PrimaireEvaluationClasseController {

    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public PrimaireEvaluationClasseController(Connection connection) {
        this.connection = connection;
    }

    /**
     *
     * @param id_eleve
     * @param id_classe
     * @param id_semestre
     */
    private void add(Long id_eleve, Long id_classe, Long id_semestre) {
        try {
            String req = "INSERT INTO evaluation_classes (id_eleve, id_classe, id_semestre) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_eleve);
            preparedStatement.setLong(2, id_classe);
            preparedStatement.setLong(3, id_semestre);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PrimaireEvaluationClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Long id_eleve, Long id_classe, Long id_semestre) {
        if (get(id_eleve, id_classe, id_semestre) == null) {
            add(id_eleve, id_classe, id_semestre);
        }
        try {
            String req = "SELECT SUM(evaluation_matieres.composition) AS sommeMoyenne, SUM(evaluation_matieres.coefficient) AS sommeCoefficient FROM evaluation_matieres "
                    + "JOIN matiere_classes ON "
                    + "evaluation_matieres.id_matiere_classe = matiere_classes.id "
                    + "WHERE evaluation_matieres.id_eleve = ? AND matiere_classes.id_classe = ? AND evaluation_matieres.id_semestre = ? AND evaluation_matieres.coefficient IS NOT NULL "
                    + "AND evaluation_matieres.composition > '-1.00' AND evaluation_matieres.composition IS NOT NULL ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_eleve);
            preparedStatement.setLong(2, id_classe);
            preparedStatement.setLong(3, id_semestre);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            double moyenne = 0.00;
            if (resultSet.next()) {
                double numerateur = resultSet.getDouble("sommeMoyenne");
                double denomunateur = resultSet.getDouble("sommeCoefficient");
                if (denomunateur != 0) {
                    moyenne = numerateur * 2 / denomunateur;
                }
            }
            req = "UPDATE evaluation_classes SET moyenne = ? WHERE id_eleve = ? AND id_classe = ? AND id_semestre = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setDouble(1, moyenne);
            preparedStatement.setLong(2, id_eleve);
            preparedStatement.setLong(3, id_classe);
            preparedStatement.setLong(4, id_semestre);
            preparedStatement.executeUpdate();
            req = "DELETE FROM evaluation_classes WHERE moyenne IS NULL ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.executeUpdate();
            req = "SELECT moyenne FROM evaluation_classes WHERE id_eleve = ? AND id_classe = ? AND id_semestre = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_eleve);
            preparedStatement.setLong(2, id_classe);
            preparedStatement.setLong(3, id_semestre);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                req = "UPDATE evaluation_classes SET moyenne_lettre = ? WHERE id_eleve = ? AND id_classe = ? AND id_semestre = ? ";
                preparedStatement = connection.prepareStatement(req);
                preparedStatement.setString(1, getMoyenneLettre(resultSet.getDouble("moyenne")));
                preparedStatement.setLong(2, id_eleve);
                preparedStatement.setLong(3, id_classe);
                preparedStatement.setLong(4, id_semestre);
                preparedStatement.executeUpdate();
            }
            req = "SELECT DISTINCT moyenne FROM evaluation_classes WHERE id_classe = ? AND id_semestre = ? AND moyenne IS NOT NULL GROUP BY moyenne ORDER BY moyenne DESC";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_classe);
            preparedStatement.setLong(2, id_semestre);
            preparedStatement.execute();
            int rang = 1;
            int compteur = 0;
            String rangString = "";
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                rang += compteur;
                compteur = 0;
                req = "SELECT COUNT(id_eleve) AS compteur FROM evaluation_classes WHERE id_classe = ? AND id_semestre = ? AND moyenne = ? ";
                preparedStatement = connection.prepareStatement(req);
                preparedStatement.setLong(1, id_classe);
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
                req = "UPDATE evaluation_classes SET rang = ? WHERE id_classe = ? AND id_semestre = ? AND moyenne = ?";
                preparedStatement = connection.prepareStatement(req);
                preparedStatement.setString(1, rangString);
                preparedStatement.setLong(2, id_classe);
                preparedStatement.setLong(3, id_semestre);
                preparedStatement.setDouble(4, resultSet.getDouble("moyenne"));
                preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(PrimaireEvaluationMatiereController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Long id_classe, Long id_semestre) {
        try {
            String req;
            req = "DELETE FROM evaluation_classes WHERE id_classe = ? AND id_semestre = ? AND moyenne IS NULL OR moyenne = '0'";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_classe);
            preparedStatement.setLong(2, id_semestre);
            preparedStatement.execute();
            req = "SELECT DISTINCT moyenne FROM evaluation_classes WHERE id_classe = ? AND id_semestre = ? AND moyenne IS NOT NULL AND moyenne > '-1.00' GROUP BY moyenne ORDER BY moyenne DESC";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_classe);
            preparedStatement.setLong(2, id_semestre);
            preparedStatement.execute();
            int rang = 1;
            int compteur = 0;
            String rangString = "";
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                rang += compteur;
                compteur = 0;
                req = "SELECT COUNT(id_eleve) AS compteur FROM evaluation_classes WHERE id_classe = ? AND id_semestre = ? AND moyenne = ? ";
                preparedStatement = connection.prepareStatement(req);
                preparedStatement.setLong(1, id_classe);
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
                req = "UPDATE evaluation_classes SET rang = ? WHERE id_classe = ? AND id_semestre = ? AND moyenne = ?";
                preparedStatement = connection.prepareStatement(req);
                preparedStatement.setString(1, rangString);
                preparedStatement.setLong(2, id_classe);
                preparedStatement.setLong(3, id_semestre);
                preparedStatement.setDouble(4, resultSet.getDouble("moyenne"));
                preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(PrimaireEvaluationMatiereController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param id
     */
    public void remove(Long id) {
        try {
            String req = "DELETE FROM evaluation_classes WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PrimaireEvaluationClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void remove(Long id_eleve, Long id_classe, Long id_semestre) {
        try {
            String req = "DELETE FROM evaluation_classes WHERE id_eleve = ? AND id_classe = ? AND id_semestre = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_eleve);
            preparedStatement.setLong(2, id_classe);
            preparedStatement.setLong(3, id_semestre);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PrimaireEvaluationClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param id
     * @return
     */
    public EvaluationClasse get(Long id) {
        try {
            String req = "SELECT * FROM evaluation_classes WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new EvaluationClasse(resultSet.getLong("id"), resultSet.getLong("id_eleve"), resultSet.getLong("id_classe"), resultSet.getLong("id_semestre"), resultSet.getString("rang"), resultSet.getDouble("moyenne"), resultSet.getString("moyenne_lettre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PrimaireEvaluationClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public EvaluationClasse get(Long id_eleve, Long id_classe, Long id_semestre) {
        try {
            String req = "SELECT * FROM evaluation_classes WHERE id_eleve = ? AND id_classe = ? AND id_semestre = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_eleve);
            preparedStatement.setLong(2, id_classe);
            preparedStatement.setLong(3, id_semestre);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new EvaluationClasse(resultSet.getLong("id"), resultSet.getLong("id_eleve"), resultSet.getLong("id_classe"), resultSet.getLong("id_semestre"), resultSet.getString("rang"), resultSet.getDouble("moyenne"), resultSet.getString("moyenne_lettre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PrimaireEvaluationClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<EvaluationClasse> gets(Long id_eleve, Long id_classe, Long id_semestre) {
        try {
            ArrayList<EvaluationClasse> list = new ArrayList<>();
            String req = "SELECT * FROM evaluation_classes WHERE id > '0' ";
            if (id_eleve != null) {
                req += "AND id_eleve = '" + id_eleve + "' ";
            }
            if (id_classe != null) {
                req += "AND id_classe = '" + id_classe + "' ";
            }
            if (id_semestre != null) {
                req += "AND id_semestre = '" + id_semestre + "' ";
            }
            req += "ORDER BY moyenne DESC ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                list.add(new EvaluationClasse(resultSet.getLong("id"), resultSet.getLong("id_eleve"), resultSet.getLong("id_classe"), resultSet.getLong("id_semestre"), resultSet.getString("rang"), resultSet.getDouble("moyenne"), resultSet.getString("moyenne_lettre")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(PrimaireEvaluationClasseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private String getMoyenneLettre(double moy) {
        String convert;
        String[] group_unit = {"", "un", "deux", "trois", "quatre", "cinq", "six", "sept", "huit", "neuf", "dix", "onze", "douze", "treize", "quatorze", "quinze", "seize", "dix sept", "dix huit", "dix neuf"};
        String[] group_diz = {"", "dix", "vingt", "trente", "quarante", "cinquante", "soixante", "soixante", "quatre vingt", "quatre vingt"};
        int avant_virgule = (int) moy;
        double reste = moy - (int) moy;
        DecimalFormat df = new DecimalFormat("#.##");
        String formatted = df.format(reste * 100);
        int apres_virgule = Integer.parseInt(formatted);
        convert = group_unit[avant_virgule] + " ";
        if (apres_virgule > 0) {
            convert += "virgule ";
        }
        if (apres_virgule > 19) {
            convert += group_diz[apres_virgule / 10] + " ";
            if (apres_virgule / 10 == 7 || apres_virgule / 10 == 9) {
                convert += group_unit[apres_virgule % 10 + 10];
            } else {
                convert += group_unit[apres_virgule % 10];
            }

        } else {
            convert += group_unit[apres_virgule];
        }
        convert = convert.substring(0, 1).toUpperCase() + convert.substring(1);

        return convert;
    }
}
