package it.uiip.airport.facades.populators;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import it.uiip.airport.core.model.AirLineModel;
import it.uiip.airport.facades.data.AirLineData;

public class AirLinePopulator implements Populator<AirLineModel, AirLineData> {

	@Override
	public void populate(final AirLineModel source, final AirLineData target) throws ConversionException {

		if (source != null) {
			if (source.getCodeAirLine() != null) {
				target.setCodeAirLine(source.getCodeAirLine());
			}
			if(source.getName()!=null) {
							target.setName(source.getName());
			}
		}

	}

}
