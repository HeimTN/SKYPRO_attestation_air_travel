package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

public class TotalTimeExceedsTwoHoursFilter implements AirTravelFilter{
    @Override
    public String filterName() {
        return "Filter: Flights where the total time spent on the ground exceeds two hours";
    }

    @Override
    public List<Flight> filteredAirTravels(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> calcTotalTime(flight) <= 2)
                .collect(Collectors.toList());
    }

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
