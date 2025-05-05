package services.interfaces;

import abstractions.Rentable;
import exceptions.InvalidItemException;
import utilities.Utility.OperationStatus;

public interface ILibraryService {

    public OperationStatus borrowResource(Rentable item, String userId) throws InvalidItemException;

    public OperationStatus returnResource(Rentable item) throws InvalidItemException;
}
