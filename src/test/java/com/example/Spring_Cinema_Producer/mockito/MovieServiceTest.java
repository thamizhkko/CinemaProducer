package com.example.Spring_Cinema_Producer.mockito;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.Spring_Cinema_Producer.DTO.MovieDTO;
import com.example.Spring_Cinema_Producer.Entity.Cinema;
import com.example.Spring_Cinema_Producer.Entity.Movies;
import com.example.Spring_Cinema_Producer.Exception.CinemaIdNotFoundException;
import com.example.Spring_Cinema_Producer.Repository.CinemaRepository;
import com.example.Spring_Cinema_Producer.Repository.MovieRepository;
import com.example.Spring_Cinema_Producer.Service.MovieService;

@ExtendWith(MockitoExtension.class)
public class MovieServiceTest {

	@Mock
	MovieRepository movierepo;
	
	@Mock
	CinemaRepository cinemarepo;
	
	@InjectMocks
	MovieService movieService;
	
	Movies movie;
	MovieDTO movieDto;
	
	@BeforeEach
	void setup() {
		Cinema cinema=new Cinema(1, "pvr", "chennai");
		
		 movie=new Movies();
		movie.setId(1);
		movie.setTitle("Inception");
        movie.setGenre("Sci-Fi");
        movie.setDuration("2h 28m");
        movie.setShowtimes(Arrays.asList("10:00 AM", "3:00 PM"));
        movie.setCinema(cinema);
        
        movieDto= new MovieDTO(2, "baki hanma", "anime", "5h 50m", "9",
        		Arrays.asList("11:00 AM", "5:00 PM"), 2);
	}
	
	
	@Test
	void testMovieList() {
		
		when(movierepo.findAll()).thenReturn(Arrays.asList(movie));
		
		List<MovieDTO> result=movieService.movieList();
		
		assertNotNull(result);
		assertEquals(1, result.size());
		
		assertEquals("Inception", result.get(0).getTitle());
		assertEquals("Sci-Fi", result.get(0).getGenre());
		assertEquals("2h 28m", result.get(0).getDuration());
		assertEquals(Arrays.asList("10:00 AM", "3:00 PM"), result.get(0).getShowtimes());
		
		//verify cinema id
		assertEquals(1, result.get(0).getCinemaId());
		
		//verify findAll() called once
		verify(movierepo, times(1)).findAll();
		
	}
	
	
	@Test
	void testAddMovie() {
		
		when(cinemarepo.findById(movieDto.getCinemaId()))
		.thenReturn(Optional.of(new Cinema(2, "IMAX", "New York")));
		
		when(movierepo.save(any(Movies.class))).thenReturn(movie);
		
		MovieDTO result=movieService.newMovie(movieDto);
		
		assertNotNull(result);
		assertEquals("Inception",result.getTitle() );
		assertEquals("Sci-Fi", result.getGenre());
		assertEquals("2h 28m", result.getDuration());
		assertEquals(Arrays.asList("10:00 AM", "3:00 PM"), result.getShowtimes());
		
		verify(movierepo,times(1)).save(any(Movies.class));
	}
	
	@Test
	void testAddMovie_CinemaNotFound() {
	    // ✅ Mock cinema repository to return empty
	    when(cinemarepo.findById(movieDto.getCinemaId())).thenReturn(Optional.empty());

	    // ✅ Check if CinemaIdNotFoundException is thrown
	    assertThrows(CinemaIdNotFoundException.class, () -> {
	        movieService.newMovie(movieDto);
	    });
	
}
}
