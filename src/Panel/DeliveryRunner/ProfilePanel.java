package Panel.DeliveryRunner;

import User.DeliveryRunner;
import javax.swing.JOptionPane;

/**
 *
 * @author NABIL BIN NAZME NAZIM TP072131
 */
public class ProfilePanel extends javax.swing.JPanel {
    private DeliveryRunner deliveryRunner;

    public ProfilePanel() {
        initComponents();
        btnSave.setVisible(false);
    }
    
    public void displayProfile(DeliveryRunner deliveryRunner){
        this.deliveryRunner = deliveryRunner;
        clearErrorLabels();
        txtPassword.setEchoChar('*');
        
        txtName.setText(deliveryRunner.getName());
        txtPhoneNumber.setText(deliveryRunner.getPhoneNumber());
        txtEmailAddress.setText(deliveryRunner.getEmailAddress());
        lblGenderType.setText(deliveryRunner.getGender());
        txtPassword.setText(deliveryRunner.getUserLogin().getPassword());
        
        txtName.setEnabled(false);
        txtPhoneNumber.setEnabled(false);
        txtEmailAddress.setEnabled(false);
        txtPassword.setEnabled(false);
    }
    
    public void clearErrorLabels() {
        lblNameError.setText("");
        lblEmailError.setText("");
        lblPhoneError.setText("");
        lblPasswordError.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        btnEdit = new javax.swing.JButton();
        lblNameError = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblEmailError = new javax.swing.JLabel();
        lblEmailAddress = new javax.swing.JLabel();
        lblPhoneError = new javax.swing.JLabel();
        lblPhoneNumber = new javax.swing.JLabel();
        lblPasswordError = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtEmailAddress = new javax.swing.JTextField();
        txtPhoneNumber = new javax.swing.JTextField();
        lblGenderType = new javax.swing.JLabel();
        lblCustomerRegistration1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(880, 600));
        setMinimumSize(new java.awt.Dimension(880, 600));
        setPreferredSize(new java.awt.Dimension(880, 600));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setMaximumSize(new java.awt.Dimension(880, 600));
        jPanel1.setMinimumSize(new java.awt.Dimension(880, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(880, 600));

        btnSave.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 18)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        txtPassword.setFont(new java.awt.Font("Dubai Light", 0, 18)); // NOI18N
        txtPassword.setToolTipText("Setting a more complex password will help protect you!");
        txtPassword.setEnabled(false);

