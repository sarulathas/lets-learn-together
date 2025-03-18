package domainObjects;

import java.util.ArrayList;
import java.util.List;

import abstractions.Rentable;
import utilities.Utility.RentStatus;
import utilities.Utility.ResourceType;

public class Book implements Rentable {

    private String bookId;
    private String title;
    private String author;
    private RentStatus bookStatus;
    private List<Transaction> transactions;
    private ResourceType type; // look to remove this

    public Book(String id, String title, String author) {
        this.bookId = id;
        this.title = title;
        this.author = author;
        this.bookStatus = RentStatus.Available;
        this.transactions = new ArrayList<Transaction>();
        this.type = ResourceType.Book;
    }

    public String getBookId() {
        return this.bookId;
    }

    public Transaction getLatestTransaction() {
        return this.transactions.getLast();
    }

    @Override
    public String toString() {
        return this.bookId + "\t" + this.title + " by " + this.author + "\t" + this.bookStatus;
    }

    @Override
    public ResourceType getItemType() {
        return this.type;
    }

    @Override
    public boolean isAvailable() {
        return this.bookStatus.equals(RentStatus.Available);
    }

    @Override
    public void borrowItem() {
        this.bookStatus = RentStatus.Borrowed;
    }

    @Override
    public void returnItem() {
        this.bookStatus = RentStatus.Available;
    }

    @Override
    public void addNewTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }

}