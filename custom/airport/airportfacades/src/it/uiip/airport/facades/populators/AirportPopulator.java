/**
 *
 */
package it.uiip.airport.facades.populators;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

import it.uiip.airport.core.model.AirportModel;
import it.uiip.airport.facades.data.AirportData;


/**
 * @author soprasteria
 *
 */
public class AirportPopulator implements Populator<AirportModel, AirportData>
{

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hybris.platform.converters.Populator#populate(java.lang.Object, java.lang.Object)
	 */
	@Override
	public void populate(final AirportModel source, final AirportData target) throws ConversionException
	{
		target.setCodeAirport(source.getCodeAirport());
		target.setName(source.getName());
		target.setCity(source.getCity());
		target.setCountry(source.getCountry());
		target.setRunways(source.getRunways());

	}

}
