/**
 *
 */
package it.uiip.airport.facades;

import java.util.List;

import it.uiip.airport.facades.data.AirportData;

/**
 * @author tminichiello
 *
 */
public interface AirportFacade
{
	public List<AirportData> getAllAirports();

	public List<AirportData> getAirportsForCountry(String country);

	public AirportData getAirportForCodeIATA(String codeIata);
}
