package org.example;
// CA1
import java.io. * ;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        String fileName = "titanic-data-100.csv"; // file should be in the project folder (below pom.xml)

        ArrayList<Passenger> passengerList= new ArrayList<>();

        loadPassengerDataFromFile( passengerList, fileName);

        displayAllPassengers( passengerList );


        // Assignment: Implement and test the following methods.
        // See the description of each method in the CA1 Specification PDF file from Moodle

        getPassengerNames(passengerList);
        getPassengersContainingName(passengerList, "William");
        getPassengersOlderThan(passengerList, 30);
        countPassengersByGender(passengerList, "Female");
        sumFares(passengerList);
        maleSurvivors(passengerList);
        ticketOwner(passengerList, "William");
        averageAge(passengerList);
        getPassengersByTicketClass(passengerList, PassengerClass.FIRST);
        sortPassengersByPassengerId(passengerList);
        sortPassengersByName(passengerList);
        sortPassengersByAgeThenName(passengerList);
        sortPassengersByGenderThenPassengerNumber(passengerList);
        sortPassengersByFareThenSurvival(passengerList);
        sortPassengersByTicketClass(passengerList);
        sortPassengersByAge(passengerList);
        sortPassengersByTicketNumberLambda(passengerList);
        sortPassengersByTicketNumberStatic(passengerList);
        findPassengerByTicketNumber(passengerList, passengerList.get(12));
        findPassengerByPassengerId(passengerList, passengerList.get(78));

        System.out.println("Finished, Goodbye!");
    }

    /**
     * Populate an ArrayList of Passenger objects with data from a text file
     * @param passengerList - an ArrayList to be filled with Passenger objects
     * @param fileName - name of CSV text file containing passenger details
     */
    public static void loadPassengerDataFromFile( ArrayList<Passenger> passengerList, String fileName) {

        // Format of each row of data is:
        // Name,Age,Height(m),GPA  - these heading names are included as the first row in file
        // John Malone,20,1.78,3.55   for example

        // Use a Regular Expression to set both comma and newline as delimiters.
        //  sc.useDelimiter("[,\\r\\n]+");
        // Text files in windows have lines ending with "CR-LF" or "\r\n" sequences.
        // or may have only a newline - "\n"
        // Windows uses CRLF (\r\n, 0D 0A) line endings while Unix just uses LF (\n, 0A).
        //
        try (Scanner sc = new Scanner(new File(fileName))
                .useDelimiter("[,\\r\\n]+"))
        {

            // skip past the first line, as it has field names (not data)
            if(sc.hasNextLine())
                sc.nextLine();   // read the header line containing column titles, but don't use it

            // while there is a next token to read....
            System.out.println("Go...");

            while (sc.hasNext())
            {
                String passengerId = sc.next();    // read passenger ID
                int survived = sc.nextInt();     // 0=false, 1=true
                int passengerClass = sc.nextInt();  // passenger class, 1=1st, 2=2nd or 3rd
                String name = sc.next();
                String gender = sc.next();
                int age = sc.nextInt();
                int siblingsAndSpouses = sc.nextInt();
                int parentsAndChildren = sc.nextInt();
                String ticketNumber = sc.next();
                double fare = sc.nextDouble();
                String cabin = sc.next();
                String embarkedAt = sc.next();

                System.out.println(passengerId +", " + name);

                passengerList.add(
                        new Passenger( passengerId, survived, passengerClass,
                                name, gender, age, siblingsAndSpouses,parentsAndChildren,ticketNumber,
                                fare, cabin, embarkedAt)
                );
            }
        } catch (FileNotFoundException exception)
        {
            System.out.println("FileNotFoundException caught. The file " +fileName+ " may not exist." + exception);
        }
    }

    public static void displayAllPassengers( ArrayList<Passenger> passengerList ) {
        System.out.println("Displaying all passengers:");
        for( Passenger passenger : passengerList)
        {
            System.out.println(passenger);
        }
    }

    // Task 1
    public static String[] getPassengerNames(ArrayList<Passenger> passengerList) {
        String[] passengerNames = new String[passengerList.size()];

        for(int i = 0; i < passengerList.size(); i++) {
            passengerNames[i] = passengerList.get(i).getName();
        }

        return passengerNames;
    }

    // Task 2
    public static ArrayList<Passenger> getPassengersContainingName(ArrayList<Passenger> passengerList, String name) {
        ArrayList<Passenger> passengers = new ArrayList<>();

        for(Passenger passenger : passengerList) {
            if(passenger.getName().contains(name)) {
                passengers.add(passenger);
            }
        }

        return passengers;
    }

    // Task 3
    public static ArrayList<Passenger> getPassengersOlderThan(ArrayList<Passenger> passengerList, int age) {
        ArrayList<Passenger> passengers = new ArrayList<>();

        for(Passenger passenger : passengerList) {
            if(passenger.getAge() > age) {
                passengers.add(passenger);
            }
        }

        return passengers;
    }

    // Task 4 (ASK ABOUT PARAMETERS)
    public static ArrayList<Passenger> countPassengersByGender(ArrayList<Passenger> passengerList, String gender) {
        ArrayList<Passenger> passengers = new ArrayList<>();

        for(Passenger passenger : passengerList) {
            if(passenger.getGender().equals(gender)) {
                passengers.add(passenger);
            }
        }

        return passengers;
    }

    // Task 5
    public static double sumFares(ArrayList<Passenger> passengerList) {
        ArrayList<Passenger> passengers = new ArrayList<>();
        double total = 0;

        for(Passenger passenger : passengerList) {
            total += passenger.getFare();
        }

        return total;
    }

    // Task 6
    public static String[] maleSurvivors(ArrayList<Passenger> passengerList) {
        String[] passengerNames = new String[passengerList.size()];

        for(int i = 0; i < passengerList.size(); i++) {
            if(passengerList.get(i).getGender().equals("Male") && passengerList.get(i).getSurvived() == 1) {
                passengerNames[i] = passengerList.get(i).getName();
            }
        }

        return passengerNames;
    }

    // Task 7
    public static Passenger ticketOwner(ArrayList<Passenger> passengerList, String ticketNumber) {
        Passenger passengerOwner = null;

        for(Passenger passenger : passengerList) {
            if(passenger.getTicketNumber().equals(ticketNumber)) {
                passengerOwner = passenger;
            }
        }

        return passengerOwner;
    }

    // Task 8
    public static double averageAge(ArrayList<Passenger> passengerList) {
        double total = 0;

        for(Passenger passenger : passengerList) {
            total += passenger.getAge();
        }

        return total / passengerList.size();
    }

    // Task 9
    public static ArrayList<Passenger> getPassengersByTicketClass(ArrayList<Passenger> passengerList, PassengerClass passengerClass) {
        ArrayList<Passenger> passengers = new ArrayList<>();

        for(Passenger passenger : passengerList) {
            if(passenger.getPassengerClass().equals(passengerClass)) {
                passengers.add(passenger);
            }
        }

        return passengers;
    }

    // Task 10
    public static ArrayList<Passenger> sortPassengersByPassengerId(ArrayList<Passenger> passengerList) {
        ArrayList<Passenger> passengers = passengerList;

        Collections.sort(passengers);

        return passengers;
    }

    // Task 11
    public static ArrayList<Passenger> sortPassengersByName(ArrayList<Passenger> passengerList) {
        ArrayList<Passenger> passengers = passengerList;

        passengers.sort((passenger1, passenger2) -> passenger1.getName().compareTo(passenger2.getName()));

        return passengers;
    }

    // Task 12
    public static ArrayList<Passenger> sortPassengersByAgeThenName(ArrayList<Passenger> passengerList) {
        ArrayList<Passenger> passengers = passengerList;

        Collections.sort(passengers, new NameWithinAgeSort());

        return passengers;
    }

    // Task 13
    public static ArrayList<Passenger> sortPassengersByGenderThenPassengerNumber(ArrayList<Passenger> passengerList) {
        ArrayList<Passenger> passengers = passengerList;

        Collections.sort(passengers, new NumberWithinGenderSort());

        return passengers;
    }

    // Task 14
    public static ArrayList<Passenger> sortPassengersByFareThenSurvival(ArrayList<Passenger> passengerList) {
        ArrayList<Passenger> passengers = passengerList;

        Collections.sort(passengers, new SurvivedWithinFareSort());

        return passengers;
    }

    // Task 15
    public static ArrayList<Passenger> sortPassengersByTicketClass(ArrayList<Passenger> passengerList) {
        ArrayList<Passenger> passengers = passengerList;

        Collections.sort(passengers, new TicketClassSort());

        return passengers;
    }

    // Task 16
    public static ArrayList<Passenger> sortPassengersByAge(ArrayList<Passenger> passengerList) {
        ArrayList<Passenger> passengers = passengerList;

        Collections.sort(passengers, new Comparator<Passenger>() {
            @Override
            public int compare(Passenger passenger1, Passenger passenger2) {
                return Integer.compare(passenger1.getAge(), passenger2.getAge());
            }
        });

        return passengers;
    }

    // Task 17
    public static ArrayList<Passenger> sortPassengersByTicketNumberLambda(ArrayList<Passenger> passengerList) {
        ArrayList<Passenger> passengers = passengerList;

        passengers.sort((Passenger passenger1, Passenger passenger2) -> passenger1.getTicketNumber().compareTo(passenger2.getTicketNumber()));

        return passengers;
    }

    // Task 18
    public static ArrayList<Passenger> sortPassengersByTicketNumberStatic(ArrayList<Passenger> passengerList) {
        ArrayList<Passenger> passengers = passengerList;

        passengers.sort(Passenger::compareByTicketNumber);

        return passengers;
    }

    // Task 19
    public static Passenger findPassengerByTicketNumber(ArrayList<Passenger> passengerList, Passenger passengerWithTicketNumber) {
        Passenger found = null;

        Passenger[] passengers = new Passenger[passengerList.size()];

        for(int i = 0; i < passengerList.size(); i++) {
            passengers[i] = passengerList.get(i);
        }

        Arrays.sort(passengers, new TicketNumberSort());

        int index = Arrays.binarySearch(passengers, passengerWithTicketNumber, new TicketNumberSort());

        if(index >= 0) {
            found = passengerList.get(index);
        }

        return found;
    }

    // Task 20
    public static Passenger findPassengerByPassengerId(ArrayList<Passenger> passengerList, Passenger passengerWithID) {
        Passenger found = null;

        Passenger[] passengers = new Passenger[passengerList.size()];

        for(int i = 0; i < passengerList.size(); i++) {
            passengers[i] = passengerList.get(i);
        }

        Arrays.sort(passengers, new PassengerIDSort());

        int index = Arrays.binarySearch(passengers, passengerWithID, new PassengerIDSort());

        if(index >= 0) {
            found = passengerList.get(index);
        }

        return found;
    }
}
