package services.implementation;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import abstractions.Rentable;
import domainObjects.Transaction;
import exceptions.InvalidItemException;
import services.interfaces.ILibraryService;
import services.utilities.Constants;
import utilities.Utility.OperationStatus;

public class LibraryService implements ILibraryService {

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public LibraryService() {
    }

    public OperationStatus borrowResource(Rentable item, String userId) throws InvalidItemException {
        if (!item.isAvailable()) {
            // throw as exception
            throw new InvalidItemException("Requested item is not available");
            // System.out.println("Requested item is not available"); // change message
            // return OperationStatus.FAILURE;
        }
        // change these back to DateTime
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
        // 14 to be extracted to constant in a separate folder under service
        calendar.add(Calendar.DATE, Constants.MAX_DAYS_TO_BORROW);
        Date dueDate = calendar.getTime();
        return dueDate;
    }

    public OperationStatus returnResource(Rentable item) throws InvalidItemException {
        /* TO DO: check for overdue and fines */
        if (item.isAvailable()) {
            // throw exceptions and handle it outside
            throw new InvalidItemException("Item is not borrowed.");
            // System.out.println("Item is not borrowed.");
            // return OperationStatus.FAILURE;
        }

        item.getLatestTransaction().setIsReturned(true);
        item.returnItem();
        return OperationStatus.SUCCESS;
    }

}
