package com.flightCheckedIn.integration.dao;

import com.flightCheckedIn.integration.dto.Reservation;
import com.flightCheckedIn.integration.dto.ReservationUpdateRequest;

public interface ReservationRestClient {

	public Reservation findReservation(Long id);
	public Reservation updateReservation(ReservationUpdateRequest  request);
}
