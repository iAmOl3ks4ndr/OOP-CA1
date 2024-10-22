package org.example;

import java.util.Comparator;

public class SurvivedWithinFareSort implements Comparator<Passenger> {

    // Task 14
    public int compare(Passenger passenger1, Passenger passenger2) {
        if (passenger1.getFare() == passenger2.getFare())
            return Integer.compare(passenger1.getSurvived(), passenger2.getSurvived());
        else {
            return Double.compare(passenger1.getFare(), passenger2.getFare());
        }
    }
}
