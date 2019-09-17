package it.uiip.airport.core.service;

import java.util.List;

import it.uiip.airport.core.model.PlaneModel;

public interface PlaneService {

	 public List<PlaneModel> getPlanesForCity(String city);

	public List<PlaneModel> getAllPlanes();

}
