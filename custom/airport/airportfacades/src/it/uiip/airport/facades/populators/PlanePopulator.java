package it.uiip.airport.facades.populators;

import org.springframework.beans.factory.annotation.Required;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import it.uiip.airport.core.model.AirLineModel;
import it.uiip.airport.core.model.PlaneModel;
import it.uiip.airport.facades.data.AirLineData;
import it.uiip.airport.facades.data.PlaneData;

public class PlanePopulator implements Populator<PlaneModel,PlaneData> {
	
	private Converter<AirLineModel,AirLineData> airLineConverter;
	
	@Override
	public void populate(PlaneModel source, PlaneData target) throws ConversionException {
		
		target.setCodePlane(source.getCodePlane());
		target.setModel(source.getModel().getCode());
		target.setStatePlane(source.getStatePlane().getCode());
		target.setNumberMaxSits(source.getNumberMaxSits());
		target.setGoods(source.getGoods());
		target.setAirLine(airLineConverter.convert(source.getAirline()));
		
		
	}

	public Converter<AirLineModel, AirLineData> getAirLineConverter() {
		return airLineConverter;
	}
	
	@Required
	public void setAirLineConverter(Converter<AirLineModel, AirLineData> airLineConverter) {
		this.airLineConverter = airLineConverter;
	}
	
	
	
}
