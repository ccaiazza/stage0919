package it.uiip.airport.core.dao;



import java.util.List;

import de.hybris.platform.servicelayer.internal.dao.GenericDao;
import it.uiip.airport.core.model.AirLineModel;

public interface AirLineDao extends GenericDao<AirLineModel>{
	

	public AirLineModel findAirLineByCodeAirLine(String codeAirLine);
	public List<AirLineModel> findAllAirLines();
}