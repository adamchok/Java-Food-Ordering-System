package Panel.Customer;

import Order.DeliveryTask;
import Order.Order;
import Review.DeliveryReview;
import User.Customer;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import JSwingObjects.JTablesAndCombobox;
import Order.Foodcart;

/**
 *
 * @author CHGOK QI YANG TP070091
 */
public class CurrentOrderPanel extends javax.swing.JPanel implements JTablesAndCombobox {
    private DeliveryTask deliveryTask;
    private Order order;
    private Customer customer;
    
    private boolean noDeliveryRunner = false;
    
    public CurrentOrderPanel() {
        initComponents();
        noDeliveryRunnerPanel.setVisible(false);
        deliveryRunnerPanel.setVisible(false);
    }
    
    public void displayCurrentOrder(Customer customer) {
        noDeliveryRunnerPanel.setVisible(false);
        deliveryRunnerPanel.setVisible(false);
        cbxService.setEnabled(true);
        noDeliveryRunner = false;
        this.customer = customer;
        order = null;
        deliveryTask = null;
        
        boolean isDelivery = displayOrderDetails();
        
        if (isDelivery == true) {
            noDeliveryRunner = displayDeliveryDetails();
        }
        
        if (noDeliveryRunner == true) {
            String[] vendorServices = order.getVendor().getServices().split(", ");
            btnCancel.setEnabled(true);
            noDeliveryRunnerPanel.setVisible(true);
            if (vendorServices.length==1 && vendorServices[0].equals("Delivery")) {
                cbxService.setEnabled(false);
                btnConfirm.setEnabled(false);
            } else {
                for (String service : vendorServices) {
                    if (!service.equals("Delivery")) {
                        addItemToComboBox(cbxService, service);
                    }
                }
                btnConfirm.setEnabled(true);
            }
        }
    }
    
    public boolean displayOrderDetails() {
        double serviceFee;
        boolean isDelivery = false;
        Order orders = new Order(customer);
        ArrayList<Order> pendingOrderList = orders.getPendingOrderList(false);
        
        if (!pendingOrderList.isEmpty()) {
            for (Order pendingOrder : pendingOrderList) {
                order = pendingOrder;
                break;
            }
        }
        
        if (order != null) {
            if (order.getServiceType().equals("Delivery")) {
                txtDeliveryAddress.setText(order.getDeliveryAddress());
                serviceFee = 5;
                isDelivery = true;
            } else {
                serviceFee = 0;
                isDelivery = false;
                lblDeliveryStatus.setText("-");
            }
            
            String itemOrderList = "";
            Foodcart foodCart = order.getFoodCart();
            for (int i = 0; i < foodCart.getFoodItems().size(); i++) {
            itemOrderList += foodCart.getFoodItems().get(i).getItemName()+ "(x"+foodCart.getFoodItemCounts().get(i)+")"
                    +" - RM "+String.format("%.2f", foodCart.getFoodItems().get(i).getItemPrice() * foodCart.getFoodItemCounts().get(i))
                    +"\n-----------------------------------------\n";
            }
            
            String orderStatus = order.getOrderStatus();
            lblStatus.setText(orderStatus);
            switch (orderStatus) {
                case "Pending" -> lblOrder.setText("Pending Order");
                case "Preparing" -> lblOrder.setText("Preparing Order");
                case "Pending pick-up" -> {
                    lblOrder.setText("Waiting for order pick-up");
                }
                case "Delivering" -> lblOrder.setText("Delivering Order");
                default -> {
                }
            }
            
            txtItemOrderDetails.setText(itemOrderList);
            
            lblVendorName.setText(order.getVendor().getName());
        
            txtRestaurantAddress.setText(order.getVendor().getRestaurantAddress());
            txtRestaurantAddress.setCaretPosition(0);
            
            lblService.setText(order.getServiceType());
            lblServiceCost.setText("RM "+String.format("%.2f",serviceFee));
            
            lblDate.setText(order.getOrderDate());
            lblTime.setText(order.getOrderTime());
            
            lblTotalPrice.setText("RM "+String.format("%.2f", order.getOrderCost()));
        } else {
            lblOrder.setText("No Orders");
            txtItemOrderDetails.setText("");
            lblVendorName.setText("");
            txtRestaurantAddress.setText("");
            lblService.setText("");
            lblServiceCost.setText("");
            lblDate.setText("");
            lblTime.setText("");
            lblTotalPrice.setText("");
            lblStatus.setText("");
            lblDeliveryStatus.setText("");
        }
        return isDelivery;
    }
    
    
    public boolean displayDeliveryDetails() {
        deliveryRunnerPanel.setVisible(true);
        DeliveryTask task = new DeliveryTask();
        task.setOrder(order);
        deliveryTask = task.getDeliveryTask(false);
        
        if (deliveryTask != null) {
            
            lblDeliveryStatus.setText(deliveryTask.getDeliveryStatus());
            if (deliveryTask.getDeliveryRunner() != null) {
                DeliveryReview deliveryReview = new DeliveryReview(deliveryTask.getDeliveryRunner());
                
                lblName.setText(deliveryTask.getDeliveryRunner().getName());
                lblPhone.setText(deliveryTask.getDeliveryRunner().getPhoneNumber());
                lblRating.setText(deliveryReview.getAverageRating());
            } else {
                return true;
            }
        }
        return false;
    }
    
