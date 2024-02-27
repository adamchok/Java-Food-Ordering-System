package FoodItem;

import FileManagement.Data;
import User.Vendor;
import java.io.Serializable;
import java.util.ArrayList;

public class FoodItem extends Data implements Serializable {
    private static final long serialVersionUID = 19L;
    
    private String itemID, itemName, itemType;
    private double itemPrice;
    private Vendor vendor;
    
    
    //  DEFAULT CONSTRUCTOR  //
    public FoodItem(){
    }
    
    //  CONSTRUCTOR TO GET MENU  //
    public FoodItem(Vendor vendor) {
        this.vendor = vendor;
    }
    
    //  CONSTRUCTOR TO GET SPECIFIC ITEM  // 
    public FoodItem(String itemID) {
        this.itemID = itemID;
    }
    
    //  CONSTRUCTOR TO CREATE NEW ITEM  //
    public FoodItem(String itemName, double itemPrice, String itemType, Vendor vendor) {
        this.vendor = vendor;
        this.itemID = generateFoodItemID();
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemType = itemType;
        this.itemID = generateFoodItemID();
    }

    public String getItemID() {
        return itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Vendor getVendor() {
        return vendor;
    }
    
    //  CREATING A NEW ITEM ID  //
    private String generateFoodItemID() {
        ArrayList<FoodItem> items = getMenu(true);
        int largestId = 0;
        
        if (!items.isEmpty()) {
            for (FoodItem item : items) {
                String id = item.getItemID();
                int idNum = Integer.parseInt(id.split("-")[1]);
                if (idNum > largestId) {
                    largestId = idNum;
                }
            } 
        }
        return "IT-"+(largestId + 1);
    }
    
    //  GET A LIST OF FOOD ITEMS BASED ON A VENDOR  //
    public ArrayList<FoodItem> getMenu(boolean isAll) {
        ArrayList<Object> objectList = getObjectList("Item Details");
        ArrayList<FoodItem> itemList = new ArrayList<>();
        
        if (!objectList.isEmpty()) {
            for (Object object : objectList) {
                if (object instanceof FoodItem item) {
                    if (isAll == false) {
                        if (item.getVendor().getId().equals(getVendor().getId())) {
                            itemList.add(item);
                        }
                    } else {
                        itemList.add(item);
                    }
                }
            }
        }
        return itemList;  
    }
    
    public boolean createItem() {
        return recordData("Item Details");
    }
    
    public boolean deleteItem() {
        return removeData("Item Details");
    }
    
    public boolean updateItem() {
        return updateData("Item Details");
    }
    
    
    //  GET AN ITEM OBJECT BASED ON ITS ID AND VENDOR  //
    @Override
    public Object getObjectImplementation(Object object) {
        if (object instanceof FoodItem item) {
            if (item.getItemID().equals(getItemID())) {
                return item;
            }
        }
        return null;
    }
    
    
    //  UPDATE AN ITEM BASED ON ITS ID AND VENDOR  //
    @Override
    public Object updateDataImplementation(Object object) {
        if (object instanceof FoodItem item) {
            if (item.getItemID().equals(getItemID())) {
                return this;
            } else {
                return item;
            }
        }
        return null;
    }
    
    
    //  DELETE AN ITEM BASED ON ITS ID AND VENDOR  //
    @Override
    public Object removeDataImplementation(Object object) {
        if (object instanceof FoodItem item) {
            if (!item.getItemID().equals(getItemID())) {
                return item;
            }
        }
        return null;
    }
}
