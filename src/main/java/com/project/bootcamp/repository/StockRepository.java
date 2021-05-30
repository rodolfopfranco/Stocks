package com.project.bootcamp.repository;

import com.project.bootcamp.model.Stock;
import com.project.bootcamp.model.dto.StockDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

//Speed up the database CRUD extending Repository methods
@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
    Optional<Stock> findByNameAndDate(String name, LocalDate date);

    // the ":" refers to variables from the optional. No ";" at the endline
    @Query("SELECT stock "+
            "FROM Stock stock "+
            "WHERE stock.name = :name AND stock.date = :date AND stock.id <> :id")
    Optional<Stock> findByStockUpdate(String name, LocalDate date, Long id);

    @Query("SELECT stock "+
            "FROM Stock stock "+
            "WHERE stock.date = :date")
    Optional<List<Stock>> findByToday(LocalDate date);
}