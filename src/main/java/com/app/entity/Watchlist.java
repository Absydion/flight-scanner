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
public class Watchlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToMany(mappedBy = "flightList")
    @Column
    private List<Flight> flightList;
    @Column
    private String user;
    @Column
    private String name;
    @Column
    private LocalDateTime createdAtDatetime;
    @Column
    private LocalDateTime updatedAtDatetime;
}
