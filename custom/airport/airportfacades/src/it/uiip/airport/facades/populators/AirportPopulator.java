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
		if (source.getCodeIATA() != null)
		{
			target.setCodeAirport(source.getCodeIATA());
		}
		if (source.getName() != null)
		{
			target.setName(source.getName());
		}
		if (source.getCity() != null)
		{
			target.setCity(source.getCity());
		}
		if (source.getCountry() != null)
		{
			target.setCountry(source.getCountry());
		}
		if (source.getRunways() != null)
		{
			target.setRunways(source.getRunways());
		}

	}
}
