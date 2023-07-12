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
public class Note {

    private final Long id_eleve, id_matiere_classe;
    private final String nom_prenom;

    public Note(Long id_eleve, Long id_matiere_classe, String nom_prenom) {
        this.id_eleve = id_eleve;
        this.id_matiere_classe = id_matiere_classe;
        this.nom_prenom = nom_prenom;
    }

    public String getNom_prenom() {
        return nom_prenom;
    }

    public Long getId_eleve() {
        return id_eleve;
    }

    public Long getId_matiere_classe() {
        return id_matiere_classe;
    }
}
