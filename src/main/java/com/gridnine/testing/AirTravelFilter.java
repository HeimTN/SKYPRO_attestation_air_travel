package com.gridnine.testing;

import java.util.List;

public interface AirTravelFilter {
    String filterName();
    List<Flight> filteredAirTravels(List<Flight> flights);
}
