package Panel.Admin;

import User.DeliveryRunner;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CHENG WEI QUAN TP071634
 */
public class CreateDeliveryRunner extends javax.swing.JPanel {
    private final DefaultTableModel modelRunnerCreate = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column){
            return false;
        }
    };
    private final String[] runnerColumn = {"Pending ID", "Name", "Gender", "Phone Number", "Email Address"};
    private DeliveryRunner selectedRunner;
    
    public CreateDeliveryRunner() {
        initComponents();
        modelRunnerCreate.setColumnIdentifiers(runnerColumn);
        tableDeliveryRunner.setModel(modelRunnerCreate);
        displayPendingDeliveryRunners();
    }
    
    public final void displayPendingDeliveryRunners() {
        btnApproveRunner.setEnabled(false);
        btnRejectRunner.setEnabled(false);
        
        selectedRunner = null;
        modelRunnerCreate.setRowCount(0);
        
        DeliveryRunner runners = new DeliveryRunner();
        ArrayList<DeliveryRunner> runnerList = runners.getDeliveryRunnerList(true);
        
        for (DeliveryRunner pendingRunner : runnerList) {
            String[] tableData = {pendingRunner.getId(), pendingRunner.getName(), pendingRunner.getGender(),
                pendingRunner.getPhoneNumber(), pendingRunner.getEmailAddress()};
            modelRunnerCreate.addRow(tableData);
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

        scrollTableDeliveryRunner = new javax.swing.JScrollPane();
        tableDeliveryRunner = new javax.swing.JTable();
        btnRejectRunner = new javax.swing.JButton();
        btnApproveRunner = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableDeliveryRunner.setModel(modelRunnerCreate);
        tableDeliveryRunner.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableDeliveryRunnerMouseReleased(evt);
            }
        });
        scrollTableDeliveryRunner.setViewportView(tableDeliveryRunner);

        add(scrollTableDeliveryRunner, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 900, 470));

        btnRejectRunner.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 21)); // NOI18N
        btnRejectRunner.setText("Reject");
        btnRejectRunner.setEnabled(false);
        btnRejectRunner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRejectRunnerActionPerformed(evt);
            }
        });
        add(btnRejectRunner, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 500, 140, 50));

        btnApproveRunner.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 21)); // NOI18N
        btnApproveRunner.setText("Approve");
        btnApproveRunner.setEnabled(false);
        btnApproveRunner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApproveRunnerActionPerformed(evt);
            }
        });
        add(btnApproveRunner, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 500, 140, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void btnRejectRunnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRejectRunnerActionPerformed
        if (selectedRunner != null) {
            if (selectedRunner.removePendingUser()) {
                JOptionPane.showMessageDialog(this, "Delivery runner registration rejected.");
            } else {
                JOptionPane.showMessageDialog(this, "Unable to reject delivery runner registration. Please try again.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a pending delivery runner form the table to reject their registration.");
        }
        displayPendingDeliveryRunners();
    }//GEN-LAST:event_btnRejectRunnerActionPerformed

    private void btnApproveRunnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApproveRunnerActionPerformed
        if (selectedRunner != null) {
            selectedRunner.removePendingUser();
            
            selectedRunner.setId(selectedRunner.generateDeliveryRunnerID());
            selectedRunner.getUserLogin().setId(selectedRunner.getId());
            
            if (selectedRunner.createUser()) {
                JOptionPane.showMessageDialog(this, "Delivery runner registration successful.");
            } else {
                JOptionPane.showMessageDialog(this, "Delivery runner registration unsuccessful. Please try again.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a pending delivery runner form the table to register them.");
        }
        displayPendingDeliveryRunners();
    }//GEN-LAST:event_btnApproveRunnerActionPerformed

    private void tableDeliveryRunnerMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDeliveryRunnerMouseReleased
        int row = tableDeliveryRunner.getSelectedRow();
        if (row >= 0) {
            String id = String.valueOf(tableDeliveryRunner.getValueAt(row, 0));
            selectedRunner = new DeliveryRunner(id).getUser(true);
            
            btnApproveRunner.setEnabled(true);
            btnRejectRunner.setEnabled(true);
        } else {
            btnApproveRunner.setEnabled(false);
            btnRejectRunner.setEnabled(false);
        }
    }//GEN-LAST:event_tableDeliveryRunnerMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApproveRunner;
    private javax.swing.JButton btnRejectRunner;
    private javax.swing.JScrollPane scrollTableDeliveryRunner;
    private javax.swing.JTable tableDeliveryRunner;
    // End of variables declaration//GEN-END:variables
}