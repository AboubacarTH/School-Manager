/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.frame;

import bean.Absence;
import bean.Annee;
import bean.Classe;
import bean.Cycle;
import bean.Eleve;
import bean.EleveClasse;
import bean.Retard;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import static main.Main.getController;

/**
 *
 * @author ATH
 */
public class AbsenceRetardForm extends javax.swing.JFrame {

    /**
     * Creates new form RetardForm
     */
    public AbsenceRetardForm() {
        id_annees = new HashMap<>();
        id_cycles = new HashMap<>();
        id_classes = new HashMap<>();
        id_table_absences = new HashMap<>();
        id_table_retards = new HashMap<>();
        initComponents();
        init_combo_box_annee();
        init_combo_box_cycle();
        init_combo_box_classe();
        table_absence();
        table_retard();
        popup();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popup_menu = new javax.swing.JPopupMenu();
        menu_item_detail = new javax.swing.JMenuItem();
        menu_item_contacter = new javax.swing.JMenuItem();
        menu_item_retirer = new javax.swing.JMenuItem();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_absence = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_retard = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        combo_box_annee = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        combo_box_cycle = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        combo_box_classe = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        date_chooser = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        text_field_rechercher = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        menu_item_detail.setText("Voir détail");
        menu_item_detail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_detailActionPerformed(evt);
            }
        });
        popup_menu.add(menu_item_detail);

        menu_item_contacter.setText("Contacter le parent ou tuteur");
        menu_item_contacter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_contacterActionPerformed(evt);
            }
        });
        popup_menu.add(menu_item_contacter);

        menu_item_retirer.setText("Retirer");
        menu_item_retirer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_retirerActionPerformed(evt);
            }
        });
        popup_menu.add(menu_item_retirer);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Absence - Retard");
        setMinimumSize(new java.awt.Dimension(1000, 558));
        setResizable(false);

        table_absence.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "N°", "Cycle", "Classe", "Matricule", "Nom prénom", "Date", "Observation"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table_absence);
        if (table_absence.getColumnModel().getColumnCount() > 0) {
            table_absence.getColumnModel().getColumn(0).setMinWidth(35);
            table_absence.getColumnModel().getColumn(0).setPreferredWidth(35);
            table_absence.getColumnModel().getColumn(0).setMaxWidth(35);
            table_absence.getColumnModel().getColumn(1).setPreferredWidth(100);
            table_absence.getColumnModel().getColumn(2).setPreferredWidth(100);
            table_absence.getColumnModel().getColumn(3).setPreferredWidth(100);
            table_absence.getColumnModel().getColumn(5).setPreferredWidth(100);
            table_absence.getColumnModel().getColumn(6).setPreferredWidth(300);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1078, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Absences", jPanel1);

        table_retard.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "N°", "Cycle", "Classe", "Matricule", "Nom prénom", "Date", "Observation"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(table_retard);
        if (table_retard.getColumnModel().getColumnCount() > 0) {
            table_retard.getColumnModel().getColumn(0).setMinWidth(35);
            table_retard.getColumnModel().getColumn(0).setPreferredWidth(35);
            table_retard.getColumnModel().getColumn(0).setMaxWidth(35);
            table_retard.getColumnModel().getColumn(1).setPreferredWidth(100);
            table_retard.getColumnModel().getColumn(2).setPreferredWidth(100);
            table_retard.getColumnModel().getColumn(3).setPreferredWidth(100);
            table_retard.getColumnModel().getColumn(5).setPreferredWidth(100);
            table_retard.getColumnModel().getColumn(6).setPreferredWidth(300);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1078, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Retard", jPanel4);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Année :");

        combo_box_annee.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo_box_annee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_box_anneeActionPerformed(evt);
            }
        });

        jLabel6.setText("Cycle :");

        combo_box_cycle.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo_box_cycle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_box_cycleActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Classe :");

        combo_box_classe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo_box_classe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_box_classeActionPerformed(evt);
            }
        });

        jLabel2.setText("Date :");

        date_chooser.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                date_chooserPropertyChange(evt);
            }
        });

        jLabel4.setText("Rechercher :");

        text_field_rechercher.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                text_field_rechercherKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combo_box_annee, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(combo_box_cycle, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(combo_box_classe, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(date_chooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_field_rechercher, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(combo_box_annee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(combo_box_cycle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(date_chooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(combo_box_classe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(text_field_rechercher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jButton1.setText("Nouveau");

        jButton2.setText("Mettre à jour");

        jButton3.setText("Supprimer");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTabbedPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menu_item_retirerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_retirerActionPerformed
        retirer();
    }//GEN-LAST:event_menu_item_retirerActionPerformed

    private void menu_item_detailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_detailActionPerformed
//        if("Retard".equals(cb_absence_retard.getSelectedItem().toString())){
//            Etudiant e = retardDAO.getRetard((int) jTable_eleve.getValueAt(jTable_eleve.getSelectedRow(), 4)).getEleve();
//            Detail detail = new Detail(this, true, el);
//            detail.setVisible(true);
//        }
//        if("Absence".equals(cb_absence_retard.getSelectedItem().toString())){
//            Eleve el = absenceDAO.getAbsence((int) jTable_eleve.getValueAt(jTable_eleve.getSelectedRow(), 4)).getEleve();
//            Detail detail = new Detail(this, true, el);
//            detail.setVisible(true);
//        }
    }//GEN-LAST:event_menu_item_detailActionPerformed

    private void menu_item_contacterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_contacterActionPerformed
        contacter();
    }//GEN-LAST:event_menu_item_contacterActionPerformed

    private void combo_box_anneeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_box_anneeActionPerformed
        init_combo_box_classe();
    }//GEN-LAST:event_combo_box_anneeActionPerformed

    private void combo_box_cycleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_box_cycleActionPerformed
        init_combo_box_classe();
    }//GEN-LAST:event_combo_box_cycleActionPerformed

    private void combo_box_classeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_box_classeActionPerformed
        table_absence();
        table_retard();
    }//GEN-LAST:event_combo_box_classeActionPerformed

    private void text_field_rechercherKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_field_rechercherKeyReleased
        table_absence();
        table_retard();
    }//GEN-LAST:event_text_field_rechercherKeyReleased

    private void date_chooserPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_date_chooserPropertyChange
        table_absence();
        table_retard();
    }//GEN-LAST:event_date_chooserPropertyChange

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new AbsenceRetardForm().setVisible(true);
        });
    }
    private final HashMap<Integer, Long> id_annees, id_cycles, id_classes, id_table_absences, id_table_retards;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo_box_annee;
    private javax.swing.JComboBox<String> combo_box_classe;
    private javax.swing.JComboBox<String> combo_box_cycle;
    private com.toedter.calendar.JDateChooser date_chooser;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JMenuItem menu_item_contacter;
    private javax.swing.JMenuItem menu_item_detail;
    private javax.swing.JMenuItem menu_item_retirer;
    private javax.swing.JPopupMenu popup_menu;
    private javax.swing.JTable table_absence;
    private javax.swing.JTable table_retard;
    private javax.swing.JTextField text_field_rechercher;
    // End of variables declaration//GEN-END:variables

    private void table_absence() {
        DefaultTableModel model = (DefaultTableModel) table_absence.getModel();
        model.setRowCount(0);
        id_table_absences.clear();
        if (combo_box_annee.getSelectedIndex() < 0 || combo_box_cycle.getSelectedIndex() < 0 || combo_box_classe.getSelectedIndex() < 0) {
            return;
        }
        Long id_annee = id_annees.get(combo_box_annee.getSelectedIndex());
        Long id_classe = id_classes.get(combo_box_classe.getSelectedIndex());
        String rechercher = null;
        Timestamp date = null;
        if (!text_field_rechercher.getText().isEmpty()) {
            rechercher = text_field_rechercher.getText();
        }
        if (date_chooser.getDate() != null) {
            date = new Timestamp(date_chooser.getDate().getTime());
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy à HH:mm:ss");
        ArrayList<bean.Absence> list = getController().getAbsenceController().gets(null, id_annee, id_classe, date, rechercher);
        for (int i = 0; i < list.size(); i++) {
            Object row[] = new Object[7];
            Absence absence = list.get(i);
            EleveClasse eleveClasse = getController().getEleveClasseController().get(absence.getId_eleve_classe());
            Classe classe = getController().getClasseController().get(eleveClasse.getId_classe());
            Cycle cycle = getController().getCycleController().get(classe.getId_cycle());
            Eleve eleve = getController().getEleveController().get(eleveClasse.getId_eleve());
            row[0] = i + 1;
            row[1] = cycle.getCycle();
            row[2] = classe.getClasse();
            row[3] = eleve.getMatricule();
            row[4] = eleve.getNom_prenom();
            row[5] = simpleDateFormat.format(absence.getDate());
            row[6] = absence.getCommentaire();
            id_table_absences.put(i, absence.getId());
            model.addRow(row);
        }
        table_absence.setModel(model);
        table_absence.setShowVerticalLines(true);
        table_absence.setShowHorizontalLines(true);
    }

    private void table_retard() {
        DefaultTableModel model = (DefaultTableModel) table_retard.getModel();
        model.setRowCount(0);
        id_table_retards.clear();
        if (combo_box_annee.getSelectedIndex() < 0 || combo_box_cycle.getSelectedIndex() < 0 || combo_box_classe.getSelectedIndex() < 0) {
            return;
        }
        Long id_annee = id_annees.get(combo_box_annee.getSelectedIndex());
        Long id_classe = id_classes.get(combo_box_classe.getSelectedIndex());
        String rechercher = null;
        Timestamp date = null;
        if (!text_field_rechercher.getText().isEmpty()) {
            rechercher = text_field_rechercher.getText();
        }
        if (date_chooser.getDate() != null) {
            date = new Timestamp(date_chooser.getDate().getTime());
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy à HH:mm:ss");
        ArrayList<bean.Retard> list = getController().getRetardController().gets(null, id_annee, id_classe, date, rechercher);
        for (int i = 0; i < list.size(); i++) {
            Object row[] = new Object[7];
            Retard retard = list.get(i);
            EleveClasse eleveClasse = getController().getEleveClasseController().get(retard.getId_eleve_classe());
            Classe classe = getController().getClasseController().get(eleveClasse.getId_classe());
            Cycle cycle = getController().getCycleController().get(classe.getId_cycle());
            Eleve eleve = getController().getEleveController().get(eleveClasse.getId_eleve());
            row[0] = i + 1;
            row[1] = cycle.getCycle();
            row[2] = classe.getClasse();
            row[3] = eleve.getMatricule();
            row[4] = eleve.getNom_prenom();
            row[5] = simpleDateFormat.format(retard.getDate());
            row[6] = retard.getCommentaire();
            id_table_retards.put(i, retard.getId());
            model.addRow(row);
        }
        table_retard.setModel(model);
        table_retard.setShowVerticalLines(true);
        table_retard.setShowHorizontalLines(true);
    }

    private void init_combo_box_annee() {
        id_annees.clear();
        combo_box_annee.removeAllItems();
        try {
            ArrayList<Annee> list = getController().getAnneeController().gets();
            for (int i = 0; i < list.size(); i++) {
                Annee annee = list.get(i);
                combo_box_annee.addItem(annee.getAnnee());
                id_annees.put(i, annee.getId());
            }
        } catch (Exception e) {
            id_annees.clear();
            combo_box_annee.removeAllItems();
        }

    }

    private void init_combo_box_cycle() {
        id_cycles.clear();
        combo_box_cycle.removeAllItems();
        try {
            ArrayList<Cycle> list = getController().getCycleController().gets();
            for (int i = 0; i < list.size(); i++) {
                Cycle cycle = list.get(i);
                combo_box_cycle.addItem(cycle.getCycle());
                id_cycles.put(i, cycle.getId());

            }
        } catch (Exception e) {
            id_cycles.clear();
            combo_box_cycle.removeAllItems();
        }
    }

    private void init_combo_box_classe() {
        id_classes.clear();
        combo_box_classe.removeAllItems();
        if (combo_box_annee.getSelectedIndex() < 0 || combo_box_cycle.getSelectedIndex() < 0) {
            return;
        }
        try {
            Long id_annee = id_annees.get(combo_box_annee.getSelectedIndex());
            Long id_cycle = id_cycles.get(combo_box_cycle.getSelectedIndex());
            ArrayList<Classe> list = getController().getClasseController().gets(id_annee, id_cycle);
            if (list.size() > 1) {
                combo_box_classe.addItem("Toutes");
                id_classes.put(0, null);
                for (int i = 0; i < list.size(); i++) {
                    Classe classe = list.get(i);
                    combo_box_classe.addItem(classe.getClasse());
                    id_classes.put(i + 1, classe.getId());
                }
            } else {
                for (int i = 0; i < list.size(); i++) {
                    Classe classe = list.get(i);
                    combo_box_classe.addItem(classe.getClasse());
                    id_classes.put(i, classe.getId());
                }
            }
        } catch (Exception e) {
            id_classes.clear();
            combo_box_classe.removeAllItems();
        }
    }

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
//        addPopup(scroll_pane_absence_retard, popup_menu);
//        addPopup(table_absence_retard, popup_menu);
    }

    private void contacter() {
//        int row = table_absence.getSelectedRow();
//        if (row < 0) {
//            return;
//        }
//        Long id_absence = id_table_absences.get(row);
//        ContacterDialog contacter = new ContacterDialog(this, true, eleve);
//        contacter.setVisible(true);
    }

    private void retirer() {
//        int row = table_absence.getSelectedRow();
//        if (row < 0) {
//            return;
//        }
//        Long id_absence = id_table_absences.get(row);
//        Absence absence = getController().getAbsenceController().get(id_absence);
//        Eleve eleve = getController().getEleveController().get(null);
//        int choice = JOptionPane.showConfirmDialog(this, "Etes vous sure de vouloir retirer : " + absenceRetard.getAbsence_retard() + " de l'eleve " + eleve.getNom_prenom() + " ?", "Action irréversible", JOptionPane.YES_NO_OPTION);
//        if (choice == 0) {
//            getController().getAbsenceRetardController().remove(id);
//            table_absence_retard();
//        }
    }

}