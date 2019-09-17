package it.uiip.airport.facades.populators;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import it.uiip.airport.core.model.PassengerModel;
import it.uiip.airport.facades.data.PassengerData;

public class PassengerPopulator implements Populator <PassengerModel,PassengerData>{

	@Override
	public void populate(PassengerModel source, PassengerData target) throws ConversionException {
		target.setName(source.getName());
		target.setCodeFiscal(source.getCodeFiscal());
		target.setBirthday(source.getBirthday());
		target.setAge(source.getAge());
		
	}

}
