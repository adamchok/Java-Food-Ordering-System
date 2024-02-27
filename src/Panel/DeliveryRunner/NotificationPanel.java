package Panel.DeliveryRunner;

import Notification.Notification;
import User.DeliveryRunner;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author NABIL BIN NAZME NAZIM TP072131
 */
public class NotificationPanel extends javax.swing.JPanel {
    private DeliveryRunner runner;
    private Notification runnerNotification;
    
    private final DefaultTableModel model = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column){
            return false;
        }
    };
    
    private final TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
    private final String[] notificationTableColumns = {"ID", "Type", "Sender", "Date", "Time"};

    
    public NotificationPanel() {
        initComponents();
        model.setColumnIdentifiers(notificationTableColumns);
        notificationTable.setModel(model);
        notificationTable.setRowSorter(sorter);
    }
    public void displayNotifications(DeliveryRunner runner) {
        this.runner = runner;
        runnerNotification = null;
        model.setRowCount(0);
        lblMessage.setText("");
        
        btnView.setEnabled(false);
        btnDelete.setEnabled(false);
        
        Notification notifications = new Notification(runner.getId());
        ArrayList<Notification> notificationList = notifications.getNotificationList(false);
        for (Notification notification : notificationList) {
            String[] tableData = {notification.getNotificationID(), notification.getNotificationType(), 
                notification.getSenderID(), notification.getDate(), notification.getTime()};
            model.addRow(tableData);
        }
    }
    
    private void displayNotificationMessage() {
        if (runnerNotification != null) {
            lblMessage.setText(runnerNotification.getMessage());
            
            btnView.setEnabled(true);
            btnDelete.setEnabled(true);
        }
    }
   
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // </editor-fold>
@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        notificationTable = new javax.swing.JTable();
        btnDeleteAll = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lblMessage = new javax.swing.JTextArea();
        btnView = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(880, 600));
        setMinimumSize(new java.awt.Dimension(880, 600));
        setPreferredSize(new java.awt.Dimension(880, 600));

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jTextField1.setText("Notifications ");
        jTextField1.setBorder(null);

        notificationTable.setRowHeight(25);
        notificationTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                notificationTableMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(notificationTable);

        btnDeleteAll.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnDeleteAll.setText("Delete All");
        btnDeleteAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteAllActionPerformed(evt);
            }
        });

        lblMessage.setEditable(false);
        lblMessage.setBackground(new java.awt.Color(255, 255, 255));
        lblMessage.setColumns(20);
        lblMessage.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblMessage.setLineWrap(true);
        lblMessage.setRows(5);
        lblMessage.setWrapStyleWord(true);
        lblMessage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblMessage.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        lblMessage.setEnabled(false);
        jScrollPane1.setViewportView(lblMessage);

        btnView.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnView.setText("View");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnDelete.setText("Delete Notification");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDeleteAll))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnView, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 8, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteAll))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnView)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteAllActionPerformed
        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "There is no notifications to delete.");
        } else {
            Notification notification = new Notification(runner.getId());
            if (notification.deleteAllNotification()) {
                JOptionPane.showMessageDialog(this, "All notifications deleted.");
                displayNotifications(runner);
            } else {
                JOptionPane.showMessageDialog(this, "Unable to delete all notifications. Please try again.");
                displayNotifications(runner);
            }
        }
    }//GEN-LAST:event_btnDeleteAllActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        if (runnerNotification != null) {
            if (runnerNotification.getNotificationType().equals("Pending Task") ||
                    runnerNotification.getNotificationType().equals("Order")) {
                Panel.DeliveryRunner.MainPanel mainPanel = (Panel.DeliveryRunner.MainPanel) this.getParent();
                mainPanel.displayCurrentTask(runner);
            }
        }
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (runnerNotification != null) {
            if (runnerNotification.deleteNotification()) {
                JOptionPane.showMessageDialog(this, "Notification deleted.");
                displayNotifications(runner);
            } else {
                JOptionPane.showMessageDialog(this, "Unable to delete notification. Please try again.");
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void notificationTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notificationTableMouseReleased
        int row = notificationTable.getSelectedRow();
        if (row >= 0) {
            String notificationID = String.valueOf(notificationTable.getValueAt(row, 0));
            runnerNotification = (Notification) new Notification(runner.getId(), notificationID).getObject("Notification");
            displayNotificationMessage();
        }
    }//GEN-LAST:event_notificationTableMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDeleteAll;
    private javax.swing.JButton btnView;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextArea lblMessage;
    public javax.swing.JTable notificationTable;
    // End of variables declaration//GEN-END:variables

    
    /*private void initComponents() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }*/
}