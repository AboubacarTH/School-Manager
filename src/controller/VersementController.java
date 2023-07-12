/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import bean.Versement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Toukou Habi
 */
public class VersementController {

    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public VersementController(Connection connection) {
        this.connection = connection;
    }

    public void add(Long id_eleve, Long id_tranche, Long id_montant_classe, Date date, Double montant, Double reduction) {
        try {
            String montant_lettre = getMontantLettre(montant);
            String req = "INSERT INTO versements (id_eleve, id_tranche, id_montant_classe, date, montant, reduction, montant_lettre) VALUES (?, ?, ?, ?, ?, ?, ?) ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_eleve);
            preparedStatement.setLong(2, id_tranche);
            preparedStatement.setLong(3, id_montant_classe);
            preparedStatement.setTimestamp(4, new Timestamp(date.getTime()));
            preparedStatement.setDouble(5, montant);
            preparedStatement.setDouble(6, reduction);
            preparedStatement.setString(7, montant_lettre);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VersementController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Long id, Long id_eleve, Long id_tranche, Long id_montant_classe, Date date, Double montant, Double reduction) {
        try {
            String montant_lettre = getMontantLettre(montant);
            String req = "UPDATE versements SET id_eleve = ?, id_tranche = ?, id_montant_classe = ?, date = ?, montant = ?, reduction = ?, montant_lettre = ? WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_eleve);
            preparedStatement.setLong(2, id_tranche);
            preparedStatement.setLong(3, id_montant_classe);
            preparedStatement.setTimestamp(4, new Timestamp(date.getTime()));
            preparedStatement.setDouble(5, montant);
            preparedStatement.setDouble(6, reduction);
            preparedStatement.setString(7, montant_lettre);
            preparedStatement.setLong(8, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VersementController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void remove(Long id) {
        try {
            String req = "DELETE FROM versements WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VersementController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Versement get(Long id) {
        try {
            String req = "SELECT * FROM versements WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new Versement(resultSet.getLong("id"), resultSet.getLong("id_eleve"), resultSet.getLong("id_tranche"), resultSet.getLong("id_montant_classe"), resultSet.getTimestamp("date"), resultSet.getDouble("montant"), resultSet.getDouble("reduction"), resultSet.getString("montant_lettre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(VersementController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Versement get(Long id_eleve, Long id_tranche, Long id_montant_classe) {
        try {
            String req = "SELECT * FROM versements WHERE id_eleve = ? AND id_tranche = ? AND id_montant_classe = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setLong(1, id_eleve);
            preparedStatement.setLong(2, id_tranche);
            preparedStatement.setLong(3, id_montant_classe);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                return new Versement(resultSet.getLong("id"), resultSet.getLong("id_eleve"), resultSet.getLong("id_tranche"), resultSet.getLong("id_montant_classe"), resultSet.getTimestamp("date"), resultSet.getDouble("montant"), resultSet.getDouble("reduction"), resultSet.getString("montant_lettre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(VersementController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Versement> gets(Long id_eleve, Long id_annee, Long id_cycle, Long id_classe, Long id_tranche, String sexe, String rechercher) {
        try {
            ArrayList<Versement> list = new ArrayList<>();
            String req = "SELECT versements.id, versements.id_eleve, versements.id_tranche, versements.id_montant_classe, versements.date, versements.montant, versements.reduction, versements.montant_lettre FROM versements "
                    + "JOIN eleve_classes ON versements.id_eleve = eleve_classes.id_eleve "
                    + "JOIN montant_classes ON versements.id_montant_classe = montant_classes.id AND eleve_classes.id_classe = montant_classes.id_classe "
                    + "JOIN classes ON eleve_classes.id_classe = classes.id "
                    + "JOIN eleves ON eleves.id = eleve_classes.id_eleve "
                    + " WHERE versements.id > '0' ";
            if (id_annee != null) {
                req += "AND classes.id_annee ='" + id_annee + "' ";
            }
            if (id_cycle != null) {
                req += "AND classes.id_cycle ='" + id_cycle + "' ";
            }
            if (id_classe != null) {
                req += "AND classes.id ='" + id_classe + "' ";
            }
            if (id_tranche != null) {
                req += "AND versements.id_tranche ='" + id_tranche + "' ";
            }
            if (id_eleve != null) {
                req += "AND eleves.id ='" + id_eleve + "' ";
            }
            if (sexe != null && !"Tous".equals(sexe)) {
                req += "AND eleves.sexe = '" + sexe + "' ";
            }
            if (rechercher != null) {
                req += "AND (eleves.matricule LIKE '%" + rechercher + "%' OR eleves.nom_prenom LIKE '%" + rechercher + "%') ";
            }
            req += "ORDER BY versements.id ASC ";
            preparedStatement = connection.prepareStatement(req);
            resultSet = preparedStatement.getResultSet();
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                list.add(new Versement(resultSet.getLong("id"), resultSet.getLong("id_eleve"), resultSet.getLong("id_tranche"), resultSet.getLong("id_montant_classe"), resultSet.getTimestamp("date"), resultSet.getDouble("montant"), resultSet.getDouble("reduction"), resultSet.getString("montant_lettre")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(VersementController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private String getMontantLettre(Double number) {
        if (number == 0) {
            return "zéro";
        }
        String snumber;
        // pad des "0"
        String mask = "000000000000";
        DecimalFormat df = new DecimalFormat(mask);
        snumber = df.format(number);
        // XXXnnnnnnnnn
        int lesMilliards = Integer.parseInt(snumber.substring(0, 3));
        // nnnXXXnnnnnn
        int lesMillions = Integer.parseInt(snumber.substring(3, 6));
        // nnnnnnXXXnnn
        int lesCentMille = Integer.parseInt(snumber.substring(6, 9));
        // nnnnnnnnnXXX
        int lesMille = Integer.parseInt(snumber.substring(9, 12));
        String tradMilliards;
        tradMilliards = switch (lesMilliards) {
            case 0 ->
                "";
            case 1 ->
                convertLessThanOneThousand(lesMilliards)
                + " milliard ";
            default ->
                convertLessThanOneThousand(lesMilliards)
                + " milliards ";
        };
        String resultat = tradMilliards;
        String tradMillions;
        tradMillions = switch (lesMillions) {
            case 0 ->
                "";
            case 1 ->
                convertLessThanOneThousand(lesMillions)
                + " million ";
            default ->
                convertLessThanOneThousand(lesMillions)
                + " millions ";
        };
        resultat = resultat + tradMillions;
        String tradCentMille;
        tradCentMille = switch (lesCentMille) {
            case 0 ->
                "";
            case 1 ->
                "mille ";
            default ->
                convertLessThanOneThousand(lesCentMille)
                + " mille ";
        };
        resultat = resultat + tradCentMille;
        String tradMille;
        tradMille = convertLessThanOneThousand(lesMille);
        resultat = resultat + tradMille;
        return resultat;
    }

    private String convertZeroToHundred(int number) {
        String[] group_unit_1 = {"", "un", "deux", "trois", "quatre", "cinq", "six", "sept", "huit", "neuf", "dix", "onze", "douze", "treize", "quatorze", "quinze", "seize", "dix sept", "dix huit", "dix neuf"};
        String[] group_diz = {"", "", "vingt", "trente", "quarante", "cinquante", "soixante", "soixante", "quatre vingt", "quatre vingt"};
        int laDizaine = number / 10;
        int lUnite = number % 10;
        String resultat;
        switch (laDizaine) {
            case 1:
            case 7:
            case 9:
                lUnite = lUnite + 10;
                break;
            default:
        }
        String laLiaison = "";
        if (laDizaine > 1) {
            laLiaison = "-";
        }
        // cas particuliers
        switch (lUnite) {
            case 0 ->
                laLiaison = "";
            case 1 -> {
                if (laDizaine == 8) {
                    laLiaison = "-";
                } else {
                    laLiaison = " et ";
                }
            }
            case 11 -> {
                if (laDizaine == 7) {
                    laLiaison = " et ";
                }
            }
            default -> {
            }
        }
        switch (laDizaine) {
            case 0 ->
                resultat = group_unit_1[lUnite];
            case 8 -> {
                if (lUnite == 0) {
                    resultat = group_diz[laDizaine];
                } else {
                    resultat = group_diz[laDizaine]
                            + laLiaison + group_diz[lUnite];
                }
            }
            default ->
                resultat = group_diz[laDizaine]
                        + laLiaison + group_unit_1[lUnite];
        }
        return resultat;
    }

    private String convertLessThanOneThousand(int number) {
        String[] group_unit_2 = {"", "", "deux", "trois", "quatre", "cinq", "six", "sept", "huit", "neuf", "dix"};
        int lesCentaines = number / 100;
        int leReste = number % 100;
        String sReste = convertZeroToHundred(leReste);
        String resultat;
        switch (lesCentaines) {
            case 0 ->
                resultat = sReste;
            case 1 -> {
                if (leReste > 0) {
                    resultat = "cent " + sReste;
                } else {
                    resultat = "cent";
                }
            }
            default -> {
                if (leReste > 0) {
                    resultat = group_unit_2[lesCentaines] + " cent " + sReste;
                } else {
                    resultat = group_unit_2[lesCentaines] + " cents";
                }
            }
        }
        return resultat;
    }

}
