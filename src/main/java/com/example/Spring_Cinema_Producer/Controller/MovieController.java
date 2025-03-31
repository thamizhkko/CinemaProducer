package com.example.Spring_Cinema_Producer.Controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.Spring_Cinema_Producer.DTO.MovieDTO;
import com.example.Spring_Cinema_Producer.Service.MovieService;

@RestController
public class MovieController {

	@Autowired
	MovieService movieService;

	@GetMapping("/movies")
	public ResponseEntity<List<MovieDTO>> getAllMovies() {

		return ResponseEntity.ok(movieService.movieList());
	}

	@PostMapping("/movies")
	public ResponseEntity<MovieDTO> addMovie(@RequestBody MovieDTO movieDto) {

		movieService.newMovie(movieDto);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(movieDto.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

}
