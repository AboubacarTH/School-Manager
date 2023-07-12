/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import java.sql.Timestamp;

/**
 *
 * @author ATH
 */
public class Journal {

    private final Long id, id_user;
    private final Timestamp date;

    public Journal(Long id, Long id_user, Timestamp date) {
        this.id = id;
        this.id_user = id_user;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public Long getId_user() {
        return id_user;
    }

    public Timestamp getDate() {
        return date;
    }

}
