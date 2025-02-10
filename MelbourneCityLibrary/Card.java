import java.util.Date;
import java.util.UUID;

public class Card {

    private UUID userId;
    private Date borrowedDate;
    private Date dueDate;
    private boolean isReturned;

    public Card(UUID userId, Date borrowedDate, Date dueDate) {
        this.userId = userId;
        this.borrowedDate = borrowedDate;
        this.dueDate = dueDate;
        this.isReturned = false;
    }

    public UUID getUserId() {
        return userId;
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
