package Frame.Registration;

import Frame.Login.LoginFrame;
import User.DeliveryRunner;
import javax.swing.JOptionPane;

/**
 *
 * @author CHOK QI YANG TP070091
 */
public class DeliveryRunnerRegistration extends javax.swing.JFrame {

    public DeliveryRunnerRegistration() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        genderGroup = new javax.swing.ButtonGroup();
        registrationPanel = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblEmailAddress = new javax.swing.JLabel();
        lblPhoneNumber = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        lblConfirmPassword = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtEmailAddress = new javax.swing.JTextField();
        txtPhoneNumber = new javax.swing.JTextField();
        rbtnMale = new javax.swing.JRadioButton();
        rbtnFemale = new javax.swing.JRadioButton();
        txtPassword = new javax.swing.JPasswordField();
        txtConfirmPassword = new javax.swing.JPasswordField();
        btnRegister = new javax.swing.JButton();
        btnBackToLogin = new javax.swing.JButton();
        lblNameError = new javax.swing.JLabel();
        lblEmailError = new javax.swing.JLabel();
        lblPhoneError = new javax.swing.JLabel();
        lblPasswordError = new javax.swing.JLabel();
        lblConfirmPasswordError = new javax.swing.JLabel();
        lblGenderError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Delivery Runner Registration");
        setMinimumSize(new java.awt.Dimension(800, 500));

        registrationPanel.setBackground(new java.awt.Color(255, 255, 255));

        lblTitle.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Delivery Runner Registration");

        lblName.setFont(new java.awt.Font("Dubai Light", 0, 18)); // NOI18N
        lblName.setText("*Name:");

        lblEmailAddress.setFont(new java.awt.Font("Dubai Light", 0, 18)); // NOI18N
        lblEmailAddress.setText("*Email Address:");

        lblPhoneNumber.setFont(new java.awt.Font("Dubai Light", 0, 18)); // NOI18N
        lblPhoneNumber.setText("*Phone Number:");

        lblGender.setFont(new java.awt.Font("Dubai Light", 0, 18)); // NOI18N
        lblGender.setText("*Gender:");

        lblPassword.setFont(new java.awt.Font("Dubai Light", 0, 18)); // NOI18N
        lblPassword.setText("*Password:");

        lblConfirmPassword.setFont(new java.awt.Font("Dubai Light", 0, 18)); // NOI18N
        lblConfirmPassword.setText("*Confirm Password:");

        txtName.setFont(new java.awt.Font("Dubai Light", 0, 18)); // NOI18N

        txtEmailAddress.setFont(new java.awt.Font("Dubai Light", 0, 18)); // NOI18N
        txtEmailAddress.setToolTipText("Must include '@' and '.com'");

        txtPhoneNumber.setFont(new java.awt.Font("Dubai Light", 0, 18)); // NOI18N
        txtPhoneNumber.setText("e.g., 0161118888");
        txtPhoneNumber.setToolTipText("e.g., 0161118888");

        genderGroup.add(rbtnMale);
        rbtnMale.setFont(new java.awt.Font("Dubai Light", 0, 18)); // NOI18N
        rbtnMale.setSelected(true);
        rbtnMale.setText("Male");

        genderGroup.add(rbtnFemale);
        rbtnFemale.setFont(new java.awt.Font("Dubai Light", 0, 18)); // NOI18N
        rbtnFemale.setText("Female");

        txtPassword.setFont(new java.awt.Font("Dubai Light", 0, 18)); // NOI18N
        txtPassword.setToolTipText("Setting a more complex password will help protect you!");

        txtConfirmPassword.setFont(new java.awt.Font("Dubai Light", 0, 18)); // NOI18N
        txtConfirmPassword.setToolTipText("Make sure it is the same as the password!");

