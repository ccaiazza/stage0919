package it.uiip.airport.core.service.impl;


import java.util.List;


import org.springframework.beans.factory.annotation.Required;
import org.springframework.util.Assert;

import it.uiip.airport.core.dao.AirLineDao;
import it.uiip.airport.core.model.AirLineModel;
import it.uiip.airport.core.service.AirLineService;

public class DefaultAirLineService implements AirLineService {
	
	private AirLineDao airLineDao;
	

	public AirLineDao getAirLineDao() {
		return airLineDao;
	}

	@Required
	public void setAirLineDao(AirLineDao airLineDao) {
		this.airLineDao = airLineDao;
	}


	@Override
	public AirLineModel getAirLineForCodeAirLine(String codeAirLine) {
		Assert.notNull(codeAirLine,"codeAirLineIsNull");
		return airLineDao.findAirLineByCodeAirLine(codeAirLine);
	}

	@Override
	public List<AirLineModel> getAllAirLines() {
		return airLineDao.findAllAirLines();
	}

}
