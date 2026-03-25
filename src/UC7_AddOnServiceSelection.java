// UC7: Add-On Service Selection
// Goal: Extend the booking model to support optional services

import java.util.*;

class AddOnService {
    private String serviceName;
    private double cost;
    
    public AddOnService(String serviceName, double cost) {
        this.serviceName = serviceName;
        this.cost = cost;
    }
    
    public String getServiceName() { return serviceName; }
    public double getCost() { return cost; }
}

class AddOnServiceManager {
    private Map<String, List<AddOnService>> reservationServices;
    
    public AddOnServiceManager() {
        this.reservationServices = new HashMap<>();
    }
    
    public void addServiceToReservation(String reservationId, AddOnService service) {
        reservationServices.putIfAbsent(reservationId, new ArrayList<>());
        reservationServices.get(reservationId).add(service);
        System.out.println("Added " + service.getServiceName() + " to reservation " + reservationId);
    }
    
    public double calculateAdditionalCost(String reservationId) {
        if (!reservationServices.containsKey(reservationId)) return 0.0;
        return reservationServices.get(reservationId).stream()
            .mapToDouble(AddOnService::getCost).sum();
    }
    
    public List<AddOnService> getServices(String reservationId) {
        return reservationServices.getOrDefault(reservationId, new ArrayList<>());
    }
}

public class UC7_AddOnServiceSelection {
    public static void main(String[] args) {
        AddOnServiceManager manager = new AddOnServiceManager();
        
        // Demonstrate add-on service selection
        AddOnService breakfast = new AddOnService("Breakfast", 15.0);
        AddOnService parking = new AddOnService("Parking", 20.0);
        AddOnService spa = new AddOnService("Spa Access", 50.0);
        
        String reservationId = "RES001";
        manager.addServiceToReservation(reservationId, breakfast);
        manager.addServiceToReservation(reservationId, parking);
        manager.addServiceToReservation(reservationId, spa);
        
        double totalCost = manager.calculateAdditionalCost(reservationId);
        System.out.println("\nTotal additional cost for " + reservationId + ": $" + totalCost);
        
        System.out.println("\nServices for reservation " + reservationId + ":");
        for (AddOnService service : manager.getServices(reservationId)) {
            System.out.println("- " + service.getServiceName() + ": $" + service.getCost());
        }
    }
}
