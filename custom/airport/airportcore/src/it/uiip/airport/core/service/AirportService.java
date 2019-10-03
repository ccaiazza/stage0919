/**
 *
 */
package it.uiip.airport.core.service;

import it.uiip.airport.core.model.AirportModel;


/**
 * @author tminichiello
 *
 */
public interface AirportService
{
	public AirportModel getAirportForCodeIATA(String codeIata);
}


