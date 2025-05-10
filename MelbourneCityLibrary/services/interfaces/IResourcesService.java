package services.interfaces;

import java.util.List;
import abstractions.Rentable;
import domainObjects.User;
import utilities.Utility.OperationStatus;
import utilities.Utility.ResourceType;

public interface IResourcesService {

    public OperationStatus addNewLibraryResource(Rentable item);

    public void addNewUser(User newUser);

    public List<Rentable> getAllCollection();

    public List<User> getAllUsers();

    public Rentable getResourceById(String id);

    public List<Rentable> getCollection();

    public List<User> getUsers();

    public List<Rentable> getCollectionByType(ResourceType resourceType);

}
