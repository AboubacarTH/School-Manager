/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.dialog;

import bean.Eleve;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ATH
 */
public class DetailDialog extends javax.swing.JDialog {

    /**
     * Creates new form Detail
     * @param parent
     * @param modal
     */
    public DetailDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public DetailDialog(java.awt.Frame parent, boolean modal, bean.Eleve e) {
        super(parent, modal);
        eleve = e;
        initComponents();
        update_table();
        jLabel_matricule.setText("MATRICULE : " + eleve.getMatricule());
        jLabel_nom_prenom.setText("NOM ET PRENOM : " + eleve.getNom_prenom());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popup_table = new javax.swing.JPopupMenu();
        menu_item_add_insc = new javax.swing.JMenuItem();
        menu_item_update_insc = new javax.swing.JMenuItem();
        menu_item_remove_insc = new javax.swing.JMenuItem();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel_matricule = new javax.swing.JLabel();
        jLabel_nom_prenom = new javax.swing.JLabel();
        jLabel_photo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_insc = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        menu_item_add_insc.setText("Ajouter nouvelle Inscription");
        menu_item_add_insc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_add_inscActionPerformed(evt);
            }
        });
        popup_table.add(menu_item_add_insc);

        menu_item_update_insc.setText("Modifier l'inscription");
        menu_item_update_insc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_update_inscActionPerformed(evt);
            }
        });
        popup_table.add(menu_item_update_insc);

        menu_item_remove_insc.setText("Retirer l'inscription");
        menu_item_remove_insc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_remove_inscActionPerformed(evt);
            }
        });
        popup_table.add(menu_item_remove_insc);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Detail");
        setAlwaysOnTop(true);
        setResizable(false);

        jLabel_matricule.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel_matricule.setText("Matricule");

        jLabel_nom_prenom.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel_nom_prenom.setText("Nom et prénom");

        jLabel_photo.setBackground(new java.awt.Color(51, 51, 255));
        jLabel_photo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/administration-vector-icon.jpg"))); // NOI18N

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseReleased(evt);
            }
        });

        jTable_insc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "FILIERE / OPTION", "ANNEE", "INSCRIT", "ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_insc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable_inscMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_insc);
        if (jTable_insc.getColumnModel().getColumnCount() > 0) {
            jTable_insc.getColumnModel().getColumn(1).setMinWidth(150);
            jTable_insc.getColumnModel().getColumn(1).setPreferredWidth(150);
            jTable_insc.getColumnModel().getColumn(1).setMaxWidth(150);
            jTable_insc.getColumnModel().getColumn(2).setMinWidth(75);
            jTable_insc.getColumnModel().getColumn(2).setPreferredWidth(75);
            jTable_insc.getColumnModel().getColumn(2).setMaxWidth(75);
            jTable_insc.getColumnModel().getColumn(3).setMinWidth(10);
            jTable_insc.getColumnModel().getColumn(3).setPreferredWidth(10);
            jTable_insc.getColumnModel().getColumn(3).setMaxWidth(10);
        }

        jLabel1.setText("Photo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_nom_prenom)
                                    .addComponent(jLabel_matricule))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel_photo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel_matricule)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel_nom_prenom))
                        .addComponent(jLabel_photo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menu_item_add_inscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_add_inscActionPerformed
        //update_table();
    }//GEN-LAST:event_menu_item_add_inscActionPerformed

    private void menu_item_update_inscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_update_inscActionPerformed
        int row = jTable_insc.getSelectedRow();
        String filiere = jTable_insc.getValueAt(row, 0).toString();
        String annee = jTable_insc.getValueAt(row, 1).toString();
        String semestre = jTable_insc.getValueAt(row, 2).toString();
        //update_table();
    }//GEN-LAST:event_menu_item_update_inscActionPerformed

    private void menu_item_remove_inscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_remove_inscActionPerformed
        int choice = JOptionPane.showConfirmDialog(this, "Etes vous sure de vouloir suprimer l'inscription selectionnée ?", "Action irréversible", JOptionPane.YES_NO_OPTION);
        if(choice == 0){
            int row = jTable_insc.getSelectedRow();
            String filiere = jTable_insc.getValueAt(row, 0).toString();
            String annee = jTable_insc.getValueAt(row, 1).toString();
            String semestre = jTable_insc.getValueAt(row, 2).toString();
        }
        //update_table();
    }//GEN-LAST:event_menu_item_remove_inscActionPerformed

    private void jScrollPane1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseReleased
        int r = jTable_insc.rowAtPoint(evt.getPoint());
        if(r >=0 && r < jTable_insc.getRowCount()){
            jTable_insc.setRowSelectionInterval(r, r);

        }else{
            jTable_insc.clearSelection();
        }
        int index = jTable_insc.getSelectedRow();
        if(index < 0){
            menu_item_remove_insc.setEnabled(false);
            menu_item_update_insc.setEnabled(false);
        }else{
            menu_item_remove_insc.setEnabled(true);
            menu_item_update_insc.setEnabled(true);
        }
        if(evt.isPopupTrigger() && evt.getComponent() instanceof JScrollPane){
            popup_table.show(evt.getComponent(), evt.getX(), evt.getY());
            popup_table.setVisible(true);
        }
    }//GEN-LAST:event_jScrollPane1MouseReleased

    private void jTable_inscMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_inscMouseReleased
        int r = jTable_insc.rowAtPoint(evt.getPoint());
        if(r >=0 && r < jTable_insc.getRowCount()){
            jTable_insc.setRowSelectionInterval(r, r);

        }else{
            jTable_insc.clearSelection();
        }
        int index = jTable_insc.getSelectedRow();
        if(index < 0){
            menu_item_remove_insc.setEnabled(false);
            menu_item_update_insc.setEnabled(false);
        }else{
            menu_item_remove_insc.setEnabled(true);
            menu_item_update_insc.setEnabled(true);
        }
        if(evt.isPopupTrigger() && evt.getComponent() instanceof JTable){
            popup_table.show(evt.getComponent(), evt.getX(), evt.getY());
            popup_table.setVisible(true);
        }
    }//GEN-LAST:event_jTable_inscMouseReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetailDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            DetailDialog dialog = new DetailDialog(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }
    private Eleve eleve = null;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_matricule;
    private javax.swing.JLabel jLabel_nom_prenom;
    private javax.swing.JLabel jLabel_photo;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_insc;
    private javax.swing.JMenuItem menu_item_add_insc;
    private javax.swing.JMenuItem menu_item_remove_insc;
    private javax.swing.JMenuItem menu_item_update_insc;
    private javax.swing.JPopupMenu popup_table;
    // End of variables declaration//GEN-END:variables

    private void update_table(){
        String entete[] = {"FILIERE", "ANNEE", "INSCRIT", "ID"};
        DefaultTableModel dt=new DefaultTableModel(null,entete);
        dt.setRowCount(0);
        
        this.jTable_insc.setModel(dt);
        if (jTable_insc.getColumnModel().getColumnCount() > 0) {
            jTable_insc.getColumnModel().getColumn(1).setMinWidth(150);
            jTable_insc.getColumnModel().getColumn(1).setPreferredWidth(150);
            jTable_insc.getColumnModel().getColumn(1).setMaxWidth(150);
            jTable_insc.getColumnModel().getColumn(2).setMinWidth(75);
            jTable_insc.getColumnModel().getColumn(2).setPreferredWidth(75);
            jTable_insc.getColumnModel().getColumn(2).setMaxWidth(75);
            jTable_insc.getColumnModel().getColumn(3).setMinWidth(10);
            jTable_insc.getColumnModel().getColumn(3).setPreferredWidth(10);
            jTable_insc.getColumnModel().getColumn(3).setMaxWidth(10);
            jTable_insc.setRowHeight(30);
        }
    }
}
