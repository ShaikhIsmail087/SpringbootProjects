package com.flightReservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightReservation.entities.Passenger;

public interface PassengerRepositorty extends JpaRepository<Passenger, Long> {

}
