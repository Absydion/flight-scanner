package com.app.service;

import com.app.entity.Flight;
import com.app.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Flight getFlightById(Long id) {
        return flightRepository.findById(id).orElse(null);
    }

    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public Flight updateFlight(Long id, Flight flight) {
        Flight flightToUpdate = flightRepository.findById(id).orElse(null);
        if (flightToUpdate != null) {
            flightToUpdate.setDeparturePlace(flight.getDeparturePlace());
            flightToUpdate.setArrivalPlace(flight.getArrivalPlace());
            flightToUpdate.setArrivalTime(flight.getArrivalTime());
            flightToUpdate.setDepartureDate(flight.getDepartureDate());
            flightRepository.save(flightToUpdate);
        }
        return flightToUpdate;
    }

    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }

    public List<Flight> searchFlights(String departure, String destination, LocalDate date) {
        return flightRepository.findByDeparturePlaceAndArrivalPlaceAndDepartureDate(departure, destination, date);
    }
}
