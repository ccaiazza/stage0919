/**
 *
 */
package it.uiip.airport.facades.impl;

import de.hybris.platform.servicelayer.dto.converter.Converter;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;

import it.uiip.airport.core.model.FlightModel;
import it.uiip.airport.core.service.FlightService;
import it.uiip.airport.facades.FlightFacade;
import it.uiip.airport.facades.data.FlightData;

/**
 * @author soprasteria
 *
 */
public class DefaultFlightFacade implements FlightFacade
{
	private FlightService flightService;
	private Converter<FlightModel, FlightData> flightConverter;

	/*
	 * (non-Javadoc)
	 *
	 * @see it.uiip.airport.facades.FlightFacade#getAllFlight()
	 */
	@Override
	public List<FlightData> getAllFlight()
	{
		return flightConverter.convertAll(flightService.getAllFlight());
	}

	public FlightService getFlightService()
	{
		return flightService;
	}

	@Required
	public void setFlightService(final FlightService flightService)
	{
		this.flightService = flightService;
	}

	/**
	 * @return the flightConverter
	 */
	public Converter<FlightModel, FlightData> getFlightConverter()
	{
		return flightConverter;
	}

	@Required
	public void setFlightConverter(final Converter<FlightModel, FlightData> flightConverter)
	{
		this.flightConverter = flightConverter;
	}



}
