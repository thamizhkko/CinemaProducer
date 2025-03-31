package com.example.Spring_Cinema_Producer.DTO;

import java.util.List;

public class MovieDTO {

	private Integer id;
	private String title;
	private String genre;
	private String duration;
	private String rating;
	private List<String> showtimes;
	private Integer cinemaId;

	public MovieDTO(Integer id, String title, String genre, String duration, String rating, List<String> showtimes,
			Integer cinemaId) {
		super();
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.duration = duration;
		this.rating = rating;
		this.showtimes = showtimes;
		this.cinemaId = cinemaId;
	}

	public Integer getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getGenre() {
		return genre;
	}

	public String getDuration() {
		return duration;
	}

	public String getRating() {
		return rating;
	}

	public List<String> getShowtimes() {
		return showtimes;
	}

	public Integer getCinemaId() {
		return cinemaId;
	}

}
