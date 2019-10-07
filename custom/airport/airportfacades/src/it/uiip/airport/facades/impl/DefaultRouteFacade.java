/**
 *
 */
package it.uiip.airport.facades.impl;

import de.hybris.platform.servicelayer.dto.converter.Converter;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;

import it.uiip.airport.core.model.RouteModel;
import it.uiip.airport.core.service.RouteFlightService;
import it.uiip.airport.facades.RouteFacade;
import it.uiip.airport.facades.data.RouteData;



/**
 * @author tminichiello
 *
 */
public class DefaultRouteFacade implements RouteFacade
{
	private RouteFlightService routeFlightService;
	private Converter<RouteModel, RouteData> routeConverterFacade;

	@Override
	public RouteData getRouteForCodeRoute(final String codeRoute)
	{
		try
		{
			return routeConverterFacade.convert(routeFlightService.getRouteForCodeRoute(codeRoute));
		}
		catch (final Exception e)
		{
			return null;
		}
	}

	@Override
	public List<RouteData> getAllRoutes()
	{
		return routeConverterFacade.convertAll(routeFlightService.getAllRoutes());
	}

	@Override
	public List<RouteData> getRoutesForAirportDeparture(final String nameAirport)
	{
		return routeConverterFacade.convertAll(routeFlightService.getRoutesForAirportDeparture(nameAirport));
	}


	/**
	 * @return the routeService
	 */
	public RouteFlightService getRouteService()
	{
		return routeFlightService;
	}

	@Required
	public void setRouteFlightService(final RouteFlightService routeService)
	{
		this.routeFlightService = routeService;
	}

	/**
	 * @return the routeConverterFacade
	 */
	public Converter<RouteModel, RouteData> getRouteConverterFacade()
	{
		return routeConverterFacade;
	}

	@Required
	public void setRouteConverterFacade(final Converter<RouteModel, RouteData> routeConverterFacade)
	{
		this.routeConverterFacade = routeConverterFacade;
	}



}
