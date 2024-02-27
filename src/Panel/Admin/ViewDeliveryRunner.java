package Panel.Admin;

import Notification.Notification;
import Order.DeliveryTask;
import Review.DeliveryReview;
import User.DeliveryRunner;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CHENG WEI QUAN TP071634
 */
public class ViewDeliveryRunner extends javax.swing.JPanel {
    private final DefaultTableModel modelViewRunner = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column){
            return false;
        }
    };
    private final String[] viewRunnerColumn = {"No.","ID","Name","Gender","Phone Number","Email Address"};
    
    private int row;
    private DeliveryRunner selectedRunner;
    
    public ViewDeliveryRunner() {
        initComponents();
        modelViewRunner.setColumnIdentifiers(viewRunnerColumn);
        tableRunner.setModel(modelViewRunner);
        displayDeliveryRunners();
    }

    public final void displayDeliveryRunners() {
        modelViewRunner.setRowCount(0);
        clearTextField();
        selectedRunner = null;
        row = -1;
        
        tfEditName.setEnabled(false);
        tfEditPhoneNumber.setEnabled(false);
        tfEditEmail.setEnabled(false);
        btnSaveRunner.setEnabled(false);
        btnDeleteRunner.setEnabled(true);

        int number = 0;
        DeliveryRunner runners = new DeliveryRunner();
        ArrayList<DeliveryRunner> runnerList = runners.getDeliveryRunnerList(false);
        
        if (!runnerList.isEmpty()) {
            for (DeliveryRunner runner : runnerList) {
                number++;
                String[] tableData = {String.valueOf(number), runner.getId(), runner.getName(),
                    runner.getGender(), runner.getPhoneNumber(), runner.getEmailAddress()};
                modelViewRunner.addRow(tableData);
            }
        }
    }
    
    public void clearTextField(){
        lblEditID.setText("");
        tfEditName.setText("");
        lblEditGender.setText("");
        tfEditPhoneNumber.setText("");
        tfEditEmail.setText("");  
        lblNameInvalid.setText("");
        lblEmailInvalid.setText("");
        lblPhoneNumberInvalid.setText("");
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPaneRunner = new javax.swing.JScrollPane();
        tableRunner = new javax.swing.JTable();
        btnEditRunner = new javax.swing.JButton();
        btnSaveRunner = new javax.swing.JButton();
        btnDeleteRunner = new javax.swing.JButton();
        lblID = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        lblPhoneNumber = new javax.swing.JLabel();
        lblEmailAddress = new javax.swing.JLabel();
        lblEditGender = new javax.swing.JLabel();
        tfEditEmail = new javax.swing.JTextField();
        lblEditID = new javax.swing.JLabel();
        tfEditName = new javax.swing.JTextField();
        tfEditPhoneNumber = new javax.swing.JTextField();
        lblNameInvalid = new javax.swing.JLabel();
        lblPhoneNumberInvalid = new javax.swing.JLabel();
        lblEmailInvalid = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableRunner.setModel(modelViewRunner);
        tableRunner.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableRunnerMouseReleased(evt);
            }
        });
        jScrollPaneRunner.setViewportView(tableRunner);

        add(jScrollPaneRunner, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 660, 540));

        btnEditRunner.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 21)); // NOI18N
        btnEditRunner.setText("Edit");
        btnEditRunner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditRunnerActionPerformed(evt);
            }
        });
        add(btnEditRunner, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 350, 140, 50));

        btnSaveRunner.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 21)); // NOI18N
        btnSaveRunner.setText("Save");
        btnSaveRunner.setEnabled(false);
        btnSaveRunner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveRunnerActionPerformed(evt);
            }
        });
        add(btnSaveRunner, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 420, 140, 50));

        btnDeleteRunner.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 21)); // NOI18N
        btnDeleteRunner.setText("Delete");
        btnDeleteRunner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteRunnerActionPerformed(evt);
            }
        });
        add(btnDeleteRunner, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 490, 140, 50));

        lblID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblID.setText("ID:");
        add(lblID, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 50, -1, -1));

        lblName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblName.setText("Name:");
        add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 90, -1, 20));

        lblGender.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblGender.setText("Gender:");
        add(lblGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 160, -1, 20));

        lblPhoneNumber.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblPhoneNumber.setText("Phone Number:");
        add(lblPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 200, -1, 20));

        lblEmailAddress.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblEmailAddress.setText("Email Address:");
        add(lblEmailAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 270, -1, 20));

        lblEditGender.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        add(lblEditGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 160, 160, 20));

        tfEditEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tfEditEmail.setEnabled(false);
        add(tfEditEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 300, 220, -1));

        lblEditID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        add(lblEditID, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 50, 210, 20));

        tfEditName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tfEditName.setEnabled(false);
        add(tfEditName, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 120, 220, 30));

        tfEditPhoneNumber.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tfEditPhoneNumber.setEnabled(false);
        add(tfEditPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 230, 220, -1));

        lblNameInvalid.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblNameInvalid.setForeground(new java.awt.Color(255, 0, 51));
        lblNameInvalid.setText("Invalid!");
        add(lblNameInvalid, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 100, 60, 20));

        lblPhoneNumberInvalid.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblPhoneNumberInvalid.setForeground(new java.awt.Color(255, 0, 51));
        lblPhoneNumberInvalid.setText("Invalid!");
        add(lblPhoneNumberInvalid, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 210, 60, 20));

        lblEmailInvalid.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblEmailInvalid.setForeground(new java.awt.Color(255, 0, 51));
        lblEmailInvalid.setText("Invalid!");
        add(lblEmailInvalid, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 280, 60, 20));
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditRunnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditRunnerActionPerformed
        row = tableRunner.getSelectedRow();
        if (row >= 0) {
            tfEditName.setEnabled(true);
            tfEditPhoneNumber.setEnabled(true);
            tfEditEmail.setEnabled(true);
            btnSaveRunner.setEnabled(true);
            btnDeleteRunner.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a delivery runner from the table to edit.");
        }
    }//GEN-LAST:event_btnEditRunnerActionPerformed

    private void btnSaveRunnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveRunnerActionPerformed
        String name = tfEditName.getText();
        String phoneNumber = tfEditPhoneNumber.getText();
        String emailAddress = tfEditEmail.getText();
        
        int error = 0;

        if (name.isEmpty()) {
            lblNameInvalid.setText("Invalid!");
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
            selectedRunner.setName(name);
            selectedRunner.setEmailAddress(emailAddress);
            selectedRunner.setPhoneNumber(phoneNumber);
            
            if (selectedRunner.updateUser()) {
                JOptionPane.showMessageDialog(this, "Update successful.");
            } else {
                JOptionPane.showMessageDialog(this, "Update unsuccessful. Please try again.");
            }
            displayDeliveryRunners();
            btnSaveRunner.setEnabled(false);
            clearTextField();
        }
    }//GEN-LAST:event_btnSaveRunnerActionPerformed

    private void btnDeleteRunnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteRunnerActionPerformed
        row = tableRunner.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(null, "Please select a row to delete!");
        }
        else{
            if (selectedRunner.removeUser()) {
                DeliveryReview reviews = new DeliveryReview(selectedRunner);
                reviews.deleteAllReviews();
                DeliveryTask tasks = new DeliveryTask(selectedRunner);
                tasks.deleteAllTasks();
                Notification tempNotification = new Notification(selectedRunner.getId());
                tempNotification.deleteAllNotification();
                JOptionPane.showMessageDialog(this, "Delivery runner deleted.");
            } else {
                JOptionPane.showMessageDialog(this, "Unable to delete delivery runner. Please try again.");
            }
            displayDeliveryRunners();
        }
    }//GEN-LAST:event_btnDeleteRunnerActionPerformed

    private void tableRunnerMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableRunnerMouseReleased
        row = tableRunner.getSelectedRow();
        
        if (row >= 0) {
            String id = String.valueOf(tableRunner.getValueAt(row, 1));
            selectedRunner = (DeliveryRunner) new DeliveryRunner(id).getObject("Delivery Runner");
            
            lblEditID.setText(selectedRunner.getId());
            tfEditName.setText(selectedRunner.getName());
            lblEditGender.setText(selectedRunner.getGender());
            tfEditPhoneNumber.setText(selectedRunner.getPhoneNumber());
            tfEditEmail.setText(selectedRunner.getEmailAddress());
        }
        
    }//GEN-LAST:event_tableRunnerMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteRunner;
    private javax.swing.JButton btnEditRunner;
    private javax.swing.JButton btnSaveRunner;
    private javax.swing.JScrollPane jScrollPaneRunner;
    private javax.swing.JLabel lblEditGender;
    private javax.swing.JLabel lblEditID;
    private javax.swing.JLabel lblEmailAddress;
    private javax.swing.JLabel lblEmailInvalid;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNameInvalid;
    private javax.swing.JLabel lblPhoneNumber;
    private javax.swing.JLabel lblPhoneNumberInvalid;
    private javax.swing.JTable tableRunner;
    private javax.swing.JTextField tfEditEmail;
    private javax.swing.JTextField tfEditName;
    private javax.swing.JTextField tfEditPhoneNumber;
    // End of variables declaration//GEN-END:variables
}
