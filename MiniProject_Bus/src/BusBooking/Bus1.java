package BusBooking;
import java.util.*;
import java.lang.*;

public class Bus1 {
    private String busId;
    private String source;
    private String destination;
    private String date;
    private int totalSeats;
    private int bookedSeats;

    public Bus1(String busId, String source, String destination, String date, int totalSeats) {
        this.busId = busId;
        this.source = source;
        this.destination = destination;
        this.date = date;
        this.totalSeats = totalSeats;
        this.bookedSeats = 0;
    }
    public String getBusId() {
        return busId;
    }
    public String getSource() {
        return source;
    }
    public String getDestination() {
        return destination;
    }
    public String getDate() {
        return date;
    }
    public int getTotalSeats() {
        return totalSeats;
    }
    public int getBookedSeats() {
        return bookedSeats;
    }
    public boolean bookSeats(int numberOfSeats) {
        if (bookedSeats + numberOfSeats <= totalSeats) {
            bookedSeats += numberOfSeats;
            return true;
        }
        return false;
    }
    public void cancelSeats(int numberOfSeats) {
        if (bookedSeats >= numberOfSeats) {
            bookedSeats -= numberOfSeats;
        }
    }
    public int getAvailableSeats() {
        return totalSeats - bookedSeats;
    }
}