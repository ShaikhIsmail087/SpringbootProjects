package com.flightReservation.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Component
public class EmailUtil {

	@Autowired
	private JavaMailSender sender;
	private static final Logger LOGGER = LoggerFactory.getLogger(JavaMailSender.class);

	public void sendItinerary(String toAddress, String filePath) {
		LOGGER.info("inside sendItinerary()");
		MimeMessage message = sender.createMimeMessage();

		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
			messageHelper.setTo(toAddress);
			messageHelper.setSubject("Itinerary for your flight");
			messageHelper.setText("please find your Itinerary is attached");
			messageHelper.addAttachment("Itinearary", new File(filePath));
			sender.send(message);
			LOGGER.info("Mail sent successfully...");
		} catch (MessagingException e) {
			e.printStackTrace();
			LOGGER.error("Exception inside sendItinerary" + e);
		}
	}

}
