package it.uiip.airport.storefront.controllers.airport;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import it.uiip.airport.facades.AirLineFacade;
import it.uiip.airport.facades.PlaneFacade;
import it.uiip.airport.facades.data.AirLineData;
import it.uiip.airport.facades.data.PlaneData;
import it.uiip.airport.storefront.controllers.ControllerConstants;

@Controller
@RequestMapping(value = "/airport")
public class AirportController extends AbstractPageController {
	
	@Resource(name = "planeFacade")
	private PlaneFacade planeFacade;
	
	@Resource(name = "airLineFacade")
	private AirLineFacade airLineFacade;
	
	
	// -------------------------------------------------------------------------AIRLINE SEARCH
	
	@RequestMapping(value = "/searchAirLine/{codeAirLine}", method = RequestMethod.GET)
	public String searchAirLineByCodeAirLine(@PathVariable("codeAirLine")
	final String codeAirLine, final Model model, final HttpServletResponse response)
	{
		
		final AirLineData airLine = airLineFacade.getAirLineforCodeAirLine(codeAirLine.toUpperCase());
		model.addAttribute("airLine", airLine);
		model.addAttribute("codeAirLine", codeAirLine);
		return ControllerConstants.Views.Pages.Airport.AirportSearchAirLinePage;

	}
		
	@RequestMapping(value = "/searchAllAirLines", method = RequestMethod.GET)
	public String searchAllAirLines(final Model model, final HttpServletResponse response)
	{
		
		final List<AirLineData> airLines = airLineFacade.getAllAirLines();
		model.addAttribute("airLines", airLines);
		return ControllerConstants.Views.Pages.Airport.AirportSearchAllAirLinesPage;

	}
	
	// -------------------------------------------------------------------------PLANE SEARCH

	
	@RequestMapping(value = "/searchPlane/{codePlane}", method = RequestMethod.GET)
	public String searchPlaneByCodePlane(@PathVariable("codePlane")
	final String codePlane, final Model model, final HttpServletResponse response)
	{
		
		final PlaneData plane = planeFacade.getPlaneForCode(codePlane);
		model.addAttribute("plane", plane);
		return ControllerConstants.Views.Pages.Airport.AirportSearchPlanePage;

	}
	
	
	@RequestMapping(value = "/searchPlanesByState/{state}", method = RequestMethod.GET)
	public String searchPlanesByState(@PathVariable("state")
	final String state, final Model model, final HttpServletResponse response)
	{
		
		final List<PlaneData> planes = planeFacade.getPlanesForState(state);
		model.addAttribute("planes", planes);
		model.addAttribute("statePlane",state);
		return ControllerConstants.Views.Pages.Airport.AirportSearchPlanesByStatePage;

	}
	
	@RequestMapping(value = "/searchPlanesByCodeAirLine/{codeAirLine}", method = RequestMethod.GET)
	public String searchPlanesByCodeAirLine(@PathVariable("codeAirLine")
	final String codeAirLine, final Model model, final HttpServletResponse response)
	{
		
		final List<PlaneData> planes = planeFacade.getPlanesForCodeAirLine(codeAirLine);
		final AirLineData airLine = airLineFacade.getAirLineforCodeAirLine(codeAirLine);
		model.addAttribute("planes", planes);
		model.addAttribute("airLine", airLine);
		model.addAttribute("codeAirLine",codeAirLine);
		return ControllerConstants.Views.Pages.Airport.AirportSearchPlanesByCodeAirLinePage;

	}
		
	@RequestMapping(value = "/searchAllPlanes", method = RequestMethod.GET)
	public String searchAllPlanes(final Model model, final HttpServletResponse response)
	{
		
		final List<PlaneData> planes = planeFacade.getAllPlanes();
		model.addAttribute("planes", planes);
		return ControllerConstants.Views.Pages.Airport.AirportSearchAllPlanesPage;

	}
	

}
