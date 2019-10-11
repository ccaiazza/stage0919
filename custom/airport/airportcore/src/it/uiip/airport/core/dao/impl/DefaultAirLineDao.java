package it.uiip.airport.core.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;

import de.hybris.platform.servicelayer.exceptions.ModelNotFoundException;
import de.hybris.platform.servicelayer.internal.dao.DefaultGenericDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.SearchResult;
import it.uiip.airport.core.dao.AirLineDao;
import it.uiip.airport.core.model.AirLineModel;

public class DefaultAirLineDao extends DefaultGenericDao<AirLineModel> implements AirLineDao {

	private static final Logger LOG= Logger.getLogger(DefaultAirLineDao.class);
	
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
		try {
		final AirLineModel result	= getFlexibleSearchService().searchUnique(fsq);
		return result;
		}catch(ModelNotFoundException e) {
			LOG.info("AirLine Not Found");
		}
		return null;
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
