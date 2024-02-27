package Panel.Admin;

import Review.DeliveryReview;
import User.DeliveryRunner;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CHENG WEI QUAN TP071634
 */
public class FeedbackDeliveryRunner extends javax.swing.JPanel {
    private final DefaultTableModel modelRunnerFeedback = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column){
            return false;
        }
    };
    private final String[] runnerColumn = {"ID", "Name", "Average Rating"};
    
    public FeedbackDeliveryRunner() {
        initComponents();
        modelRunnerFeedback.setColumnIdentifiers(runnerColumn);
        tableRunnerReview.setModel(modelRunnerFeedback);
        displayRunnerReviews();
    }

    public final void displayRunnerReviews() {
        txtRunnerReviews.setText("");
        modelRunnerFeedback.setRowCount(0);
        
        DeliveryRunner runners = new DeliveryRunner();
        ArrayList<DeliveryRunner> runnerList = runners.getDeliveryRunnerList(false);
        
        if (!runnerList.isEmpty()) {
            for (DeliveryRunner runner : runnerList) {
                DeliveryReview review = new DeliveryReview(runner);
                String[] tableData = {runner.getId(), runner.getName(), review.getAverageRating()};
                modelRunnerFeedback.addRow(tableData);
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPaneRunner1 = new javax.swing.JScrollPane();
        tableRunnerReview = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtRunnerReviews = new javax.swing.JTextArea();
        lblRunnerReviews = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(944, 580));
        setMinimumSize(new java.awt.Dimension(944, 580));
        setPreferredSize(new java.awt.Dimension(944, 580));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableRunnerReview.setModel(modelRunnerFeedback);
        tableRunnerReview.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableRunnerReviewMouseReleased(evt);
            }
        });
        jScrollPaneRunner1.setViewportView(tableRunnerReview);

        add(jScrollPaneRunner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 550, 540));

        txtRunnerReviews.setColumns(20);
        txtRunnerReviews.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtRunnerReviews.setLineWrap(true);
        txtRunnerReviews.setText("Select a runner to view their delivery reviews.");
        txtRunnerReviews.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtRunnerReviews);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 60, 360, 490));

        lblRunnerReviews.setFont(new java.awt.Font("SansSerif", 1, 30)); // NOI18N
        lblRunnerReviews.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRunnerReviews.setText("Reviews");
        add(lblRunnerReviews, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, 360, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void tableRunnerReviewMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableRunnerReviewMouseReleased
        int row = tableRunnerReview.getSelectedRow();
        if (row >= 0) {
            String reviewString = "";
            String id = String.valueOf(tableRunnerReview.getValueAt(row, 0));
            DeliveryRunner runner = new DeliveryRunner(id).getUser(false);
            
            DeliveryReview reviews = new DeliveryReview(runner);
            ArrayList<DeliveryReview> reviewList = reviews.getDeliveryReviewList();
            
            if (!reviewList.isEmpty()) {
                for (DeliveryReview review : reviewList) {
                    reviewString += review.getId()+" - "+review.getReviewDate() + " - " + review.getReviewRating() + "\n" + review.getReviewComments() + 
                            "\n------------------------------------------------\n";
                }
            }
            txtRunnerReviews.setText(reviewString);
        } else {
            txtRunnerReviews.setText("Select a delivery runner to view their delivery reviews.");
        }
    }//GEN-LAST:event_tableRunnerReviewMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPaneRunner1;
    private javax.swing.JLabel lblRunnerReviews;
    private javax.swing.JTable tableRunnerReview;
    private javax.swing.JTextArea txtRunnerReviews;
    // End of variables declaration//GEN-END:variables
}
