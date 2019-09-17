package it.uiip.airport.core.service;

import java.util.Date;
import java.util.List;

import it.uiip.airport.core.model.FlightModel;

public interface FlightService {

	public List<FlightModel> getFlightsForCity(String city);
	public List<FlightModel> getFlightsForDate(Date date);
	public List<FlightModel> getAllFlight();
}
