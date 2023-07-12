/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.sql.Timestamp;

/**
 *
 * @author ATH
 */
public class Retard {

    private final Long id, id_eleve_classe;
    private final Timestamp date;
    private final String commentaire;

    public Retard(Long id, Long id_eleve_classe, Timestamp date, String commentaire) {
        this.id = id;
        this.id_eleve_classe = id_eleve_classe;
        this.date = date;
        this.commentaire = commentaire;
    }

    public Long getId() {
        return id;
    }

    public Long getId_eleve_classe() {
        return id_eleve_classe;
    }

    public Timestamp getDate() {
        return date;
    }

    public String getCommentaire() {
        return commentaire;
    }

}
