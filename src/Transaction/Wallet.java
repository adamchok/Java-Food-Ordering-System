package Transaction;

import java.io.Serializable;

public class Wallet implements Serializable {
    private static final long serialVersionUID = 10L;
    
    private double currentCreditAmount;
    
    //  CONSTRUCTOR FOR CREATING A NEW WALLET  //
    public Wallet() {
        this.currentCreditAmount = 0;
    }

    public double getCurrentCreditAmount() {
        return currentCreditAmount;
    }

    public void setCurrentCreditAmount(double currentCreditAmount) {
        this.currentCreditAmount = currentCreditAmount;
    }
    
    public void depositCredit(double depositAmount) {
        currentCreditAmount += depositAmount;
    }
    
    public void withdrawCredit(double withdrawAmount) {
        currentCreditAmount -= withdrawAmount;
    }
    
}
