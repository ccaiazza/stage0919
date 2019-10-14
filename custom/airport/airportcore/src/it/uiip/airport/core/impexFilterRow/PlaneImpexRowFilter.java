package it.uiip.airport.core.impexFilterRow;

import de.hybris.platform.acceleratorservices.dataimport.batch.converter.ImpexRowFilter;

import java.util.Map;

import org.springframework.beans.factory.annotation.Required;

import it.uiip.airport.core.service.AirLineService;

public class PlaneImpexRowFilter implements ImpexRowFilter {
	
	private AirLineService airLineService;
	
	
	@Override
	public boolean filter(final Map<Integer, String> row) {
		final String codeAirline=row.get(5);
		if(airLineService.getAirLineForCodeAirLine(codeAirline)!=null) {
			return true;
		}
		return false;
	}


	public AirLineService getAirLineService() {
		return airLineService;
	}

	@Required
	public void setAirLineService(final AirLineService airLineService) {
		this.airLineService = airLineService;
	}

}
