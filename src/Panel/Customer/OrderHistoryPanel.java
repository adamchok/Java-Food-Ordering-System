package Panel.Customer;

import Order.Order;
import Review.VendorReview;
import User.Customer;
import User.Vendor;
import java.awt.Container;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import JSwingObjects.JTablesAndCombobox;
import Order.Foodcart;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author CHOK QI YANG TP070091
 */
public class OrderHistoryPanel extends javax.swing.JPanel implements JTablesAndCombobox{
    private final DefaultTableModel model = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column){  
            return false;  
        }
    };
    private final TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
    private final String[] orderHistoryTableColumns = {"OrderID", "Status", "Restaurant", "VendorID", "Date", "Time", "Service", "Cost"};
    
    private Customer customer;
    private Order order;
    
    public OrderHistoryPanel() {
        initComponents();
        model.setColumnIdentifiers(orderHistoryTableColumns);
        orderHistoryTable.setModel(model);
        orderHistoryTable.setRowSorter(sorter);
        orderHistoryTable.getColumnModel().getColumn(1).setCellRenderer(new CustomCellRenderer());
    }
    
    private class CustomCellRenderer extends DefaultTableCellRenderer {
        private final Color completedColor = new Color(0, 255, 0, 100);
        private final Color notCompletedColor = new Color(255, 0, 0, 100);
        
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component rendererComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            if (column == 1) {
                String status = value.toString();
                if ("Completed".equals(status)) {
                    rendererComponent.setBackground(completedColor);
                } else {
                    rendererComponent.setBackground(notCompletedColor);
                }
            } else {
                rendererComponent.setBackground(table.getBackground());
            }
            return rendererComponent;
        }
    }
    
    public void displayOrderHistory(Customer customer) {
        model.setRowCount(0);
        this.customer = customer;
        Order orders = new Order(customer);
        
        ArrayList<Order> orderHistoryList = orders.getOrderHistoryList();
        
        if (!orderHistoryList.isEmpty()) {
            for (Order orderHistory : orderHistoryList) {
                String[] tableInfo = {orderHistory.getOrderID(), orderHistory.getOrderStatus(),
                    orderHistory.getVendor().getName(), orderHistory.getVendor().getId(), 
                    orderHistory.getOrderDate(), orderHistory.getOrderTime(),
                    orderHistory.getServiceType(), String.format("%.2f", orderHistory.getOrderCost())};
                
                addItemToComboBox(cbxService, orderHistory.getServiceType());
                addItemToComboBox(cbxStatus, orderHistory.getOrderStatus());
                addItemToComboBox(cbxDate, orderHistory.getOrderDate());
                
                model.addRow(tableInfo); 
            }
        }
        cbxStatus.setSelectedIndex(0);
        cbxService.setSelectedIndex(0);
        cbxDate.setSelectedIndex(0);
    }
    
    public void displayItemOrder() {
        if (order != null) {
            String itemOrderList = "";
            Foodcart foodCart = order.getFoodCart();
            for (int i = 0; i < foodCart.getFoodItems().size(); i++) {
            itemOrderList += foodCart.getFoodItems().get(i).getItemName()+ "(x"+foodCart.getFoodItemCounts().get(i)+")"
                    +" - RM "+String.format("%.2f", foodCart.getFoodItems().get(i).getItemPrice() * foodCart.getFoodItemCounts().get(i))
                    +"\n---------------------------------------\n";
            }
            txtItemOrderDetails.setText(itemOrderList);
        }
    }
    
    @Override
    public boolean comboboxFilterImplementation(RowFilter.Entry<? extends DefaultTableModel, ? extends Object> entry) {
        String statusFilter = (String) cbxStatus.getSelectedItem();   
        String serviceFilter = (String) cbxService.getSelectedItem();
        String dateFilter = (String) cbxDate.getSelectedItem();
        
        String statusItem = entry.getStringValue(1);
        String dateItem = entry.getStringValue(4);
        String serviceItem = entry.getStringValue(6);

        boolean status = "All".equals(statusFilter) || statusItem.equals(statusFilter);
        boolean service = "All".equals(serviceFilter) || serviceItem.equals(serviceFilter);
        boolean date = "All".equals(dateFilter) || dateItem.equals(dateFilter);

        return status && date && service; 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollVendorTable = new javax.swing.JScrollPane();
        orderHistoryTable = new javax.swing.JTable();
        scrollRestaurantAddress3 = new javax.swing.JScrollPane();
        txtItemOrderDetails = new javax.swing.JTextArea();
        lblServices = new javax.swing.JLabel();
        cbxService = new javax.swing.JComboBox<>();
        lblStatus = new javax.swing.JLabel();
        cbxStatus = new javax.swing.JComboBox<>();
        lblDate = new javax.swing.JLabel();
        cbxDate = new javax.swing.JComboBox<>();
        btnReorder = new javax.swing.JButton();
        btnGiveReview = new javax.swing.JButton();
        lblReviewStatus = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(926, 560));
        setMinimumSize(new java.awt.Dimension(926, 560));
        setPreferredSize(new java.awt.Dimension(926, 560));

        orderHistoryTable.setModel(model);
        orderHistoryTable.setMaximumSize(new java.awt.Dimension(932, 400));
        orderHistoryTable.setMinimumSize(new java.awt.Dimension(932, 400));
        orderHistoryTable.setPreferredSize(new java.awt.Dimension(932, 400));
        orderHistoryTable.setRowHeight(50);
        orderHistoryTable.setShowGrid(true);
        orderHistoryTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                orderHistoryTableMouseReleased(evt);
            }
        });
        scrollVendorTable.setViewportView(orderHistoryTable);

        txtItemOrderDetails.setEditable(false);
        txtItemOrderDetails.setBackground(new java.awt.Color(255, 255, 255));
        txtItemOrderDetails.setColumns(20);
        txtItemOrderDetails.setFont(new java.awt.Font("Dubai Light", 0, 16)); // NOI18N
        txtItemOrderDetails.setLineWrap(true);
        txtItemOrderDetails.setRows(1);
        txtItemOrderDetails.setTabSize(4);
        txtItemOrderDetails.setWrapStyleWord(true);
        txtItemOrderDetails.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtItemOrderDetails.setMargin(new java.awt.Insets(0, 0, 0, 0));
        scrollRestaurantAddress3.setViewportView(txtItemOrderDetails);

        lblServices.setFont(new java.awt.Font("Dubai Light", 0, 20)); // NOI18N
        lblServices.setText("Service:");

        cbxService.setFont(new java.awt.Font("Dubai Light", 0, 16)); // NOI18N
        cbxService.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All" }));
        cbxService.setToolTipText("A style of cooking characterized by distinctive ingredients, techniques and dishes, and usually associated with a specific culture or geographic region.");
        cbxService.setMaximumSize(new java.awt.Dimension(105, 25));
        cbxService.setMinimumSize(new java.awt.Dimension(105, 25));
        cbxService.setPreferredSize(new java.awt.Dimension(105, 25));
        cbxService.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxServiceItemStateChanged(evt);
            }
        });

        lblStatus.setFont(new java.awt.Font("Dubai Light", 0, 20)); // NOI18N
        lblStatus.setText("Status:");

        cbxStatus.setFont(new java.awt.Font("Dubai Light", 0, 16)); // NOI18N
        cbxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All" }));
        cbxStatus.setToolTipText("A style of cooking characterized by distinctive ingredients, techniques and dishes, and usually associated with a specific culture or geographic region.");
        cbxStatus.setMaximumSize(new java.awt.Dimension(105, 25));
        cbxStatus.setMinimumSize(new java.awt.Dimension(105, 25));
        cbxStatus.setPreferredSize(new java.awt.Dimension(105, 25));
        cbxStatus.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxStatusItemStateChanged(evt);
            }
        });

        lblDate.setFont(new java.awt.Font("Dubai Light", 0, 20)); // NOI18N
        lblDate.setText("Date:");

        cbxDate.setFont(new java.awt.Font("Dubai Light", 0, 16)); // NOI18N
        cbxDate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All" }));
        cbxDate.setToolTipText("A style of cooking characterized by distinctive ingredients, techniques and dishes, and usually associated with a specific culture or geographic region.");
        cbxDate.setMaximumSize(new java.awt.Dimension(105, 25));
        cbxDate.setMinimumSize(new java.awt.Dimension(105, 25));
        cbxDate.setPreferredSize(new java.awt.Dimension(105, 25));
        cbxDate.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxDateItemStateChanged(evt);
            }
        });

        btnReorder.setText("Re-order");
        btnReorder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReorderActionPerformed(evt);
            }
        });

        btnGiveReview.setText("Give Review");
        btnGiveReview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGiveReviewActionPerformed(evt);
            }
        });

        lblReviewStatus.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblReviewStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReviewStatus.setText("(Review Status)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblServices)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxService, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblStatus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxDate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scrollVendorTable, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(lblReviewStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(scrollRestaurantAddress3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnGiveReview, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnReorder, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblServices)
                    .addComponent(cbxService, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStatus)
                    .addComponent(cbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDate)
                    .addComponent(cbxDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnReorder, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGiveReview, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblReviewStatus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollRestaurantAddress3))
                    .addComponent(scrollVendorTable, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbxServiceItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxServiceItemStateChanged
        applyFilters(sorter);
    }//GEN-LAST:event_cbxServiceItemStateChanged

    private void cbxStatusItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxStatusItemStateChanged
        applyFilters(sorter);
    }//GEN-LAST:event_cbxStatusItemStateChanged

    private void cbxDateItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxDateItemStateChanged
        applyFilters(sorter);
    }//GEN-LAST:event_cbxDateItemStateChanged

    private void btnReorderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReorderActionPerformed
        if (orderHistoryTable.getSelectedRow() >= 0) {
            Container tabbedPane = this.getParent();
            Container historyPanel = tabbedPane.getParent();
            MainPanel mainPanel = (MainPanel) historyPanel.getParent();
            String selectedVendorID = (String) orderHistoryTable.getValueAt(orderHistoryTable.getSelectedRow(), 3);
            Vendor vendor = (Vendor) new Vendor(selectedVendorID).getObject("Vendor");
            mainPanel.displayVendorMenu(vendor, customer); 
        }
    }//GEN-LAST:event_btnReorderActionPerformed

    private void btnGiveReviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGiveReviewActionPerformed
        int selectedIndex = orderHistoryTable.getSelectedRow();
        if (selectedIndex >= 0) {
            String orderStatus = (String) orderHistoryTable.getValueAt(selectedIndex, 1);
            
            if (orderStatus.equals("Completed")) {
                VendorReview reviewChecker = new VendorReview(order.getOrderID());
                
                if (reviewChecker.getObject("Vendor Reviews") == null) {
                    Container tabbedPane = this.getParent();
                    HistoryPanel historyPanel = (HistoryPanel) tabbedPane.getParent();
                    historyPanel.displayReview(customer, order);
                } else {
                    JOptionPane.showMessageDialog(this, "You have submitted a review for this order already.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Unable to provide review becasue the order was rejected.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select an order to provide a review for!");
        }
    }//GEN-LAST:event_btnGiveReviewActionPerformed

    private void orderHistoryTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_orderHistoryTableMouseReleased
        int selectedIndex = orderHistoryTable.getSelectedRow();
        if (selectedIndex >= 0) {
            order = null;
            String selectedOrderID = (String) orderHistoryTable.getValueAt(selectedIndex, 0);
            order = (Order) new Order(selectedOrderID).getObject("Order History");
            displayItemOrder();
            
            String orderStatus = (String) orderHistoryTable.getValueAt(selectedIndex, 1);
            if (orderStatus.equals("Completed")) {
                VendorReview reviewChecker = new VendorReview(order.getOrderID());
                
                if (reviewChecker.getObject("Vendor Reviews") == null) {
                    lblReviewStatus.setText("Not Reviewed");
                } else {
                    lblReviewStatus.setText("Reviewed");
                }
            } else {
                lblReviewStatus.setText("Cannot Review");
            }
        }
    }//GEN-LAST:event_orderHistoryTableMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGiveReview;
    private javax.swing.JButton btnReorder;
    private javax.swing.JComboBox<String> cbxDate;
    private javax.swing.JComboBox<String> cbxService;
    private javax.swing.JComboBox<String> cbxStatus;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblReviewStatus;
    private javax.swing.JLabel lblServices;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JTable orderHistoryTable;
    private javax.swing.JScrollPane scrollRestaurantAddress3;
    private javax.swing.JScrollPane scrollVendorTable;
    private javax.swing.JTextArea txtItemOrderDetails;
    // End of variables declaration//GEN-END:variables
}
