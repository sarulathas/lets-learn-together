package utilities;

import java.util.Collection;

import domainObjects.Book;
import domainObjects.User;

public class Utility {

    public static void printBooks(Collection<Book> books) {
        System.err.println("--------------------------------------\n");
        for (Book book : books) {
            System.out.println(book);
        }
        System.err.println("--------------------------------------\n");
    }

    public static void printUsers(Collection<User> users) {
        System.err.println("--------------------------------------\n");
        for (User user : users) {
            System.out.println(user);
        }
        System.err.println("--------------------------------------\n");
    }

    public enum BookStatus {
        Available,
        Borrowed,
        Overdue
    }

    public enum OperationStatus {
        SUCCESS,
        FAILURE
    }
}
