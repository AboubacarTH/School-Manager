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
public class Cycle {

    private final Long id;
    private final String cycle;

    public Cycle(Long id, String cycle) {
        this.id = id;
        this.cycle = cycle;
    }

    public Long getId() {
        return id;
    }

    public String getCycle() {
        return cycle;
    }

}
