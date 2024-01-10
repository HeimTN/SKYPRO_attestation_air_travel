package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class DepartCurrentTimePointFilter implements AirTravelFilter{
    @Override
    public String filterName() {
        return "Filter: Departure up to the current point in time";
    }

    @Override
    public List<Flight> filteredAirTravels(List<Flight> flights) {
        LocalDateTime time = LocalDateTime.now();
        return flights.stream()
                .filter(flight -> flight.getSegments().stream().allMatch(segment -> segment.getDepartureDate().isAfter(time)))
                .collect(Collectors.toList());
    }
}
