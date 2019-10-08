/**
 *
 */
package it.uiip.airport.facades.impl;

import de.hybris.platform.servicelayer.dto.converter.Converter;
import de.hybris.platform.servicelayer.exceptions.ModelNotFoundException;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;

import it.uiip.airport.core.model.AirportModel;
import it.uiip.airport.core.service.AirportService;
import it.uiip.airport.facades.AirportFacade;
import it.uiip.airport.facades.data.AirportData;


/**
 * @author tminichiello
 *
 */
public class DefaultAirportFacade implements AirportFacade
{
	private AirportService airportService;
	private Converter<AirportModel, AirportData> airportConverter;

	@Override
	public List<AirportData> getAllAirports()
	{
		return airportConverter.convertAll(airportService.getAllAirports());
	}

	@Override
	public List<AirportData> getAirportsForCountry(final String country)
	{
		return airportConverter.convertAll(airportService.getAirportsForCountry(country));
	}

	@Override
	public AirportData getAirportForCodeIATA(final String codeIata)
	{
		if (codeIata != null)
		{
			try
			{
				return airportConverter.convert(airportService.getAirportForCodeIATA(codeIata));
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

	/**
	 * @return the airportService
	 */
	public AirportService getAirportService()
	{
		return airportService;
	}

	@Required
	public void setAirportService(final AirportService airportService)
	{
		this.airportService = airportService;
	}

	/**
	 * @return the airportConverter
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
