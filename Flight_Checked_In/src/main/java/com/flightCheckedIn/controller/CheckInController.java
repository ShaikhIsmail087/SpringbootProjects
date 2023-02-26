package com.flightCheckedIn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.flightCheckedIn.integration.dao.ReservationRestClient;
import com.flightCheckedIn.integration.dto.Reservation;
import com.flightCheckedIn.integration.dto.ReservationUpdateRequest;

@Controller
public class CheckInController {

	@Autowired
	private ReservationRestClient restClient;

	@RequestMapping("/showStartCheckIn")
	public String showStartCheckIn() {
		return "startCheckIn";
	}

	@RequestMapping("/startCheckIn")
	public String startCheckIn(@RequestParam("reservationId") Long reservationId, ModelMap modelMap) {
		Reservation reservation = restClient.findReservation(reservationId);
		modelMap.addAttribute("reservation", reservation);
		return "displayReservationDetails";
	}
	
	@RequestMapping(value = "/completeCheckIn",method = RequestMethod.POST)
	public String completeCheckIn(ReservationUpdateRequest request,ModelMap map) {
		Reservation reservation = restClient.updateReservation(request);
		System.out.println("before");
		map.addAttribute("reservation", reservation);
		System.out.println("after");
		return "complete";
	}
}
