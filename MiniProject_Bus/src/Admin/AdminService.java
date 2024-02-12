package Admin;


public interface AdminService {
    boolean verifyPassword(String password);
    void addBus(String busId, String source, String destination, String date, int totalSeats);
    void removeBus(String busId);
    void viewAllBookings();
}