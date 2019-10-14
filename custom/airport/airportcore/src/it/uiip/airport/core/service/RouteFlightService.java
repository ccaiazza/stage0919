/**
 *
 */
package it.uiip.airport.core.service;


import java.util.List;

import it.uiip.airport.core.model.RouteModel;



/**
 * @author tminichiello
 *
 */
public interface RouteFlightService
{
	public RouteModel getRouteForCodeRoute(String codeRoute);

	public List<RouteModel> getAllRoutes();

	public List<RouteModel> getRoutesForAirportDeparture(String nameAirport);

}
