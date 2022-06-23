package com.example.demo.flightService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.flightEntity.FlightEntity;

@Service
public class FlightService {
	
	@Autowired
	IFlightRepository iFlightRepository;
	
	public Integer saveFlight(FlightEntity flightEntity) {
		FlightEntity flightEntity2=  iFlightRepository.save(flightEntity);
		return flightEntity2.getId();
		
	}
	public void deleteByIdVar(Integer id) {
		iFlightRepository.deleteById(id);
	}

}
