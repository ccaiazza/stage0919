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
	private Converter<AirportModel, AirportData> airportConverter;

	@Override
	public void populate(final RouteModel source, final RouteData target) throws ConversionException
	{
		if (source != null)
		{
			if (source.getCodeRoute() != null)
			{
				target.setCodeRoute(source.getCodeRoute());
			}
			if (source.getRouteTime() != null)
			{
				target.setRouteTime(source.getRouteTime());
			}
			if (source.getAirportDeparture() != null)
			{
				target.setAirportDeparture(airportConverter.convert(source.getAirportDeparture()));
			}
			if (source.getAirportArrival() != null)
			{
				target.setAirportArrival(airportConverter.convert(source.getAirportArrival()));
			}
		}
	}

	/**
	 * @return the airportConverterFacade
	 */
	public Converter<AirportModel, AirportData> getAirportConverter()
	{
		return airportConverter;
	}

	@Required
	public void setAirportConverter(final Converter<AirportModel, AirportData> airportConverter)
	{
		this.airportConverter = airportConverter;
	}



}
