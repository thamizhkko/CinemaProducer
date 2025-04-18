package com.example.Spring_Cinema_Producer.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Spring_Cinema_Producer.DTO.CinemaDTO;
import com.example.Spring_Cinema_Producer.Repository.CinemaRepository;

@Service
public class CinemaService {

	// ✅ Log4j2 Logger initialization
    private static final Logger logger = LogManager.getLogger(CinemaService.class);

	@Autowired
	CinemaRepository cinemaRepo;
	
	public List<CinemaDTO> cinemaList(){
		 logger.info("Fetching list of cinemas from repository"); // ✅ Info log before operation
		
		List<CinemaDTO> cinemas= cinemaRepo.findAll().stream()
				.map(cinema->new CinemaDTO(cinema.getId(), cinema.getName(), cinema.getLocation()))
				.collect(Collectors.toList());
		
		 logger.info("Number of cinemas fetched: {}", cinemas.size());
		return cinemas;
	}
	
}
