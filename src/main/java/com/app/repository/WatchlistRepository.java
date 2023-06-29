package com.app.repository;


import com.app.entity.Watchlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import java.math.BigDecimal;

import java.util.List;

@Repository
    public interface WatchlistRepository extends JpaRepository<Watchlist, Long> {
    //finding flights by user's id from DB
    List<Watchlist> findByUserId(Long userId);
    //finding by arrival place from DB
    List<Watchlist> findByarrivalPlace(String arrivalPlace);
    //finding by departue palce from DB
    List<Watchlist> findBydepartuePlace (String departurePlace);
    //saving new Flight (method deleted due to JPA)

    //method used for deleting any FLight by it's id (method deleted due to JPA)

    //ACHTUNG, ZAPYTAĆ PANA DAISHI!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    @Modifying
    @Query("UPDATE Watchlist w SET w.price = :price WHERE w.id = :id")
    void updatePriceById(Long id, BigDecimal price);

}
