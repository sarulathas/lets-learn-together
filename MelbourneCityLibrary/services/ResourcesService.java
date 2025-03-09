package services;

import java.util.List;

import abstractions.Rentable;
import domainObjects.Book;
import domainObjects.Library;
import domainObjects.User;
import utilities.Utility.ResourceType;

public class ResourcesService {

    private Library library;

    public ResourcesService() {
        this.library = new Library();
    }

    // to change to add new rentable item
    public void addNewLibraryResource(String id, Rentable item) {
        this.library.getCollection().put(id, item);
        System.out.println(item);
    }

    public void addNewUser(User newUser) {
        this.library.getUsers().put(newUser.getUserId(), newUser);
    }

    public List<Rentable> getAllCollection() {
        return this.library.getCollection().values().stream().toList();
    }

    public List<Rentable> getCollectionByType(ResourceType resourceType) {
        return this.library.getCollection().values().stream().filter(item -> item.getItemType().equals(resourceType))
                .toList();
    }

    public List<User> getAllUsers() {
        return this.library.getUsers().values().stream().toList();
    }

    public Rentable getResourceById(String id) {
        return this.library.getCollection().get(id);
    }
}
