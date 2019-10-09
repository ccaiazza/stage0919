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
		if(source!= null) {
			if(source.getCodePlane()!=null) {
							target.setCodePlane(source.getCodePlane());
			}
			if(source.getModel().getCode() !=null) {
				target.setModel(source.getModel().getCode());
			}
			if(source.getStatePlane().getCode()!= null) {
				target.setStatePlane(source.getStatePlane().getCode());
			}
			if(source.getNumberMaxSits()!=null) {
				target.setNumberMaxSits(source.getNumberMaxSits());
			}
			if(source.getGoods()!=null) {
				target.setGoods(source.getGoods());
			}
			if(source.getAirline()!=null) {
				target.setAirLine(airLineConverter.convert(source.getAirline()));
			}
		}

		
		
	}

	public Converter<AirLineModel, AirLineData> getAirLineConverter() {
		return airLineConverter;
	}
	
	@Required
	public void setAirLineConverter(Converter<AirLineModel, AirLineData> airLineConverter) {
		this.airLineConverter = airLineConverter;
	}
	
	
	
}
