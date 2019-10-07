package it.uiip.airport.facades;

import java.util.List;

import it.uiip.airport.core.model.PlaneModel;
import it.uiip.airport.facades.data.PlaneData;

public interface PlaneFacade {
	public PlaneData getPlaneForCode(String codePlane);
	public List<PlaneData> getPlanesForState(String state);
	public List<PlaneData> getPlanesForCodeAirLine(String codeAirLine);
	public List<PlaneData> getAllPlanes();

}
