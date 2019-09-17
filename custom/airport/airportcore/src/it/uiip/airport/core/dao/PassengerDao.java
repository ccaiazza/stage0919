/**
 *
 */
package it.uiip.airport.core.dao;

import de.hybris.platform.servicelayer.internal.dao.GenericDao;

import java.util.Date;
import java.util.List;

import it.uiip.airport.core.model.PassengerModel;

/**
 * @author soprasteria
 *
 */
public interface PassengerDao extends GenericDao<PassengerModel>
{
	public List<PassengerModel> findPassengersByFlightDate(Date date);

	public List<PassengerModel> findAllPassengers();
}


