package Order;

import FileManagement.Data;
import Notification.Notification;
import Time.Time;
import User.DeliveryRunner;
import java.io.Serializable;
import java.util.ArrayList;


public class DeliveryTask extends Data implements Serializable {
    private static final long serialVersionUID = 15L;
    private final Time clock = new Time();
    
    private String deliveryID, deliveryStatus, deliveryDate, deliveryTime;
    double deliveryCost;
    private Order order;
    private DeliveryRunner deliveryRunner;
    
    //  DEFAULT CONSTRUCTOR  //
    public DeliveryTask() {
    }
    
    //  CONSTRUCTOR TO GET CURRENT DELIVERY TASK OR DELETE ALL TASK  //
    public DeliveryTask(DeliveryRunner deliveryRunner) {
        this.deliveryRunner = deliveryRunner;
    }
    
    //  CONSTRUCTOR TO GET DELIVERY TASK OBJECT  //
    public DeliveryTask(String deliveryID) {
        this.deliveryID = deliveryID;
    }
    
    //  CONSTRUCTOR TO CREATE NEW DELIVERY TASK  //
    public DeliveryTask(Order order) {
        this.order = order;
        this.deliveryRunner = assignDeliveryRunner(false);
        this.deliveryID = generateTaskID(false);
        if (deliveryRunner == null) {
            this.deliveryStatus = "No Delivery Runner";
        } else {
            this.deliveryStatus = "Pending";
        }
        
        this.deliveryCost = order.getOrderCost() - order.getFoodCart().getTotalCost();
    }

