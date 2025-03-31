package com.example.Spring_Cinema_Producer.mockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.Spring_Cinema_Producer.DTO.CinemaDTO;
import com.example.Spring_Cinema_Producer.Entity.Bookings;
import com.example.Spring_Cinema_Producer.Entity.Cinema;
import com.example.Spring_Cinema_Producer.Repository.BookingRepository;
import com.example.Spring_Cinema_Producer.Repository.CinemaRepository;
import com.example.Spring_Cinema_Producer.Repository.MovieRepository;
import com.example.Spring_Cinema_Producer.Repository.UsersRepository;
import com.example.Spring_Cinema_Producer.Service.BookingService;

@ExtendWith(MockitoExtension.class)
public class BookingServiceTest {

	@Mock
	CinemaRepository cinemarepo;
	
	@Mock
	MovieRepository movierepo;
	
	@Mock
	BookingRepository bookingrepo;
	
	@Mock
	UsersRepository userrepo;
	
	@InjectMocks
	BookingService bookingService;
	
	Bookings booking;
	
	@BeforeEach
	void setup() {
		
		Cinema cinema=new Cinema(1, "AGS cinemas", "kerala");
		
		 booking=new Bookings();
		
		booking.setId(1);
		booking.setShowtime("10 AM");
		booking.setSeats(5);
		booking.setCinema(cinema);
	}
}
