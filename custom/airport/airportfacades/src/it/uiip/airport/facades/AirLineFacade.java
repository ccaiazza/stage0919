package it.uiip.airport.facades;
import java.util.List;

import it.uiip.airport.facades.data.AirLineData;


public interface AirLineFacade {
	
	public AirLineData getAirLineforCodeAirLine(String codeAirLine);
	public List<AirLineData> getAllAirLines();

}
