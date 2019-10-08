/**
 *
 */
package it.uiip.airport.facades.impl;

import de.hybris.platform.servicelayer.dto.converter.Converter;
import de.hybris.platform.servicelayer.exceptions.ModelNotFoundException;

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
	private Converter<RouteModel, RouteData> routeConverter;

	@Override
	public RouteData getRouteForCodeRoute(final String codeRoute)
	{
		if (codeRoute != null)
		{
			try
			{
				return routeConverter.convert(routeFlightService.getRouteForCodeRoute(codeRoute));
			}
			catch (final ModelNotFoundException e)
			{
				return null;
			}
		}
		else
		{
			return null;
		}
	}

	@Override
	public List<RouteData> getAllRoutes()
	{
		return routeConverter.convertAll(routeFlightService.getAllRoutes());
	}

	@Override
	public List<RouteData> getRoutesForAirportDeparture(final String nameAirport)
	{
		return routeConverter.convertAll(routeFlightService.getRoutesForAirportDeparture(nameAirport));
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
	public Converter<RouteModel, RouteData> getRouteConverter()
	{
		return routeConverter;
	}

	@Required
	public void setRouteConverter(final Converter<RouteModel, RouteData> routeConverter)
	{
		this.routeConverter = routeConverter;
	}



}
