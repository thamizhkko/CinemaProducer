package com.example.Spring_Cinema_Producer.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.Spring_Cinema_Producer.Entity.Cinema;
import com.example.Spring_Cinema_Producer.Repository.CinemaRepository;
import com.example.Spring_Cinema_Producer.Service.CinemaService;


@SpringBootTest
public class CinemaServiceTest {

	@Autowired
	CinemaRepository cinemarepo;
	
	@Autowired
	CinemaService cinemaservice;
	
	@Test
	public void testCinemaList() {
		
		Cinema savedCinema=cinemarepo.save(new Cinema(1, "inox", "chennai"));
		
		Assertions.assertNotNull(savedCinema);
		Assertions.assertNotNull(savedCinema.getId());
		Assertions.assertEquals("inox", savedCinema.getName());
		Assertions.assertEquals("chennai", savedCinema.getLocation());
		
	}
	
}
