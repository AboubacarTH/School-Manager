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
public class Eleve {

    private final Long id, id_nationalite;
    private final String matricule, nom_prenom, lieu_de_naissance, contact, sexe, qr_code, photo;
    private final Date date_de_naissance;
    private final int numero_table;

    public Eleve(Long id, Long id_nationalite, String matricule, String nom_prenom, Date date_de_naissance, String lieu_de_naissance, String contact, String sexe, String qr_code, String photo, int numero_table) {
        this.id = id;
        this.id_nationalite = id_nationalite;
        this.matricule = matricule;
        this.nom_prenom = nom_prenom;
        this.date_de_naissance = date_de_naissance;
        this.lieu_de_naissance = lieu_de_naissance;
        this.contact = contact;
        this.sexe = sexe;
        this.qr_code = qr_code;
        this.photo = photo;
        this.numero_table = numero_table;
    }

    public Long getId() {
        return id;
    }

    public Long getId_nationalite() {
        return id_nationalite;
    }

    public String getMatricule() {
        return matricule;
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

    public String getSexe() {
        return sexe;
    }

    public String getQr_code() {
        return qr_code;
    }

    public String getPhoto() {
        return photo;
    }

    public int getNumero_table() {
        return numero_table;
    }

}
