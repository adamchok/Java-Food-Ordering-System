package Order;

import Time.Time;
import FileManagement.Data;
import Notification.Notification;
import Transaction.Transaction;
import User.Customer;
import User.Vendor;
import java.io.Serializable;
import java.util.ArrayList;

public class Order extends Data implements Serializable {
    private static final long serialVersionUID = 16L;
    private final Time clock = new Time();
    
    private String orderID, orderStatus, deliveryAddress, serviceType, orderDate, orderTime;
    private Foodcart foodCart;
    private double orderCost;
    
    private Customer customer;
    private Vendor vendor;
    
    //  DEFAULT CONSTRUCTOR  //
    public Order() {
    }
    
    //  CONSTRUCTOR FOR CUSTOMER  //
    public Order(Customer customer) {
        this.customer = customer;
    }
    
    //  CONSTRUCTOR FOR VENDOR  //
    public Order(Vendor vendor) {
        this.vendor = vendor;
    }
    
    //  CONSTRUCTOR FOR GETTING A SPECIFIC ORDER OBJECT BASED ON ORDER ID  //
    public Order (String orderID) {
        this.orderID = orderID;
    }
    
    //  CREATE NEW DELIVERY ORDER  //
    public Order(Foodcart foodCart, double orderCost, Vendor vendor, String deliveryAddress, String serviceType, Customer customer) {
        this.orderID = generateOrderID(false);
        this.orderStatus = "Pending";
        this.foodCart = foodCart;
        this.orderCost = orderCost;
        this.vendor = vendor;
        this.deliveryAddress = deliveryAddress;
        this.serviceType = serviceType;
        this.customer = customer;
        setOrderDate();
        setOrderTime();
    }
    
    //  CREATE NEW DINE-IN OR TAKE-AWAY ORDER  //
    public Order (Foodcart foodCart,double orderCost, Vendor vendor, String serviceType, Customer customer) {
        this.orderID = generateOrderID(false);
        this.orderStatus = "Pending";
        this.foodCart = foodCart;
        this.orderCost = orderCost;
        this.vendor = vendor;
        this.serviceType = serviceType;
        this.customer = customer;
        setOrderDate();
        setOrderTime();
    }

