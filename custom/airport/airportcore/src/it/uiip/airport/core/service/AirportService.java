/**
 *
 */
package it.uiip.airport.core.service;

import java.util.List;

import it.uiip.airport.core.model.AirportModel;


/**
 * @author tminichiello
 *
 */
public interface AirportService
{
	public AirportModel getAirportForCodeIATA(String codeIata);

	public List<AirportModel> getAllAirports();

	public List<AirportModel> getAirportsForCountry(String country);

	public boolean addAirport(AirportModel airport);
}


