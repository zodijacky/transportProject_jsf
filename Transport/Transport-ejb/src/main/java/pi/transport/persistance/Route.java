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
@Table(name="t_route")
public class Route implements Serializable{
	
	@Override
	public String toString() {
		try {
			return "Route [id=" + id + ", name=" + name + ", sector=" + sector.getArea()
					+ "]";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "Route [id=" + id + ", name=" + name ;
	}

	private int id;
	private String name;
	private Sector sector;	
	private List<Trip> trips= new ArrayList<Trip>();	
	private List<Bus> buses=new ArrayList<Bus>();
	private List<News> news=new ArrayList<News>();
	
	
	public Route()
	{}
	public Route(int id, String name,Sector sector) {
		this.id = id;
		this.name = name;
		this.buses = new ArrayList<>();
		this.sector = sector;
		this.trips = new ArrayList<>();
	}
	public Route( String name,Sector sector) {		
		this.name = name;
		this.buses = new ArrayList<>();
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


	@OneToMany (mappedBy = "route")
	
	public List<News> getNews() {
		return news;
	}
	public void setNews(List<News> news) {
		this.news = news;
	}
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn (name ="id_sector")
	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}
	
	
	@OneToMany (cascade=CascadeType.REMOVE,mappedBy="route")
	public List<Trip> getTrips() {			
		return trips;
	}

	public void setTrips(List<Trip> trips) {
		this.trips = trips;
	}
	
	@ManyToMany	(cascade=CascadeType.ALL)
	public List<Bus> getBuses() {
		return buses;
	}

	public void setBuses(List<Bus> buses) {
		this.buses = buses;
	}

	
	
	
	
	
	
	
	
	
	
	
	

}
