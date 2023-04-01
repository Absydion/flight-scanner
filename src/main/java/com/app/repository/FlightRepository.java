package com.app.repository;

import com.app.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface FlightRepository extends JpaRepository <Flight, Long> {
    List<Flight> findAll();
    Optional<Flight> findById(Long id);
    void findALlFlights();
    void findFlightById(Long id);
    void saveFlight(Flight flight);

}