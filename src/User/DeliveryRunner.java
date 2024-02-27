package User;

import java.io.Serializable;
import java.util.ArrayList;

public class DeliveryRunner extends User implements Serializable {
    private static final long serialVersionUID = 5L;
    
    private String gender;
    
    //  DEFAULT CONSTRUCTOR //
    public DeliveryRunner() { 
    }
    
    //  CONSTRUCTOR FOR LOGIN   //
    public DeliveryRunner(String id) {
        super(id);
    }
    
    //  CREATE NEW DELIVERY RUNNER  //
    public DeliveryRunner(String name, String emailAddress, String phoneNumber, String gender, String password) {
        super(name, emailAddress, phoneNumber);
        this.gender = gender;
        getUserLogin().setPassword(password);
        getUserLogin().setUserType("Delivery Runner");
    }
    
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;    
    }
    
    @Override
    public DeliveryRunner getUser(boolean isPending) {
        String file = isPending ? getPendingUsersFile() : "Delivery Runner";
        return (DeliveryRunner) getObject(file);
    }
    
    //  GET A LIST OF REGISTERED OR PENDING DELIVERY RUNNERS  //
    public ArrayList<DeliveryRunner> getDeliveryRunnerList(boolean isPending) {
        String file = isPending ? getPendingUsersFile() : "Delivery Runner";
        ArrayList<User> userList = getUserList(file);
        ArrayList<DeliveryRunner> runnerList = new ArrayList<>();
       
        if (!userList.isEmpty()) {
            for (User user : userList) {
                if (user instanceof DeliveryRunner runner && runner.getId() != null) {
                    runnerList.add(runner);
                }
            }
        }
        return runnerList;
    }
    
    public final String generateDeliveryRunnerID() {
        ArrayList<DeliveryRunner> runnerList = getDeliveryRunnerList(false);
        int largestId = 0;
        
        if (runnerList.isEmpty() == false) {
            for (DeliveryRunner runner : runnerList) {
                String runnerID = runner.getId();
                int idNum = Integer.parseInt(runnerID.substring(1));
                if (idNum > largestId) {
                    largestId = idNum;
                }
            } 
        }
        return "D"+String.valueOf(largestId + 1);
    }
    
    @Override
    protected Object getObjectImplementation(Object object) {
        if (object instanceof DeliveryRunner runner) {
            if (runner.getId().equals(getId())) {
                return runner;
            }
        }
        return null;
    }
    
    @Override
    protected Object updateDataImplementation(Object object) { 
        if (object instanceof DeliveryRunner runner) {
            if (runner.getId().equals(getId())) {
                // Update delivery runner details
                return this;
            } else {
                return runner;
            }
        }
        return null;
    }

    @Override
    protected Object removeDataImplementation(Object object) {
        if (object instanceof DeliveryRunner runner) {
            if (!runner.getId().equals(getId())) {
                return runner;
            }
        }
        return null;
    }
    
}
