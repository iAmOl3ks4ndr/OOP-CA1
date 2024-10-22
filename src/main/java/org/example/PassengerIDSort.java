package org.example;

import java.util.Comparator;

public class PassengerIDSort implements Comparator<Passenger> {

    // Task 20
    public int compare(Passenger passenger1, Passenger passenger2) {
        return passenger1.getPassengerId().compareTo(passenger2.getPassengerId());
    }
}
