package it.uiip.airport.facades.impl;

import it.uiip.airport.core.model.AirLineModel;
import it.uiip.airport.core.service.AirLineService;
import it.uiip.airport.facades.AirLineFacade;
import it.uiip.airport.facades.data.AirLineData;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;

import de.hybris.platform.servicelayer.dto.converter.Converter;

public class DefaultAirLineFacade implements AirLineFacade {
	
	private AirLineService airLineService;
	private Converter<AirLineModel, AirLineData> airLineConverter;

	
	public AirLineService getAirLineService() {
		return airLineService;
	}

	@Required
	public void setAirLineService(AirLineService airLineService) {
		this.airLineService = airLineService;
	}
	

	public Converter<AirLineModel, AirLineData> getAirLineConverter() {
		return airLineConverter;
	}
	
	@Required
	public void setAirLineConverter(Converter<AirLineModel, AirLineData> airLineConverter) {
		this.airLineConverter = airLineConverter;
	}

	@Override
	public AirLineData getAirLineforCodeAirLine(String codeAirLine) {
		try {
					return airLineConverter.convert(airLineService.getAirLineForCodeAirLine(codeAirLine));
		}catch(Exception e) {
			return null;
		}
	}

	@Override
	public List<AirLineData> getAllAirLines() {
		return airLineConverter.convertAll(airLineService.getAllAirLines());
	}

}
