package org.airport;
public class Main {
    public static void main(String[] args) {
        BinarySearchTreeAirport airport = new BinarySearchTreeAirport();
        int[] plannedLandings = {5, 20, 41, 47, 48, 50, 54, 58};

        for (int landingTime : plannedLandings) {
            airport.reserveLanding(landingTime);
            airport.updateFlights();
        }
        airport.printLandingSchedule();
    }
}