package Panel.Admin;

import User.Admin;
import javax.swing.JOptionPane;

/**
 *
 * @author CHENG WEI QUAN TP071634
 */
public class ProfilePanel extends javax.swing.JPanel {
    private Admin admin;
    
    public ProfilePanel() {
        initComponents();
        btnSave.setVisible(false);
    }
    
    public void displayProfile(Admin admin){
        this.admin = admin;
        clearErrorLabels();
        txtPassword.setEchoChar('*');
        
        txtName.setText(admin.getName());
        txtPhoneNumber.setText(admin.getPhoneNumber());
        txtEmailAddress.setText(admin.getEmailAddress());
        lblGenderType.setText(admin.getGender());
        txtPassword.setText(admin.getUserLogin().getPassword());
        
        txtName.setEnabled(false);
        txtPhoneNumber.setEnabled(false);
        txtEmailAddress.setEnabled(false);
        txtPassword.setEnabled(false);
    }

    public void clearErrorLabels() {
        lblNameCheck.setText("");
        lblEmailCheck.setText("");
        lblPhoneNumberCheck.setText("");
        lblPasswordCheck.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        registrationPanel = new javax.swing.JPanel();
        lblAdminRegistration = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblNameCheck = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblEmailAddress = new javax.swing.JLabel();
        lblEmailCheck = new javax.swing.JLabel();
        txtEmailAddress = new javax.swing.JTextField();
        lblPhoneNumber = new javax.swing.JLabel();
        lblPhoneNumberCheck = new javax.swing.JLabel();
        txtPhoneNumber = new javax.swing.JTextField();
        lblGender = new javax.swing.JLabel();
        lblGenderType = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        lblPasswordCheck = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnEdit = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();

        registrationPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout registrationPanelLayout = new javax.swing.GroupLayout(registrationPanel);
        registrationPanel.setLayout(registrationPanelLayout);
        registrationPanelLayout.setHorizontalGroup(
            registrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 791, Short.MAX_VALUE)
        );
        registrationPanelLayout.setVerticalGroup(
            registrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(944, 600));
        setMinimumSize(new java.awt.Dimension(944, 600));
        setPreferredSize(new java.awt.Dimension(944, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAdminRegistration.setFont(new java.awt.Font("SansSerif", 1, 43)); // NOI18N
        lblAdminRegistration.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAdminRegistration.setText("Profile");
        add(lblAdminRegistration, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 140, -1));

        lblName.setFont(new java.awt.Font("Dubai Light", 0, 18)); // NOI18N
        lblName.setText("Name:");
        add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, -1, 40));

        lblNameCheck.setFont(new java.awt.Font("Dubai Light", 0, 18)); // NOI18N
        lblNameCheck.setForeground(new java.awt.Color(204, 0, 51));
        add(lblNameCheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 120, -1, 30));

        txtName.setFont(new java.awt.Font("Dubai Light", 0, 18)); // NOI18N
        txtName.setEnabled(false);
        add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 300, 50));

        lblEmailAddress.setFont(new java.awt.Font("Dubai Light", 0, 18)); // NOI18N
        lblEmailAddress.setText("Email Address:");
        add(lblEmailAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, -1, 40));

        lblEmailCheck.setFont(new java.awt.Font("Dubai Light", 0, 18)); // NOI18N
        lblEmailCheck.setForeground(new java.awt.Color(204, 0, 51));
        add(lblEmailCheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 180, -1, 20));

        txtEmailAddress.setFont(new java.awt.Font("Dubai Light", 0, 18)); // NOI18N
        txtEmailAddress.setToolTipText("Must include '@' and '.com'");
        txtEmailAddress.setEnabled(false);
        add(txtEmailAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, 300, 50));

        lblPhoneNumber.setFont(new java.awt.Font("Dubai Light", 0, 18)); // NOI18N
        lblPhoneNumber.setText("Phone Number:");
        add(lblPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, -1, 40));

        lblPhoneNumberCheck.setFont(new java.awt.Font("Dubai Light", 0, 18)); // NOI18N
        lblPhoneNumberCheck.setForeground(new java.awt.Color(204, 0, 51));
        add(lblPhoneNumberCheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 240, -1, 20));

        txtPhoneNumber.setFont(new java.awt.Font("Dubai Light", 0, 18)); // NOI18N
        txtPhoneNumber.setToolTipText("e.g., 0161118888");
        txtPhoneNumber.setEnabled(false);
        add(txtPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, 300, 50));

        lblGender.setFont(new java.awt.Font("Dubai Light", 0, 18)); // NOI18N
        lblGender.setText("Gender:");
        add(lblGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, -1, 40));

        lblGenderType.setFont(new java.awt.Font("Dubai Light", 0, 18)); // NOI18N
        lblGenderType.setText("{Insert Gender}");
        add(lblGenderType, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 290, -1, 40));

        lblPassword.setFont(new java.awt.Font("Dubai Light", 0, 18)); // NOI18N
        lblPassword.setText("Password:");
        add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, -1, 40));

        lblPasswordCheck.setFont(new java.awt.Font("Dubai Light", 0, 18)); // NOI18N
        lblPasswordCheck.setForeground(new java.awt.Color(204, 0, 51));
        add(lblPasswordCheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 350, -1, 20));

        txtPassword.setFont(new java.awt.Font("Dubai Light", 0, 18)); // NOI18N
        txtPassword.setToolTipText("Setting a more complex password will help protect you!");
        txtPassword.setEnabled(false);
        add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, 300, 50));

        btnEdit.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 21)); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 420, 140, 50));

        btnSave.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 21)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 420, 140, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        btnSave.setVisible(true);
        txtName.setEnabled(true);
        txtPhoneNumber.setEnabled(true);
        txtEmailAddress.setEnabled(true);
        txtPassword.setEnabled(true);
        txtPassword.setEchoChar('\0');
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        clearErrorLabels();
        
        String name = txtName.getText();
        String emailAddress = txtEmailAddress.getText();
        String phoneNumber = txtPhoneNumber.getText();
        String password = txtPassword.getText();
        
        int error = 0;

        if (name.isEmpty()) {
            lblNameCheck.setText("Invalid name");
            error++;
        }
        if (emailAddress.isEmpty() || !emailAddress.contains("@") || !emailAddress.contains(".com")) {
            lblEmailCheck.setText("Invalid email address");
            error++;
        }
        if (phoneNumber.isEmpty() || phoneNumber.length() != 10) {
            lblPhoneNumberCheck.setText("Invalid phone number");
            error++;
        }
        if (password.isEmpty()) {
            lblPasswordCheck.setText("Invalid password");
            error++;
        }
        
        if (error == 0) {
            admin.setName(name);
            admin.setPhoneNumber(phoneNumber);
            admin.setEmailAddress(emailAddress);
            admin.updatePassword(password);
            
            if (admin.updateUser()) {
                JOptionPane.showMessageDialog(this, "Update successful.");
                btnSave.setVisible(false);
                displayProfile(admin);
                
                MainPanel parent = (MainPanel) getParent();
                parent.updateAdmin(admin);
            } else {
                JOptionPane.showMessageDialog(this, "Update unsuccessful. Please try again.");
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel lblAdminRegistration;
    private javax.swing.JLabel lblEmailAddress;
    private javax.swing.JLabel lblEmailCheck;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblGenderType;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNameCheck;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPasswordCheck;
    private javax.swing.JLabel lblPhoneNumber;
    private javax.swing.JLabel lblPhoneNumberCheck;
    private javax.swing.JPanel registrationPanel;
    private javax.swing.JTextField txtEmailAddress;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPhoneNumber;
    // End of variables declaration//GEN-END:variables
}
