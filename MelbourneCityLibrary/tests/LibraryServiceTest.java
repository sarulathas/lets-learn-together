package tests;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import domainObjects.Book;
import services.LibraryService;

public class LibraryServiceTest {

    private LibraryService service = new LibraryService();

    @Test
    public void testBorrowBook() {
        Book book = new Book("1", "New Book", "Author Name");

        service.borrowResource(book, "1");

        Assertions.assertEquals(false, book.isAvailable());
        Assertions.assertEquals(book, book.getLatestTransaction().getItem());
        Assertions.assertEquals("1", book.getLatestTransaction().getUserId());
        Assertions.assertEquals(false, book.getLatestTransaction().isReturned());
        Assertions.assertEquals(new SimpleDateFormat("yyyy-MM-dd").format(new Date()),
                book.getLatestTransaction().getBorrowedDate());
    }

    @Test
    public void testReturnBook() {
        Book book = new Book("1", "New Book", "Author Name");

        service.borrowResource(book, "1");

        service.returnResource(book);

        Assertions.assertEquals(true, book.isAvailable());
        Assertions.assertEquals(true, book.getLatestTransaction().isReturned());
    }
}
