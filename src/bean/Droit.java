/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

/**
 *
 * @author ATH
 */
public class Droit {

    private final Long id;
    private final boolean administration, professeur, ajouter, modifier, suprimer, s1, s2, s3;

    public Droit(Long id, boolean administration, boolean professeur, boolean ajouter, boolean modifier, boolean suprimer, boolean s1, boolean s2, boolean s3) {
        this.id = id;
        this.administration = administration;
        this.professeur = professeur;
        this.ajouter = ajouter;
        this.modifier = modifier;
        this.suprimer = suprimer;
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
    }

    public Long getId() {
        return id;
    }

    public boolean isS3() {
        return s3;
    }

    public boolean isS1() {
        return s1;
    }

    public boolean isS2() {
        return s2;
    }

    public boolean isAdministration() {
        return administration;
    }

    public boolean isProfesseur() {
        return professeur;
    }

    public boolean isAjouter() {
        return ajouter;
    }

    public boolean isModifier() {
        return modifier;
    }

    public boolean isSuprimer() {
        return suprimer;
    }

}
