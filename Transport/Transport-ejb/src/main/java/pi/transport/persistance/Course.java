package pi.transport.persistance;

import java.io.Serializable;
import java.util.Date;





import javax.persistence.*;

@Entity
@Table(name="t_course")
public class Course implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Date departure;
	private Date arrival;
	private Double cost;
	private Date duration;
	private Integer passengers;
	private Driver driver;
	public Course() {
		super();
	}
	public Course(Integer id, Date departure, Date arrival, Double cost,
			Date duration, Integer passengers, Driver driver) {
		super();
		this.id = id;
		this.departure = departure;
		this.arrival = arrival;
		this.cost = cost;
		this.duration = duration;
		this.passengers = passengers;
		this.driver = driver;
	}
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Temporal(TemporalType.TIME)
	public Date getDeparture() {
		return departure;
	}
	public void setDeparture(Date departure) {
		this.departure = departure;
	}
	
	@Temporal(TemporalType.TIME)
	public Date getArrival() {
		return arrival;
	}
	public void setArrival(Date arrival) {
		this.arrival = arrival;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	
	@Temporal(TemporalType.TIME)
	public Date getDuration() {
		return duration;
	}
	public void setDuration(Date duration) {
		this.duration = duration;
	}
	public Integer getPassengers() {
		return passengers;
	}
	public void setPassengers(Integer passengers) {
		this.passengers = passengers;
	}
	
	@ManyToOne
	@JoinColumn(name="id_driver")
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", departure=" + departure + ", arrival="
				+ arrival + ", cost=" + cost + ", duration=" + duration
				+ ", passengers=" + passengers + ", driver=" + driver + "]";
	}
	
	
	
	
	
	
	
}
