package utilities;

import java.util.Collection;
import java.util.List;

import abstractions.Rentable;
import domainObjects.User;

public class Utility {

    public static void printBooks(List<Rentable> collection) {
        System.err.println("--------------------------------------\n");
        for (Rentable item : collection) {
            System.out.println(item);
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

    // can be within domainObjects
    public enum RentStatus {
        Available,
        Borrowed,
        Overdue
    }

    // should be within service.should not be leaked. 
    // output needs to be transformed and handled in user interface.
    public enum OperationStatus {
        SUCCESS,
        FAILURE
    }

    public enum ResourceType {
        Book,
        DVD
    }
}
