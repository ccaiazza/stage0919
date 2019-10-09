/**
 *
 */
package it.uiip.airport.core.dao.impl;

import de.hybris.platform.servicelayer.exceptions.ModelNotFoundException;
import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.SearchResult;

import java.util.List;

import org.apache.log4j.Logger;

import it.uiip.airport.core.dao.RouteDao;
import it.uiip.airport.core.model.RouteModel;


/**
 * @author tminichiello
 *
 */
public class DefaultRouteDao extends DefaultGenericDao<RouteModel> implements RouteDao
{

	private static final Logger LOG = Logger.getLogger(DefaultRouteDao.class);
	/**
	 * @param typecode
	 */
	public DefaultRouteDao(final String typecode)
	{
		super(typecode);
	}

	@Override
	public List<RouteModel> findAllRoutes()
	{
		final StringBuilder queryStr = new StringBuilder();
		queryStr.append("SELECT {R.pk} FROM {Route AS R}");
		final FlexibleSearchQuery fsq = new FlexibleSearchQuery(queryStr);
		final SearchResult<RouteModel> result = getFlexibleSearchService().search(fsq);
		return result.getResult();
	}

	@Override
	public RouteModel findAirportRouteByCodeRoute(final String codeRoute)
	{
		final StringBuilder queryStr = new StringBuilder();
		queryStr.append("SELECT {R.pk} FROM {Route AS R}");
		queryStr.append("WHERE {R.codeRoute}=?codeRoute");
		final FlexibleSearchQuery fsq = new FlexibleSearchQuery(queryStr);
		fsq.addQueryParameter("codeRoute", codeRoute);
		try
		{
		final RouteModel result = getFlexibleSearchService().searchUnique(fsq);
		return result;
		}
		catch (final ModelNotFoundException e)
		{
			LOG.info("Route not found");
		}
		return null;
	}

	@Override
	public List<RouteModel> findRoutesByAirportDeparture(final String nameAirport)
	{
		final StringBuilder queryStr = new StringBuilder();
		queryStr.append("SELECT {R.pk} ");
		queryStr.append("From {route as R ");
		queryStr.append("Join Airport as A on {R.airportDeparture}={A.pk} }");
		queryStr.append("Where {A.name}=?name ");
		final FlexibleSearchQuery fsq = new FlexibleSearchQuery(queryStr);
		fsq.addQueryParameter("name", nameAirport);
		final SearchResult<RouteModel> result = getFlexibleSearchService().search(fsq);
		return result.getResult();
	}


}
