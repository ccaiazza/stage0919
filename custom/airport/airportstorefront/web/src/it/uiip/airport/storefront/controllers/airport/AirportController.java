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

import it.uiip.airport.facades.AirportFacade;
import it.uiip.airport.facades.RouteFacade;
import it.uiip.airport.facades.data.AirportData;
import it.uiip.airport.facades.data.RouteData;
import it.uiip.airport.storefront.controllers.ControllerConstants;


/**
 * @author tminichiello
 *
 */
@Controller
@RequestMapping(value = "/airport")
public class AirportController extends AbstractPageController
{
	//__________________________________________ROUTE_____________________________________________

	@Resource(name = "routeFacade")
	private RouteFacade routeFacade;

	@RequestMapping(value = "/searchRouteByCodeRoute/{codeRoute}", method = RequestMethod.GET)
	public String searchRouteByCodeRoute(@PathVariable("codeRoute")
	final String codeRoute, final Model model, final HttpServletResponse response)
	{
		final RouteData route = routeFacade.getRouteForCodeRoute(codeRoute);
		model.addAttribute("route", route);
		return ControllerConstants.Views.Pages.Airport.RouteSearchPageC;
	}

	@RequestMapping(value = "/searchRouteByCodeRoute/", method = RequestMethod.GET)
	public String searchRouteByCodeRoute(final Model model, final HttpServletResponse response)
	{
		model.addAttribute("route", null);
		return ControllerConstants.Views.Pages.Airport.RouteSearchPageC;
	}


	@RequestMapping(value = "/searchAllRoutes", method = RequestMethod.GET)
	public String searchAllRoutes(final Model model, final HttpServletResponse response)
	{
		final List<RouteData> routes = routeFacade.getAllRoutes();
		model.addAttribute("routes", routes);
		model.addAttribute("tag", "All Routes");
		return ControllerConstants.Views.Pages.Airport.RouteSearchPage;
	}

	@RequestMapping(value = "/searchRoutesByAirportDeparture/{airportDeparture}", method = RequestMethod.GET)
	public String searchAllRoutes(@PathVariable("airportDeparture")
	final String airportDeparture, final Model model, final HttpServletResponse response)
	{
		final List<RouteData> routes = routeFacade.getRoutesForAirportDeparture(airportDeparture);
		model.addAttribute("routes", routes);
		model.addAttribute("tag", "From " + airportDeparture);
		return ControllerConstants.Views.Pages.Airport.RouteSearchPage;
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
		return ControllerConstants.Views.Pages.Airport.AirportSearchPageC;
	}

	@RequestMapping(value = "/searchAirportByCodeIata/", method = RequestMethod.GET)
	public String searchAirportsByCodeIata(final Model model, final HttpServletResponse response)
	{
		model.addAttribute("airport", null);
		return ControllerConstants.Views.Pages.Airport.AirportSearchPageC;
	}

	@RequestMapping(value = "/searchAirportByCountry/{country}", method = RequestMethod.GET)
	public String searchAirportsByCountry(@PathVariable("country")
	final String country, final Model model, final HttpServletResponse response)
	{
		final List<AirportData> airports = airportFacade.getAirportsForCountry(country);
		model.addAttribute("airports", airports);
		return ControllerConstants.Views.Pages.Airport.AirportSearchPage;
	}

	@RequestMapping(value = "/searchAllAirports", method = RequestMethod.GET)
	public String searchAllAirports(final Model model, final HttpServletResponse response)
	{
		final List<AirportData> airports = airportFacade.getAllAirports();
		model.addAttribute("airports", airports);
		return ControllerConstants.Views.Pages.Airport.AirportSearchPage;
	}
}
