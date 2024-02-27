package Panel.Admin;

import User.Vendor;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CHENG WEI QUAN TP071634
 */
public class CreateVendor extends javax.swing.JPanel {
    private final DefaultTableModel modelVendorCreate = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column){
            return false;
        }
    };
    private final String[] vendorColumn = {"Pending ID", "Name", "Cuisine", "Location", "Service Type", "Phone Number", "Email Address"};
    private Vendor selectedVendor;
    
    public CreateVendor() {
        initComponents();
        modelVendorCreate.setColumnIdentifiers(vendorColumn);
        tableVendor.setModel(modelVendorCreate);
        displayPendingVendors();
    }
    
    public final void displayPendingVendors() {
        btnApproveVendor.setEnabled(false);
        btnRejectVendor.setEnabled(false);
        
        selectedVendor = null;
        modelVendorCreate.setRowCount(0);
        
        Vendor vendors = new Vendor();
        ArrayList<Vendor> vendorList = vendors.getVendorList(true);
        
        for (Vendor pendingVendor : vendorList) {
            String[] tableData = {pendingVendor.getId(), pendingVendor.getName(), pendingVendor.getCuisine(),
                pendingVendor.getLocation(), pendingVendor.getServices(), pendingVendor.getPhoneNumber(), pendingVendor.getEmailAddress()};
            modelVendorCreate.addRow(tableData);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollTableVendor = new javax.swing.JScrollPane();
        tableVendor = new javax.swing.JTable();
        btnRejectVendor = new javax.swing.JButton();
        btnApproveVendor = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableVendor.setModel(modelVendorCreate);
        tableVendor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableVendorMouseReleased(evt);
            }
        });
        scrollTableVendor.setViewportView(tableVendor);

        add(scrollTableVendor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 900, 470));

        btnRejectVendor.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 21)); // NOI18N
        btnRejectVendor.setText("Reject");
        btnRejectVendor.setEnabled(false);
        btnRejectVendor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRejectVendorActionPerformed(evt);
            }
        });
        add(btnRejectVendor, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 500, 140, 50));

        btnApproveVendor.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 21)); // NOI18N
        btnApproveVendor.setText("Approve");
        btnApproveVendor.setEnabled(false);
        btnApproveVendor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApproveVendorActionPerformed(evt);
            }
        });
        add(btnApproveVendor, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 500, 140, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void btnRejectVendorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRejectVendorActionPerformed
        if (selectedVendor != null) {
            if (selectedVendor.removePendingUser()) {
                JOptionPane.showMessageDialog(this, "Vendor registration rejected.");
            } else {
                JOptionPane.showMessageDialog(this, "Unable to reject vendor registration. Please try again.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a pending vendor form the table to reject their registration.");
        }
        displayPendingVendors();
    }//GEN-LAST:event_btnRejectVendorActionPerformed

    private void btnApproveVendorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApproveVendorActionPerformed
        if (selectedVendor != null) {
            selectedVendor.removePendingUser();
            
            selectedVendor.setId(selectedVendor.generateVendorID());
            selectedVendor.getUserLogin().setId(selectedVendor.getId());
            
            if (selectedVendor.createUser()) {
                JOptionPane.showMessageDialog(this, "Vendor registration successful.");
            } else {
                JOptionPane.showMessageDialog(this, "Vendor registration unsuccessful. Please try again.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a pending vendor form the table to register them.");
        }
        displayPendingVendors();
    }//GEN-LAST:event_btnApproveVendorActionPerformed

    private void tableVendorMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableVendorMouseReleased
        int row = tableVendor.getSelectedRow();
        if (row >= 0) {
            String id = String.valueOf(tableVendor.getValueAt(row, 0));
            selectedVendor = new Vendor(id).getUser(true);
            
            btnApproveVendor.setEnabled(true);
            btnRejectVendor.setEnabled(true);
        } else {
            btnApproveVendor.setEnabled(false);
            btnRejectVendor.setEnabled(false);
        }
    }//GEN-LAST:event_tableVendorMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApproveVendor;
    private javax.swing.JButton btnRejectVendor;
    private javax.swing.JScrollPane scrollTableVendor;
    private javax.swing.JTable tableVendor;
    // End of variables declaration//GEN-END:variables
}
