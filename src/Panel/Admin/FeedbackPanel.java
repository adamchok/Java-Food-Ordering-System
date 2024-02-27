/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Panel.Admin;

/**
 *
 * @author Dixon
 */
public class FeedbackPanel extends javax.swing.JPanel {

    
    public FeedbackPanel() {
        initComponents();
    }
    
    public void displayReviews() {
        feedbackVendor.displayVendorReviews();
        feedbackDeliveryRunner.displayRunnerReviews();
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
        feedbackVendor = new Panel.Admin.FeedbackVendor();
        feedbackDeliveryRunner = new Panel.Admin.FeedbackDeliveryRunner();

        setMaximumSize(new java.awt.Dimension(944, 600));
        setMinimumSize(new java.awt.Dimension(944, 600));
        setPreferredSize(new java.awt.Dimension(944, 600));

        TabbedPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TabbedPane.setMaximumSize(new java.awt.Dimension(944, 600));
        TabbedPane.setMinimumSize(new java.awt.Dimension(944, 600));
        TabbedPane.setPreferredSize(new java.awt.Dimension(944, 600));
        TabbedPane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                TabbedPaneStateChanged(evt);
            }
        });
        TabbedPane.addTab("Vendor", feedbackVendor);
        TabbedPane.addTab("Delivery Runner", feedbackDeliveryRunner);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        TabbedPane.getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    private void TabbedPaneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_TabbedPaneStateChanged
        if (TabbedPane.getSelectedIndex() == 0) {
            feedbackVendor.displayVendorReviews();
        } else {
            feedbackDeliveryRunner.displayRunnerReviews();
        }
    }//GEN-LAST:event_TabbedPaneStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTabbedPane TabbedPane;
    private Panel.Admin.FeedbackDeliveryRunner feedbackDeliveryRunner;
    private Panel.Admin.FeedbackVendor feedbackVendor;
    // End of variables declaration//GEN-END:variables
}