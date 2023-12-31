/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.panel;

import bean.Nationalite;
import bean.ProfesseurMatiereClasse;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.AbstractCellEditor;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import main.Main;
import static main.Main.getController;
import static main.Main.getDroit;
import view.dialog.ProfesseurDialog;
import view.dialog.SupressionDialog;

/**
 *
 * @author ATH
 */
public class ProfesseurPanel extends javax.swing.JPanel {

    /**
     * Creates new form Professeur
     */
    public ProfesseurPanel() {
        id_professeurs = new HashMap<>();
        id_nationalies = new HashMap<>();
        initComponents();
        init_combo_box_nationalite();
        table_professeur();
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

        popup_professeur = new javax.swing.JPopupMenu();
        menu_item_professeur_add = new javax.swing.JMenuItem();
        menu_item_professeur_update = new javax.swing.JMenuItem();
        menu_item_professeur_remove = new javax.swing.JMenuItem();
        scroll_pane_professeur = new javax.swing.JScrollPane();
        table_professeur = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        combo_box_nationalite = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        combo_box_titre = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        combo_box_sexe = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        text_field_rechercher = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btn_actualiser_table = new javax.swing.JButton();
        button_add = new javax.swing.JButton();
        button_update = new javax.swing.JButton();
        button_remove = new javax.swing.JButton();

        menu_item_professeur_add.setText("Ajouter");
        menu_item_professeur_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_professeur_addActionPerformed(evt);
            }
        });
        popup_professeur.add(menu_item_professeur_add);

        menu_item_professeur_update.setText("Mettre à jour");
        menu_item_professeur_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_professeur_updateActionPerformed(evt);
            }
        });
        popup_professeur.add(menu_item_professeur_update);

        menu_item_professeur_remove.setText("Suprimer");
        menu_item_professeur_remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_professeur_removeActionPerformed(evt);
            }
        });
        popup_professeur.add(menu_item_professeur_remove);

        table_professeur.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "N°", "Matricule", "Nom et prénom", "Nationalité", "Diplôme", "Matières", "Classes", "N° Tel", "Option"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scroll_pane_professeur.setViewportView(table_professeur);
        if (table_professeur.getColumnModel().getColumnCount() > 0) {
            table_professeur.getColumnModel().getColumn(0).setPreferredWidth(35);
            table_professeur.getColumnModel().getColumn(0).setMaxWidth(35);
            table_professeur.getColumnModel().getColumn(1).setPreferredWidth(100);
            table_professeur.getColumnModel().getColumn(1).setMaxWidth(100);
            table_professeur.getColumnModel().getColumn(3).setPreferredWidth(100);
            table_professeur.getColumnModel().getColumn(3).setMaxWidth(100);
            table_professeur.getColumnModel().getColumn(4).setPreferredWidth(120);
            table_professeur.getColumnModel().getColumn(4).setMaxWidth(200);
            table_professeur.getColumnModel().getColumn(5).setPreferredWidth(120);
            table_professeur.getColumnModel().getColumn(5).setMaxWidth(200);
            table_professeur.getColumnModel().getColumn(6).setPreferredWidth(120);
            table_professeur.getColumnModel().getColumn(6).setMaxWidth(200);
            table_professeur.getColumnModel().getColumn(7).setPreferredWidth(200);
            table_professeur.getColumnModel().getColumn(7).setMaxWidth(260);
            table_professeur.getColumnModel().getColumn(8).setMinWidth(185);
            table_professeur.getColumnModel().getColumn(8).setPreferredWidth(185);
            table_professeur.getColumnModel().getColumn(8).setMaxWidth(185);
        }

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabel1.setText("Nationalité :");

        combo_box_nationalite.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo_box_nationalite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_box_nationaliteActionPerformed(evt);
            }
        });

        jLabel2.setText("Titre :");

        combo_box_titre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tous", "Mr", "Mme", "Mlle", "Ing", "Dr", "Pr" }));
        combo_box_titre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_box_titreActionPerformed(evt);
            }
        });

        jLabel3.setText("Sexe :");

        combo_box_sexe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tous", "F", "M" }));
        combo_box_sexe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_box_sexeActionPerformed(evt);
            }
        });

        jLabel6.setText("Rechercher :");

        text_field_rechercher.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                text_field_rechercherKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(combo_box_nationalite, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(combo_box_titre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combo_box_sexe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(text_field_rechercher, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(combo_box_nationalite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(combo_box_titre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(combo_box_sexe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(text_field_rechercher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        btn_actualiser_table.setForeground(new java.awt.Color(0, 153, 0));
        btn_actualiser_table.setText("Actualiser la table");
        btn_actualiser_table.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualiser_tableActionPerformed(evt);
            }
        });

        button_add.setText("Nouveau");
        button_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_addActionPerformed(evt);
            }
        });

        button_update.setText("Mettre à jour");
        button_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_updateActionPerformed(evt);
            }
        });

        button_remove.setForeground(new java.awt.Color(102, 0, 0));
        button_remove.setText("Suprimer");
        button_remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_removeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_actualiser_table)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(button_add)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(button_update)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(button_remove)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_add)
                    .addComponent(button_update)
                    .addComponent(button_remove))
                .addGap(18, 18, 18)
                .addComponent(btn_actualiser_table)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scroll_pane_professeur)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 218, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(scroll_pane_professeur, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void menu_item_professeur_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_professeur_addActionPerformed
        add_professeur();
    }//GEN-LAST:event_menu_item_professeur_addActionPerformed

    private void menu_item_professeur_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_professeur_updateActionPerformed
        update_professeur();
    }//GEN-LAST:event_menu_item_professeur_updateActionPerformed

    private void menu_item_professeur_removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_professeur_removeActionPerformed
        remove_professeur();
    }//GEN-LAST:event_menu_item_professeur_removeActionPerformed

    private void combo_box_nationaliteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_box_nationaliteActionPerformed
        table_professeur();
    }//GEN-LAST:event_combo_box_nationaliteActionPerformed

    private void combo_box_titreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_box_titreActionPerformed
        table_professeur();
    }//GEN-LAST:event_combo_box_titreActionPerformed

    private void combo_box_sexeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_box_sexeActionPerformed
        table_professeur();
    }//GEN-LAST:event_combo_box_sexeActionPerformed

    private void text_field_rechercherKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_field_rechercherKeyReleased
        table_professeur();
    }//GEN-LAST:event_text_field_rechercherKeyReleased

    private void btn_actualiser_tableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualiser_tableActionPerformed
        table_professeur();
    }//GEN-LAST:event_btn_actualiser_tableActionPerformed

    private void button_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_addActionPerformed
        add_professeur();
    }//GEN-LAST:event_button_addActionPerformed

    private void button_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_updateActionPerformed
        update_professeur();
    }//GEN-LAST:event_button_updateActionPerformed

    private void button_removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_removeActionPerformed
        remove_professeur();
    }//GEN-LAST:event_button_removeActionPerformed
    private final HashMap<Integer, Long> id_professeurs, id_nationalies;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_actualiser_table;
    private javax.swing.JButton button_add;
    private javax.swing.JButton button_remove;
    private javax.swing.JButton button_update;
    private javax.swing.JComboBox<String> combo_box_nationalite;
    private javax.swing.JComboBox<String> combo_box_sexe;
    private javax.swing.JComboBox<String> combo_box_titre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JMenuItem menu_item_professeur_add;
    private javax.swing.JMenuItem menu_item_professeur_remove;
    private javax.swing.JMenuItem menu_item_professeur_update;
    private javax.swing.JPopupMenu popup_professeur;
    private javax.swing.JScrollPane scroll_pane_professeur;
    private javax.swing.JTable table_professeur;
    private javax.swing.JTextField text_field_rechercher;
    // End of variables declaration//GEN-END:variables
    private void table_professeur() {
        DefaultTableModel model = (DefaultTableModel) table_professeur.getModel();
        model.setRowCount(0);
        id_professeurs.clear();
        try {
            if (combo_box_nationalite.getSelectedIndex() < 0 || combo_box_sexe.getSelectedIndex() < 0 || combo_box_titre.getSelectedIndex() < 0) {
                return;
            }
            Long id_nationalite = id_nationalies.get(combo_box_nationalite.getSelectedIndex());
            String titre = null, sexe = null, recherche = null;
            if (!combo_box_titre.getSelectedItem().toString().equals("Tous")) {
                titre = combo_box_titre.getSelectedItem().toString();
            }
            if (!combo_box_sexe.getSelectedItem().toString().equals("Tous")) {
                sexe = combo_box_sexe.getSelectedItem().toString();
            }

            if (!text_field_rechercher.getText().isEmpty()) {
                recherche = text_field_rechercher.getText();
            }
            ArrayList<bean.Professeur> list = getController().getProfesseurController().gets(id_nationalite, titre, sexe, recherche);
            for (int i = 0; i < list.size(); i++) {
                ProfesseurMatiereClasse professeurMatiereClasse = getController().getProfesseurMatiereClasseController().get(null, null, null, null, list.get(i).getId());
                Object row[] = new Object[9];
                row[0] = i + 1;
                row[1] = list.get(i).getMatricule();
                row[2] = list.get(i).getNom_prenom();
                row[3] = getController().getNationaliteController().get(list.get(i).getId_nationalite()).getNationalite();
                row[4] = list.get(i).getDiplome();
                if (professeurMatiereClasse != null) {
                    row[5] = getController().getMatiereController().get(getController().getMatiereClasseController().get(professeurMatiereClasse.getId_matiere_classe()).getId_matiere()).getMatiere();
                    row[6] = "";
                } else {
                    row[5] = "";
                    row[6] = "";
                }
                row[7] = list.get(i).getContact();
                id_professeurs.put(i, list.get(i).getId());
                model.addRow(row);
            }
            table_professeur.setModel(model);
            table_professeur.setShowVerticalLines(true);
            table_professeur.setShowHorizontalLines(true);
            table_professeur.setRowHeight(30);
            table_professeur.setGridColor(Color.BLACK);
            TableColumn column = table_professeur.getColumnModel().getColumn(table_professeur.getColumnModel().getColumnCount() - 1);
            column.setCellRenderer(new ButtonsRenderer());
            column.setCellEditor(new ButtonsEditor(table_professeur));
        } catch (NullPointerException e) {
            model.setRowCount(0);
            id_professeurs.clear();
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
        addPopup(scroll_pane_professeur, popup_professeur);
        addPopup(table_professeur, popup_professeur);
    }

    private void init_combo_box_nationalite() {
        combo_box_nationalite.removeAllItems();
        id_nationalies.clear();
        try {
            ArrayList<Nationalite> list = getController().getNationaliteController().gets();
            for (int i = 0; i < list.size(); i++) {
                Nationalite nationalite = list.get(i);
                combo_box_nationalite.addItem(nationalite.getNationalite());
                id_nationalies.put(i, nationalite.getId());
            }
        } catch (Exception e) {
            combo_box_nationalite.removeAllItems();
            id_nationalies.clear();
        }
    }

    private void add_professeur() {
        if (!getDroit().isSuprimer()) {
            JOptionPane.showMessageDialog(this, "Veuillez contacter le super Administrateur ", "Droit super Administrateur réquis !", JOptionPane.WARNING_MESSAGE);
            return;
        }
        ProfesseurDialog professeurDialog = new ProfesseurDialog(null, true);
        professeurDialog.setVisible(true);
        table_professeur();
    }

    private void update_professeur() {
        if (!getDroit().isSuprimer()) {
            JOptionPane.showMessageDialog(this, "Veuillez contacter le super Administrateur ", "Droit super Administrateur réquis !", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int row = table_professeur.getSelectedRow();
        if (row < 0) {
            return;
        }
        bean.Professeur professeur = getController().getProfesseurController().get(id_professeurs.get(row));
        ProfesseurDialog professeurDialog = new ProfesseurDialog(null, true, professeur);
        professeurDialog.setVisible(true);
        table_professeur();
    }

    private void remove_professeur() {
        Main.setCan_remove(false);
        if (!getDroit().isSuprimer()) {
            JOptionPane.showMessageDialog(this, "Veuillez contacter le super Administrateur ", "Droit super Administrateur réquis !", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int row = table_professeur.getSelectedRow();
        if (row < 0) {
            return;
        }
        bean.Professeur professeur = getController().getProfesseurController().get(id_professeurs.get(row));
        int choice = JOptionPane.showConfirmDialog(this, "Etes vous sure de vouloir suprimer l'enseignant(e) " + professeur.getNom_prenom() + " ?", "Action irréversible", JOptionPane.YES_NO_OPTION);
        if (choice == 0) {
            SupressionDialog supressionDialog = new SupressionDialog(null, true);
            supressionDialog.setVisible(true);
            if (Main.isCan_remove()) {
                getController().getProfesseurController().remove(professeur.getId());
                getController().getUserController().remove(professeur.getMatricule());
                table_professeur();
                JOptionPane.showMessageDialog(this, "Opération éffectuée avec succes ! ", "Supression", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        Main.setCan_remove(false);
    }

    enum Actions {
        MODIFIER, SUPRIMER;
    }

    class ButtonsPanel extends JPanel {

        public final List<JButton> buttons = new ArrayList<>();

        public ButtonsPanel() {
            super(new FlowLayout(FlowLayout.LEFT));
            setOpaque(true);
            for (Actions a : Actions.values()) {
                JButton b = new JButton(a.toString());
                b.setFocusable(false);
                b.setRolloverEnabled(false);
                if ("MODIFIER".equals(a.toString())) {
                    b.setBackground(Color.green);
                    b.setForeground(Color.white);
                }
                if ("SUPRIMER".equals(a.toString())) {
                    b.setBackground(Color.red);
                    b.setForeground(Color.white);
                }
                add(b);
                buttons.add(b);
            }
        }

        protected void updateButtons(Object value) {
            if (value instanceof EnumSet ea) {
                removeAll();
                if (ea.contains(Actions.MODIFIER)) {
                    add(buttons.get(0));
                }
                if (ea.contains(Actions.SUPRIMER)) {
                    add(buttons.get(1));
                }
            }
        }
    }

    class ButtonsRenderer implements TableCellRenderer {

        private final ButtonsPanel panel = new ButtonsPanel();

        @Override
        public Component getTableCellRendererComponent(
                JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            panel.setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
            panel.updateButtons(value);
            return panel;
        }
    }

    class ModifierAction extends AbstractAction {

        private final JTable table;

        public ModifierAction(JTable table) {
            super(Actions.MODIFIER.toString());
            this.table = table;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            update_professeur();
        }
    }

    class SuprimerAction extends AbstractAction {

        public SuprimerAction(JTable table) {
            super(Actions.SUPRIMER.toString());
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            remove_professeur();
        }
    }

    class ButtonsEditor extends AbstractCellEditor implements TableCellEditor {

        private final ButtonsPanel panel = new ButtonsPanel();
        private final JTable table;
        private Object o;

        private class EditingStopHandler extends MouseAdapter implements ActionListener {

            @Override
            public void mousePressed(MouseEvent e) {
                Object o = e.getSource();
                if (o instanceof TableCellEditor) {
                    actionPerformed(null);
                } else if (o instanceof JButton) {
                    ButtonModel m = ((JButton) e.getComponent()).getModel();
                    if (m.isPressed() && table.isRowSelected(table.getEditingRow()) && e.isControlDown()) {
                        panel.setBackground(table.getBackground());
                    }
                }
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(() -> {
                    fireEditingStopped();
                });
            }
        }

        public ButtonsEditor(JTable table) {
            super();
            this.table = table;
            panel.buttons.get(0).setAction(new ModifierAction(table));
            panel.buttons.get(1).setAction(new SuprimerAction(table));

            EditingStopHandler handler = new EditingStopHandler();
            for (JButton b : panel.buttons) {
                b.addMouseListener(handler);
                b.addActionListener(handler);
            }
            panel.addMouseListener(handler);
        }

        @Override
        public Component getTableCellEditorComponent(
                JTable table, Object value, boolean isSelected, int row, int column) {
            panel.setBackground(table.getSelectionBackground());
            panel.updateButtons(value);
            o = value;
            return panel;
        }

        @Override
        public Object getCellEditorValue() {
            return o;
        }
    }
}
