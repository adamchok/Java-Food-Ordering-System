package User;

import FileManagement.Data;
import java.io.Serializable;
import java.util.ArrayList;

public class Login extends Data implements Serializable {
    private static final long serialVersionUID = 7L;
    
    private String id, password, userType;
    
    // DEFAULT CONSTRUCTOR  //
    public Login() {      
    }
    
    //  CONSTRUCTOR FOR USER LOGIN  //
    public Login(String id, String password) {
        this.id = id;
        this.password = password;
    }
    
    //  CONTRUCTOR FOR CREATING NEW LOGIN FOR A NEW USER  //
    public Login(String id, String password, String userType) {
        this.id = id;
        this.password = password;
        this.userType = userType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
    
    public ArrayList<Login> getLoginList() {
        ArrayList<Object> objectList = super.getObjectList("Login");
        ArrayList<Login> loginList = new ArrayList<>();
        
        if (!objectList.isEmpty()) {
            for (Object object : objectList) {
                if (object instanceof Login login && login.getId() != null) {
                    loginList.add(login);
                }
            }
        }
        return loginList;
        
    }
    
    public String validateLogin() {
        ArrayList<Login> loginList = getLoginList();
        
        if (!loginList.isEmpty()) {
            for (Login login : loginList) {
                if (login.getId().equals(getId()) && login.getPassword().equals(getPassword())) {
                    return login.getUserType();
                }
            }
            return "Incorrect";
        } 
        return "Login Error";
        
    }  
    
    //  GET LOGIN OBJECT BASED ON USER ID  //
    @Override
    protected Object getObjectImplementation(Object object) {
        if (object instanceof Login login && login.getId() != null) {
            if (login.getId().equals(getId())) {
                return login;
            }
        }
        return null;
    }
    
    //  UPDATE LOGIN DETAILS  //
    @Override
    protected Object updateDataImplementation(Object object) { 
        if (object instanceof Login login && login.getId() != null) {
            if (login.getId().equals(getId())) {
                return this;
            } else {
                return login;
            }
        }
        return null;
    }
    
    //  REMOVE LOGIN OBJECT WHEN USER DELETED  //
    @Override
    protected Object removeDataImplementation(Object object) {
        if (object instanceof Login login && login.getId() != null) {
            if (!login.getId().equals(getId())) {
                return login;
            }
        }
        return null;
    }
    
}
