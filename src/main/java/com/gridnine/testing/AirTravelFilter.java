package com.gridnine.testing;

import java.util.List;
/**
 * The {@code AirTravelFilter} interface represents a filter for air travels.
 * Implementations of this interface define specific criteria for filtering flights.
 */
public interface AirTravelFilter {
    /**
     * Gets the name of the filter.
     *
     * @return The name of the filter.
     */
    String filterName();
    /**
     * Filters a list of flights based on specific criteria defined by the implementing class.
     *
     * @param flights The list of flights to be filtered.
     * @return A new list of flights that satisfy the filtering criteria.
     */
    List<Flight> filteredAirTravels(List<Flight> flights);
}
