package com.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Watchlist watchList;

    @Column
    private String flightNumber;
    private String departurePlace;
    private String arrivalPlace;
    private LocalDate departureDate;
    private LocalTime arrivalTime;
    private String flightStatus;
    private Double price;

    // Getter and Setter methods for departurePlace, arrivalPlace, departureDate, arrivalTime, flightStatus, and price

    // Add the getter and setter methods for the additional fields here
}
