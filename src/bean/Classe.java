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
public class Classe {

    private final Long id, id_annee, id_cycle;
    private final String classe;

    public Classe(Long id, Long id_annee, Long id_cycle, String classe) {
        this.id = id;
        this.id_annee = id_annee;
        this.id_cycle = id_cycle;
        this.classe = classe;
    }

    public Long getId() {
        return id;
    }

    public Long getId_annee() {
        return id_annee;
    }

    public Long getId_cycle() {
        return id_cycle;
    }

    public String getClasse() {
        return classe;
    }

}
