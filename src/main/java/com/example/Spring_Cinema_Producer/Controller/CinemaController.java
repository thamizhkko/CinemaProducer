package com.example.Spring_Cinema_Producer.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Spring_Cinema_Producer.DTO.CinemaDTO;
import com.example.Spring_Cinema_Producer.Service.CinemaService;

@RestController

public class CinemaController {

	@Autowired
	CinemaService cinemaService;
	
	@GetMapping("/cinema")
	public ResponseEntity<List<CinemaDTO>> getAllCinemas(){
		
		return ResponseEntity.ok(cinemaService.cinemaList());
	}
}
