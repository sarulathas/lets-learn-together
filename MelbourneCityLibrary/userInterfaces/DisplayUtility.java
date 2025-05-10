package userInterfaces;

import java.util.List;
import java.util.stream.Collectors;

import abstractions.Rentable;
import services.implementation.ResourcesService;
import utilities.Utility;
import utilities.Utility.ResourceType;

public class DisplayUtility {

    private ResourcesService resourcesService;

    public DisplayUtility(ResourcesService resourcesService) {
        this.resourcesService = resourcesService;
    }

    public boolean displayAvailableResourceByType(ResourceType type) {
        List<Rentable> items = resourcesService.getCollectionByType(type);
        items = items.stream().filter(item -> item.isAvailable()).collect(Collectors.toList());
        Utility.printBooks(items);
        return items.size() > 0;
    }

    public boolean displayBorrowedResourceByType(ResourceType type) {
        List<Rentable> items = resourcesService.getCollectionByType(type);
        items = items.stream().filter(item -> !item.isAvailable()).collect(Collectors.toList());
        Utility.printBooks(items);
        return items.size() > 0;
    }

    public void displayAllUsers() {
        Utility.printUsers(resourcesService.getAllUsers());
    }

    public void listCollectionByType(ResourceType type) {
        List<Rentable> books = resourcesService.getCollectionByType(type);
        Utility.printBooks(books);
    }

    public void listAllCollections() {
        List<Rentable> books = resourcesService.getAllCollection();
        Utility.printBooks(books);
    }

}
