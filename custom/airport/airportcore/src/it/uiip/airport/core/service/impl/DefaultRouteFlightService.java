/**
 *
 */
package it.uiip.airport.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;

import it.uiip.airport.core.dao.RouteDao;
import it.uiip.airport.core.model.RouteModel;
import it.uiip.airport.core.service.RouteFlightService;


/**
 * @author tminichiello
 *
 */
public class DefaultRouteFlightService implements RouteFlightService
{
	private RouteDao routeDao;

	@Override
	public RouteModel getRouteForCodeRoute(final String codeRoute)
	{
		return routeDao.findAirportRouteByCodeRoute(codeRoute);
	}

	@Override
	public List<RouteModel> getAllRoutes()
	{
		return routeDao.findAllRoutes();
	}

	@Override
	public List<RouteModel> getRoutesForAirportDeparture(final String nameAirport)
	{
		return routeDao.findRoutesByAirportDeparture(nameAirport);
	}

	/**
	 * @return the routeDao
	 */
	public RouteDao getRouteDao()
	{
		return routeDao;
	}

	@Required
	public void setRouteDao(final RouteDao routeDao)
	{
		this.routeDao = routeDao;
	}


}
