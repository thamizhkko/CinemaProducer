package com.example.Spring_Cinema_Producer.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Spring_Cinema_Producer.DTO.MovieDTO;
import com.example.Spring_Cinema_Producer.Entity.Cinema;
import com.example.Spring_Cinema_Producer.Entity.Movies;
import com.example.Spring_Cinema_Producer.Exception.CinemaIdNotFoundException;
import com.example.Spring_Cinema_Producer.Repository.CinemaRepository;
import com.example.Spring_Cinema_Producer.Repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	MovieRepository movierepo;

	@Autowired
	CinemaRepository cinemarepo;

	public List<MovieDTO> movieList() {

		return movierepo.findAll().stream()
				.map(movie -> new MovieDTO(movie.getId(), movie.getTitle(), movie.getGenre(), movie.getDuration(),
						movie.getRating(), movie.getShowtimes(), movie.getCinema().getId()))
				.collect(Collectors.toList());
	}

	public MovieDTO newMovie(MovieDTO newMovie) {

		Movies movie = new Movies();
		movie.setTitle(newMovie.getTitle());
		movie.setGenre(newMovie.getGenre());
		movie.setDuration(newMovie.getDuration());
		movie.setRating(newMovie.getRating());
		movie.setShowtimes(newMovie.getShowtimes());

		Cinema cinema = cinemarepo.findById(newMovie.getCinemaId())
				.orElseThrow(() -> new CinemaIdNotFoundException("cinema id not found"));

		movie.setCinema(cinema);
		Movies savedmovie = movierepo.save(movie);
		return new MovieDTO(savedmovie.getId(), savedmovie.getTitle(), savedmovie.getGenre(), savedmovie.getDuration(),
				savedmovie.getRating(), savedmovie.getShowtimes(), savedmovie.getCinema().getId());
	}

}
