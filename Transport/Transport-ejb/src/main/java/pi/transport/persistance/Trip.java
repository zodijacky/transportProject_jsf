package pi.transport.persistance;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_trip")
public class Trip implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private Station departure;
	private Station arrival;	
	private Route route;
	
	
	private List<TripSchedule> schedules;
	
	@Id	@GeneratedValue(strategy=GenerationType.IDENTITY)

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name="id_dep")
	public Station getDeparture() {
		return departure;
	}
	public void setDeparture(Station departure) {
		this.departure = departure;
	}
	
	@ManyToOne
	@JoinColumn(name="id_arr")
	public Station getArrival() {
		return arrival;
	}
	public void setArrival(Station arrival) {
		this.arrival = arrival;
	}
	@ManyToOne
	@JoinColumn (name="id_route")
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
	}
	
	
	public Trip()
	{}
	public Trip(int id, Station departure, Station arrival,Route route) {
		this.id = id;
		this.departure = departure;
		this.arrival = arrival;
		this.route=route;
	}
	public Trip( Station departure, Station arrival,Route route) {
		this.departure = departure;
		this.arrival = arrival;
		this.route=route;
	}
	@Override
	public String toString() {
		return "Trip [id=" + id + ", departure=" + departure + ", arrival="
				+ arrival  + "]";
	}
	
	@OneToMany(mappedBy = "trip")
	public List<TripSchedule> getSchedules() {
		return schedules;
	}
	
	
	public void setSchedules(List<TripSchedule> schedules) {
		this.schedules = schedules;
	}
	
	
	
	
}
