package pi.transport.presentation.mbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import pi.transport.persistance.RouteSuggestion;
import pi.transport.persistance.Sector;
import pi.transport.services.RoutesSuggestionServiceLocal;



@ManagedBean(name="routeSMB")
@ViewScoped
public class RouteSuggestionBean {

	
	
	@EJB 
	private RoutesSuggestionServiceLocal routesuggestionServiceLocal;
	
	
	private List<RouteSuggestion> routes;
	private RouteSuggestion routeSuggestion;
	private Boolean formDisplayed;
	private List<Sector> sectors;

	
	
	public RouteSuggestionBean() {
		
	}
	public void doCancel()
	{
		formDisplayed=false;
	}
	public List<RouteSuggestion> getRoutes() {
		return routes;
	}
	public void setRoutes(List<RouteSuggestion> routes) {
		this.routes = routes;
	}
	public RouteSuggestion getRouteSuggestion() {
		return routeSuggestion;
	}
	public void setRouteSuggestion(RouteSuggestion routeSuggestion) {
		this.routeSuggestion = routeSuggestion;
	}
	public Boolean getFormDisplayed() {
		return formDisplayed;
	}
	public void setFormDisplayed(Boolean formDisplayed) {
		this.formDisplayed = formDisplayed;
	}
	public List<Sector> getSectors() {
		return sectors;
	}
	public void setSectors(List<Sector> sectors) {
		this.sectors = sectors;
	}
	
	@PostConstruct
	public void init(){
		routeSuggestion = new RouteSuggestion();
		routes = routesuggestionServiceLocal.findAllRoutesSuggestion();
		formDisplayed = false;
		sectors =routesuggestionServiceLocal.findAllSectors();
	}
	
	
	public void doSaveRoutes()
	{
		routesuggestionServiceLocal.saveRoute(routeSuggestion);
		routes=routesuggestionServiceLocal.findAllRoutesSuggestion();
		formDisplayed=false;
	}
	public void doNew()
	{
		formDisplayed=true;
		routeSuggestion=new RouteSuggestion();
	}
	public void doSelect(RouteSuggestion r)
	{
		formDisplayed=true;
		this.routeSuggestion=r;
	}
	public void doDeleteRoutes()
	{
		routesuggestionServiceLocal.removeProduct(routeSuggestion);
		routes=routesuggestionServiceLocal.findAllRoutesSuggestion();
		formDisplayed=false;
	}

}
