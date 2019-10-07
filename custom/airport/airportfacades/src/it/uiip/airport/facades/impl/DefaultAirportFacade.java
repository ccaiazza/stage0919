/**
 *
 */
package it.uiip.airport.facades.impl;

import de.hybris.platform.servicelayer.dto.converter.Converter;

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
	private Converter<AirportModel, AirportData> airportConverterFacade;

	@Override
	public List<AirportData> getAllAirports()
	{
		return airportConverterFacade.convertAll(airportService.getAllAirports());
	}

	@Override
	public List<AirportData> getAirportsForCountry(final String country)
	{
		return airportConverterFacade.convertAll(airportService.getAirportsForCountry(country));
	}

	@Override
	public AirportData getAirportForCodeIATA(final String codeIata)
	{
		try
		{
			return airportConverterFacade.convert(airportService.getAirportForCodeIATA(codeIata));
		}
		catch (final Exception e)
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
		return airportConverterFacade;
	}

	@Required
	public void setAirportConverterFacade(final Converter<AirportModel, AirportData> airportConverter)
	{
		this.airportConverterFacade = airportConverter;
	}



}
