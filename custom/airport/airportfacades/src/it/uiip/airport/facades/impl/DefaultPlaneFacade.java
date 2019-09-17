/**
 *
 */
package it.uiip.airport.facades.impl;

import de.hybris.platform.servicelayer.dto.converter.Converter;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;

import it.uiip.airport.core.model.PlaneModel;
import it.uiip.airport.core.service.PlaneService;
import it.uiip.airport.facades.PlaneFacade;
import it.uiip.airport.facades.data.PlaneData;


/**
 * @author soprasteria
 *
 */
public class DefaultPlaneFacade implements PlaneFacade
{

	private PlaneService planeService;

	private Converter<PlaneModel, PlaneData> planeConverter;

	@Override
	public List<PlaneData> getAllPlane()
	{
		// XXX Auto-generated method stub
		return planeConverter.convertAll(planeService.getAllPlanes());

	}

	@Override
	public List<PlaneData> getPlanesForCity(final String city)
	{
		// XXX Auto-generated method stub
		return planeConverter.convertAll(planeService.getPlanesForCity(city));
	}

	/**
	 * @return the planeService
	 */
	public PlaneService getPlaneService()
	{
		return planeService;
	}

	@Required
	public void setPlaneService(final PlaneService planeService)
	{
		this.planeService = planeService;
	}

	/**
	 * @return the planeConverter
	 */
	public Converter<PlaneModel, PlaneData> getPlaneConverter()
	{
		return planeConverter;
	}

	@Required
	public void setPlaneConverter(final Converter<PlaneModel, PlaneData> planeConverter)
	{
		this.planeConverter = planeConverter;
	}





}
