package org.example;

import java.util.Comparator;

public class NameWithinAgeSort implements Comparator<Passenger> {

    // Task 12
    public int compare(Passenger passenger1, Passenger passenger2) {
        if (passenger1.getAge() == passenger2.getAge())
            return passenger1.getName().compareTo(passenger2.getName());
        else {
            return Integer.compare(passenger1.getAge(), passenger2.getAge());
        }
    }
}
