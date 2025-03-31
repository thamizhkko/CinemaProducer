package com.example.Spring_Cinema_Producer.Controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.Spring_Cinema_Producer.DTO.BookingDTO;
import com.example.Spring_Cinema_Producer.Service.BookingService;

@RestController
public class BookingController {

	@Autowired
	BookingService bookingService;
	
	@PostMapping("/bookings")
	public ResponseEntity<BookingDTO> newBooking(@RequestBody BookingDTO newbooking){
		
		bookingService.addBooking(newbooking);
		
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
		.buildAndExpand(newbooking.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
}
