package Transaction;

import FileManagement.Data;
import Notification.Notification;
import Time.Time;
import User.Customer;
import java.io.Serializable;
import java.util.ArrayList;

public class TopUp extends Data implements Serializable {
    private static final long serialVersionUID = 8L;
    
    private String topUpID, topUpDate, topUpTime, topUpStatus;
    private double topUpAmount;
    private Customer customer;
    
    //  DEFAULT CONSTRUCTOR  //
    public TopUp() {
    }
    
    //  CONSTRUCTOR FOR GETING A SPECIFIC TOP-UP OBJECT or TOP-UP LIST  //
    public TopUp (Customer customer) {
        this.customer = customer;
    }
    
    //  CONSTRUCTOR FOR CREATING A NEW TOP UP  //
    public TopUp(Customer customer, double topUpAmount) {
        Time clock = new Time();
        this.customer = customer;
        this.topUpAmount = topUpAmount;
        this.topUpDate = clock.getDate();
        this.topUpTime = clock.getTime();
        this.topUpStatus = "Pending";
    }

    public String getTopUpID() {
        return topUpID;
    }

    public void setTopUpID(String topUpID) {
        this.topUpID = topUpID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getTopUpAmount() {
        return topUpAmount;
    }

    public String getTopUpDate() {
        return topUpDate;
    }

    public String getTopUpTime() {
        return topUpTime;
    }

    public String getTopUpStatus() {
        return topUpStatus;
    }
    
    public TopUp getTopUp(boolean isHistory) {
        String file = isHistory ? "Top-up History" : "Pending Top-up";
        return (TopUp) getObject(file);
    }
    
    private String generateTopUpID() {
        ArrayList<TopUp> topUpList = getTopUpList(true);
        int largestId = 0;
        
        if (topUpList.isEmpty() == false) {
            for (TopUp topUp : topUpList) {
                String id = topUp.getTopUpID();
                int idNum = Integer.parseInt(id.split("-")[1]);
                if (idNum > largestId) {
                    largestId = idNum;
                }
            } 
        }
        return "TP-"+String.valueOf(largestId + 1);
    }
    
    public ArrayList<TopUp> getTopUpList(boolean isHistory) {
        ArrayList<Object> objectList;
        if (isHistory == true) {
            objectList = getObjectList("Top-up History");
        } else {
            objectList = getObjectList("Pending Top-up");
        }
        ArrayList<TopUp> topUpList = new ArrayList<>();
        
        if (!objectList.isEmpty()) {
            for (Object object : objectList) {
                if (object instanceof TopUp topUp && topUp.getCustomer() != null) {
                    topUpList.add(topUp);
                }
            }
        }
        return topUpList;
    }
    
    public boolean requestTopUp() {
        return recordData("Pending Top-up");
    }
    
    public boolean approveTopUp() {
        getCustomer().getCustomerWallet().depositCredit(getTopUpAmount());
        
        removeData("Pending Top-up");
        topUpStatus = "Approved";
        setTopUpID(generateTopUpID());
        
        Transaction topUpTransaction = new Transaction(getTopUpID(), "Top-up",
                getCustomer(), getTopUpAmount(), "Successful");
        
        Notification topUpNotification = new Notification("Top-up", "Admin", getCustomer().getId(),
                "RM "+String.format("%.2f", getTopUpAmount())+" ("+getTopUpID()+") successfully topped up.");
        
        return recordData("Top-up History") && topUpNotification.sendNotification() && topUpTransaction.recordData("Transaction History") &&
                getCustomer().updateUser();
    }
    
    public boolean rejectTopUp() {
        removeData("Pending Top-up");
        topUpStatus = "Rejected";
        setTopUpID(generateTopUpID());
        
        Transaction topUpTransaction = new Transaction(getTopUpID(), "Top-up",
                getCustomer(), getTopUpAmount(), "Unsuccessful");
        
        Notification topUpNotification = new Notification("Top-up", "Admin", getCustomer().getId(),
                "RM "+String.format("%.2f", getTopUpAmount())+" ("+getTopUpID()+") unsuccessful top-up");
        
        return recordData("Top-up History") && topUpTransaction.recordData("Transaction History") && topUpNotification.sendNotification();
    }
    
    @Override
    protected Object getObjectImplementation(Object object) {
        if (object instanceof TopUp topUp) {
            try {
                if (topUp.getCustomer().getId().equals(getCustomer().getId())) {
                    return topUp;
                } 
            } catch (NullPointerException a) {
                try {
                    if (topUp.getTopUpID().equals(getTopUpID())) {
                        return topUp;
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
        return object; // DO NOTHING
    }

    @Override
    protected Object removeDataImplementation(Object object) {
        if (object instanceof TopUp topUp && topUp.getCustomer() != null && topUp.getCustomer().getId() != null) {
            if (!topUp.getCustomer().getId().equals(getCustomer().getId())) {
                return topUp;
            }
        }
        return null;
    }
}