        btnEdit.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 18)); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        lblNameError.setFont(new java.awt.Font("Dubai Light", 0, 18)); // NOI18N
        lblNameError.setForeground(new java.awt.Color(204, 0, 51));
        lblNameError.setText("Invalid");

        lblName.setFont(new java.awt.Font("Dubai Light", 0, 18)); // NOI18N
        lblName.setText("Name:");

        lblEmailError.setFont(new java.awt.Font("Dubai Light", 0, 18)); // NOI18N
        lblEmailError.setForeground(new java.awt.Color(204, 0, 51));
        lblEmailError.setText("Invalid");

        lblEmailAddress.setFont(new java.awt.Font("Dubai Light", 0, 18)); // NOI18N
        lblEmailAddress.setText("Email Address:");

        lblPhoneError.setFont(new java.awt.Font("Dubai Light", 0, 18)); // NOI18N
        lblPhoneError.setForeground(new java.awt.Color(204, 0, 51));
        lblPhoneError.setText("Invalid");

        lblPhoneNumber.setFont(new java.awt.Font("Dubai Light", 0, 18)); // NOI18N
        lblPhoneNumber.setText("Phone Number:");

        lblPasswordError.setFont(new java.awt.Font("Dubai Light", 0, 18)); // NOI18N
        lblPasswordError.setForeground(new java.awt.Color(204, 0, 51));
        lblPasswordError.setText("Invalid");

        lblGender.setFont(new java.awt.Font("Dubai Light", 0, 18)); // NOI18N
        lblGender.setText("Gender:");

        lblPassword.setFont(new java.awt.Font("Dubai Light", 0, 18)); // NOI18N
        lblPassword.setText("Password:");

        txtName.setFont(new java.awt.Font("Dubai Light", 0, 18)); // NOI18N
        txtName.setEnabled(false);

        txtEmailAddress.setFont(new java.awt.Font("Dubai Light", 0, 18)); // NOI18N
        txtEmailAddress.setToolTipText("Must include '@' and '.com'");
        txtEmailAddress.setEnabled(false);

        txtPhoneNumber.setFont(new java.awt.Font("Dubai Light", 0, 18)); // NOI18N
        txtPhoneNumber.setToolTipText("e.g., 0161118888");
        txtPhoneNumber.setEnabled(false);

        lblGenderType.setFont(new java.awt.Font("Dubai Light", 0, 18)); // NOI18N
        lblGenderType.setText("{Insert Gender}");

        lblCustomerRegistration1.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lblCustomerRegistration1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCustomerRegistration1.setText("Profile");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(207, 207, 207)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblName, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblEmailAddress, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblPhoneNumber, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblGender, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblPassword, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtEmailAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblEmailError))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPhoneError))
                            .addComponent(lblGenderType)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPasswordError))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNameError))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(201, Short.MAX_VALUE))
            .addComponent(lblCustomerRegistration1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblCustomerRegistration1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNameError)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmailAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmailAddress)
                    .addComponent(lblEmailError))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPhoneNumber)
                    .addComponent(lblPhoneError))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGenderType)
                    .addComponent(lblGender))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPasswordError))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(182, 182, 182))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        clearErrorLabels();

        String name = txtName.getText();
        String emailAddress = txtEmailAddress.getText();
        String phoneNumber = txtPhoneNumber.getText();
        String password = txtPassword.getText();

        int error = 0;

        if (name.isEmpty()) {
            lblNameError.setText("Invalid name");
            error++;
        }
        if (emailAddress.isEmpty() || !emailAddress.contains("@") || !emailAddress.contains(".com")) {
            lblEmailError.setText("Invalid email address");
            error++;
        }
        if (phoneNumber.isEmpty() || phoneNumber.length() != 10) {
            lblPhoneError.setText("Invalid phone number");
            error++;
        }
        if (password.isEmpty()) {
            lblPasswordError.setText("Invalid password");
            error++;
        }

        if (error == 0) {
            deliveryRunner.setName(name);
            deliveryRunner.setPhoneNumber(phoneNumber);
            deliveryRunner.setEmailAddress(emailAddress);
            deliveryRunner.updatePassword(password);
            
            deliveryRunner.getUserLogin().updateData("Login");
            if (deliveryRunner.updateData("Delivery Runner") == true) {
                JOptionPane.showMessageDialog(this, "Update successful.");
                btnSave.setVisible(false);
                displayProfile(deliveryRunner);
                
                Panel.DeliveryRunner.MainPanel parent = (MainPanel) getParent();
                parent.updateDeliveryRunner(deliveryRunner);
                
            } else {
                JOptionPane.showMessageDialog(this, "Update unsuccessful. Please try again.");
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        btnSave.setVisible(true);
        txtName.setEnabled(true);
        txtPhoneNumber.setEnabled(true);
        txtEmailAddress.setEnabled(true);
        txtPassword.setEnabled(true);
        txtPassword.setEchoChar('\0');
    }//GEN-LAST:event_btnEditActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSave;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCustomerRegistration1;
    private javax.swing.JLabel lblEmailAddress;
    private javax.swing.JLabel lblEmailError;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblGenderType;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNameError;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPasswordError;
    private javax.swing.JLabel lblPhoneError;
    private javax.swing.JLabel lblPhoneNumber;
    private javax.swing.JTextField txtEmailAddress;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPhoneNumber;
    // End of variables declaration//GEN-END:variables
}
