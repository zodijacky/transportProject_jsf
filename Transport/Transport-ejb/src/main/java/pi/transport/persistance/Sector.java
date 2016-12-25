package pi.transport.persistance;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="t_sector")
public class Sector implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int id;
	
	private String area;
	
	
	
	private List<Route> routes;
	private List<RouteSuggestion> routesSuggestion;
	
	public Sector ()
	{}
	
public Sector(int id, String area) {
		
		this.id = id;
		this.area = area;
		this.routes = new ArrayList<Route>();
	}
public Sector( String area) {	
		
		this.area = area;
		this.routes = new ArrayList<Route>();
	}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	public int getId() {
		return id;
	}
    public void setId(int id) {
		this.id = id;
	}
    
    @Column(unique=true)
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	@OneToMany(cascade=CascadeType.REMOVE,mappedBy="sector")
	public List<Route> getRoutes() {
		return routes;
	}

	public void setRoutes(List<Route> routes) {
		this.routes = routes;
	}

	@Override
	public String toString() {
		return "Sector [id=" + id + ", area=" + area + "]";
	}
	
	
	

	@OneToMany(cascade=CascadeType.REMOVE,mappedBy="sector")
	public List<RouteSuggestion> getRoutesSuggestion() {
		return routesSuggestion;
	}

	public void setRoutesSuggestion(List<RouteSuggestion> routesSuggestion) {
		this.routesSuggestion = routesSuggestion;
	}
	@PreRemove
	public void preRemove() {
		for (RouteSuggestion rs : routesSuggestion)
			rs.setSector(null);	
	
}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sector other = (Sector) obj;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		return true;
	}

	
	
}
