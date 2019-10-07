/**
 *
 */
package it.uiip.airport.facades.populators;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

import it.uiip.airport.core.model.AirportModel;
import it.uiip.airport.facades.data.AirportData;

/**
 * @author tminichiello
 *
 */
public class AirportPopulator implements Populator<AirportModel, AirportData>
{

	@Override
	public void populate(final AirportModel source, final AirportData target) throws ConversionException
	{
		target.setCodeAirport(source.getCodeIATA());
		target.setName(source.getName());
		target.setCity(source.getCity());
		target.setCountry(source.getCountry());
		target.setRunways(source.getRunways());

	}
}
