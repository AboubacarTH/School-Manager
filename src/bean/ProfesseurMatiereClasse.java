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
public class ProfesseurMatiereClasse {

    private final Long id, id_professeur, id_matiere_classe;

    public ProfesseurMatiereClasse(Long id, Long id_matiere_classe, Long id_professeur) {
        this.id_professeur = id_professeur;
        this.id_matiere_classe = id_matiere_classe;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Long getId_professeur() {
        return id_professeur;
    }

    public Long getId_matiere_classe() {
        return id_matiere_classe;
    }

}
