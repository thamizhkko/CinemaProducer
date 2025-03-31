package com.example.Spring_Cinema_Producer.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Spring_Cinema_Producer.DTO.CinemaDTO;
import com.example.Spring_Cinema_Producer.Repository.CinemaRepository;

@Service
public class CinemaService {

	@Autowired
	CinemaRepository cinemaRepo;
	
	public List<CinemaDTO> cinemaList(){
		
		return cinemaRepo.findAll().stream()
				.map(cinema->new CinemaDTO(cinema.getId(), cinema.getName(), cinema.getLocation()))
				.collect(Collectors.toList());
	}
	
}
