package com.example.Spring_Cinema_Producer.mockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import com.example.Spring_Cinema_Producer.DTO.CinemaDTO;
import com.example.Spring_Cinema_Producer.Entity.Cinema;
import com.example.Spring_Cinema_Producer.Repository.CinemaRepository;
import com.example.Spring_Cinema_Producer.Service.CinemaService;

@ExtendWith(MockitoExtension.class)
public class CinemaServiceTest {

	@Mock
	CinemaRepository cinemarepo;  // Mocking the repository (no DB)
	
	@InjectMocks
	CinemaService cinemaservice;  // Injecting mock into service
	
	private Cinema cinema1;
	private Cinema cinema2;
	
	@BeforeEach
	void setup() {
		cinema1=new Cinema(1, "pvr", "chennai");
		cinema2=new Cinema(2, "ags", "kerala");
	}
	
	@Test
	void testCinemaList() {
		
		when(cinemarepo.findAll()).thenReturn(Arrays.asList(cinema1,cinema2));
		
	List<CinemaDTO>	result=cinemaservice.cinemaList();
	
	Assertions.assertNotNull(result);
	Assertions.assertEquals(2, result.size());
	
	Assertions.assertEquals("pvr", result.get(0).getName());
	Assertions.assertEquals("ags", result.get(1).getName());
	
	Assertions.assertEquals("chennai", result.get(0).getLocation());
	Assertions.assertEquals("kerala", result.get(1).getLocation());
	
	Mockito.verify(cinemarepo,Mockito.times(1)).findAll();
	
	}
	
	
}
