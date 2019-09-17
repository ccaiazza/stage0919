/**
 *
 */
package it.uiip.airport.core.dao.impl;

import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.SearchResult;

import java.util.List;

import it.uiip.airport.core.dao.AirportDao;
import it.uiip.airport.core.model.AirportModel;

/**
 * @author soprasteria
 *
 */
public class DefaultAirportDao extends DefaultGenericDao<AirportModel> implements AirportDao
{

	public DefaultAirportDao(final String typecode) {
		super(typecode);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<AirportModel> findAirportsByCity(final String city) {
		final StringBuilder queryStr = new StringBuilder();
		queryStr.append("SELECT {a.pk} FROM {Airport AS a}");
		queryStr.append("WHERE {a.city} = ?city");
		final FlexibleSearchQuery fsq = new FlexibleSearchQuery(queryStr);
		fsq.addQueryParameter("city", city);
		final SearchResult<AirportModel> result = getFlexibleSearchService().search(fsq);
		return result.getResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.uiip.airport.core.dao.AirportDao#findAllAirport()
	 */
	@Override
	public List<AirportModel> findAllAirport()
	{
		final StringBuilder queryStr = new StringBuilder();
		queryStr.append("SELECT {a.pk} FROM {Airport AS a}");
		final FlexibleSearchQuery fsq = new FlexibleSearchQuery(queryStr);
		final SearchResult<AirportModel> result = getFlexibleSearchService().search(fsq);
		return result.getResult();
	}


}
