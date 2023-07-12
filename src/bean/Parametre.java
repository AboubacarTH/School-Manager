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
public class Parametre {

    private final Long id_parametre, id_annee;

    public Parametre(Long id_parametre, Long id_annee) {
        this.id_parametre = id_parametre;
        this.id_annee = id_annee;
    }

    public Long getId_parametre() {
        return id_parametre;
    }

    public Long getId_annee() {
        return id_annee;
    }

}
