package com.gridnine.testing;

import java.util.List;
import java.util.stream.Collectors;

public class ArrivalEarlierDepartDateFilter implements AirTravelFilter{
    @Override
    public String filterName() {
        return "Filter: Segments with arrival date earlier than departure date";
    }

    @Override
    public List<Flight> filteredAirTravels(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> flight.getSegments().stream().allMatch(segment -> segment.getArrivalDate().isAfter(segment.getDepartureDate())))
                .collect(Collectors.toList());
    }
}
