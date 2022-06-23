package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PricingController {
	
	@GetMapping("/price")
	
	float getPrice() {
		return 1000;
	}

}
