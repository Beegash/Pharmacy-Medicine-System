/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.beegash.pharmacymedicinesystem;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;

/**
 *
 * @author fener
 */
public class MedicineListBackUp extends javax.swing.JFrame {

    /**
     * Creates new form MedicineList
     */
    String[] columnNames = {"Medicine Id", "Medicine Name", "Dose", "Issued Date", "Exp Date", "Storage Cond", "How to Use", "Daily Dose", "Stock"};
    DefaultTableModel model = new DefaultTableModel(columnNames, 0);
    private DefaultTableModel tableModel;
    static ArrayList<Medicine> medicineList = new ArrayList<>();
    static boolean isMedicineListInitialized = false;
    Medicine adderal = new Medicine(1, "Adderal", "10", "12/01/2020", "12/02/2024", "Room temperature", "Take with water", "1", 5000);
    Medicine amitriptyline = new Medicine(2, "Amitriptyline", "12", "12/01/2023", "12/11/2024", "Cool and dry place", "Take with food", "1", 20000);
    Medicine benzonatate = new Medicine(3, "Benzonatate", "12", "06/11/2022", "12/02/2024", "Room temperature", "Take with water", "1", 10000);
    Medicine brilinta = new Medicine(4, "Brilinta", "12", "12/01/2022", "04/09/2024", "Room temperature", "Take with water", "1", 25000);
    Medicine cymbalta = new Medicine(5, "Cymbalta ", "12", "05/01/2023", "02/05/2024", "Cool and dry place", "Take as needed", "1", 5000);
    Medicine ibuprofen = new Medicine(6, "Ibuprofen", "200", "07/04/2022", "07/04/2023", "Cool and dry place", "Take with food or water", "2", 2000);
    Medicine acetaminophen = new Medicine(7, "Acetaminophen", "500 ", "09/05/2022", "12/11/2024", "Room temperature", "Take with water", "1", 1000);
    Medicine diphenhydramine = new Medicine(8, "Diphenhydramine", "25", "06/01/2023", "22/04/2024", "Cool and dry place", "Take with food or water", "1", 9000);
    Medicine famotidine = new Medicine(9, "Famotidine", "20", "31/03/2023", "30/12/2024", "Room temperature", "Take with water", "1", 6000);
    Medicine loratadine = new Medicine(10, "Loratadine", "10", "25/12/2022", "15/12/2023", "Cool and dry place", "Take with water", "1", 4500);
    Medicine metformin = new Medicine(11, "Metformin", "500", "24/06/2022", "01/01/2024", "Room temperature", "Take with food", "2", 1000);

    public MedicineListBackUp() {
        tableModel = new DefaultTableModel();
        tableMedicine = new JTable(tableModel);
        populateMedicineTable();
        initComponents();
        setLocationRelativeTo(null);

        if (!isMedicineListInitialized) {
            initMedicineList();
            isMedicineListInitialized = true;
        }
        tableMedicine.setModel(model);

        for (Medicine mdcn : medicineList) {
            Object[] row = {mdcn.getMedicineId(), mdcn.getMedicineName(), mdcn.getDose(), mdcn.getIssuedDate(), mdcn.getExpDate(), mdcn.getStorageConditions(), mdcn.getHowToUse(), mdcn.getDailyDose(), mdcn.getStock()};
            model.addRow(row);
        }

    }
    

