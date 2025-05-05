package abstractions;

import java.util.UUID;

import domainObjects.Transaction;
import utilities.Utility.ResourceType;

public interface Rentable {

    public ResourceType getItemType();

    public boolean isAvailable();

    public void borrowItem();

    public void returnItem();

    public void addNewTransaction(Transaction transaction);

    public Transaction getLatestTransaction();

    public UUID getId();
}
