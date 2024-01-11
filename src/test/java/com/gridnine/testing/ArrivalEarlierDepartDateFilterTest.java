package com.gridnine.testing;


import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ArrivalEarlierDepartDateFilterTest {
    ArrivalEarlierDepartDateFilter filter = new ArrivalEarlierDepartDateFilter();
    @Test
    void filterName_NotNull(){
        assertFalse(filter.filterName().isEmpty());
    }

    @Test
    void filteredAirTravels_NoFlights(){
        List<Flight> flights = new ArrayList<>();
        List<Flight> result = filter.filteredAirTravels(flights);
        assertTrue(result.isEmpty());
    }

    @Test
    void filteredAirTravels_AllSegmentsCorrect() {
        LocalDateTime now = LocalDateTime.now();

        Flight flight = new Flight(List.of(
                new Segment(now, now.plusHours(1)),
                new Segment(now.plusHours(2), now.plusHours(3))
        ));

        List<Flight> flights = List.of(flight);

        List<Flight> result = filter.filteredAirTravels(flights);
        assertEquals(flights, result);
    }

    @Test
    void filteredAirTravels_SomeSegmentsIncorrect() {
        LocalDateTime now = LocalDateTime.now();

        Flight flight = new Flight(List.of(
                new Segment(now, now.plusHours(1)),
                new Segment(now.plusHours(2), now.minusHours(3))
        ));

        List<Flight> flights = List.of(flight);

        List<Flight> result = filter.filteredAirTravels(flights);
        assertTrue(result.isEmpty());
    }
}
