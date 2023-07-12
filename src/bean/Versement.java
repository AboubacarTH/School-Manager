/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import java.util.Date;

/**
 *
 * @author Toukou Habi
 */
public class Versement {

    private final Long id, id_eleve, id_tranche, id_montant_classe;
    private final Date date;
    private final Double montant, reduction;
    private final String montant_lettre;

    public Versement(Long id, Long id_eleve, Long id_tranche, Long id_montant_classe, Date date, Double montant, Double reduction, String montant_lettre) {
        this.id = id;
        this.id_eleve = id_eleve;
        this.id_tranche = id_tranche;
        this.id_montant_classe = id_montant_classe;
        this.date = date;
        this.montant = montant;
        this.reduction = reduction;
        this.montant_lettre = montant_lettre;
    }

    public Long getId() {
        return id;
    }

    public Long getId_eleve() {
        return id_eleve;
    }

    public Long getId_tranche() {
        return id_tranche;
    }

    public Date getDate() {
        return date;
    }

    public Double getMontant() {
        return montant;
    }

    public Double getReduction() {
        return reduction;
    }

    public Long getId_montant_classe() {
        return id_montant_classe;
    }

    public String getMontant_lettre() {
        return montant_lettre;
    }

}