    // not usng combobox to do filters, so no need to write any code for it.
    @Override
    public boolean comboboxFilterImplementation(RowFilter.Entry<? extends DefaultTableModel, ? extends Object> entry) {
        return false; // do nothing
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        currentOrderPanel = new javax.swing.JPanel();
        orderDetailsPanel = new javax.swing.JPanel();
        lblOrderDetails = new javax.swing.JLabel();
        lblRestaurantAddress = new javax.swing.JLabel();
        scrollRestaurantAddress1 = new javax.swing.JScrollPane();
        txtRestaurantAddress = new javax.swing.JTextArea();
        lblDeliveryAddress = new javax.swing.JLabel();
        scrollRestaurantAddress2 = new javax.swing.JScrollPane();
        txtDeliveryAddress = new javax.swing.JTextArea();
        lblTotalCost = new javax.swing.JLabel();
        lblTotalPrice = new javax.swing.JLabel();
        lblServiceType = new javax.swing.JLabel();
        lblDeliveryCost = new javax.swing.JLabel();
        lblServiceCost = new javax.swing.JLabel();
        lblService = new javax.swing.JLabel();
        lblRestaurantName = new javax.swing.JLabel();
        lblVendorName = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        lblOrderTime = new javax.swing.JLabel();
        lblOrderDate = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        itemOrderDetailsPanel = new javax.swing.JPanel();
        scrollRestaurantAddress3 = new javax.swing.JScrollPane();
        txtItemOrderDetails = new javax.swing.JTextArea();
        lblItemOrderDetails = new javax.swing.JLabel();
        lblOrder = new javax.swing.JLabel();
        orderStatusPanel = new javax.swing.JPanel();
        lblOrderStatusDetails = new javax.swing.JLabel();
        lblOrderStatus = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        lblDeliveryStatus_1 = new javax.swing.JLabel();
        deliveryRunnerPanel = new javax.swing.JPanel();
        lblDeliveryName = new javax.swing.JLabel();
        lblPhoneNumber = new javax.swing.JLabel();
        lblAverageRating = new javax.swing.JLabel();
        lblDeliveryRunnerInfo = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblRating = new javax.swing.JLabel();
        lblDeliveryStatus = new javax.swing.JLabel();
        noDeliveryRunnerPanel = new javax.swing.JPanel();
        lblServiceType1 = new javax.swing.JLabel();
        scrollRestaurantAddress4 = new javax.swing.JScrollPane();
        lblApologies = new javax.swing.JTextArea();
        cbxService = new javax.swing.JComboBox<>();
        btnConfirm = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(906, 560));
        setMinimumSize(new java.awt.Dimension(906, 560));
        setPreferredSize(new java.awt.Dimension(906, 560));

        currentOrderPanel.setBackground(new java.awt.Color(255, 255, 255));
        currentOrderPanel.setMaximumSize(new java.awt.Dimension(906, 560));
        currentOrderPanel.setMinimumSize(new java.awt.Dimension(906, 560));
        currentOrderPanel.setPreferredSize(new java.awt.Dimension(906, 560));
        currentOrderPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        orderDetailsPanel.setBackground(new java.awt.Color(255, 255, 255));
        orderDetailsPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        lblOrderDetails.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        lblOrderDetails.setText("Order Details:");

