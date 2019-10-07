/**
 *
 */
package it.uiip.airport.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;

import it.uiip.airport.core.dao.AirportDao;
import it.uiip.airport.core.model.AirportModel;
import it.uiip.airport.core.service.AirportService;

/**
 * @author tminichiello
 *
 */
public class DefaultAirportService implements AirportService
{
	private AirportDao airportDao;

	@Override
	public AirportModel getAirportForCodeIATA(final String codeIATA)
	{
		return airportDao.findAirportByCodeIATA(codeIATA);
	}


	@Override
	public List<AirportModel> getAllAirports()
	{
		return airportDao.findAllAirports();
	}



	@Override
	public List<AirportModel> getAirportsForCountry(final String country)
	{
		return airportDao.findAirportsByCountry(country);
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
