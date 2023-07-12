/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.panel;

import bean.Classe;
import bean.Cycle;
import bean.Eleve;
import bean.EleveClasse;
import bean.EvaluationClasse;
import bean.EvaluationMatiere;
import bean.Matiere;
import bean.MatiereClasse;
import bean.MatiereType;
import bean.Professeur;
import bean.Semestre;
import java.awt.Color;
import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import static main.Main.getConnection;
import static main.Main.getController;
import static main.Main.getDroit;
import static main.Main.getUser;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ATH
 */
public class PrimaireNotePanel extends javax.swing.JPanel {

    public PrimaireNotePanel() {
        if (getDroit().isProfesseur()) {
            Professeur professeur = getController().getProfesseurController().get(getUser().getLogin());
            if (professeur != null) {
                id_professeur = professeur.getId();
            } else {
                id_professeur = 0;
            }
        } else {
            id_professeur = 0;
        }
        model = new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "N°", "Matière", "Note", "Sur"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, true, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        id_matiere_classes = new HashMap<>();
        id_annees = new HashMap<>();
        id_classes = new HashMap<>();
        id_cycles = new HashMap<>();
        id_semestres = new HashMap<>();
        id_type_matieres = new HashMap<>();
        id_eleve_classes = new HashMap<>();
        initComponents();
        popup();
        if (getController().getDroitController().get(getUser().getId()).isProfesseur()) {
            combo_box_annee.setEnabled(false);
            button_bulletin_classe.setEnabled(false);
            menu_item_imprimer.setEnabled(false);
        }
        init_combo_box_annee();
        init_combo_box_cycle();
        init_combo_box_classe();
        init_combo_box_type_matiere();
        init_combo_box_semestre();
        init_combo_box_eleve();
        table_note();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popup_menu = new javax.swing.JPopupMenu();
        menu_item_imprimer = new javax.swing.JMenuItem();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        combo_box_annee = new javax.swing.JComboBox<>();
        combo_box_cycle = new javax.swing.JComboBox<>();
        combo_box_classe = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        combo_box_type_matiere_classe = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        combo_box_eleve = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        combo_box_semestre = new javax.swing.JComboBox<>();
        scroll_pane_table_note = new javax.swing.JScrollPane();
        table_note = new javax.swing.JTable();
        button_bulletin_classe = new javax.swing.JButton();
        btn_actualiser_table = new javax.swing.JButton();
        btn_calculer = new javax.swing.JButton();

        menu_item_imprimer.setText("Imprimer bulletin");
        menu_item_imprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_imprimerActionPerformed(evt);
            }
        });
        popup_menu.add(menu_item_imprimer);

        setPreferredSize(new java.awt.Dimension(952, 550));

        jLabel2.setText("Année scolaire :");

        jLabel3.setText("Cycle :");

        jLabel4.setText("Classe :");

        combo_box_annee.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo_box_annee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_box_anneeActionPerformed(evt);
            }
        });

        combo_box_cycle.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo_box_cycle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_box_cycleActionPerformed(evt);
            }
        });

        combo_box_classe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo_box_classe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_box_classeActionPerformed(evt);
            }
        });

        jLabel7.setText("Type de matière :");

        combo_box_type_matiere_classe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo_box_type_matiere_classe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_box_type_matiere_classeActionPerformed(evt);
            }
        });

        jLabel5.setText("Prénom et Nom :");

        combo_box_eleve.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo_box_eleve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_box_eleveActionPerformed(evt);
            }
        });

        jLabel1.setText("Trimestre :");

        combo_box_semestre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo_box_semestre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_box_semestreActionPerformed(evt);
            }
        });

        table_note.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "N°", "Matière", "Note", "Sur"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scroll_pane_table_note.setViewportView(table_note);
        if (table_note.getColumnModel().getColumnCount() > 0) {
            table_note.getColumnModel().getColumn(0).setPreferredWidth(35);
            table_note.getColumnModel().getColumn(0).setMaxWidth(35);
            table_note.getColumnModel().getColumn(1).setPreferredWidth(400);
            table_note.getColumnModel().getColumn(1).setMaxWidth(500);
            table_note.getColumnModel().getColumn(2).setPreferredWidth(75);
            table_note.getColumnModel().getColumn(2).setMaxWidth(100);
            table_note.getColumnModel().getColumn(3).setPreferredWidth(75);
            table_note.getColumnModel().getColumn(3).setMaxWidth(100);
        }

        button_bulletin_classe.setText("Bulletin classe");
        button_bulletin_classe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_bulletin_classeActionPerformed(evt);
            }
        });

        btn_actualiser_table.setForeground(new java.awt.Color(0, 153, 0));
        btn_actualiser_table.setText("Actualiser la table");
        btn_actualiser_table.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualiser_tableActionPerformed(evt);
            }
        });

        btn_calculer.setText("Calculer note");
        btn_calculer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calculerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scroll_pane_table_note)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(combo_box_cycle, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(combo_box_classe, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(combo_box_annee, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(combo_box_type_matiere_classe, 0, 220, Short.MAX_VALUE)
                                    .addComponent(combo_box_semestre, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(btn_calculer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(combo_box_eleve, 0, 339, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_actualiser_table, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_bulletin_classe))
                        .addContainerGap(35, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(combo_box_type_matiere_classe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_calculer)
                            .addComponent(button_bulletin_classe))
                        .addGap(13, 13, 13)
                        .addComponent(btn_actualiser_table, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(combo_box_annee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(combo_box_cycle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(combo_box_semestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(combo_box_classe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combo_box_eleve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addGap(18, 18, 18)
                .addComponent(scroll_pane_table_note, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void combo_box_anneeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_box_anneeActionPerformed
        init_combo_box_cycle();
        init_combo_box_classe();
        init_combo_box_type_matiere();
        init_combo_box_semestre();
        init_combo_box_eleve();
    }//GEN-LAST:event_combo_box_anneeActionPerformed

    private void combo_box_cycleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_box_cycleActionPerformed
        init_combo_box_classe();
        init_combo_box_type_matiere();
        init_combo_box_semestre();
        init_combo_box_eleve();
    }//GEN-LAST:event_combo_box_cycleActionPerformed

    private void combo_box_classeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_box_classeActionPerformed
        init_combo_box_type_matiere();
        init_combo_box_semestre();
        init_combo_box_eleve();
        table_note();
    }//GEN-LAST:event_combo_box_classeActionPerformed

    private void combo_box_type_matiere_classeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_box_type_matiere_classeActionPerformed
        init_combo_box_eleve();
    }//GEN-LAST:event_combo_box_type_matiere_classeActionPerformed

    private void combo_box_eleveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_box_eleveActionPerformed
        table_note();
    }//GEN-LAST:event_combo_box_eleveActionPerformed

    private void combo_box_semestreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_box_semestreActionPerformed
        table_note();
    }//GEN-LAST:event_combo_box_semestreActionPerformed

    private void menu_item_imprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_imprimerActionPerformed
        int row = combo_box_eleve.getSelectedIndex();
        if (row < 0 || combo_box_semestre.getSelectedIndex() < 0 || combo_box_eleve.getSelectedIndex() < 0 || combo_box_annee.getSelectedIndex() < 0) {
            return;
        }
        Long id_eleve_classe = id_eleve_classes.get(combo_box_eleve.getSelectedIndex());
        Long id_semestre = id_semestres.get(combo_box_semestre.getSelectedIndex());
        EleveClasse eleveClasse = getController().getEleveClasseController().get(id_eleve_classe);
        getBulletin(eleveClasse.getId_eleve(), eleveClasse.getId_classe(), id_semestre);
    }//GEN-LAST:event_menu_item_imprimerActionPerformed

    private void button_bulletin_classeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_bulletin_classeActionPerformed
        if (combo_box_classe.getSelectedIndex() < 0 || combo_box_classe.getSelectedItem().toString().equals("Toutes") || combo_box_semestre.getSelectedIndex() < 0 || table_note.getRowCount() < 1) {
            return;
        }
        if (combo_box_semestre.getSelectedIndex() < 0 || combo_box_eleve.getSelectedIndex() < 0 || combo_box_annee.getSelectedIndex() < 0) {
            return;
        }
        Long id_classe = id_classes.get(combo_box_classe.getSelectedIndex());
        Long id_semestre = id_semestres.get(combo_box_semestre.getSelectedIndex());
        getBulletin(null, id_classe, id_semestre);
    }//GEN-LAST:event_button_bulletin_classeActionPerformed

    private void btn_actualiser_tableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualiser_tableActionPerformed
        table_note();
    }//GEN-LAST:event_btn_actualiser_tableActionPerformed

    private void btn_calculerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calculerActionPerformed
        calculer();
    }//GEN-LAST:event_btn_calculerActionPerformed
    private final HashMap<Integer, Long> id_matiere_classes, id_annees, id_semestres, id_cycles, id_classes, id_type_matieres, id_eleve_classes;
    private final long id_professeur;
    private final DefaultTableModel model;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_actualiser_table;
    private javax.swing.JButton btn_calculer;
    private javax.swing.JButton button_bulletin_classe;
    private javax.swing.JComboBox<String> combo_box_annee;
    private javax.swing.JComboBox<String> combo_box_classe;
    private javax.swing.JComboBox<String> combo_box_cycle;
    private javax.swing.JComboBox<String> combo_box_eleve;
    private javax.swing.JComboBox<String> combo_box_semestre;
    private javax.swing.JComboBox<String> combo_box_type_matiere_classe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuItem menu_item_imprimer;
    private javax.swing.JPopupMenu popup_menu;
    private javax.swing.JScrollPane scroll_pane_table_note;
    private javax.swing.JTable table_note;
    // End of variables declaration//GEN-END:variables
    private static void addPopup(Component component, final JPopupMenu popup) {
        component.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    showMenu(e);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    showMenu(e);
                }
            }

            private void showMenu(MouseEvent e) {
                popup.show(e.getComponent(), e.getX(), e.getY());
            }
        });
    }

    private void popup() {
        addPopup(scroll_pane_table_note, popup_menu);
        addPopup(table_note, popup_menu);
    }

    private void init_combo_box_annee() {
        combo_box_annee.removeAllItems();
        id_annees.clear();
        try {
            ArrayList<bean.Annee> list = getController().getAnneeController().gets();
            if (list == null || list.isEmpty()) {
                return;
            }
            for (int i = 0; i < list.size(); i++) {
                combo_box_annee.addItem(list.get(i).getAnnee());
                id_annees.put(i, list.get(i).getId());
            }
        } catch (Exception e) {
            combo_box_annee.removeAllItems();
            id_annees.clear();
        }

    }

    private void init_combo_box_cycle() {
        combo_box_cycle.removeAllItems();
        id_cycles.clear();
        try {
            if (combo_box_annee.getSelectedIndex() < 0) {
                return;
            }
            Long id_annee = id_annees.get(combo_box_annee.getSelectedIndex());
            ArrayList<Cycle> list;
            if (getDroit().isProfesseur()) {
                list = getController().getCycleController().gets(id_annee, id_professeur);
            } else {
                list = getController().getCycleController().gets();
            }
            for (int i = 0; i < list.size(); i++) {
                combo_box_cycle.addItem(list.get(i).getCycle());
                id_cycles.put(i, list.get(i).getId());
            }
        } catch (Exception e) {
            combo_box_cycle.removeAllItems();
            id_cycles.clear();
        }
    }

    private void init_combo_box_classe() {
        combo_box_classe.removeAllItems();
        id_classes.clear();
        try {
            if (combo_box_annee.getSelectedIndex() < 0 || combo_box_cycle.getSelectedIndex() < 0) {
                return;
            }
            Long id_annee = id_annees.get(combo_box_annee.getSelectedIndex());
            Long id_cycle = id_cycles.get(combo_box_cycle.getSelectedIndex());
            ArrayList<Classe> list;
            if (getDroit().isProfesseur()) {
                list = getController().getClasseController().gets(id_annee, id_cycle, id_professeur);
            } else {
                list = getController().getClasseController().gets(id_annee, id_cycle);
            }
            for (int i = 0; i < list.size(); i++) {
                combo_box_classe.addItem(list.get(i).getClasse());
                id_classes.put(i, list.get(i).getId());
            }
        } catch (Exception e) {
            combo_box_classe.removeAllItems();
            id_classes.clear();
        }
    }

    private void init_combo_box_type_matiere() {
        combo_box_type_matiere_classe.removeAllItems();
        id_type_matieres.clear();
        if (combo_box_annee.getSelectedIndex() < 0 || combo_box_cycle.getSelectedIndex() < 0 || combo_box_classe.getSelectedIndex() < 0) {
            return;
        }
        try {
            Long id_classe = id_classes.get(combo_box_classe.getSelectedIndex());
            ArrayList<MatiereType> list;
            if (getDroit().isProfesseur()) {
                list = getController().getMatiereTypeController().gets(id_classe, id_professeur);
            } else {
                list = getController().getMatiereTypeController().gets();
            }
            for (int i = 0; i < list.size(); i++) {
                combo_box_type_matiere_classe.addItem(list.get(i).getType());
                id_type_matieres.put(i, list.get(i).getId());
            }
        } catch (Exception e) {
            combo_box_type_matiere_classe.removeAllItems();
            id_type_matieres.clear();
        }
    }

    private void init_combo_box_semestre() {
        combo_box_semestre.removeAllItems();
        id_semestres.clear();
        ArrayList<Semestre> list = getController().getSemestreController().gets();
        if (list == null) {
            return;
        }
        try {
            for (int i = 0; i < list.size(); i++) {
                combo_box_semestre.addItem(list.get(i).getSemestre());
                id_semestres.put(i, list.get(i).getId());
            }
        } catch (Exception e) {
            combo_box_semestre.removeAllItems();
            id_semestres.clear();
        }
    }

    private void init_combo_box_eleve() {
        combo_box_eleve.removeAllItems();
        id_eleve_classes.clear();
        if (combo_box_annee.getSelectedIndex() < 0 || combo_box_classe.getSelectedIndex() < 0) {
            return;
        }
        try {
            Long id_annee = id_annees.get(combo_box_annee.getSelectedIndex());
            Long id_cycle = id_cycles.get(combo_box_cycle.getSelectedIndex());
            Long id_classe = id_classes.get(combo_box_classe.getSelectedIndex());
            ArrayList<EleveClasse> list = getController().getEleveClasseController().gets(null, id_annee, id_cycle, id_classe, null, null, null);
            for (int i = 0; i < list.size(); i++) {
                EleveClasse eleveClasse = list.get(i);
                Eleve eleve = getController().getEleveController().get(eleveClasse.getId_eleve());
                combo_box_eleve.addItem(eleve.getNom_prenom());
                id_eleve_classes.put(i, eleveClasse.getId());
            }
        } catch (Exception e) {
            combo_box_eleve.removeAllItems();
            id_eleve_classes.clear();
        }
    }

    private void init_model() {
        model.setRowCount(0);
    }

    private void table_note() {
        init_model();
        id_matiere_classes.clear();
        if (combo_box_annee.getSelectedIndex() < 0 || combo_box_classe.getSelectedIndex() < 0 || combo_box_eleve.getSelectedIndex() < 0 || combo_box_semestre.getSelectedIndex() < 0) {
            return;
        }
        try {
            Long id_semestre = id_semestres.get(combo_box_semestre.getSelectedIndex());
            Long id_eleve_classe = id_eleve_classes.get(combo_box_eleve.getSelectedIndex());
            EleveClasse eleveClasse = getController().getEleveClasseController().get(id_eleve_classe);
            ArrayList<MatiereClasse> list;
            if (getDroit().isProfesseur()) {
                list = getController().getMatiereClasseController().gets(null, null, eleveClasse.getId_classe(), null, id_professeur);
            } else {
                list = getController().getMatiereClasseController().gets(null, null, eleveClasse.getId_classe(), null);
            }
            for (int i = 0; i < list.size(); i++) {
                EvaluationMatiere evaluationMatiere = getController().getPrimaireEvaluationMatiereController().get(eleveClasse.getId_eleve(), list.get(i).getId(), id_semestre);
                Object row[] = new Object[4];
                row[0] = i + 1;
                row[1] = getController().getMatiereController().get(list.get(i).getId_matiere()).getMatiere();
                if (evaluationMatiere != null) {
                    row[2] = evaluationMatiere.getComposition() > -1.00 ? evaluationMatiere.getComposition() : "";
                } else {
                    row[2] = "";
                }
                row[3] = 5 * list.get(i).getCoefficient();
                id_matiere_classes.put(i, list.get(i).getId());
                model.addRow(row);
            }
            table_note.setModel(model);
            if (table_note.getColumnModel().getColumnCount() > 0) {
                table_note.getColumnModel().getColumn(0).setPreferredWidth(35);
                table_note.getColumnModel().getColumn(0).setMaxWidth(35);
                table_note.getColumnModel().getColumn(1).setPreferredWidth(400);
                table_note.getColumnModel().getColumn(1).setMaxWidth(500);
                table_note.getColumnModel().getColumn(2).setPreferredWidth(75);
                table_note.getColumnModel().getColumn(2).setMaxWidth(100);
                table_note.getColumnModel().getColumn(3).setPreferredWidth(75);
                table_note.getColumnModel().getColumn(3).setMaxWidth(100);
                table_note.setShowVerticalLines(true);
                table_note.setShowHorizontalLines(true);
                table_note.setGridColor(Color.BLACK);
                table_note.setRowHeight(30);
                table_note.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                table_note.getModel().addTableModelListener((TableModelEvent e) -> {
                    try {
                        int row = table_note.getSelectedRow();
                        if (row < 0) {
                            return;
                        }
                        int column = table_note.getSelectedColumn();
                        mise_a_jour_note(row, table_note.getValueAt(row, column).toString());
                    } catch (Exception ex) {
                    }
                });
            }
        } catch (Exception e) {
        }
    }

    private void mise_a_jour_note(int row, String valeur_string) {
        try {
            if (combo_box_semestre.getSelectedIndex() < 0 || combo_box_eleve.getSelectedIndex() < 0) {
                return;
            }
            Long id_eleve_classe = id_eleve_classes.get(combo_box_eleve.getSelectedIndex());
            Long id_semestre = id_semestres.get(combo_box_semestre.getSelectedIndex());
            Long id_matiere_classe = id_matiere_classes.get(row);
            EleveClasse eleveClasse = getController().getEleveClasseController().get(id_eleve_classe);
            EvaluationMatiere evaluationMatiere = getController().getPrimaireEvaluationMatiereController().get(eleveClasse.getId_eleve(), id_matiere_classe, id_semestre);
            MatiereClasse matiereClasse = getController().getMatiereClasseController().get(id_matiere_classe);
            /*
        *supression d'une note
             */
            if (valeur_string.isEmpty() && evaluationMatiere != null) {
                switch (combo_box_semestre.getSelectedItem().toString()) {
                    case "1er Trimestre" -> {
                        if (!getDroit().isS1()) {
                            JOptionPane.showMessageDialog(this, "Contacter l'administration pour cette action.", "Droit de saisie 1er Trimestre réquis ", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                    }
                    case "2e Trimestre" -> {
                        if (!getDroit().isS2()) {
                            JOptionPane.showMessageDialog(this, "Contacter l'administration pour cette action.", "Droit de saisie 2e Trimestre réquis ", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                    }
                    case "3e Trimestre" -> {
                        if (!getDroit().isS3()) {
                            JOptionPane.showMessageDialog(this, "Contacter l'administration pour cette action.", "Droit de saisie 2e Trimestre réquis ", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                    }
                    default -> {
                        JOptionPane.showMessageDialog(this, "Contacter l'administration pour cette action.", "Droit de saisie 1er Trimestre réquis ", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                }
                if (!getDroit().isSuprimer() && evaluationMatiere.getComposition() != -1.00) {
                    JOptionPane.showMessageDialog(this, "Contacter l'administration pour cette action.", "Droit de supression réquis ", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                getController().getPrimaireEvaluationMatiereController().remove(eleveClasse.getId_eleve(), id_matiere_classe, id_semestre, "composition");
                return;
            } else if (valeur_string.isEmpty() && evaluationMatiere == null) {
                return;
            }
            /*
        * fin supression d'une note
        *                   Ajout et modification d'une note
             */
            double valeur;
            try {
                valeur = Double.parseDouble(valeur_string);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Valeur incorrect !\nSaisissez uniquement des chiffres !\nMettre un point a la place de virgule.", "Valeur incorrecte ", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            if ((valeur < 0.00 || valeur > 5 * matiereClasse.getCoefficient())) {
                JOptionPane.showMessageDialog(this, "Note incorrect !\nLa note doit être incluse entre 0 et " + 5 * matiereClasse.getCoefficient() + "!", "Note incorrecte ", JOptionPane.INFORMATION_MESSAGE);
                //table_note();
                return;
            }
            if (evaluationMatiere == null) {
                switch (combo_box_semestre.getSelectedItem().toString()) {
                    case "1er Trimestre" -> {
                        if (!getDroit().isS1()) {
                            JOptionPane.showMessageDialog(this, "Contacter l'administration pour cette action.", "Droit de saisie pour 1er Trimestre réquis ", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                    }
                    case "2e Trimestre" -> {
                        if (!getDroit().isS2()) {
                            JOptionPane.showMessageDialog(this, "Contacter l'administration pour cette action.", "Droit de saisie pour 2e Trimestre réquis ", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                    }
                    case "3e Trimestre" -> {
                        if (!getDroit().isS3()) {
                            JOptionPane.showMessageDialog(this, "Contacter l'administration pour cette action.", "Droit de saisie pour 3e Trimestre réquis ", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                    }
                    default -> {
                        JOptionPane.showMessageDialog(this, "Contacter l'administration pour cette action.", "Droit de saisie Semestre réquis ", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                }
                if (!getDroit().isAjouter()) {
                    JOptionPane.showMessageDialog(this, "Contacter l'administration pour cette action.", "Droit d'ajout réquis ", JOptionPane.INFORMATION_MESSAGE);
                    //table_note();
                    return;
                }
            }
            switch (combo_box_semestre.getSelectedItem().toString()) {
                case "1er Trimestre" -> {
                    if (!getDroit().isS1()) {
                        JOptionPane.showMessageDialog(this, "Contacter l'administration pour cette action.", "Droit de saisie pour 1er Trimestre réquis ", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                }
                case "2e Trimestre" -> {
                    if (!getDroit().isS2()) {
                        JOptionPane.showMessageDialog(this, "Contacter l'administration pour cette action.", "Droit de saisie pour 2e Trimestre réquis ", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                }
                case "3e Trimestre" -> {
                    if (!getDroit().isS3()) {
                        JOptionPane.showMessageDialog(this, "Contacter l'administration pour cette action.", "Droit de saisie pour 3e Trimestre réquis ", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                }
                default -> {
                    JOptionPane.showMessageDialog(this, "Contacter l'administration pour cette action.", "Droit de saisie Trimestre réquis ", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            }
            if (evaluationMatiere == null) {
                if (!getDroit().isAjouter()) {
                    JOptionPane.showMessageDialog(this, "Contacter l'administration pour cette action.", "Droit d'ajout réquis ", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            } else {
                if (!getDroit().isAjouter() && (evaluationMatiere.getComposition() == -1.00)) {
                    JOptionPane.showMessageDialog(this, "Contacter l'administration pour cette action.", "Droit d'ajout réquis ", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                if (!getDroit().isModifier() && (evaluationMatiere.getComposition() != -1.00)) {
                    JOptionPane.showMessageDialog(this, "Contacter l'administration pour cette action.", "Droit d'ajout réquis ", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            }
            getController().getPrimaireEvaluationMatiereController().add(eleveClasse.getId_eleve(), id_matiere_classe, id_semestre, "composition", valeur);
        } catch (HeadlessException | NullPointerException e) {
        }
        if (combo_box_eleve.getSelectedIndex() == combo_box_eleve.getItemCount() - 1 && row == table_note.getRowCount() - 1) {
            System.out.println("eleve " + combo_box_eleve.getSelectedIndex() + " total " + (combo_box_eleve.getItemCount() - 1));
            System.out.println("row " + row + " total " + (table_note.getRowCount() - 1));
            calculer();
            table_note();
        }
    }

    public void getBulletin(Long id_eleve, Long id_classe, Long id_semestre) {
        ArrayList<EvaluationClasse> list = getController().getPrimaireEvaluationClasseController().gets(id_eleve, id_classe, id_semestre);
        try {
            if (list.isEmpty()) {
                return;
            }
            HashMap<String, Object> m = new HashMap<>();
            String reports = System.getProperty("user.dir") + "\\ressources\\report\\Bulletin_primaire.jasper";
            m.put("id_classe", id_classe);
            m.put("id_semestre", id_semestre);
            m.put("id_eleve", list.get(0).getId_eleve());
            JasperPrint jasperPrint = JasperFillManager.fillReport(reports, m, getConnection());
            if (list.size() > 1) {
                for (int i = 1; i < list.size(); i++) {
                    HashMap<String, Object> mp = new HashMap<>();
                    mp.put("id_classe", id_classe);
                    mp.put("id_semestre", id_semestre);
                    mp.put("id_eleve", list.get(i).getId_eleve());
                    try {
                        JasperPrint jasperPrint1 = JasperFillManager.fillReport(reports, mp, getConnection());
                        jasperPrint.addPage(jasperPrint1.getPages().get(0));
                    } catch (JRException ex) {
                        Logger.getLogger(PrimaireNotePanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException | IndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(null, " Echec d'impression du Rélévé de note\n" + ex.getMessage());
        }
    }

    private void calculer() {
        if (combo_box_annee.getSelectedIndex() < 0 || combo_box_cycle.getSelectedIndex() < 0 || combo_box_classe.getSelectedIndex() < 0 || combo_box_semestre.getSelectedIndex() < 0) {
            return;
        }
        Long id_cycle = id_cycles.get(combo_box_cycle.getSelectedIndex());
        Long id_classe = id_classes.get(combo_box_classe.getSelectedIndex());
        Long id_semestre = id_semestres.get(combo_box_semestre.getSelectedIndex());
        getController().getMatiereClasseController().gets(null, null, id_classe, id_cycle).forEach((matiereClasse) -> {
            Matiere matiere = getController().getMatiereController().get(matiereClasse.getId_matiere());
            getController().getPrimaireEvaluationMatiereController().update_coefficient(matiereClasse.getId());
            getController().getEleveClasseController().gets(null, null, id_cycle, id_classe, null, null, null).forEach((ec) -> {
                getController().getPrimaireEvaluationMatiereController().update(ec.getId_eleve(), matiereClasse.getId(), id_semestre);
                getController().getPrimaireEvaluationMatiereTypeController().update(ec.getId_eleve(), id_classe, matiere.getId_matiere_type(), id_semestre);
                getController().getPrimaireEvaluationClasseController().update(ec.getId_eleve(), id_classe, id_semestre);
            });
            getController().getPrimaireEvaluationMatiereController().update(matiereClasse.getId(), id_semestre);
        });
        getController().getMatiereTypeController().gets().forEach((matiereType) -> {
            getController().getPrimaireEvaluationMatiereTypeController().update(id_classe, matiereType.getId(), id_semestre);
        });
        getController().getPrimaireEvaluationClasseController().update(id_classe, id_semestre);
        JOptionPane.showMessageDialog(this, "Opération effectuée avec success ", "Réussie !", JOptionPane.INFORMATION_MESSAGE);
    }

}
