package userInterfaces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.UUID;

import domainObjects.Book;
import domainObjects.DVD;
import domainObjects.User;
import services.implementation.ResourcesService;
import utilities.Utility.OperationStatus;
import utilities.Utility.ResourceType;

public class ResourceOperations {

    private ResourcesService resourcesService;
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // inject abstraction instead of concrete classes
    public ResourceOperations(ResourcesService resourcesService) {
        this.resourcesService = resourcesService;
    }

    public void addNewLibraryItem(ResourceType type) throws IOException {
        UUID id = UUID.randomUUID();
        System.out.print("Enter " + type + " Name: ");
        String title = br.readLine();

        OperationStatus status;

        if (type.equals(ResourceType.Book)) {
            System.out.print("Enter Author Name: ");
            String author = br.readLine();
            status = resourcesService.addNewLibraryResource(new Book(id, title, author));
        } else {
            status = resourcesService.addNewLibraryResource(new DVD(id, title));
        }

        if (status.equals(OperationStatus.SUCCESS)) {
            System.out.println(type + " added successfully!\n");
        } else {
            System.out.println("Failed to add new " + type + "\n");
        }
    }

    public void addNewUser() throws IOException {
        System.out.print("Enter User ID: ");
        String userId = br.readLine();
        System.out.print("Enter User Name: ");
        String userName = br.readLine();

        resourcesService.addNewUser(new User(userId, userName));
        System.out.println("User added successfully!\n");
    }

}
