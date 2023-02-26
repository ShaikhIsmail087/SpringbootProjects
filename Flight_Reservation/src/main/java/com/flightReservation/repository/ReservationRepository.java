package com.flightReservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightReservation.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
