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
public class PlanePopulator implements Populator<PlaneModel, PlaneData>
{

	/*
	 * (non-Javadoc)
	 *
	 * @see de.hybris.platform.converters.Populator#populate(java.lang.Object, java.lang.Object)
	 */
	@Override
	public void populate(final PlaneModel source, final PlaneData target) throws ConversionException
	{
		target.setCodePlane(source.getCodePlane());
		target.setTypePlane(source.getTypePlane());
		target.setGoods(source.getGoods());
		target.setNumOfSits(source.getNumOfSits());

	}

}
