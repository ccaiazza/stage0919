package it.uiip.airport.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;

import it.uiip.airport.core.dao.PlaneDao;
import it.uiip.airport.core.model.AirportModel;
import it.uiip.airport.core.model.PlaneModel;
import it.uiip.airport.core.service.AirportService;
import it.uiip.airport.core.service.PlaneService;

public class DefaultPlaneService implements PlaneService {
	
	private PlaneDao planeDao;

	@Override
	public PlaneModel getPlaneForCode(String codePlane) {
		return planeDao.findPlaneByCode(codePlane);
	}

	@Override
	public List<PlaneModel> getPlanesForState(String state) {
		return planeDao.findPlanesByState(state);
	}

	@Override
	public List<PlaneModel> getPlanesForCodeAirLine(String codeAirLine) {
		return planeDao.findPlanesByCodeAirLine(codeAirLine);
	}

	@Override
	public List<PlaneModel> getAllPlanes() {
		return planeDao.findAllPlanes();
	}
	
	
	public PlaneDao getPlaneDao() {
		return planeDao;
	}
	
	@Required
	public void setPlaneDao(PlaneDao planeDao) {
		this.planeDao = planeDao;
	}
	
	
	


}
