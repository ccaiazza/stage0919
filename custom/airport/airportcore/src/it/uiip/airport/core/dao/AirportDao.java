/**
 *
 */
package it.uiip.airport.core.dao;

import de.hybris.platform.servicelayer.internal.dao.GenericDao;

import java.util.List;

import it.uiip.airport.core.model.AirportModel;


/**
 * @author soprasteria
 *
 */
public interface AirportDao extends GenericDao<AirportModel> {

	public List<AirportModel> findAirportsByCity(String city);

	public List<AirportModel> findAllAirport();

}
