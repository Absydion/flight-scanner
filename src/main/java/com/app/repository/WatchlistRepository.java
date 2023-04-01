package com.app.repository;

import com.app.entity.Flight;
import com.app.entity.Watchlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
    public interface WatchlistRepository extends JpaRepository<Watchlist, Long> {
        void addFlightToWatchlist(Flight flight, Watchlist watchlist);

        void removeFlightFromWatchlist(Flight flight, Watchlist watchlist);
        List<Flight> getFlightsFromWatchlist(Watchlist watchlist);
    }
