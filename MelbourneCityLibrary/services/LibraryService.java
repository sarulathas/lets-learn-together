package services;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import domainObjects.Book;
import domainObjects.Transaction;
import domainObjects.User;
import utilities.Utility.BookStatus;
import utilities.Utility.OperationStatus;

public class LibraryService {

    private Map<String, Book> books;
    private Map<String, User> users;

    public LibraryService() {
        books = new HashMap<String, Book>();
        users = new HashMap<String, User>();
    }

    public Map<String, Book> getBooks() {
        return this.books;
    }

    public Map<String, User> getUsers() {
        return this.users;
    }

    public void addNewBook(Book newBook) {
        this.books.put(newBook.getBookId(), newBook);
        System.out.println(newBook);
    }

    public void addNewUser(User newUser) {
        this.users.put(newUser.getUserId(), newUser);
    }

    public OperationStatus borrowBook(String bookId, String userId) {
        if (!this.books.get(bookId).isBookAvailable()) {
            System.out.println("Book is not available");
            return OperationStatus.FAILURE;
        }
        Date borrowedDate = new Date();
        Date dueDate = computeDueDate();
        Transaction newTrasaction = new Transaction(userId, borrowedDate, dueDate);
        this.books.get(bookId).setTransaction(newTrasaction);
        this.books.get(bookId).setBookStatus(BookStatus.Borrowed);
        System.out.println("Book is due on " + dueDate);
        return OperationStatus.SUCCESS;
    }

    private Date computeDueDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 14);
        Date dueDate = calendar.getTime();
        return dueDate;
    }

    public OperationStatus returnBook(String bookId) {
        /* TO DO: check for overdue and fines */
        if (this.books.get(bookId).isBookAvailable()) {
            System.out.println("Book is not borrowed.");
            return OperationStatus.FAILURE;
        }

        this.books.get(bookId).getLatestTransaction().setIsReturned(true);
        this.books.get(bookId).setBookStatus(BookStatus.Available);
        return OperationStatus.SUCCESS;
    }

}
