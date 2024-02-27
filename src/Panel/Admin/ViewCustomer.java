package Panel.Admin;

import User.Customer;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CHENG WEI QUAN TP071634
 */
public class ViewCustomer extends javax.swing.JPanel {
    private final DefaultTableModel modelViewCustomer = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column){
            return false;
        }
    };
    private final String[] viewCustomerColumn = {"No.","ID","Name","Gender","Phone Number","Email Address"};
    
    private int row;
    private Customer selectedCustomer;
    
    public ViewCustomer() {
        initComponents();
        modelViewCustomer.setColumnIdentifiers(viewCustomerColumn);
        tableCustomer.setModel(modelViewCustomer);
        displayCustomers();
    }

    public final void displayCustomers() {
        clearTextField();
        modelViewCustomer.setRowCount(0);
        selectedCustomer = null;
        row = -1;
        
        tfEditName.setEnabled(false);
        tfEditPhoneNumber.setEnabled(false);
        tfEditEmail.setEnabled(false);
        btnSaveCustomer.setEnabled(false);
        btnDeleteCustomer.setEnabled(true);

        int number = 0;
        Customer customers = new Customer();
        ArrayList<Customer> customerList = customers.getCustomerList(false);
        
        if (!customerList.isEmpty()) {
            for (Customer customer : customerList) {
                number++;
                String[] tableData = {String.valueOf(number), customer.getId(), customer.getName(),
                    customer.getGender(), customer.getPhoneNumber(), customer.getEmailAddress()};
                modelViewCustomer.addRow(tableData);
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

        jScrollPaneCustomer = new javax.swing.JScrollPane();
        tableCustomer = new javax.swing.JTable();
        btnEditCustomer = new javax.swing.JButton();
        btnSaveCustomer = new javax.swing.JButton();
        btnDeleteCustomer = new javax.swing.JButton();
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

        setMaximumSize(new java.awt.Dimension(930, 550));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableCustomer.setModel(modelViewCustomer);
        tableCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableCustomerMouseReleased(evt);
            }
        });
        jScrollPaneCustomer.setViewportView(tableCustomer);

        add(jScrollPaneCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 660, 540));

        btnEditCustomer.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 21)); // NOI18N
        btnEditCustomer.setText("Edit");
        btnEditCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditCustomerActionPerformed(evt);
            }
        });
        add(btnEditCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 350, 140, 50));

        btnSaveCustomer.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 21)); // NOI18N
        btnSaveCustomer.setText("Save");
        btnSaveCustomer.setEnabled(false);
        btnSaveCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveCustomerActionPerformed(evt);
            }
        });
        add(btnSaveCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 420, 140, 50));

        btnDeleteCustomer.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 21)); // NOI18N
        btnDeleteCustomer.setText("Delete");
        btnDeleteCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCustomerActionPerformed(evt);
            }
        });
        add(btnDeleteCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 490, 140, 50));

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

    private void btnEditCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditCustomerActionPerformed
        row = tableCustomer.getSelectedRow();
        if (row >= 0) {
            tfEditName.setEnabled(true);
            tfEditPhoneNumber.setEnabled(true);
            tfEditEmail.setEnabled(true);
            btnSaveCustomer.setEnabled(true);
            btnDeleteCustomer.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a customer from the table to edit.");
        }
    }//GEN-LAST:event_btnEditCustomerActionPerformed

    private void btnSaveCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveCustomerActionPerformed
        String name = tfEditName.getText();
        String emailAddress = tfEditEmail.getText();
        String phoneNumber = tfEditPhoneNumber.getText();
        
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
            selectedCustomer.setName(name);
            selectedCustomer.setPhoneNumber(phoneNumber);
            selectedCustomer.setEmailAddress(emailAddress);
            
            if (selectedCustomer.updateUser()) {
                JOptionPane.showMessageDialog(this, "Update successful.");
                selectedCustomer = null;
            } else {
                JOptionPane.showMessageDialog(this, "Update unsuccessful. Please try again.");
            }
            displayCustomers();
            btnSaveCustomer.setEnabled(false);
            clearTextField();
        }
    }//GEN-LAST:event_btnSaveCustomerActionPerformed

    private void btnDeleteCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCustomerActionPerformed
        row = tableCustomer.getSelectedRow();
        if(row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a customer to delete.");
        }
        else{
            if (selectedCustomer.removeUser()) {
                JOptionPane.showMessageDialog(this, "Customer deleted.");
            } else {
                JOptionPane.showMessageDialog(this, "Unable to delete customer. Please try again.");
            }
            displayCustomers();
        }
    }//GEN-LAST:event_btnDeleteCustomerActionPerformed

    private void tableCustomerMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCustomerMouseReleased
        row = tableCustomer.getSelectedRow();
        
        if (row >= 0) {
            String id = String.valueOf(tableCustomer.getValueAt(row, 1));
            selectedCustomer = (Customer) new Customer(id).getUser(false);
            
            lblEditID.setText(selectedCustomer.getId());
            tfEditName.setText(selectedCustomer.getName());
            lblEditGender.setText(selectedCustomer.getGender());
            tfEditPhoneNumber.setText(selectedCustomer.getPhoneNumber());
            tfEditEmail.setText(selectedCustomer.getEmailAddress());
        }    
    }//GEN-LAST:event_tableCustomerMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteCustomer;
    private javax.swing.JButton btnEditCustomer;
    private javax.swing.JButton btnSaveCustomer;
    private javax.swing.JScrollPane jScrollPaneCustomer;
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
    private javax.swing.JTable tableCustomer;
    private javax.swing.JTextField tfEditEmail;
    private javax.swing.JTextField tfEditName;
    private javax.swing.JTextField tfEditPhoneNumber;
    // End of variables declaration//GEN-END:variables
}
