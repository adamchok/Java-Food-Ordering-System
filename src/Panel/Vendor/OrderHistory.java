package Panel.Vendor;

import JSwingObjects.JTablesAndCombobox;
import Order.Foodcart;
import Order.Order;
import Time.Time;
import Transaction.Transaction;
import User.Vendor;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author KWAN JUN ER TP066265
 */
public class OrderHistory extends javax.swing.JPanel implements JTablesAndCombobox {
    private final DefaultTableModel model = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column){
            return false;
        }
    };
    private final DefaultListModel<String> listModel = new DefaultListModel<>();
    private final TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
    private final String[] OrderHistoryListColumns = {"Order ID", "Service Type", "Date","Time", "Order Cost"};

    private Order orderHistory;
    private boolean dailyFilter = false;
    
    public OrderHistory() {
        initComponents();
        model.setColumnIdentifiers(OrderHistoryListColumns);
        orderHistoryTable.setModel(model);
        listFoodItems.setModel(listModel);
        orderHistoryTable.setRowSorter(sorter);
    }
    
    public void displayOrderHistory(Vendor vendor) {
        model.setRowCount(0);
        clearOrderDetails();
        orderHistory = null;
        
        Order orders = new Order(vendor);
        ArrayList<Order> orderHistoryList = orders.getOrderHistoryList();
        
        String[] services = vendor.getServices().split(", ");
        for (String service : services) {
            addItemToComboBox(cbxService, service);
        }
        
        if (!orderHistoryList.isEmpty()) {
            for (Order order : orderHistoryList) {
                String[] tableData = {order.getOrderID(), order.getServiceType(), order.getOrderDate(), order.getOrderTime(),
                    String.format("%.2f", order.getFoodCart().getTotalCost())};
                
                String[] date = order.getOrderDate().split("/");
                String year = date[2];
                addItemToComboBox(cbxYear, year);
                
                model.addRow(tableData);
            }
        }
    }
    
    private void displayOrderDetails() {
        clearOrderDetails();
        if (orderHistory != null) {
            lblOrderID.setText(orderHistory.getOrderID());
            lblOrderStatus.setText(orderHistory.getOrderStatus());
            lblCustomerID.setText(orderHistory.getCustomer().getId());
            lblServiceType.setText(orderHistory.getServiceType());
            lblOrderDate.setText(orderHistory.getOrderDate());
            lblOrderTime.setText(orderHistory.getOrderTime());
            lblTotalOrderCost.setText("RM "+String.format("%.2f", orderHistory.getOrderCost()));
            lblInvoiceNumber.setText("No invoice number");
            
            if (!orderHistory.getOrderStatus().equals("Rejected") && !orderHistory.getOrderStatus().equals("Cancelled")) {
                Transaction transaction = new Transaction(orderHistory.getOrderID());
                transaction = (Transaction) transaction.getObject("Transaction History");
                lblInvoiceNumber.setText(transaction.getInvoiceNumber());
            }
            
            Foodcart orderList = orderHistory.getFoodCart();
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
        lblInvoiceNumber.setText("");
        listModel.clear();
    }
    
    @Override
    public boolean comboboxFilterImplementation(RowFilter.Entry<? extends DefaultTableModel, ? extends Object> entry) {
        String serviceFilter = (String) cbxService.getSelectedItem();
        String monthFilter = (String) cbxMonth.getSelectedItem();
        String yearFilter = (String) cbxYear.getSelectedItem();
        String searchFilter = txtSearch.getText();
        
        String serviceItem = entry.getStringValue(1);
        String idItem = entry.getStringValue(0);
        
        Time clock = new Time();
        String currentDate = clock.getDate();
        
        String date = entry.getStringValue(2);
        String monthItem = date.split("/")[1];
        String yearItem = date.split("/")[2];
        
        
        boolean service = "All".equals(serviceFilter) || serviceItem.contains(serviceFilter);
        boolean month = "All".equals(monthFilter) || monthItem.equals(monthFilter);
        boolean year = "All".equals(yearFilter) || yearItem.equals(yearFilter);
        boolean id = searchFilter.isEmpty() || searchFilter.isBlank() || idItem.contains(searchFilter);
        
        if (dailyFilter == true) {
            boolean daily = currentDate.equals(date);
            return service && id && daily; 
        } else {
            return service && month && year && id;
        } 
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
        orderHistoryTable = new javax.swing.JTable();
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
        lblTotalOrderCost = new javax.swing.JTextField();
        lblCustomerID = new javax.swing.JTextField();
        lblOrderStatus = new javax.swing.JTextField();
        scrollFoodItems = new javax.swing.JScrollPane();
        listFoodItems = new javax.swing.JList<>();
        lblInvoice = new javax.swing.JLabel();
        lblInvoiceNumber = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cbxYear = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cbxService = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        cbxMonth = new javax.swing.JComboBox<>();
        btnDailyFilter = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(944, 600));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setText("Order History");

        orderHistoryTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                orderHistoryTableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(orderHistoryTable);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setMaximumSize(new java.awt.Dimension(506, 487));
        jPanel1.setMinimumSize(new java.awt.Dimension(506, 487));

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
        lblOrderID.setBackground(java.awt.Color.white);
        lblOrderID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblOrderID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblOrderID.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        lblOrderID.setEnabled(false);

        lblServiceType.setEditable(false);
        lblServiceType.setBackground(java.awt.Color.white);
        lblServiceType.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblServiceType.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblServiceType.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        lblServiceType.setEnabled(false);

        lblOrderDate.setEditable(false);
        lblOrderDate.setBackground(java.awt.Color.white);
        lblOrderDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblOrderDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblOrderDate.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        lblOrderDate.setEnabled(false);

        lblOrderTime.setEditable(false);
        lblOrderTime.setBackground(java.awt.Color.white);
        lblOrderTime.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblOrderTime.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblOrderTime.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        lblOrderTime.setEnabled(false);

        lblTotalOrderCost.setEditable(false);
        lblTotalOrderCost.setBackground(java.awt.Color.white);
        lblTotalOrderCost.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTotalOrderCost.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblTotalOrderCost.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        lblTotalOrderCost.setEnabled(false);

        lblCustomerID.setEditable(false);
        lblCustomerID.setBackground(java.awt.Color.white);
        lblCustomerID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCustomerID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblCustomerID.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        lblCustomerID.setEnabled(false);

        lblOrderStatus.setEditable(false);
        lblOrderStatus.setBackground(java.awt.Color.white);
        lblOrderStatus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblOrderStatus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblOrderStatus.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        lblOrderStatus.setEnabled(false);

        listFoodItems.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        listFoodItems.setEnabled(false);
        scrollFoodItems.setViewportView(listFoodItems);

        lblInvoice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblInvoice.setText("Invoice:");

        lblInvoiceNumber.setEditable(false);
        lblInvoiceNumber.setBackground(java.awt.Color.white);
        lblInvoiceNumber.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblInvoiceNumber.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblInvoiceNumber.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        lblInvoiceNumber.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTotalOrderCost))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblInvoice)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblInvoiceNumber)
                                    .addComponent(lblCustomerID, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                                    .addComponent(lblServiceType, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblOrderDate, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblOrderStatus)
                                    .addComponent(lblOrderID)
                                    .addComponent(lblOrderTime, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(scrollFoodItems, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addGap(161, 161, 161))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblOrderStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblServiceType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOrderDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOrderTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jLabel10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblInvoiceNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollFoodItems)))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lblTotalOrderCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
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
        jLabel2.setText("Year Filter:");

        cbxYear.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbxYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All" }));
        cbxYear.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxYearItemStateChanged(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setText("Daily Filter:");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setText("Service Type:");

        cbxService.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbxService.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All" }));
        cbxService.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxServiceItemStateChanged(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setText("Month Filter:");

        cbxMonth.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbxMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cbxMonth.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxMonthItemStateChanged(evt);
            }
        });

        btnDailyFilter.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDailyFilter.setText("Filter");
        btnDailyFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDailyFilterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(178, 178, 178)
                                .addComponent(jLabel15))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(3, 3, 3)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jLabel14)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxService, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDailyFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel16))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxYear, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(cbxService, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(btnDailyFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16)
                                    .addComponent(cbxMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(cbxYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbxServiceItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxServiceItemStateChanged
        clearOrderDetails();
        applyFilters(sorter);
    }//GEN-LAST:event_cbxServiceItemStateChanged

    private void cbxMonthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxMonthItemStateChanged
        clearOrderDetails();
        applyFilters(sorter);
    }//GEN-LAST:event_cbxMonthItemStateChanged

    private void cbxYearItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxYearItemStateChanged
        clearOrderDetails();
        applyFilters(sorter);
    }//GEN-LAST:event_cbxYearItemStateChanged

    private void btnDailyFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDailyFilterActionPerformed
        clearOrderDetails();
        orderHistoryTable.clearSelection();
        orderHistory = null;
        dailyFilter = dailyFilter != true;
        if (dailyFilter == true) {
            btnDailyFilter.setBackground(Color.GREEN);
            cbxMonth.setSelectedIndex(0);
            cbxYear.setSelectedIndex(0);
            cbxMonth.setEnabled(false);
            cbxYear.setEnabled(false);
        } else {
            btnDailyFilter.setBackground(Color.RED);
            cbxMonth.setSelectedIndex(0);
            cbxYear.setSelectedIndex(0);
            cbxMonth.setEnabled(true);
            cbxYear.setEnabled(true);
        }
        applyFilters(sorter);
    }//GEN-LAST:event_btnDailyFilterActionPerformed

    private void txtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyTyped
        clearOrderDetails();
        applyFilters(sorter);
    }//GEN-LAST:event_txtSearchKeyTyped

    private void orderHistoryTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_orderHistoryTableMouseReleased
        int row = orderHistoryTable.getSelectedRow();
        if (row >= 0) {
            String orderID = String.valueOf(orderHistoryTable.getValueAt(row, 0));
            orderHistory = (Order) new Order(orderID).getObject("Order History");
            displayOrderDetails();
        }
    }//GEN-LAST:event_orderHistoryTableMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDailyFilter;
    private javax.swing.JComboBox<String> cbxMonth;
    private javax.swing.JComboBox<String> cbxService;
    private javax.swing.JComboBox<String> cbxYear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JLabel lblInvoice;
    private javax.swing.JTextField lblInvoiceNumber;
    private javax.swing.JTextField lblOrderDate;
    private javax.swing.JTextField lblOrderID;
    private javax.swing.JTextField lblOrderStatus;
    private javax.swing.JTextField lblOrderTime;
    private javax.swing.JTextField lblServiceType;
    private javax.swing.JTextField lblTotalOrderCost;
    private javax.swing.JList<String> listFoodItems;
    private javax.swing.JTable orderHistoryTable;
    private javax.swing.JScrollPane scrollFoodItems;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
