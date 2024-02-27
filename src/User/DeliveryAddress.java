package User;

import FileManagement.Data;
import java.io.Serializable;
import java.util.ArrayList;

public class DeliveryAddress extends Data implements Serializable {
    private static final long serialVersionUID = 6L;
    
    private String addressID, title, address;
    private Customer customer;
    
    //  DEFAULT  CONSTRUCTOR  //
    public DeliveryAddress() {
    }

    //  CONSTRUCTOR TO GET DELIVERY ADDRESS LIST  //
    public DeliveryAddress(Customer customer) {
        this.customer = customer;
    }
    
    //  CONSTRUCTOR TO GET DELIVERY ADDRESS OBJECT  //
    public DeliveryAddress(String addressID) {
        this.addressID = addressID;
    }
    
    // CREATE NEW DELIVERY ADDRESS  //
    public DeliveryAddress(Customer customer, String title, String address) {
        this.addressID = generateAddressID();
        this.customer = customer;
        this.title = title;
        this.address = address;
    }

    public String getAddressID() {
        return addressID;
    }

    public void setAddressID(String addressID) {
        this.addressID = addressID;
    }
    
    public Customer getCustomer() {
        return customer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    private String generateAddressID() {
        ArrayList<DeliveryAddress> deliveryAddressList = getDeliveryAddressList(true);
        int largestId = 0;
        
        if (!deliveryAddressList.isEmpty()) {
            for (DeliveryAddress deliveryAddress : deliveryAddressList) {
                String id = deliveryAddress.getAddressID();
                int idNum = Integer.parseInt(id.split("-")[1]);
                if (idNum > largestId) {
                    largestId = idNum;
                }
            } 
        }
        return "DA-"+String.valueOf(largestId + 1);
    }
    
    public ArrayList<DeliveryAddress> getDeliveryAddressList(boolean isAll) {
        ArrayList<Object> objectList = getObjectList("Customer Delivery Addresses");
        ArrayList<DeliveryAddress> deliveryAddressList = new ArrayList<>();
        
        if (!objectList.isEmpty()) {
            for (Object object : objectList) {
                if (object instanceof DeliveryAddress deliveryAddress && deliveryAddress.getCustomer() != null) {
                    if (isAll == false) {
                        if (deliveryAddress.getCustomer().getId().equals(getCustomer().getId())) {
                            deliveryAddressList.add(deliveryAddress);
                        }
                    } else {
                        deliveryAddressList.add(deliveryAddress);
                    }
                    
                }
            }
        }
        return deliveryAddressList;
    }
    
    public DeliveryAddress getDeliveryAddress() {
        return (DeliveryAddress) getObject("Customer Delivery Addresses");
    }
    
    public boolean addDeliveryAddress() {
        return recordData("Customer Delivery Addresses");
    }
    
    public boolean updateDeliveryAddress() {
        return updateData("Customer Delivery Addresses");
    }
    
    public boolean removeDeliveryAddress () {
        return removeData("Customer Delivery Addresses");
    }
    
    @Override
    public Object getObjectImplementation(Object object) {
        if (object instanceof DeliveryAddress deliveryAddress && deliveryAddress.getAddressID() != null) {
            if (deliveryAddress.getAddressID().equals(getAddressID())) {
                return deliveryAddress;
            }
        }
        return null;
    }

    @Override
    protected Object updateDataImplementation(Object object) {
        if (object instanceof DeliveryAddress deliveryAddress && deliveryAddress.getAddressID() != null) {
            if (deliveryAddress.getAddressID().equals(getAddressID())) {
                return this;
            } else {
                return deliveryAddress;
            }
        }
        return null;
    }
    
    @Override
    protected Object removeDataImplementation(Object object) {
        if (object instanceof DeliveryAddress deliveryAddress && deliveryAddress.getAddressID() != null) {
            if (!deliveryAddress.getAddressID().equals(getAddressID())) {
                return deliveryAddress;
            }
        }
        return null;
    }
}