    public String getOrderID() {
        return orderID;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public Foodcart getFoodCart() {
        return foodCart;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Vendor getVendor() {
        return vendor;
    }
    
    public String getOrderDate() {
        return orderDate;
    }
    
    public final void setOrderDate() {
        orderDate = clock.getDate();
    }
    
    public String getOrderTime() {
        return orderTime;
    }
    
    public final void setOrderTime() {
        orderTime = clock.getTime();
    }

    public double getOrderCost() {
        return orderCost;
    }
    
    private String generateOrderID(boolean isHistory) {
        String file = isHistory ? "Order History" : "Pending Order Details";
        ArrayList<Object> orders = super.getObjectList(file);
        int largestId = 0;
        
        if (orders.isEmpty() == false) {
            for (Object object : orders) {
                if (object instanceof Order order) {
                    String id = order.getOrderID();
                    int idNum = Integer.parseInt(id.split("-")[1]);
                    if (idNum > largestId) {
                        largestId = idNum;
                    }
                }
            } 
        }
        return (isHistory ? "OD-" : "PO-") + (largestId + 1);
    }
    
    //  FOR CUSTOMERS AND VENDORS  //
    public ArrayList<Order> getOrderHistoryList() {
        ArrayList<Object> objectList = getObjectList("Order History");
        ArrayList<Order> orderHistoryList = new ArrayList<>();
        
        for (Object object : objectList) {
            if (object instanceof Order order) {
                try {
                    if (order.getVendor().getId().equals(getVendor().getId())) {
                        orderHistoryList.add(order);
                    } 
                } catch (NullPointerException a) {
                    try {
                        if (order.getCustomer().getId().equals(getCustomer().getId())) {
                            orderHistoryList.add(order);
                        }
                    } catch (NullPointerException b) {
                    }
                }
            }
        }
        return orderHistoryList;
    }
    
    //  FOR CUSTOMER  //
    public ArrayList<Order> getPendingOrderList(boolean isDineIn) {
        ArrayList<Object> objectList = getObjectList("Pending Order Details");
        ArrayList<Order> pendingOrderList = new ArrayList<>();
       
        for (Object object : objectList) {
            if (object instanceof Order order && order.getServiceType() != null && order.getCustomer() != null) {
                if (isDineIn == true) {
                    if (order.getServiceType().equals("Dine-in") && order.getCustomer().getId().equals(getCustomer().getId())) {
                       pendingOrderList.add(order);
                    }
                } else {
                    if (!order.getServiceType().equals("Dine-in") && order.getCustomer().getId().equals(getCustomer().getId())) {
                       pendingOrderList.add(order); 
                    } 
                }
            }
        }
        return pendingOrderList;
    }
    
    //  FOR VENDOR  //
    public ArrayList<Order> getPendingOrderList() {
        ArrayList<Object> objectList = getObjectList("Pending Order Details");
        ArrayList<Order> pendingOrderList = new ArrayList<>();
       
        for (Object object : objectList) {
            if (object instanceof Order order && order.getVendor() != null) {
                if (order.getVendor().getId().equals(getVendor().getId())) {
                    pendingOrderList.add(order);
                }
            }
        }
        return pendingOrderList;
    }
    
    public Order getOrder(boolean isHistory) {
        String file = isHistory ? "Order History" : "Pending Order Details";
        return (Order) getObject(file);
    }
    
    public boolean placeOrder() {
        Notification vendorNotification = new Notification("Pending Order", getCustomer().getId(), getVendor().getId(),
            "New order placed - Pending Order: " + getOrderID() + ". Please accept or reject the order in 'Pending Order' tab.");
        
        Notification customerNotification = new Notification("Pending Order", getVendor().getId(), getCustomer().getId(),
            "New "+ getServiceType() +" order placed - Pending Order: " + getOrderID() + ". Please view your order in the 'Orders' tab.");
        
        return vendorNotification.sendNotification() && customerNotification.sendNotification() && recordData("Pending Order Details");
    }
    
    public boolean acceptOrder() {
        if (getServiceType().equals("Delivery")) {
            DeliveryTask newDeliveryTask = new DeliveryTask(this);
            newDeliveryTask.recordData("Pending Delivery Tasks");
            
            if (newDeliveryTask.getDeliveryRunner() != null) {
                Notification deliveryRunnerNotification = new Notification("Pending Task",
                        getVendor().getId(), newDeliveryTask.getDeliveryRunner().getId(),
                    "A new delivery task has been assigned to you. View the pending task in 'Task' tab.");
                deliveryRunnerNotification.sendNotification();
            }
        }
        setOrderStatus("Preparing");
        
        Notification vendorNotification;
        
        if (getServiceType().equals("Dine-in")) {
            vendorNotification = new Notification("Dine-in Order", getVendor().getId(), getCustomer().getId(),
                "Dine-in Order: " + getOrderID()+" has been accepted. View accepted order in 'Dine-in Order' at the 'Orders' tab.");
        } else {
            vendorNotification = new Notification("Order", getVendor().getId(), getCustomer().getId(),
                "Order: " + getOrderID()+" has been accepted. View accepted order in 'Current Order' at the 'Orders' tab.");
        }
        
        return vendorNotification.sendNotification() && updateData("Pending Order Details");
    }
    
    public boolean deliverOrder() {
        setOrderStatus("Delivering");
        
        Notification notification = new Notification("Order", getVendor().getId(), getCustomer().getId(),
            "Order: "+getOrderID()+" is delivering! View delivering order in 'Current Order' at 'Orders.'");
        
        return notification.recordData("Notification") && updateData("Pending Order Details");
    }
    
    public boolean rejectOrder() {
        removeData("Pending Order Details");
        
        Notification notification = new Notification("Rejected Order", getVendor().getId(), getCustomer().getId(),
                "Order: "+getOrderID()+" has been rejected. You may place another order.");
        
        orderID = generateOrderID(true);
        setOrderStatus("Rejected");
        
        return notification.recordData("Notification")  && recordData("Order History");
    }
    
    public boolean completeOrder() {
        removeData("Pending Order Details");
        orderID = generateOrderID(true);
        setOrderStatus("Completed");
        
        getCustomer().getCustomerWallet().withdrawCredit(getOrderCost());
        getCustomer().updateUser();
        
        Transaction transaction = new Transaction(getOrderID(), "Order", getCustomer(),
                getOrderCost(), "Successful");
        transaction.recordData("Transaction History");
        
        Notification notification = new Notification("Order", getVendor().getId(), getCustomer().getId(),
                "Order: "+getOrderID()+" is completed. RM " + getOrderCost() + " has been deducted from your wallet. Thank you.");
        
        return notification.recordData("Notification") && recordData("Order History");
    }
    
    public boolean notifyDeliveryRunner() {
        setOrderStatus("Pending pick-up");
        
        DeliveryTask task = new DeliveryTask();
        task.setOrder(this);
        task = (DeliveryTask) task.getDeliveryTask(false);
        
        if (task.getDeliveryRunner() != null) {
            Notification runnerNotification = new Notification("Order",
                    getVendor().getId(), task.getDeliveryRunner().getId(),
                "Delivery: " + task.getDeliveryID() + " order preparation is complete. Please pick up the order to deliver it. Thank you.");
            task.getOrder().setOrderStatus("Preperation Complete");
            task.setDeliveryStatus("Ready for Pick-up");
            task.updateData("Pending Delivery Tasks");
            runnerNotification.recordData("Notification");
        }
        
        Notification customerNotification = new Notification("Order", getVendor().getId(), getCustomer().getId(),
                "Your " + getServiceType() + " order preparation is complete. Pending for delivery.");
                
        return customerNotification.sendNotification() && updateData("Pending Order Details");
    }
    
    public boolean cancelOrder() {
        Notification vendorNotification = new Notification("Cancelled Order", getCustomer().getId(), getVendor().getId(),
                "Order: "+getOrderID()+" has been cancelled.");
        
        Notification customerNotification = new Notification("Cancelled Order", getVendor().getId(), getCustomer().getId(),
                "Order: "+getOrderID()+" has been cancelled.");
        
        if (getServiceType().equals("Delivery")) {
            DeliveryTask task = new DeliveryTask();
            task.setOrder(this);
            task = (DeliveryTask) task.getDeliveryTask(false);
            task.removeData("Pending Delivery Tasks");
        }
        
        removeData("Pending Order Details");
        
        orderID = generateOrderID(true);
        setOrderStatus("Cancelled");
        
        return vendorNotification.sendNotification() && customerNotification.sendNotification() && recordData("Order History");
    }
    
    @Override
    public Object getObjectImplementation(Object object) {
        if (object instanceof Order order) {
            try {
                if (order.getOrderID().equals(getOrderID())) {
                    return order;
                }
            } catch (NullPointerException a) {
                try {
                    if (order.getCustomer().getId().equals(getCustomer().getId())) {
                        return order;
                    }
                } catch (NullPointerException b) {
                    return null;
                }
            }
        }
        return null;
    }
    
    @Override
    protected Object updateDataImplementation(Object object) { 
        if (object instanceof Order order) {
            if (order.getOrderID().equals(getOrderID())) {
                return this;
            } else {
                return order;
            }
        }
        return null;
    }

    @Override
    public Object removeDataImplementation(Object object) {
        if (object instanceof Order order) {
            if (!order.getOrderID().equals(getOrderID())) {
                return order;
            }
        }
        return null;
    }
}
