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
public class NoteEvaluationClasse {

    private final Long id_eleve, id_classe, id_semestre;

    public NoteEvaluationClasse(Long id_eleve, Long id_classe, Long id_semestre) {
        this.id_eleve = id_eleve;
        this.id_classe = id_classe;
        this.id_semestre = id_semestre;
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

}
