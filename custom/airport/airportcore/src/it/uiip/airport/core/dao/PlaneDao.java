package it.uiip.airport.core.dao;

import java.util.List;

import de.hybris.platform.servicelayer.internal.dao.GenericDao;
import it.uiip.airport.core.model.PlaneModel;

public interface PlaneDao extends GenericDao<PlaneModel>{

	public PlaneModel findPlaneByCode(String codePlane);
	public List<PlaneModel> findPlanesByState(String state);
	public List<PlaneModel> findPlanesByCodeAirLine(String codeAirLine);
	public List<PlaneModel> findAllPlanes();
}
