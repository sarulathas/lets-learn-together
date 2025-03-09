package services;

import java.util.Calendar;
import java.util.Date;

import abstractions.Rentable;
import domainObjects.Transaction;
import utilities.Utility.OperationStatus;

public class LibraryService {

    public LibraryService() {
    }

    public OperationStatus borrowResource(Rentable item, String userId) {
        if (!item.isAvailable()) {
            System.out.println("Requested item is not available"); // change message
            return OperationStatus.FAILURE;
        }
        Date borrowedDate = new Date();
        Date dueDate = computeDueDate();
        Transaction newTrasaction = new Transaction(item, userId, borrowedDate, dueDate);
        item.addNewTransaction(newTrasaction);
        item.borrowItem();
        System.out.println("Item is due on " + dueDate);
        return OperationStatus.SUCCESS;
    }

    private Date computeDueDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 14);
        Date dueDate = calendar.getTime();
        return dueDate;
    }

    public OperationStatus returnResource(Rentable item) {
        /* TO DO: check for overdue and fines */
        if (item.isAvailable()) {
            System.out.println("Item is not borrowed.");
            return OperationStatus.FAILURE;
        }

        item.getLatestTransaction().setIsReturned(true);
        item.returnItem();
        return OperationStatus.SUCCESS;
    }

}
