package it.uiip.airport.core.handler;

import java.util.Date;

import de.hybris.platform.servicelayer.model.attribute.DynamicAttributeHandler;

import it.uiip.airport.core.model.PassengerModel;

public class AgePassengerHandler implements DynamicAttributeHandler<Integer, PassengerModel>{

	@Override
	public Integer get(PassengerModel passenger) {
		return passenger.getCurrentDate().getYear()-passenger.getBirthday().getYear();
	}

	@Override
	public void set(PassengerModel passenger, Integer age) {

	}

}
