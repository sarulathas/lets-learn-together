package domainObjects;

import java.util.HashMap;
import java.util.Map;

import abstractions.Rentable;

public class Library {
    private Map<String, Rentable> collection;
    private Map<String, User> users;

    public Library() {
        collection = new HashMap<String, Rentable>();
        users = new HashMap<String, User>();
    }

    public Library(Map<String, Rentable> collection, Map<String, User> users) {
        this.collection = collection;
        this.users = users;
    }

    public Map<String, Rentable> getCollection() {
        return collection;
    }

    public Map<String, User> getUsers() {
        return users;
    }

}
