/**
 *
 */
package it.uiip.airport.core.impexFilterRow;


import de.hybris.platform.acceleratorservices.dataimport.batch.converter.ImpexRowFilter;

import java.util.Map;

import org.springframework.beans.factory.annotation.Required;

import it.uiip.airport.core.service.AirportService;


/**
 * @author tminichiello
 *
 */
public class RouteImpexRowFilter implements ImpexRowFilter
{
	private AirportService airportService;


	@Override
	public boolean filter(final Map<Integer, String> row)
	{
		final String s = row.toString();
		final String codeIATADeparture = row.get(1);
		final String codeIATAArrival = row.get(2);
		if (airportService.getAirportForCodeIATA(codeIATADeparture) && airportService.getAirportForCodeIATA(codeIATAArrival))
		{
			return true;
		}

		return false;
	}


	public AirportService getAirportService()
	{
		return airportService;
	}

	@Required
	public void setAirportService(final AirportService airportService)
	{
		this.airportService = airportService;
	}



}
