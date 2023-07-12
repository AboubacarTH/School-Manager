/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

/**
 *
 * @author ATH
 */
public class EvaluationMatiereType {

    private final Long id, id_eleve, id_classe, id_semestre, id_matiere_type;
    private final Double moyenne;
    private final String rang;
    private final int coefficient;

    public EvaluationMatiereType(Long id, Long id_eleve, Long id_classe, Long id_semestre, Long id_matiere_type, Double moyenne, String rang, int coefficient) {
        this.id = id;
        this.id_eleve = id_eleve;
        this.id_classe = id_classe;
        this.id_semestre = id_semestre;
        this.id_matiere_type = id_matiere_type;
        this.moyenne = moyenne;
        this.rang = rang;
        this.coefficient = coefficient;
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

    public Long getId_matiere_type() {
        return id_matiere_type;
    }

    public Double getMoyenne() {
        return moyenne;
    }

    public String getRang() {
        return rang;
    }

    public int getCoefficient() {
        return coefficient;
    }

}
