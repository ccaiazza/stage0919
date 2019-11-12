/**
 *
 */
package it.uiip.airport.controllers;

import static it.uiip.airport.constants.AirportwebservicesConstants.CLIENT_CREDENTIAL_AUTHORIZATION_NAME;
import static it.uiip.airport.constants.AirportwebservicesConstants.PASSWORD_AUTHORIZATION_NAME;

import de.hybris.platform.webservicescommons.mapping.DataMapper;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Authorization;
import it.uiip.airport.data.AirportDataList;
import it.uiip.airport.dto.AirportDTO;
import it.uiip.airport.dto.AirportListDTO;
import it.uiip.airport.facades.data.AirportData;
import it.uiip.airport.facades.impl.DefaultAirportFacade;

/**
 * @author tminichiello
 *
 */

@RestController
@RequestMapping(value = "/dto")
public class AirportDTOController
{
	public static final String DEFAULT_FIELD_SET = "DEFAULT";

	@Resource(name = "dataMapper")
	private DataMapper dataMapper;

	@Resource(name = "defaultAirportFacade")
	private DefaultAirportFacade defaultAirportFacade;


	@RequestMapping(value = "/airport/{code}", method = RequestMethod.GET)
	@ApiOperation(authorizations ={ @Authorization(value = CLIENT_CREDENTIAL_AUTHORIZATION_NAME), @Authorization(value = PASSWORD_AUTHORIZATION_NAME) },
		value = "Method with path parameter returns Airport DTO", produces = "application/json,application/xml")
	public AirportDTO getAirportByCodeIATA(@ApiParam(value = "Airport code", required = true)
	@PathVariable("code")
	final String code)
	{
		final AirportData airportData = defaultAirportFacade.getAirportForCodeIATA(code);
		return dataMapper.map(airportData, AirportDTO.class, "BASIC");
	}

	@RequestMapping(value = "/airport", method = RequestMethod.GET)
	@ApiOperation(authorizations =
	{ @Authorization(value = CLIENT_CREDENTIAL_AUTHORIZATION_NAME),
			@Authorization(value = PASSWORD_AUTHORIZATION_NAME) }, value = "Method with path parameter returns Airport DTO", produces = "application/json,application/xml")
	public AirportDTO getAirportByCodeIATA()
	{
		final AirportData airportData = defaultAirportFacade.getAirportForCodeIATA("FCO");
		return dataMapper.map(airportData, AirportDTO.class, "BASIC");
	}

	@RequestMapping(value = "/allAirports", method = RequestMethod.GET)
	@ApiOperation(authorizations =
	{ @Authorization(value = CLIENT_CREDENTIAL_AUTHORIZATION_NAME),
			@Authorization(value = PASSWORD_AUTHORIZATION_NAME) }, value = "Method with path parameter returns Airport DTO", produces = "application/json,application/xml")
	public AirportListDTO getAllAirports()
	{
		final List<AirportData> airportsData = defaultAirportFacade.getAllAirports();
		final AirportDataList airportDataList = new AirportDataList();
		airportDataList.setList(airportsData);
		return dataMapper.map(airportDataList, AirportListDTO.class);
	}

	@RequestMapping(value = "/insertAirport", method = RequestMethod.POST)
	@ApiOperation(authorizations =
	{ @Authorization(value = CLIENT_CREDENTIAL_AUTHORIZATION_NAME),
			@Authorization(value = PASSWORD_AUTHORIZATION_NAME) }, value = "Method with path parameter returns Airport DTO", produces = "application/json,application/xml")
	public String addAirport(@RequestBody
	final AirportDTO airportDTO)
	{
		if (defaultAirportFacade.addAirport(dataMapper.map(airportDTO, AirportData.class)))
		{
			return "Airport Inserito";
		}
		else
		{
			return "Airport non inserito";
		}
	}

}