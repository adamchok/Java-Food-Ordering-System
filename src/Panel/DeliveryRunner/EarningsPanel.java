/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Panel.DeliveryRunner;

import JSwingObjects.JTablesAndCombobox;
import Order.DeliveryTask;
import User.DeliveryRunner;
import java.util.ArrayList;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author NABIL BIN NAZME NAZIM TP072131
 */
public class EarningsPanel extends javax.swing.JPanel implements  JTablesAndCombobox {
    private final DefaultTableModel modelTableHistory = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column){
            return false;
        }
    };
    private final String[] colNames = {"ID", "Restaurant", "Date", "Time", "Amount"};
    private final TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelTableHistory);
    
    private DeliveryRunner runner;
    private DeliveryTask deliveryHistory;
    private double earning = 0;
    
    public EarningsPanel() {
        initComponents();
        modelTableHistory.setColumnIdentifiers(colNames);
        tableHistory.setModel(modelTableHistory);
        tableHistory.setRowSorter(sorter);
    }
    
    public void displayRevenueDashboard(DeliveryRunner runner) {
        modelTableHistory.setRowCount(0);
        clearDeliveryDetails();
        deliveryHistory = null;
        this.runner = runner;
        
        DeliveryTask tasks = new DeliveryTask(runner);
        ArrayList<DeliveryTask> deliveryHistoryList = tasks.getDeliveryHistory();
        if (!deliveryHistoryList.isEmpty()) {
            for (DeliveryTask task : deliveryHistoryList) {
                String[] tableData = {task.getDeliveryID(), task.getOrder().getVendor().getName(), task.getDeliveryDate(), task.getDeliveryTime(),
                    String.format("%.2f", task.getDeliveryCost())};
                
                String[] date = task.getDeliveryDate().split("/");
                String year = date[2];
                
                addItemToComboBox(cbxYear, year);
                
                modelTableHistory.addRow(tableData);
            }
        }
        calculateRevenue();
    }
    
    private void clearDeliveryDetails() {
        lblDeliveryID.setText("");
        lblDeliveryDate.setText("");
        lblDeliveryTime.setText("");
        lblRestaurant.setText("");
        lblDeliveryFee.setText("");
        lblRestaurantAddress.setText("");
        lblDeliveryAddress.setText("");
    }
    
    private void calculateRevenue() {
        double totalRevenue = 0;
        
        for (int i = 0; i < tableHistory.getRowCount() ; i++) {
            double amount = Double.parseDouble(String.valueOf(tableHistory.getValueAt(i, 4)));
            totalRevenue += amount;
        }
        
        lblRMAmount.setText("Profit: RM "+String.format("%.2f", totalRevenue));
    }
    
    private void displayDeliveryDetails() {
        if (deliveryHistory != null) {
            lblDeliveryID.setText(deliveryHistory.getDeliveryID());
            lblDeliveryDate.setText(deliveryHistory.getDeliveryDate());
            lblDeliveryTime.setText(deliveryHistory.getDeliveryTime());
            lblRestaurant.setText(deliveryHistory.getOrder().getVendor().getName());
            
            lblDeliveryFee.setText("RM "+String.format("%.2f", deliveryHistory.getDeliveryCost()));
            
            lblRestaurantAddress.setText(deliveryHistory.getOrder().getVendor().getRestaurantAddress());
            lblDeliveryAddress.setText(deliveryHistory.getOrder().getDeliveryAddress());
        }
    }
    
    @Override
    public boolean comboboxFilterImplementation(RowFilter.Entry<? extends DefaultTableModel, ? extends Object> entry) {
        String monthFilter = (String) cbxMonth.getSelectedItem();
        String quaterFilter = (String) cbxQuater.getSelectedItem();
        String yearFilter = (String) cbxYear.getSelectedItem();
        
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
                
        return quater && month && year;    
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblRevenueDashboard = new javax.swing.JLabel();
        panelEarningFilter = new javax.swing.JPanel();
        lblRMAmount = new javax.swing.JLabel();
        scrollHistory = new javax.swing.JScrollPane();
        tableHistory = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        cbxMonth = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        cbxQuater = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        cbxYear = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblDeliveryID = new javax.swing.JTextField();
        lblDeliveryDate = new javax.swing.JTextField();
        lblDeliveryTime = new javax.swing.JTextField();
        lblRestaurant = new javax.swing.JTextField();
        btnClear = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        lblDeliveryFee = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lblRestaurantAddress = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        lblDeliveryAddress = new javax.swing.JTextArea();
        jLabel20 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(880, 600));
        setMinimumSize(new java.awt.Dimension(880, 600));
        setPreferredSize(new java.awt.Dimension(880, 600));

        lblRevenueDashboard.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lblRevenueDashboard.setText("Revenue Dashboard");

        panelEarningFilter.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelEarningFilterLayout = new javax.swing.GroupLayout(panelEarningFilter);
        panelEarningFilter.setLayout(panelEarningFilterLayout);
        panelEarningFilterLayout.setHorizontalGroup(
            panelEarningFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelEarningFilterLayout.setVerticalGroup(
            panelEarningFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lblRMAmount.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lblRMAmount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRMAmount.setText("Profit: RM {Insert}");

        tableHistory.setModel(modelTableHistory);
        tableHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableHistoryMouseReleased(evt);
            }
        });
        scrollHistory.setViewportView(tableHistory);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Month :");

        cbxMonth.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cbxMonth.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxMonthItemStateChanged(evt);
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

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setText("Year :");

        cbxYear.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All" }));
        cbxYear.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxYearItemStateChanged(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Delivery ID:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Delivery Date:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Restaurant:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Delivery Time:");

        lblDeliveryID.setEditable(false);
        lblDeliveryID.setBackground(new java.awt.Color(255, 255, 255));
        lblDeliveryID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDeliveryID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblDeliveryID.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        lblDeliveryID.setEnabled(false);

        lblDeliveryDate.setEditable(false);
        lblDeliveryDate.setBackground(new java.awt.Color(255, 255, 255));
        lblDeliveryDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDeliveryDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblDeliveryDate.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        lblDeliveryDate.setEnabled(false);

        lblDeliveryTime.setEditable(false);
        lblDeliveryTime.setBackground(new java.awt.Color(255, 255, 255));
        lblDeliveryTime.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDeliveryTime.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblDeliveryTime.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        lblDeliveryTime.setEnabled(false);

        lblRestaurant.setEditable(false);
        lblRestaurant.setBackground(new java.awt.Color(255, 255, 255));
        lblRestaurant.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblRestaurant.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblRestaurant.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        lblRestaurant.setEnabled(false);

        btnClear.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setText("Delivery Fee:");

        lblDeliveryFee.setEditable(false);
        lblDeliveryFee.setBackground(new java.awt.Color(255, 255, 255));
        lblDeliveryFee.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDeliveryFee.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblDeliveryFee.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        lblDeliveryFee.setEnabled(false);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("Restaurant Address:");

        lblRestaurantAddress.setEditable(false);
        lblRestaurantAddress.setBackground(new java.awt.Color(255, 255, 255));
        lblRestaurantAddress.setColumns(20);
        lblRestaurantAddress.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblRestaurantAddress.setLineWrap(true);
        lblRestaurantAddress.setWrapStyleWord(true);
        lblRestaurantAddress.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblRestaurantAddress.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        lblRestaurantAddress.setEnabled(false);
        jScrollPane1.setViewportView(lblRestaurantAddress);

        lblDeliveryAddress.setEditable(false);
        lblDeliveryAddress.setBackground(new java.awt.Color(255, 255, 255));
        lblDeliveryAddress.setColumns(20);
        lblDeliveryAddress.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDeliveryAddress.setLineWrap(true);
        lblDeliveryAddress.setWrapStyleWord(true);
        lblDeliveryAddress.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblDeliveryAddress.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        lblDeliveryAddress.setEnabled(false);
        jScrollPane2.setViewportView(lblDeliveryAddress);

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setText("Delivery Address:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblDeliveryDate, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDeliveryTime, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblRestaurant, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDeliveryFee)
                                    .addComponent(lblDeliveryID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGap(0, 2, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lblDeliveryID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lblDeliveryDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(lblDeliveryTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lblRestaurant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(lblDeliveryFee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnClear)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelEarningFilter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblRevenueDashboard, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(scrollHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblRMAmount, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 852, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(8, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblRevenueDashboard)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelEarningFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbxYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbxQuater, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbxMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRMAmount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollHistory, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

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

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        tableHistory.clearSelection();
        clearDeliveryDetails();
    }//GEN-LAST:event_btnClearActionPerformed

    private void tableHistoryMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableHistoryMouseReleased
        int row = tableHistory.getSelectedRow();
        if (row >= 0) {
            String deliveryID = String.valueOf(tableHistory.getValueAt(row, 0));
            deliveryHistory = (DeliveryTask) new DeliveryTask(deliveryID).getDeliveryTask(true);
            displayDeliveryDetails();
        }
    }//GEN-LAST:event_tableHistoryMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JComboBox<String> cbxMonth;
    private javax.swing.JComboBox<String> cbxQuater;
    private javax.swing.JComboBox<String> cbxYear;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea lblDeliveryAddress;
    private javax.swing.JTextField lblDeliveryDate;
    private javax.swing.JTextField lblDeliveryFee;
    private javax.swing.JTextField lblDeliveryID;
    private javax.swing.JTextField lblDeliveryTime;
    private javax.swing.JLabel lblRMAmount;
    private javax.swing.JTextField lblRestaurant;
    private javax.swing.JTextArea lblRestaurantAddress;
    private javax.swing.JLabel lblRevenueDashboard;
    private javax.swing.JPanel panelEarningFilter;
    private javax.swing.JScrollPane scrollHistory;
    private javax.swing.JTable tableHistory;
    // End of variables declaration//GEN-END:variables
}
