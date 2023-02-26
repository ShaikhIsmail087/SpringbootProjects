package com.flightReservation.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flightReservation.entities.Flight;
import com.flightReservation.repository.FlightRepository;

@Controller
public class FlightController {
	@Autowired
	private FlightRepository flightRepository;
	private static final Logger LOGGER = LoggerFactory.getLogger(FlightController.class);

	@RequestMapping("/findFlights")
	public String findFlights(@RequestParam("from") String from, @RequestParam("to") String to,
			@RequestParam("dateOfDeparture") String date, ModelMap modelMap) throws ParseException {
		LOGGER.info("inside findFlights() From:" + from + "To:" + to + "Departure Date: " + date);
		Date departureDate = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(date);
		List<Flight> flights = flightRepository.findFlights(from, to, departureDate);
		modelMap.addAttribute("flights", flights);
		LOGGER.info("Flight Found Here: " + flights);
		return "displayFlights";
	}
}
