package FileManagement;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public abstract class Data {
    private String fileLocale;    
    
    private final String ADMIN_DETAILS_FILE = "src\\Data\\AdminDetails.dat";
    private final String CUSTOMER_DELIVERY_ADDRESSES_FILE = "src\\Data\\CustomerDeliveryAddresses.dat";
    private final String CUSTOMER_DETAILS_FILE = "src\\Data\\CustomerDetails.dat";
    private final String DELIVERY_HISTORY_FILE = "src\\Data\\DeliveryHistory.dat";
    private final String DELIVERY_RUNNER_DETAILS_FILE = "src\\Data\\DeliveryRunnerDetails.dat";
    private final String DELIVERY_RUNNER_REVIEWS = "src\\Data\\DeliveryRunnerReviews.dat";
    private final String ITEM_DETAILS_FILE = "src\\Data\\ItemDetails.dat";
    private final String LOGIN_DETAILS_FILE = "src\\Data\\LoginDetails.dat";
    private final String NOTIFICATION_FILE = "src\\Data\\Notification.dat";
    private final String ORDER_HISTORY_FILE = "src\\Data\\OrderHistory.dat";
    private final String PENDING_DELIVERY_TASKS_FILE = "src\\Data\\PendingDeliveryTasks.dat";
    private final String PENDING_ORDER_DETAILS_FILE = "src\\Data\\PendingOrderDetails.dat";
    private final String PENDING_TOP_UP_FILE = "src\\Data\\PendingTop-up.dat";
    private final String PENDING_USERS_FILE = "src\\Data\\PendingUsers.dat";
    private final String TOP_UP_HISTORY_FILE = "src\\Data\\Top-upHistory.dat";
    private final String TRANSACTION_HISTORY_FILE = "src\\Data\\TransactionHistory.dat";
    private final String VENDOR_DETAILS_FILE = "src\\Data\\VendorDetails.dat";
    private final String VENDOR_REVIEWS_FILE = "src\\Data\\VendorReviews.dat";

    private File setFile(String fileType) {
        fileLocale = switch (fileType){
            case "Admin" -> ADMIN_DETAILS_FILE;
            case "Customer" -> CUSTOMER_DETAILS_FILE;
            case "Customer Delivery Addresses" -> CUSTOMER_DELIVERY_ADDRESSES_FILE;
            case "Delivery History" -> DELIVERY_HISTORY_FILE;
            case "Delivery Runner" -> DELIVERY_RUNNER_DETAILS_FILE;
            case "Delivery Runner Reviews" -> DELIVERY_RUNNER_REVIEWS;
            case "Item Details" -> ITEM_DETAILS_FILE;
            case "Login" -> LOGIN_DETAILS_FILE;
            case "Notification" -> NOTIFICATION_FILE;
            case "Order History" -> ORDER_HISTORY_FILE;
            case "Pending Delivery Tasks" -> PENDING_DELIVERY_TASKS_FILE;
            case "Pending Order Details" -> PENDING_ORDER_DETAILS_FILE;
            case "Pending Top-up" -> PENDING_TOP_UP_FILE;
            case "Pending Users" -> PENDING_USERS_FILE;
            case "Top-up History" -> TOP_UP_HISTORY_FILE;
            case "Transaction History" -> TRANSACTION_HISTORY_FILE;
            case "Vendor" -> VENDOR_DETAILS_FILE;
            case "Vendor Reviews" -> VENDOR_REVIEWS_FILE;
            default -> "Invalid";
        };
        
        if (!fileLocale.equals("Invalid")) {
            return new File(fileLocale);
        } else {
            return null;
        }
    }

    public ArrayList<Object> getObjectList(String fileType) {
        ArrayList<Object> objectList = new ArrayList<>();
        try (FileInputStream inputFile = new FileInputStream(setFile(fileType));
                BufferedInputStream bufferInputFile = new BufferedInputStream(inputFile);
                ObjectInputStream objectInput = new ObjectInputStream(bufferInputFile)) {           
            
            while (true) {
                try {
                    objectList.add(objectInput.readObject());
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException ex) {
                    System.out.println(ex.getMessage());
                }
            }
            
        } catch (IOException e) {
        }
        return objectList;
    }
    
    public Object getObject(String fileType) {
        ArrayList<Object> objectList = getObjectList(fileType);
        for (Object object : objectList) {
            Object returnObject = getObjectImplementation(object);
            if (returnObject != null) {
                return returnObject;
            }
        }
        return null;
    };
    
    
    /*
        RECORD DATA
    */
    public boolean recordData(String fileType) {
        // Create a temporary array list to store all existing object //
        ArrayList<Object> temporaryObjectList = getObjectList(fileType);
        // Try-catch for input and output stream //
        try (FileOutputStream fileOutput = new FileOutputStream(setFile(fileType));
                BufferedOutputStream bufferFileOutput = new BufferedOutputStream(fileOutput);
                ObjectOutputStream objectOutput = new ObjectOutputStream(bufferFileOutput)) {
            
            // Add new object into temporary array list //
            temporaryObjectList.add(this);
            
            // Write every object in temporary array list into file //
            for (Object object : temporaryObjectList) {
                objectOutput.writeObject(object);
            }
            
            // Return operation status //
            return true;
            
        } catch (IOException e) {
            // Print IOException message for file error //
            System.out.println(e.getMessage());
        }
        
        // Return operation status //
        return false;
    };
    
    
    /*
        UPDATE DATA
    */
    public boolean updateData(String fileType) {
        // Get current object list //
        ArrayList<Object> oldObjectList = getObjectList(fileType);
        // Try-catch for input and output stream //
        try (FileOutputStream fileOutput = new FileOutputStream(setFile(fileType));
                BufferedOutputStream bufferFileOutput = new BufferedOutputStream(fileOutput);
                ObjectOutputStream objectOutput = new ObjectOutputStream(bufferFileOutput)) {
            // Get updated object list //
            ArrayList<Object> updatedObjectList = new ArrayList<>();
            for (Object object : oldObjectList) {
                Object tempObject = updateDataImplementation(object);
                if (tempObject != null) {
                    updatedObjectList.add(tempObject);
                }
            }
            // Write every object in updated array list into file //
            for (Object object : updatedObjectList) {
                objectOutput.writeObject(object);
            }
            // Return operation status //
            return true;
        } catch (IOException e) {
            // Print IOException message for file error //
            System.out.println(e.getMessage());
        }
        // Return operation status //
        return false;
    };

    
    /*
        REMOVE DATA
    */
    public boolean removeData(String fileType) {
        // Get current object list //
        ArrayList<Object> oldObjectList = getObjectList(fileType);
        // Try-catch for input and output stream //
        try (FileOutputStream fileOutput = new FileOutputStream(setFile(fileType));
                BufferedOutputStream bufferFileOutput = new BufferedOutputStream(fileOutput);
                ObjectOutputStream objectOutput = new ObjectOutputStream(bufferFileOutput)) {
            
            // Get new object list //
            ArrayList<Object> newObjectList = new ArrayList<>();
            
            for (Object object : oldObjectList) {
                Object tempObject = removeDataImplementation(object);
                if (tempObject != null) {
                    newObjectList.add(tempObject);
                }
            }
            
            // Write every object in new array list into file //
            for (Object object : newObjectList) {
                objectOutput.writeObject(object);
            }
            
            // Return operation status //
            return true;
            
        } catch (IOException e) {
            // Print IOException message for file error //
            System.out.println(e.getMessage());
        }
        
        // Return operation status //
        return false;
    };
    
    
    /*
    ABSTRACT METHODS
    */
    protected abstract Object getObjectImplementation(Object object);
    protected abstract Object removeDataImplementation(Object object);
    protected abstract Object updateDataImplementation(Object object);
}
