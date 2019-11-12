/**
 *
 */
package it.uiip.airport.facades.populators;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.StubLocaleProvider;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.internal.model.impl.LocaleProvider;
import de.hybris.platform.servicelayer.model.ItemModelContextImpl;

import java.util.Locale;

import it.uiip.airport.core.model.AirportModel;
import it.uiip.airport.facades.data.AirportData;

/**
 * @author tminichiello
 *
 */
public class AirportReversePopulator implements Populator<AirportData, AirportModel>
{

	@Override
	public void populate(final AirportData source, final AirportModel target) throws ConversionException
	{
		final LocaleProvider localeProvider = new StubLocaleProvider(Locale.ENGLISH);
		final ItemModelContextImpl itemModelContext = (ItemModelContextImpl) target.getItemModelContext();
		itemModelContext.setLocaleProvider(localeProvider);
		if (source != null)
		{
			if (source.getCodeIATA() != null)
			{
				target.setCodeIATA(source.getCodeIATA());
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

}
