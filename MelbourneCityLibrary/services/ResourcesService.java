package services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import abstractions.Rentable;
import domainObjects.Book;
import domainObjects.User;
import utilities.Utility.ResourceType;

public class ResourcesService {

    private Map<String, Rentable> collection;
    private Map<String, User> users;

    public ResourcesService() {
        this.collection = new HashMap<String, Rentable>();
        this.users = new HashMap<String, User>();
    }

    public ResourcesService(Map<String, Rentable> collection, Map<String, User> users) {
        this.collection = collection;
        this.users = users;
    }

    public Map<String, Rentable> getCollection() {
        return this.collection;
    }

    public Map<String, User> getUsers() {
        return this.users;
    }

    public void addNewLibraryResource(String id, Rentable item) {
        this.collection.put(id, item);
        System.out.println(item);
    }

    public void addNewUser(User newUser) {
        this.users.put(newUser.getUserId(), newUser);
    }

    public List<Rentable> getAllCollection() {
        return this.collection.values().stream().toList();
    }

    public List<Rentable> getCollectionByType(ResourceType resourceType) {
        return this.collection.values().stream().filter(item -> item.getItemType().equals(resourceType)).toList();
    }

    public List<User> getAllUsers() {
        return this.users.values().stream().toList();
    }

    public Rentable getResourceById(String id) {
        return this.collection.get(id);
    }
}
