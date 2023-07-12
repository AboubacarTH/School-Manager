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
public class EvaluationClasse {

    private final Long id, id_eleve, id_classe, id_semestre;
    private final String rang, moyenne_lettre;
    private final Double moyenne;

    public EvaluationClasse(Long id, Long id_eleve, Long id_classe, Long id_semestre, String rang, Double moyenne, String moyenne_lettre) {
        this.id = id;
        this.id_eleve = id_eleve;
        this.id_classe = id_classe;
        this.id_semestre = id_semestre;
        this.rang = rang;
        this.moyenne = moyenne;
        this.moyenne_lettre = moyenne_lettre;
    }

    public Long getId() {
        return id;
    }

    public Long getId_eleve() {
        return id_eleve;
    }

    public Long getId_classe() {
        return id_classe;
    }

    public Long getId_semestre() {
        return id_semestre;
    }

    public String getRang() {
        return rang;
    }

    public Double getMoyenne() {
        return moyenne;
    }

    public String getMoyenne_lettre() {
        return moyenne_lettre;
    }
}
