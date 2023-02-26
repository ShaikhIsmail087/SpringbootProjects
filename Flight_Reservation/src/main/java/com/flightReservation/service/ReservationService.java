package com.flightReservation.service;

import com.flightReservation.dto.ReservationRequest;
import com.flightReservation.entities.Reservation;

public interface ReservationService {
	public Reservation bookFlight( ReservationRequest request); 
}
