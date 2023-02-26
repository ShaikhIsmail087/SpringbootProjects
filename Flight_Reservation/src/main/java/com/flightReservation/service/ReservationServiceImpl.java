package com.flightReservation.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightReservation.dto.ReservationRequest;
import com.flightReservation.entities.Flight;
import com.flightReservation.entities.Passenger;
import com.flightReservation.entities.Reservation;
import com.flightReservation.repository.FlightRepository;
import com.flightReservation.repository.PassengerRepositorty;
import com.flightReservation.repository.ReservationRepository;
import com.flightReservation.util.EmailUtil;
import com.flightReservation.util.PDFGenerator;

@Service
public class ReservationServiceImpl implements ReservationService {
	@Autowired
	private FlightRepository flightRepository;
	@Autowired
	private PassengerRepositorty passengerRepository;
	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	PDFGenerator pdfGenerator;

	@Autowired
	EmailUtil emailUtil;
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);

	@Override
	public Reservation bookFlight(ReservationRequest request) {
		LOGGER.info("inside bookFlight()");
		// make payment
		Long flightId = request.getId();
		LOGGER.info("Fetching Flight fo flight id: " + flightId);
		Flight flight = flightRepository.findById(flightId).get();
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerlastName());
		passenger.setPhone(request.getPassengerPhone());
		passenger.setEmail(request.getPassengerEmail());
		LOGGER.info("saving the passenger " + passenger);
		Passenger savedPassenger = passengerRepository.save(passenger);

		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);
		LOGGER.info("saving reservation: " + reservation);
		Reservation savedReservation = reservationRepository.save(reservation);
		String filePath = "D:\\Project_path" + savedReservation.getId() + ".pdf";
		LOGGER.info("generating the iteratiory");
		pdfGenerator.generateItinerary(savedReservation, filePath);
		emailUtil.sendItinerary(passenger.getEmail(), filePath);
		LOGGER.info("Emailing the iteratiory");
		return savedReservation;
	}

}
