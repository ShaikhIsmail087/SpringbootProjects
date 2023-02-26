package com.flightCheckedIn.integration.dto;

import lombok.Data;

@Data
public class ReservationUpdateRequest {

	private Long id;
	private Boolean checkedIn;
	private int numberOfBags;
}
