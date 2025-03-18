package services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import abstractions.Rentable;
import domainObjects.User;
import utilities.Utility.OperationStatus;
import utilities.Utility.ResourceType;

public class ResourcesService {

    // can be list of rentable collection instead of a map
    private Map<String, Rentable> collection; // should it belong to the domain or the use case?
    private Map<String, User> users; // can be maintained as a list

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

    // auto-generate ids and use items in list
    // handle duplicate name
    public OperationStatus addNewLibraryResource(String id, Rentable item) {
        if (this.collection.containsKey(id)) {
            // throw exception
            System.out.println("Id already exists!");
            return OperationStatus.FAILURE;
        }
        this.collection.put(id, item);
        System.out.println(item);
        return OperationStatus.SUCCESS;
    }

    public void addNewUser(User newUser) {
        this.users.put(newUser.getUserId(), newUser);
    }

    public List<Rentable> getAllCollection() {
        return this.collection.values().stream().toList();
    }

    // use the class type instead of resource type
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
