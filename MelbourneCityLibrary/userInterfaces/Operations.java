package userInterfaces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import services.ResourcesService;
import utilities.Utility.ResourceType;

public class Operations {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static ResourcesService resourcesService = new ResourcesService();
    private static ResourceOperations resourceOperations = new ResourceOperations(resourcesService);
    private static DisplayUtility displayUtility = new DisplayUtility(resourcesService);
    private static UserOperations userOperations = new UserOperations(displayUtility, resourcesService);

    public static void startUserInteractions() throws NumberFormatException, IOException {
        System.out.println(" Welcome to the Melbourne City Library");
        boolean exit = false;
        while (!exit) {
            printMainMenu();
            int selectedOption = Integer.parseInt(br.readLine());

            switch (selectedOption) {
                case 1:
                    resourceOperations.addNewLibraryItem(ResourceType.Book);
                    break;
                case 2:
                    resourceOperations.addNewLibraryItem(ResourceType.DVD);
                    break;
                case 3:
                    resourceOperations.addNewUser();
                    break;
                case 4:
                    displayUtility.listCollectionByType(ResourceType.Book);
                    break;
                case 5:
                    displayUtility.listCollectionByType(ResourceType.DVD);
                    break;
                case 6:
                    displayUtility.listAllCollections();
                    break;
                case 7:
                    userOperations.borrowResourceByType(ResourceType.Book);
                    break;
                case 8:
                    userOperations.borrowResourceByType(ResourceType.DVD);
                    break;
                case 9:
                    userOperations.returnResourceByType(ResourceType.Book);
                    break;
                case 10:
                    userOperations.returnResourceByType(ResourceType.DVD);
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

}