        lblRestaurantAddress.setFont(new java.awt.Font("Dubai Light", 0, 16)); // NOI18N
        lblRestaurantAddress.setText("Restaurant Address:");

        txtRestaurantAddress.setEditable(false);
        txtRestaurantAddress.setBackground(new java.awt.Color(255, 255, 255));
        txtRestaurantAddress.setColumns(20);
        txtRestaurantAddress.setFont(new java.awt.Font("Dubai Light", 0, 11)); // NOI18N
        txtRestaurantAddress.setLineWrap(true);
        txtRestaurantAddress.setRows(3);
        txtRestaurantAddress.setTabSize(4);
        txtRestaurantAddress.setWrapStyleWord(true);
        txtRestaurantAddress.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        scrollRestaurantAddress1.setViewportView(txtRestaurantAddress);

        lblDeliveryAddress.setFont(new java.awt.Font("Dubai Light", 0, 16)); // NOI18N
        lblDeliveryAddress.setText("Delivery Address (if applicable):");

        txtDeliveryAddress.setEditable(false);
        txtDeliveryAddress.setBackground(new java.awt.Color(255, 255, 255));
        txtDeliveryAddress.setColumns(20);
        txtDeliveryAddress.setFont(new java.awt.Font("Dubai Light", 0, 11)); // NOI18N
        txtDeliveryAddress.setLineWrap(true);
        txtDeliveryAddress.setRows(3);
        txtDeliveryAddress.setTabSize(4);
        txtDeliveryAddress.setWrapStyleWord(true);
        txtDeliveryAddress.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        scrollRestaurantAddress2.setViewportView(txtDeliveryAddress);

        lblTotalCost.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblTotalCost.setText("Total Cost:");

        lblTotalPrice.setFont(new java.awt.Font("Dubai Light", 1, 24)); // NOI18N
        lblTotalPrice.setText("RM 0");

        lblServiceType.setFont(new java.awt.Font("Dubai Light", 0, 16)); // NOI18N
        lblServiceType.setText("Service Type:");

        lblDeliveryCost.setFont(new java.awt.Font("Dubai Light", 0, 16)); // NOI18N
        lblDeliveryCost.setText("Delivery Cost:");

        lblServiceCost.setFont(new java.awt.Font("Dubai Light", 0, 16)); // NOI18N
        lblServiceCost.setText("-");

        lblService.setFont(new java.awt.Font("Dubai Light", 0, 16)); // NOI18N
        lblService.setText("{Insert Service Type}");

        lblRestaurantName.setFont(new java.awt.Font("Dubai Light", 0, 16)); // NOI18N
        lblRestaurantName.setText("Restaurant Name:");

        lblVendorName.setFont(new java.awt.Font("Dubai Light", 0, 16)); // NOI18N
        lblVendorName.setText("{Insert Name}");

        lblTime.setFont(new java.awt.Font("Dubai Light", 0, 16)); // NOI18N
        lblTime.setText("{Insert Order Time}");

        lblOrderTime.setFont(new java.awt.Font("Dubai Light", 0, 16)); // NOI18N
        lblOrderTime.setText("Order Time:");

        lblOrderDate.setFont(new java.awt.Font("Dubai Light", 0, 16)); // NOI18N
        lblOrderDate.setText("Order Date:");

        lblDate.setFont(new java.awt.Font("Dubai Light", 0, 16)); // NOI18N
        lblDate.setText("{Insert Order Date}");

