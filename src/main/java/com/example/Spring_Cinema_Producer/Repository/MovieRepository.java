package com.example.Spring_Cinema_Producer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Spring_Cinema_Producer.Entity.Movies;

@Repository
public interface MovieRepository extends JpaRepository<Movies, Integer>{

	
}
