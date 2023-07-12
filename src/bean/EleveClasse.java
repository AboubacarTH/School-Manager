/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

/**
 *
 * @author Toukou Habi
 */
public class EleveClasse {

    private final Long id, id_eleve, id_classe;

    public EleveClasse(Long id, Long id_eleve, Long id_classe) {
        this.id = id;
        this.id_eleve = id_eleve;
        this.id_classe = id_classe;
    }

    public Long getId() {
        return id;
    }

    public Long getId_eleve() {
        return id_eleve;
    }

    public Long getId_classe() {
        return id_classe;
    }

}
