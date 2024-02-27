package Receipt;

import Transaction.Transaction;
import java.io.Serializable;

public abstract class Receipt implements Serializable{
    private static final long serialVersionUID = 23L;
    
    private Transaction transaction;
    
    //  DEFAULT CONSTRUCTOR  //
    public Receipt() {
    }

    //  CONSTRUCTOR FOR CREATING A NEW RECEIPT  //
    public Receipt(Transaction transaction) {
        this.transaction = transaction;
    }
   
    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