        javax.swing.GroupLayout orderDetailsPanelLayout = new javax.swing.GroupLayout(orderDetailsPanel);
        orderDetailsPanel.setLayout(orderDetailsPanelLayout);
        orderDetailsPanelLayout.setHorizontalGroup(
            orderDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderDetailsPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblOrderDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
            .addGroup(orderDetailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(orderDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollRestaurantAddress1)
                    .addGroup(orderDetailsPanelLayout.createSequentialGroup()
                        .addComponent(lblRestaurantAddress)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(orderDetailsPanelLayout.createSequentialGroup()
                .addGroup(orderDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(orderDetailsPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(orderDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDeliveryAddress)
                            .addGroup(orderDetailsPanelLayout.createSequentialGroup()
                                .addComponent(lblRestaurantName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblVendorName))))
                    .addGroup(orderDetailsPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTotalCost)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTotalPrice)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(orderDetailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(orderDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(orderDetailsPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(orderDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(orderDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblDeliveryCost)
                                .addComponent(lblServiceType)
                                .addGroup(orderDetailsPanelLayout.createSequentialGroup()
                                    .addComponent(lblOrderDate)
                                    .addGap(1, 1, 1)))
                            .addComponent(lblOrderTime, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(orderDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(orderDetailsPanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(orderDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblServiceCost)
                                    .addComponent(lblService)))
                            .addGroup(orderDetailsPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(orderDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTime)
                                    .addComponent(lblDate))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(orderDetailsPanelLayout.createSequentialGroup()
                        .addComponent(scrollRestaurantAddress2)
                        .addContainerGap())))
        );
        orderDetailsPanelLayout.setVerticalGroup(
            orderDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderDetailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblOrderDetails)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(orderDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRestaurantName)
                    .addComponent(lblVendorName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblRestaurantAddress)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollRestaurantAddress1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDeliveryAddress)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollRestaurantAddress2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(orderDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblServiceType)
                    .addComponent(lblService))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(orderDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDeliveryCost)
                    .addComponent(lblServiceCost))
                .addGap(3, 3, 3)
                .addGroup(orderDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOrderDate)
                    .addComponent(lblDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(orderDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOrderTime)
                    .addComponent(lblTime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(orderDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalCost)
                    .addComponent(lblTotalPrice))
                .addGap(160, 160, 160))
        );

        currentOrderPanel.add(orderDetailsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(302, 65, 303, 470));

        itemOrderDetailsPanel.setBackground(new java.awt.Color(255, 255, 255));
        itemOrderDetailsPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        txtItemOrderDetails.setEditable(false);
        txtItemOrderDetails.setBackground(new java.awt.Color(255, 255, 255));
        txtItemOrderDetails.setColumns(20);
        txtItemOrderDetails.setFont(new java.awt.Font("Dubai Light", 0, 16)); // NOI18N
        txtItemOrderDetails.setLineWrap(true);
        txtItemOrderDetails.setRows(1);
        txtItemOrderDetails.setTabSize(4);
        txtItemOrderDetails.setWrapStyleWord(true);
        txtItemOrderDetails.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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
                .addComponent(scrollRestaurantAddress3, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        currentOrderPanel.add(itemOrderDetailsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 65, 290, 470));

