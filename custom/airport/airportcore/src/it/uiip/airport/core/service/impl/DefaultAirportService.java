/**
 *
 */
package it.uiip.airport.core.service.impl;

import org.springframework.beans.factory.annotation.Required;

import it.uiip.airport.core.dao.AirportDao;
import it.uiip.airport.core.service.AirportService;

/**
 * @author tminichiello
 *
 */
public class DefaultAirportService implements AirportService
{
	private AirportDao airportDao;

	@Override
	public boolean getAirportForCodeIATA(final String codeIATA)
	{
		return airportDao.findAirportByCodeIATA(codeIATA);
	}



	public AirportDao getAirportDao()
	{
		return airportDao;
	}

	@Required
	public void setAirportDao(final AirportDao airportDao)
	{
		this.airportDao = airportDao;
	}

}
