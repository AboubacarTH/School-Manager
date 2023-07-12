/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

/**
 *
 * @author Toukou Habi
 */
public class MontantClasse {

    private final Long id, id_classe;
    private final Double montant;

    public Long getId() {
        return id;
    }

    public Long getId_classe() {
        return id_classe;
    }

    public Double getMontant() {
        return montant;
    }

    public MontantClasse(Long id, Long id_classe, Double montant) {
        this.id = id;
        this.id_classe = id_classe;
        this.montant = montant;
    }

}
