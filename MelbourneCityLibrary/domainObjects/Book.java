package domainObjects;

import java.util.ArrayList;
import java.util.List;

import utilities.Utility.BookStatus;

public class Book {

    private String bookId;
    private String title;
    private String author;
    private BookStatus bookStatus;
    private List<Transaction> transactions;

    public Book(String id, String title, String author) {
        this.bookId = id;
        this.title = title;
        this.author = author;
        this.bookStatus = BookStatus.Available;
        this.transactions = new ArrayList<Transaction>();
    }

    public String getBookId() {
        return this.bookId;
    }

    public void setBookStatus(BookStatus bookStatus) {
        this.bookStatus = bookStatus;
    }

    public void setTransaction(Transaction trasaction) {
        this.transactions.add(trasaction);
    }

    public Transaction getLatestTransaction() {
        return this.transactions.getLast();
    }

    public boolean isBookAvailable() {
        return this.bookStatus.equals(BookStatus.Available);
    }

    @Override
    public String toString() {
        return this.bookId + "\t" + this.title + " by " + this.author + "\t" + this.bookStatus;
    }

}