    public String getDeliveryID() {
        return deliveryID;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
    
    public String getDeliveryDate() {
        return deliveryDate;
    }
    
    public String getDeliveryTime() {
        return deliveryTime;
    }

    public DeliveryRunner getDeliveryRunner() {
        return deliveryRunner;
    }

    public void setDeliveryRunner(DeliveryRunner deliveryRunner) {
        this.deliveryRunner = deliveryRunner;
    }

    public double getDeliveryCost() {
        return deliveryCost;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
    
    public DeliveryTask getDeliveryTask(boolean isHistory) {
        String file = isHistory ? "Delivery History" : "Pending Delivery Tasks";
        return (DeliveryTask) getObject(file);
    }
    
    public final DeliveryRunner assignDeliveryRunner(boolean isRejection) {
        ArrayList<DeliveryTask> currentDeliveryTaskList = new ArrayList<>();
        ArrayList<DeliveryRunner> allRunners = new ArrayList<>();
        
        DeliveryRunner deliveryRunners = new DeliveryRunner();
        
        for (Object object : deliveryRunners.getObjectList("Delivery Runner")) {
            if (object instanceof DeliveryRunner runner && runner.getId() != null) {
                allRunners.add(runner);
            }
        }
        
        for (Object object : getObjectList("Pending Delivery Tasks")) {
            if (object instanceof DeliveryTask task && task.getDeliveryID() != null) {
                currentDeliveryTaskList.add(task);
            }
        }
        
        DeliveryRunner selectedRunner = null;
        boolean matched = false;
        outerLoop:
        for (DeliveryRunner runner : allRunners) {
            boolean isRunnerAvailable = true;
            
            
            for (DeliveryTask task : currentDeliveryTaskList) {
                if (isRejection == false) {
                    if (task.getDeliveryRunner() != null && (task.getDeliveryRunner().getId().equals(runner.getId()))) {
                       isRunnerAvailable = false;
                       break;
                    }
                } else {
                    if (matched == false) {
                        if (runner.getId().equals(getDeliveryRunner().getId())) {
                            matched = true;
                        }
                        continue outerLoop;
                    } else {
                        if (task.getDeliveryRunner().getId().equals(runner.getId())) {
                            isRunnerAvailable = false;
                            break;
                        }
                    }
                }
            }
            
            if (isRunnerAvailable) {
                selectedRunner = runner;
                break;
            }
        }
        return selectedRunner;
    }
    
    
    private String generateTaskID(boolean isHistory) {
        String file = isHistory ? "Delivery History" : "Pending Delivery Tasks";
        ArrayList<Object> tasks = super.getObjectList(file);
        int largestId = 0;
        
        if (tasks.isEmpty() == false) {
            for (Object object : tasks) {
                if (object instanceof DeliveryTask task) {
                    String id = task.getDeliveryID();
                    int idNum = Integer.parseInt(id.split("-")[1]);
                    if (idNum > largestId) {
                        largestId = idNum;
                    }
                }
            } 
        }
        return (isHistory ? "DT-" : "PD-") + (largestId + 1);
    }
    
    public ArrayList<DeliveryTask> getDeliveryHistory() {
        ArrayList<Object> objectList = super.getObjectList("Delivery History");
        ArrayList<DeliveryTask> deliveryHistoryList = new ArrayList<>();
        
        for (Object object : objectList) {
            if (object instanceof DeliveryTask task && getDeliveryRunner() != null) {
                if (task.getDeliveryRunner().getId().equals(getDeliveryRunner().getId())) {
                    deliveryHistoryList.add(task);
                }
            }
        }
        return deliveryHistoryList;
    }
    
    public boolean acceptTask() {
        setDeliveryStatus("Waiting for pick-up");
        
        Notification notification = new Notification("Order", getDeliveryRunner().getId(),
                getOrder().getCustomer().getId(),
                getDeliveryRunner().getId()+" has accepted Order: "+getOrder().getOrderID());
        
        return notification.sendNotification() && updateData("Pending Delivery Tasks");
    }
    
    public boolean rejectTask() {
        Notification notification = new Notification("Order", getDeliveryRunner().getId(),
                getOrder().getCustomer().getId(),
                getDeliveryRunner().getId()+" has rejected Order: "+getOrder().getOrderID()+
                        ". View delivery task details in 'Current Order' at 'Orders.'");
        
        setDeliveryRunner(assignDeliveryRunner(true));
        if (getDeliveryRunner() == null) {
            setDeliveryStatus("No Delivery Runner");
        }
        return notification.sendNotification() && updateData("Pending Delivery Tasks");
    }
    
    public boolean deliveryOrder() {
        setDeliveryStatus("Delivering");
        
        return getOrder().deliverOrder() && updateData("Pending Delivery Tasks");
    }
    
    public boolean completeTask() {
        removeData("Pending Delivery Tasks");
        setDeliveryStatus("Completed");
        deliveryID = generateTaskID(true);
        deliveryDate = clock.getDate();
        deliveryTime = clock.getTime();
        
        return getOrder().completeOrder() && recordData("Delivery History");
    }
    
    public boolean deleteAllTasks() {
        return removeData("Pending Delivery Tasks") && removeData("Delivery History");
    }
    
    @Override
    public Object getObjectImplementation(Object object) {
        if (object instanceof DeliveryTask task && task.getDeliveryID() != null) {
            if (getOrder() != null) {
                if (task.getOrder().getOrderID().equals(getOrder().getOrderID())) {
                    return task;
                }
            } else if (getDeliveryID() != null) {
                if (task.getDeliveryID().equals(getDeliveryID())) {
                    return task;
                }
            } else if (getDeliveryRunner() != null) {
                try {
                    if (task.getDeliveryRunner().getId().equals(getDeliveryRunner().getId())) {
                        return task;
                    }
                } catch (NullPointerException e) {
                    return null;
                }
            }
        }
        return null;
    }
    
    // update delivery status in pending delivery task
    @Override
    public Object updateDataImplementation(Object object) {
        if (object instanceof DeliveryTask task && task.getDeliveryID() != null) {
            if (task.getDeliveryID().equals(getDeliveryID())) {
                return this;
            } else {
                return task;
            }
        }
        return null;
    }
    
    // remove pending delivery task from pending delivery task
    @Override
    public Object removeDataImplementation(Object object) {
        if (object instanceof DeliveryTask task && task.getDeliveryID() != null) {
            try {
                if (getDeliveryID() != null && !task.getDeliveryID().equals(getDeliveryID())) {
                    return task;
                }
            } catch (NullPointerException a) {
                try {
                    if (!task.getDeliveryRunner().getId().equals(getDeliveryRunner().getId())) {
                        return task;
                    }
                } catch (NullPointerException b) {
                    try {
                        if (!task.getOrder().getOrderID().equals(getOrder().getOrderID())) {
                            return task;
                        }
                    } catch (NullPointerException c) {
                        
                    }
                }
            }
        }
        return null;
    }
}