        lblOrder.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lblOrder.setText("No Order");
        currentOrderPanel.add(lblOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 456, -1));

        orderStatusPanel.setBackground(new java.awt.Color(255, 255, 255));
        orderStatusPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        orderStatusPanel.setMaximumSize(new java.awt.Dimension(298, 492));
        orderStatusPanel.setMinimumSize(new java.awt.Dimension(298, 492));
        orderStatusPanel.setPreferredSize(new java.awt.Dimension(298, 492));

        lblOrderStatusDetails.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        lblOrderStatusDetails.setText("Order Status Details:");

        lblOrderStatus.setFont(new java.awt.Font("Dubai Light", 0, 16)); // NOI18N
        lblOrderStatus.setText("Order Status:");

        lblStatus.setFont(new java.awt.Font("Dubai Light", 0, 16)); // NOI18N
        lblStatus.setText("-");

        lblDeliveryStatus_1.setFont(new java.awt.Font("Dubai Light", 0, 16)); // NOI18N
        lblDeliveryStatus_1.setText("Delivery Status:");

        deliveryRunnerPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDeliveryName.setFont(new java.awt.Font("Dubai Light", 0, 16)); // NOI18N
        lblDeliveryName.setText("Name:");
        deliveryRunnerPanel.add(lblDeliveryName, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 44, -1, -1));

        lblPhoneNumber.setFont(new java.awt.Font("Dubai Light", 0, 16)); // NOI18N
        lblPhoneNumber.setText("Phone Number:");
        deliveryRunnerPanel.add(lblPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 78, -1, -1));

        lblAverageRating.setFont(new java.awt.Font("Dubai Light", 0, 16)); // NOI18N
        lblAverageRating.setText("Average Rating:");
        deliveryRunnerPanel.add(lblAverageRating, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 112, -1, -1));

        lblDeliveryRunnerInfo.setFont(new java.awt.Font("Dubai Light", 1, 18)); // NOI18N
        lblDeliveryRunnerInfo.setText("Delivery Runner Information:");
        deliveryRunnerPanel.add(lblDeliveryRunnerInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        lblPhone.setFont(new java.awt.Font("Dubai Light", 0, 16)); // NOI18N
        lblPhone.setText("-");
        deliveryRunnerPanel.add(lblPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 78, -1, -1));

        lblName.setFont(new java.awt.Font("Dubai Light", 0, 16)); // NOI18N
        lblName.setText("-");
        deliveryRunnerPanel.add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 44, -1, -1));

        lblRating.setFont(new java.awt.Font("Dubai Light", 0, 16)); // NOI18N
        lblRating.setText("-");
        deliveryRunnerPanel.add(lblRating, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 112, -1, -1));

        lblDeliveryStatus.setFont(new java.awt.Font("Dubai Light", 0, 16)); // NOI18N
        lblDeliveryStatus.setText("-");

        lblServiceType1.setFont(new java.awt.Font("Dubai Light", 0, 16)); // NOI18N
        lblServiceType1.setText("Service Type:");

        lblApologies.setEditable(false);
        lblApologies.setBackground(new java.awt.Color(255, 255, 255));
        lblApologies.setColumns(20);
        lblApologies.setFont(new java.awt.Font("Dubai Light", 0, 14)); // NOI18N
        lblApologies.setLineWrap(true);
        lblApologies.setTabSize(4);
        lblApologies.setText("We sincerely apologise that there are current no available delivery runners to deliver your order.\nYou may cancel the order, or choose another service type below:");
        lblApologies.setWrapStyleWord(true);
        lblApologies.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        scrollRestaurantAddress4.setViewportView(lblApologies);

        cbxService.setFont(new java.awt.Font("Dubai Light", 0, 16)); // NOI18N
        cbxService.setToolTipText("A style of cooking characterized by distinctive ingredients, techniques and dishes, and usually associated with a specific culture or geographic region.");
        cbxService.setMaximumSize(new java.awt.Dimension(105, 25));
        cbxService.setMinimumSize(new java.awt.Dimension(105, 25));
        cbxService.setPreferredSize(new java.awt.Dimension(105, 25));

        btnConfirm.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 18)); // NOI18N
        btnConfirm.setText("Confirm");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout noDeliveryRunnerPanelLayout = new javax.swing.GroupLayout(noDeliveryRunnerPanel);
        noDeliveryRunnerPanel.setLayout(noDeliveryRunnerPanelLayout);
        noDeliveryRunnerPanelLayout.setHorizontalGroup(
            noDeliveryRunnerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(noDeliveryRunnerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(noDeliveryRunnerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(noDeliveryRunnerPanelLayout.createSequentialGroup()
                        .addComponent(lblServiceType1)
                        .addGap(7, 7, 7)
                        .addComponent(cbxService, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(noDeliveryRunnerPanelLayout.createSequentialGroup()
                        .addGroup(noDeliveryRunnerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnConfirm, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(noDeliveryRunnerPanelLayout.createSequentialGroup()
                                .addGap(0, 5, Short.MAX_VALUE)
                                .addComponent(scrollRestaurantAddress4, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12))))
        );
        noDeliveryRunnerPanelLayout.setVerticalGroup(
            noDeliveryRunnerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(noDeliveryRunnerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollRestaurantAddress4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(noDeliveryRunnerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblServiceType1)
                    .addComponent(cbxService, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 26, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout orderStatusPanelLayout = new javax.swing.GroupLayout(orderStatusPanel);
        orderStatusPanel.setLayout(orderStatusPanelLayout);
        orderStatusPanelLayout.setHorizontalGroup(
            orderStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderStatusPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(orderStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(orderStatusPanelLayout.createSequentialGroup()
                        .addGroup(orderStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblOrderStatus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDeliveryStatus_1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(orderStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDeliveryStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(lblOrderStatusDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(orderStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(deliveryRunnerPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(noDeliveryRunnerPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        orderStatusPanelLayout.setVerticalGroup(
            orderStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderStatusPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblOrderStatusDetails)
                .addGap(6, 6, 6)
                .addGroup(orderStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOrderStatus)
                    .addComponent(lblStatus))
                .addGap(6, 6, 6)
                .addGroup(orderStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDeliveryStatus_1)
                    .addComponent(lblDeliveryStatus))
                .addGap(6, 6, 6)
                .addComponent(deliveryRunnerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(noDeliveryRunnerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        currentOrderPanel.add(orderStatusPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(611, 65, 280, 470));

        btnCancel.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 18)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        currentOrderPanel.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 20, 90, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(currentOrderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(currentOrderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        if (order != null) {
            if (order.getOrderStatus().equals("Pending") || noDeliveryRunner == true) {
                if (order.cancelOrder()) {
                    JOptionPane.showMessageDialog(this,"Order cancelled.");
                    displayCurrentOrder(customer);
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

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        order.setOrderDate();
        order.setOrderTime();

        if (cbxService.getSelectedItem().equals("Dine-in")) {
            order.setServiceType("Dine-in");
            order.setOrderStatus("Pending");
        } else if (cbxService.getSelectedItem().equals("Take Away")) {
            order.setServiceType("Take Away");
            order.setOrderStatus(lblStatus.getText()); 
        }
        
        if (order.updateData("Pending Order Details") && deliveryTask.removeData("Pending Delivery Tasks")) {
            JOptionPane.showMessageDialog(this, "Order details updated.");
        } else {
            JOptionPane.showMessageDialog(this, "Unable to update order details. Please try again.");
        }
        displayCurrentOrder(customer);
    }//GEN-LAST:event_btnConfirmActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JComboBox<String> cbxService;
    private javax.swing.JPanel currentOrderPanel;
    private javax.swing.JPanel deliveryRunnerPanel;
    private javax.swing.JPanel itemOrderDetailsPanel;
    private javax.swing.JTextArea lblApologies;
    private javax.swing.JLabel lblAverageRating;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDeliveryAddress;
    private javax.swing.JLabel lblDeliveryCost;
    private javax.swing.JLabel lblDeliveryName;
    private javax.swing.JLabel lblDeliveryRunnerInfo;
    private javax.swing.JLabel lblDeliveryStatus;
    private javax.swing.JLabel lblDeliveryStatus_1;
    private javax.swing.JLabel lblItemOrderDetails;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblOrder;
    private javax.swing.JLabel lblOrderDate;
    private javax.swing.JLabel lblOrderDetails;
    private javax.swing.JLabel lblOrderStatus;
    private javax.swing.JLabel lblOrderStatusDetails;
    private javax.swing.JLabel lblOrderTime;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblPhoneNumber;
    private javax.swing.JLabel lblRating;
    private javax.swing.JLabel lblRestaurantAddress;
    private javax.swing.JLabel lblRestaurantName;
    private javax.swing.JLabel lblService;
    private javax.swing.JLabel lblServiceCost;
    private javax.swing.JLabel lblServiceType;
    private javax.swing.JLabel lblServiceType1;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblTotalCost;
    private javax.swing.JLabel lblTotalPrice;
    private javax.swing.JLabel lblVendorName;
    private javax.swing.JPanel noDeliveryRunnerPanel;
    private javax.swing.JPanel orderDetailsPanel;
    private javax.swing.JPanel orderStatusPanel;
    private javax.swing.JScrollPane scrollRestaurantAddress1;
    private javax.swing.JScrollPane scrollRestaurantAddress2;
    private javax.swing.JScrollPane scrollRestaurantAddress3;
    private javax.swing.JScrollPane scrollRestaurantAddress4;
    private javax.swing.JTextArea txtDeliveryAddress;
    private javax.swing.JTextArea txtItemOrderDetails;
    private javax.swing.JTextArea txtRestaurantAddress;
    // End of variables declaration//GEN-END:variables
}
