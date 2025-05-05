package domainObjects;

import java.util.Date;
import java.util.UUID;

import abstractions.Rentable;

public class Transaction {

    private Rentable item;
    private String userId;
    private Date borrowedDate; // keep it as DateTime
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
        return this.borrowedDate;
    }

    public Date getDueDate() {
        return this.dueDate;
    }

    public void setIsReturned(boolean value) {
        this.isReturned = value;
    }

    public Rentable getItem() {
        return item;
    }

    public String getUserId() {
        return userId;
    }

    public boolean isReturned() {
        return isReturned;
    }

}
