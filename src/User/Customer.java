package User;

import Transaction.Wallet;
import java.io.Serializable;
import java.util.ArrayList;

public class Customer extends User implements Serializable {
    private static final long serialVersionUID = 3L;
    
    private String gender;
    private Wallet customerWallet;

    //  DEFAULT CONSTRUCTOR  //
    public Customer() {      
    }
    
    //  CONSTRUCTOR FOR LOGIN  //
    public Customer(String id) {
        super(id);
    }
    
    //  CONSTRUCTOR FOR REGISTERING NEW CUSTOMER  //
    public Customer(String name, String emailAddress, String phoneNumber, String gender, String password) {
        super(name, emailAddress, phoneNumber);
        this.gender = gender;
        getUserLogin().setPassword(password);
        getUserLogin().setUserType("Customer");
    }
    
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Wallet getCustomerWallet() {
        return customerWallet;
    }
    
    public void setCustomerWallet(Wallet customerWallet) {
        this.customerWallet = customerWallet;
    }
    
    @Override
    public Customer getUser(boolean isPending) {
        String file = isPending ? getPendingUsersFile() : "Customer";
        return (Customer) getObject(file);
    }
    
    //  GET A LIST OF REGISTERED OR PENDING CUSTOMERS  //
    public ArrayList<Customer> getCustomerList(boolean isPending) {
        String file = isPending ? getPendingUsersFile() : "Customer";
        ArrayList<User> userList = getUserList(file);
        ArrayList<Customer> customerList = new ArrayList<>();
       
        if (!userList.isEmpty()) {
            for (User user : userList) {
                if (user instanceof Customer customer && customer.getId() != null) {
                    customerList.add(customer);
                }
            }
        }
        return customerList;
    }
    
    //  GENERATES NEW CUSTOMER ID TO REGISTER CUSTOMER  //
    public final String generateCustomerID() {
        ArrayList<Customer> customerList = getCustomerList(false);
        int largestId = 0;
        
        if (!customerList.isEmpty()) {
            for (Customer customer : customerList) {
                String id = customer.getId();
                int idNum = Integer.parseInt(id.substring(1));
                if (idNum > largestId) {
                    largestId = idNum;
                }
            } 
        }
        return "C"+String.valueOf(largestId + 1);
    }
    
    @Override
    protected Object getObjectImplementation(Object object) {
        if (object instanceof Customer customer && customer.getId() != null) {
            if (customer.getId().equals(getId())) {
                return customer;
            }
        }
        return null;
    }
  
    @Override
    protected Object updateDataImplementation(Object object) { 
        if (object instanceof Customer customer && customer.getId() != null) {
            if (customer.getId().equals(getId())) {
                return this;
            } else {
                return customer;
            }
        }
        return null;
    }

    @Override
    protected Object removeDataImplementation(Object object) {
        if (object instanceof Customer customer && customer.getId() != null) {
            if (!customer.getId().equals(getId())) {
                return customer;
            }
        }
        return null;
    }
    
}
