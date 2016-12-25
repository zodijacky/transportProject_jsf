package pi.transport.persistance;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remove;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import pi.transport.services.TripService;
import pi.transport.services.TripServiceRemote;

@Entity
@Table(name="t_routesuggestion")
public class RouteSuggestion implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	

	private int id;
	private String name;
	private Sector sector;	
	private boolean available;
	
	public RouteSuggestion()
	{}
	public RouteSuggestion(int id, String name,Sector sector) {
		this.id = id;
		this.name = name;
	
		this.sector = sector;
		
	}
	public RouteSuggestion( String name,Sector sector) {		
		this.name = name;
		
		this.sector = sector;
		
	}

	
	@Id	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}



	
	
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn (name ="id_sector")
	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}
	
	
	
	
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
