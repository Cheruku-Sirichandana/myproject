package Admin;
//import Bookings.*;
import BusBooking.*;


import java.lang.*;
import java.util.Iterator;
import java.util.List;


public class AdminTicketBookingService implements AdminService {
    private List<Bus1> availableBuses;
    private final String adminPassword; // Add the admin password
    public AdminTicketBookingService(List<Bus1> availableBuses, String adminPassword) {
        this.availableBuses = availableBuses;
        this.adminPassword = adminPassword;
    }
    @Override
    public boolean verifyPassword(String password) {
        return adminPassword.equals(password);
    }
    @Override
    public void addBus(String busId, String source, String destination, String date, int totalSeats) {
        availableBuses.add(new Bus1(busId, source, destination, date, totalSeats));
        System.out.println("Bus added successfully.");
    }
    @Override
    public void removeBus(String busId) {
//        availableBuses.forEach(bus1 -> {
//            if (bus1.getBusId().equals(busId)) {
////                iterator.remove();
//                System.out.println("Bus removed successlly.");
//                return;
//            }
//                }
//        );


        Iterator<Bus1> iterator = availableBuses.iterator();
        while (iterator.hasNext()) {
            Bus1 bus = iterator.next();
            if (bus.getBusId().equals(busId)) {
                iterator.remove();
                System.out.println("Bus removed successlly.");
                return;
            }
        }
        System.out.println("Bus ID not found.");
    }
    @Override
    public void viewAllBookings() {
        System.out.println("All bookings:");
        for (Bus1 bus : availableBuses) {
            System.out.println("Bus ID: " + bus.getBusId() + ", Booked Seats: " + bus.getBookedSeats());
        }
    }
}
