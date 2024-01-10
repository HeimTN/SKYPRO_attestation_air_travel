package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
/**
 * The {@code DepartCurrentTimePointFilter} class implements the {@code AirTravelFilter} interface
 * and filters flights based on the departure time criteria up to the current point in time.
 */
public class DepartCurrentTimePointFilter implements AirTravelFilter{
    /**
     * Gets the name of the filter.
     *
     * @return The name of the filter: "Filter: Departure up to the current point in time".
     */
    @Override
    public String filterName() {
        return "Filter: Departure up to the current point in time";
    }

    /**
     * Filters a list of flights, retaining only those where all segments have departure times after
     * the current point in time.
     *
     * @param flights The list of flights to be filtered.
     * @return A new list of flights with segments departing after the current point in time.
     */
    @Override
    public List<Flight> filteredAirTravels(List<Flight> flights) {
        LocalDateTime time = LocalDateTime.now();
        return flights.stream()
                .filter(flight -> flight.getSegments().stream().allMatch(segment -> segment.getDepartureDate().isAfter(time)))
                .collect(Collectors.toList());
    }
}
