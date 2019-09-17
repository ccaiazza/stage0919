/**
 *
 */
package it.uiip.airport.facades.populators;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

import it.uiip.airport.core.model.PlaneModel;
import it.uiip.airport.facades.data.PlaneData;


/**
 * @author soprasteria
 *
 */
public class PlaneReversePopulator implements Populator<PlaneData, PlaneModel>
{

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.platform.converters.Populator#populate(java.lang.Object, java.lang.Object)
	 */
	@Override
	public void populate(final PlaneData source, final PlaneModel target) throws ConversionException
	{
		target.setCodePlane(source.getCodePlane());
		target.setTypePlane(source.getTypePlane());
		target.setGoods(source.getGoods());
		target.setNumOfSits(source.getNumOfSits());
	}

}
