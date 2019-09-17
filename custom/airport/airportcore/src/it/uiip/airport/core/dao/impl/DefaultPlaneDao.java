/**
 *
 */
package it.uiip.airport.core.dao.impl;

import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.SearchResult;

import java.util.List;

import it.uiip.airport.core.dao.PlaneDao;
import it.uiip.airport.core.model.PlaneModel;

/**
 * @author soprasteria
 *
 */
public class DefaultPlaneDao extends DefaultGenericDao<PlaneModel> implements PlaneDao {

	public DefaultPlaneDao(final String typecode) {
		super(typecode);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<PlaneModel> findPlanesByCity(final String city) {
		final StringBuilder queryStr= new StringBuilder();
		queryStr.append("SELECT * FROM {Plane as p JOIN Flight AS f");
		queryStr.append("ON {f.plane} = {p.PK} JOIN Route AS r");
		queryStr.append("ON {r.flight} = {f.PK} JOIN Airport AS a");
		queryStr.append("ON {f.airportArr} = {a.PK}}");
		queryStr.append("WHERE {a.city} = ?city");
		final FlexibleSearchQuery fsq = new FlexibleSearchQuery(queryStr);
		fsq.addQueryParameter("city", city);
		final SearchResult<PlaneModel> result = getFlexibleSearchService().search(fsq);
		return result.getResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.uiip.airport.core.dao.PlaneDao#findAllPlanes()
	 */
	@Override
	public List<PlaneModel> findAllPlanes()
	{
		final StringBuilder queryStr = new StringBuilder();
		queryStr.append("SELECT * FROM {Plane as p}}");
		final FlexibleSearchQuery fsq = new FlexibleSearchQuery(queryStr);
		final SearchResult<PlaneModel> result = getFlexibleSearchService().search(fsq);
		return result.getResult();
	}

}
