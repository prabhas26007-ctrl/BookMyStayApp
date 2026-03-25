// UC12: Data Persistence & System Recovery
// Goal: Implement data persistence and recovery mechanisms

import java.util.*;
import java.io.*;

class BookingPersistence {
    private static final String FILE_PATH = "bookings.txt";
    
    public void saveBookings(List<String> bookings) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {
            for (String booking : bookings) {
                writer.println(booking);
            }
            System.out.println("Bookings saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving bookings: " + e.getMessage());
        }
    }
    
    public List<String> loadBookings() {
        List<String> bookings = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                bookings.add(line);
            }
            System.out.println("Bookings loaded successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("No previous bookings found.");
        } catch (IOException e) {
            System.err.println("Error loading bookings: " + e.getMessage());
        }
        return bookings;
    }
}

public class UC12_DataPersistence {
    public static void main(String[] args) {
        BookingPersistence persistence = new BookingPersistence();
        
        // Create sample bookings
        List<String> bookings = new ArrayList<>();
        bookings.add("RES001:John Doe:Room-101:2026-03-27");
        bookings.add("RES002:Jane Smith:Room-102:2026-03-28");
        
        // Save bookings
        System.out.println("Saving bookings...");
        persistence.saveBookings(bookings);
        
        // Load bookings (simulating system recovery)
        System.out.println("\nSimulating system recovery...");
        List<String> loadedBookings = persistence.loadBookings();
        
        System.out.println("\nLoaded bookings:");
        for (String booking : loadedBookings) {
            System.out.println(booking);
        }
    }
}
