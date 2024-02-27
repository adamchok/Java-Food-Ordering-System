package Panel.Vendor;

import JSwingObjects.JTablesAndCombobox;
import Order.Order;
import Transaction.Transaction;
import User.Vendor;
import java.util.ArrayList;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author KWAN JUN ER TP066265
 */
public class RevenueDashboard extends javax.swing.JPanel implements JTablesAndCombobox{
    private final DefaultTableModel model = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column){
            return false;
        }
    };
    private final TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
    private final String[] RevenueDashboardColumns = {"Order ID", "Service Type", "Date","Time", "Order Cost"};
    
    private Vendor vendor;
    private Order orderHistory;
    
    public RevenueDashboard() {
        initComponents();
        model.setColumnIdentifiers(RevenueDashboardColumns);
        orderHistoryTable.setModel(model);
        orderHistoryTable.setRowSorter(sorter);
    }
    
    public void displayRevenueDashboard(Vendor vendor) {
        model.setRowCount(0);
        clearOrderDetails();
        orderHistory = null;
        this.vendor = vendor;
        
        Order orders = new Order(vendor);
        ArrayList<Order> orderHistoryList = orders.getOrderHistoryList();
        if (!orderHistoryList.isEmpty()) {
            for (Order order : orderHistoryList) {
                if (!order.getOrderStatus().equals("Cancelled") && !order.getOrderStatus().equals("Rejected")) {
                    String[] tableData = {order.getOrderID(), order.getServiceType(), order.getOrderDate(), order.getOrderTime(),
                    String.format("%.2f", order.getFoodCart().getTotalCost())};
                    
                    String[] date = order.getOrderDate().split("/");
                    String year = date[2];

                    addItemToComboBox(cbxYear, year);

                    model.addRow(tableData);
                }
            }
        }
        calculateRevenue();
    }
    
    private void clearOrderDetails() {
        lblOrderID.setText("");
        lblOrderDate.setText("");
        lblOrderTime.setText("");
        lblServiceType.setText("");
        lblInvoiceNumber.setText("");
        lblTotalOrderCost.setText("");
        lblTotalOrderProfit.setText("");
    }
    
    private void calculateRevenue() {
        int rowCount = orderHistoryTable.getRowCount();
        int numberOfOrders = rowCount;
        double totalRevenue = 0;
        
        for (int i = 0; i < rowCount; i++) {
            double amount = Double.parseDouble(String.valueOf(orderHistoryTable.getValueAt(i, 4)));
            totalRevenue += amount;
        }
        
        lblTotalOrder.setText(String.valueOf(numberOfOrders));
        lblTotalRevenue.setText("RM "+String.format("%.2f", totalRevenue));
        lblProfit.setText("RM "+String.format("%.2f", totalRevenue * 0.90));
    }
    
    private void displayOrderDetails() {
        if (orderHistory != null) {
            lblOrderID.setText(orderHistory.getOrderID());
            lblOrderDate.setText(orderHistory.getOrderDate());
            lblOrderTime.setText(orderHistory.getOrderTime());
            lblServiceType.setText(orderHistory.getServiceType());
            
            lblTotalOrderCost.setText("RM "+String.format("%.2f", orderHistory.getOrderCost()));
            lblTotalOrderProfit.setText("RM "+String.format("%.2f", orderHistory.getFoodCart().getTotalCost() * 0.9));
            
            Transaction transaction = new Transaction(orderHistory.getOrderID());
            transaction = (Transaction) transaction.getObject("Transaction History");
            lblInvoiceNumber.setText(transaction.getInvoiceNumber());
        }
    }
    
    @Override
    public boolean comboboxFilterImplementation(RowFilter.Entry<? extends DefaultTableModel, ? extends Object> entry) {
        String monthFilter = (String) cbxMonth.getSelectedItem();
        String quaterFilter = (String) cbxQuater.getSelectedItem();
        String yearFilter = (String) cbxYear.getSelectedItem();
        String searchFilter = txtSearch.getText();
        
        
        String idItem = entry.getStringValue(0);
        String date = entry.getStringValue(2);
        
        
        String monthItem = date.split("/")[1];
        String yearItem = date.split("/")[2];
        String quaterItem;
        
        quaterItem = switch (monthItem) {
            case "All"-> "All";
            case "1", "2", "3" -> "1";
            case "4", "5", "6" -> "2";
            case "7", "8", "9" -> "3";
            default -> "4";
        };
        
        boolean quater = "All".equals(quaterFilter) || quaterItem.equals(quaterFilter);
        boolean month = "All".equals(monthFilter) || monthItem.equals(monthFilter);
        boolean year = "All".equals(yearFilter) || yearItem.equals(yearFilter);
        boolean id = searchFilter.isEmpty() || searchFilter.isBlank() || idItem.contains(searchFilter);
                
        return quater && month && year && id;    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        orderHistoryTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblTotalRevenue = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblTotalOrder = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        lblProfit = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lblOrderID = new javax.swing.JTextField();
        lblOrderDate = new javax.swing.JTextField();
        lblOrderTime = new javax.swing.JTextField();
        lblServiceType = new javax.swing.JTextField();
        lblTotalOrderCost = new javax.swing.JTextField();
        lblTotalOrderProfit = new javax.swing.JTextField();
        btnViewOrderRecord = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        lblInvoiceNumber = new javax.swing.JTextField();
        txtSearch = new javax.swing.JTextField();
        cbxMonth = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        cbxYear = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        cbxQuater = new javax.swing.JComboBox<>();

        setMaximumSize(new java.awt.Dimension(925, 600));
        setMinimumSize(new java.awt.Dimension(925, 600));
        setPreferredSize(new java.awt.Dimension(925, 600));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Revenue Dashboard");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Month :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Search Order ID :");

        orderHistoryTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                orderHistoryTableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(orderHistoryTable);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Total Revenue Earned:");

        lblTotalRevenue.setEditable(false);
        lblTotalRevenue.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTotalRevenue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblTotalRevenue.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        lblTotalRevenue.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Total Order:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Commision Rate:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Profit Earned :");

        lblTotalOrder.setEditable(false);
        lblTotalOrder.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTotalOrder.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblTotalOrder.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        lblTotalOrder.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("10 %");

        lblProfit.setEditable(false);
        lblProfit.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblProfit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblProfit.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        lblProfit.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(lblTotalOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(lblTotalRevenue, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(lblProfit, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTotalRevenue, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(lblProfit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTotalOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Order ID :");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Order Date:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Service Type:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Order Time:");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Total Order Cost:");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("Total Order Profit:");

        lblOrderID.setEditable(false);
        lblOrderID.setBackground(new java.awt.Color(255, 255, 255));
        lblOrderID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblOrderID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblOrderID.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        lblOrderID.setEnabled(false);

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

        lblServiceType.setEditable(false);
        lblServiceType.setBackground(new java.awt.Color(255, 255, 255));
        lblServiceType.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblServiceType.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblServiceType.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        lblServiceType.setEnabled(false);

        lblTotalOrderCost.setEditable(false);
        lblTotalOrderCost.setBackground(new java.awt.Color(255, 255, 255));
        lblTotalOrderCost.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTotalOrderCost.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblTotalOrderCost.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        lblTotalOrderCost.setEnabled(false);

        lblTotalOrderProfit.setEditable(false);
        lblTotalOrderProfit.setBackground(new java.awt.Color(255, 255, 255));
        lblTotalOrderProfit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTotalOrderProfit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblTotalOrderProfit.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        lblTotalOrderProfit.setEnabled(false);

        btnViewOrderRecord.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnViewOrderRecord.setText("View Order History");
        btnViewOrderRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewOrderRecordActionPerformed(evt);
            }
        });

        btnClear.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setText("Invoice Number:");

        lblInvoiceNumber.setEditable(false);
        lblInvoiceNumber.setBackground(new java.awt.Color(255, 255, 255));
        lblInvoiceNumber.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblInvoiceNumber.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblInvoiceNumber.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        lblInvoiceNumber.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(149, Short.MAX_VALUE)
                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnViewOrderRecord)
                .addGap(6, 6, 6))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel12)
                    .addComponent(jLabel14)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblServiceType, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblInvoiceNumber)
                    .addComponent(lblTotalOrderCost)
                    .addComponent(lblTotalOrderProfit)
                    .addComponent(lblOrderID)
                    .addComponent(lblOrderDate)
                    .addComponent(lblOrderTime, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lblOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lblOrderDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(lblOrderTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lblServiceType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(lblInvoiceNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(lblTotalOrderCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(lblTotalOrderProfit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClear)
                    .addComponent(btnViewOrderRecord))
                .addContainerGap())
        );

        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSearch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchKeyTyped(evt);
            }
        });

        cbxMonth.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cbxMonth.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxMonthItemStateChanged(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Order History");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setText("Year :");

        cbxYear.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All" }));
        cbxYear.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxYearItemStateChanged(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setText("Quater :");

        cbxQuater.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxQuater.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "1", "2", "3", "4" }));
        cbxQuater.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxQuaterItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxQuater, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxYear, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbxYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbxQuater, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbxMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        orderHistoryTable.clearSelection();
        clearOrderDetails();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnViewOrderRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewOrderRecordActionPerformed
        Panel.Vendor.MainPanel mainPanel = (Panel.Vendor.MainPanel) this.getParent();
        mainPanel.displayOrder(vendor, 2);
    }//GEN-LAST:event_btnViewOrderRecordActionPerformed

    private void cbxMonthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxMonthItemStateChanged
        applyFilters(sorter);
        calculateRevenue();
    }//GEN-LAST:event_cbxMonthItemStateChanged

    private void cbxQuaterItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxQuaterItemStateChanged
        applyFilters(sorter);
        calculateRevenue();
    }//GEN-LAST:event_cbxQuaterItemStateChanged

    private void cbxYearItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxYearItemStateChanged
        applyFilters(sorter);
        calculateRevenue();
    }//GEN-LAST:event_cbxYearItemStateChanged

    private void txtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyTyped
        applyFilters(sorter);
        calculateRevenue();
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
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnViewOrderRecord;
    private javax.swing.JComboBox<String> cbxMonth;
    private javax.swing.JComboBox<String> cbxQuater;
    private javax.swing.JComboBox<String> cbxYear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lblInvoiceNumber;
    private javax.swing.JTextField lblOrderDate;
    private javax.swing.JTextField lblOrderID;
    private javax.swing.JTextField lblOrderTime;
    private javax.swing.JTextField lblProfit;
    private javax.swing.JTextField lblServiceType;
    private javax.swing.JTextField lblTotalOrder;
    private javax.swing.JTextField lblTotalOrderCost;
    private javax.swing.JTextField lblTotalOrderProfit;
    private javax.swing.JTextField lblTotalRevenue;
    private javax.swing.JTable orderHistoryTable;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
