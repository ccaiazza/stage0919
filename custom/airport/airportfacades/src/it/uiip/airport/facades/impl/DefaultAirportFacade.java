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
 * @author soprasteria
 *
 */
public class DefaultAirportFacade implements AirportFacade
{
	private AirportService airportService;

	private Converter<AirportModel, AirportData> airportConverter;

	/* (non-Javadoc)
	 * @see it.uiip.airport.facades.AirportFacade#getAllAirport()
	 */
	@Override
	public List<AirportData> getAllAirport()
	{
		return airportConverter.convertAll(airportService.getAllAirport());
	}


	public AirportService getAirportService()
	{
		return airportService;
	}

	@Required
	public void setAirportService(final AirportService airportService)
	{
		this.airportService = airportService;
	}



	public Converter<AirportModel, AirportData> getAirportConverter()
	{
		return airportConverter;
	}


	@Required
	public void setAirportConverter(final Converter<AirportModel, AirportData> airportConverter)
	{
		this.airportConverter = airportConverter;
	}


	/*
	 * (non-Javadoc)
	 *
	 * @see it.uiip.airport.facades.AirportFacade#getAirportforCity(java.lang.String)
	 */
	@Override
	public List<AirportData> getAirportsforCity(final String city)
	{
		return airportConverter.convertAll(airportService.getAirportsForCity(city));
	}



}