    public void populateMedicineTable() {
        try {
            Connection connection = DBhelper.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM medicinetable");
            Statement statement1 = connection.createStatement();
            ResultSet resultSet = statement1.executeQuery("SELECT * FROM medicinetable");

            while (resultSet.next()) {
                int medicineId = resultSet.getInt("medicine_id");
                String medicineName = resultSet.getString("medicine_name");
                String issuedDate = resultSet.getString("issued_date");
                String expDate = resultSet.getString("exp_date");
                String storageConditions = resultSet.getString("storage_conditions");
                String howToUse = resultSet.getString("howToUse");
                String dailyDose = resultSet.getString("daily_dose");
                int stock = resultSet.getInt("stock");
                String dose = resultSet.getString("dose");

                tableModel.addRow(new Object[]{medicineId, medicineName, dose, issuedDate, expDate, storageConditions, howToUse, dailyDose, stock,});
            }

            resultSet.close();
            statement1.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/pharmacy?zeroDateTimeBehavior=CONVERT_TO_NULL";
        String username = "root";
        String password = "1287";
        return DriverManager.getConnection(url, username, password);
    }

    private void initMedicineList() {
        medicineList.add(adderal);
        medicineList.add(amitriptyline);
        medicineList.add(benzonatate);
        medicineList.add(brilinta);
        medicineList.add(cymbalta);
        medicineList.add(ibuprofen);
        medicineList.add(acetaminophen);
        medicineList.add(diphenhydramine);
        medicineList.add(famotidine);
        medicineList.add(loratadine);
        medicineList.add(metformin);
    }

    private void refreshTable() {
        model.setRowCount(0);

        for (Medicine mdcn : medicineList) {
            Object[] row = {mdcn.getMedicineId(), mdcn.getMedicineName(), mdcn.getDose(), mdcn.getIssuedDate(), mdcn.getExpDate(), mdcn.getStorageConditions(), mdcn.getHowToUse(), mdcn.getDailyDose(), mdcn.getStock()};
            model.addRow(row);

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

        jScrollPane1 = new javax.swing.JScrollPane();
        tableMedicine = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtMedicineId = new javax.swing.JTextField();
        btnAddMedicine = new javax.swing.JButton();
        txtDose = new javax.swing.JTextField();
        txtExpDate = new javax.swing.JTextField();
        txtIssuedDate = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtStorage = new javax.swing.JTextField();
        txtHowToUse = new javax.swing.JTextField();
        txtDailyDose = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtMedicineName1 = new javax.swing.JTextField();
        btnView = new javax.swing.JButton();
        btnCloseWindows = new javax.swing.JButton();
        btnDeleteMedicine = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableMedicine.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableMedicine);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(txtMedicineId, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 140, 20));

        btnAddMedicine.setText("Add Medicine");
        btnAddMedicine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMedicineActionPerformed(evt);
            }
        });
        jPanel1.add(btnAddMedicine, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, -1, -1));
        jPanel1.add(txtDose, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 140, -1));
        jPanel1.add(txtExpDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 140, -1));
        jPanel1.add(txtIssuedDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 140, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Medicine :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Dose (mg) :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Exp Date :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Issued Date :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("How to Use:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Daily Dose");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Storage Condutions:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, -1, -1));
        jPanel1.add(txtStorage, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, 140, -1));
        jPanel1.add(txtHowToUse, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, 140, -1));
        jPanel1.add(txtDailyDose, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, 140, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Stock: ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, -1, -1));
        jPanel1.add(txtStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, 140, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Medicine ID:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));
        jPanel1.add(txtMedicineName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 140, 20));

        btnView.setText("View");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });
        jPanel1.add(btnView, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, -1, -1));

        btnCloseWindows.setText("Close Window");
        btnCloseWindows.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseWindowsActionPerformed(evt);
            }
        });

        btnDeleteMedicine.setText("Remove Medicine");
        btnDeleteMedicine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteMedicineActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(570, 570, 570)
                .addComponent(btnCloseWindows))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(560, 560, 560)
                .addComponent(btnDeleteMedicine))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(btnCloseWindows)
                .addGap(7, 7, 7)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnDeleteMedicine))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseWindowsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseWindowsActionPerformed
        // TODO add your handling code here:

        this.setVisible(false);
    }//GEN-LAST:event_btnCloseWindowsActionPerformed

    private void btnAddMedicineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMedicineActionPerformed
        // TODO add your handling code here:
        model.setRowCount(0);
        int medicineId;
        String medicineName = txtMedicineName1.getText();
        String dose = txtDose.getText();
        String issuedDate = txtIssuedDate.getText();
        String expDate = txtExpDate.getText();
        String storageConditions = txtStorage.getText();
        String howToUse = txtHowToUse.getText();
        String dailyDose = txtDailyDose.getText();
        int stock;
        if (medicineName.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a medicine name.");
            refreshTable();
            return;
        }

        for (Medicine mdcn : medicineList) {
            if (mdcn.getMedicineName().equalsIgnoreCase(medicineName)) {
                JOptionPane.showMessageDialog(this, "A medicine with the same name or same id already exists.");
                refreshTable();
                return;
            }
        }
        try {
            medicineId = Integer.parseInt(txtMedicineId.getText());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number for id.");
            refreshTable();
            return;
        }
        if (dose.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a dose variable.");
            refreshTable();
            return;
        }
        if (issuedDate.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a issued date.");
            refreshTable();
            return;
        }
        if (expDate.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a expiration date.");
            refreshTable();
            return;
        }
        if (storageConditions.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a strorage condition variable.");
            refreshTable();
            return;
        }
        if (howToUse.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter using instructions.");
            refreshTable();
            return;
        }
        if (dailyDose.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a daily dose variable.");
            refreshTable();
            return;
        }

        try {
            stock = Integer.parseInt(txtStock.getText());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number for stock.");
            refreshTable();
            return;
        }
        Medicine medicine = new Medicine(medicineId, medicineName, dose, issuedDate, expDate, storageConditions, howToUse, dailyDose, stock);
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "1287");
            String query = "INSERT INTO medicinetable (medicine_id, medicine_name, issued_date, exp_date, storage_conditions, howToUse, daily_dose, stock, dose) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, medicine.getMedicineId());
            stmt.setString(2, medicine.getMedicineName());
            stmt.setString(3, medicine.getIssuedDate());
            stmt.setString(4, medicine.getExpDate());
            stmt.setString(5, medicine.getStorageConditions());
            stmt.setString(6, medicine.getHowToUse());
            stmt.setString(7, medicine.getDailyDose());
            stmt.setInt(8, medicine.getStock());
            stmt.setString(9, medicine.getDose());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred while adding the medicine to the database.");
            refreshTable();
            return;
        }
        medicineList.add(medicine);
        for (Medicine mdcn : medicineList) {
            Object[] row = {mdcn.getMedicineId(), mdcn.getMedicineName(), mdcn.getDose(), mdcn.getIssuedDate(), mdcn.getExpDate(), mdcn.getStorageConditions(), mdcn.getHowToUse(), mdcn.getDailyDose(), mdcn.getStock()};
            model.addRow(row);
        }

        refreshTable();

    }//GEN-LAST:event_btnAddMedicineActionPerformed

    private void btnDeleteMedicineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteMedicineActionPerformed
        // TODO add your handling code here:
        int selectedRow = tableMedicine.getSelectedRow();
        if (selectedRow != -1) {
            String medicineName = (String) model.getValueAt(selectedRow, 1);

            try {
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "1287");
                String query = "DELETE FROM medicinetable WHERE medicine_name = ?";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, medicineName);
                stmt.executeUpdate();
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "An error occurred while deleting the medicine from the database.");
                return;
            }

            medicineList.remove(selectedRow);
            model.removeRow(selectedRow);
            JOptionPane.showMessageDialog(this, "Medicine sucsessfully removed");
        } else {
            JOptionPane.showMessageDialog(this, "Please select a medicine to delete.");
        }
    }//GEN-LAST:event_btnDeleteMedicineActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnViewActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MedicineListBackUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MedicineListBackUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MedicineListBackUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MedicineListBackUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MedicineListBackUp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddMedicine;
    private javax.swing.JButton btnCloseWindows;
    private javax.swing.JButton btnDeleteMedicine;
    private javax.swing.JButton btnView;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableMedicine;
    private javax.swing.JTextField txtDailyDose;
    private javax.swing.JTextField txtDose;
    private javax.swing.JTextField txtExpDate;
    private javax.swing.JTextField txtHowToUse;
    private javax.swing.JTextField txtIssuedDate;
    private javax.swing.JTextField txtMedicineId;
    private javax.swing.JTextField txtMedicineName1;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtStorage;
    // End of variables declaration//GEN-END:variables
}
