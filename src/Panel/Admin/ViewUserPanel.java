package Panel.Admin;

/**
 *
 * @author CHENG WEI QUAN TP071634
 */
public class ViewUserPanel extends javax.swing.JPanel {
    public ViewUserPanel() {
        initComponents();
    }
    
    public void displayUsers() {
        TabbedPane.setSelectedIndex(0);
        viewCustomer.displayCustomers();
        viewDeliveryRunner.displayDeliveryRunners();
        viewVendor.displayVendors();
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
        viewCustomer = new Panel.Admin.ViewCustomer();
        viewDeliveryRunner = new Panel.Admin.ViewDeliveryRunner();
        viewVendor = new Panel.Admin.ViewVendor();

        setMaximumSize(new java.awt.Dimension(944, 600));
        setMinimumSize(new java.awt.Dimension(944, 600));

        TabbedPane.setMaximumSize(new java.awt.Dimension(944, 600));
        TabbedPane.setMinimumSize(new java.awt.Dimension(944, 600));
        TabbedPane.setPreferredSize(new java.awt.Dimension(944, 600));
        TabbedPane.addTab("Customer", viewCustomer);
        TabbedPane.addTab("Delivery Runner", viewDeliveryRunner);
        TabbedPane.addTab("Vendor", viewVendor);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 944, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        TabbedPane.getAccessibleContext().setAccessibleName("Vendor");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane TabbedPane;
    private Panel.Admin.ViewCustomer viewCustomer;
    private Panel.Admin.ViewDeliveryRunner viewDeliveryRunner;
    private Panel.Admin.ViewVendor viewVendor;
    // End of variables declaration//GEN-END:variables
}