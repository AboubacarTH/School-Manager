/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import bean.Droit;
import bean.User;
import com.formdev.flatlaf.FlatLightLaf;
import controller.Controller;
import database.ConnectorDB;
import database.ConnectorLite;
import java.sql.Connection;
import javax.swing.UIManager;
import view.dialog.LoginDialog;
import view.frame.ConfigForm;

/**
 *
 * @author ATH
 */
public class Main {

    private static Connection connectionLite;
    private static Connection connection;
    private static Controller controller;
    private static User user;
    private static Droit droit;
    //private static final String PATH = "C://Geschool/";
    private static final String LOGIN = "admin", PASSWORD = "2379";
    private static boolean can_remove = false, primaire = false;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FlatLightLaf.setup();
        UIManager.put("Component.arrowType", "triangle");
        UIManager.put("Button.arc", 000);
        UIManager.put("Component.arc", 0);
        UIManager.put("ProgressBar.arc", 999);
        UIManager.put("TextComponent.arc", 0);
        connectionLite = new ConnectorLite().getConnection();
        connection = new ConnectorDB(connectionLite).getConnection();
        controller = new Controller(connection);
        if (getController().getUserController().isEmpty()) {
            getController().getUserController().add("Geschool", LOGIN, PASSWORD);
            user = getController().getUserController().get(LOGIN, PASSWORD);
            getController().getDroitController().add(user.getId(), true, false, true, true, true, true, true, true);
            droit = getController().getDroitController().get(user.getId());
        } else {
//            production
//            user = getController().getUserController().get(LOGIN, PASSWORD);
//            droit = getController().getDroitController().get(user.getId());
            LoginDialog loginDialog = new LoginDialog(null, true);
            loginDialog.setVisible(true);
        }
        if (user != null && droit != null) {
            getController().getJournalController().add(user.getId(), new java.util.Date());
            ConfigForm configForm = new ConfigForm();
            configForm.setVisible(true);
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static Connection getConnectionLite() {
        return connectionLite;
    }

    public static Controller getController() {
        return controller;
    }

    public static User getUser() {
        return user;
    }

    public static Droit getDroit() {
        return droit;
    }

    public static void setDroit(Droit droit) {
        Main.droit = droit;
    }

    public static void setUser(User user) {
        Main.user = user;
    }

//    public static String getPATH() {
//        return PATH;
//    }
    public static boolean isCan_remove() {
        return can_remove;
    }

    public static void setCan_remove(boolean can_remove) {
        Main.can_remove = can_remove;
    }

    public static boolean isPrimaire() {
        return primaire;
    }

    public static void setPrimaire(boolean primaire) {
        Main.primaire = primaire;
    }
}
