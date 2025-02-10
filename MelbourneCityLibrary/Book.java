import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

enum Status {
    Available,
    Borrowed,
    Overdue
}

public class Book {

    private UUID bookId;
    private String title;
    private String author;
    private Status bookStatus;
    private List<Card> transactions;

    public Book(String title, String author) {
        this.bookId = UUID.randomUUID();
        this.title = title;
        this.author = author;
        this.bookStatus = Status.Available;
        this.transactions = new ArrayList<Card>();
    }

    public UUID getBookId() {
        return this.bookId;
    }

    public void setBookStatus(Status bookStatus) {
        this.bookStatus = bookStatus;
    }

    public void setTransactionCard(Card trasactionCard) {
        this.transactions.add(trasactionCard);
    }

    public Card getLatestTransaction() {
        return this.transactions.getLast();
    }

    public boolean isBookAvailable() {
        return this.bookStatus.equals(Status.Available);
    }

    @Override
    public String toString() {
        return title + "    " + author + "    " + bookStatus;
    }

}