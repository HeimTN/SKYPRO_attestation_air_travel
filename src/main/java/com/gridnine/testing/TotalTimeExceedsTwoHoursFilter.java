package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
/**
 * The {@code TotalTimeExceedsTwoHoursFilter} class implements the {@code AirTravelFilter} interface
 * and filters flights based on the criteria that the total time spent on the ground should exceed two hours.
 */
public class TotalTimeExceedsTwoHoursFilter implements AirTravelFilter{
    /**
     * Gets the name of the filter.
     *
     * @return The name of the filter: "Filter: Flights where the total time spent on the ground exceeds two hours".
     */
    @Override
    public String filterName() {
        return "Filter: Flights where the total time spent on the ground exceeds two hours";
    }
    /**
     * Filters a list of flights, retaining only those where the total time spent on the ground exceeds two hours.
     *
     * @param flights The list of flights to be filtered.
     * @return A new list of flights with total ground time exceeding two hours.
     */
    @Override
    public List<Flight> filteredAirTravels(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> calcTotalTime(flight) <= 2)
                .collect(Collectors.toList());
    }
    /**
     * Calculates the total time spent on the ground for a given flight.
     *
     * @param flight The flight for which to calculate the total time on the ground.
     * @return The total time spent on the ground in hours.
     */
    private long calcTotalTime(Flight flight){
        List<Segment> segments = flight.getSegments();
        long totalTime = 0;
        for(int i = 0; i < segments.size()-1; i++){
            LocalDateTime current = segments.get(i).getArrivalDate();
            LocalDateTime next = segments.get(i+1).getDepartureDate();
            totalTime += current.until(next, ChronoUnit.HOURS);
        }
        return totalTime;
    }
}
