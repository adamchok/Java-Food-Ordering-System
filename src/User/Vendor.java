package User;

import java.io.Serializable;
import java.util.ArrayList;

public class Vendor extends User implements Serializable {
    private static final long serialVersionUID = 4L;
    
    private String cuisine, services, location, restaurantAddress;
    
    //  DEFAULT CONSTRUCTOR  //
    public Vendor() {
    }
    
    //  CONSTRUCTOR FOR LOGIN  //
    public Vendor(String id) {
        super(id);
    }
    
    //  CONSTRUCTOR FOR REGISTERING VENDOR   //
    public Vendor(String name, String emailAddress, String phoneNumber, String password, 
            String cuisine, String services, String location, String restaurantAddress) {
        
        super(name, emailAddress, phoneNumber);
        this.cuisine = cuisine;
        this.services = services;
        this.location = location;
        this.restaurantAddress = restaurantAddress;
        getUserLogin().setPassword(password);
        getUserLogin().setUserType("Vendor");
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }
    
    @Override
    public Vendor getUser(boolean isPending) {
        String file = isPending ? getPendingUsersFile() : "Vendor";
        return (Vendor) getObject(file);
    }
    
    public ArrayList<Vendor> getVendorList(boolean isPending) {
        String file = isPending ? getPendingUsersFile() : "Vendor";
        ArrayList<User> userList = getUserList(file);
        ArrayList<Vendor> vendorList = new ArrayList<>();
       
        if (!userList.isEmpty()) {
            for (User user : userList) {
                if (user instanceof Vendor vendor && vendor.getId() != null) {
                    vendorList.add(vendor);
                }
            }
        }
        return vendorList;
    }
    
    public final String generateVendorID() {
        ArrayList<Vendor> vendorList = getVendorList(false);
        int largestId = 0;
        
        if (!vendorList.isEmpty()) {
            for (Vendor vendor : vendorList) {
                String id = vendor.getId();
                int idNum = Integer.parseInt(id.substring(1));
                if (idNum > largestId) {
                    largestId = idNum;
                }
            } 
        }
        return "V"+String.valueOf(largestId + 1);
    }
    
    
    @Override
    protected Object getObjectImplementation(Object object) {
        if (object instanceof Vendor vendor) {
            if (vendor.getId().equals(getId())) {
                return vendor;
            }
        }
        return null;
    }
    
    @Override
    protected Object updateDataImplementation(Object object) { 
        if (object instanceof Vendor vendor) {
            if (vendor.getId().equals(getId())) {
                // Return this object to vendor details
                return this;
            } else {
                return vendor;
            }
        }
        return null;
    }

    @Override
    protected Object removeDataImplementation(Object object) {
        if (object instanceof Vendor vendor) {
            if (!vendor.getId().equals(getId())) {
                return vendor;
            }
        }
        return null;
    }
    
}
