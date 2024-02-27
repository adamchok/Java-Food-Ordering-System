package Panel.Customer;

import Frame.UserFrames.CustomerMainPage;
import Order.Foodcart;
import Order.Order;
import User.Customer;
import User.Vendor;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.SwingUtilities;

/**
 *
 * @author CHOK QI YANG TP070091
 */
public class MainPanel extends javax.swing.JPanel {
    public final CardLayout mainPanelLayout;
    
    public MainPanel() {
        initComponents();
        this.setLayout(new CardLayout());
        mainPanelLayout = (CardLayout) this.getLayout();
        
        this.add(browseVendorPanel, "browseVendorPanel");
        this.add(viewMenuPanel, "viewMenuPanel");
        this.add(confirmOrderPanel, "confirmOrderPanel");
        this.add(orderPanel, "orderPanel");
        this.add(historyPanel, "historyPanel");
        this.add(notificationPanel, "notificationPanel");
        this.add(profilePanel, "profilePanel");
        
    }

    public void updateCustomer(Customer customer) {
        CustomerMainPage userFrame = (CustomerMainPage) SwingUtilities.getWindowAncestor(this);
        userFrame.setCustomer(customer);
    }
    
    public boolean checkCurrentOrder(String serviceType, Customer customer) {
        Order orders = new Order(customer);
        ArrayList<Order> pendingOrders = orders.getPendingOrderList(false);
        
        for (Order order : pendingOrders) {
            if (order.getCustomer().getId().equals(customer.getId()) && !order.getServiceType().equals("Dine-in")) {
                return true;
            }
        }
        return false;
    }
    
    public void displayBrowseVendor(Customer customer) {
        browseVendorPanel.displayRestaurants(customer);
        mainPanelLayout.show(this, "browseVendorPanel");
    }

    public void displayVendorMenu(Vendor vendor, Customer customer) {
        viewMenuPanel.displayMenu(vendor, customer);
        mainPanelLayout.show(this, "viewMenuPanel");
    }
    
    public void displayConfirmOrder(Foodcart foodCart, String serviceType, Vendor vendor, Customer customer) {
        confirmOrderPanel.displayOrderDetails(foodCart, serviceType, vendor, customer);
        mainPanelLayout.show(this, "confirmOrderPanel");
    }
    
    public void displayCurrentOrder(Customer customer) {
        orderPanel.displayCurrentOrder(customer);
        mainPanelLayout.show(this, "orderPanel");
    }
    
    public void displayDineInOrder(Customer customer) {
        orderPanel.displayDineInOrder(customer);
        mainPanelLayout.show(this, "orderPanel");
    }
    
    public void displayHistory(Customer customer) {
        historyPanel.displayOrderHistory(customer);
        mainPanelLayout.show(this, "historyPanel");
    }
    
    public void displayTransaction(Customer customer) {
        historyPanel.displayTransactionHistory(customer);
        mainPanelLayout.show(this, "historyPanel");
    }
    
    public void displayTransactionHistory(Customer customer) {
        mainPanelLayout.show(this, "historyPanel");
    }
    
    public void displayNotification(Customer customer) {
        notificationPanel.displayNotifications(customer);
        mainPanelLayout.show(this, "notificationPanel");
    }
    
    public void displayProfile(Customer customer) {
        profilePanel.displayProfile(customer);
        profilePanel.displayTopUp();
        mainPanelLayout.show(this, "profilePanel");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        browseVendorPanel = new Panel.Customer.BrowseVendorPanel();
        viewMenuPanel = new Panel.Customer.ViewMenuPanel();
        profilePanel = new Panel.Customer.ProfilePanel();
        historyPanel = new Panel.Customer.HistoryPanel();
        notificationPanel = new Panel.Customer.NotificationPanel();
        orderPanel = new Panel.Customer.OrderPanel();
        confirmOrderPanel = new Panel.Customer.ConfirmOrderPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(900, 580));
        setMinimumSize(new java.awt.Dimension(900, 580));
        setPreferredSize(new java.awt.Dimension(900, 580));
        setLayout(new java.awt.CardLayout());
        add(browseVendorPanel, "card4");
        add(viewMenuPanel, "card2");
        add(profilePanel, "card3");
        add(historyPanel, "card5");
        add(notificationPanel, "card6");
        add(orderPanel, "card7");
        add(confirmOrderPanel, "card8");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Panel.Customer.BrowseVendorPanel browseVendorPanel;
    private Panel.Customer.ConfirmOrderPanel confirmOrderPanel;
    public Panel.Customer.HistoryPanel historyPanel;
    private Panel.Customer.NotificationPanel notificationPanel;
    private Panel.Customer.OrderPanel orderPanel;
    private Panel.Customer.ProfilePanel profilePanel;
    private Panel.Customer.ViewMenuPanel viewMenuPanel;
    // End of variables declaration//GEN-END:variables
}
