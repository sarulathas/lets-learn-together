package tests;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import domainObjects.Book;
import domainObjects.User;
import services.LibraryService;

public class LibraryServiceTest {

    private LibraryService service = new LibraryService();

    @Test
    public void testAddNewBook() {
        Book newBook = new Book("1", "New Book", "Author Name");

        service.addNewLibraryResource(newBook);

        Assertions.assertEquals(service.getBooks().get(newBook.getBookId()), newBook);
    }

    @Test
    public void testAddNewUser() {
        User newUser = new User("1", "User Name");

        service.addNewUser(newUser);

        Assertions.assertEquals(service.getUsers().get(newUser.getUserId()), newUser);
    }

    @Test
    public void testBorrowBook() {
        Book book = new Book("1", "New Book", "Author Name");
        User user = new User("1", "User Name");
        service.addNewLibraryResource(book);
        service.addNewUser(user);

        service.borrowResource("1", "1");

        Assertions.assertEquals(service.getBooks().get(book.getBookId()).isBookAvailable(), false);
    }

    @Test
    public void testReturnBook() {
        Book book = new Book("1", "New Book", "Author Name");
        User user = new User("1", "User Name");
        service.addNewLibraryResource(book);
        service.addNewUser(user);
        service.borrowResource("1", "1");

        service.returnResource("1");

        Assertions.assertEquals(service.getBooks().get(book.getBookId()).isBookAvailable(), true);
    }
}
