package domainObjects;

import java.util.ArrayList;
import java.util.List;

import abstractions.Rentable;
import utilities.Utility.RentStatus;
import utilities.Utility.ResourceType;

public class DVD implements Rentable {

    private String id;
    private String name;
    private ResourceType type;
    private RentStatus status;
    private List<Transaction> transactions;

    public DVD(String id, String name) {
        this.id = id;
        this.name = name;
        this.type = ResourceType.DVD;
        this.status = RentStatus.Available;
        this.transactions = new ArrayList<Transaction>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ResourceType getType() {
        return type;
    }

    @Override
    public ResourceType getItemType() {
        return this.type;
    }

    @Override
    public boolean isAvailable() {
        return this.status.equals(RentStatus.Available);
    }

    @Override
    public void borrowItem() {
        this.status = RentStatus.Borrowed;
    }

    @Override
    public void returnItem() {
        this.status = RentStatus.Available;
    }

    @Override
    public void addNewTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }

    @Override
    public Transaction getLatestTransaction() {
        return this.transactions.getLast();
    }

    @Override
    public String toString() {
        return this.id + "\t" + this.name + "\t" + this.status;
    }

}
