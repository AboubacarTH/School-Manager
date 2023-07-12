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
public class MatiereType {

    private final Long id;
    private final String type;
    private final int priorite;

    public MatiereType(Long id, String type, int priorite) {
        this.id = id;
        this.type = type;
        this.priorite = priorite;
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public int getPriorite() {
        return priorite;
    }

}
