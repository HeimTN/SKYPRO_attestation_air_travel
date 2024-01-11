package com.gridnine.testing;

import java.util.List;
import java.util.stream.Collectors;
/**
 * The {@code ArrivalEarlierDepartDateFilter} class implements the {@code AirTravelFilter} interface
 * and filters flights based on the criteria that all segments must have an arrival date later than the departure date.
 */
public class ArrivalEarlierDepartDateFilter implements AirTravelFilter{
    /**
     * Gets the name of the filter.
     *
     * @return The name of the filter: "Filter: Segments with arrival date earlier than departure date".
     */
    @Override
    public String filterName() {
        return "Filter: Segments with arrival date earlier than departure date";
    }
    /**
     * Filters a list of flights, retaining only those where all segments have arrival dates later than
     * the corresponding departure dates.
     *
     * @param flights The list of flights to be filtered.
     * @return A new list of flights with segments having arrival dates later than departure dates.
     */
    @Override
    public List<Flight> filteredAirTravels(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> flight.getSegments().stream().allMatch(segment -> segment.getArrivalDate().isAfter(segment.getDepartureDate())))
                .collect(Collectors.toList());
    }
}
