package Panel.Admin;

import Transaction.TopUp;
import User.Customer;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CHENG WEI QUAN TP071634
 */
public class TopUpPanel extends javax.swing.JPanel {
    private final DefaultTableModel modelTopUp = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column){
            return false;
        }
    };
    private final String[] topupColumn = {"No.","Name","Customer ID","Date","Time","Amount"};
    
    private TopUp selectedTopUp;
    
    public TopUpPanel() {
        initComponents();
        modelTopUp.setColumnIdentifiers(topupColumn);
        tableTopUp.setModel(modelTopUp);
    }

    public final void displayPendingTopUps() {
        modelTopUp.setRowCount(0);
        selectedTopUp = null;
        
        int number = 0;
        TopUp topUps = new TopUp();
        ArrayList<TopUp> topUpList = topUps.getTopUpList(false);
        
        for (TopUp topUp : topUpList) {
            number++;
            String[] tableData = {String.valueOf(number), topUp.getCustomer().getName(), topUp.getCustomer().getId(), topUp.getTopUpDate(),
                topUp.getTopUpTime(), String.format("%.2f", topUp.getTopUpAmount())};
            modelTopUp.addRow(tableData);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPaneTopUp = new javax.swing.JScrollPane();
        tableTopUp = new javax.swing.JTable();
        btnRejectTopUp = new javax.swing.JButton();
        btnApproveTopUp = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(944, 600));
        setMinimumSize(new java.awt.Dimension(944, 600));

        tableTopUp.setModel(modelTopUp);
        tableTopUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableTopUpMouseReleased(evt);
            }
        });
        jScrollPaneTopUp.setViewportView(tableTopUp);

        btnRejectTopUp.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 21)); // NOI18N
        btnRejectTopUp.setText("Reject");
        btnRejectTopUp.setEnabled(false);
        btnRejectTopUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRejectTopUpActionPerformed(evt);
            }
        });

        btnApproveTopUp.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 21)); // NOI18N
        btnApproveTopUp.setText("Approve");
        btnApproveTopUp.setEnabled(false);
        btnApproveTopUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApproveTopUpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRejectTopUp, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnApproveTopUp, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPaneTopUp, javax.swing.GroupLayout.PREFERRED_SIZE, 912, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneTopUp, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRejectTopUp, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnApproveTopUp, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRejectTopUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRejectTopUpActionPerformed
        if (selectedTopUp.rejectTopUp()) {
            JOptionPane.showMessageDialog(this, "Rejection successful.");
        } else {
            JOptionPane.showMessageDialog(this, "Rejection unsuccessful. Please try again.");
        }
        
        selectedTopUp = null;
        displayPendingTopUps();
    }//GEN-LAST:event_btnRejectTopUpActionPerformed

    private void btnApproveTopUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApproveTopUpActionPerformed
        if (selectedTopUp != null) {
            if (selectedTopUp.approveTopUp()) {
                JOptionPane.showMessageDialog(this, "Top-up successful.");
            } else {
                JOptionPane.showMessageDialog(this, "Top-up unsuccessful. Please try again.");
            }
        }
        displayPendingTopUps();
    }//GEN-LAST:event_btnApproveTopUpActionPerformed

    private void tableTopUpMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableTopUpMouseReleased
        int row = tableTopUp.getSelectedRow();
        if (row >= 0) {
            String id = String.valueOf(tableTopUp.getValueAt(row, 2));
            
            TopUp pendingTopUp = new TopUp((Customer) new Customer(id).getUser(false));
            selectedTopUp = (TopUp) pendingTopUp.getTopUp(false);
            
            btnApproveTopUp.setEnabled(true);
            btnRejectTopUp.setEnabled(true);
        } else {
            btnApproveTopUp.setEnabled(false);
            btnRejectTopUp.setEnabled(false);
        }
    }//GEN-LAST:event_tableTopUpMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApproveTopUp;
    private javax.swing.JButton btnRejectTopUp;
    private javax.swing.JScrollPane jScrollPaneTopUp;
    private javax.swing.JTable tableTopUp;
    // End of variables declaration//GEN-END:variables
}
