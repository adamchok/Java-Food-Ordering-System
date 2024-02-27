package User;

import java.io.Serializable;
import java.util.ArrayList;


public class Admin extends User implements Serializable {
    private static final long serialVersionUID = 2L;
    
    private String gender;
    
    //  DEFAULT CONSTRUCTOR  //
    public Admin() { 
    }
    
    //  CONSTRUCTOR FOR REGISTERING NEW CUSTOMER  //
    public Admin(String name, String emailAddress, String phoneNumber, String gender, String password) {
        super(name, emailAddress, phoneNumber);
        this.gender = gender;
        getUserLogin().setPassword(password);
        getUserLogin().setUserType("Admin");
    }
    
    //  CONSTRUCTOR FOR LOGIN  //
    public Admin(String id) {
        super(id);
    }
    
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    @Override
    public Admin getUser(boolean isPending) {
        return null;  // DO NOTHING 
    }
    
    public Admin getAdmin() {
        return (Admin) getObject("Admin");
    }
    
    @Override
    protected Object getObjectImplementation(Object object) {
        if (object instanceof Admin admin && admin.getId() != null) {
            if (admin.getId().equals(getId())) {
                return admin;
            }
        }
        return null;
    }
    
    @Override
    protected Object updateDataImplementation(Object object) { 
        if (object instanceof Admin admin && admin.getId() != null) {
            if (admin.getId().equals(getId())) {
                return this;
            } else {
                return admin;
            }
        }
        return null;
    }
    
    @Override
    protected Object removeDataImplementation(Object object) {
        return object; // DO NOTHING
    }
}
