package com.flightReservation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flightReservation.dto.ReservationRequest;
import com.flightReservation.entities.Flight;
import com.flightReservation.entities.Reservation;
import com.flightReservation.repository.FlightRepository;
import com.flightReservation.service.ReservationService;

@Controller
public class ReservationController {
	@Autowired
	private FlightRepository flightRepository;
	@Autowired
	private ReservationService reservationService;
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);

	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap) {
		LOGGER.info("showCompleteReservation() invoked with the flight id: " + flightId);
		Flight flight = flightRepository.findById(flightId).get();
		modelMap.addAttribute("flight", flight);
		LOGGER.info("Flight is " + flight);
		return "completeReservation";
	}

	@RequestMapping("/completeReservation")
	public String completeReservation(ReservationRequest request, ModelMap modelMap) {
		LOGGER.info("completeReservation() " + request);
		Reservation reservation = reservationService.bookFlight(request);
		Long id = reservation.getId();
		System.out.println(id);
		modelMap.addAttribute("msg", "Reservation created successfully and id is " + reservation.getId());
		return "reservationConfirmation";
	}
}
