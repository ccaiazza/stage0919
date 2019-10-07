package it.uiip.airport.core.dao.impl;

import java.util.List;

import de.hybris.platform.servicelayer.exceptions.ModelNotFoundException;
import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;
import de.hybris.platform.servicelayer.search.SearchResult;
import it.uiip.airport.core.dao.AirLineDao;
import it.uiip.airport.core.model.AirLineModel;

public class DefaultAirLineDao extends DefaultGenericDao<AirLineModel> implements AirLineDao {

	
	public DefaultAirLineDao(String typecode) {
		super(typecode);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public AirLineModel findAirLineByCodeAirLine(String codeAirLine) {
		final StringBuilder queryStr = new StringBuilder();
		queryStr.append("SELECT {A.pk} FROM {AirLine AS A} WHERE {A.codeAirLine} = ?codeAirLine");
		final FlexibleSearchQuery fsq = new FlexibleSearchQuery(queryStr);
		fsq.addQueryParameter("codeAirLine", codeAirLine);
		final AirLineModel result	= getFlexibleSearchService().searchUnique(fsq);
		return result;
	}


	@Override
	public List<AirLineModel> findAllAirLines() {
		final StringBuilder queryStr = new StringBuilder();
		queryStr.append("SELECT {A.pk} FROM {AirLine AS A}");
		final FlexibleSearchQuery fsq = new FlexibleSearchQuery(queryStr);
		final SearchResult<AirLineModel> result	= getFlexibleSearchService().search(fsq);
		return result.getResult();
		
	}

	

}
