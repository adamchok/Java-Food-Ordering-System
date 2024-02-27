package Transaction;

import FileManagement.Data;
import Notification.Notification;
import Order.Order;
import Receipt.OrderReceipt;
import Receipt.Receipt;
import Receipt.TopUpReceipt;
import User.Customer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import Time.Time;
import java.io.Serializable;

public class Transaction extends Data implements Serializable { 
    private static final long serialVersionUID = 9L;
    private final Time clock = new Time();
    
    private String transactionID, transactionType, transactionDate, transactionTime, invoiceNumber, transactionStatus;
    double transactionAmount;
    private Customer customer;
    private Receipt receipt;
    
    //  DEFAULT CONSTRUCTOR  //
    public Transaction() {
    }
    
    //  CONSTRUCTOR FOR GETTING A SPECIFIC TRANSACTION BASED ON ID  //
    public Transaction(String transactionID) {
        this.transactionID = transactionID;
    }
    
    //  CONSTRUCTOR FOR GETTING A LIST OF TRANSACTION BASED ON CUSTOMER  //
    public Transaction(Customer customer) {
        this.customer = customer;
    }
    
    //  CONSTRUCTOR FOR CREATING A NEW TRANSACTION  //
    public Transaction(String transactionID, String transactionType, Customer customer, double transactionAmount, String transactionStatus) {
        this.transactionID = transactionID;
        this.transactionType = transactionType;
        this.customer = customer;
        this.transactionDate =  clock.getDate();
        this.transactionTime = clock.getTime();
        this.transactionAmount = transactionAmount;
        this.invoiceNumber = generateInvoice();
        this.transactionStatus = transactionStatus;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public String getTransactionTime() {
        return transactionTime;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }
    
    public Receipt getReceipt() {
        return receipt;
    }
    
    public Transaction getTransaction() {
        return (Transaction) getObject("Transaction History");
    }
    
    private String generateInvoice() {
        SimpleDateFormat invoiceFormat = new SimpleDateFormat("ddMMyyhhmmss");
        String invoiceNum = invoiceFormat.format(new Date());
        return invoiceNum;
    }
    
    public ArrayList<Transaction> getTransactionHistoryList(boolean isCustomer) {
        ArrayList<Object> objectList = getObjectList("Transaction History");
        ArrayList<Transaction> transactionList = new ArrayList<>();
        
        if (!objectList.isEmpty()) {
            for (Object object : objectList) {
                if (object instanceof Transaction transaction && transaction.getCustomer() != null &&
                        transaction.getCustomer().getId() != null) {
                    if (isCustomer == true) {
                        if (transaction.getCustomer().getId().equals(getCustomer().getId())) {
                            transactionList.add(transaction);
                        }
                    } else {
                        transactionList.add(transaction);
                    }
                }
            }
        }
        return transactionList;
    }
    
    public boolean generateReceipt() {
        if (getTransactionType().equals("Order")) {
            this.receipt = getOrderReceipt();
        } else {
            this.receipt = getTopUpReceipt();
        }
        
        Notification notification = new Notification("Receipt", "Admin", customer.getId(),
                "Receipt for your latest transacton is sent. You may view them at the transaction tab.");
        
        return updateData("Transaction History") && notification.recordData("Notification");
    }
    
    public OrderReceipt getOrderReceipt() {
        Order orders = new Order(getCustomer());
        ArrayList<Order> orderList = orders.getOrderHistoryList();
        Order specificOrder = null;
        if (!orderList.isEmpty()) {
            for (Object object : orderList) {
                if (object instanceof Order order && order.getOrderID() != null) {
                    if (order.getOrderID().equals(getTransactionID())) {
                        specificOrder = order;
                    }
                }
            } 
        }
        OrderReceipt orderReceipt = new OrderReceipt(specificOrder, this);
        return orderReceipt;
    }
    
    public TopUpReceipt getTopUpReceipt() {
        TopUp topUps = new TopUp();
        ArrayList<TopUp> topUpList = topUps.getTopUpList(true);
        TopUp specificTopUp = null;
        if (!topUpList.isEmpty()) {
            for (Object object : topUpList) {
                if (object instanceof TopUp topUp && topUp.getTopUpID() != null) {
                    if (topUp.getTopUpID().equals(getTransactionID())) {
                        specificTopUp = topUp;
                    }
                }
            } 
        }
        TopUpReceipt topUpReceipt = new TopUpReceipt(specificTopUp, this);
        return topUpReceipt;
    }
    
    @Override
    protected Object getObjectImplementation(Object object) {
        if (object instanceof Transaction transaction && transaction.getTransactionID() != null) {
            if (transaction.getTransactionID().equals(getTransactionID())) {
                return transaction;
            }
        }
        return null;
    }
    
    @Override
    protected Object updateDataImplementation(Object object) {
        if (object instanceof Transaction transaction && transaction.getTransactionID() != null) {
            if (transaction.getTransactionID().equals(getTransactionID())) {
                return this;
            } else {
                return transaction;
            }
        }
        return null;
    }
    
    @Override
    protected Object removeDataImplementation(Object object) {
        return object; // DO NOTHING
    }
    
}
