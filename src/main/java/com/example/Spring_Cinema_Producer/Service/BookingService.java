package com.example.Spring_Cinema_Producer.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Spring_Cinema_Producer.DTO.BookingDTO;
import com.example.Spring_Cinema_Producer.Entity.Bookings;
import com.example.Spring_Cinema_Producer.Entity.Cinema;
import com.example.Spring_Cinema_Producer.Entity.Movies;
import com.example.Spring_Cinema_Producer.Entity.Users;
import com.example.Spring_Cinema_Producer.Exception.CinemaIdNotFoundException;
import com.example.Spring_Cinema_Producer.Exception.MovieIdNotFoundException;
import com.example.Spring_Cinema_Producer.Exception.UserIdNotFoundException;
import com.example.Spring_Cinema_Producer.Repository.BookingRepository;
import com.example.Spring_Cinema_Producer.Repository.CinemaRepository;
import com.example.Spring_Cinema_Producer.Repository.MovieRepository;
import com.example.Spring_Cinema_Producer.Repository.UsersRepository;

@Service
public class BookingService {

	
	@Autowired
	BookingRepository bookingRepo;
	
	@Autowired
	MovieRepository movierepo;
	
	@Autowired
	CinemaRepository cinemarepo;
	
	@Autowired
    UsersRepository userrepo;
	
	public BookingDTO addBooking(BookingDTO bookDTO) {
		
		 
		Movies movie=movierepo.findById(bookDTO.getMovieId())
		.orElseThrow(()->new MovieIdNotFoundException("movie id not found"));
		
		Cinema cinema=cinemarepo.findById(bookDTO.getCinemaId())
		.orElseThrow(()->new CinemaIdNotFoundException("cinema id not found"));
		
		Users user=userrepo.findById(bookDTO.getUserId())
		.orElseThrow(()->new UserIdNotFoundException("user id not found"));
		
		Bookings booking=new Bookings();
		booking.setMovies(movie);
		booking.setCinema(cinema);
		booking.setUser(user);
		booking.setShowtime(bookDTO.getShowtime());
		booking.setSeats(bookDTO.getSeats());
		
		//save booking
		Bookings savedBooking=bookingRepo.save(booking);
		
		return new BookingDTO(savedBooking.getId(), savedBooking.getShowtime(), savedBooking.getSeats()
				, savedBooking.getMovies().getId(), savedBooking.getCinema().getId(), savedBooking.getUser().getId());
		
	}
	
}
