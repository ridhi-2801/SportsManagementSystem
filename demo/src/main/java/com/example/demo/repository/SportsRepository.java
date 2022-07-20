package com.example.demo.repository;

import com.example.demo.model.Sports;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportsRepository extends JpaRepository<Sports,Integer> {


public Sports findBySportsName(String sportsName);

}
