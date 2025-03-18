package domainObjects;

import abstractions.Rentable;

public class Transaction {

    private Rentable item;
    private String userId;
    private String borrowedDate; // keep it as DateTime
    private String dueDate;
    private boolean isReturned;

    public Transaction(Rentable item, String userId, String borrowedDate, String dueDate) {
        this.item = item;
        this.userId = userId;
        this.borrowedDate = borrowedDate;
        this.dueDate = dueDate;
        this.isReturned = false;
    }

    public String getBorrowedDate() {
        return borrowedDate;
    }

    public String getDueDate() {
        return dueDate;
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
