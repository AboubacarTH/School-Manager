/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.sql.Date;

/**
 *
 * @author ATH
 */
public class Professeur {

    private final Long id, id_nationalite;
    private final String matricule, nom_prenom, lieu_de_naissance, contact, titre, diplome, mot_de_passe, sexe;
    private final Date date_de_naissance;

    private final boolean etat;

    public Professeur(Long id, String matricule, Long id_nationalite, String nom_prenom, Date date_de_naissance, String lieu_de_naissance, String contact, String titre, String diplome, boolean etat, String mot_de_passe, String sexe) {
        this.id = id;
        this.matricule = matricule;
        this.id_nationalite = id_nationalite;
        this.nom_prenom = nom_prenom;
        this.date_de_naissance = date_de_naissance;
        this.lieu_de_naissance = lieu_de_naissance;
        this.contact = contact;
        this.titre = titre;
        this.diplome = diplome;
        this.etat = etat;
        this.mot_de_passe = mot_de_passe;
        this.sexe = sexe;
    }

    public Long getId() {
        return id;
    }

    public String getMatricule() {
        return matricule;
    }

    public Long getId_nationalite() {
        return id_nationalite;
    }

    public String getNom_prenom() {
        return nom_prenom;
    }

    public Date getDate_de_naissance() {
        return date_de_naissance;
    }

    public String getLieu_de_naissance() {
        return lieu_de_naissance;
    }

    public String getContact() {
        return contact;
    }

    public String getTitre() {
        return titre;
    }

    public String getDiplome() {
        return diplome;
    }

    public boolean isEtat() {
        return etat;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public String getSexe() {
        return sexe;
    }

}
