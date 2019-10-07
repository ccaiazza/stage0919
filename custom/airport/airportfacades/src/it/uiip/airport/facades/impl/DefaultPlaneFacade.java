package it.uiip.airport.facades.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;

import de.hybris.platform.servicelayer.dto.converter.Converter;
import it.uiip.airport.core.model.AirLineModel;
import it.uiip.airport.core.model.PlaneModel;
import it.uiip.airport.core.service.PlaneService;
import it.uiip.airport.facades.PlaneFacade;
import it.uiip.airport.facades.data.AirLineData;
import it.uiip.airport.facades.data.PlaneData;

public class DefaultPlaneFacade implements PlaneFacade {
	
	private PlaneService planeService;
	private Converter<PlaneModel, PlaneData> planeConverter;
	
	
	public PlaneService getPlaneService() {
		return planeService;
	}
	
	@Required
	public void setPlaneService(PlaneService planeService) {
		this.planeService = planeService;
	}
	public Converter<PlaneModel, PlaneData> getPlaneConverter() {
		return planeConverter;
	}
	
	@Required
	public void setPlaneConverter(Converter<PlaneModel, PlaneData> planeConverter) {
		this.planeConverter = planeConverter;
	}
	@Override
	public PlaneData getPlaneForCode(String codePlane) {
		return planeConverter.convert(planeService.getPlaneForCode(codePlane));
	}
	@Override
	public List<PlaneData> getPlanesForState(String state) {
		return planeConverter.convertAll(planeService.getPlanesForState(state));
	}
	@Override
	public List<PlaneData> getPlanesForCodeAirLine(String codeAirLine) {
		return planeConverter.convertAll(planeService.getPlanesForCodeAirLine(codeAirLine));
	}
	@Override
	public List<PlaneData> getAllPlanes() {
		return planeConverter.convertAll(planeService.getAllPlanes());
	}

	
}
