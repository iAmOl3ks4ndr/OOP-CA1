package org.example;

import java.util.Comparator;

public class TicketNumberSort implements Comparator<Passenger> {

    // Task 19
    public int compare(Passenger passenger1, Passenger passenger2) {
        return passenger1.getTicketNumber().compareTo(passenger2.getTicketNumber());
    }
}
