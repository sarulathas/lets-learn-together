package domainObjects;

import java.util.Date;

import abstractions.Rentable;

public class Transaction {

    private Rentable item;
    private String userId;
    private Date borrowedDate;
    private Date dueDate;
    private boolean isReturned;

    public Transaction(Rentable item, String userId, Date borrowedDate, Date dueDate) {
        this.item = item;
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
