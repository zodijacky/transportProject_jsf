package pi.transport.persistance;

import java.io.Serializable;

public class BusRoute implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Integer idBusRoute;
	Bus bus;
	Route route ;
	
	public BusRoute(){
		
	}
	
	
       public BusRoute(Bus bus, Route route) {
		
		this.bus = bus;
		this.route = route;
	}
	public BusRoute(Integer idBusRoute) {
		
		this.idBusRoute = idBusRoute;
		
	}


	public BusRoute(Integer idBusRoute,Bus bus,Route route) {
		
		this.idBusRoute = idBusRoute;
		
		this.bus =bus;
		this.route = route;
	}
		
  
	public Integer getIdBusRoute() {
		return idBusRoute;
	}

	public void setIdBusRoute(Integer idBusRoute) {
		this.idBusRoute = idBusRoute;
	}

	
	//@Column(name="idBus")
	
	public Bus getBus() {
		return bus;
	}
	public void setBus(Bus bus) {
		this.bus = bus;
	}
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route routes) {
		this.route = routes;
	}
	@Override
	public String toString() {
		return "BusRoute [idBusRoute=" + idBusRoute + 
		 ", bus=" + bus + ", route=" + route
				+ "]";
	}
	
	
	
	
	
	
	
	
	

}

