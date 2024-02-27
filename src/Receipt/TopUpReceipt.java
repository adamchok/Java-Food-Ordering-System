package Receipt;

import Transaction.TopUp;
import Transaction.Transaction;
import java.io.Serializable;

public class TopUpReceipt extends Receipt implements Serializable{
    private static final long serialVersionUID = 21L;
    
    private TopUp topUp;
    
    
    //  CONSTRUCTOR FOR CREATING A NEW TOP UP RECEIPT  //
    public TopUpReceipt(TopUp topUp, Transaction transaction) {
        super(transaction);
        this.topUp = topUp;
    }

    public TopUp getTopUp() {
        return topUp;
    }

    public void setTopUp(TopUp topUp) {
        this.topUp = topUp;
    }
    
    @Override
    public String toString() {
        String receipt = "";
        
        receipt += "Top Up Status: "+ topUp.getTopUpStatus() + "\n";

        receipt += "---------------------------------------------------\n";

        receipt += "Invoice Number: " + getTransaction().getInvoiceNumber() + "\n";
        receipt += "Top-up ID: " + topUp.getTopUpID() + "\n";
        receipt += "Top-up Date: " + topUp.getTopUpDate() + "\n";
        receipt += "Top-up Time: " + topUp.getTopUpTime() + "\n";
        receipt += "Transacton Date: " + getTransaction().getTransactionDate() + "\n";
        receipt += "Transaction Time: " + getTransaction().getTransactionTime() + "\n";

        receipt += "---------------------------------------------------\n";

        receipt += "Top-up Amount: RM " + String.format("%.2f", topUp.getTopUpAmount());
        
        return receipt;
    }
}
