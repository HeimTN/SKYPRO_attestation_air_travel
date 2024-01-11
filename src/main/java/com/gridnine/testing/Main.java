package com.gridnine.testing;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();

        List<AirTravelFilter> filters = Arrays.asList(
                new DepartCurrentTimePointFilter(),
                new ArrivalEarlierDepartDateFilter(),
                new TotalTimeExceedsTwoHoursFilter()
        );

        System.out.println("Initial flight list without filters");
        System.out.println(flights);

        filters.forEach(filter -> {
            List<Flight> filteredFlights = filter.filteredAirTravels(flights);
            System.out.println(filter.filterName());
            System.out.println(filteredFlights);
        });
    }
}