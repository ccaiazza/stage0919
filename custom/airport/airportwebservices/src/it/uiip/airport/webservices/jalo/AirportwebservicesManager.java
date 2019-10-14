/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package it.uiip.airport.webservices.jalo;

import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.extension.ExtensionManager;
import org.apache.log4j.Logger;
import it.uiip.airport.webservices.constants.AirportwebservicesConstants;

public class AirportwebservicesManager extends GeneratedAirportwebservicesManager
{
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger( AirportwebservicesManager.class.getName() );
	
	public static final AirportwebservicesManager getInstance()
	{
		final ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (AirportwebservicesManager) em.getExtension(AirportwebservicesConstants.EXTENSIONNAME);
	}
	
}
