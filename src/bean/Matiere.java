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
public class Matiere {

    private final Long id, id_matiere_type;
    private final String matiere;
    private final int priorite;

    public Matiere(Long id, String matiere, Long id_matiere_type, int priorite) {
        this.id = id;
        this.priorite = priorite;
        this.matiere = matiere;
        this.id_matiere_type = id_matiere_type;
    }

    public Long getId() {
        return id;
    }

    public String getMatiere() {
        return matiere;
    }

    public Long getId_matiere_type() {
        return id_matiere_type;
    }

    public int getPriorite() {
        return priorite;
    }

}
