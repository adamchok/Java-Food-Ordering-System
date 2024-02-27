package Notification;

import FileManagement.Data;
import Time.Time;
import java.io.Serializable;
import java.util.ArrayList;

public class Notification extends Data implements Serializable {
    private static final long serialVersionUID = 18L;
    private final Time clock = new Time();
    
    private String notificationID, notificationType, time, date, senderID, receipientID, message;
    
    //  DEFAULT CONSTRUCTOR  //
    public Notification() {
    }
    
    //  CONSTRUCTOR TO GET ALL NOTIFICATION OR DELETE ALL NOTIFICATION  //
    public Notification(String receipientID) {
        this.receipientID = receipientID;
    }
    
    //  CONSTRUCTOR TO GET A SPECIFIC NOTIFICATION OBJECT  //
    public Notification(String receipientID, String notificationID) {
        this.receipientID = receipientID;
        this.notificationID = notificationID;
    }
    
    //  CONSTRUCTOR TO CREATE NEW NOTIFICATION  //
    public Notification(String notificationType, String senderID, String receipientID, String message) {
        this.notificationID = generateNotificationID();
        this.notificationType = notificationType;
        this.time = clock.getTime();
        this.date = clock.getDate();
        this.senderID = senderID;
        this.receipientID = receipientID;
        this.message = message;
    }

    public String getNotificationID() {
        return notificationID;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    public String getSenderID() {
        return senderID;
    }

    public String getReceipientID() {
        return receipientID;
    }

    public String getMessage() {
        return message;
    }
    
    //  GET A LIST OF NOTIFICATION BASED ON ALL OR SPECIFIC USER  //
    public ArrayList<Notification> getNotificationList(boolean isAll) {
        ArrayList<Object> objectList = super.getObjectList("Notification");
        ArrayList<Notification> notificationList = new ArrayList<>();
        
        if (!objectList.isEmpty()) {
            for (Object object : objectList) {
                if (object instanceof Notification notification) {
                    if (isAll == false) {
                        if (notification.getReceipientID().equals(getReceipientID())) {
                            notificationList.add(notification);
                        }
                    } else {
                        notificationList.add(notification);
                    }
                }
            }
        }
        return notificationList;
    }
    
    //  GENERATE A NOTIFICATION ID  //
    private String generateNotificationID() {
        ArrayList<Notification> notificationList = getNotificationList(true);
        int largestId = 0;
        
        if (!notificationList.isEmpty()) {
            for (Notification notification : notificationList) {
                String id = notification.getNotificationID();
                int idNum = Integer.parseInt(id.split("-")[1]);
                if (idNum > largestId) {
                    largestId = idNum;
                }
            }
        }
        return "N-"+String.valueOf(largestId + 1);
    }
    
    public boolean sendNotification() {
        return recordData("Notification");
    }
    
    //  DELETE ALL NOTIFICATION OF A SPECIFC USER  //
    public boolean deleteAllNotification() {
        boolean noError = true;
        for (Notification notification : getNotificationList(false)) {
            noError = notification.removeData("Notification");
            if (noError == false) {
                break;
            }
        }
        return noError;
    }
    
    //  DELETE A SPECIFC NOTIFICATION  //
    public boolean deleteNotification() {
        return removeData("Notification");
    }
    
    @Override
    public Object getObjectImplementation(Object object) {
        if (object instanceof Notification notification) {
            if (notification.getNotificationID().equals(getNotificationID())) {
                return notification;
            }
        }
        return null;
    }
    
    @Override
    public Object updateDataImplementation(Object object) {
        return object;  //  DO NOTHING
    }
    
    @Override
    public Object removeDataImplementation(Object object) {
        if (object instanceof Notification notification) {
            if (!notification.getNotificationID().equals(getNotificationID())) {
                return notification;
            }
        }
        return null;
    }
    
}
