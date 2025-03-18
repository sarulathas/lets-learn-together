package userInterfaces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import services.LibraryService;
import services.ResourcesService;
import utilities.Utility.OperationStatus;
import utilities.Utility.ResourceType;

public class UserOperations {

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private DisplayUtility displayUtility;
    private LibraryService libraryServices;
    private ResourcesService resourcesService;

    public UserOperations(DisplayUtility displayUtility, ResourcesService resourcesService) {
        this.displayUtility = displayUtility;
        this.resourcesService = resourcesService;
        // inject abstraction instead of concrete classes
        this.libraryServices = new LibraryService();
    }

    public void borrowResourceByType(ResourceType type) throws IOException {
        System.out.println("Available " + type);
        Boolean isResourceAvailable = displayUtility.displayAvailableResourceByType(type);

        if (!isResourceAvailable) {
            System.out.println(" Sorry! No " + type + "s are available at the moment.");
            return;
        }

        System.out.print("Enter " + type + " ID: ");
        String bookId = br.readLine();
        System.out.println("Users");
        displayUtility.displayAllUsers();
        System.out.print("Enter User ID: ");
        String userId = br.readLine();

        OperationStatus status = libraryServices.borrowResource(resourcesService.getResourceById(bookId), userId);
        if (status.equals(OperationStatus.FAILURE)) {
            System.out.println("Unable to borrow " + type + "!");
            return;
        }
        System.out.println(type + " borrowed successfully!\n");
    }

    public void returnResourceByType(ResourceType type) throws IOException {
        System.out.println("Borrowed " + type);
        Boolean isResourceBorrowed = displayUtility.displayBorrowedResourceByType(type);

        if (!isResourceBorrowed) {
            System.out.println(" Sorry! No " + type + "s are borrowed at the moment.");
            return;
        }

        System.out.print("Enter " + type + " ID: ");
        String bookId = br.readLine();

        OperationStatus status = libraryServices.returnResource(resourcesService.getResourceById(bookId));
        if (status.equals(OperationStatus.FAILURE)) {
            System.out.println("Failed to return " + type + "!");
            return;
        }
        System.out.println(type + " returned successfully!\n");
    }

}
