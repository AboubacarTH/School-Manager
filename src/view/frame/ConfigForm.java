/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.frame;

import javax.swing.JOptionPane;
import static main.Main.getController;
import static main.Main.getDroit;
import static main.Main.getUser;
import static main.Main.isPrimaire;
import static main.Main.setDroit;
import static main.Main.setUser;
import view.dialog.AdresseDialog;
import view.dialog.LoginDialog;
import view.panel.AbsenceRetardPanel;
import view.panel.ClassePanel;
import view.panel.ComptePanel;
import view.panel.ConfigPanel;
import view.panel.ElevePanel;
import view.panel.MatierePanel;
import view.panel.NotePanel;
import view.panel.PrimaireComptePanel;
import view.panel.PrimaireNotePanel;
import view.panel.ProfesseurPanel;
import view.panel.ScolaritePanel;

/**
 *
 * @author ATH
 */
public class ConfigForm extends javax.swing.JFrame {

    /**
     * Creates new form ConfigForm
     */
    public ConfigForm() {
        initComponents();
        if (isPrimaire()) {
            menu_item_comptes.setVisible(false);
            menu_item_gestion_note.setVisible(false);
        } else {
            menu_item_comptes_primaire.setVisible(false);
            menu_item_gestion_note_primaire.setVisible(false);
        }
        if (getDroit().isProfesseur() && !getDroit().isAdministration()) {
            setProfesseurProfil();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        menu_fichier = new javax.swing.JMenu();
        menu_item_mon_compte = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        menu_item_se_deconnecter = new javax.swing.JMenuItem();
        menu_item_quitter = new javax.swing.JMenuItem();
        menu_edition = new javax.swing.JMenu();
        menu_item_eleve = new javax.swing.JMenuItem();
        menu_item_enseignant = new javax.swing.JMenuItem();
        menuItem_classe = new javax.swing.JMenuItem();
        menu_item_matiere = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menu_item_gestion_note = new javax.swing.JMenuItem();
        menu_item_gestion_note_primaire = new javax.swing.JMenuItem();
        menu_sanction = new javax.swing.JMenu();
        menuItem_absence_retard = new javax.swing.JMenuItem();
        menu_comptabilite = new javax.swing.JMenu();
        menuItem_scolarite = new javax.swing.JMenuItem();
        menu_parametre = new javax.swing.JMenu();
        menu_item_comptes = new javax.swing.JMenuItem();
        menu_item_comptes_primaire = new javax.swing.JMenuItem();
        menu_item_configuration_de_base = new javax.swing.JMenuItem();
        menu_item_serveur_principal = new javax.swing.JMenuItem();
        menu_help = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tableau de bord");
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/water.jpg"))); // NOI18N

        menu_fichier.setText("Fichier");

        menu_item_mon_compte.setText("Mon compte");
        menu_fichier.add(menu_item_mon_compte);
        menu_fichier.add(jSeparator2);

        menu_item_se_deconnecter.setText("Se Déconnecter");
        menu_item_se_deconnecter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_se_deconnecterActionPerformed(evt);
            }
        });
        menu_fichier.add(menu_item_se_deconnecter);

        menu_item_quitter.setText("Quitter");
        menu_item_quitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_quitterActionPerformed(evt);
            }
        });
        menu_fichier.add(menu_item_quitter);

        menuBar.add(menu_fichier);

        menu_edition.setText("Edition");

        menu_item_eleve.setText("Elève");
        menu_item_eleve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_eleveActionPerformed(evt);
            }
        });
        menu_edition.add(menu_item_eleve);

        menu_item_enseignant.setText("Enseignant");
        menu_item_enseignant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_enseignantActionPerformed(evt);
            }
        });
        menu_edition.add(menu_item_enseignant);

        menuItem_classe.setText("Classe");
        menuItem_classe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_classeActionPerformed(evt);
            }
        });
        menu_edition.add(menuItem_classe);

        menu_item_matiere.setText("Matière");
        menu_item_matiere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_matiereActionPerformed(evt);
            }
        });
        menu_edition.add(menu_item_matiere);
        menu_edition.add(jSeparator1);

        menu_item_gestion_note.setText("Gestion des notes");
        menu_item_gestion_note.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_gestion_noteActionPerformed(evt);
            }
        });
        menu_edition.add(menu_item_gestion_note);

        menu_item_gestion_note_primaire.setText("Gestion des notes");
        menu_item_gestion_note_primaire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_gestion_note_primaireActionPerformed(evt);
            }
        });
        menu_edition.add(menu_item_gestion_note_primaire);

        menuBar.add(menu_edition);

        menu_sanction.setText("Sanction");

        menuItem_absence_retard.setText("Absence et retard");
        menuItem_absence_retard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_absence_retardActionPerformed(evt);
            }
        });
        menu_sanction.add(menuItem_absence_retard);

        menuBar.add(menu_sanction);

        menu_comptabilite.setText("Comptabilité");

        menuItem_scolarite.setText("Scolarité");
        menuItem_scolarite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_scolariteActionPerformed(evt);
            }
        });
        menu_comptabilite.add(menuItem_scolarite);

        menuBar.add(menu_comptabilite);

        menu_parametre.setText("Paramètre");

        menu_item_comptes.setText("Comptes");
        menu_item_comptes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_comptesActionPerformed(evt);
            }
        });
        menu_parametre.add(menu_item_comptes);

        menu_item_comptes_primaire.setText("Comptes");
        menu_item_comptes_primaire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_comptes_primaireActionPerformed(evt);
            }
        });
        menu_parametre.add(menu_item_comptes_primaire);

        menu_item_configuration_de_base.setText("Configuration de base");
        menu_item_configuration_de_base.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_configuration_de_baseActionPerformed(evt);
            }
        });
        menu_parametre.add(menu_item_configuration_de_base);

        menu_item_serveur_principal.setText("Serveur principal");
        menu_item_serveur_principal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_serveur_principalActionPerformed(evt);
            }
        });
        menu_parametre.add(menu_item_serveur_principal);

        menuBar.add(menu_parametre);

        menu_help.setText("Help");
        menuBar.add(menu_help);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 627, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menu_item_eleveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_eleveActionPerformed
        this.setContentPane(new ElevePanel());
        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_menu_item_eleveActionPerformed

    private void menu_item_enseignantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_enseignantActionPerformed
        this.setContentPane(new ProfesseurPanel());
        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_menu_item_enseignantActionPerformed

    private void menu_item_matiereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_matiereActionPerformed
        this.setContentPane(new MatierePanel());
        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_menu_item_matiereActionPerformed

    private void menu_item_gestion_noteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_gestion_noteActionPerformed
        this.setContentPane(new NotePanel());
        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_menu_item_gestion_noteActionPerformed

    private void menu_item_configuration_de_baseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_configuration_de_baseActionPerformed
        this.setContentPane(new ConfigPanel());
        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_menu_item_configuration_de_baseActionPerformed

    private void menuItem_classeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_classeActionPerformed
        this.setContentPane(new ClassePanel());
        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_menuItem_classeActionPerformed

    private void menu_item_serveur_principalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_serveur_principalActionPerformed
        AdresseDialog adresseDialog = new AdresseDialog(null, true);
        adresseDialog.setVisible(true);
        System.exit(0);
    }//GEN-LAST:event_menu_item_serveur_principalActionPerformed

    private void menu_item_quitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_quitterActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menu_item_quitterActionPerformed

    private void menu_item_comptesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_comptesActionPerformed
        this.setContentPane(new ComptePanel());
        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_menu_item_comptesActionPerformed

    private void menu_item_se_deconnecterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_se_deconnecterActionPerformed
        int choice = JOptionPane.showConfirmDialog(this, "Etes vous sure de vouloir vous déconnecter ? ", "Déconnexion", JOptionPane.YES_NO_OPTION);
        if (choice == 0) {
            setUser(null);
            setDroit(null);
            this.setVisible(false);
            LoginDialog loginDialog = new LoginDialog(null, true);
            loginDialog.setVisible(true);
            if (getUser() != null) {
                if (getController().getDroitController().get(getUser().getId()) == null) {
                    getController().getDroitController().add(getUser().getId(), true, true, true, true, true, false, false, false);
                }
                getController().getJournalController().add(getUser().getId(), new java.util.Date());
                if (getDroit() == null) {
                    System.exit(0);
                }
                ConfigForm configForm = new ConfigForm();
                configForm.setVisible(true);
            }
        }

    }//GEN-LAST:event_menu_item_se_deconnecterActionPerformed

    private void menuItem_scolariteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_scolariteActionPerformed
        this.setContentPane(new ScolaritePanel());
        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_menuItem_scolariteActionPerformed

    private void menuItem_absence_retardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_absence_retardActionPerformed
        this.setContentPane(new AbsenceRetardPanel());
        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_menuItem_absence_retardActionPerformed

    private void menu_item_gestion_note_primaireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_gestion_note_primaireActionPerformed
        this.setContentPane(new PrimaireNotePanel());
        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_menu_item_gestion_note_primaireActionPerformed

    private void menu_item_comptes_primaireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_comptes_primaireActionPerformed
        this.setContentPane(new PrimaireComptePanel());
        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_menu_item_comptes_primaireActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ConfigForm().setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuItem_absence_retard;
    private javax.swing.JMenuItem menuItem_classe;
    private javax.swing.JMenuItem menuItem_scolarite;
    private javax.swing.JMenu menu_comptabilite;
    private javax.swing.JMenu menu_edition;
    private javax.swing.JMenu menu_fichier;
    private javax.swing.JMenu menu_help;
    private javax.swing.JMenuItem menu_item_comptes;
    private javax.swing.JMenuItem menu_item_comptes_primaire;
    private javax.swing.JMenuItem menu_item_configuration_de_base;
    private javax.swing.JMenuItem menu_item_eleve;
    private javax.swing.JMenuItem menu_item_enseignant;
    private javax.swing.JMenuItem menu_item_gestion_note;
    private javax.swing.JMenuItem menu_item_gestion_note_primaire;
    private javax.swing.JMenuItem menu_item_matiere;
    private javax.swing.JMenuItem menu_item_mon_compte;
    private javax.swing.JMenuItem menu_item_quitter;
    private javax.swing.JMenuItem menu_item_se_deconnecter;
    private javax.swing.JMenuItem menu_item_serveur_principal;
    private javax.swing.JMenu menu_parametre;
    private javax.swing.JMenu menu_sanction;
    // End of variables declaration//GEN-END:variables
    private void setProfesseurProfil() {
        menu_edition.setEnabled(false);
        menu_sanction.setEnabled(false);
        menu_comptabilite.setEnabled(false);
        menu_parametre.setEnabled(false);
        if (isPrimaire()) {
            this.setContentPane(new PrimaireNotePanel());
        } else {
            this.setContentPane(new NotePanel());
        }
        this.revalidate();
        this.repaint();

    }
}
