package com.example.demo.flightController;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
 import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.flightEntity.FlightEntity;
import com.example.demo.flightService.FlightService;

@RestController
@RequestMapping("/")
public class FlightController {
	
	@Autowired
	private FlightService flightService;
	
	
	@GetMapping("/hello")
	public String helloworld() {
		return "Hello,this is My World";
	}
	
	//post
	
	@PostMapping(value="/createFlight",consumes= {"application/json"})
	public Integer createFlight(@Valid @RequestBody FlightEntity flight) {
		Integer id = flightService.saveFlight(flight);
		System.out.println(id);
		return id;
	}
	
	@DeleteMapping("/deleteFlight")
	public void deleteFlight(@RequestParam("id") Integer flightId) {
		flightService.deleteByIdVar(flightId);
	}
	
	

	//error and exception handling
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleException(MethodArgumentNotValidException exception){
		 Map<String, String> messages=new HashMap<>();
		 
		 exception.getAllErrors().forEach(error ->{
			 String fieldName=((FieldError)error).getField();
			 String errorMessage=((FieldError)error).getDefaultMessage();
			 messages.put(fieldName, errorMessage);
	

	});
		return messages;
	
}
	
	
	@GetMapping("/getflightprice")
	public Double getFlightPrice(){
		HttpHeaders headers=new HttpHeaders();
		HttpEntity<String> entity= new HttpEntity<String>(headers);
		RestTemplate restTemplate =new RestTemplate();
		Double price =  restTemplate.exchange("http://localhost:7878/price",HttpMethod.GET,entity,Double.class).getBody();
		return price;
		
	}
	
}
