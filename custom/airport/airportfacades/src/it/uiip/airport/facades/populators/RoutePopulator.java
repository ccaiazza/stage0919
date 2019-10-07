/**
 *
 */
package it.uiip.airport.facades.populators;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.dto.converter.Converter;

import org.springframework.beans.factory.annotation.Required;

import it.uiip.airport.core.model.AirportModel;
import it.uiip.airport.core.model.RouteModel;
import it.uiip.airport.facades.data.AirportData;
import it.uiip.airport.facades.data.RouteData;


/**
 * @author tminichiello
 *
 */
public class RoutePopulator implements Populator<RouteModel, RouteData>
{
	private Converter<AirportModel, AirportData> airportConverterFacade;

	@Override
	public void populate(final RouteModel source, final RouteData target) throws ConversionException
	{
		target.setCodeRoute(source.getCodeRoute());
		target.setRouteTime(source.getRouteTime());
		target.setAirportDeparture(airportConverterFacade.convert(source.getAirportDeparture()));
		target.setAirportArrival(airportConverterFacade.convert(source.getAirportArrival()));
	}

	/**
	 * @return the airportConverterFacade
	 */
	public Converter<AirportModel, AirportData> getAirportConverterFacade()
	{
		return airportConverterFacade;
	}

	@Required
	public void setAirportConverterFacade(final Converter<AirportModel, AirportData> airportConverterFacade)
	{
		this.airportConverterFacade = airportConverterFacade;
	}



}
