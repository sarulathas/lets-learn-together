package userInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import abstractions.Rentable;
import domainObjects.Book;
import domainObjects.DVD;
import domainObjects.Library;
import domainObjects.User;
import services.LibraryService;
import services.ResourcesService;
import utilities.Utility;
import utilities.Utility.OperationStatus;
import utilities.Utility.ResourceType;

public class UserOperations {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static LibraryService libraryServices = new LibraryService();
    private static ResourcesService resourcesService = new ResourcesService();

    public static void startUserInteractions() throws NumberFormatException, IOException {
        System.out.println(" Welcome to the Melbourne City Library");
        boolean exit = false;
        while (!exit) {
            printMainMenu();
            int selectedOption = Integer.parseInt(br.readLine());

            switch (selectedOption) {
                case 1:
                    addNewLibraryItem(ResourceType.Book);
                    break;
                case 2:
                    addNewLibraryItem(ResourceType.DVD);
                    break;
                case 3:
                    addNewUser();
                    break;
                case 4:
                    listCollectionByType(ResourceType.Book);
                    break;
                case 5:
                    listCollectionByType(ResourceType.DVD);
                    break;
                case 6:
                    listAllCollections();
                    break;
                case 7:
                    borrowResourceByType(ResourceType.Book);
                    break;
                case 8:
                    borrowResourceByType(ResourceType.DVD);
                    break;
                case 9:
                    returnResourceByType(ResourceType.Book);
                    break;
                case 10:
                    returnResourceByType(ResourceType.DVD);
                    break;
                case 11:
                    exit = true;
                    break;
                default:
                    break;
            }
        }

    }

    private static void printMainMenu() {
        System.out.println("Main Menu");
        System.out.println("1. Add Book");
        System.out.println("2. Add DVD");
        System.out.println("3. Add User");
        System.out.println("4. List all Books");
        System.out.println("5. List all DVDs");
        System.out.println("6. List all library collection");
        System.out.println("7. Borrow a Book");
        System.out.println("8. Borrow a DVD");
        System.out.println("9. Return a Book");
        System.out.println("10. Return a DVD");
        System.out.println("11. Exit");
    }

    private static void addNewLibraryItem(ResourceType type) throws IOException {
        System.out.print("Enter " + type + " ID: ");
        String id = br.readLine();
        System.out.print("Enter " + type + " Name: ");
        String title = br.readLine();
        if (type.equals(ResourceType.Book)) {
            System.out.print("Enter Author Name: ");
            String author = br.readLine();
            resourcesService.addNewLibraryResource(id, new Book(id, title, author));
        } else {
            resourcesService.addNewLibraryResource(id, new DVD(id, title));
        }

        System.out.println(type + " added successfully!\n");
    }

    private static void addNewUser() throws IOException {
        System.out.print("Enter User ID: ");
        String userId = br.readLine();
        System.out.print("Enter User Name: ");
        String userName = br.readLine();

        resourcesService.addNewUser(new User(userId, userName));
        System.out.println("User added successfully!\n");
    }

    private static void borrowResourceByType(ResourceType type) throws IOException {
        System.out.println("Available " + type);
        displayAvailableResourceByType(type);
        System.out.print("Enter " + type + " ID: ");
        String bookId = br.readLine();
        System.out.println("Users");
        displayAllUsers();
        System.out.print("Enter User ID: ");
        String userId = br.readLine();

        OperationStatus status = libraryServices.borrowResource(resourcesService.getResourceById(bookId), userId);
        if (status.equals(OperationStatus.FAILURE)) {
            System.out.println("Unable to borrow " + type + "!");
            return;
        }
        System.out.println(type + " borrowed successfully!\n");
    }

    private static void returnResourceByType(ResourceType type) throws IOException {
        System.out.println("Borrowed " + type);
        displayBorrowedResourceByType(type);
        System.out.print("Enter " + type + " ID: ");
        String bookId = br.readLine();

        OperationStatus status = libraryServices.returnResource(resourcesService.getResourceById(bookId));
        if (status.equals(OperationStatus.FAILURE)) {
            System.out.println("Failed to return " + type + "!");
            return;
        }
        System.out.println(type + " returned successfully!\n");
    }

    private static void listCollectionByType(ResourceType type) {
        List<Rentable> books = resourcesService.getCollectionByType(type);
        Utility.printBooks(books);
    }

    private static void listAllCollections() {
        List<Rentable> books = resourcesService.getAllCollection();
        Utility.printBooks(books);
    }

    private static void displayAvailableResourceByType(ResourceType type) {
        List<Rentable> books = resourcesService.getCollectionByType(type);
        books = books.stream().filter(book -> book.isAvailable()).collect(Collectors.toList());
        Utility.printBooks(books);
    }

    private static void displayBorrowedResourceByType(ResourceType type) {
        List<Rentable> books = resourcesService.getCollectionByType(type);
        books = books.stream().filter(book -> !book.isAvailable()).collect(Collectors.toList());
        Utility.printBooks(books);
    }

    private static void displayAllUsers() {
        Utility.printUsers(resourcesService.getAllUsers());
    }

}
