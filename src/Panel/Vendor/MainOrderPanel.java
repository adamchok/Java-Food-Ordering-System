package Panel.Vendor;

import User.Vendor;

/**
 *
 * @author KWAN JUN ER TP066265
 */
public class MainOrderPanel extends javax.swing.JPanel {
    private Vendor vendor;
    public MainOrderPanel() {
        initComponents();
    }
    
    public void displayMainOrderPanel(Vendor vendor, int index) {
        this.vendor = vendor;
        TabbedPane.setSelectedIndex(index);
        pendingOrderList.displayPendingOrders(vendor);
        acceptedOrderInPreparation.displayAcceptedOrders(vendor);
        orderHistory.displayOrderHistory(vendor);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TabbedPane = new javax.swing.JTabbedPane();
        pendingOrderList = new Panel.Vendor.PendingOrderList();
        acceptedOrderInPreparation = new Panel.Vendor.AcceptedOrderInPreparation();
        orderHistory = new Panel.Vendor.OrderHistory();

        setMaximumSize(new java.awt.Dimension(944, 600));

        TabbedPane.setPreferredSize(new java.awt.Dimension(925, 600));
        TabbedPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                TabbedPaneMouseReleased(evt);
            }
        });
        TabbedPane.addTab("Pending Order", pendingOrderList);
        TabbedPane.addTab("Accepted Order", acceptedOrderInPreparation);
        TabbedPane.addTab("Order History", orderHistory);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TabbedPaneMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabbedPaneMouseReleased
        displayMainOrderPanel(vendor, TabbedPane.getSelectedIndex());
    }//GEN-LAST:event_TabbedPaneMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane TabbedPane;
    private Panel.Vendor.AcceptedOrderInPreparation acceptedOrderInPreparation;
    private Panel.Vendor.OrderHistory orderHistory;
    private Panel.Vendor.PendingOrderList pendingOrderList;
    // End of variables declaration//GEN-END:variables
}
