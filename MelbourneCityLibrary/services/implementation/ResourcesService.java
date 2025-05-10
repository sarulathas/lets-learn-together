package services.implementation;

import java.util.ArrayList;
import java.util.List;
import abstractions.Rentable;
import domainObjects.User;
import services.interfaces.IResourcesService;
import utilities.Utility.OperationStatus;
import utilities.Utility.ResourceType;

public class ResourcesService implements IResourcesService {

    // can be list of rentable collection instead of a map
    // private Map<String, Rentable> collection; // should it belong to the domain
    // or the use case?
    // private Map<String, User> users; // can be maintained as a list

    private List<Rentable> collection;
    private List<User> users;

    public ResourcesService() {
        this.collection = new ArrayList<Rentable>();
        this.users = new ArrayList<User>();
    }

    public ResourcesService(ArrayList<Rentable> collection, ArrayList<User> users) {
        this.collection = collection;
        this.users = users;
    }

    public List<Rentable> getCollection() {
        return this.collection;
    }

    public List<User> getUsers() {
        return this.users;
    }

    // auto-generate ids and use items in list
    // handle duplicate name
    public OperationStatus addNewLibraryResource(Rentable item) {
        // if (this.collection.containsKey(id)) {
        // // throw exception
        // System.out.println("Id already exists!");
        // return OperationStatus.FAILURE;
        // }
        this.collection.add(item);
        System.out.println(item);
        return OperationStatus.SUCCESS;
    }

    public void addNewUser(User newUser) {
        this.users.add(newUser);
    }

    public List<Rentable> getAllCollection() {
        return this.collection.stream().toList();
    }

    // use the class type instead of resource type
    public List<Rentable> getCollectionByType(ResourceType resourceType) {
        return this.collection.stream().filter(item -> item.getItemType().equals(resourceType)).toList();
    }

    public List<User> getAllUsers() {
        return this.users.stream().toList();
    }

    public Rentable getResourceById(String id) {
        return this.collection.stream().filter(item -> item.getId().equals(id)).toList().get(0);
    }
}
