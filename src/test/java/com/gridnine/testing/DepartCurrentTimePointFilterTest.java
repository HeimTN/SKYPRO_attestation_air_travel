package com.gridnine.testing;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DepartCurrentTimePointFilterTest {
    DepartCurrentTimePointFilter filter = new DepartCurrentTimePointFilter();
    @Test
    void filterName_NotNull(){
        assertFalse(filter.filterName().isEmpty());
    }

    @Test
    void filteredAirTravels_NoFlights() {
        List<Flight> flights = new ArrayList<>();
        List<Flight> result = filter.filteredAirTravels(flights);
        assertTrue(result.isEmpty());
    }

    @Test
    void filteredAirTravels_AllSegmentsAfterCurrentTime() {
        LocalDateTime currentTime = LocalDateTime.now();

        Flight flight = new Flight(List.of(
                new Segment(currentTime.plusHours(1), currentTime.plusHours(2)),
                new Segment(currentTime.plusHours(3), currentTime.plusHours(4))
        ));

        List<Flight> flights = List.of(flight);

        List<Flight> result = filter.filteredAirTravels(flights);
        assertEquals(flights, result);
    }

    @Test
    void filteredAirTravels_SomeSegmentsBeforeCurrentTime() {
        LocalDateTime currentTime = LocalDateTime.now();

        Flight flight = new Flight(List.of(
                new Segment(currentTime.minusHours(1), currentTime.plusHours(2)),
                new Segment(currentTime.plusHours(1), currentTime.plusHours(4))
        ));

        List<Flight> flights = List.of(flight);

        List<Flight> result = filter.filteredAirTravels(flights);
        assertTrue(result.isEmpty());
    }
}
