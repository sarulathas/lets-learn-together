import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;

public class MainMenu {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static MelbourneCityLibrary library = new MelbourneCityLibrary();

    public static void main(String[] args) throws NumberFormatException, IOException {
        start();
    }

    private static void start() throws NumberFormatException, IOException {
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

    private static void addNewBook() throws IOException {
        System.out.print("Enter Book Name: ");
        String title = br.readLine();
        System.out.print("Enter Author Name: ");
        String author = br.readLine();
        library.addNewBook(new Book(title, author));
        System.out.println("Book added successfully!\n");
    }

    private static void addNewUser() throws IOException {
        System.out.print("Enter User Name: ");
        String userName = br.readLine();
        library.addNewUser(new User(userName));
        System.out.println("User added successfully!\n");
    }

    private static void listAllBooks() {
        Collection<Book> books = library.getBooks().values();
        System.out.println("\n\n Title \t\t Author \t Status");
        System.err.println("--------------------------------------\n");
        for (Book book : books) {
            System.out.println(book.toString());
        }
        System.out.println();
    }

    private static void borrowBook() throws IOException {
        displayAvailableBooks();
        System.out.print("Enter Book ID: ");
        UUID bookId = UUID.fromString(br.readLine());
        displayAllUsers();
        System.out.print("Enter User ID: ");
        UUID userId = UUID.fromString(br.readLine());
        Date dueDate = library.borrowBook(bookId, userId);

        System.out.println("Book borrowed successfully! It is due on " + dueDate + ".\n");
    }

    private static void returnBook() throws IOException {
        displayBorrowedBooks();
        System.out.print("Enter Book ID: ");
        UUID bookId = UUID.fromString(br.readLine());

        library.returnBook(bookId);

        System.out.println("Book returned successfully!\n");
    }

    private static void displayAvailableBooks() {
        Collection<Book> books = library.getBooks().values();
        System.out.println("\n\n ID \t\t Title \t\t Author \t Status");
        System.err.println("--------------------------------------\n");
        for (Book book : books) {
            if (book.isBookAvailable()) {
                System.out.print(book.getBookId() + " ");
                System.out.println(book.toString());
            }
        }
        System.out.println();
    }

    private static void displayBorrowedBooks() {
        Collection<Book> books = library.getBooks().values();
        System.out.println("\n\n ID \t\t Title \t\t Author \t Status");
        System.err.println("--------------------------------------\n");
        for (Book book : books) {
            if (!book.isBookAvailable()) {
                System.out.print(book.getBookId() + " ");
                System.out.println(book.toString());
            }
        }
        System.out.println();
    }

    private static void displayAllUsers() {
        Collection<User> users = library.getUsers().values();
        System.out.println("\n\n ID \t Username");
        System.err.println("----------------------\n");
        for (User user : users) {
            System.out.println(user.toString());
        }
        System.out.println();
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
}