        btnRegister.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 18)); // NOI18N
        btnRegister.setText("Register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        btnBackToLogin.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 18)); // NOI18N
        btnBackToLogin.setText("Back to Login");
        btnBackToLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackToLoginActionPerformed(evt);
            }
        });

        lblNameError.setFont(new java.awt.Font("Dubai Light", 0, 14)); // NOI18N
        lblNameError.setForeground(new java.awt.Color(204, 0, 51));

        lblEmailError.setFont(new java.awt.Font("Dubai Light", 0, 14)); // NOI18N
        lblEmailError.setForeground(new java.awt.Color(204, 0, 51));

        lblPhoneError.setFont(new java.awt.Font("Dubai Light", 0, 14)); // NOI18N
        lblPhoneError.setForeground(new java.awt.Color(204, 0, 51));

        lblPasswordError.setFont(new java.awt.Font("Dubai Light", 0, 14)); // NOI18N
        lblPasswordError.setForeground(new java.awt.Color(204, 0, 51));

        lblConfirmPasswordError.setFont(new java.awt.Font("Dubai Light", 0, 14)); // NOI18N
        lblConfirmPasswordError.setForeground(new java.awt.Color(204, 0, 51));

        lblGenderError.setFont(new java.awt.Font("Dubai Light", 0, 14)); // NOI18N
        lblGenderError.setForeground(new java.awt.Color(204, 0, 51));

        javax.swing.GroupLayout registrationPanelLayout = new javax.swing.GroupLayout(registrationPanel);
        registrationPanel.setLayout(registrationPanelLayout);
        registrationPanelLayout.setHorizontalGroup(
            registrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(registrationPanelLayout.createSequentialGroup()
                .addGroup(registrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(registrationPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBackToLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(registrationPanelLayout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addGroup(registrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblName, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblEmailAddress, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblPhoneNumber, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblGender, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblPassword, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblConfirmPassword, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(registrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtName)
                            .addComponent(txtEmailAddress)
                            .addComponent(txtPhoneNumber)
                            .addGroup(registrationPanelLayout.createSequentialGroup()
                                .addComponent(rbtnMale)
                                .addGap(18, 18, 18)
                                .addComponent(rbtnFemale))
                            .addComponent(txtPassword)
                            .addComponent(txtConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(registrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNameError)
                            .addComponent(lblEmailError)
                            .addComponent(lblPhoneError)
                            .addComponent(lblPasswordError)
                            .addComponent(lblConfirmPasswordError)
                            .addComponent(lblGenderError)))
                    .addGroup(registrationPanelLayout.createSequentialGroup()
                        .addGap(312, 312, 312)
                        .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(228, Short.MAX_VALUE))
        );
        registrationPanelLayout.setVerticalGroup(
            registrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registrationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addGroup(registrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNameError))
                .addGap(12, 12, 12)
                .addGroup(registrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmailAddress)
                    .addComponent(txtEmailAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmailError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(registrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhoneNumber)
                    .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPhoneError))
                .addGap(12, 12, 12)
                .addGroup(registrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGender)
                    .addComponent(rbtnMale, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtnFemale, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGenderError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(registrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPasswordError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(registrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblConfirmPassword)
                    .addComponent(txtConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblConfirmPasswordError))
                .addGap(18, 18, 18)
                .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(btnBackToLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(registrationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(registrationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void clearErrorLabels() {
        lblNameError.setText("");
        lblEmailError.setText("");
        lblPhoneError.setText("");
        lblGenderError.setText("");
        lblPasswordError.setText("");
        lblConfirmPasswordError.setText("");
    }
    
    
    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        clearErrorLabels();
        
        String name = txtName.getText();
        String emailAddress = txtEmailAddress.getText();
        String phoneNumber = txtPhoneNumber.getText();
        
        String gender;
        if (rbtnMale.isSelected()) {
            gender = rbtnMale.getText();
        } else {
            gender = rbtnFemale.getText();
        }
        
        String password = txtPassword.getText();
        String confirmPassword = txtConfirmPassword.getText();
        
        int error = 0;
        
        if (name.isEmpty()) {
            lblNameError.setText("Invalid first name");
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
        } else if (confirmPassword.isEmpty()){
            lblConfirmPasswordError.setText("Please re-enter password");
            error++;
        } else if (!password.equals(confirmPassword)){
            lblConfirmPasswordError.setText("Both passwords do not match");
            error++;
        }
        
        if (error == 0) {
            DeliveryRunner newRunner = new DeliveryRunner(name, emailAddress, phoneNumber, gender, password);
            Boolean dataRecordResults = newRunner.recordData("Pending Users");
            
            if (dataRecordResults == true) {
                JOptionPane.showMessageDialog(this, "Sign-up successful.");
                btnBackToLogin.doClick();
            } else {
                JOptionPane.showMessageDialog(this, "Sign-up unsuccessful. Please try again.");
            }
        }
        
    }//GEN-LAST:event_btnRegisterActionPerformed
 
    private void btnBackToLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackToLoginActionPerformed
        dispose();
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setVisible(true);
    }//GEN-LAST:event_btnBackToLoginActionPerformed

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
        }
        catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DeliveryRunnerRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeliveryRunnerRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeliveryRunnerRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeliveryRunnerRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DeliveryRunnerRegistration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBackToLogin;
    private javax.swing.JButton btnRegister;
    private javax.swing.ButtonGroup genderGroup;
    private javax.swing.JLabel lblConfirmPassword;
    private javax.swing.JLabel lblConfirmPasswordError;
    private javax.swing.JLabel lblEmailAddress;
    private javax.swing.JLabel lblEmailError;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblGenderError;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNameError;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPasswordError;
    private javax.swing.JLabel lblPhoneError;
    private javax.swing.JLabel lblPhoneNumber;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JRadioButton rbtnFemale;
    private javax.swing.JRadioButton rbtnMale;
    private javax.swing.JPanel registrationPanel;
    private javax.swing.JPasswordField txtConfirmPassword;
    private javax.swing.JTextField txtEmailAddress;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPhoneNumber;
    // End of variables declaration//GEN-END:variables
}