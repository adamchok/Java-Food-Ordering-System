package Receipt;

import Order.Foodcart;
import Order.Order;
import Transaction.Transaction;
import java.io.Serializable;

public class OrderReceipt extends Receipt implements Serializable{
    private static final long serialVersionUID = 20L;
    
    private Order order;
    
    //  DEFAULT CONSTRUCTOR  //
    public OrderReceipt() {
    }
    
    //  CONSTRUCTOR FOR CREATING A NEW ORDER RECEIPT  //
    public OrderReceipt(Order order, Transaction transaction) {
        super(transaction);
        this.order = order;
    }
    
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
    
    @Override
    public String toString() {
        String receipt = "";
        String orderItemList = "";
        double subtotal = 0;
        double serviceFee = 0;
        
        receipt += "Restaurant Name: "+ order.getVendor().getName() + "\n";
        receipt += "Restaurant Address:\n"+ order.getVendor().getRestaurantAddress() + "\n";

        receipt += "Phone Number: "+ order.getVendor().getPhoneNumber();   
        receipt += "\n---------------------------------------------------\n";

        receipt += "Invoice Number: " + getTransaction().getInvoiceNumber() + "\n";
        receipt += "Order Date: " + order.getOrderDate() + "\n";
        receipt += "Order Time: " + order.getOrderTime() + "\n";
        receipt += "Transacton Date: " + getTransaction().getTransactionDate() + "\n";
        receipt += "Transaction Time: " + getTransaction().getTransactionTime() + "\n\n";

        receipt += "OrderID: " + order.getOrderID() + "\n";
        receipt += "Order Status: " + order.getOrderStatus() + "\n";
        receipt += "Service Type: " + order.getServiceType() + "\n";
        
        if (order.getServiceType().equals("Delivery")) {
            receipt += "Delivery Address: " + order.getDeliveryAddress();
            serviceFee = 5;
        }
        
        receipt += "\n---------------------------------------------------\n";

        Foodcart foodCart = order.getFoodCart();
        int numberOfItems = foodCart.getFoodItems().size();
        subtotal = foodCart.getTotalCost();
        
        for (int i = 0; i < numberOfItems; i++) {
            double foodSubtotal = (foodCart.getFoodItems().get(i).getItemPrice() * foodCart.getFoodItemCounts().get(i));

            orderItemList += foodCart.getFoodItems().get(i).getItemName()+ "(x"+foodCart.getFoodItemCounts().get(i)+")"+
                    " - RM "+String.format("%.2f", foodSubtotal)+"\n";
        }
        
        receipt += orderItemList;

        receipt += "---------------------------------------------------\n";

        receipt += "Subtotal: RM" + String.format("%.2f", subtotal) + "\n";
        receipt += "Service Cost: RM" + String.format("%.2f", serviceFee) + "\n";

        receipt += "Total Cost: RM" + String.format("%.2f", subtotal + serviceFee);
        return receipt;
    }
}
