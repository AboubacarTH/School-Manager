/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/OkCancelDialog.java to edit this template
 */
package view.dialog;

import bean.Annee;
import bean.Classe;
import bean.Cycle;
import bean.Eleve;
import bean.EleveClasse;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;
import static main.Main.getController;

/**
 *
 * @author Toukou Habi
 */
public class EleveClasseDialog extends javax.swing.JDialog {

    /**
     * A return status code - returned if Cancel button has been pressed
     */
    public static final int RET_CANCEL = 0;
    /**
     * A return status code - returned if OK button has been pressed
     */
    public static final int RET_OK = 1;

    /**
     * Creates new form EleveClasseDialog
     *
     * @param parent
     * @param modal
     */
    public EleveClasseDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        id_annees = new HashMap<>();
        id_cycles = new HashMap<>();
        id_classes = new HashMap<>();
        id_eleves = new HashMap<>();
        selected_id_eleve = null;
        initComponents();
        init_combo_box_annee();
        init_combo_box_cycle();
        init_combo_box_classe();
        table_eleve();
        // Close the dialog when Esc is pressed
        String cancelName = "cancel";
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), cancelName);
        ActionMap actionMap = getRootPane().getActionMap();
        actionMap.put(cancelName, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doClose(RET_CANCEL);
            }
        });

    }

    public EleveClasseDialog(java.awt.Frame parent, boolean modal, ArrayList<Long> selected_id_eleve) {
        super(parent, modal);
        id_annees = new HashMap<>();
        id_cycles = new HashMap<>();
        id_classes = new HashMap<>();
        id_eleves = new HashMap<>();
        this.selected_id_eleve = selected_id_eleve;
        initComponents();
        init_combo_box_annee();
        init_combo_box_cycle();
        init_combo_box_classe();
        table_eleve();
        // Close the dialog when Esc is pressed
        String cancelName = "cancel";
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), cancelName);
        ActionMap actionMap = getRootPane().getActionMap();
        actionMap.put(cancelName, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doClose(RET_CANCEL);
            }
        });

    }

    /**
     * @return the return status of this dialog - one of RET_OK or RET_CANCEL
     */
    public int getReturnStatus() {
        return returnStatus;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        combo_box_annee = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        combo_box_cycle = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        combo_box_classe = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_eleve = new javax.swing.JTable();

        setTitle("Elève classe");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

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

        table_eleve.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "N°", "Matricule", "Nom et Prénom"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table_eleve);
        if (table_eleve.getColumnModel().getColumnCount() > 0) {
            table_eleve.getColumnModel().getColumn(0).setMinWidth(35);
            table_eleve.getColumnModel().getColumn(0).setPreferredWidth(35);
            table_eleve.getColumnModel().getColumn(0).setMaxWidth(35);
            table_eleve.getColumnModel().getColumn(1).setMinWidth(100);
            table_eleve.getColumnModel().getColumn(1).setPreferredWidth(100);
            table_eleve.getColumnModel().getColumn(1).setMaxWidth(100);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 288, Short.MAX_VALUE)
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combo_box_annee, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(combo_box_cycle, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(combo_box_classe, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancelButton, okButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(combo_box_annee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(combo_box_cycle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(combo_box_classe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(okButton))
                .addContainerGap())
        );

        getRootPane().setDefaultButton(okButton);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        valider();
        doClose(RET_OK);
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        doClose(RET_CANCEL);
    }//GEN-LAST:event_cancelButtonActionPerformed

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        doClose(RET_CANCEL);
    }//GEN-LAST:event_closeDialog

    private void combo_box_anneeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_box_anneeActionPerformed
        init_combo_box_classe();
        table_eleve();
    }//GEN-LAST:event_combo_box_anneeActionPerformed

    private void combo_box_cycleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_box_cycleActionPerformed
        init_combo_box_classe();
        table_eleve();
    }//GEN-LAST:event_combo_box_cycleActionPerformed

    private void combo_box_classeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_box_classeActionPerformed
        table_eleve();
    }//GEN-LAST:event_combo_box_classeActionPerformed

    private void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            EleveClasseDialog dialog = new EleveClasseDialog(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }
    private final HashMap<Integer, Long> id_annees, id_cycles, id_classes, id_eleves;
    private final ArrayList<Long> selected_id_eleve;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JComboBox<String> combo_box_annee;
    private javax.swing.JComboBox<String> combo_box_classe;
    private javax.swing.JComboBox<String> combo_box_cycle;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton okButton;
    private javax.swing.JTable table_eleve;
    // End of variables declaration//GEN-END:variables

    private int returnStatus = RET_CANCEL;

    private void init_combo_box_annee() {
        combo_box_annee.removeAllItems();
        id_annees.clear();
        try {
            ArrayList<Annee> list = getController().getAnneeController().gets();
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
            ArrayList<Cycle> list = getController().getCycleController().gets();
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
            ArrayList<Classe> list = getController().getClasseController().gets(id_annee, id_cycle);
            for (int i = 0; i < list.size(); i++) {
                combo_box_classe.addItem(list.get(i).getClasse());
                id_classes.put(i, list.get(i).getId());
            }
        } catch (Exception e) {
            combo_box_classe.removeAllItems();
            id_classes.clear();
        }
    }

    private void table_eleve() {
        try {
            DefaultTableModel model = (DefaultTableModel) table_eleve.getModel();
            model.setRowCount(0);
            id_eleves.clear();
            if (selected_id_eleve != null) {
                for (int i = 0; i < selected_id_eleve.size(); i++) {
                    Object row[] = new Object[3];
                    Eleve eleve = getController().getEleveController().get(selected_id_eleve.get(i));
                    row[0] = i + 1;
                    row[1] = eleve.getMatricule();
                    row[2] = eleve.getNom_prenom();
                    id_eleves.put(i, eleve.getId());
                    model.addRow(row);
                }
            }
            table_eleve.setModel(model);
            table_eleve.setShowVerticalLines(true);
            table_eleve.setShowHorizontalLines(true);
        } catch (NullPointerException e) {
        }
    }

    private void valider() {
        if (combo_box_annee.getSelectedIndex() < 0 || combo_box_cycle.getSelectedIndex() < 0 || combo_box_classe.getSelectedIndex() < 0) {
            return;
        }
        Long id_classe = id_classes.get(combo_box_classe.getSelectedIndex());
        Classe classe = getController().getClasseController().get(id_classes.get(combo_box_classe.getSelectedIndex()));
        if (selected_id_eleve != null) {
            for (int i = 0; i < selected_id_eleve.size(); i++) {
                ArrayList<EleveClasse> list = getController().getEleveClasseController().gets(selected_id_eleve.get(i), null, null, null, null, null, null);
                for (int j = 0; j < list.size(); j++) {
                    if (i > 0) {
                        break;
                    }
                    EleveClasse get = list.get(j);
                    Classe c = getController().getClasseController().get(get.getId_classe());
                    if (Objects.equals(classe.getId_annee(), c.getId_annee())) {
                        JOptionPane.showMessageDialog(this, "Impossible d'inscrire un élève dans deux classes à la même année ", "Duplication !", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                }
                getController().getEleveClasseController().add(selected_id_eleve.get(i), id_classe);
            }
        }
        JOptionPane.showMessageDialog(this, "Opération effectuée avec success ", "Réussie !", JOptionPane.INFORMATION_MESSAGE);
    }
}
