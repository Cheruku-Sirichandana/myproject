package BusBooking;
import Admin.*;
import Bookings.*;


import java.util.*;
import java.lang.*;

public class BusBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Bus1> availableBuses = new ArrayList<>();
        TicketBookingService bookingService = new OnlineBusTicketBookingService(availableBuses);
       // String adminUserName="Dep1";
        String adminPassword = "12345";
        while (true) {
            System.out.println("\nBus Ticket Booking System");
            System.out.println("1. Get Available Buses\n2. Book a Ticket\n3.  Cancel Ticket\n4. Show Available Seats\n5.Show Booked Seats\n6. Admin Menu\n7. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Source: ");
                    String source = sc.next();
                    System.out.print("Enter Desination: ");
                    String destination = sc.next();
                    System.out.print("Enter Date (DD-MM-YYYY): ");
                    String date = sc.next();
                    bookingService.getAvailableBuses(source, destination, date);
                    break;
                case 2:
                    System.out.print("Enter Bus ID: ");
                    String busId = sc.next();
                    System.out.print("Enter Number of Seats: ");
                    int numberOfSeats = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Traveller Name: ");
                    String travelerName = sc.next();
                    bookingService.bookTicket(busId, numberOfSeats, new Traveler1(travelerName));
                    break;
                case 3:
                    System.out.print("Enter Bus ID: ");
                    String cancelBusId = sc.next();
                    System.out.print("Enter Number of Seats to Cancel: ");
                    int cancelSeats = sc.nextInt();
                    sc.nextLine();
                    bookingService.cancelTicket(cancelBusId, cancelSeats);
                    break;
                case 4:
                    System.out.print("Enter Bus ID: ");
                    String showAvailableBusId = sc.next();
                    bookingService.showAvailableSeats(showAvailableBusId);
                    break;
                case 5:
                    System.out.print("Enter Bus ID: ");
                    String showBookedBusId = sc.next();
                    bookingService.showBookedSeats(showBookedBusId);
                    break;
                case 6:
                   // System.out.println("Enter Username:");
                    //String enteredUsername=sc.next();
                    System.out.print("Enter admin password: ");
                    String enteredPassword = sc.next();
                    //only admin knows the password
                    //if(enteredUsername.equals(adminUsername) && (enteredPassword.equals(adminPassword))
                    if (enteredPassword.equals(adminPassword)) {
                        AdminService adminService = new AdminTicketBookingService(availableBuses, adminPassword);
                        System.out.println("\nAdmin Menu");
                        System.out.println("1. Add Bus\n2. Remove Bus\n3. View All Bookings");
                        System.out.print("Enter your choice: ");
                        int adminChoice = sc.nextInt();
                        sc.nextLine();
                        switch (adminChoice) {
                            case 1:
                                System.out.print("Enter Bus ID: ");
                                String adminBusId = sc.next();
                                System.out.print("Enter Source: ");
                                String adminSource = sc.next();
                                System.out.print("Enter Destinattion: ");
                                String adminDestination = sc.next();
                                System.out.print("Enter Date (DD-MM-YYYY): ");
                                String adminDate = sc.next();
                                System.out.print("Enter Total Seats: ");
                                int adminTotalSeats = sc.nextInt();
                                sc.nextLine();
                                adminService.addBus(adminBusId, adminSource, adminDestination, adminDate, adminTotalSeats);
                                break;
                            case 2:
                                System.out.print("Enter Bus ID to remove: ");
                                String removeBusId = sc.next();
                                adminService.removeBus(removeBusId);
                                break;
                            case 3:
                                adminService.viewAllBookings();
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                                break;
                        }}
                    break;
                case 7:
                    System.out.println("Exiting the system.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}