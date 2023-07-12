/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author ATH
 */
public class EvaluationMatiere {

    private final Long id, id_eleve, id_matiere_classe, id_semestre;
    private final Double interro_1, interro_2, interro_3, interro_4, composition, devoir_1, devoir_2, moyenne, moyenne_classe, note_coefficient, moyenne_interro, moyenne_devoir;
    private final String rang, appreciation;
    private final int coefficient;

    public EvaluationMatiere(Long id, Long id_eleve, Long id_matiere_classe, Long id_semestre, Double interro_1, Double interro_2, Double interro_3, Double interro_4, Double composition, Double devoir_1, Double devoir_2, String rang, String appreciation, Double moyenne, Double moyenne_classe, int coefficient, Double note_coefficient, Double moyenne_interro, Double moyenne_devoir) {
        this.id = id;
        this.id_eleve = id_eleve;
        this.id_matiere_classe = id_matiere_classe;
        this.id_semestre = id_semestre;
        this.interro_1 = interro_1;
        this.interro_2 = interro_2;
        this.interro_3 = interro_3;
        this.interro_4 = interro_4;
        this.composition = composition;
        this.devoir_1 = devoir_1;
        this.devoir_2 = devoir_2;
        this.rang = rang;
        this.appreciation = appreciation;
        this.moyenne = moyenne;
        this.moyenne_classe = moyenne_classe;
        this.coefficient = coefficient;
        this.note_coefficient = note_coefficient;
        this.moyenne_interro = moyenne_interro;
        this.moyenne_devoir = moyenne_devoir;
    }

    public EvaluationMatiere(Long id, Long id_eleve, Long id_matiere_classe, Long id_semestre, Double composition, String rang, String appreciation, int coefficient) {
        this.id = id;
        this.id_eleve = id_eleve;
        this.id_matiere_classe = id_matiere_classe;
        this.id_semestre = id_semestre;
        this.interro_1 = null;
        this.interro_2 = null;
        this.interro_3 = null;
        this.interro_4 = null;
        this.composition = composition;
        this.devoir_1 = null;
        this.devoir_2 = null;
        this.rang = rang;
        this.appreciation = appreciation;
        this.moyenne = null;
        this.moyenne_classe = null;
        this.coefficient = coefficient;
        this.note_coefficient = null;
        this.moyenne_interro = null;
        this.moyenne_devoir = null;
    }

    public Long getId() {
        return id;
    }

    public Long getId_eleve() {
        return id_eleve;
    }

    public Long getId_matiere_classe() {
        return id_matiere_classe;
    }

    public Long getId_semestre() {
        return id_semestre;
    }

    public Double getInterro_1() {
        return interro_1;
    }

    public Double getInterro_2() {
        return interro_2;
    }

    public Double getInterro_3() {
        return interro_3;
    }

    public Double getInterro_4() {
        return interro_4;
    }

    public Double getComposition() {
        return composition;
    }

    public Double getDevoir_1() {
        return devoir_1;
    }

    public Double getDevoir_2() {
        return devoir_2;
    }

    public String getRang() {
        return rang;
    }

    public String getAppreciation() {
        return appreciation;
    }

    public Double getMoyenne() {
        return moyenne;
    }

    public Double getMoyenne_classe() {
        return moyenne_classe;
    }

    public Double getNote_coefficient() {
        return note_coefficient;
    }

    public Double getMoyenne_interro() {
        return moyenne_interro;
    }

    public Double getMoyenne_devoir() {
        return moyenne_devoir;
    }

    public int getCoefficient() {
        return coefficient;
    }

}
