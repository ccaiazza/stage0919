/**
 *
 */
package it.uiip.airport.core.dao;

import de.hybris.platform.servicelayer.internal.dao.GenericDao;

import it.uiip.airport.core.model.AirportModel;


/**
 * @author tminichiello
 *
 */
public interface AirportDao extends GenericDao<AirportModel>
{
	public boolean findAirportByCodeIATA(String codeIATA);
}
