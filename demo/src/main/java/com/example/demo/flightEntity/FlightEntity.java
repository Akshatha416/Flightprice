package com.example.demo.flightEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class FlightEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private Integer id;
	@NotBlank ( message="this can't be blank")
	private String flightName;
	@NotBlank ( message="this can't be blank")
    private String airlineName;
	
	private float price;
    
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public FlightEntity() {
		super();
	}
	public FlightEntity(Integer id, String flightName, String airlineName) {
		super();
		this.id = id;
		this.flightName = flightName;
		this.airlineName = airlineName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public String getAirlineName() {
		return airlineName;
	}
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	

}
