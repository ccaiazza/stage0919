package it.uiip.airport.core.service;

import java.util.List;

import it.uiip.airport.core.model.PlaneModel;

public interface PlaneService {
	public PlaneModel getPlaneForCode(String codePlane);
	public List<PlaneModel> getPlanesForState(String state);
	public List<PlaneModel> getPlanesForCodeAirLine(String codeAirLine);
	public List<PlaneModel> getAllPlanes();

}
