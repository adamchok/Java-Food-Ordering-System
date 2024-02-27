/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Panel.Admin;

import User.Vendor;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dixon
 */
public class ViewVendor extends javax.swing.JPanel {

    private final DefaultTableModel modelViewVendor = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column){
            return false;
        }
    };
    private final String[] viewVendorColumn = {"ID","Name","Cuisine","Location","Services","Phone Number","Email Address"};
    private int row;
    private Vendor selectedVendor;
    
    public ViewVendor() {
        initComponents();
        modelViewVendor.setColumnIdentifiers(viewVendorColumn);
        tableVendor.setModel(modelViewVendor);
        displayVendors();
    }

    public final void displayVendors() {
        modelViewVendor.setRowCount(0);
        clearTextField();
        tfEditName.setEnabled(false);
        tfEditAddress.setEnabled(false);
        tfEditServiceType.setEnabled(false);
        tfEditCuisine.setEnabled(false);
        tfEditEmail.setEnabled(false);
        tfEditPhoneNumber.setEnabled(false);
        btnSaveVendor.setEnabled(false);
        btnDeleteVendor.setEnabled(true);
        
        Vendor vendors = new Vendor();
        ArrayList<Vendor> vendorList = vendors.getVendorList(false);
        for (Vendor vendor : vendorList) {
            String[] tableData = {vendor.getId(), vendor.getName(), vendor.getCuisine(),
                vendor.getLocation(), vendor.getServices(), vendor.getPhoneNumber(), vendor.getEmailAddress()};
            modelViewVendor.addRow(tableData);
        }
    }
    
    public void clearTextField(){
        lblEditID.setText("");
        tfEditName.setText("");
        tfEditCuisine.setText("");
        tfEditServiceType.setText("");
        tfEditAddress.setText("");
        tfEditPhoneNumber.setText("");
        tfEditEmail.setText(""); 
        lblCuisineInvalid.setText("");
        lblNameInvalid.setText("");
        lblEmailInvalid.setText("");
        lblServiceTypeInvalid.setText("");
        lblPhoneNumberInvalid.setText("");
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPaneVendor = new javax.swing.JScrollPane();
        tableVendor = new javax.swing.JTable();
        lblID = new javax.swing.JLabel();
        lblEditID = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblNameInvalid = new javax.swing.JLabel();
        tfEditName = new javax.swing.JTextField();
        lblCuisine = new javax.swing.JLabel();
        tfEditCuisine = new javax.swing.JTextField();
        lblPhoneNumber = new javax.swing.JLabel();
        lblServiceTypeInvalid = new javax.swing.JLabel();
        tfEditServiceType = new javax.swing.JTextField();
        lblEmailAddress = new javax.swing.JLabel();
        lblEmailInvalid = new javax.swing.JLabel();
        tfEditEmail = new javax.swing.JTextField();
        btnEditVendor = new javax.swing.JButton();
        btnSaveVendor = new javax.swing.JButton();
        btnDeleteVendor = new javax.swing.JButton();
        lblCuisineInvalid = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblServiceType = new javax.swing.JLabel();
        tfEditPhoneNumber = new javax.swing.JTextField();
        taAddress = new javax.swing.JScrollPane();
        tfEditAddress = new javax.swing.JTextArea();
        lblPhoneNumberInvalid = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableVendor.setModel(modelViewVendor);
        tableVendor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableVendorMouseReleased(evt);
            }
        });
        jScrollPaneVendor.setViewportView(tableVendor);

        add(jScrollPaneVendor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 650, 540));

        lblID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblID.setText("ID:");
        add(lblID, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 20, -1, -1));

        lblEditID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        add(lblEditID, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 20, 220, 20));

        lblName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblName.setText("Name:");
        add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 50, -1, 20));

        lblNameInvalid.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblNameInvalid.setForeground(new java.awt.Color(255, 0, 51));
        lblNameInvalid.setText("Invalid!");
        add(lblNameInvalid, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 60, 60, 20));

        tfEditName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tfEditName.setEnabled(false);
        add(tfEditName, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 80, 250, 30));

        lblCuisine.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCuisine.setText("Cuisine:");
        add(lblCuisine, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 120, -1, 20));

        tfEditCuisine.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tfEditCuisine.setEnabled(false);
        add(tfEditCuisine, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 150, 250, 30));

        lblPhoneNumber.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblPhoneNumber.setText("Phone Number:");
        add(lblPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 370, -1, 20));

        lblServiceTypeInvalid.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblServiceTypeInvalid.setForeground(new java.awt.Color(255, 0, 51));
        lblServiceTypeInvalid.setText("Invalid!");
        add(lblServiceTypeInvalid, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 310, 60, 20));

        tfEditServiceType.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tfEditServiceType.setEnabled(false);
        add(tfEditServiceType, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 330, 250, -1));

        lblEmailAddress.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblEmailAddress.setText("Email Address:");
        add(lblEmailAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 440, -1, 20));

        lblEmailInvalid.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblEmailInvalid.setForeground(new java.awt.Color(255, 0, 51));
        lblEmailInvalid.setText("Invalid!");
        add(lblEmailInvalid, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 450, 60, -1));

        tfEditEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tfEditEmail.setEnabled(false);
        add(tfEditEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 470, 250, -1));

        btnEditVendor.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 18)); // NOI18N
        btnEditVendor.setText("Edit");
        btnEditVendor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditVendorActionPerformed(evt);
            }
        });
        add(btnEditVendor, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 510, 70, 40));

        btnSaveVendor.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 18)); // NOI18N
        btnSaveVendor.setText("Save");
        btnSaveVendor.setEnabled(false);
        btnSaveVendor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveVendorActionPerformed(evt);
            }
        });
        add(btnSaveVendor, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 510, 70, 40));

        btnDeleteVendor.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 18)); // NOI18N
        btnDeleteVendor.setText("Delete");
        btnDeleteVendor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteVendorActionPerformed(evt);
            }
        });
        add(btnDeleteVendor, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 510, 90, 40));

        lblCuisineInvalid.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblCuisineInvalid.setForeground(new java.awt.Color(255, 0, 51));
        lblCuisineInvalid.setText("Invalid!");
        add(lblCuisineInvalid, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 130, 60, 20));

        lblAddress.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblAddress.setText("Address:");
        add(lblAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 190, -1, -1));

        lblServiceType.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblServiceType.setText("Service Type:");
        add(lblServiceType, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 300, -1, -1));

        tfEditPhoneNumber.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tfEditPhoneNumber.setEnabled(false);
        add(tfEditPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 400, 250, -1));

        tfEditAddress.setEditable(false);
        tfEditAddress.setColumns(20);
        tfEditAddress.setLineWrap(true);
        tfEditAddress.setWrapStyleWord(true);
        tfEditAddress.setEnabled(false);
        taAddress.setViewportView(tfEditAddress);

        add(taAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 220, 250, 80));

        lblPhoneNumberInvalid.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblPhoneNumberInvalid.setForeground(new java.awt.Color(255, 0, 51));
        lblPhoneNumberInvalid.setText("Invalid!");
        add(lblPhoneNumberInvalid, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 380, 60, 20));
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditVendorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditVendorActionPerformed
        row = tableVendor.getSelectedRow();
        if (row >= 0) {
            tfEditCuisine.setEnabled(true);
            tfEditEmail.setEnabled(true);
            tfEditPhoneNumber.setEnabled(true);
            btnSaveVendor.setEnabled(true);
            btnDeleteVendor.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a vendor from the table to edit.");
        }
    }//GEN-LAST:event_btnEditVendorActionPerformed

    private void btnSaveVendorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveVendorActionPerformed
        String name = tfEditName.getText();
        String cuisine = tfEditCuisine.getText();
        String address = tfEditAddress.getText();
        String serviceType = tfEditServiceType.getText();
        String emailAddress = tfEditEmail.getText();
        String phoneNumber = tfEditPhoneNumber.getText();
        
        int error = 0;

        if (name.isEmpty()) {
            lblNameInvalid.setText("Invalid!");
            error++;
        }
        if (cuisine.isEmpty()) {
            lblCuisineInvalid.setText("Invalid!");
            error++;
        }
        if (serviceType.isEmpty()) {
            lblServiceTypeInvalid.setText("Invalid!");
            error++;
        }
        if (emailAddress.isEmpty() || !emailAddress.contains("@") || !emailAddress.contains(".com")) {
            lblEmailInvalid.setText("Invalid!");
            error++;
        }
        if (phoneNumber.isEmpty() || phoneNumber.length() != 10) {
            lblPhoneNumberInvalid.setText("Invalid!");
            error++;
        }
        
        if (error == 0) {
            selectedVendor.setName(name);
            selectedVendor.setCuisine(cuisine);
            selectedVendor.setRestaurantAddress(address);
            selectedVendor.setPhoneNumber(phoneNumber);
            selectedVendor.setEmailAddress(emailAddress);
            
            if (selectedVendor.updateUser()) {
                JOptionPane.showMessageDialog(this, "Update successful.");
            } else {
                JOptionPane.showMessageDialog(this, "Update unsuccessful.");
            }
            displayVendors();
            btnSaveVendor.setEnabled(false);
            clearTextField();
        }
    }//GEN-LAST:event_btnSaveVendorActionPerformed

    private void btnDeleteVendorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteVendorActionPerformed
        row = tableVendor.getSelectedRow();
        if(row == -1) {
            JOptionPane.showMessageDialog(null, "Please select a row to delete!");
        }
        else {
            if (selectedVendor.removeUser()) {
                JOptionPane.showMessageDialog(this, "Vendor deleted.");
            } else {
                JOptionPane.showMessageDialog(this, "Unable to delete vendor. Please try again.");
            }
            displayVendors();
        }
    }//GEN-LAST:event_btnDeleteVendorActionPerformed

    private void tableVendorMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableVendorMouseReleased
        row = tableVendor.getSelectedRow();
        selectedVendor = null;
        if (row >= 0) {
            String id = String.valueOf(tableVendor.getValueAt(row, 0));
            selectedVendor = (Vendor) new Vendor(id).getObject("Vendor");
            if (selectedVendor != null) {
                lblEditID.setText(selectedVendor.getId());
                tfEditName.setText(selectedVendor.getName());
                tfEditCuisine.setText(selectedVendor.getCuisine());
                tfEditAddress.setText(selectedVendor.getRestaurantAddress());
                tfEditServiceType.setText(selectedVendor.getServices());
                tfEditEmail.setText(selectedVendor.getEmailAddress());
                tfEditPhoneNumber.setText(selectedVendor.getPhoneNumber());
            }
        }
    }//GEN-LAST:event_tableVendorMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteVendor;
    private javax.swing.JButton btnEditVendor;
    private javax.swing.JButton btnSaveVendor;
    private javax.swing.JScrollPane jScrollPaneVendor;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblCuisine;
    private javax.swing.JLabel lblCuisineInvalid;
    private javax.swing.JLabel lblEditID;
    private javax.swing.JLabel lblEmailAddress;
    private javax.swing.JLabel lblEmailInvalid;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNameInvalid;
    private javax.swing.JLabel lblPhoneNumber;
    private javax.swing.JLabel lblPhoneNumberInvalid;
    private javax.swing.JLabel lblServiceType;
    private javax.swing.JLabel lblServiceTypeInvalid;
    private javax.swing.JScrollPane taAddress;
    private javax.swing.JTable tableVendor;
    private javax.swing.JTextArea tfEditAddress;
    private javax.swing.JTextField tfEditCuisine;
    private javax.swing.JTextField tfEditEmail;
    private javax.swing.JTextField tfEditName;
    private javax.swing.JTextField tfEditPhoneNumber;
    private javax.swing.JTextField tfEditServiceType;
    // End of variables declaration//GEN-END:variables
}
