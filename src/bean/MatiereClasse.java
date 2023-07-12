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
public class MatiereClasse {

    private final Long id, id_matiere, id_classe;
    private final int volume_horaire, coefficient;

    public MatiereClasse(Long id, Long id_matiere, Long id_classe, int volume_horaire, int coefficient) {
        this.id = id;
        this.id_matiere = id_matiere;
        this.id_classe = id_classe;
        this.volume_horaire = volume_horaire;
        this.coefficient = coefficient;
    }

    public Long getId() {
        return id;
    }

    public Long getId_matiere() {
        return id_matiere;
    }

    public Long getId_classe() {
        return id_classe;
    }

    public int getVolume_horaire() {
        return volume_horaire;
    }

    public int getCoefficient() {
        return coefficient;
    }

}
