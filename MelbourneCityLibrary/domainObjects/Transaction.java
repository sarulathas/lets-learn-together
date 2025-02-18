package domainObjects;

import java.util.Date;

public class Transaction {

    private String userId;
    private Date borrowedDate;
    private Date dueDate;
    private boolean isReturned;

    public Transaction(String userId, Date borrowedDate, Date dueDate) {
        this.userId = userId;
        this.borrowedDate = borrowedDate;
        this.dueDate = dueDate;
        this.isReturned = false;
    }

    public Date getBorrowedDate() {
        return borrowedDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setIsReturned(boolean value) {
        this.isReturned = value;
    }

}
