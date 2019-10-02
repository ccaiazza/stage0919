package it.uiip.airport.core.impexFilterRow;

import java.util.Map;

import org.springframework.beans.factory.annotation.Required;

import de.hybris.platform.acceleratorservices.dataimport.batch.converter.ImpexRowFilter;
import it.uiip.airport.core.service.AirLineService;

public class PlaneImpexRowFilter implements ImpexRowFilter {
	
	private AirLineService airLineService;
	
	
	@Override
	public boolean filter(Map<Integer, String> row) {
		final String codeAirline=row.get(5);
		if(airLineService.getAirLineForCodeAirLine(codeAirline)) {
			return true;
		}
		return false;
	}


	public AirLineService getAirLineService() {
		return airLineService;
	}

	@Required
	public void setAirLineService(AirLineService airLineService) {
		this.airLineService = airLineService;
	}

}
