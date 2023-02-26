package com.flightCheckedIn.integration.dto;

import java.sql.Timestamp;
import java.util.Date;

import lombok.Data;

@Data
public class Flight {

	private Long id;
	private String flightNumber;
	private String operatingAirlines;
	private String departureCity;
	private String arrivalCity;
	private Date dateOfDeparture;
	private Timestamp estimatedDepartureTime;
}
