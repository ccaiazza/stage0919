/**
 *
 */
package it.uiip.airport.facades;

import java.util.List;

import it.uiip.airport.facades.data.AirportData;


/**
 * @author soprasteria
 *
 */
public interface AirportFacade
{
	public List<AirportData> getAllAirport();

	public List<AirportData> getAirportsforCity(String city);
}
