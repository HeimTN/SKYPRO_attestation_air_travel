# AirTravelFilter Module

The AirTravelFilter module is designed to facilitate the dynamic filtering of a set of air travels based on various rules. This module provides a flexible framework for defining and applying filtering rules to large sets of flights.

## Features

- **Extensibility**: The module supports an extensible set of filtering rules, allowing you to easily add or modify rules as needed.
- **Dynamic Rule Selection**: Rules can be chosen and defined dynamically based on the specific context of the filtering operation.
- **Efficient Processing**: The module is designed to handle large sets of air travels efficiently, making it suitable for diverse datasets.

## Usage

### Basic Usage

1. **Create AirTravelFilter Instances**: Implement the `AirTravelFilter` interface to define specific filtering rules.

    ```java
    public interface AirTravelFilter {
        String filterName();
        List<Flight> filteredAirTravels(List<Flight> flights);
    }
    ```
2. **Implement Custom Filtering Rules**: Create classes that implement the `AirTravelFilter` interface to define custom filtering criteria.

    ```java
    public class DepartCurrentTimePointFilter implements AirTravelFilter {
        // ... implementation ...
    }

    public class ArrivalEarlierDepartDateFilter implements AirTravelFilter {
        // ... implementation ...
    }

    public class TotalTimeExceedsTwoHoursFilter implements AirTravelFilter {
        // ... implementation ...
    }
    ```
3. **Apply Filters Dynamically**: Instantiate the filters based on the dynamic context and apply them.

    ```java
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();
        // Apply filters
        List<AirTravelFilter> filters = Arrays.asList(
                new DepartCurrentTimePointFilter(),
                new ArrivalEarlierDepartDateFilter(),
                new TotalTimeExceedsTwoHoursFilter()
        );
        //... other code ...
    }
    ```
## License
This module is open-source and distributed under the MIT License. Feel free to use, modify, and distribute it as needed.
