package pi.transport.persistance;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Station {
	
	private int id;
	
	private String name;
	
	private long longitude;
	private long latitude;
	
	private List<Trip> departureTrips;
	private List<Trip> arrivalTrips;
	
	private String type;  // Metro ou Bus
	private boolean available;
	
	private StationChief stationChief;
	
	public Station() {
		departureTrips = new ArrayList<>();
		arrivalTrips = new ArrayList<>();
	}
	
	public Station(String name, long longitude, long latitude, String type, StationChief stationChief) {

		this.name = name;
		this.longitude = longitude;
		this.latitude = latitude;
		this.type = type;
		this.available = true;
	}
	
	public Station(String name, long longitude, long latitude, String type, boolean available) {

		this.name = name;
		this.longitude = longitude;
		this.latitude = latitude;
		this.type = type;
		this.available = available;
	}

	@Id
	@GeneratedValue
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

	public long getLongitude() {
		return longitude;
	}

	public void setLongitude(long longitude) {
		this.longitude = longitude;
	}

	public long getLatitude() {
		return latitude;
	}

	public void setLatitude(long latitude) {
		this.latitude = latitude;
	}

	@OneToMany (mappedBy = "departure")
	public List<Trip> getDepartureTrips() {
		return departureTrips;
	}

	public void setDepartureTrips(List<Trip> departureTrips) {
		this.departureTrips = departureTrips;
	}

	@OneToMany (mappedBy = "arrival")
	public List<Trip> getArrivalTrips() {
		return arrivalTrips;
	}

	public void setArrivalTrips(List<Trip> arrivalTrips) {
		this.arrivalTrips = arrivalTrips;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean getAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	@OneToOne
	@JoinColumn(name="id_chief")
	public StationChief getStationChief() {
		return stationChief;
	}

	public void setStationChief(StationChief stationChief) {
		this.stationChief = stationChief;
	}
	
	

}
