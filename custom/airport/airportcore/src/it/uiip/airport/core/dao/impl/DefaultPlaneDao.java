package it.uiip.airport.core.dao.impl;

import java.util.List;
import java.util.Map;

import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;
import de.hybris.platform.servicelayer.internal.dao.SortParameters;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.SearchResult;
import it.uiip.airport.core.dao.PlaneDao;
import it.uiip.airport.core.model.PlaneModel;

public class DefaultPlaneDao extends DefaultGenericDao<PlaneModel> implements PlaneDao {

	public DefaultPlaneDao(String typecode) {
		super(typecode);
		
	}

	@Override
	public PlaneModel findPlaneByCode(String codePlane) {
		final StringBuilder queryStr = new StringBuilder();
		queryStr.append("SELECT {P.pk} FROM {Plane AS P} WHERE {P.codePlane} = ?codePlane ");
		final FlexibleSearchQuery fsq = new FlexibleSearchQuery(queryStr);
		fsq.addQueryParameter("codePlane", codePlane);
		final PlaneModel result	= getFlexibleSearchService().searchUnique(fsq);
		return result;
	}

	@Override
	public List<PlaneModel> findPlanesByState(String state) {
		final StringBuilder queryStr = new StringBuilder();
		queryStr.append("SELECT {P.pk} FROM {Plane AS P JOIN statePlaneEnum as S on {P.statePlane}={S.pk}} WHERE {S.code} = ?state");
		final FlexibleSearchQuery fsq = new FlexibleSearchQuery(queryStr);
		fsq.addQueryParameter("state", state);
		final SearchResult<PlaneModel> result	= getFlexibleSearchService().search(fsq);
		return result.getResult();
	}

	@Override
	public List<PlaneModel> findPlanesByCodeAirLine(String codeAirLine) {
		final StringBuilder queryStr = new StringBuilder();
		queryStr.append("SELECT {P.pk} FROM {Plane AS P JOIN AirLine as A ON {P.airLine}={A.pk}} WHERE {A.codeAirLine} = ?codeAirLine ");
		final FlexibleSearchQuery fsq = new FlexibleSearchQuery(queryStr);
		fsq.addQueryParameter("codeAirLine", codeAirLine);
		final SearchResult<PlaneModel> result	= getFlexibleSearchService().search(fsq);
		return result.getResult();
	}

	@Override
	public List<PlaneModel> findAllPlanes() {
		final StringBuilder queryStr = new StringBuilder();
		queryStr.append("SELECT {P.pk} FROM {Plane AS P}");
		final FlexibleSearchQuery fsq = new FlexibleSearchQuery(queryStr);
		final SearchResult<PlaneModel> result	= getFlexibleSearchService().search(fsq);
		return result.getResult();
	}




}
