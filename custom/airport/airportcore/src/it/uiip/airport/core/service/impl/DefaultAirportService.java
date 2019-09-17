/**
 *
 */
package it.uiip.airport.core.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;

import it.uiip.airport.core.dao.AirportDao;
import it.uiip.airport.core.model.AirportModel;
import it.uiip.airport.core.service.AirportService;


/**
 * @author soprasteria
 *
 */
public class DefaultAirportService implements AirportService
{
	private static final Logger LOG = Logger.getLogger(DefaultAirportService.class);
	private AirportDao airportDao;


	@Override
	public List<AirportModel> getAirportsForCity(final String city)
	{
		// XXX Auto-generated method stub
		LOG.info("Invoke method findAirportsByCity in DefaultAirportService");
		return airportDao.findAirportsByCity(city);
	}


	/**
	 * @return the airportDao
	 */
	public AirportDao getAirportDao()
	{
		return airportDao;
	}


	@Required
	public void setAirportDao(final AirportDao airportDao)
	{
		this.airportDao = airportDao;
	}


	/*
	 * (non-Javadoc)
	 *
	 * @see it.uiip.airport.core.service.AirportService#getAllAirport()
	 */
	@Override
	public List<AirportModel> getAllAirport()
	{
		LOG.info("Invoke method findAllAirport in DefaultAirportService");
		return airportDao.findAllAirport();
	}


}
