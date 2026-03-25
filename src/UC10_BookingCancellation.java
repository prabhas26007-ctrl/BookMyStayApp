// UC10: Booking Cancellation & Inventory Rollback
// Goal: Allow cancellation and restore room inventory

import java.util.*;

class RoomInventory {
    private Map<String, Integer> availableRooms;
    
    public RoomInventory() {
        this.availableRooms = new HashMap<>();
        availableRooms.put("Deluxe", 10);
        availableRooms.put("Suite", 5);
    }
    
    public boolean bookRoom(String roomType) {
        if (availableRooms.getOrDefault(roomType, 0) > 0) {
            availableRooms.put(roomType, availableRooms.get(roomType) - 1);
            return true;
        }
        return false;
    }
    
    public void cancelBooking(String roomType) {
        availableRooms.put(roomType, availableRooms.get(roomType) + 1);
        System.out.println("Cancelled booking for " + roomType + ". Inventory restored.");
    }
    
    public void printInventory() {
        System.out.println("\nCurrent Inventory:");
        for (Map.Entry<String, Integer> entry : availableRooms.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " rooms");
        }
    }
}

public class UC10_BookingCancellation {
    public static void main(String[] args) {
        RoomInventory inventory = new RoomInventory();
        
        System.out.println("Initial state:");
        inventory.printInventory();
        
        System.out.println("\nBooking a Deluxe room...");
        inventory.bookRoom("Deluxe");
        inventory.printInventory();
        
        System.out.println("\nCancelling the Deluxe booking...");
        inventory.cancelBooking("Deluxe");
        inventory.printInventory();
    }
}
