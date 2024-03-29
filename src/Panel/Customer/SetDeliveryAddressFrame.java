package Panel.Customer;

import User.Customer;
import User.DeliveryAddress;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CHOK QI YANG TP070091 
 */
public class SetDeliveryAddressFrame extends javax.swing.JFrame {
    private final DefaultTableModel model = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column){  
            return false;  
        }
    };
    private final String[] deliveryAddressTableColumns = {"ID", "Title", "Delivery Address"};
    
    private DeliveryAddress deliveryAddress;
    private Customer customer;
    
    public SetDeliveryAddressFrame() {
        initComponents();
        setLocationRelativeTo(null);
        model.setColumnIdentifiers(deliveryAddressTableColumns);
        deliveryAddressTable.setModel(model);
    }
    
    public final void displayDeliveryAddresses(Customer customer) { 
        this.customer = customer;
        deliveryAddress = null;
        model.setRowCount(0);
        
        DeliveryAddress deliveryAddresses = new DeliveryAddress(customer);
        ArrayList<DeliveryAddress> deliveryAddressList = deliveryAddresses.getDeliveryAddressList(false);
        
        for (DeliveryAddress address : deliveryAddressList) {
            String[] tableInfo = {address.getAddressID(), address.getTitle(), address.getAddress()};
            model.addRow(tableInfo);
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

        setDeliveryAddressPanel = new javax.swing.JPanel();
        scrollRestaurantAddress2 = new javax.swing.JScrollPane();
        txtDeliveryAddress = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        deliveryAddressTable = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        lblDeliveryAddress = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Manage Delivery Addresses");
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(600, 450));
        setMinimumSize(new java.awt.Dimension(600, 450));

        setDeliveryAddressPanel.setBackground(new java.awt.Color(255, 255, 255));
        setDeliveryAddressPanel.setMaximumSize(new java.awt.Dimension(600, 450));
        setDeliveryAddressPanel.setMinimumSize(new java.awt.Dimension(600, 450));
        setDeliveryAddressPanel.setPreferredSize(new java.awt.Dimension(600, 450));

        txtDeliveryAddress.setColumns(20);
        txtDeliveryAddress.setFont(new java.awt.Font("Dubai Light", 0, 18)); // NOI18N
        txtDeliveryAddress.setLineWrap(true);
        txtDeliveryAddress.setRows(5);
        txtDeliveryAddress.setTabSize(4);
        txtDeliveryAddress.setWrapStyleWord(true);
        txtDeliveryAddress.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtDeliveryAddress.setMargin(new java.awt.Insets(0, 0, 0, 0));
        scrollRestaurantAddress2.setViewportView(txtDeliveryAddress);

        deliveryAddressTable.setModel(model);
        deliveryAddressTable.setRowHeight(50);
        deliveryAddressTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                deliveryAddressTableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(deliveryAddressTable);

        btnAdd.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 18)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 18)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 18)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Dubai Light", 0, 18)); // NOI18N
        lblTitle.setText("Address Title:");

        txtTitle.setFont(new java.awt.Font("Dubai Light", 0, 18)); // NOI18N

        lblDeliveryAddress.setFont(new java.awt.Font("Dubai Light", 0, 18)); // NOI18N
        lblDeliveryAddress.setText("Delivery Address:");

        javax.swing.GroupLayout setDeliveryAddressPanelLayout = new javax.swing.GroupLayout(setDeliveryAddressPanel);
        setDeliveryAddressPanel.setLayout(setDeliveryAddressPanelLayout);
        setDeliveryAddressPanelLayout.setHorizontalGroup(
            setDeliveryAddressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(setDeliveryAddressPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(setDeliveryAddressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, setDeliveryAddressPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(setDeliveryAddressPanelLayout.createSequentialGroup()
                        .addGroup(setDeliveryAddressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDeliveryAddress, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTitle, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(setDeliveryAddressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTitle)
                            .addComponent(scrollRestaurantAddress2))))
                .addContainerGap())
        );

        setDeliveryAddressPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAdd, btnDelete, btnUpdate});

        setDeliveryAddressPanelLayout.setVerticalGroup(
            setDeliveryAddressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(setDeliveryAddressPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(setDeliveryAddressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(setDeliveryAddressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDeliveryAddress)
                    .addComponent(scrollRestaurantAddress2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(setDeliveryAddressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(setDeliveryAddressPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(setDeliveryAddressPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String title = txtTitle.getText();
        String address = txtDeliveryAddress.getText();
        
        if (!title.isEmpty() && !address.isEmpty()) {
            deliveryAddress = new DeliveryAddress(customer, title, address);

            if (deliveryAddress.addDeliveryAddress()) {
                JOptionPane.showMessageDialog(this, "Address added.");
                txtTitle.setText("");
                txtDeliveryAddress.setText("");
            }  else {
                JOptionPane.showMessageDialog(this, "Unable to add address. Please try again.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please input a title and an address before adding.");
        }
        displayDeliveryAddresses(customer);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (deliveryAddress != null) {
            if (deliveryAddress.removeDeliveryAddress()) {
                JOptionPane.showMessageDialog(this, "Address deleted.");
                txtTitle.setText("");
                txtDeliveryAddress.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Unable to delete address. Please try again.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select an address before deleting.");
        }
        displayDeliveryAddresses(customer);
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String title = txtTitle.getText();
        String address = txtDeliveryAddress.getText();
        if (deliveryAddress != null) {
            if (!title.isEmpty() && !address.isEmpty()) {
                deliveryAddress.setTitle(title);
                deliveryAddress.setAddress(address);

                if (deliveryAddress.updateDeliveryAddress()) {
                    JOptionPane.showMessageDialog(this, "Address details updated.");
                    txtTitle.setText("");
                    txtDeliveryAddress.setText("");
                }  else {
                    JOptionPane.showMessageDialog(this, "Unable to update address details. Please try again.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please input a title and a delivery address / select an address before updating.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please a delivery address to update its details");
        }
        
        displayDeliveryAddresses(customer);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void deliveryAddressTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deliveryAddressTableMouseReleased
        int row = deliveryAddressTable.getSelectedRow();
        if (row >= 0) {
            String id = deliveryAddressTable.getValueAt(row, 0).toString();
            deliveryAddress = new DeliveryAddress(id).getDeliveryAddress();
            
            txtTitle.setText(deliveryAddress.getTitle());
            txtDeliveryAddress.setText(deliveryAddress.getAddress());
        }
    }//GEN-LAST:event_deliveryAddressTableMouseReleased

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SetDeliveryAddressFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SetDeliveryAddressFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SetDeliveryAddressFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SetDeliveryAddressFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SetDeliveryAddressFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JTable deliveryAddressTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDeliveryAddress;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JScrollPane scrollRestaurantAddress2;
    private javax.swing.JPanel setDeliveryAddressPanel;
    private javax.swing.JTextArea txtDeliveryAddress;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables
}
