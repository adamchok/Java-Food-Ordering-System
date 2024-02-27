/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Panel.Admin;

import Transaction.Transaction;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CHENG WEI QUAN TP071634
 */
public class ReceiptsPanel extends javax.swing.JPanel {
    private final DefaultTableModel modelTransaction = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column){
            return false;
        }
    };
    private final String[] receiptColumn = {"No.", "ID", "Customer ID", "Type", "Invoice", "Date", "Time", "Amount", "Status"};
    
    private Transaction selectedTransaction;
    
    public ReceiptsPanel() {
        initComponents();
        modelTransaction.setColumnIdentifiers(receiptColumn);
        tableTransactions.setModel(modelTransaction);
        displayPendingTransactions();
    }

    public final void displayPendingTransactions() {
        modelTransaction.setRowCount(0);
        int number = 0;
        Transaction transactions = new Transaction();
        
        ArrayList<Transaction> transactionHistoryList = transactions.getTransactionHistoryList(false);
        
        for (Transaction transaction : transactionHistoryList) {
            if (transaction.getReceipt() == null) {
                number++;
                String[] tableData = {String.valueOf(number), transaction.getTransactionID(),
                    transaction.getCustomer().getId(), transaction.getTransactionType(),
                    transaction.getInvoiceNumber(), transaction.getTransactionDate(), transaction.getTransactionTime(), 
                    String.format("%.2f", transaction.getTransactionAmount()), transaction.getTransactionStatus()};
                modelTransaction.addRow(tableData);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPendingTransactions = new javax.swing.JScrollPane();
        tableTransactions = new javax.swing.JTable();
        btnSendReceipt = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(944, 600));
        setMinimumSize(new java.awt.Dimension(944, 600));

        tableTransactions.setModel(modelTransaction);
        tableTransactions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableTransactionsMouseReleased(evt);
            }
        });
        scrollPendingTransactions.setViewportView(tableTransactions);

        btnSendReceipt.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 21)); // NOI18N
        btnSendReceipt.setText("Send Receipt");
        btnSendReceipt.setEnabled(false);
        btnSendReceipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendReceiptActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSendReceipt)
                    .addComponent(scrollPendingTransactions, javax.swing.GroupLayout.PREFERRED_SIZE, 910, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPendingTransactions, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSendReceipt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSendReceiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendReceiptActionPerformed
        if (selectedTransaction != null) {
            if (selectedTransaction.generateReceipt()) {
                JOptionPane.showMessageDialog(this, "Receipt delivered.");
            } else {
                JOptionPane.showMessageDialog(this, "Receipt not delivered. Please try again.");
            }
        }
        selectedTransaction = null;
        displayPendingTransactions();
    }//GEN-LAST:event_btnSendReceiptActionPerformed

    private void tableTransactionsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableTransactionsMouseReleased
        int row = tableTransactions.getSelectedRow();
        if (row >= 0) {
            String id = String.valueOf(tableTransactions.getValueAt(row, 1));
            selectedTransaction = new Transaction(id).getTransaction();
            
            btnSendReceipt.setEnabled(true);
        } else {
            btnSendReceipt.setEnabled(false);
        }
    }//GEN-LAST:event_tableTransactionsMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSendReceipt;
    private javax.swing.JScrollPane scrollPendingTransactions;
    private javax.swing.JTable tableTransactions;
    // End of variables declaration//GEN-END:variables
}
