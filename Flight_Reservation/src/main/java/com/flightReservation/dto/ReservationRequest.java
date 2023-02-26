package com.flightReservation.dto;

import com.flightReservation.entities.AbstractEntity;

public class ReservationRequest extends AbstractEntity{

	// private Long flightId;
	private String passengerFirstName;
	private String passengerlastName;
	private String passengerEmail;
	private String passengerPhone;
	private String nameOnTheCard;
	private String cardNumber;
	private String expirationDate;
	private String securityCode;

	public String getPassengerFirstName() {
		return passengerFirstName;
	}

	public void setPassengerFirstName(String passengerFirstName) {
		this.passengerFirstName = passengerFirstName;
	}

	public String getPassengerlastName() {
		return passengerlastName;
	}

	public void setPassengerlastName(String passengerlastName) {
		this.passengerlastName = passengerlastName;
	}

	public String getPassengerEmail() {
		return passengerEmail;
	}

	public void setPassengerEmail(String passengerEmail) {
		this.passengerEmail = passengerEmail;
	}

	public String getPassengerPhone() {
		return passengerPhone;
	}

	public void setPassengerPhone(String passengerPhone) {
		this.passengerPhone = passengerPhone;
	}

	public String getNameOnTheCard() {
		return nameOnTheCard;
	}

	public void setNameOnTheCard(String nameOnTheCard) {
		this.nameOnTheCard = nameOnTheCard;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	@Override
	public String toString() {
		return "ReservationRequest [passengerFirstName=" + passengerFirstName + ", passengerlastName="
				+ passengerlastName + ", passengerEmail=" + passengerEmail + ", passengerPhone=" + passengerPhone
				+ ", nameOnTheCard=" + nameOnTheCard + ", cardNumber=" + cardNumber + ", expirationDate="
				+ expirationDate + ", securityCode=" + securityCode + "]";
	}
	
	

}
