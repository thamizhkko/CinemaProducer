package com.example.Spring_Cinema_Producer.DTO;

public class CinemaDTO {

	private Integer id;
	private String name;
	private String location;

	public CinemaDTO(Integer id, String name, String location) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

}
