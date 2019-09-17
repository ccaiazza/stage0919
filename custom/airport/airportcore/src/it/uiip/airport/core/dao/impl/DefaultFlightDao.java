/**
 *
 */
package it.uiip.airport.core.dao.impl;

import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.SearchResult;

import java.util.Date;
import java.util.List;

import it.uiip.airport.core.dao.FlightDao;
import it.uiip.airport.core.model.FlightModel;

/**
 * @author soprasteria
 *
 */
public class DefaultFlightDao extends DefaultGenericDao<FlightModel> implements FlightDao{

	public DefaultFlightDao(final String typecode) {
		super(typecode);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<FlightModel> findFlightsByDepartureCity(final String city) {
		final StringBuilder queryString = new StringBuilder();
		queryString.append("SELECT {f.pk}");
		queryString.append("FROM {Flight AS f");
		queryString.append("JOIN Airport AS a ON {f.airportDep} = {a.pk}}");
		queryString.append("WHERE {a.city} = ?city");
		final FlexibleSearchQuery fsq = new FlexibleSearchQuery(queryString);
		fsq.addQueryParameter("city", city);
		final SearchResult<FlightModel> result = getFlexibleSearchService().search(fsq);
		return result.getResult();
	}

	@Override
	public List<FlightModel> findFlightsByDepartureDate(final Date date) {
		final StringBuilder queryString = new StringBuilder();
		queryString.append("SELECT {f.pk} ");
		queryString.append("FROM {Flight AS f");
		queryString.append("JOIN Route AS r ON {r.flight} = {f.pk}}");
		queryString.append("WHERE {r.dateRouteDep} LIKE '?date%'");
		final FlexibleSearchQuery fsq = new FlexibleSearchQuery(queryString);
		fsq.addQueryParameter("date", date);
		final SearchResult<FlightModel> result = getFlexibleSearchService().search(fsq);
		return result.getResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.uiip.airport.core.dao.FlightDao#findAllFlight()
	 */
	@Override
	public List<FlightModel> findAllFlight()
	{
		final StringBuilder queryString = new StringBuilder();
		queryString.append("SELECT {f.pk} ");
		queryString.append("FROM {Flight AS f}}");
		final FlexibleSearchQuery fsq = new FlexibleSearchQuery(queryString);
		final SearchResult<FlightModel> result = getFlexibleSearchService().search(fsq);
		return result.getResult();
	}

}
