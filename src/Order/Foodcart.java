package Order;

import FoodItem.FoodItem;
import java.io.Serializable;
import java.util.ArrayList;

public class Foodcart implements Serializable {
    private static final long serialVersionUID = 17L;
    private final ArrayList<FoodItem> foodItems;
    private final ArrayList<Integer> foodItemCounts;
    
    private double totalCost;

    //  CONSTRUCTOR FOR CREATING A NEW FOODCART  //
    public Foodcart() {
        totalCost = 0;
        foodItems = new ArrayList<>();
        foodItemCounts = new ArrayList<>();
    }

    public ArrayList<FoodItem> getFoodItems() {
        return foodItems;
    }

    public ArrayList<Integer> getFoodItemCounts() {
        return foodItemCounts;
    }
    
    public double getTotalCost() {
        return totalCost;
    }
    
    public void addItem(FoodItem foodItem, int foodItemCount) {
        boolean isExist = false;
        for (FoodItem item : foodItems) {
            if (item.getItemID().equals(foodItem.getItemID())) {
                int index = foodItems.indexOf(item);
                this.foodItemCounts.set(index, foodItemCounts.get(index) + foodItemCount);
                isExist = true;
                break;
            }
        }
        
        if (!isExist) {
            this.foodItems.add(foodItem);
            this.foodItemCounts.add(foodItemCount);
        }
        
        this.totalCost += (foodItem.getItemPrice() * foodItemCount);
    }
    
    public void removeItem(int index) {
        totalCost -= (foodItems.get(index).getItemPrice() * foodItemCounts.get(index));
        this.foodItems.remove(index);
        this.foodItemCounts.remove(index);
    }
}
