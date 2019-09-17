/**
 *
 */
package it.uiip.airport.core.service.impl;

import de.hybris.platform.servicelayer.user.impl.DefaultUserService;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;

import it.uiip.airport.core.dao.PassengerDao;
import it.uiip.airport.core.model.PassengerModel;
import it.uiip.airport.core.service.PassengerService;


/**
 * @author soprasteria
 *
 */
public class DefaultPassengerService extends DefaultUserService implements PassengerService
{
	private PassengerDao passengerDao;
	private static final Logger LOG = Logger.getLogger(DefaultPassengerService.class);

	@Override
	public List<PassengerModel> getAllPassengers()
	{
		LOG.info("Invoke method findAllPassengers in DefaultPassengerService");
		return passengerDao.findAllPassengers();
	}

	@Override
	public List<PassengerModel> getPassengersForDate(final Date date)
	{
		LOG.info("Invoke method findPassengersByFlightDate in DefaultPassengerService");
		return passengerDao.findPassengersByFlightDate(date);
	}

	public PassengerDao getPassengerDao()
	{
		return passengerDao;
	}


	@Required
	public void setPassengerDao(final PassengerDao passengerDao)
	{
		this.passengerDao = passengerDao;
	}

}
