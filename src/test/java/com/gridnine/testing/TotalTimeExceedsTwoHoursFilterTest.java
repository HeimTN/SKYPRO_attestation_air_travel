package com.gridnine.testing;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TotalTimeExceedsTwoHoursFilterTest {
    TotalTimeExceedsTwoHoursFilter filter = new TotalTimeExceedsTwoHoursFilter();
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
    void filteredAirTravels_TotalTimeExceedsTwoHours() {
        Flight flight = new Flight(List.of(
                new Segment(LocalDateTime.now(), LocalDateTime.now().plusHours(1)),
                new Segment(LocalDateTime.now().plusHours(4), LocalDateTime.now().plusHours(5))
        ));

        List<Flight> flights = List.of(flight);

        List<Flight> result = filter.filteredAirTravels(flights);
        assertTrue(result.isEmpty());
    }

    @Test
    void filteredAirTravels_TotalTimeWithinTwoHours() {
        Flight flight = new Flight(List.of(
                new Segment(LocalDateTime.now(), LocalDateTime.now().plusHours(1)),
                new Segment(LocalDateTime.now().plusHours(2), LocalDateTime.now().plusHours(2))
        ));

        List<Flight> flights = List.of(flight);

        List<Flight> result = filter.filteredAirTravels(flights);
        assertEquals(flights, result);
    }
}

