/**
 *
 */
package it.uiip.airport.core.dao;

import de.hybris.platform.servicelayer.internal.dao.GenericDao;

import java.util.List;

import it.uiip.airport.core.model.AirportModel;


/**
 * @author tminichiello
 *
 */
public interface AirportDao extends GenericDao<AirportModel>
{
	public AirportModel findAirportByCodeIATA(String codeIATA);

	public List<AirportModel> findAirportsByCountry(String country);

	public List<AirportModel> findAllAirports();

	public boolean addAirport(AirportModel airport);
}
