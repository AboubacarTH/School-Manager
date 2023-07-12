/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

/**
 *
 * @author ATH
 */
public class User {

    private final Long id;
    private final String nom_prenom, login, password;

    public User(Long id, String nom_prenom, String login, String password) {
        this.id = id;
        this.nom_prenom = nom_prenom;
        this.login = login;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getNom_prenom() {
        return nom_prenom;
    }

}
