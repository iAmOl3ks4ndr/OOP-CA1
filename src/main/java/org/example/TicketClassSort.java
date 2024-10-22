package org.example;

import java.util.Comparator;

public class TicketClassSort implements Comparator<Passenger> {

    // Task 15
    public int compare(Passenger passenger1, Passenger passenger2) {
        int p1Class, p2Class;

        if(passenger1.getClass().equals(PassengerClass.FIRST)) {
            p1Class = 1;
        }
        else if(passenger1.getClass().equals(PassengerClass.SECOND)) {
            p1Class = 2;
        }
        else if(passenger1.getClass().equals(PassengerClass.THIRD)) {
            p1Class = 3;
        }
        else {
            p1Class = 4;
        }

        if(passenger2.getClass().equals(PassengerClass.FIRST)) {
            p2Class = 1;
        }
        else if(passenger2.getClass().equals(PassengerClass.SECOND)) {
            p2Class = 2;
        }
        else if(passenger2.getClass().equals(PassengerClass.THIRD)) {
            p2Class = 3;
        }
        else {
            p2Class = 4;
        }

        return Integer.compare(p1Class, p2Class);
    }
}
