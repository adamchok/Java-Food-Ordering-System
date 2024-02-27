package Panel.Vendor;

import JSwingObjects.JTablesAndCombobox;
import Order.Foodcart;
import Order.Order;
import User.Vendor;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author KWAN JUN ER TP066265
 */
public class AcceptedOrderInPreparation extends javax.swing.JPanel implements JTablesAndCombobox {
    private final DefaultTableModel model = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column){
            return false;
        }
    };
    private final DefaultListModel<String> listModel = new DefaultListModel<>();
    private final TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
    private final String[] acceptedOrderListColumns = {"Order ID", "Customer ID", "Service Type", "Date","Time", "Order Cost"};
    
    private Vendor vendor;
    private Order acceptedOrder;  
    
    public AcceptedOrderInPreparation() {
        initComponents();
        model.setColumnIdentifiers(acceptedOrderListColumns);
        listFoodItems.setModel(listModel);
        acceptedOrderTable.setModel(model);
        acceptedOrderTable.setRowSorter(sorter);
    }
    
    public void displayAcceptedOrders(Vendor vendor) {
        model.setRowCount(0);
        clearOrderDetails();
        acceptedOrder = null;
        this.vendor = vendor;
        
        String[] services = vendor.getServices().split(", ");
        for (String service : services) {
            addItemToComboBox(cbxService, service);
        }
        
        Order orders = new Order(vendor);
        ArrayList<Order> pendingOrderList = orders.getPendingOrderList();
        
        if (!pendingOrderList.isEmpty()) {
            for (Order order : pendingOrderList) {
                if (order.getOrderStatus().equals("Preparing")) {
                    String[] tableData = {order.getOrderID(), order.getCustomer().getId(), order.getServiceType(),
                        order.getOrderDate(), order.getOrderTime(), String.format("%.2f", order.getFoodCart().getTotalCost())};
                    model.addRow(tableData);
                }
            }
        }
    }
    
    private void displayOrderDetails() {
        if (acceptedOrder != null) {
            lblOrderID.setText(acceptedOrder.getOrderID());
            lblOrderStatus.setText(acceptedOrder.getOrderStatus());
            lblCustomerID.setText(acceptedOrder.getCustomer().getId());
            lblServiceType.setText(acceptedOrder.getServiceType());
            lblOrderDate.setText(acceptedOrder.getOrderDate());
            lblOrderTime.setText(acceptedOrder.getOrderTime());
            lblTotalOrderCost.setText("RM "+String.format("%.2f", acceptedOrder.getOrderCost()));
            
            Foodcart orderList = acceptedOrder.getFoodCart();
            for (int i = 0; i < orderList.getFoodItems().size(); i++) {
                String orderItem = "Item No "+orderList.getFoodItems().get(i).getItemID()
                        +": "+orderList.getFoodItems().get(i).getItemName()+" x"+orderList.getFoodItemCounts().get(i)
                        +" - RM "+String.format("%.2f", orderList.getFoodItems().get(i).getItemPrice() * orderList.getFoodItemCounts().get(i));
                if (!listModel.contains(orderItem)) {
                    listModel.addElement(orderItem);
                }
            }
        }
    }
    
    private void clearOrderDetails() {
        lblOrderID.setText("");
        lblOrderStatus.setText("");
        lblCustomerID.setText("");
        lblServiceType.setText("");
        lblOrderDate.setText("");
        lblOrderTime.setText("");
        lblTotalOrderCost.setText("");
        listModel.clear();
    }
    
    @Override
    public boolean comboboxFilterImplementation(RowFilter.Entry<? extends DefaultTableModel, ? extends Object> entry) {
        String serviceFilter = (String) cbxService.getSelectedItem();
        String searchFilter = txtSearch.getText();
        
        String serviceItem = entry.getStringValue(2);
        String idItem = entry.getStringValue(0);
        
        boolean service = "All".equals(serviceFilter) || serviceItem.contains(serviceFilter);
        boolean id = searchFilter.isEmpty() || searchFilter.isBlank() || idItem.contains(searchFilter);
                
        return service && id;    
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        acceptedOrderTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblOrderID = new javax.swing.JTextField();
        lblServiceType = new javax.swing.JTextField();
        lblOrderDate = new javax.swing.JTextField();
        lblOrderTime = new javax.swing.JTextField();
        lblOrderStatus = new javax.swing.JTextField();
        lblTotalOrderCost = new javax.swing.JTextField();
        lblCustomerID = new javax.swing.JTextField();
        btnCompleteOrder = new javax.swing.JButton();
        scrollFoodItems = new javax.swing.JScrollPane();
        listFoodItems = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cbxService = new javax.swing.JComboBox<>();

        setMaximumSize(new java.awt.Dimension(925, 580));
        setMinimumSize(new java.awt.Dimension(925, 580));
        setPreferredSize(new java.awt.Dimension(925, 580));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setText("Accepted Orders");

        acceptedOrderTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                acceptedOrderTableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(acceptedOrderTable);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setMaximumSize(new java.awt.Dimension(506, 487));
        jPanel1.setPreferredSize(new java.awt.Dimension(506, 487));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Order ID:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Order Status:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Customer ID:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Service Type:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Order Date:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Order Time:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Total Order Cost:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Order List:");

        lblOrderID.setEditable(false);
        lblOrderID.setBackground(new java.awt.Color(255, 255, 255));
        lblOrderID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblOrderID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblOrderID.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        lblOrderID.setEnabled(false);

        lblServiceType.setEditable(false);
        lblServiceType.setBackground(new java.awt.Color(255, 255, 255));
        lblServiceType.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblServiceType.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblServiceType.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        lblServiceType.setEnabled(false);

        lblOrderDate.setEditable(false);
        lblOrderDate.setBackground(new java.awt.Color(255, 255, 255));
        lblOrderDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblOrderDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblOrderDate.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        lblOrderDate.setEnabled(false);

        lblOrderTime.setEditable(false);
        lblOrderTime.setBackground(new java.awt.Color(255, 255, 255));
        lblOrderTime.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblOrderTime.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblOrderTime.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        lblOrderTime.setEnabled(false);

        lblOrderStatus.setEditable(false);
        lblOrderStatus.setBackground(new java.awt.Color(255, 255, 255));
        lblOrderStatus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblOrderStatus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblOrderStatus.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        lblOrderStatus.setEnabled(false);

        lblTotalOrderCost.setEditable(false);
        lblTotalOrderCost.setBackground(new java.awt.Color(255, 255, 255));
        lblTotalOrderCost.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTotalOrderCost.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblTotalOrderCost.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        lblTotalOrderCost.setEnabled(false);

        lblCustomerID.setEditable(false);
        lblCustomerID.setBackground(new java.awt.Color(255, 255, 255));
        lblCustomerID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCustomerID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblCustomerID.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        lblCustomerID.setEnabled(false);

        btnCompleteOrder.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCompleteOrder.setText("Complete Order Preparation");
        btnCompleteOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompleteOrderActionPerformed(evt);
            }
        });

        listFoodItems.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        listFoodItems.setEnabled(false);
        scrollFoodItems.setViewportView(listFoodItems);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTotalOrderCost))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(lblOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(lblOrderStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblOrderDate, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(lblOrderTime, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblCustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblServiceType, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btnCompleteOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel13)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(scrollFoodItems, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblOrderStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblCustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblServiceType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lblOrderDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOrderTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jLabel13)
                .addGap(2, 2, 2)
                .addComponent(scrollFoodItems, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalOrderCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(9, 9, 9)
                .addComponent(btnCompleteOrder, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Search :");

        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Service Type:");

        cbxService.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbxService.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All" }));
        cbxService.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxServiceItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(12, 12, 12)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jLabel2)
                                .addGap(6, 6, 6)
                                .addComponent(cbxService, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)))
                .addGap(6, 6, 6))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxService, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbxServiceItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxServiceItemStateChanged
        applyFilters(sorter);
    }//GEN-LAST:event_cbxServiceItemStateChanged

    private void txtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyTyped
        applyFilters(sorter);
    }//GEN-LAST:event_txtSearchKeyTyped

    private void btnCompleteOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompleteOrderActionPerformed
        if (acceptedOrder != null) {
            if (acceptedOrder.getServiceType().equals("Delivery")) {
                if (acceptedOrder.notifyDeliveryRunner()) {
                    JOptionPane.showMessageDialog(this, "Order completed. The delivery runner was notified.");
                    displayAcceptedOrders(vendor);
                } else {
                    JOptionPane.showMessageDialog(this, "Unable to complete the order. Please try again.");
                }
            } else {
                if (acceptedOrder.completeOrder()) {
                    JOptionPane.showMessageDialog(this, "Order completed. You can view the order in 'Order History' tab.");
                    displayAcceptedOrders(vendor);
                } else {
                    JOptionPane.showMessageDialog(this, "Unable to complete order. Please try again.");
                }
            }
        }
    }//GEN-LAST:event_btnCompleteOrderActionPerformed

    private void acceptedOrderTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_acceptedOrderTableMouseReleased
        int row = acceptedOrderTable.getSelectedRow();
        if (row >= 0) {
            String orderID = String.valueOf(acceptedOrderTable.getValueAt(row, 0));
            acceptedOrder = (Order) new Order(orderID).getObject("Pending Order Details");
            displayOrderDetails();
        }
    }//GEN-LAST:event_acceptedOrderTableMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable acceptedOrderTable;
    private javax.swing.JButton btnCompleteOrder;
    private javax.swing.JComboBox<String> cbxService;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lblCustomerID;
    private javax.swing.JTextField lblOrderDate;
    private javax.swing.JTextField lblOrderID;
    private javax.swing.JTextField lblOrderStatus;
    private javax.swing.JTextField lblOrderTime;
    private javax.swing.JTextField lblServiceType;
    private javax.swing.JTextField lblTotalOrderCost;
    private javax.swing.JList<String> listFoodItems;
    private javax.swing.JScrollPane scrollFoodItems;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}