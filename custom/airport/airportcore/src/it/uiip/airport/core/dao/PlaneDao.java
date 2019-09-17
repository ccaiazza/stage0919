/**
 *
 */
package it.uiip.airport.core.dao;

import de.hybris.platform.servicelayer.internal.dao.GenericDao;

import java.util.List;

import it.uiip.airport.core.model.PlaneModel;


/**
 * @author soprasteria
 *
 */
public interface PlaneDao extends GenericDao<PlaneModel> {

	public List<PlaneModel> findPlanesByCity(String city);

	public List<PlaneModel> findAllPlanes();
}
