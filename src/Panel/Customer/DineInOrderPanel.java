package Panel.Customer;

import JSwingObjects.JTablesAndCombobox;
import Order.Foodcart;
import Order.Order;
import User.Customer;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author CHOK QI YANG TP070091
 */
public class DineInOrderPanel extends javax.swing.JPanel implements JTablesAndCombobox{
    private final DefaultTableModel model = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column){  
            return false;  
        }
    };
    private final TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
    private final String[] dineInOrderTableColumns = {"ID", "Date", "Restaurant", "VendorID"};
    
    private Customer customer;   
    private Order dineInOrder;
    
    public DineInOrderPanel() {
        initComponents();
        model.setColumnIdentifiers(dineInOrderTableColumns);
        dineInOrderTable.setModel(model);
    }
    
    public void displayDineInOrders(Customer customer) {
        this.customer = customer;
        dineInOrder = null;
        Order orders = new Order(customer);
        
        clearOrderDetails();
        
        model.setRowCount(0);
        
        ArrayList<Order> orderList = orders.getPendingOrderList(true);
        
        if (orderList != null) {
            for (Order order : orderList) {
                String[] tableInfo = {order.getOrderID(), order.getOrderDate(), order.getVendor().getName(),
                    order.getVendor().getId()};
                addItemToComboBox(cbxDate, order.getOrderDate());
                model.addRow(tableInfo);
            }
        }
        cbxDate.setSelectedIndex(0);
    }
    
    public void displayOrderDetails(Order order) {
        clearOrderDetails();
        
        lblVendorName.setText(order.getVendor().getName());
        txtRestaurantAddress.setText(order.getVendor().getRestaurantAddress());

        lblService.setText(order.getServiceType());
        lblDate.setText(order.getOrderDate());
        lblTime.setText(order.getOrderTime());
        lblStatus.setText(order.getOrderStatus());
        lblTotalPrice.setText("RM "+ String.format("%.2f", order.getOrderCost()));

        String itemOrderList = "";
        Foodcart foodCart = order.getFoodCart();
        for (int i = 0; i < foodCart.getFoodItems().size(); i++) {
        itemOrderList += foodCart.getFoodItems().get(i).getItemName()+ "(x"+foodCart.getFoodItemCounts().get(i)+")"
                +" - RM "+String.format("%.2f", foodCart.getFoodItems().get(i).getItemPrice() * foodCart.getFoodItemCounts().get(i))
                +"\n-----------------------------------------\n";
        }
        txtItemOrderDetails.setText(itemOrderList);
        String orderStatus = order.getOrderStatus();
        lblStatus.setText(orderStatus);
        switch (orderStatus) {
            case "Pending":
                lblOrder.setText("Pending Order");
                break;
            case "Preparing":
                lblOrder.setText("Preparing Order");
                break;
            default:
                break;
        }
    }
    
    @Override
    public boolean comboboxFilterImplementation(RowFilter.Entry<? extends DefaultTableModel, ? extends Object> entry) {
        String dateFilter = (String) cbxDate.getSelectedItem();
        String dateItem = entry.getStringValue(0);
        
        boolean date = "All".equals(dateFilter) || dateItem.equals(dateFilter);
        return date;
    }
    
    public void clearOrderDetails() {
        lblOrder.setText("No Order Selected");
        txtItemOrderDetails.setText("");
        lblVendorName.setText("");
        txtRestaurantAddress.setText("");
        lblService.setText("");
        lblDate.setText("");
        lblTime.setText("");
        lblTotalPrice.setText("0");
        lblStatus.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dineInOrderPanel = new javax.swing.JPanel();
        orderDetailsPanel = new javax.swing.JPanel();
        lblOrderDetails = new javax.swing.JLabel();
        lblRestaurantAddress = new javax.swing.JLabel();
        scrollRestaurantAddress1 = new javax.swing.JScrollPane();
        txtRestaurantAddress = new javax.swing.JTextArea();
        lblTotalCost = new javax.swing.JLabel();
        lblTotalPrice = new javax.swing.JLabel();
        lblServiceType = new javax.swing.JLabel();
        lblService = new javax.swing.JLabel();
        lblRestaurantName = new javax.swing.JLabel();
        lblVendorName = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        lblOrderTime = new javax.swing.JLabel();
        lblOrderDate = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblOrderStatus = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        lblOrder = new javax.swing.JLabel();
        orderStatusPanel = new javax.swing.JPanel();
        lblOrderStatusDetails = new javax.swing.JLabel();
        cbxDate = new javax.swing.JComboBox<>();
        lblDateFilter = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        dineInOrderTable = new javax.swing.JTable();
        btnRefresh = new javax.swing.JButton();
        itemOrderDetailsPanel = new javax.swing.JPanel();
        scrollRestaurantAddress3 = new javax.swing.JScrollPane();
        txtItemOrderDetails = new javax.swing.JTextArea();
        lblItemOrderDetails = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(926, 560));
        setMinimumSize(new java.awt.Dimension(926, 560));
        setPreferredSize(new java.awt.Dimension(926, 560));

        dineInOrderPanel.setBackground(new java.awt.Color(255, 255, 255));
        dineInOrderPanel.setMaximumSize(new java.awt.Dimension(926, 560));
        dineInOrderPanel.setMinimumSize(new java.awt.Dimension(926, 560));
        dineInOrderPanel.setPreferredSize(new java.awt.Dimension(926, 560));

        orderDetailsPanel.setBackground(new java.awt.Color(255, 255, 255));
        orderDetailsPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        lblOrderDetails.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        lblOrderDetails.setText("Order Details:");

        lblRestaurantAddress.setFont(new java.awt.Font("Dubai Light", 0, 16)); // NOI18N
        lblRestaurantAddress.setText("Restaurant Address:");

        txtRestaurantAddress.setEditable(false);
        txtRestaurantAddress.setBackground(new java.awt.Color(255, 255, 255));
        txtRestaurantAddress.setColumns(20);
        txtRestaurantAddress.setFont(new java.awt.Font("Dubai Light", 0, 18)); // NOI18N
        txtRestaurantAddress.setLineWrap(true);
        txtRestaurantAddress.setTabSize(4);
        txtRestaurantAddress.setWrapStyleWord(true);
        txtRestaurantAddress.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtRestaurantAddress.setMargin(new java.awt.Insets(0, 0, 0, 0));
        scrollRestaurantAddress1.setViewportView(txtRestaurantAddress);

        lblTotalCost.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblTotalCost.setText("Total Cost:");

        lblTotalPrice.setFont(new java.awt.Font("Dubai Light", 1, 24)); // NOI18N
        lblTotalPrice.setText("RM 0");

        lblServiceType.setFont(new java.awt.Font("Dubai Light", 0, 16)); // NOI18N
        lblServiceType.setText("Service Type:");

        lblService.setFont(new java.awt.Font("Dubai Light", 0, 16)); // NOI18N
        lblService.setText("-");

        lblRestaurantName.setFont(new java.awt.Font("Dubai Light", 0, 16)); // NOI18N
        lblRestaurantName.setText("Restaurant Name:");

        lblVendorName.setFont(new java.awt.Font("Dubai Light", 0, 16)); // NOI18N
        lblVendorName.setText("-");

        lblTime.setFont(new java.awt.Font("Dubai Light", 0, 16)); // NOI18N
        lblTime.setText("-");

        lblOrderTime.setFont(new java.awt.Font("Dubai Light", 0, 16)); // NOI18N
        lblOrderTime.setText("Order Time:");

        lblOrderDate.setFont(new java.awt.Font("Dubai Light", 0, 16)); // NOI18N
        lblOrderDate.setText("Order Date:");

        lblDate.setFont(new java.awt.Font("Dubai Light", 0, 16)); // NOI18N
        lblDate.setText("-");

        lblOrderStatus.setFont(new java.awt.Font("Dubai Light", 0, 16)); // NOI18N
        lblOrderStatus.setText("Order Status:");

        lblStatus.setFont(new java.awt.Font("Dubai Light", 0, 16)); // NOI18N
        lblStatus.setText("-");

        javax.swing.GroupLayout orderDetailsPanelLayout = new javax.swing.GroupLayout(orderDetailsPanel);
        orderDetailsPanel.setLayout(orderDetailsPanelLayout);
        orderDetailsPanelLayout.setHorizontalGroup(
            orderDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderDetailsPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblOrderDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(orderDetailsPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblRestaurantName)
                .addGap(7, 7, 7)
                .addComponent(lblVendorName))
            .addGroup(orderDetailsPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblRestaurantAddress))
            .addGroup(orderDetailsPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(scrollRestaurantAddress1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(orderDetailsPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(orderDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblServiceType, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblOrderDate, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblOrderTime, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblOrderStatus, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(orderDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDate)
                    .addComponent(lblService)
                    .addComponent(lblTime)
                    .addComponent(lblStatus)))
            .addGroup(orderDetailsPanelLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lblTotalCost)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotalPrice))
        );
        orderDetailsPanelLayout.setVerticalGroup(
            orderDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderDetailsPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblOrderDetails)
                .addGap(6, 6, 6)
                .addGroup(orderDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRestaurantName)
                    .addComponent(lblVendorName))
                .addGap(6, 6, 6)
                .addComponent(lblRestaurantAddress)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollRestaurantAddress1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(orderDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblService)
                    .addComponent(lblServiceType))
                .addGap(2, 2, 2)
                .addGroup(orderDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOrderDate)
                    .addComponent(lblDate))
                .addGap(2, 2, 2)
                .addGroup(orderDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOrderTime)
                    .addComponent(lblTime))
                .addGap(2, 2, 2)
                .addGroup(orderDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOrderStatus)
                    .addComponent(lblStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(orderDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalCost)
                    .addComponent(lblTotalPrice))
                .addGap(9, 9, 9))
        );

        lblOrder.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lblOrder.setText("No Order Selected");

        orderStatusPanel.setBackground(new java.awt.Color(255, 255, 255));
        orderStatusPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        orderStatusPanel.setMaximumSize(new java.awt.Dimension(298, 492));
        orderStatusPanel.setMinimumSize(new java.awt.Dimension(298, 492));
        orderStatusPanel.setPreferredSize(new java.awt.Dimension(298, 492));

        lblOrderStatusDetails.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        lblOrderStatusDetails.setText("Dine-in Orders:");

        cbxDate.setFont(new java.awt.Font("Dubai Light", 0, 16)); // NOI18N
        cbxDate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All" }));
        cbxDate.setToolTipText("");
        cbxDate.setMaximumSize(new java.awt.Dimension(105, 25));
        cbxDate.setMinimumSize(new java.awt.Dimension(105, 25));
        cbxDate.setPreferredSize(new java.awt.Dimension(105, 25));
        cbxDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxDateActionPerformed(evt);
            }
        });

        lblDateFilter.setFont(new java.awt.Font("Dubai Light", 0, 16)); // NOI18N
        lblDateFilter.setText("Date:");

        dineInOrderTable.setModel(model);
        dineInOrderTable.setMaximumSize(new java.awt.Dimension(282, 410));
        dineInOrderTable.setMinimumSize(new java.awt.Dimension(282, 410));
        dineInOrderTable.setName(""); // NOI18N
        dineInOrderTable.setPreferredSize(new java.awt.Dimension(282, 410));
        dineInOrderTable.setRowHeight(50);
        dineInOrderTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                dineInOrderTableMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(dineInOrderTable);

        javax.swing.GroupLayout orderStatusPanelLayout = new javax.swing.GroupLayout(orderStatusPanel);
        orderStatusPanel.setLayout(orderStatusPanelLayout);
        orderStatusPanelLayout.setHorizontalGroup(
            orderStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderStatusPanelLayout.createSequentialGroup()
                .addGroup(orderStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(orderStatusPanelLayout.createSequentialGroup()
                        .addGroup(orderStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, orderStatusPanelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lblOrderStatusDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, orderStatusPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblDateFilter)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxDate, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addGroup(orderStatusPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );
        orderStatusPanelLayout.setVerticalGroup(
            orderStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderStatusPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblOrderStatusDetails)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(orderStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDateFilter)
                    .addComponent(cbxDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnRefresh.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 18)); // NOI18N
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        itemOrderDetailsPanel.setBackground(new java.awt.Color(255, 255, 255));
        itemOrderDetailsPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        txtItemOrderDetails.setEditable(false);
        txtItemOrderDetails.setBackground(new java.awt.Color(255, 255, 255));
        txtItemOrderDetails.setColumns(20);
        txtItemOrderDetails.setFont(new java.awt.Font("Dubai Light", 0, 16)); // NOI18N
        txtItemOrderDetails.setLineWrap(true);
        txtItemOrderDetails.setTabSize(4);
        txtItemOrderDetails.setWrapStyleWord(true);
        txtItemOrderDetails.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtItemOrderDetails.setMargin(new java.awt.Insets(0, 0, 0, 0));
        scrollRestaurantAddress3.setViewportView(txtItemOrderDetails);

        lblItemOrderDetails.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        lblItemOrderDetails.setText("Item Order Details:");

        javax.swing.GroupLayout itemOrderDetailsPanelLayout = new javax.swing.GroupLayout(itemOrderDetailsPanel);
        itemOrderDetailsPanel.setLayout(itemOrderDetailsPanelLayout);
        itemOrderDetailsPanelLayout.setHorizontalGroup(
            itemOrderDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itemOrderDetailsPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblItemOrderDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(268, 268, 268))
            .addGroup(itemOrderDetailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollRestaurantAddress3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        itemOrderDetailsPanelLayout.setVerticalGroup(
            itemOrderDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itemOrderDetailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblItemOrderDetails)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollRestaurantAddress3)
                .addContainerGap())
        );

        btnCancel.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 18)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dineInOrderPanelLayout = new javax.swing.GroupLayout(dineInOrderPanel);
        dineInOrderPanel.setLayout(dineInOrderPanelLayout);
        dineInOrderPanelLayout.setHorizontalGroup(
            dineInOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dineInOrderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dineInOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(dineInOrderPanelLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(orderStatusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(orderDetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(itemOrderDetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dineInOrderPanelLayout.createSequentialGroup()
                        .addComponent(lblOrder)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, Short.MAX_VALUE))
        );
        dineInOrderPanelLayout.setVerticalGroup(
            dineInOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dineInOrderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dineInOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblOrder)
                    .addGroup(dineInOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dineInOrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(orderStatusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(orderDetailsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(itemOrderDetailsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dineInOrderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dineInOrderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        displayDineInOrders(customer);
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void cbxDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxDateActionPerformed
        applyFilters(sorter);
    }//GEN-LAST:event_cbxDateActionPerformed

    private void dineInOrderTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dineInOrderTableMouseReleased
        int selectedIndex = dineInOrderTable.getSelectedRow();
        if (selectedIndex >= 0) {
            String id = (String) dineInOrderTable.getValueAt(selectedIndex, 0);
            dineInOrder = (Order) new Order(id).getObject("Pending Order Details");
            displayOrderDetails(dineInOrder);
        }
    }//GEN-LAST:event_dineInOrderTableMouseReleased

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        if (dineInOrder != null) {
            if (dineInOrder.getOrderStatus().equals("Pending")) {
                if (dineInOrder.cancelOrder()) {
                    JOptionPane.showMessageDialog(this,"Order cancelled.");
                    displayDineInOrders(customer);
                } else {
                    JOptionPane.showMessageDialog(this,"Unable to cancel order. Please try again.");
                }
            } else {
                JOptionPane.showMessageDialog(this,"Order was already accepted. Unable to cancel the order.");
            }
        } else {
            JOptionPane.showMessageDialog(this,"You have no delivery or take away order at the moment. You may place an order.");
        }
    }//GEN-LAST:event_btnCancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JComboBox<String> cbxDate;
    private javax.swing.JPanel dineInOrderPanel;
    private javax.swing.JTable dineInOrderTable;
    private javax.swing.JPanel itemOrderDetailsPanel;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDateFilter;
    private javax.swing.JLabel lblItemOrderDetails;
    private javax.swing.JLabel lblOrder;
    private javax.swing.JLabel lblOrderDate;
    private javax.swing.JLabel lblOrderDetails;
    private javax.swing.JLabel lblOrderStatus;
    private javax.swing.JLabel lblOrderStatusDetails;
    private javax.swing.JLabel lblOrderTime;
    private javax.swing.JLabel lblRestaurantAddress;
    private javax.swing.JLabel lblRestaurantName;
    private javax.swing.JLabel lblService;
    private javax.swing.JLabel lblServiceType;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblTotalCost;
    private javax.swing.JLabel lblTotalPrice;
    private javax.swing.JLabel lblVendorName;
    private javax.swing.JPanel orderDetailsPanel;
    private javax.swing.JPanel orderStatusPanel;
    private javax.swing.JScrollPane scrollRestaurantAddress1;
    private javax.swing.JScrollPane scrollRestaurantAddress3;
    private javax.swing.JTextArea txtItemOrderDetails;
    private javax.swing.JTextArea txtRestaurantAddress;
    // End of variables declaration//GEN-END:variables
}
