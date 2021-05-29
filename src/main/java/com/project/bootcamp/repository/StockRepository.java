package com.project.bootcamp.repository;

import com.project.bootcamp.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Speed up the database CRUD extending Repository methods
@Repository
public interface StockRepository extends JpaRepository <Stock, Long>{

}
