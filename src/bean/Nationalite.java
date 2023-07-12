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
public class Nationalite {

    private final Long id;
    private final String nationalite;

    public Nationalite(Long id, String nationalite) {
        this.id = id;
        this.nationalite = nationalite;
    }

    public Long getId() {
        return id;
    }

    public String getNationalite() {
        return nationalite;
    }

}
