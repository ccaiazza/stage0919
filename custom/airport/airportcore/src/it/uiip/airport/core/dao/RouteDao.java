/**
 *
 */
package it.uiip.airport.core.dao;

import de.hybris.platform.servicelayer.internal.dao.GenericDao;

import java.util.List;

import it.uiip.airport.core.model.RouteModel;


/**
 * @author tminichiello
 *
 */
public interface RouteDao extends GenericDao<RouteModel>
{
	public List<RouteModel> findAllRoutes();

	public RouteModel findAirportRouteByCodeRoute(String code);

	public List<RouteModel> findRoutesByAirportDeparture(String nameAirport);
}
