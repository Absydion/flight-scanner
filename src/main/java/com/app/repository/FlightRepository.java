package com.app.repository;

import com.app.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository <Flight, Long> {
//co to sie stalo sie
    List<Flight> findByDeparturePlaceAndArrivalPlaceAndDepartureDate(String departurePlace, String arrivalPlace, LocalDate departureDate);


    List<Flight> findByDepartureAndDestinationAndDate(String departure, String destination, LocalDate date);
}