/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Panel.Admin;

import Frame.UserFrames.AdminMainPage;
import User.Admin;
import java.awt.CardLayout;
import javax.swing.SwingUtilities;

/**
 *
 * @author Dixon
 */
public class MainPanel extends javax.swing.JPanel {
    public final CardLayout mainPanelLayout;
    
    
    public MainPanel() {
        initComponents();
        this.setLayout(new CardLayout());
        mainPanelLayout = (CardLayout) this.getLayout();
        add(createUserPanel, "createUserPanel");
        add(feedbackPanel, "feedbackPanel");
        add(profilePanel, "profilePanel");
        add(receiptsPanel, "receiptsPanel");
        add(topUpPanel, "topUpPanel");
        add(viewUserPanel, "viewUserPanel");
    }
    
    public void updateAdmin(Admin admin) {
        AdminMainPage userFrame = (AdminMainPage) SwingUtilities.getWindowAncestor(this);
        userFrame.setAdmin(admin);
    }
    
    public void displayCreateUser() {
        createUserPanel.displayPendingUsers();
        mainPanelLayout.show(this, "createUserPanel");
    }

    public void displayFeedback() {
        feedbackPanel.displayReviews();
        mainPanelLayout.show(this, "feedbackPanel");
    }
    
    public void displayProfile(Admin admin) {
        profilePanel.displayProfile(admin);
        mainPanelLayout.show(this, "profilePanel");
    }
    
    public void displayReceipts() {
        receiptsPanel.displayPendingTransactions();
        mainPanelLayout.show(this, "receiptsPanel");
    }
    
    public void displayTopUp() {
        topUpPanel.displayPendingTopUps();
        mainPanelLayout.show(this, "topUpPanel");
    }
    
    public void displayViewUser() {
        viewUserPanel.displayUsers();
        mainPanelLayout.show(this, "viewUserPanel");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        createUserPanel = new Panel.Admin.CreateUserPanel();
        feedbackPanel = new Panel.Admin.FeedbackPanel();
        profilePanel = new Panel.Admin.ProfilePanel();
        receiptsPanel = new Panel.Admin.ReceiptsPanel();
        topUpPanel = new Panel.Admin.TopUpPanel();
        viewUserPanel = new Panel.Admin.ViewUserPanel();

        setMaximumSize(new java.awt.Dimension(944, 600));
        setMinimumSize(new java.awt.Dimension(944, 600));
        setPreferredSize(new java.awt.Dimension(944, 600));
        setLayout(new java.awt.CardLayout());
        add(createUserPanel, "card2");
        add(feedbackPanel, "card3");
        add(profilePanel, "card4");
        add(receiptsPanel, "card5");
        add(topUpPanel, "card6");
        add(viewUserPanel, "card7");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Panel.Admin.CreateUserPanel createUserPanel;
    private Panel.Admin.FeedbackPanel feedbackPanel;
    private Panel.Admin.ProfilePanel profilePanel;
    private Panel.Admin.ReceiptsPanel receiptsPanel;
    private Panel.Admin.TopUpPanel topUpPanel;
    private Panel.Admin.ViewUserPanel viewUserPanel;
    // End of variables declaration//GEN-END:variables
}
