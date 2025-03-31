package com.example.Spring_Cinema_Producer.DTO;

public class BookingDTO {

	private Integer id;
	private String showtime;
	private Integer seats;
	private Integer movieId;
	private Integer cinemaId;
	private Integer userId;

	public BookingDTO(Integer id, String showtime, Integer seats, Integer movieId,Integer cinemaId, Integer userId) {
		this.id = id;
		this.showtime = showtime;
		this.seats = seats;
		this.movieId = movieId;
		this.cinemaId=cinemaId;
		this.userId = userId;
	}

	public Integer getId() {
		return id;
	}

	public String getShowtime() {
		return showtime;
	}

	public Integer getSeats() {
		return seats;
	}

	public Integer getMovieId() {
		return movieId;
	}

	public Integer getUserId() {
		return userId;
	}

	public Integer getCinemaId() {
		return cinemaId;
	}
}
