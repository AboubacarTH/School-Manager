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
public class Semestre {

    private final Long id;
    private final String semestre;
    private final String description;

    public Semestre(Long id, String semestre, String description) {
        this.id = id;
        this.semestre = semestre;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getSemestre() {
        return semestre;
    }

    public String getDescription() {
        return description;
    }

}
