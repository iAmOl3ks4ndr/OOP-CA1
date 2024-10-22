package org.example;

import java.util.Comparator;

public class NumberWithinGenderSort implements Comparator<Passenger> {

    // Task 13
    public int compare(Passenger passenger1, Passenger passenger2) {
        if (passenger1.getGender().equals(passenger2.getGender()))
            return passenger1.getPassengerId().compareTo(passenger2.getPassengerId());
        else {
            return passenger1.getGender().compareTo(passenger2.getGender());
        }
    }
}
