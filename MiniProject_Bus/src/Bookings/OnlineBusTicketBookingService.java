package Bookings;
import BusBooking.Bus1;
import BusBooking.Traveler1;


import java.lang.*;
import java.util.*;

public class OnlineBusTicketBookingService implements TicketBookingService {
    private List<Bus1> availableBuses;
    public OnlineBusTicketBookingService(List<Bus1> availableBuses) {
        this.availableBuses = availableBuses;
    }
    @Override
    public void getAvailableBuses(String source, String destination, String date) {
        System.out.println("Available buses for " + date + " from " + source + " to " + destination + ":");
        for (Bus1 bus : availableBuses) {
            if (bus.getSource().equals(source) && bus.getDestination().equals(destination) && bus.getDate().equals(date)) {
                System.out.println("Bus ID: " + bus.getBusId() + ", Available Seats: " + bus.getAvailableSeats());
            }
        }
    }
    @Override
    public void bookTicket(String busId, int numberOfSeats, Traveler1 traveler1) {
//        availableBuses.forEach(bus -> {
//            if (bus.getBusId().equals(busId)) {
//                if (bus.bookSeats(numberOfSeats)) {
//                    System.out.println("Ticket booked successfully for " + traveler1.getName() + ".");
//                    System.out.println("Booking Details - Bus ID: " + busId + ", Number of Seats: " + numberOfSeats);
//                } else {
//                    System.out.println(traveler1.getName()+",There are  not enough seats available on this bus.");
//                }
//                return;
//            }
//        }
// );

        for (Bus1 bus : availableBuses) {
            if (bus.getBusId().equals(busId)) {
                if (bus.bookSeats(numberOfSeats)) {
                    System.out.println("Ticket booked successfully for " + traveler1.getName() + ".");
                    System.out.println("Booking Details - Bus ID: " + busId + ", Number of Seats: " + numberOfSeats);
                } else {
                    System.out.println(traveler1.getName()+",There are  not enough seats available on this bus.");
                }
                return;
            }
        }
        System.out.println("Invalid Bus ID.");
    }
    @Override
    public void cancelTicket(String busId, int numberOfSeats) {
        for (Bus1 bus : availableBuses) {
            if (bus.getBusId().equals(busId)) {
                bus.cancelSeats(numberOfSeats);
                System.out.println("Ticket cancellled successfully.");
                return;
            }
        }
        System.out.println("Invalid Bus ID.");
    }
    @Override
    public void showAvailableSeats(String busId) {
        for (Bus1 bus : availableBuses) {
            if (bus.getBusId().equals(busId)) {
                System.out.println("Available seats for Bus ID " + busId + ": " + bus.getAvailableSeats());
                return;
            }
        }
        System.out.println("Invalid Bus ID.");
    }
    @Override
    public void showBookedSeats(String busId) {
        for (Bus1 bus : availableBuses) {
            if (bus.getBusId().equals(busId)) {
                System.out.println("Booked seats for Bus ID " + busId + ": " + bus.getBookedSeats());
                return;
            }
        }
        System.out.println("Invalid Bus ID.");
    }
}