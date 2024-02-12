package Bookings;

import BusBooking.Traveler1;

public interface TicketBookingService {
    void getAvailableBuses(String source, String destination, String date);
    void bookTicket(String busId, int numberOfSeats, Traveler1 traveler1);
    void cancelTicket(String busId, int numberOfSeats);
    void showAvailableSeats(String busId);
    void showBookedSeats(String busId);
}