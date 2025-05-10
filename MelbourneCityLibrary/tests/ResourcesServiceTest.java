package tests;

import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import abstractions.Rentable;
import domainObjects.Book;
import domainObjects.DVD;
import domainObjects.User;
import services.implementation.ResourcesService;
import utilities.Utility.OperationStatus;
import utilities.Utility.ResourceType;

public class ResourcesServiceTest {

    private ResourcesService resourcesService = new ResourcesService();

    @Test
    public void testAddNewBook() {
        Book newBook = new Book("1", "New Book", "Author Name");

        OperationStatus status = resourcesService.addNewLibraryResource("1", newBook);

        Assertions.assertEquals(OperationStatus.SUCCESS, status);
        Assertions.assertEquals(resourcesService.getResourceById("1"), newBook);
    }

    @Test
    public void testAddNewUser() {
        User newUser = new User("1", "User Name");

        resourcesService.addNewUser(newUser);

        Assertions.assertEquals(resourcesService.getUsers().get(newUser.getUserId()), newUser);
    }

    @Test
    public void testAddNewDVD() {
        DVD newDVD = new DVD("dvd-1", "New DVD");

        OperationStatus status = resourcesService.addNewLibraryResource("dvd-1", newDVD);

        Assertions.assertEquals(OperationStatus.SUCCESS, status);
        Assertions.assertEquals(newDVD, resourcesService.getResourceById("dvd-1"));
    }

    @Test
    public void testGetCollectionByType() {
        resourcesService.addNewLibraryResource("book-1", new Book("book-1", "Book 1", "Author One"));
        resourcesService.addNewLibraryResource("book-2", new Book("book-2", "Book 2", "Author Two"));
        resourcesService.addNewLibraryResource("dvd-1", new DVD("dvd-1", "New DVD"));

        List<Rentable> booksList = resourcesService.getCollectionByType(ResourceType.Book);
        List<Rentable> dvdList = resourcesService.getCollectionByType(ResourceType.DVD);

        Assertions.assertEquals(2, booksList.size());
        Assertions.assertEquals(2, booksList.stream().filter(Book.class::isInstance).count());

        Assertions.assertEquals(1, dvdList.size());
        Assertions.assertEquals(1, dvdList.stream().filter(DVD.class::isInstance).count());

    }

}
