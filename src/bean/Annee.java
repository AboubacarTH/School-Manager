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
public class Annee {

    private final Long id;
    private final String annee;

    public Annee(Long id, String annee) {
        this.id = id;
        this.annee = annee;
    }

    public Long getId() {
        return id;
    }

    public String getAnnee() {
        return annee;
    }
}
