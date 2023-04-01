package com.app.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table
public class Watchlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToMany(mappedBy = "FlightList")
    @Column
    private List<Flight> FlightList;
    @Column
    private String user;
    @Column
    private String name;
    @Column
    private LocalDateTime created_at_datetime;
    @Column
    private LocalDateTime updated_at_datetime;
}
