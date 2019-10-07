package it.uiip.airport.core.service;



import java.util.List;

import it.uiip.airport.core.model.AirLineModel;

public interface AirLineService {

	public AirLineModel getAirLineForCodeAirLine(String codeAirLine);
	public List<AirLineModel> getAllAirLines();
}
