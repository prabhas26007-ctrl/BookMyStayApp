// UC11: Concurrent Booking Simulation
// Goal: Simulate concurrent bookings and handle race conditions

import java.util.*;
import java.util.concurrent.locks.*;

class ThreadSafeBookingSystem {
    private Map<String, Integer> inventory;
    private Lock lock;
    
    public ThreadSafeBookingSystem() {
        this.inventory = new HashMap<>();
        inventory.put("Room-101", 1);
        this.lock = new ReentrantLock();
    }
    
    public boolean attemptBooking(String guestName, String roomId) {
        lock.lock();
        try {
            if (inventory.get(roomId) > 0) {
                Thread.sleep(100); // Simulate processing
                inventory.put(roomId, inventory.get(roomId) - 1);
                System.out.println(guestName + " successfully booked " + roomId);
                return true;
            } else {
                System.out.println(guestName + " failed - " + roomId + " not available");
                return false;
            }
        } catch (InterruptedException e) {
            return false;
        } finally {
            lock.unlock();
        }
    }
}

public class UC11_ConcurrentBookingSimulation {
    public static void main(String[] args) throws InterruptedException {
        ThreadSafeBookingSystem system = new ThreadSafeBookingSystem();
        
        Thread guest1 = new Thread(() -> system.attemptBooking("Alice", "Room-101"));
        Thread guest2 = new Thread(() -> system.attemptBooking("Bob", "Room-101"));
        
        System.out.println("Simulating concurrent bookings...");
        guest1.start();
        guest2.start();
        
        guest1.join();
        guest2.join();
        
        System.out.println("\nBooking simulation complete.");
    }
}
