
/**
 *
 */
package it.uiip.airport.storefront.controllers.airport;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import it.uiip.airport.facades.AirLineFacade;
import it.uiip.airport.facades.AirportFacade;
import it.uiip.airport.facades.PlaneFacade;
import it.uiip.airport.facades.RouteFacade;
import it.uiip.airport.facades.data.AirLineData;
import it.uiip.airport.facades.data.AirportData;
import it.uiip.airport.facades.data.PlaneData;
import it.uiip.airport.facades.data.RouteData;
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
	
	//__________________________________________ROUTE_____________________________________________

	@Resource(name = "routeFacade")
	private RouteFacade routeFacade;

	@RequestMapping(value = "/searchRouteByCodeRoute/{codeRoute}", method = RequestMethod.GET)
	public String searchRouteByCodeRoute(@PathVariable("codeRoute")
	final String codeRoute, final Model model, final HttpServletResponse response)
	{
		final RouteData route = routeFacade.getRouteForCodeRoute(codeRoute);
		model.addAttribute("route", route);
		model.addAttribute("codeRoute", codeRoute);
		return ControllerConstants.Views.Pages.Airport.RouteSearchPage;
	}

	@RequestMapping(value = "/searchAllRoutes", method = RequestMethod.GET)
	public String searchAllRoutes(final Model model, final HttpServletResponse response)
	{
		final List<RouteData> routes = routeFacade.getAllRoutes();
		model.addAttribute("routes", routes);
		model.addAttribute("tag", "All Routes");
		return ControllerConstants.Views.Pages.Airport.RouteSearchPageList;
	}

	@RequestMapping(value = "/searchRoutesByAirportDeparture/{airportDeparture}", method = RequestMethod.GET)
	public String searchAllRoutes(@PathVariable("airportDeparture")
	final String airportDeparture, final Model model, final HttpServletResponse response)
	{
		final List<RouteData> routes = routeFacade.getRoutesForAirportDeparture(airportDeparture);
		model.addAttribute("routes", routes);
		model.addAttribute("tag", "From " + airportDeparture);
		return ControllerConstants.Views.Pages.Airport.RouteSearchPageList;
	}

	//__________________________________________AIRPORT_____________________________________________

	@Resource(name = "airportFacade")
	private AirportFacade airportFacade;

	@RequestMapping(value = "/searchAirportByCodeIata/{codeIata}", method = RequestMethod.GET)
	public String searchAirportsByCodeIata(@PathVariable("codeIata")
	final String codeIata, final Model model, final HttpServletResponse response)
	{
		final AirportData airport = airportFacade.getAirportForCodeIATA(codeIata);
		model.addAttribute("airport", airport);
		model.addAttribute("codeIata", codeIata);
		return ControllerConstants.Views.Pages.Airport.AirportSearchPage;
	}

	@RequestMapping(value = "/searchAirportByCountry/{country}", method = RequestMethod.GET)
	public String searchAirportsByCountry(@PathVariable("country")
	final String country, final Model model, final HttpServletResponse response)
	{
		final List<AirportData> airports = airportFacade.getAirportsForCountry(country);
		model.addAttribute("airports", airports);
		model.addAttribute("tag", "By country" + country);
		return ControllerConstants.Views.Pages.Airport.AirportSearchPageList;
	}

	@RequestMapping(value = "/searchAllAirports", method = RequestMethod.GET)
	public String searchAllAirports(final Model model, final HttpServletResponse response)
	{
		final List<AirportData> airports = airportFacade.getAllAirports();
		model.addAttribute("airports", airports);
		model.addAttribute("tag", "All Airports");
		return ControllerConstants.Views.Pages.Airport.AirportSearchPageList;
	}
}
