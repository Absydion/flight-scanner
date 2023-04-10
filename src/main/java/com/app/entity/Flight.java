package com.app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

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
    @ManyToOne (fetch = FetchType.LAZY)
    private Watchlist watchList;
    @Column
    private String flightNumber;
    private String departuePlace;
    private String arrivalPlace;

    private LocalDate departueDate;
    private LocalTime arrivalTime;
    private String flightStatus;
    private Double price;



}
