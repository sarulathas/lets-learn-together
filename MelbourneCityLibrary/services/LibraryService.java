package services;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import abstractions.Rentable;
import domainObjects.Transaction;
import utilities.Utility.OperationStatus;

public class LibraryService {
    
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public LibraryService() {
    }

    public OperationStatus borrowResource(Rentable item, String userId) {
        if (!item.isAvailable()) {
            // throw as exception
            System.out.println("Requested item is not available"); // change message
            return OperationStatus.FAILURE;
        }
        // change these back to DateTime
        String borrowedDate = dateFormat.format(new Date());
        String dueDate = dateFormat.format(computeDueDate());
        Transaction newTrasaction = new Transaction(item, userId, borrowedDate, dueDate);

        item.addNewTransaction(newTrasaction);
        item.borrowItem();

        System.out.println("Item is due on " + dueDate);
        return OperationStatus.SUCCESS;
    }

    private Date computeDueDate() {
        Calendar calendar = Calendar.getInstance();
        // 14 to be extracted to constant in a separate folder under service
        calendar.add(Calendar.DATE, 14);
        Date dueDate = calendar.getTime();
        return dueDate;
    }

    public OperationStatus returnResource(Rentable item) {
        /* TO DO: check for overdue and fines */
        if (item.isAvailable()) {
            // throw exceptions and handle it outside
            System.out.println("Item is not borrowed.");
            return OperationStatus.FAILURE;
        }

        item.getLatestTransaction().setIsReturned(true);
        item.returnItem();
        return OperationStatus.SUCCESS;
    }

}
