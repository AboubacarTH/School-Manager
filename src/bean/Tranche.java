/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

/**
 *
 * @author Toukou Habi
 */
public class Tranche {

    private final Long id;
    private final String tranche;
    private final Double pourcentage;

    public Tranche(Long id, String tranche, Double pourcentage) {
        this.id = id;
        this.tranche = tranche;
        this.pourcentage = pourcentage;
    }

    public Long getId() {
        return id;
    }

    public String getTranche() {
        return tranche;
    }

    public Double getPourcentage() {
        return pourcentage;
    }

}
