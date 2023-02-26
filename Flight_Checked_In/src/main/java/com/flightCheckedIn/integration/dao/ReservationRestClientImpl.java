package com.flightCheckedIn.integration.dao;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.flightCheckedIn.integration.dto.Reservation;
import com.flightCheckedIn.integration.dto.ReservationUpdateRequest;

@Component
public class ReservationRestClientImpl implements ReservationRestClient {

	private static final String RESERVATION_REST_URL = "http://localhost:8081/reservations/";
	private static final String RESERVATION_REST_URL1 = "http://localhost:8081/reservations";

	@Override
	public Reservation findReservation(Long id) {
		RestTemplate restTemplate = new RestTemplate();
		Reservation reservation = restTemplate.getForObject(RESERVATION_REST_URL + id, Reservation.class);
		return reservation;
	}

	@Override
	public Reservation updateReservation(ReservationUpdateRequest request) {
		RestTemplate restTemplate = new RestTemplate();
		Reservation reservation = restTemplate.postForObject(RESERVATION_REST_URL1, request, Reservation.class);
		return reservation;
	}

}
