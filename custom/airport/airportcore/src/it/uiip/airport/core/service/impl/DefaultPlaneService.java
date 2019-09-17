package it.uiip.airport.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;

import it.uiip.airport.core.dao.PlaneDao;
import it.uiip.airport.core.model.PlaneModel;
import it.uiip.airport.core.service.PlaneService;

public class DefaultPlaneService implements PlaneService {
	private static final Logger LOG = Logger.getLogger(DefaultPlaneService.class);
	@Resource
	private PlaneDao planeDao;

	@Override
	public List<PlaneModel> getPlanesForCity(final String city) {
		LOG.info("Invoke method findPlanesByCity in DefaultPlaneService");
		return planeDao.findPlanesByCity(city);
	}

	/**
	 * @return the planeDao
	 */
	public PlaneDao getPlaneDao()
	{
		return planeDao;
	}

	@Required
	public void setPlaneDao(final PlaneDao planeDao)
	{
		this.planeDao = planeDao;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see it.uiip.airport.core.service.PlaneService#getAllPlanes()
	 */
	@Override
	public List<PlaneModel> getAllPlanes()
	{
		LOG.info("Invoke method findAllPlanes in DefaultPlaneService");
		return planeDao.findAllPlanes();
	}

}
