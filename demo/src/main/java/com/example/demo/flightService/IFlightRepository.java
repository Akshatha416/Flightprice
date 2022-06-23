package com.example.demo.flightService;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.flightEntity.FlightEntity;

public interface IFlightRepository extends JpaRepository<FlightEntity, Integer>{

}
