/**
 *
 */
package it.uiip.airport.core.dao.impl;

import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.SearchResult;

import it.uiip.airport.core.dao.AirportDao;
import it.uiip.airport.core.model.AirportModel;

/**
 * @author tminichiello
 *
 */
public class DefaultAirportDao extends DefaultGenericDao<AirportModel> implements AirportDao
{

	/**
	 * @param typecode
	 */
	public DefaultAirportDao(final String typecode)
	{
		super(typecode);
	}

	@Override
	public boolean findAirportByCodeIATA(final String codeIATA)
	{
		final StringBuilder queryStr = new StringBuilder();
		queryStr.append("SELECT {a.pk} FROM {Airport AS a}");
		queryStr.append("WHERE {a.codeIATA} = ?codeIATA");
		final FlexibleSearchQuery fsq = new FlexibleSearchQuery(queryStr);
		fsq.addQueryParameter("codeIATA", codeIATA);
		final SearchResult<AirportModel> result = getFlexibleSearchService().search(fsq);
		return !result.getResult().isEmpty();
	}

}