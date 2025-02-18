package userInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.stream.Collectors;

import domainObjects.Book;
import domainObjects.User;
import services.LibraryService;
import utilities.Utility;
import utilities.Utility.OperationStatus;

public class UserOperations {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static LibraryService library = new LibraryService();

    public static void startUserInteractions() throws NumberFormatException, IOException {
        System.out.println(" Welcome to the Melbourne City Library");
        boolean exit = false;
        while (!exit) {
            printMainMenu();
            int selectedOption = Integer.parseInt(br.readLine());

            switch (selectedOption) {
                case 1:
                    addNewBook();
                    break;
                case 2:
                    addNewUser();
                    break;
                case 3:
                    listAllBooks();
                    break;
                case 4:
                    borrowBook();
                    break;
                case 5:
                    returnBook();
                    break;
                case 6:
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
        System.out.println("2. Add User");
        System.out.println("3. List all Books");
        System.out.println("4. Borrow a Book");
        System.out.println("5. Return a Book");
        System.out.println("6. Exit");
    }

    private static void addNewBook() throws IOException {
        System.out.print("Enter Book ID: ");
        String id = br.readLine();
        System.out.print("Enter Book Name: ");
        String title = br.readLine();
        System.out.print("Enter Author Name: ");
        String author = br.readLine();

        library.addNewBook(new Book(id, title, author));
        System.out.println("Book added successfully!\n");
    }

    private static void addNewUser() throws IOException {
        System.out.print("Enter User ID: ");
        String userId = br.readLine();
        System.out.print("Enter User Name: ");
        String userName = br.readLine();

        library.addNewUser(new User(userId, userName));
        System.out.println("User added successfully!\n");
    }

    private static void borrowBook() throws IOException {
        System.out.println("Available books");
        displayAvailableBooks();
        System.out.print("Enter Book ID: ");
        String bookId = br.readLine();
        System.out.println("Users");
        displayAllUsers();
        System.out.print("Enter User ID: ");
        String userId = br.readLine();

        OperationStatus status = library.borrowBook(bookId, userId);
        if (status.equals(OperationStatus.FAILURE)) {
            System.out.println("Unable to borrow book!");
            return;
        }
        System.out.println("Book borrowed successfully!\n");
    }

    private static void returnBook() throws IOException {
        System.out.println("Borrowed books");
        displayBorrowedBooks();
        System.out.print("Enter Book ID: ");
        String bookId = br.readLine();

        OperationStatus status = library.returnBook(bookId);
        if (status.equals(OperationStatus.FAILURE)) {
            System.out.println("Failed to return book!");
            return;
        }
        System.out.println("Book returned successfully!\n");
    }

    private static void listAllBooks() {
        Collection<Book> books = library.getBooks().values();
        Utility.printBooks(books);
    }

    private static void displayAvailableBooks() {
        Collection<Book> books = library.getBooks().values();
        books = books.stream().filter(book -> book.isBookAvailable()).collect(Collectors.toList());
        Utility.printBooks(books);
    }

    private static void displayBorrowedBooks() {
        Collection<Book> books = library.getBooks().values();
        books = books.stream().filter(book -> !book.isBookAvailable()).collect(Collectors.toList());
        Utility.printBooks(books);
    }

    private static void displayAllUsers() {
        Utility.printUsers(library.getUsers().values());
    }

}
