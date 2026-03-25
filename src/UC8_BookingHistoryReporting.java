// UC8: Booking History & Reporting
// Goal: Track and report booking history

import java.util.*;
import java.time.LocalDateTime;

class BookingRecord {
    String reservationId;
    String guestName;
    LocalDateTime bookingDate;
    String status;
    
    public BookingRecord(String reservationId, String guestName, String status) {
        this.reservationId = reservationId;
        this.guestName = guestName;
        this.bookingDate = LocalDateTime.now();
        this.status = status;
    }
}

class BookingHistoryManager {
    private List<BookingRecord> bookingHistory;
    
    public BookingHistoryManager() {
        this.bookingHistory = new ArrayList<>();
    }
    
    public void addBooking(BookingRecord record) {
        bookingHistory.add(record);
        System.out.println("Recorded booking: " + record.reservationId);
    }
    
    public void printReport() {
        System.out.println("\n=== Booking History Report ===");
        for (BookingRecord record : bookingHistory) {
            System.out.println(record.reservationId + " - " + record.guestName + " - " + record.status);
        }
        System.out.println("Total bookings: " + bookingHistory.size());
    }
}

public class UC8_BookingHistoryReporting {
    public static void main(String[] args) {
        BookingHistoryManager manager = new BookingHistoryManager();
        
        manager.addBooking(new BookingRecord("RES001", "John Doe", "Confirmed"));
        manager.addBooking(new BookingRecord("RES002", "Jane Smith", "Cancelled"));
        manager.addBooking(new BookingRecord("RES003", "Bob Johnson", "Confirmed"));
        
        manager.printReport();
    }
}
