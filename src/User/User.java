package User;

import FileManagement.Data;
import Frame.UserFrames.*;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class User extends Data implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String PENDING_USERS_FILE = "Pending Users";
    
    private String id, name, phoneNumber, emailAddress;
    private Login userLogin;

    //  DEFAULT CONSTRUCTOR  //
    public User() {
    }
    
    //  CONSTRUCTOR FOR LOGIN  //
    public User(String id) {
        this.id = id;
    }
    
    //  CONSTRUCTOR FOR USER REGISTRATION  //
    public User(String name, String emailAddress, String phoneNumber) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.userLogin = new Login();
        this.id = generatePendingUserID();
    }
    
    protected String getPendingUsersFile() {
        return PENDING_USERS_FILE;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Login getUserLogin() {
        return userLogin;
    }
    
    abstract public User getUser(boolean isPending);
    
    public boolean createUser() {
        return recordData(userLogin.getUserType()) && userLogin.recordData("Login");
    }
    
    public boolean updateUser() {
        return updateData(userLogin.getUserType()) && userLogin.updateData("Login");
    }
    
    public boolean removeUser() {
        return removeData(userLogin.getUserType()) && userLogin.removeData("Login");
    }
    
    public boolean removePendingUser() {
        return removeData(getPendingUsersFile());
    }

    private String generatePendingUserID() {
        ArrayList<User> objectList = getUserList(getPendingUsersFile());
        int largestId = 0;
        
        if (objectList.isEmpty() == false) {
            for (User user : objectList) {
                String id = user.getId();
                int idNum = Integer.parseInt(id.split("-")[1]);
                if (idNum > largestId) {
                    largestId = idNum;
                }
            } 
        }
        return "PU-"+String.valueOf(largestId + 1);
    }
    
    protected ArrayList<User> getUserList(String userType) {
        ArrayList<Object> objectList = getObjectList(userType);
        ArrayList<User> userList = new ArrayList<>();
        if (!objectList.isEmpty()) {
            for (Object object : objectList) {
                if (object instanceof User user) {
                    userList.add(user);
                }
            }
        }
        return userList;
    }
    
    public void login() {        
        switch (getUserLogin().getUserType()) {
            case "Customer" -> {
                CustomerMainPage customerPage = new CustomerMainPage((Customer) this);
                customerPage.setVisible(true);
            }
            case "Vendor" -> {
                VendorMainPage vendorPage = new VendorMainPage((Vendor) this);
                vendorPage.setVisible(true);
            }
            case "Delivery Runner" -> {
                DeliveryRunnerMainPage deliveryRunnerPage = new DeliveryRunnerMainPage((DeliveryRunner) this);
                deliveryRunnerPage.setVisible(true);
            }
            default -> {
                AdminMainPage adminPage = new AdminMainPage((Admin) this);
                adminPage.setVisible(true);
            }
        }
    }
    
    public void updatePassword(String password) {
        getUserLogin().setPassword(password);
    }
}
