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
    private Watchlist watchlist;


    @Column
    private String Flightnumber;


    private String Departueplace;

    private String Arrivalplace;

    private LocalDate Departuedate;

    private LocalTime Arrivaltime;

    private String Flightstatus;

    private double price;


}
