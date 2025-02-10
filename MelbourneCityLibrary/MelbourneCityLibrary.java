import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MelbourneCityLibrary {

    private Map<UUID, Book> books;
    private Map<UUID, User> users;

    public MelbourneCityLibrary() {
        books = new HashMap<UUID, Book>();
        users = new HashMap<UUID, User>();
    }

    public void addNewBook(Book newBook) {
        System.out.println(newBook.getBookId());
        System.out.println(newBook);
        this.books.put(newBook.getBookId(), newBook);
        System.out.println(this.books.toString());
    }

    public void addNewUser(User newUser) {
        this.users.put(newUser.getUserId(), newUser);
    }

    public Map<UUID, Book> getBooks() {
        return this.books;
    }

    public Map<UUID, User> getUsers() {
        return this.users;
    }

    public Date borrowBook(UUID bookId, UUID userId) {
        Date borrowedDate = new Date();
        Date dueDate = computeDueDate();
        Card newTrasaction = new Card(userId, borrowedDate, dueDate);
        this.books.get(bookId).setTransactionCard(newTrasaction);
        this.books.get(bookId).setBookStatus(Status.Borrowed);
        return dueDate;
    }

    private Date computeDueDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 14);
        Date dueDate = calendar.getTime();
        return dueDate;
    }

    public void returnBook(UUID bookId) {
        /* TO DO: check for overdue and fines */

        this.books.get(bookId).getLatestTransaction().setIsReturned(true);
        this.books.get(bookId).setBookStatus(Status.Available);
    }

}
