package com.example.Spring_Cinema_Producer.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Movies {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private String genre;
	private String duration;
	private String rating;

	@ElementCollection
	private List<String> showtimes;

	@OneToMany(mappedBy = "movies")
	private List<Bookings> bookings;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	@JoinColumn(name = "cinema_id")
	private Cinema cinema;

	public Movies() {
	}

	public Movies(Integer id, String title, String genre, String duration, String rating, List<String> showtimes,
			List<Bookings> bookings, Cinema cinema) {
		super();
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.duration = duration;
		this.rating = rating;
		this.showtimes = showtimes;
		this.bookings = bookings;
		this.cinema = cinema;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public List<String> getShowtimes() {
		return showtimes;
	}

	public void setShowtimes(List<String> showtimes) {
		this.showtimes = showtimes;
	}

	public List<Bookings> getBookings() {
		return bookings;
	}

	public void setBookings(List<Bookings> bookings) {
		this.bookings = bookings;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	@Override
	public String toString() {
		return "Movies [id=" + id + ", title=" + title + ", genre=" + genre + ", duration=" + duration + ", rating="
				+ rating + ", showtimes=" + showtimes + ", bookings=" + bookings + ", cinema=" + cinema + "]";
	}

}
