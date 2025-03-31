package com.example.Spring_Cinema_Producer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Spring_Cinema_Producer.Entity.Bookings;

public interface BookingRepository extends JpaRepository<Bookings, Integer>{

}
