/**
 *
 */
package it.uiip.airport.facades;

import java.util.List;

import it.uiip.airport.facades.data.RouteData;


/**
 * @author tminichiello
 *
 */
public interface RouteFacade
{
	public RouteData getRouteForCodeRoute(String codeRoute);

	public List<RouteData> getAllRoutes();

	public List<RouteData> getRoutesForAirportDeparture(String nameAirport);
}
